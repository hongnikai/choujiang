package com.lc.controller;

import com.lc.entity.Seckill;
import com.lc.service.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.net.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.HttpURLConnection;


/**
 *  @描述：测试专用Controller
 ** @author LC
 *  创建时间：2018-3-9 下午15:38
 */
@Controller
@Scope(value="prototype")
@RequestMapping("/seckill")
public class SeckillController {



    @Autowired
    private SeckillService seckillService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        //list.jsp + model = ModelAndView
        //获取列表页

        List<Seckill> list = seckillService.getSeckillList();
        model.addAttribute("list", list);

        return "/WEB-INF/jsp/list.jsp";
    }


    @RequestMapping(value = "/listJson", method = RequestMethod.GET)
    @ResponseBody
    public List<Seckill>  listJson(Model model) {
        List<Seckill> list = seckillService.getSeckillList();
        System.out.println("shucbu");
        return list;
    }





}
