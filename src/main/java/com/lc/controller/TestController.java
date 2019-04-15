package com.lc.controller;

import com.lc.dao.NormalDao;
import com.lc.service.NormalService;
import com.lc.tesseract_OCR.Tesseract_tess4j;
import com.lc.test.TaskTest;
import com.lc.util.TimeUtil;
import com.lc.util.UploadUtil;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

@Controller
@Scope(value="prototype")
@RequestMapping("testController")
public class TestController {

    Jedis jedis = new Jedis("188.131.178.20",6379);

    @Autowired
    private NormalService normalService;

    @Autowired
    private NormalDao normalDao;

    /**
     *  @描述：测试小程序上传文件Controller
     *    description：抽奖小程序logs 页面    只传一张
     ** @author LC
     *  创建时间：2018-8-22 上午09:24
     */
    @ResponseBody
    @RequestMapping(value = "uploadFileXCX")
    public Object uploadFileXCX(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam(value = "file", required = false,defaultValue = "0") MultipartFile[] file
    ){
        UploadUtil u=new UploadUtil();
        TimeUtil t=new TimeUtil();

       int au_id = 123123;   //模拟数据

        String detail_path="/pictures/";
        String pics="";
        for (int i = 0; i < file.length; i++) {
            String s=u.uploadFilesToPath(request, file[i], detail_path);
            if(s==null||s.equals("")||s.equals(" ")){
            }else{
                pics+=(","+s+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            }
        }
        System.out.println(pics);
        return pics;
    }

    @ResponseBody
    @RequestMapping(value = "uploadFile")
    public Object uploadFile(HttpServletRequest request, HttpServletResponse response,
                                @RequestParam(value = "file", required = false,defaultValue = "0") MultipartFile file,
                                @RequestParam(value = "p_name",required = false,defaultValue = "0")String p_name,
                                @RequestParam(value = "num",required = false,defaultValue = "0")int num,
                                @RequestParam(value = "manNum",required = false,defaultValue = "0")int manNum,
                                @RequestParam(value = "time",required = false,defaultValue = "0")String time
    ){
        UploadUtil u=new UploadUtil();
        TimeUtil t=new TimeUtil();
        System.out.println("进入上传图片接口===================="+"p_name:"+p_name+"num:"+num+"manNum:"+manNum+"time:"+time);

        String detail_path="choujiang/pictures/";
        String pics="";
            String s=u.uploadFilesToPath(request, file, detail_path);
            if(s==null||s.equals("")||s.equals(" ")){
            }else{
                pics+=(","+s+"++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }
        System.out.println(pics);
        return pics;
    }

    @ResponseBody
    @RequestMapping("/testMap")
    public Object testMap(HttpServletRequest request) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

//        String path="/server/test.png";
//        Tesseract_tess4j tesseract_tess4j=new Tesseract_tess4j();

        ClassLoader classLoader =TaskTest.class.getClassLoader();
        Class<?> loadClass = classLoader.loadClass("com.lc.tesseract_OCR.Tesseract_tess4j");
        Method method = loadClass.getMethod("main", String[].class);
        method.invoke(null, new Object[] { new String[] {} });

//        return tesseract_tess4j.textRecognizer(path);

        return "asd";
    }

    @RequestMapping("/testRedisSession")
    @ResponseBody
    public Object testRedisSession(HttpSession session,
                                   @RequestParam(value = "what") String what){
        return jedis.get("what");
    }

    @RequestMapping(value = "/getsession",produces = "text/html;charset=utf-8")
    @ResponseBody
    public String getSession(HttpSession session, HttpServletRequest req) {
        return session.getAttribute("what").toString()+"-----"+req.getServletContext().getRealPath("/");
    }






}
