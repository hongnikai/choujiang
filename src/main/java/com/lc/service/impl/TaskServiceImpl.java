package com.lc.service.impl;

import com.lc.dao.NormalDao;
import com.lc.dao.TaskDao;
import com.lc.entity.ScheduleJob;
import com.lc.service.TaskService;
import com.lc.util.TimeUtil;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Map;


/**
 *  @描述：定时器   执行dao方法
 ** @author LC
 *  创建时间：2018-8-26 下午22:02
 */
@Service(value = "taskService")
@Transactional(readOnly = false)
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;


    @Override
    public void updateCron(Long jobId, String cron) throws SchedulerException {
        ScheduleJob job = getTaskById(jobId);
        if (job == null) {
            return;
        }
        job.setCronExpression(cron);
        if (ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            updateJobCron(job);
        }
        taskDao.updateByPrimaryKeySelective(job);

    }

    public ScheduleJob getTaskById(Long jobId) {
        return taskDao.selectByPrimaryKey(jobId);
    }

    @Override
    public void changeStatus(Long jobId, String cmd) throws SchedulerException {
        ScheduleJob job = getTaskById(jobId);
        if (job == null) {
            return;
        }
        if ("stop".equals(cmd)) {
            deleteJob(job);
            job.setJobStatus(ScheduleJob.STATUS_NOT_RUNNING);
        } else if ("start".equals(cmd)) {
            job.setJobStatus(ScheduleJob.STATUS_RUNNING);
            addJob(job);
        }
        taskDao.updateByPrimaryKeySelective(job);


    }

    /**
     * 更新job时间表达式
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void updateJobCron(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(scheduleJob.getCronExpression());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }

    /**
     * 删除一个job
     *
     * @param scheduleJob
     * @throws SchedulerException
     */
    public void deleteJob(ScheduleJob scheduleJob) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(scheduleJob.getJobName(), scheduleJob.getJobGroup());
        scheduler.deleteJob(jobKey);
    }

    /**
     * 添加任务
     *
     * @param job
     * @throws SchedulerException
     */
    public void addJob(ScheduleJob job) throws SchedulerException {
        if (job == null || !ScheduleJob.STATUS_RUNNING.equals(job.getJobStatus())) {
            return;
        }
    }








}