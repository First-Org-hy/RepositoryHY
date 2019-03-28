CREATE DATABASE housecd;

drop table housecd.t_user
CREATE TABLE housecd.t_user(
  userId INT NOT NULL PRIMARY KEY auto_increment COMMENT '�û�id',
  userName VARCHAR(255) NOT NULL COMMENT '����',
  PASSWORD VARCHAR(255) NOT NULL COMMENT '����',
  phone VARCHAR(255) NOT null COMMENT '�绰'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
select * from housecd.t_user;

/*�û���*/
CREATE TABLE housecd.app_info(
  userId INT NOT NULL PRIMARY KEY AUTO_INCREMENT, /*�û�id */
  appName VARCHAR(255),			/*΢���� */
  appId VARCHAR(255) NOT NULL , /*΢��id */
  appSecret VARCHAR(255) NOT NULL ,  /*΢����Կ */
  userName							/*�û����� */
  userIdCard						/*�û����֤�� */
  userPhone VARCHAR(255),			/*�û��ֻ��� */
  userType VARCHAR(255) NOT NULL,  /*ϵͳ����Ա���༭��¥�����񣬾��ù�˾�������ˣ���ͨ�û�*/    
  userComment          /*�ͻ���ע*/     
  recommendHousesId		/*�ͻ��Ƽ�¥�� */
  recommendHouseTypeId	/*�ͻ��Ƽ����� */  
  companyName			/*��˾���� */
  parentId 				/*��˾id */
  updateTime TIMESTAMP	/*����ʱ�� */
  crtTime TIMESTAMP ,	/*����ʱ�� */
  dataState				/*����״̬ */
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;

/*�Ƽ���*/
create table housecd.recommend(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId       /*������id */
  userName		
  guestId	/*�ͻ�id */
  guestName
  guestPhone 
  dealState		/*�ɽ�״̬ */
  dead_line		/*����ʱ�� */
  crtTime timestamp,
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*Ӷ���*/
create table housecd.brokerage(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  userId	/*������id */
  userName
  guestId   /*�ͻ�id */
  guestName
  guestPhone 
  brokerage   	/*Ӷ�� */
  brokerageState  /*Ӷ��״̬ */
  crtTime timestamp comment '',
  dataState
)ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*Ӷ�������*/
create table housecd.brokerage_param(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId    /*¥��id */
  userParentId   /*���͹�˾id */
  userId		/*������id */
  address		/*�������� */
  brokerage		/*Ӷ�� */
  brokerageType /*Ӷ�����ͣ�1.�̶���2.���� */
  crtTime timestamp comment '',
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*���۱�*/
create table housecd.sell(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesBusinessId  /*¥������id */
  userId		/*������id */
  userParentId  /*���͹�˾id */
  pictureAddress /*ͼƬ��ַ */  
  guestId		/*�ͻ�id */
  guestName
  guestIdCard
  guestAddress  
  housesId		/*¥��id */
  houseTypeId   /*����id */ 
  houseNum		/*����� */	
  price			/*���� */
  totalPrice    /*�ܼ� */   
  brokerage		/*Ӷ�� */
  brokerageState  /*Ӷ��״̬ */
  crtTime timestamp,
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

