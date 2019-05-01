CREATE DATABASE housecd;

DROP TABLE IF EXISTS housecd.t_user;
DROP TABLE IF EXISTS housecd.app_info;
DROP TABLE IF EXISTS housecd.bank_info;
DROP TABLE IF EXISTS housecd.recommend;
DROP TABLE IF EXISTS housecd.brokerage;
DROP TABLE IF EXISTS housecd.brokerage_param;
DROP TABLE IF EXISTS housecd.sell;
DROP TABLE IF EXISTS housecd.guest;
DROP TABLE IF EXISTS housecd.area;
DROP TABLE IF EXISTS housecd.advertising;
DROP TABLE IF EXISTS housecd.houses_info;
DROP TABLE IF EXISTS housecd.lable;
DROP TABLE IF EXISTS housecd.houses;
DROP TABLE IF EXISTS housecd.houses_user;
DROP TABLE IF EXISTS housecd.houses_spclty;
DROP TABLE IF EXISTS housecd.houses_picture;
DROP TABLE IF EXISTS housecd.houses_facilities;
DROP TABLE IF EXISTS housecd.house_type;
DROP TABLE IF EXISTS housecd.newHouse;
DROP TABLE IF EXISTS housecd.second_hand_house;
DROP TABLE IF EXISTS housecd.renting_house;
DROP TABLE IF EXISTS housecd.order_record;
DROP TABLE IF EXISTS housecd.house_dynamic;


