package com.lc.service;

import com.lc.entity.TreeEntity.MagTree;

import java.util.List;

public interface TreeService {

    List<MagTree> find(String deptCode);

    List<MagTree> findNext(String deptCode);
}
