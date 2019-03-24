package com.hy.service.impl;

import com.hy.dao.AppDao;
import com.hy.model.AppDomain;
import com.hy.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yaohou on 22:14 2019/3/21.
 * description:
 */
@Service(value = "appService")
public class AppServiceImpl implements AppService{

    @Autowired
    private AppDao appDao;

    @Override
    public int addApp(AppDomain app) {
        return appDao.insert(app);
    }
}
