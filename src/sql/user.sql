CREATE DATABASE housecd;

drop table housecd.t_user
CREATE TABLE housecd.t_user(
  userId INT NOT NULL PRIMARY KEY auto_increment COMMENT '用户id',
  userName VARCHAR(255) NOT NULL COMMENT '姓名',
  PASSWORD VARCHAR(255) NOT NULL COMMENT '密码',
  phone VARCHAR(255) NOT null COMMENT '电话'
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
select * from housecd.t_user;



CREATE TABLE housecd.app_info(
  id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  appName VARCHAR(255),
  appId VARCHAR(255) NOT NULL ,
  appSecret VARCHAR(255) NOT NULL ,
  appStatus VARCHAR(255) NOT NULL,  /*系统管理员，编辑，楼盘商务，经济公司，经纪人，普通用户*/
  phone VARCHAR(255),
  crtTime TIMESTAMP ,
  rcntlyTime TIMESTAMP
) ENGINE=INNODB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;
select * from housecd.app_info


CREATE table housecd.agent(
  id int not null primary key auto_increment,
  agent_id varchar(255) comment '',
  agent_name varchar(255) comment '',
  agent_id_card varchar(255) comment '',
  recommend_num int(10) comment '',
  trade_volume int(10) comment '',
  already_money varchar(255) comment '',
  stay_money varchar(255) comment '',
  status char(1) comment '',
  crtTime timestamp comment ''
)

CREATE table housecd.company(
  id int not null primary key auto_increment,
  company_id varchar(255) comment '',
  company_name varchar(255) comment '',
  duty_id varchar(255) comment '',
  id_card varchar(255) comment '',
  manager_num varchar(255) comment '',
  recommend_num int(10) comment '',
  trade_volume int(10) comment '',
  already_money varchar(255) comment '',
  stay_money varchar(255) comment '',
  status char(1) comment '',
  crtTime timestamp comment ''
)

create table housecd.recommend(
  agent_name

  recommend_name
  phone 
  deal
  dead_line
  crtTime timestamp comment '',

)

create table housecd.recommend(
  agent_name

  recommend_name
  phone 
  deal
  dead_line
  crtTime timestamp comment '',

)

create table housecd.brokerage(
    agent_name

  recommend_name
  phone 
  deal
  dead_line
  brokerage
  crtTime timestamp comment '',


)


