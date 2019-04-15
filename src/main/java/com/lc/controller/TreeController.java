package com.lc.controller;

import com.lc.entity.TreeEntity.MagTree;
import com.lc.service.NormalService;
import com.lc.service.TreeService;
import com.lc.service.impl.TreeServiceImpl;
import com.lc.util.TimeUtil;
import com.lc.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@Scope(value="prototype")
@RequestMapping("/treeController")
public class TreeController {

    @Autowired
    private TreeService treeService;

    @RequestMapping(value = "/dataTree")
    public List<MagTree> dataTree(String deptCode){
//        TreeServiceImpl tree = new TreeServiceImpl();
//        List<MagTree> list =tree.getTree(deptCode);
        List<MagTree> mag = treeService.find(deptCode);
        if(mag.size()>0){
            List<MagTree> list=treeService.findNext(deptCode);
            if(list.size()>0){//第一级有child
                mag.get(0).setState("closed");
                for(MagTree m1: list){
                    List<MagTree> result = this.dataTree(m1.getId());
                    if(result.size()>0){
                        m1.setChildren(result);
                        m1.setState("closed");
                    }else{
                        m1.setState("opened");
                        mag.get(0).setChildren(list);
                        return mag;
                    }
                }
                mag.get(0).setChildren(list);
                return mag;
            }else{//第一级无child
                mag.get(0).setState("opened");
                for(MagTree m1:list){
                    m1.setState("opened");
                }
                mag.get(0).setChildren(list);
                return mag;
            }
        }else{
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/dataTreeOnebyOne")
    public List<MagTree> dataTreeOnebyOne(String deptCode){
            List<MagTree>  menuList = treeService.find(deptCode);
            List<MagTree>  nextList = treeService.findNext(deptCode);
            List<MagTree>  resultList = new ArrayList<MagTree>();
        if (menuList.size()>0){
            for(MagTree m1:menuList){
                MagTree mag=new MagTree();
                mag.setId(m1.getId());
                mag.setText(m1.getText());
                if(nextList.size()>0){
                    mag.setState("closed");
                }else{
                    mag.setState("opened");
                }
                resultList.add(mag);
            }
            return resultList;
        }else{
            return null;
        }
    }

    @ResponseBody
    @RequestMapping("/selectNextTreeData")
    public List<MagTree> selectNextTreeData(String deptCode){
           List<MagTree> list = treeService.findNext(deptCode);
           if (list.size()>0){
           for(MagTree m1:list){
             List<MagTree> nextList = treeService.findNext(m1.getId());
             if(nextList.size()>0){
                m1.setState("closed");
             }
           }
            return list;
           }
           return null;
    }
}
