package com.lc.controller;

import com.lc.entity.TreeEntity.MagTree;
import com.lc.service.NormalService;
import com.lc.service.TreeService;
import com.lc.util.*;
import com.lc.util.myAnno.lc_rp;
import com.sun.javafx.collections.MappingChange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import net.sf.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *  @描述：普通的Controller
 *    ps： 用来处理日常琐碎
 ** @author LC
 *  创建时间：2018-7-2 下午23:30
 */
@RestController
@Scope(value="prototype")
@RequestMapping(value = "normalController")
@SuppressWarnings("all")
public class NormalController implements Runnable{

      Jedis jedis = new Jedis("39.106.19.130",6379);   //jedis

        @Autowired
        private NormalService normalService;

        @Autowired
        private TreeService treeService;

//    @Resource(name = "taskExecutor")
//    private TaskExecutor taskExecutor;

    public void run (){
        NormalController normalController = new NormalController();
    }

    /**
     * @描述：一次测试查询
     * @param
     * @return
     */
    @RequestMapping(value = "/myFirstTest",produces = "application/json;charset=utf-8")
    public Object myFirstTest(HttpServletRequest request, HttpServletResponse response)throws Exception{

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String nickname=normalService.test();
//        JSONObject json = JSONObject.fromObject(nickname);
//        System.out.println(json);
        Map<String,Object> map=new HashMap<String, Object>();
        map.put("key",nickname);

        Map<String,Object> map2=new HashMap<String, Object>();
        map2.put("p_id","155775116e594580813a2e05702f54dc");
        map2.put("man_num",3);
        List<Map<String,Object>> list = normalService.selectRandmPriceOrderWin(map2);

        return list;
    }

    /**
     * @描述：模拟微信登陆数据controller
     *
     *  @discription ： redis    and     session
     * @param
     * @return
     */
    @RequestMapping(value = "wx_login")
    public Object wx_login(HttpServletRequest request,HttpServletResponse response){

//            {"openid":"oorAYxKwiAmP-emkOYg9o9n1XWRE","nickname":"树。\uD83D\uDC44 \uD83C\uDF32\uD83C\uDF32\uD83C\uDF32",
//                "sex":1,"language":"zh_CN","city":"Panjin","province":"Liaoning","country":"CN",
//                "headimgurl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLhocHDJKRV6Nqdw3nW7DZ205C2ibwZRCudQLAibMnchtRbBViaVRFpEwBRGYj0GkyqgPZbNSrr6hBYg/132",
//                    "privilege":[]}
//              暂存openid  nickname sex headimgurl
        String openid = "oorAYxKwiAmP-emkOYg9o9n1XWRE";
        String nickname = "树2。\\uD83D\\uDC44 \\uD83C\\uDF32\\uD83C\\uDF32\\uD83C\\uDF32";
        String headimgurl = "http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLhocHDJKRV6Nqdw3nW7DZ205C2ibwZRCudQLAibMnchtRbBViaVRFpEwBRGYj0GkyqgPZbNSrr6hBYg/132";

        jedis.set("openid",openid);
        jedis.set("nickname",nickname);
        jedis.set("headimgurl",headimgurl);

        Thread t1 = new Thread();


        return "";
    }




    /**
     *  @描述：用户创建抽奖Controller  开发阶段用 ，上线引入定时器TimerTask
     *    详见：com.lc.controller.task.TaskController
     *    description：
     *                       @param p_name 本次抽奖名称
     *                       @param p_num 奖品数量
     *                       @param p_condition 抽奖状态
     *                       @param time 开奖时间
     ** @author LC
     *  创建时间：2018-7-2 下午23:30
     */
    @RequestMapping(value = "/userCreatePrize")
    public Object userCreatePrize(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam(value = "open_id",required = true)String open_id,
                                  @RequestParam(value="p_name",required=false,defaultValue="0")String p_name,
                                  @RequestParam(value="num",required=false,defaultValue="1")int p_num,
                                  @RequestParam(value = "manNum",required = false,defaultValue = "1")int man_num,
                                  @RequestParam(value="time",required=false,defaultValue="0")String time,
                                  @RequestParam(value = "file", required = false,defaultValue = "0") MultipartFile file,
                                  @RequestParam(value = "strDate",required = false,defaultValue = "2018-09-02 17:52:30")String strDate
                                ){
        UploadUtil u=new UploadUtil();
        TimeUtil t=new TimeUtil();
        String detail_path="/pictures/"+open_id;
        String pics=u.uploadFilesToPath(request, file, detail_path);

        Map<String,Object> map=new HashMap<String,Object>();
        map.put("p_id",lcRamdomUtil.getSixPlusTimeStampRamdomString());
        map.put("open_id",open_id);
        map.put("img",pics);
        map.put("p_name",p_name);
        map.put("p_num",p_num);
        map.put("man_num",man_num);
        map.put("p_condition",2);
        map.put("time",time);
        map.put("order_state",1);
        normalService.createPrice(map);
        System.out.println(open_id+p_name+p_num+man_num+time);
        return "haha";
    }

