package com.lc.dao;

import com.lc.entity.Seckill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeckillDao {

    List<Seckill> queryAll(@Param("offset") int offset, @Param("limit") int limit);



}