CREATE TABLE housecd.t_user(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
  userName VARCHAR(255) NOT NULL COMMENT '姓名',
  PASSWORD VARCHAR(255) NOT NULL COMMENT '密码',
  phone VARCHAR(255) NOT NULL COMMENT '电话'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;


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
  updateTime  TIMESTAMP	   COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;


/*银行卡信息表 */
CREATE TABLE housecd.bank_info(
  cardId	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  userId	  VARCHAR(255) COMMENT '用户id',
  cardName	  VARCHAR(255) COMMENT '开卡姓名',
  cardPhone   VARCHAR(255) COMMENT '开卡电话',
  bank        VARCHAR(255) COMMENT '开卡银行',
  cardNum     VARCHAR(255) COMMENT '卡号',
  bankDeposit VARCHAR(255) COMMENT '开户行',
  crtTime 	  TIMESTAMP    COMMENT '创建时间',
  updateTime  TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*推荐表*/
CREATE TABLE housecd.recommend(
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
  updateTime TIMESTAMP	  COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金表*/
CREATE TABLE housecd.brokerage(
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
  updateTime  TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*佣金参数表：（针对楼盘设置参数）*/
CREATE TABLE housecd.brokerage_param(
  id 		   INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId     VARCHAR(255) COMMENT '楼盘id',
  userParentId VARCHAR(255) COMMENT '经纪公司id',
  userId	   VARCHAR(255) COMMENT '经纪人id',
  address	   VARCHAR(255) COMMENT '所属区域',
  brokerage	   DECIMAL 		COMMENT '佣金',
  brokerType   CHAR(1) 	    COMMENT '佣金类型：1.固定，2.比例',
  crtTime 	   TIMESTAMP 	COMMENT '创建时间',
  updateTime   TIMESTAMP	COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*销售表*/
CREATE TABLE housecd.sell(
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
  updateTime   TIMESTAMP 	COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*客户表*/
CREATE TABLE housecd.guest(
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
  updateTime   TIMESTAMP	COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*区域表 */
CREATE TABLE housecd.area(
  areaId	 INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  areaName	 VARCHAR(255) COMMENT '区域名称',
  crtTime    TIMESTAMP    COMMENT '创建时间',
  updateTime TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*广告表 */
CREATE TABLE housecd.advertising(
 adId 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 adName      VARCHAR(255) COMMENT '广告名称',
 adAddress   VARCHAR(255) COMMENT '广告位置',/*广告位置  */
 adPicture   VARCHAR(255) COMMENT '广告图片',
 startTime   VARCHAR(255) COMMENT '开始时间',
 deadLine    VARCHAR(255) COMMENT '标题名称',
 crtTime     TIMESTAMP    COMMENT '创建时间',
 updateTime  TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*资讯表 */
CREATE TABLE housecd.houses_info(
 Id 	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 headline    VARCHAR(255) COMMENT '标题',
 programId   VARCHAR(255) COMMENT '栏目Id',
 programName VARCHAR(255) COMMENT '栏目名称',
 picAddress  VARCHAR(255) COMMENT '标题图片地址',
 lableId     VARCHAR(255) COMMENT '标签',
 content     VARCHAR(4000) COMMENT '内容',
 crtTime     TIMESTAMP     COMMENT '创建时间',
 updateTime  TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



/*标签表 一个ID允许多个标签*/
CREATE TABLE housecd.lable(
 lableId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 lableContext    VARCHAR(4000) COMMENT '标签内容',
 crtTime         TIMESTAMP     COMMENT '创建时间',
 updateTime      TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 楼盘表 */
CREATE TABLE housecd.houses(
 housesId	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
 updateTime   TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘商务关系表*/
CREATE TABLE houses_user(
housesId     VARCHAR(255)  COMMENT '楼盘ID',
userId       VARCHAR(255)  COMMENT '驻点商务ID',
crtTime      TIMESTAMP     COMMENT '创建时间',
updateTime   TIMESTAMP	   COMMENT '更新时间',
updateId  	 VARCHAR(255)  COMMENT '更新人id'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;


/*楼盘特点 一个ID允许多个标签*/
CREATE TABLE housecd.houses_spclty(
 lableId	  VARCHAR(255) COMMENT '楼盘特点id',
 lableContext VARCHAR(255) COMMENT '楼盘特点内容',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘图片地址表 一个ID允许多个标签*/
CREATE TABLE housecd.houses_picture(
 lableId	  VARCHAR(255) COMMENT '图片地址id',
 lableContext VARCHAR(255) COMMENT '图片地址',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘配套设施表 一个ID允许多个标签*/
CREATE TABLE housecd.houses_facilities(
 lableId	  VARCHAR(255) COMMENT '配套设置id',
 lableContext VARCHAR(255) COMMENT '图片地址',
 crtTime      TIMESTAMP    COMMENT '创建时间',
 updateTime   TIMESTAMP	   COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



 /*户型表 */
 CREATE TABLE housecd.house_type(
 houseTypeId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseTypeName   VARCHAR(255) COMMENT '户型类型名称',
 houseTypeSpci   VARCHAR(255) COMMENT '户型类型特点', /*特点，使用标签表 */
 houseTypePic    VARCHAR(255) COMMENT '户型类型图片', /*特点，使用标签表 */
 houseFTTB       VARCHAR(255) COMMENT '楼栋',
 houseTypeNum    VARCHAR(255) COMMENT '居室数目',
 houseSize       VARCHAR(255) COMMENT '建筑面积',
 houseAvmPrice   VARCHAR(255) COMMENT '参考均价',
 houseTolPrice   VARCHAR(255) COMMENT '参考总价',
 houseType       VARCHAR(255) COMMENT '分类：住宅',
 crtTime         TIMESTAMP	  COMMENT '创建时间',
 updateTime      TIMESTAMP	  COMMENT '更新时间'
 )ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*新房表 */
CREATE TABLE housecd.newHouse(
 Id	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseArea	  VARCHAR(255) COMMENT '区域',
 housesId     VARCHAR(255) COMMENT '楼盘ID',
 houseTypeId	VARCHAR(255) COMMENT '户型：楼盘下的户型',
 houseId	    VARCHAR(255) COMMENT '新房id： 添加新房： 10栋1单元1楼,10栋1单元1楼',
 crtTime      TIMESTAMP	  COMMENT '创建时间',
 updateTime   TIMESTAMP	  COMMENT '更新时间'
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 二手房表 */
CREATE TABLE housecd.second_hand_house(
 secondHouseId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseName      VARCHAR(255) COMMENT '二手房名称：一期10栋A户型',
 houseArea      VARCHAR(255) COMMENT '区域',	/*区域 */
 houseAddress   VARCHAR(255) COMMENT '地址',	/*地址 */
 housePlot      VARCHAR(255) COMMENT '小区', /*小区 */
 houseSize      VARCHAR(255) COMMENT '房屋面积',   /*面积 */
 houseTypeId    VARCHAR(255) COMMENT '户型',/*户型 varchar */
 houseBound     VARCHAR(255) COMMENT '朝向',/*朝向 */
 houseFloor     VARCHAR(255) COMMENT '楼层',/*楼层 */
 houseFixType   VARCHAR(255) COMMENT '装修类型：0毛坯、1简装、2精装 ',
 houseType      VARCHAR(255) COMMENT '户型：0住宅、1公寓、2商铺 ',
 houseStyleId   VARCHAR(255) COMMENT '特点，使用标签表',
 housePicAddress VARCHAR(255) COMMENT '照片地址',
 houseAvmPrice  VARCHAR(255) COMMENT '单价',
 houseTolPrice  VARCHAR(255) COMMENT '总价',
 houseSou       VARCHAR(255) COMMENT '房源介绍',/*房源介绍 */
 housePulId     VARCHAR(255) COMMENT '发布者',/*发布者 */
 relPhone       VARCHAR(255) COMMENT '联系电话',
 houseState     VARCHAR(255) COMMENT '是否上线：0上线 1下线 ',/*是否上线：上线 下线 */
 sortWay        VARCHAR(255) COMMENT '排序方式：0，默认排序  1，从高到低  2，从低到高',
 crtTime        TIMESTAMP	  COMMENT '创建时间',
 updateTime     TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/* 租房表 */
CREATE TABLE housecd.renting_house(
 rentHouseId	  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 houseName      VARCHAR(255) COMMENT '租房名称：一期10栋A户型',
 houseArea      VARCHAR(255) COMMENT '区域',	/*区域 */
 houseAddress   VARCHAR(255) COMMENT '地址',	/*地址 */
 housePlot      VARCHAR(255) COMMENT '小区', /*小区 */
 houseSize      VARCHAR(255) COMMENT '房屋面积',   /*面积 */
 houseTypeId    VARCHAR(255) COMMENT '户型',/*户型 varchar */
 houseBound     VARCHAR(255) COMMENT '朝向',/*朝向 */
 houseFloor     VARCHAR(255) COMMENT '楼层',/*楼层 */
 houseFixType   VARCHAR(255) COMMENT '装修类型：0毛坯、1简装、2精装 ',
 rentType       VARCHAR(255) COMMENT '租房类型：0整租 1合租 ',
 houseType      VARCHAR(255) COMMENT '类型：0住宅、1公寓、2商铺',
 houseStyleId   VARCHAR(255) COMMENT '特点，使用标签表',
 housePicAddress VARCHAR(255) COMMENT '照片地址',
 houseMonPrice   VARCHAR(255) COMMENT '房租租金 月',
 houseYearPrice  VARCHAR(255) COMMENT '房租租金 年',
 houseSou       VARCHAR(255) COMMENT '房源介绍',/*房源介绍 */
 houseState     VARCHAR(255) COMMENT '是否已被租：0是 1否',
 housePulId     VARCHAR(255) COMMENT '发布者',/*发布者 */
 relPhone       VARCHAR(255) COMMENT '联系电话',
 sortWay        VARCHAR(255) COMMENT '排序方式：0，默认排序  1，从高到低  2，从低到高',
 crtTime        TIMESTAMP	  COMMENT '创建时间',
 updateTime     TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;


/*预约看房表*/
CREATE TABLE order_record(
orderId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
orderUsId      VARCHAR(255) COMMENT '预约人ID',
orderName      VARCHAR(255) COMMENT '预约人姓名',
orderTel       VARCHAR(255) COMMENT '预约人电话',
orderHouseId   VARCHAR(255) COMMENT '预约楼盘Id',
orderHouseName VARCHAR(255) COMMENT '预约楼盘名称',
crtTime        TIMESTAMP	  COMMENT '创建时间',
updateTime     TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*楼盘动态表*/
CREATE TABLE house_dynamic(
dynamicId	INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
houseId        VARCHAR(255) COMMENT '楼盘Id',
userId         VARCHAR(255) COMMENT '发布人Id',
content        VARCHAR(255) COMMENT '内容',
crtTime        TIMESTAMP	  COMMENT '创建时间',
updateTime     TIMESTAMP	  COMMENT '更新时间'
)ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;