    /**
     *  @描述：获取用户信息
     *    description：从redis中取用户信息
     ** @author LC
     *  创建时间：2018-7-2 下午23:30
     */
     @RequestMapping(value = "getUserInfoFromRedis")
    public void getUserInfoFromRedis(HttpServletRequest request,HttpServletResponse response){

     }


    /**
     *  @描述：获取所有抽奖
     *    description：抽奖小程序index页面获取数据
     ** @author LC
     *  创建时间：2018-8-14 下午21:52
     */
    @RequestMapping(value = "getAllPrice")
    public Object getAllPrice(HttpServletResponse response,HttpServletRequest request){
        List<Map<String,Object>> list=normalService.selectAllPrice();
        return list;
    }

    /**
     *  @描述：根据p_id获取奖品详情 及中奖情况
     *    description：抽奖小程序index页面获取数据
     ** @author LC
     *  创建时间：2018-8-22 上午09:24
     */
    @RequestMapping(value = "getPriceByPid")
    public Object getPriceByPid(HttpServletRequest request,HttpServletResponse response,
                                @RequestParam(value = "p_id",required = true,defaultValue = "0")String p_id
                                ){
        Map<String,Object> map=normalService.getPriceByPid(p_id);

        System.out.println(
                "进入接口+++++++++++"+map.get("p_id")
        );
        return map;
    }

    /**
     *  @描述：用户参与抽奖
     *    description：抽奖小程序details页面创建抽奖申请订单
     ** @author LC
     *  创建时间：2018-8-26 上午09:24
     */
    @RequestMapping(value = "joinPriceByOpenid")
    public int joinPriceByOpenid(HttpServletRequest request,HttpServletResponse response,
                                    @RequestParam(value = "openid",required = true)String openid,
                                    @RequestParam(value = "p_id",required = true)String p_id
                                    ){
        String str = "返回正确数据："+p_id+"openid:"+openid;

        int num = normalService.userJoinPriceYesOrNot(p_id,openid);
        if(num==0){
            //查询是否参与过该奖品的抽奖
            //用户参与抽奖
            TimeUtil t =new TimeUtil();
            Map<String,Object> map = new HashMap<String,Object>();
            normalService.createPriceOrderByOpenid(openid,p_id);
            return 1;    //1   成功创建抽奖
        }else{
            //参与过不能继续
            return 0;   //0    以前参与过抽奖： 参与失败

        }
    }

    /**
     *  @描述：查询用户  参与的抽奖  and  创建的抽奖
     *    description：抽奖小程序my页面创建抽奖申请订单
     *
     *  @return 参与抽奖list 创建抽奖list
     ** @author LC
     *  create_time：2018-8-26 下午20:24
     */
    @RequestMapping(value = "selectUserJoinPriceOrder")
    public Object selectUserJoinPriceOrder(@RequestParam("open_id")String open_id){
            Map<String,Object> map = normalService.selectUserJoinPriceOrder(open_id);
            //返回用户参与的抽奖+用户创建的抽奖+中奖 集合
        return map;
    }

    /**
     *  @描述：查询用户  参与抽奖详情
     *  @return 参与抽奖list 奖品详情
     ** @author LC
     *  create_time：2018-8-26 下午20:24
     */
    @RequestMapping(value = "selectUserJoinPriceOrderDetail")
    public Object selectUserJoinPriceOrderDetail(@RequestParam("open_id")String open_id){
            List<Map<String,Object>> list = normalService.selectUserJoinPriceDetail(open_id);
        return list;
    }

    /**
     *  @描述：查询用户
     *  @return 创建抽奖详情
     ** @author LC
     *  create_time：2018-8-26 下午20:24
     */
    @RequestMapping(value = "selectUserCreatePriceOrderDetail")
    public Object selectUserCreatePriceOrderDetail(@RequestParam("open_id")String open_id){
            List<Map<String,Object>> list=normalService.selectUserCreateByOpenid(open_id);
        return list;
    }

    /**
     *  @描述：查询用户
     *  @return 中奖详情
     ** @author LC
     *  create_time：2018-8-26 下午20:24
     */
    @RequestMapping(value = "selectUserWinPriceOrderDetail")
    public Object selectUserWinPriceOrderDetail(@RequestParam("open_id")String open_id){
            List<Map<String,Object>> list=normalService.selectUserWinPriceOrderDetail(open_id);
        return list;
    }

    @RequestMapping("/selectPriceWinOrdersDetail")
    public Object selectPriceWinOrdersDetail(HttpServletResponse response,HttpServletRequest request,
                                             @RequestParam("p_id")String p_id
                                             ){
               List<Map<String,Object>> list= normalService.selectPriceWinPriceOrderDetail(p_id);
        return list;
    }

    @ResponseBody
    @RequestMapping("/testJdbc")
    public Object testJdbc(){
        String nickname=normalService.test();
        return nickname;
    }

    @ResponseBody
    @RequestMapping(value = "/getTree")
    public Object uploadFile(String deptCode){

        List<MagTree>  list = treeService.find("40101005110000001");
        return list;
    }

}
