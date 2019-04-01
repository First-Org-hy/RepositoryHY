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
  appId   VARCHAR(255) NOT NULL , /*΢��id */
  appSecret VARCHAR(255) NOT NULL ,  /*΢����Կ */
  userName							/*�û����� */
  userIdCard						/*�û����֤�� */
  userPhone VARCHAR(255),			/*�û��ֻ��� */
  userType VARCHAR(255) NOT NULL,  /*1ϵͳ����Ա��2�༭��3¥������4���ù�˾��5�����ˣ�6��ͨ�û�*/    
             
  recommendHousesId		/*�ͻ��Ƽ�¥�� */
  recommendHouseTypeId	/*�ͻ��Ƽ����� */  
  companyName			/*��˾���� ����Թ�˾��*/
  parentId 				/*������˾id */
  updateTime TIMESTAMP	/*����ʱ�� */
  crtTime TIMESTAMP ,	/*����ʱ�� */
  userState				/*������(��˾)״̬��0.����� ��1.ͨ���� 2��ͨ�� */
  dataState				/*����״̬ 1.���� 2.�߼�ɾ��*/
) ENGINE=INNODB AUTO_INCREMENT=1000000 DEFAULT CHARSET=utf8;



/*���п���Ϣ�� */
create table housecd.bank_info(
	id
	userId
	cardName
	cardPhone
	bank
	cardNum
	bankDeposit
	crtTime TIMESTAMP ,	/*����ʱ�� */ 
	dataState				/*����״̬ 1.���� 2.�߼�ɾ��*/

)

/*�Ƽ���*/
create table housecd.recommend(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  housesId      /*¥��id�� ���¥���Ƽ��û� */
  userId       /*������id */
  userName		
  guestName
  guestPhone 
  dealState		/*�ɽ�״̬ 1.δ�ɽ� 2.�ɽ� */
  dead_line		/*����ʱ�� 30 */
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
  housesId
  houseTypeId
  houseNum
  brokerage   	/*Ӷ�� */
  brokerageState  /*Ӷ��״̬ 1.����ȡ 2.����ȡ*/
  ifRead 
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
  housesBusinessId  /*¥������id ,����app_info�� */
  userId		/*������id */
  userParentId  /*���͹�˾id */  
  guestId		/*�ͻ�id */
  guestName
  guestIdCard
  guestAddress  
  housesId		/*¥��id */
  houseTypeId   /*����id */ 
  houseNum		/*����� */	
  price			/*���� */
  totalPrice    /*�ܼ� */ 
  pictureAddress /*ͼƬ��ַ */  
  sellState     /*���۲�����0 ����ˣ�1 ���ͨ�� */
  
  dealState     /*����״̬ 1.������2.������ 3. ���׸� 4.���з��� 5.������� 6. δ����  */  
  brokerage		/*Ӷ�� */
  brokerageState  /*Ӷ��״̬ */
  crtTime timestamp,
  dataState
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

/*�ͻ���*/
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

/*����� */ 
create table housecd.area(
  areaId
  areaName
  crtTime timestamp,
  dataState
)

/*���� */
create table housecd.advertising(
 adId 
 adName
 adAddress   /*���λ��  */
 adPicture
 startTime
 deadLine
 crtTime timestamp,
 dataState
 
)

/*��Ѷ�� */
create table housecd.houses_info(
 Id 
 headline /*����  */
 programa /*��Ŀ  */
 pictureAddress
 lableId   /*��ǩ  */
 content /*����  */
 crtTime timestamp,
 dataState
 
)

/*��̬�� */
create table housecd.houses_state(
 Id 
 headline
 areaId
 housesId

 crtTime timestamp,
 dataState
 
)

/*��ǩ�� һ��ID��������ǩ*/  
create table housecd.lable(
 lableId
 lableContext
 crtTime timestamp,
 dataState
)

/* ¥�̱� */
create table housecd.houses(
 housesId			/*¥��ID */
 housesName			/*¥��Name */
 housesSpecialty  /*�ص㣬ʹ�ñ�ǩ�� */
 houseState /*״̬�� �ڽ�0,����1,����2 */
 pictureX  /*Ч��ͼ */
 pictureS   /*ʵʩͼ */
 pictureJ	/*��ͨͼ */
 /*������ʩ��ѧУ��������ҽԺ�����С��������ۺ��̳� */
 /*����ID����Ҫ���ͱ� */
 /*ռ����� */
 /*������� */
 /*������� */
 /*������ */
 /*¥�̵�ַ */
 /*��Ȩ���� */
 /*����ID�� �������� */
 /*�������ͣ� */
 /*�̻��� */
 /*��ҵ��˾ */
 /*���¿��� */
 /*����ʱ�� */
 /*���� */
 /*Ͷ���� */
 /*�ݻ��� */
 /*���� */
 /*��λ�� */
 /*װ����� */
 /*��λ  ��ʲô������ ʡ���� */
 /*�Ƽ� */

 crtTime timestamp,
 dataState
 

)

 /*���ͱ� */
 create table housecd.house_type(
 houseTypeId
 houseTypeName
 houseTypeSpecialty   /*�ص㣬ʹ�ñ�ǩ�� */
 houseTypePicture
 /* ¥��*/
 /* ����*/
 /* �������*/
 /* �ο�����*/
 /* �ο��ܼ�*/
 /* ���ࣺסլ*/
 crtTime timestamp,
 dataState 
 )
 
/*�·��� */
create table housecd.house(
 houseId
		  /*���� */
 housesId /*¥�� */
		  /*���ͣ�¥���µĻ��� */
		  /*�·�id�� ����·��� 10��1��Ԫ1¥,10��1��Ԫ1¥ */
		  /* */
  crtTime timestamp,
 dataState 

) 
 
/* ���ַ��� */ 
create table housecd.second_hand_house(
 secondHouseId
 houseName  /*һ��10��A���� */
 /*���� */
 /*��ַ */
 /*С�� */
 /*��� */
 /*���� varchar */
 /*���� */
 /*¥�� */
 /*װ�ޣ�ë������װ����װ */
 /*���ͣ�סլ����Ԣ������ */
 /*�ص㣺ʹ�ñ�ǩ��  */
 /*��Ƭ��ַ */
 /*���� */
 /*�ܼ� */
 /*��Դ���� */
 /*������ */
 /*�Ƿ����ߣ����� ���� */
 
  crtTime timestamp,
 dataState 
 
)

/**/
 
 
 
 
 
 

 
 
 

























