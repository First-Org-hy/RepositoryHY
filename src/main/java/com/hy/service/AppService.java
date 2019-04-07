package com.hy.service;

import com.hy.model.AppDomain;

/**
 * Created by yaohou on 22:04 2019/3/21.
 * description:
 */
public interface AppService {
    int addApp(AppDomain app);

    int delBrokerByUserId(AppDomain app);
}
