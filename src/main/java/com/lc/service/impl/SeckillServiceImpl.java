package com.lc.service.impl;


import com.lc.dao.SeckillDao;
import com.lc.entity.Seckill;
import com.lc.service.SeckillService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Created by wchb7 on 16-5-14.
 */

@Service
public class SeckillServiceImpl implements SeckillService {

    private Log LOG = LogFactory.getLog(this.getClass());

    @Autowired
    private SeckillDao seckillDao;

    public List<Seckill> getSeckillList() {
        return seckillDao.queryAll(0, 1000);
    }


}
