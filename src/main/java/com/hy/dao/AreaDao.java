package com.hy.dao;

import com.hy.model.AreaDomain;

import java.util.List;

/**
 * Created by yaohou on 22:16 2019/3/21.
 * description:
 */
public interface AreaDao {
    List<AreaDomain> selectAreas();
}
