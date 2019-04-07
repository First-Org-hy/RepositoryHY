package com.hy.dao;

import com.hy.model.AppDomain;

import java.util.List;

/**
 * Created by yaohou on 22:16 2019/3/21.
 * description:
 */
public interface AppDao {
    int insert(AppDomain appDomain);

    List<AppDomain> selectApps();

    int delBrokerByUserId(AppDomain app);
}
