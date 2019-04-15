package com.lc.service.impl;

import com.lc.dao.NormalDao;
import com.lc.service.NormalService;
import com.lc.util.TimeUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service(value = "nomalService")
@Transactional(readOnly = false)
public class NormalServiceImpl implements NormalService{

    @Autowired
    private NormalDao normalDao;

    private TransactionTemplate transactionTemplate;


    public String test() {
        return normalDao.test();
    }

    public void createPrice(Map<String,Object> map) {
        this.normalDao.createPrice(map);
    }

    public Map<String,Object> selectUserInfoByOpenId(@Param("open_id")String open_id){
        return this.normalDao.selectUserInfoByOpenId(open_id);
    }

    public List<Map<String, Object>> selectAllPrice() {
        return this.normalDao.selectAllPrice();
    }

    public void updatePricePriceName(String p_name, String p_id) {
        this.normalDao.updatePricePriceName(p_name,p_id);
    }

    public void updateServiceShiWu(Map<String,Object> map,@Param("p_name")String p_name,@Param("p_id")String p_id){
        this.normalDao.updatePricePriceName(p_name,p_id);
        System.out.println("z************************************************执行了");
        this.normalDao.createPrice(map);
        throw new RuntimeException("出现异常，不想插入和提交");
    }
//    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor = Exception.class)

    public Map<String,Object> getPriceByPid(String p_id){
        return normalDao.getPriceByPid(p_id);
    }

    public void createPriceOrderByOpenid(String openid,String p_id){
        TimeUtil t = new TimeUtil();
        Map<String,Object> map =new HashMap<String,Object>();
        map.put("p_id",p_id);
        map.put("open_id",openid);
        map.put("create_time",t.getSystemTimeFormart());
        map.put("order_state",0);
        normalDao.createPriceOrderByOpenid(map);
    }

    public Map<String,Object> selectUserJoinPriceOrder(@Param("open_id")String open_id){
        List<Map<String,Object>> list =normalDao.selectUserJoinPriceOrder(open_id);
        List<Map<String,Object>> list2 = normalDao.selectUserCreateByOpenid(open_id);
        List<Map<String,Object>> list3=normalDao.selectUserJoinPriceOrderOrderState1(open_id);

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userJoin",list);           //用户参与抽奖
        map.put("userCreate",list2);        //用户创建抽奖
        map.put("userWin",list3);           //用户 的中奖记录
        return map;
    }

    public List<Map<String,Object>> selectUserJoinPriceDetail(String open_id){ return normalDao.selectUserJoinPriceDetail(open_id); }

    public List<Map<String,Object>> selectUserCreateByOpenid(@Param("open_id")String open_id){return normalDao.selectUserCreateByOpenid(open_id); };

    public List<Map<String,Object>> selectUserWinPriceOrderDetail(@Param("open_id")String open_id){return normalDao.selectUserJoinPriceOrderOrderState1(open_id); };

    public int userJoinPriceYesOrNot(@Param("p_id")String p_id,@Param("open_id")String open_id){
        return normalDao.userJoinPriceYesOrNot(p_id,open_id);
    }

    public void updataPriceOrderState1ByPid(String p_id) {
        normalDao.updataPriceOrderState1ByPid(p_id);
    }

    public List<Map<String, Object>> selectRandmPriceOrderWin(Map<String, Object> map) {
        return normalDao.selectRandmPriceOrderWin(map);
    }

    public void updateUserWinPriceOrder(int p_order_id, int win_num) {
        normalDao.updateUserWinPriceOrder(p_order_id,win_num);
    }

    public List<Map<String, Object>> selectPriceWinPriceOrderDetail(String p_id) {
        return normalDao.selectPriceWinPriceOrderDetail(p_id);
    }

    @Override
    public void deletePriceOutOfTime(String time) {
        normalDao.deletePriceOutOfTime(time);
    }

    @Override
    public void delectPriceOrderNotInPrice() {
        normalDao.delectPriceOrderNotInPrice();
    }


}
