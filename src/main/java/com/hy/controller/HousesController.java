package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.service.HousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/** Created by yaohou on 18:16 2019/4/7. description: 楼盘控制类 */
@RestController
@RequestMapping(value = "houses")
public class HousesController {
  @Autowired private HousesService housesService;

  // 驻点商务楼盘查询: userId(驻点商务id)
  // 普通用户楼盘查询
  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),户型,装修,面积,开盘时间,售卖状况,特色
  //     包含:楼盘经纪人
  //     包含:楼盘动态
  //     包含:楼盘户型
  //     包含:楼盘配套设施
  //     包含:楼盘特点
  //     包含:楼盘图片
  //     包含:在售新房
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
