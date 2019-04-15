package com.lc.service;

import com.lc.entity.ScheduleJob;
import org.quartz.SchedulerException;

import java.util.Map;

public interface TaskService {

    public void updateCron(Long jobId, String cron) throws SchedulerException;

    public ScheduleJob getTaskById(Long jobId);

    public void changeStatus(Long jobId, String cmd) throws SchedulerException;
}
