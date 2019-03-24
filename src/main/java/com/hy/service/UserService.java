package com.hy.service;

import com.github.pagehelper.PageInfo;
import com.hy.model.UserDomain;

/**
 *
 * @author yaohou
 * @date 21:50 2018/4/19
 * description:
 */
public interface UserService {

    int addUser(UserDomain user);

    PageInfo<UserDomain> findAllUser(int pageNum, int pageSize);
}
