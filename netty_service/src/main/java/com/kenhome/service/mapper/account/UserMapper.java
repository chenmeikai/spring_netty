package com.kenhome.service.mapper.account;

import com.kenhome.common.entity.account.User;
import com.kenhome.service.base.BaseMapper;
import com.kenhome.service.mapper.account.provider.UserProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * MemberMapper
 *
 * @author cmk
 * @version 1.0
 * @create 2018-09-18 14:18:25
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    @Select("select * from t_user where username = #{username}")
    User getByUsername(@Param("username") String username);

    @SelectProvider(type = UserProvider.class, method = "getFriendsByUserId")
    List<User> getFriendsByUserId(@Param("userId") String userId);


}
