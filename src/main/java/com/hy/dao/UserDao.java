package com.hy.dao;


import com.hy.model.UserDomain;

import java.util.List;

/**
 * @author houyao
 */
public interface UserDao {


    int insert(UserDomain record);

    List<UserDomain> selectUsers();
}