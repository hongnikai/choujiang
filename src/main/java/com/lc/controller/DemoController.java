package com.lc.controller;

import com.lc.entity.GamePanel;
import com.lc.service.NormalService;
import com.lc.util.TimeUtil;
import com.lc.util.UploadUtil;
import com.lc.util.lcRamdomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JFrame;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;


@RestController
@Scope(value="prototype")
@RequestMapping("demoController")
@SuppressWarnings("all")
public class DemoController {

    Jedis jedis = new Jedis("39.106.19.130",6379);

    @Autowired
    private NormalService normalService;


    public static void main(String[] args) {

        List<Map<String,String>> list  = new ArrayList<>();
        Map<String,String> map = new HashMap<>();
        map.put("1","11");
        list.add(map);

        System.out.println(list);


    }


    @RequestMapping("tanke")
    public void tanke(HttpServletRequest request){

        JFrame jFrame = new JFrame("坦克大战");
        jFrame.setBounds(300, 300, 600, 400);

        Container container = jFrame.getContentPane();
        GamePanel gamePanel = new GamePanel();
        container.add(gamePanel);
        jFrame.addKeyListener(gamePanel);
        Thread thread = new Thread(gamePanel);
        thread.start();

        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * @描述：存储cookies  和混合 redis
     *
     *  @discription ： redis    and     session
     * @param
     * @return
     */
    @RequestMapping(value = "CookieSend")
    public Object cooksend(HttpServletRequest request, HttpServletResponse response){

        // java.util.Map<String,Object> map = new HashMap<String,Object>();
        int age = 11;
        String value = "wo_men_yi_qi_xue_mao_jiao";
        String name = "my_cookie";
//        Cookie cookie = new Cookie(name , value);
//        response.addCookie(cookie);
        this.createCookie(request,response,name,value);
        System.out.println("Cookie创建成功："+"res_message"+"小饼干er");
        Object result = (Object)this.createRedis(request,response,name,value);
        if(name.equals(result)){
            System.out.println("创建redis缓存："+"key为："+name+"*****redis****");
        }
//
//      Cookie cookie = new Cookie(name,value);
//       response.addCookie(cookie);
//        cookie.setMaxAge(10000);
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            //获取cookies 的值
            for (Cookie CC : cookies){
                String cookieValue = CC.getValue();
                System.out.println(cookieValue);
            }
        }

        return  "cookie_ending";
    }

    @SuppressWarnings("cookies")
    public void createCookie(HttpServletRequest request,HttpServletResponse response,
                             String name,String value){
        Cookie cookie = new Cookie(name , value);
        response.addCookie(cookie);
    }

    @SuppressWarnings("redis")
    public Object createRedis(HttpServletRequest request,HttpServletResponse respose,
                              String key,String value){
        jedis.set(key,value);
        //
        return key;
    }
    /**
     * @描述：事务练习
     *
     *  @discription ： redis    and     cookies
     * @param
     * @return
     */
    @RequestMapping("/insert")
    public Object insert() throws RuntimeException {

        Map<String,Object> map = new HashMap<String,Object>();

        lcRamdomUtil lc=new lcRamdomUtil();
        TimeUtil t = new TimeUtil();
        String p_id = lc.getRamdomString();
        map.put("p_id", p_id);
        map.put("au_id", 12131);
        map.put("p_name", "asdasd");
        map.put("p_num", 45456);
        map.put("p_condition", 456456);
        map.put("time",t.getSystemTimeFormart());
        normalService.updateServiceShiWu(map,"拉斯蒂外","155775116e594580813a2e05702f54dc");

   //     normalService.updatePricePriceName("是我没错","155775116e594580813a2e05702f54dc");
        return "controller_ending";
    }

    /**
     *  @描述：事务练习
     *    description：事务管理工作
     ** @author LC
     *  创建时间：2018-7-2 下午23:30
     */
    @RequestMapping(value = "/transactionalDemo")
    public Object transactionalDemo(HttpServletRequest request,HttpServletResponse response,
                                    @RequestParam(value="p_name",required=false,defaultValue="小小bbaac111")String p_name,
                                    @RequestParam(value="p_num",required=false,defaultValue="1")int p_num,
                                    @RequestParam(value="condition",required=false,defaultValue="0")int p_condition,
                                    @RequestParam(value = "au_id",required = false,defaultValue = "0")String au_id
    ){

        lcRamdomUtil lc=new lcRamdomUtil();
        UploadUtil u=new UploadUtil();
        TimeUtil t=new TimeUtil();

        Map<String,Object> map=new HashMap<String,Object>();

        map.put("p_id", lc.getRamdomString());
        map.put("au_id", au_id);
        map.put("p_name", p_name);
        map.put("p_num", p_num);
        map.put("p_condition", p_condition);
        map.put("time",t.getSystemTimeFormart());

        normalService.createPrice(map);
        List<Map<String,Object>> list=normalService.selectAllPrice();
        return list;
    }

    /**
     *  @描述：多线程练习
     *    description：事务管理工作
     ** @author LC
     *  创建时间：2018-7-2 下午23:30
     */
    @RequestMapping("run1")
    public Object run1(){

        int num = 1000;

        Thread t = new Thread();
        Thread t2 = new Thread();

        for (int i=0;i<=50;i++){
            try {
                t.currentThread().sleep(1000);
            } catch (InterruptedException e) {

            }
            System.out.println("开始睡觉"+i+"次");
            if (i>10){
                System.out.println("工作进行了一半儿");
                t.currentThread().interrupt();
                System.out.println("及时停止***");
            }
        }
        return "DDDDDDDDD";
    }






}
