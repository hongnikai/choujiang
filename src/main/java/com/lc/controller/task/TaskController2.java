package com.lc.controller.task;


import com.lc.dao.TaskDao;
import com.lc.entity.RetObj;
import com.lc.entity.ScheduleJob;
import com.lc.service.TaskService;
import org.apache.log4j.Logger;
import org.quartz.CronScheduleBuilder;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@Scope(value="prototype")
@RequestMapping("task")
public class TaskController2 {
    // 日志记录器
    public final Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private TaskDao taskDao;

    @Autowired
    private TaskService taskService;


    @RequestMapping("taskList")
    public Object taskList(HttpServletRequest request) {
       List<ScheduleJob> taskList = taskDao.getAll();
        request.setAttribute("taskList", taskList);
          return "/taskList.jsp";
    }

    @ResponseBody
    @RequestMapping("taskListTest")
    public Object taskListTest(HttpServletRequest request) {
        List<ScheduleJob> taskList = taskDao.getAll();
        request.setAttribute("taskList", taskList);
        return taskList;
    }

    /*
    * 修改  cron表达式
    * */
    @RequestMapping("updateCron")
    @ResponseBody
    public RetObj updateCron(HttpServletRequest request, Long jobId, String cron) {
        RetObj retObj = new RetObj();
        retObj.setFlag(false);
        try {
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        } catch (Exception e) {
            retObj.setMsg("cron表达式有误，不能被解析！");
            return retObj;
        }
        try {
            taskService.updateCron(jobId, cron);
        } catch (SchedulerException e) {
            retObj.setMsg("cron更新失败！");
            return retObj;
        }
        retObj.setFlag(true);
        return retObj;
    }

    @RequestMapping("changeJobStatus")
    @ResponseBody
    public RetObj changeJobStatus(HttpServletRequest request, Long jobId, String cmd) {
        RetObj retObj = new RetObj();
        retObj.setFlag(false);
        try {
            taskService.changeStatus(jobId, cmd);
        } catch (SchedulerException e) {
            log.error(e.getMessage(), e);
            retObj.setMsg("任务状态改变失败！");
            return retObj;
        }
        retObj.setFlag(true);
        return retObj;
    }







}
