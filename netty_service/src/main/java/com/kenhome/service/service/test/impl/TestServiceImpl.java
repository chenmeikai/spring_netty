package com.kenhome.service.service.test.impl;

import com.kenhome.common.constant.account.SexEnum;
import com.kenhome.common.entity.account.User;
import com.kenhome.common.utils.code.MD5;
import com.kenhome.service.mapper.account.UserMapper;
import com.kenhome.service.service.test.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\16 0016 23:07
 */

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String test(String username) {

        User user = userMapper.getByUsername(username);
        System.out.println(user.getSex().getName());
        return user.getSex().getName();
    }

    @Override
    public String save(String username,String password,String phone) {
        User user =new User();
        user.init();
        user.setUsername(username);
        password = MD5.getIntance().start(password);
        user.setPassword(password);
        user.setPhone(phone);
        user.setSex(SexEnum.BOY);
        int code = userMapper.insert(user);
        return  code+"";
    }
}
