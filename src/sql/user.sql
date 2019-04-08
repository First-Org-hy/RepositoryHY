CREATE DATABASE housecd;

DROP TABLE IF EXISTS housecd.t_user;
CREATE TABLE housecd.t_user(
  userId INT NOT NULL PRIMARY KEY auto_increment COMMENT '用户id',
  userName VARCHAR(255) NOT NULL COMMENT '姓名',
  PASSWORD VARCHAR(255) NOT NULL COMMENT '密码',
  phone VARCHAR(255) NOT null COMMENT '电话'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


DROP TABLE IF EXISTS housecd.app_info;


/*用户表*/
CREATE TABLE housecd.app_info(
  userId 	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT, /*用户id */
  appName 	  VARCHAR(255) COMMENT '微信名',
  appId 	  VARCHAR(255) NOT NULL COMMENT '微信id',
  appSecret   VARCHAR(255) NOT NULL COMMENT '微信秘钥',
  userName    VARCHAR(255) COMMENT '用户姓名',
  userIdCard  VARCHAR(255) COMMENT '用户身份证号',
  userPhone   VARCHAR(255) COMMENT '用户手机号',
  userType    CHAR(1) 	   COMMENT '用户类型：1系统管理员，2编辑，3楼盘商务，4经济公司，5经纪人，6普通用户',
  -- userComment VARCHAR(255) COMMENT '客户备注',
  housesId    VARCHAR(255) COMMENT '客户推荐楼盘',
  houseTypeId VARCHAR(50)  COMMENT '客户推荐户型',
  companyName VARCHAR(255) COMMENT '公司名称',
  parentId 	  VARCHAR(255) COMMENT '所属公司id',
  userState   CHAR(1) 	   COMMENT '经纪人(公司)状态:0.待审核，1.通过，2不通过',
  crtTime     TIMESTAMP    COMMENT '创建时间',
  updateTime  TIMESTAMP	   COMMENT '更新时间',
  dataState   CHAR(1)      COMMENT '数据状态:1.正常 2.逻辑删除'
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;


/*银行卡信息表 */
create table housecd.bank_info(
  cardId	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  userId	  VARCHAR(255) COMMENT '用户id',
  cardName	  VARCHAR(255) COMMENT '开卡姓名',
  cardPhone   VARCHAR(255) COMMENT '开卡电话',
  bank        VARCHAR(255) COMMENT '开卡银行',
  cardNum     VARCHAR(255) COMMENT '卡号',
  bankDeposit VARCHAR(255) COMMENT '开户行',
  crtTime 	  TIMESTAMP    COMMENT '创建时间',
  updateTime  TIMESTAMP	   COMMENT '更新时间',
  dataState   CHAR(1) 	   COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*推荐表*/
create table housecd.recommend(
  id 		 INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  housesId   VARCHAR(255) COMMENT '楼盘id， 针对楼盘推荐用户',
  userId     VARCHAR(255) COMMENT '经纪人id',
  userParentId VARCHAR(255) COMMENT '经纪公司Id',
  userName   VARCHAR(255) COMMENT '用户名',
  guestName  VARCHAR(255) COMMENT '客户名',
  guestPhone VARCHAR(255) COMMENT '客户手机',
  dealState	 CHAR(1)      COMMENT '成交状态:1.未成交 2.成交',
  -- dead_line	 VARCHAR(255) COMMENT '到期时间:30-crtTime',
  crtTime    TIMESTAMP    COMMENT '创建时间',
  updateTime TIMESTAMP	  COMMENT '更新时间',
  dataState  VARCHAR(50)  COMMENT '成交状态'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金表*/
create table housecd.brokerage(
  id 	 	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId      VARCHAR(255) COMMENT '经纪人id',
  userName    VARCHAR(255) COMMENT '用户名',
  guestId     VARCHAR(255) COMMENT '客户ID',
  guestName   VARCHAR(255) COMMENT '客户姓名',
  guestPhone  VARCHAR(255) COMMENT '客户手机',
  -- housesId    VARCHAR(255) COMMENT '楼盘Id',
  houseId     VARCHAR(255) COMMENT '房子ID',
  houseTypeId VARCHAR(255) COMMENT '房子类型ID',
  houseNum    VARCHAR(255) COMMENT '房子序号',
  brokerage   DECIMAL 	   COMMENT '佣金',
  brokerState CHAR(1) 	   COMMENT '佣金状态:1.待提取 2.已提取',
  ifRead 	  CHAR(1) 	   COMMENT '是否已读:1.未读 2.已读',
  crtTime 	  TIMESTAMP    COMMENT '创建时间',
  updateTime  TIMESTAMP	   COMMENT '更新时间',
  dataState   CHAR(1) 	   COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金参数表：（针对楼盘设置参数）*/
create table housecd.brokerage_param(
  id 		   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId     VARCHAR(255) COMMENT '楼盘id',
  userParentId VARCHAR(255) COMMENT '经纪公司id',
  userId	   VARCHAR(255) COMMENT '经纪人id',
  address	   VARCHAR(255) COMMENT '所属区域',
  brokerage	   DECIMAL 		COMMENT '佣金',
  brokerType   CHAR(1) 	    COMMENT '佣金类型：1.固定，2.比例',
  crtTime 	   timestamp 	COMMENT '创建时间',
  updateTime   TIMESTAMP	COMMENT '更新时间',
  dataState    CHAR(1) 		COMMENT 'data状态'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*销售表*/
create table housecd.sell(
  id 		   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userBsId 	   VARCHAR(255) COMMENT '楼盘商务id',
  userId  	   VARCHAR(255) COMMENT '经纪人id'	,
  userParentId VARCHAR(255) COMMENT '经纪公司id' ,
  guestId 	   VARCHAR(255) COMMENT '客户id',
  guestName    VARCHAR(255) COMMENT '客户姓名',
  guestIdCard  VARCHAR(50)  COMMENT '客户身份证号',
  guestAddress VARCHAR(255) COMMENT '客户地址',
  housesId     VARCHAR(255) COMMENT '楼盘id'	,
  houseTypeId  VARCHAR(255) COMMENT '户型id',
  houseNum	   VARCHAR(255) COMMENT '房间号',
  price	       DECIMAL   	COMMENT '单价',
  totalPrice   DECIMAL   	COMMENT '总价',
  picAddress   VARCHAR(255) COMMENT '图片地址',
  sellState    CHAR(1)   	COMMENT '图片地址：0 待审核，1 审核通过 ',
  dealState    CHAR(1)   	COMMENT '交易状态:1.看房，2.交定金 3. 交首付 4.银行房贷 5.购买完成 6. 未购买',
  brokerage	   DECIMAL      COMMENT '佣金',
  brokerState  CHAR(1)   	COMMENT '佣金状态',
  crtTime 	   TIMESTAMP 	COMMENT '创建时间',
  updateTime   TIMESTAMP 	COMMENT '更新时间',
  dataState    CHAR(1)   	COMMENT 'data状态'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*客户表*/
create table housecd.guest(
  guestId      INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  guestName    VARCHAR(255) COMMENT '客户姓名',
  guestIdCard  VARCHAR(50)  COMMENT '客户身份证号',
  guestPhone   VARCHAR(255) COMMENT '客户手机',
  housesId     VARCHAR(255) COMMENT '楼盘id',
  houseTypeId  VARCHAR(255) COMMENT '户型id',
  userParentId VARCHAR(255) COMMENT '经纪公司id',
  userId 	   VARCHAR(255) COMMENT '经纪人id',
  guestComment VARCHAR(255) COMMENT '客户备注',
  crtTime      TIMESTAMP    COMMENT '创建时间',
  updateTime   TIMESTAMP	COMMENT '更新时间',
  dataState    CHAR(1)      COMMENT 'data状态'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*区域表 */
create table housecd.area(
  areaId	 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  areaName	 VARCHAR(255) COMMENT '区域名称：',
  crtTime    TIMESTAMP    COMMENT '创建时间',
  updateTime TIMESTAMP	  COMMENT '更新时间',
  dataState  CHAR(1)      COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*广告表 */
create table housecd.advertising(
 adId 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 adName
 adAddress   /*广告位置  */
 adPicture
 startTime
 deadLine
 crtTime timestamp,
 dataState
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*资讯表 */
create table housecd.houses_info(
 Id 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 headline /*标题  */
 programa /*栏目  */
 pictureAddress
 lableId   /*标签  */
 content /*内容  */
 crtTime timestamp,
 dataState

)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*动态表 */
create table housecd.houses_state(
 Id 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 headline
 areaId
 housesId

 crtTime timestamp,
 dataState

)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*标签表 一个ID允许多个标签*/
create table housecd.lable(
 lableId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 lableContext
 crtTime timestamp,
 dataState
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 楼盘表 */
create table housecd.houses(
 housesId	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,  /*楼盘ID */
 housesName	  VARCHAR(255) COMMENT '楼盘Name',	
 housesSpclty VARCHAR(255) COMMENT '特点，使用标签表',
 houseState   VARCHAR(255) COMMENT '状态： 在建0,在售1,售罄2',
 pictureX     VARCHAR(255) COMMENT '效果图',
 pictureS     VARCHAR(255) COMMENT '实施图',
 pictureJ	  VARCHAR(255) COMMENT '交通图',
 mating       VARCHAR(255) COMMENT '配套设施：学校、公交、医院、银行、地铁、综合商场',
 houseTypeId  VARCHAR(255) COMMENT '户型ID，需要户型表',		
 areaZ 	      VARCHAR(255) COMMENT '占地面积',
 areaJ        VARCHAR(255) COMMENT '建筑面积',
 areaS 	  	  VARCHAR(255) COMMENT '商用面积',
 developers   VARCHAR(255) COMMENT '开发商',
 housesAddrss VARCHAR(255) COMMENT '楼盘地址',
 period  	  VARCHAR(255) COMMENT '产权年限',
 areaId       VARCHAR(255) COMMENT '区域ID： 所属区域',
 buildType    VARCHAR(255) COMMENT '建筑类型：',
 greenRate    VARCHAR(255) COMMENT '绿化率',
 companyW     VARCHAR(255) COMMENT '物业公司',
 openHouse    VARCHAR(255) COMMENT '最新开盘',
 deadLine     VARCHAR(255) COMMENT '交房时间',
 avgPrice     VARCHAR(255) COMMENT '均价',
 investor     VARCHAR(255) COMMENT '投资商',
 plotRatio    VARCHAR(255) COMMENT '容积率',
 familyNum    VARCHAR(255) COMMENT '户数',
 carportNum   VARCHAR(255) COMMENT '车位数',
 fitment      VARCHAR(255) COMMENT '装修情况',
 location     VARCHAR(255) COMMENT '定位  是什么？？？ 省市区',
 recommend    VARCHAR(255) COMMENT '推荐',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间',
 dataState    CHAR(1)      COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘特点 一个ID允许多个标签*/
create table housecd.houses_spclty(
 lableId	  VARCHAR(255) COMMENT '楼盘特点id',
 lableContext VARCHAR(255) COMMENT '楼盘特点内容',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间',
 dataState    CHAR(1)      COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘图片地址表 一个ID允许多个标签*/
create table housecd.houses_picture(
 lableId	  VARCHAR(255) COMMENT '图片地址id',
 lableContext VARCHAR(255) COMMENT '图片地址',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间',
 dataState    CHAR(1)      COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘配套设施表 一个ID允许多个标签*/
create table housecd.houses_picture(
 lableId	  VARCHAR(255) COMMENT '配套设置id',
 lableContext VARCHAR(255) COMMENT '图片地址',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间',
 dataState    CHAR(1)      COMMENT 'data状态'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



 /*户型表 */
 create table housecd.house_type(
 houseTypeId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
 )ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*新房表 */
create table housecd.house(
 houseId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
		  /*区域 */
 housesId /*楼盘 */
		  /*户型：楼盘下的户型 */
		  /*新房id： 添加新房： 10栋1单元1楼,10栋1单元1楼 */
		  /* */
  crtTime timestamp,
 dataState

) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 二手房表 */
create table housecd.second_hand_house(
 secondHouseId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseName  /*一期10栋A户型 */
 /*区域 */
 /*地址 */
 /*小区 */
 /*面积 */
 /*户型 varchar */
 /*朝向 */
 /*楼层 */
 /*装修：0毛坯、简装、精装 */
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

)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 租房表 */
create table housecd.renting_house(
 houseId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseName
 areaId
 address
 面积
 houseTypeId /* 户型*/
 朝向
 楼层
 /* 装修:毛坯、简装、精装 */
 /* 类型：住宅、公寓、商铺*/
 /* 类型： 整租、合租、*/
 /* 设施：床、电视、热水器、空调、宽带、洗衣机、冰箱、炉灶*/
 /* 特点：特点1、特点2  使用lable标签表*/
 /* 照片：1 2 3 */
 /* 房租：*元/月、季、半年、年  */
 /* 房源简介*/
 /* 联系电话*/
 /* 发布者*/
 
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;
 