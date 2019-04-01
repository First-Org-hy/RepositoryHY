CREATE DATABASE housecd;

drop table housecd.t_user
CREATE TABLE housecd.t_user(
  userId INT NOT NULL PRIMARY KEY auto_increment COMMENT '用户id',
  userName VARCHAR(255) NOT NULL COMMENT '姓名',
  PASSWORD VARCHAR(255) NOT NULL COMMENT '密码',
  phone VARCHAR(255) NOT null COMMENT '电话'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
select * from housecd.t_user;

/*用户表*/
CREATE TABLE housecd.app_info(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, /*用户id */
  appName VARCHAR(255),			/*微信名 */
  appId   VARCHAR(255) NOT NULL , /*微信id */
  appSecret VARCHAR(255) NOT NULL ,  /*微信秘钥 */
  userName							/*用户姓名 */
  userIdCard						/*用户身份证号 */
  userPhone VARCHAR(255),			/*用户手机号 */
  userType VARCHAR(255) NOT NULL,  /*1系统管理员，2编辑，3楼盘商务，4经济公司，5经纪人，6普通用户*/    
             
  recommendHousesId		/*客户推荐楼盘 */
  recommendHouseTypeId	/*客户推荐户型 */  
  companyName			/*公司名称 （针对公司）*/
  parentId 				/*所属公司id */
  updateTime TIMESTAMP	/*更新时间 */
  crtTime TIMESTAMP ,	/*创建时间 */
  userState				/*经纪人(公司)状态：0.待审核 ，1.通过， 2不通过 */
  dataState				/*数据状态 1.正常 2.逻辑删除*/
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



/*银行卡信息表 */
create table housecd.bank_info(
	id
	userId
	cardName
	cardPhone
	bank
	cardNum
	bankDeposit
	crtTime TIMESTAMP ,	/*创建时间 */ 
	dataState				/*数据状态 1.正常 2.逻辑删除*/

)

/*推荐表*/
create table housecd.recommend(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId      /*楼盘id， 针对楼盘推荐用户 */
  userId       /*经济人id */
  userName		
  guestName
  guestPhone 
  dealState		/*成交状态 1.未成交 2.成交 */
  dead_line		/*到期时间 30 */
  crtTime timestamp,
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金表*/
create table housecd.brokerage(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId	/*经济人id */
  userName
  guestId   /*客户id */
  guestName
  guestPhone 
  housesId
  houseTypeId
  houseNum
  brokerage   	/*佣金 */
  brokerageState  /*佣金状态 1.待提取 2.已提取*/
  ifRead 
  crtTime timestamp comment '',
  dataState
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金参数表*/
create table housecd.brokerage_param(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId    /*楼盘id */
  userParentId   /*经纪公司id */
  userId		/*经纪人id */
  address		/*所属区域 */
  brokerage		/*佣金 */
  brokerageType /*佣金类型：1.固定，2.比例 */
  crtTime timestamp comment '',
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*销售表*/
create table housecd.sell(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesBusinessId  /*楼盘商务id ,来自app_info表 */
  userId		/*经纪人id */
  userParentId  /*经纪公司id */  
  guestId		/*客户id */
  guestName
  guestIdCard
  guestAddress  
  housesId		/*楼盘id */
  houseTypeId   /*户型id */ 
  houseNum		/*房间号 */	
  price			/*单价 */
  totalPrice    /*总价 */ 
  pictureAddress /*图片地址 */  
  sellState     /*销售操作：0 待审核，1 审核通过 */
  
  dealState     /*交易状态 1.看房，2.交定金 3. 交首付 4.银行房贷 5.购买完成 6. 未购买  */  
  brokerage		/*佣金 */
  brokerageState  /*佣金状态 */
  crtTime timestamp,
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*客户表*/
create table housecd.guest(
	guestId INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	guestName
	guestIdCard
	guestPhone
	housesId
	houseTypeId
	userParentId
	userId
	guestComment	
	crtTime timestamp,
	dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*区域变 */ 
create table housecd.area(
  areaId
  areaName
  crtTime timestamp,
  dataState
)

/*广告表 */
create table housecd.advertising(
 adId 
 adName
 adAddress   /*广告位置  */
 adPicture
 startTime
 deadLine
 crtTime timestamp,
 dataState
 
)

/*资讯表 */
create table housecd.houses_info(
 Id 
 headline /*标题  */
 programa /*栏目  */
 pictureAddress
 lableId   /*标签  */
 content /*内容  */
 crtTime timestamp,
 dataState
 
)

/*动态表 */
create table housecd.houses_state(
 Id 
 headline
 areaId
 housesId

 crtTime timestamp,
 dataState
 
)

/*标签表 一个ID允许多个标签*/  
create table housecd.lable(
 lableId
 lableContext
 crtTime timestamp,
 dataState
)

/* 楼盘表 */
create table housecd.houses(
 housesId			/*楼盘ID */
 housesName			/*楼盘Name */
 housesSpecialty  /*特点，使用标签表 */
 houseState /*状态： 在建0,在售1,售罄2 */
 pictureX  /*效果图 */
 pictureS   /*实施图 */
 pictureJ	/*交通图 */
 /*配套设施：学校、公交、医院、银行、地铁、综合商场 */
 /*户型ID，需要户型表 */
 /*占地面积 */
 /*建筑面积 */
 /*商用面积 */
 /*开发商 */
 /*楼盘地址 */
 /*产权年限 */
 /*区域ID： 所属区域 */
 /*建筑类型： */
 /*绿化率 */
 /*物业公司 */
 /*最新开盘 */
 /*交房时间 */
 /*均价 */
 /*投资商 */
 /*容积率 */
 /*户数 */
 /*车位数 */
 /*装修情况 */
 /*定位  是什么？？？ 省市区 */
 /*推荐 */

 crtTime timestamp,
 dataState
 

)

 /*户型表 */
 create table housecd.house_type(
 houseTypeId
 houseTypeName
 houseTypeSpecialty   /*特点，使用标签表 */
 houseTypePicture
 /* 楼栋*/
 /* 居室*/
 /* 建筑面积*/
 /* 参考均价*/
 /* 参考总价*/
 /* 分类：住宅*/
 crtTime timestamp,
 dataState 
 )
 
/*新房表 */
create table housecd.house(
 houseId
		  /*区域 */
 housesId /*楼盘 */
		  /*户型：楼盘下的户型 */
		  /*新房id： 添加新房： 10栋1单元1楼,10栋1单元1楼 */
		  /* */
  crtTime timestamp,
 dataState 

) 
 
/* 二手房表 */ 
create table housecd.second_hand_house(
 secondHouseId
 houseName  /*一期10栋A户型 */
 /*区域 */
 /*地址 */
 /*小区 */
 /*面积 */
 /*户型 varchar */
 /*朝向 */
 /*楼层 */
 /*装修：毛坯、简装、精装 */
 /*户型：住宅、公寓、商铺 */
 /*特点：使用标签表  */
 /*照片地址 */
 /*单价 */
 /*总价 */
 /*房源介绍 */
 /*发布者 */
 /*是否上线：上线 下线 */
 
  crtTime timestamp,
 dataState 
 
)

/**/
 
 
 
 
 
 

 
 
 

























