package com.example.redis.dao;

import com.example.redis.entity.RedPackage;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


/**
 * Created by lw on 2020/3/13
 *
 * @author lw
 */
@Repository
public interface RedPackageDao {

    @Insert("insert into red_package (package_id,package_name,package_value,package_status,valid_time,exprie_time,create_time) " +
            " values " +
            "(#{redPackage.packageId},#{redPackage.packageName},#{redPackage.packageValue}" +
            ",#{redPackage.packageStatus},#{redPackage.validTime},#{redPackage.exprieTime},#{redPackage.createTime})")
    Integer grantRedPackage(@Param("redPackage") RedPackage redPackage);


    @Update("<script>" +
            "update red_package\n" +
            "    <set >\n" +
            "      <if test=\"redPackage.packageName != null\" >\n" +
            "        package_name = #{redPackage.packageName},\n" +
            "      </if>\n" +
            "      <if test=\"redPackage.packageValue != null\" >\n" +
            "        package_value = #{redPackage.packageValue},\n" +
            "      </if>\n" +
            "      <if test=\"redPackage.packageStatus != null\" >\n" +
            "        package_status = #{redPackage.packageStatus},\n" +
            "      </if>\n" +
            "      <if test=\"redPackage.validTime != null\" >\n" +
            "        valid_time = #{redPackage.validTime},\n" +
            "      </if>\n" +
            "    </set>\n" +
            "    where package_id = #{redPackage.packageId}" +
            "</script>")
    Integer updateRedPackage(@Param("redPackage") RedPackage redPackage);


    @Select("select package_id as packageId," +
            " package_name as packageName," +
            " package_value as packageValue," +
            " package_status as packageStatus," +
            " valid_time as validTime," +
            " exprie_time as exprieTime," +
            " create_time as createTime," +
            " update_time as updateTime" +
            " from red_package where package_id=#{packageId}")
    RedPackage getRedPackage(@Param("packageId") String packageId);
}
