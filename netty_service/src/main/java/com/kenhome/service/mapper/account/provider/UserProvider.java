package com.kenhome.service.mapper.account.provider;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: cmk
 * @Description:
 * @Date: Created in 9:21 2018/9/19 0019
 * @Modified By:
 */
public class UserProvider {

    public static String getFriendsByUserId(@Param("userId")String userId){

        SQL sql = new SQL();
        sql.SELECT("t1.*");
        sql.FROM("t_user t1,t_friend t2");
        sql.WHERE("t1.id=t2.friend_id");
        sql.WHERE("t2.user_id=#{userId}");
        return  sql.toString();

    }
}
