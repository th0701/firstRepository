package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.Order_item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface Order_itemMapper {
    @Insert("<script>" +
            "insert into order_item(order_id,product_id,pd_colorId,diopterName,product_price,num,sumPrice,creteTime,item_ser,item_deli,item_sendMoney,item_remark) values"+
            "<foreach item='Order_item' collection='list' separator=',' index='index'> "+
            "(#{Order_item.order_id},#{Order_item.product_id},#{Order_item.pd_colorId},#{Order_item.diopterName},#{Order_item.product_price},#{Order_item.num},#{Order_item.sumPrice},#{Order_item.creteTime},#{Order_item.item_ser},#{Order_item.item_deli},#{Order_item.item_sendMoney},#{Order_item.item_remark})"+
            "</foreach> "+
            "</script>")
    int addOrder_item(List<Order_item> list);

    @Select("select b.product_name,b.product_image,a.product_price,a.num,a.diopterName,c.pd_colorName,a.sumPrice,a.item_ser,a.item_deli,a.item_remark,a.item_sendMoney from order_item a left join product b on a.product_id=b.product_id left join product_color c on a.product_id=c.product_id and a.pd_colorId=c.pd_colorId where order_id=#{id}")
    List<Order_item> selectList(Integer id);

    @Insert("insert into order_item(order_id,product_id,pd_colorId,diopterName,product_price,num,sumPrice,creteTime,item_ser,item_deli,item_sendMoney) " +
            "values(#{order_id},#{product_id},#{pd_colorId},#{diopterName},#{product_price},#{num},#{sumPrice},#{creteTime},#{item_ser},#{item_deli},#{item_sendMoney})")
    int addOneOrder_item(Order_item order_item);

    @Select("select product_id,pd_colorId,diopterName,num from order_item where order_id=(select order_id from `order` where order_no=#{order_no})")
    List<Order_item> selectOrderItems(String order_no);
    //删除订单明细
    @Delete("delete from order_item where order_id=#{id}")
    int deleteOrderItem(Integer id);
}
