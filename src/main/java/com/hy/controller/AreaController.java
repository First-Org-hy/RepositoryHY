package com.hy.controller;

import com.hy.model.AreaDomain;
import com.hy.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yaohou on 16:36 2019/4/7.
 * description:
 */
@RestController
@RequestMapping(value = "area")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @ResponseBody
    @GetMapping(value = "query")
    public List<AreaDomain> queryAreas(){
        return areaService.queryAreas();
    }
}
