package com.hy.service.impl;

import com.hy.dao.AreaDao;
import com.hy.model.AreaDomain;
import com.hy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yaohou on 16:32 2019/4/7.
 * description:
 */
@Service(value = "areaService")
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;


    @Override
    public List<AreaDomain> queryAreas() {
        return areaDao.selectAreas();
    }
}
