package com.lc.service.impl;

import com.lc.dao.TaskDao;
import com.lc.dao.TreeDao;
import com.lc.entity.TreeEntity.MagTree;
import com.lc.service.TreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "treeService")
@Transactional(readOnly = false)
public class TreeServiceImpl implements TreeService {

    @Autowired
    private TreeDao treeDao;

    @Override
    public List<MagTree> find(String deptCode) {
        return treeDao.find(deptCode);
    }

    @Override
    public List<MagTree> findNext(String deptCode) {
        return treeDao.findNext(deptCode);
    }

    public List<MagTree> getTree(String deptCode){
        List<MagTree> mag=treeDao.findNext(deptCode);
        return mag;
    }



}
