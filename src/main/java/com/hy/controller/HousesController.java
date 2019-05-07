package com.hy.controller;

import com.hy.common.Lable;
import com.hy.model.HousesDomain;
import com.hy.model.HousesSpcltyDomain;
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
  @ResponseBody
  @GetMapping(value = "query")
  public List<HousesDomain> queryHouses(HousesDomain housesDomain) {
    return housesService.queryHouses(housesDomain);
  }

  // 楼盘特点查询，所有特点去重
  @ResponseBody
  @GetMapping("/querySpclty")
  public List<HousesSpcltyDomain> querySpclty() {
    return housesService.querySpclty();
  }
  // 普通用户 区域/价格/筛选 楼盘: areaId,总价,avgPrice(单价),排序,户型,装修,面积,开盘时间,售卖状况,特色
  //
  // areaId,sumPrice,avgPrice-maxPrice(单价),housesType,fitment,areaJ,crtTime,houseState,housesSpclty*/
  //     包含:楼盘经纪人
  //     包含:楼盘动态
  //     包含:楼盘户型
  //     包含:楼盘配套设施
  //     包含:楼盘特点
  //     包含:楼盘图片
  //     包含:在售新房
  @ResponseBody
  @GetMapping(value = "queryAll")
  public List<HousesDomain> queryAll(HousesDomain housesDomain) {
    return housesService.queryAll(housesDomain);
  }

  //新增楼盘信息
  @ResponseBody
  @PostMapping(value = "add")
  public Lable addHouses(HousesDomain housesDomain) {
    return housesService.addHouses(housesDomain);
  }

  //删除楼盘信息
  @ResponseBody
  @PostMapping(value = "delete")
  public Lable delHouses(HousesDomain housesDomain) {
    return housesService.delHouses(housesDomain);
  }

  //修改楼盘信息
  @ResponseBody
  @PostMapping(value = "update")
  public Lable updateHouses(HousesDomain housesDomain) {
    return housesService.updateHouses(housesDomain);
  }

}
