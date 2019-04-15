package com.lc.service.impl;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TaskTest {
	public final Logger log = Logger.getLogger(this.getClass());
 
	public void run() {
		for (int i = 0; i < 1; i++) {
			log.debug(i+"执行抽奖逻辑" + (new Date()));
		}

	}

}
