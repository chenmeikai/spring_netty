package com.kenhome.service.service.user.impl;

import com.kenhome.common.entity.account.User;
import com.kenhome.service.base.BaseMapper;
import com.kenhome.service.base.BaseServiceImpl;
import com.kenhome.service.mapper.account.UserMapper;
import com.kenhome.service.service.user.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\18 0018 22:18
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    protected BaseMapper<User> getBaseMapper() {
        return userMapper;
    }

    @Override
    public List<User> getFriendsByUserId(@Param("userId") String userId) {
        return userMapper.getFriendsByUserId(userId);
    }
}
