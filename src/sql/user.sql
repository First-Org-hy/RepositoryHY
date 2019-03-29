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
  appId VARCHAR(255) NOT NULL , /*微信id */
  appSecret VARCHAR(255) NOT NULL ,  /*微信秘钥 */
  userName							/*用户姓名 */
  userIdCard						/*用户身份证号 */
  userPhone VARCHAR(255),			/*用户手机号 */
  userType VARCHAR(255) NOT NULL,  /*1系统管理员，2编辑，3楼盘商务，4经济公司，5经纪人，6普通用户*/    
             /*userComment 客户备注*/     
  recommendHousesId		/*客户推荐楼盘 */
  recommendHouseTypeId	/*客户推荐户型 */  
  companyName			/*公司名称 （针对公司）*/
  parentId 				/*所属公司id */
  updateTime TIMESTAMP	/*更新时间 */
  crtTime TIMESTAMP ,	/*创建时间 */
  userState				/*经纪人(公司)状态：0.待审核 ，1.通过， 2不通过 */
  dataState				/*数据状态 1.正常 2.逻辑删除*/
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*推荐表*/
create table housecd.recommend(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
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
  housesBusinessId  /*楼盘商务id */
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
