package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Diopter;
import com.tongxue.wxapp.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into `order`(order_no,openId,order_creteTime,product_ser,order_payment,`check`,order_deli,order_sendMoney,statu) " +
            "values(#{order_no},#{openId},#{order_creteTime},#{product_ser},#{order_payment},#{check},#{order_deli},#{order_sendMoney},#{statu})")
    @Options(useGeneratedKeys=true, keyProperty="order_id", keyColumn="order_id")
    void addOrder(Order order);
    //删除订单
    @Delete("delete from `order` where order_id=#{id}")
    int deleteOrder(Integer id);

    @Select("select order_id,order_payment,order_no,addr_id,statu from `order` where order_id=#{id}")
    Order selectOrder(Integer id);

    @Select("select a.order_id from `order` a where a.check=#{check} and a.statu=1")
    Integer selectCheck(String check);

    @Select("<script>" +
            "select a.order_id, a.order_no, a.openId,b.nickName,a.order_creteTime,a.order_payment,a.order_remark from `order` a " +
            "left join wxuser b on a.openid=b.openid and a.statu=1"+
            "<where>" +
            "<if test='order_no !=null' >" +
            "and a.order_no like concat('%', #{order_no}, '%')"+
            "</if>"+
            "<if test='order_creteTime !=null' >" +
            "and a.order_creteTime=#{order_creteTime} "+
            "</if>"+
            "</where>" +
            "</script>")
    List<Order> selectOneList(@Param("order_no") String order_no, @Param("order_creteTime")Date order_creteTime);

    @Select("select order_id,order_no,order_creteTime,order_payment,order_remark,statu from `order` where openId=#{openId}")
    List<Order> selectWxList(String openId);

    @Select("select order_id,order_no,order_creteTime,order_payment,statu,order_remark from `order` where openId=#{openId} and statu=#{statu}")
    List<Order> selectWxOneList(@Param("openId") String openId,@Param("statu") Integer statu);

    //统一下单后该订单绑定地址、添加客户备注
    @Update("update `order` set addr_id=#{addr_id},order_remark=#{order_remark} where order_no=#{order_no}")
    int updateOrderstatu(Order order);

    //支付完成后修改订单状态、支付时间
    @Update("update `order` set statu=2,order_payTime=#{order_payTime} where order_no=#{order_no}")
    int updatePayTime(Order order);

    //取消订单修改订单状态
    @Update("update `order` set statu=0 where order_no=#{order_no}")
    int updateStatu(String order_no);


}
