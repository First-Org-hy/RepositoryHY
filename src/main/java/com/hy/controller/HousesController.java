package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 18:16 2019/4/7. description: */
@RestController
@RequestMapping(value = "houses")
public class HousesController {
  @Autowired private HousesService housesService;

  @ResponseBody
  @GetMapping(value = "query")
  public List<HousesDomain> queryHouses(HousesDomain housesDomain) {

    return housesService.queryHouses(housesDomain);
  }

  @ResponseBody
  @PostMapping(value = "add")
  public Lable addHouses(HousesDomain housesDomain) {
    return housesService.addHouses(housesDomain);
  }
}
