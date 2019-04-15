package com.lc.dao;


import com.lc.entity.ScheduleJob;

import java.util.List;
import java.util.Map;


public interface TaskDao {


//	int deleteByPrimaryKey(Long jobId);
//
//	int insert(ScheduleJob record);
//
//	int insertSelective(ScheduleJob record);
//
	ScheduleJob selectByPrimaryKey(Long jobId);
//
//	int updateByPrimaryKeySelective(ScheduleJob record);
//
	int updateByPrimaryKeySelective(ScheduleJob record);

	List<ScheduleJob> getAll();

	List<Map<String,Object>> getAllTask();
}