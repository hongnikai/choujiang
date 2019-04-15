package com.lc.task;

import java.util.TimerTask;

import com.lc.util.TimeUtil;

public class MyTimerTask extends TimerTask{

    private long time;

    @Override
    public void run() {

    }

    public MyTimerTask(long time) {
        super();
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }



}
