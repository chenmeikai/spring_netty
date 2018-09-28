package com.kenhome.service.service.user;

import com.kenhome.common.entity.account.User;
import com.kenhome.service.base.BaseService;

import java.util.List;

/**
 * @Author cmk
 * @Description
 * @Date 2018\9\18 0018 22:17
 */
public interface UserService extends BaseService<User> {

    List<User> getFriendsByUserId(String userId);

}
