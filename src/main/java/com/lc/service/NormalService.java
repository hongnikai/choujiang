package com.lc.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface NormalService {

    public String test();

    void createPrice(Map<String,Object> map);

    Map<String,Object> selectUserInfoByOpenId(@Param("open_id")String open_id);

    List<Map<String,Object>> selectAllPrice();

    void updatePricePriceName(@Param("p_name")String p_name,@Param("p_id")String p_id);

    void updateServiceShiWu(Map<String,Object> map,@Param("p_name")String p_name,@Param("p_id")String p_id);

    Map<String,Object> getPriceByPid(@Param("p_id")String p_id);

    void createPriceOrderByOpenid(String openid,String p_id);

    Map<String,Object> selectUserJoinPriceOrder(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserJoinPriceDetail(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserCreateByOpenid(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserWinPriceOrderDetail(@Param("open_id")String open_id);

    int userJoinPriceYesOrNot(@Param("p_id")String p_id,@Param("open_id")String open_id);

    void updataPriceOrderState1ByPid(@Param("p_id")String p_id);

    List<Map<String,Object>> selectRandmPriceOrderWin(Map<String,Object> map);

    void updateUserWinPriceOrder(@Param("p_order_id")int p_order_id,@Param("win_num")int win_num);

    List<Map<String,Object>> selectPriceWinPriceOrderDetail(@Param("p_id")String p_id);

    void deletePriceOutOfTime(@Param("time")String time);

    void delectPriceOrderNotInPrice();
}
