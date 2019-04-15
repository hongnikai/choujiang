package com.lc.dao;

import org.apache.ibatis.annotations.Param;
import com.lc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface NormalDao {

    String test();

    void createPrice(Map<String,Object> map);

    Map<String,Object> selectUserInfoByOpenId(@Param("open_id")String open_id);

    List<Map<String,Object>> selectAllPrice();

    void updatePricePriceName(@Param("p_name")String p_name,@Param("p_id")String p_id);

    Map<String,Object> getPriceByPid(@Param("p_id")String p_id);

    void createPriceOrderByOpenid(Map<String,Object> map);

    List<Map<String,Object>> selectUserJoinPriceOrder(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserCreateByOpenid(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserJoinPriceOrderOrderState1(@Param("open_id")String open_id);

    List<Map<String,Object>> selectUserJoinPriceDetail(@Param("open_id")String open_id);

    int userJoinPriceYesOrNot(@Param("p_id")String p_id,@Param("open_id")String open_id);

    void updataPriceOrderState1ByPid(@Param("p_id")String p_id);

    List<Map<String,Object>> selectRandmPriceOrderWin(Map<String,Object> map);

    void updateUserWinPriceOrder(@Param("p_order_id")int p_order_id,@Param("win_num")int win_num);

    List<Map<String,Object>> selectPriceWinPriceOrderDetail(@Param("p_id")String p_id);

    void deletePriceOutOfTime(@Param("time")String time);

    void delectPriceOrderNotInPrice();
}
