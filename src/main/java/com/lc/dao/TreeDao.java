package com.lc.dao;

import com.lc.entity.TreeEntity.MagTree;

import java.util.List;

public interface TreeDao {

    List<MagTree> find(String deptCode);

    List<MagTree> findNext(String deptCode);

}
