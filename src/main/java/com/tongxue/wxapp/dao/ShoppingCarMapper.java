package com.tongxue.wxapp.dao;

import com.tongxue.wxapp.pojo.ShoppingCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {
    @Select("select a.shopId,a.openId,d.nickName ,a.sumPrice,a.createTime,a.updateTime,a.productid product_id,b.product_name productName,b.product_price productPrice,b.product_image pdImage, a.pdColorId pd_colorId,c.pd_colorName colorName,a.num,a.diopterName from " +
            "shoppingCar a left join product b on a.productid=b.product_id left join product_color c on a.productId=c.product_id and a.pdColorId=c.pd_colorId left join wxuser d on a.openid=d.openid")
    List<ShoppingCar> selectList();

    @Insert("insert into shoppingcar(openid,productid,pdColorId,diopterName,num,sumprice,createTime) values(#{openId},#{product_id},#{pd_colorId},#{diopterName},#{num},#{sumPrice},#{createTime})")
    int addShopping(ShoppingCar shoppingCar);

    @Update("update shoppingcar set wxuid=#{wxUId},productid=#{productId},num=#{num},sumprice=#{sumPrice},updateTime=#{updateTime} where shopid=#{shopId}")
    int updateShopping(ShoppingCar shoppingCar);

    @Delete("delete from shoppingcar where shopid=#{id}")
    int deleteShopping(Integer id);

    @Select("select shopId,num,sumPrice from shoppingCar where productid=#{product_id} and openid=#{openId} and pdColorId=#{pd_colorId} and diopterName=#{diopterName}")
    ShoppingCar selectShopping(@Param("product_id") Integer product_id, @Param("openId") String openId, @Param("pd_colorId") Integer pd_colorId, @Param("diopterName") String diopterName);

    @Update("update shoppingcar set num=#{num}, sumPrice=#{sumPrice},updateTime=#{updateTime} where shopid=#{shopId}")
    int updateShopOne(ShoppingCar shoppingCar);

    @Select("select a.shopId,a.openId,a.productid product_id,b.product_name productName,b.product_price productPrice,b.product_image pdImage,a.pdColorId pd_colorId,c.pd_colorName colorName,a.num,a.diopterName,a.sumPrice from " +
            "shoppingCar a left join product b on a.productid=b.product_id left join product_color c on a.productId=c.product_id and a.pdColorId=c.pd_colorId where a.openId=#{openId}")
    List<ShoppingCar> selectWxList(String openId);

    @Update("update shoppingcar set num=num+#{num} ,sumPrice=num*#{price} where shopId=#{shopId}")
    int update(@Param("num") Integer num, @Param("price") Double price, @Param("shopId") Integer shopId);

    @Select("select num from shoppingcar where shopId=#{shopId}")
    int selectNum(Integer shopId);

    @Delete("<script>" +
            "delete from shoppingcar where shopId in "+
            "<foreach item='ShoppingCar' collection='list' open='(' separator=',' close=')'> "+
            "#{ShoppingCar.shopId} "+
            "</foreach> "+
            "</script>")
    int deleteArrayShopping(@Param("list") List<ShoppingCar> list);

    @Select("<script>"+
            "select a.shopId,a.openId,a.productid product_id,b.product_price productPrice,a.pdColorId pd_colorId,a.num,a.diopterName,a.sumPrice from shoppingCar a left join product b on a.productId=b.product_id where shopId in"+
            "<foreach item='ShoppingCar' collection='list' open='(' separator=',' close=')'> "+
            "#{ShoppingCar.shopId} "+
            "</foreach> "+
            "</script>")
    List<ShoppingCar> selectArrayShopping(@Param("list") List<ShoppingCar> list);

    @Select("select shopId from shoppingcar where productid=#{product_id} and pdcolorId=#{pd_colorId} and diopterName=#{diopterName} and num=#{num} and openId=#{openId}")
    Integer selectShopId(@Param("product_id") Integer product_id,@Param("pd_colorId") Integer pd_colorId,@Param("diopterName") String diopterName ,@Param("num") Integer num,@Param("openId") String openId);


}
