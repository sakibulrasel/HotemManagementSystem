-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.45-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema myproject
--

CREATE DATABASE IF NOT EXISTS myproject;
USE myproject;

--
-- Definition of table `bills`
--

DROP TABLE IF EXISTS `bills`;
CREATE TABLE `bills` (
  `b_id` int(10) unsigned NOT NULL auto_increment,
  `food_bill` double NOT NULL default '0',
  `room_bill` double NOT NULL default '0',
  `room_no` int(10) unsigned NOT NULL default '0',
  `total_bill` double NOT NULL default '0',
  PRIMARY KEY  (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bills`
--

/*!40000 ALTER TABLE `bills` DISABLE KEYS */;
INSERT INTO `bills` (`b_id`,`food_bill`,`room_bill`,`room_no`,`total_bill`) VALUES 
 (1,300,2500,100,9500),
 (2,360,2500,100,0),
 (3,360,2500,100,0),
 (4,480,2500,100,0),
 (5,480,2500,100,0),
 (6,480,2500,100,0),
 (7,750,81000,105,0),
 (8,750,81000,105,0),
 (9,900,81000,105,0),
 (10,900,81000,105,0),
 (11,500,0,1001,0),
 (12,750,0,1001,0),
 (13,500,0,103,0),
 (14,750,0,105,0);
/*!40000 ALTER TABLE `bills` ENABLE KEYS */;


--
-- Definition of table `event`
--

DROP TABLE IF EXISTS `event`;
CREATE TABLE `event` (
  `eventId` int(10) unsigned NOT NULL auto_increment,
  `eventType` varchar(45) NOT NULL,
  `eventDuration` varchar(45) NOT NULL,
  `eventEnter` varchar(45) NOT NULL,
  `eventDate` varchar(45) NOT NULL,
  `eventTime` varchar(45) NOT NULL,
  `eventGuests` varchar(45) NOT NULL,
  `hallName` varchar(45) NOT NULL,
  `hallPrice` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`eventId`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event`
--

/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`eventId`,`eventType`,`eventDuration`,`eventEnter`,`eventDate`,`eventTime`,`eventGuests`,`hallName`,`hallPrice`) VALUES 
 (1,'Get together','4','Band','Aug 9, 2018','0301AM','600','Chand','5000'),
 (2,'Birthday Party','5','Calipso','Aug 11, 2018','0201AM','700','Chand','5000'),
 (3,'Birthday Party','4','DJ','Aug 2, 2018','0201AM','600','Chand','5000'),
 (4,'Wedding','4','Calipso','Aug 1, 2018','02 :01 AM','500','Chand','5000'),
 (5,'Wedding','5','Band','Aug 23, 2018','02 :01 AM','600','South','80000'),
 (6,'Wedding','4','DJ','Aug 29, 2018','02 :01 AM','500','North','90000'),
 (7,'Birthday Party','5','DJ','Aug 24, 2018','01 :01 PM','700','East','100000'),
 (8,'Wedding','5','Band','Aug 3, 2018','01 :00 AM','400','adsfaf','50000'),
 (9,'Wedding','5','Band','Aug 25, 2018','03 :00 AM','500','South','80000'),
 (10,'Birthday Party','5','Band','Sep 14, 2018','02 :02 AM','400','North','90000'),
 (11,'Wedding','5','Band','Sep 7, 2018','02 :01 AM','600','East','100000'),
 (12,'Birthday Party','4','Band','Sep 15, 2018','01 :01 AM','400','South','80000'),
 (13,'Wedding','4','Band','Sep 21, 2018','02 :02 AM','600','South','80000'),
 (14,'Wedding','4','Band','Sep 22, 2018','02 :02 AM','500','South','80000'),
 (15,'Birthday Party','4','Band','Sep 23, 2018','03 :01 AM','300','South','80000');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;


--
-- Definition of table `event_booking`
--

DROP TABLE IF EXISTS `event_booking`;
CREATE TABLE `event_booking` (
  `b_id` int(10) unsigned NOT NULL auto_increment,
  `booking_event_id` varchar(45) NOT NULL,
  `booking_customer_NIC` varchar(45) NOT NULL,
  `booking_date` varchar(45) NOT NULL,
  `booking_status` varchar(45) NOT NULL,
  PRIMARY KEY  (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_booking`
--

/*!40000 ALTER TABLE `event_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_booking` ENABLE KEYS */;


--
-- Definition of table `event_customer_info`
--

DROP TABLE IF EXISTS `event_customer_info`;
CREATE TABLE `event_customer_info` (
  `c_id` int(10) unsigned NOT NULL auto_increment,
  `cus_event_id` int(10) unsigned NOT NULL,
  `customer_name` varchar(45) NOT NULL,
  `customer_NID` varchar(45) NOT NULL,
  `customer_address` varchar(45) NOT NULL,
  `customer_tel` varchar(45) NOT NULL,
  `h_no` varchar(45) NOT NULL,
  PRIMARY KEY  (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_customer_info`
--

/*!40000 ALTER TABLE `event_customer_info` DISABLE KEYS */;
INSERT INTO `event_customer_info` (`c_id`,`cus_event_id`,`customer_name`,`customer_NID`,`customer_address`,`customer_tel`,`h_no`) VALUES 
 (1,5454,'Sakibul','19912617239002736','Savar','01738363303',''),
 (2,234,'erxw','1991364','dfght','857676967',''),
 (3,3,'sakibul','12346577','savar','1234567',''),
 (5,3,'rasel','19912617239002736','dhaka','2435234523',''),
 (6,4,'Sakibul','3758479665','Dhaka','01738363303',''),
 (7,5,'Sakibul','9398929','Savar','01738363303','101'),
 (8,6,'sakibul','123456789','Savar','01738363303','102'),
 (9,8,'sakibul','121212','savar','23123123','adsfaf'),
 (10,9,'asdfasd','345234','asdf','34234','102'),
 (11,10,'rasel','112233','sadf','3452345','102'),
 (12,11,'sakibul','4567','Savar','1231434134','103'),
 (13,12,'sakibul','123','Dhaka','0183784','101'),
 (14,13,'asdfas','333','asdf','341234','101'),
 (15,14,'dfasdfas','111','adf','23452345','101'),
 (16,15,'rasel','11111','adfad','23444','101');
/*!40000 ALTER TABLE `event_customer_info` ENABLE KEYS */;


--
-- Definition of table `event_decoration`
--

DROP TABLE IF EXISTS `event_decoration`;
CREATE TABLE `event_decoration` (
  `d_id` int(10) unsigned NOT NULL auto_increment,
  `decor_event_id` varchar(45) default NULL,
  `decor_customer_NIC` varchar(45) default NULL,
  `theme_color` varchar(45) default NULL,
  `decor_description` varchar(500) default NULL,
  `table_decoration` varchar(45) default NULL,
  `wall_decoration` varchar(45) default NULL,
  `flower_decoration` varchar(45) default NULL,
  `disco_light` varchar(45) default NULL,
  `entrance_arch` varchar(45) default NULL,
  `decor_special_requirements` varchar(45) default NULL,
  `decor_special_req_price` varchar(45) default NULL,
  `decor_price` varchar(45) default NULL,
  `decor_total` varchar(45) default NULL,
  PRIMARY KEY  (`d_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_decoration`
--

/*!40000 ALTER TABLE `event_decoration` DISABLE KEYS */;
INSERT INTO `event_decoration` (`d_id`,`decor_event_id`,`decor_customer_NIC`,`theme_color`,`decor_description`,`table_decoration`,`wall_decoration`,`flower_decoration`,`disco_light`,`entrance_arch`,`decor_special_requirements`,`decor_special_req_price`,`decor_price`,`decor_total`) VALUES 
 (1,'101','19912617239002736','Green','wegsfasf','null','null','null','null','null','sdfasffasdfsfsf','30000','90000','80000.0'),
 (2,'6','123456789','Red','fasdfasdf','Table Decorations','null','null','null','null','asfasdf','20000','60000','80000.0'),
 (3,'7','24242','Red','gfasrff','Table Decorations','Wall Decorations','null','null','null','','30000','70000','100000.0'),
 (4,'7','24242','Red','gfasrff','Table Decorations','Wall Decorations','null','null','null','','30000','70000','100000.0'),
 (5,'8','121212','Red','asdfasdf','Table Decorations','Wall Decorations','null','null','null','asdfasdf','30000','40000','70000.0'),
 (6,'9','345234','Red','qwrqwe','null','null','null','null','null','rwqer','50000','50000','100000.0'),
 (7,'10','112233','Blue','fgsdf','null','null','null','null','null','sdfgsdfg','10000','50000','60000.0'),
 (8,'13','4567','Blue','','Table Decoration','Wall Decoration','null','null','null','','5000','400000',''),
 (9,'12','123','Blue','wdfasdfafd','Table Decorations','null','null','null','null','zsdasdf','20000','30000','50000.0'),
 (10,'13','333','Red','werfwef','Table Decorations','Wall Decorations','null','null','null','adf','30000','400000','430000.0'),
 (11,'14','111','Red','asdfa','null','Wall Decorations','null','null','null','casd','5000','400000','405000.0'),
 (12,'15','11111','Red','asdf','Table Decorations','Wall Decorations','null','null','null','asdf','4000','40000','44000.0');
/*!40000 ALTER TABLE `event_decoration` ENABLE KEYS */;


--
-- Definition of table `event_food_packages`
--

DROP TABLE IF EXISTS `event_food_packages`;
CREATE TABLE `event_food_packages` (
  `f_id` int(10) unsigned NOT NULL auto_increment,
  `fp_event_id` varchar(45) NOT NULL,
  `fp_customer_NIC` varchar(45) NOT NULL,
  `no_of_plates` varchar(45) NOT NULL,
  `fp_regular` varchar(45) NOT NULL,
  `fp_price` varchar(45) NOT NULL,
  `order_status` varchar(500) NOT NULL,
  `fp_menu_id` varchar(45) NOT NULL,
  `h_no` varchar(45) NOT NULL,
  PRIMARY KEY  (`f_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_food_packages`
--

/*!40000 ALTER TABLE `event_food_packages` DISABLE KEYS */;
INSERT INTO `event_food_packages` (`f_id`,`fp_event_id`,`fp_customer_NIC`,`no_of_plates`,`fp_regular`,`fp_price`,`order_status`,`fp_menu_id`,`h_no`) VALUES 
 (1,'5454','19912617239002736','500','Package B','3460.00','0','550005',''),
 (2,'101','19912617239002736','500','Customized','410000.0','Chocolate Biscuit Pudding ,Fruit Trifle ,Chicken Salad ,Brinjal Pahi ,Chicken Salad ,Fried Rice (Basmathi) ,Welcome Drink ,','N/A',''),
 (3,'','','600','Customized','420000.0','Fish Stew/Fish Sweet Sauce ,Chicken Black Curry ,Macaroni with Chili Sauce ,Steam Rice ,Plain Rice (Basmathi) ,Welcome Drink ,','N/A',''),
 (4,'34','1991364','700','Customized','378000.0','Chicken Black Curry ,Brinjal Pahi ,Fried Rice (Basmathi) ,Welcome Drink ,','N/A',''),
 (5,'3','19912617239002736','500','Customized','95000.0','Plain Rice (Basmathi) ,Welcome Drink ,','N/A',''),
 (6,'7','3252352','600','Package A','4450.00','0','550004','2'),
 (7,'8','121212','100','Package A','4450.00','0','550004','adsfaf'),
 (8,'9','345234','10','Package A','4450.00','0','550004','102'),
 (9,'10','112233','100','Package B','3460.00','0','550005','102'),
 (10,'13','4567','2','Package A','4450.00','0','550004','103'),
 (11,'12','123','500','Package B','3460.00','0','550005','101'),
 (12,'13','333','400','Package A','4450.00','0','550004','101'),
 (13,'14','111','400','Package A','4450.00','0','550004','101'),
 (14,'15','11111','200','Package E','3670.00','0','550008','101');
/*!40000 ALTER TABLE `event_food_packages` ENABLE KEYS */;


--
-- Definition of table `event_order`
--

DROP TABLE IF EXISTS `event_order`;
CREATE TABLE `event_order` (
  `eo_id` int(10) unsigned NOT NULL auto_increment,
  `order_event_id` varchar(45) NOT NULL,
  `order_customer_NIC` varchar(45) NOT NULL,
  `event_order_no_of_plates` varchar(45) NOT NULL,
  `order_status` varchar(45) NOT NULL,
  `order_menu_id` varchar(45) NOT NULL,
  PRIMARY KEY  (`eo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_order`
--

/*!40000 ALTER TABLE `event_order` DISABLE KEYS */;
INSERT INTO `event_order` (`eo_id`,`order_event_id`,`order_customer_NIC`,`event_order_no_of_plates`,`order_status`,`order_menu_id`) VALUES 
 (1,'5454','19912617239002736','500','0','550005'),
 (2,'','','600','Customized','N/A'),
 (3,'34','1991364','700','Customized','N/A'),
 (4,'3','19912617239002736','500','Customized','N/A'),
 (5,'7','3252352','600','0','550004'),
 (6,'8','121212','100','0','550004'),
 (7,'9','345234','10','0','550004'),
 (8,'10','112233','100','0','550005'),
 (9,'13','4567','2','0','550004'),
 (10,'12','123','500','0','550005'),
 (11,'13','333','400','0','550004'),
 (12,'14','111','400','0','550004'),
 (13,'15','11111','200','0','550008');
/*!40000 ALTER TABLE `event_order` ENABLE KEYS */;


--
-- Definition of table `event_payment`
--

DROP TABLE IF EXISTS `event_payment`;
CREATE TABLE `event_payment` (
  `p_id` int(10) unsigned NOT NULL auto_increment,
  `event_paymentID` varchar(45) NOT NULL,
  `customer_NIC` varchar(45) NOT NULL,
  `payment_method` varchar(45) NOT NULL,
  `credit_Debit` varchar(45) NOT NULL,
  `payment_description` varchar(45) NOT NULL,
  `payment_total` varchar(45) NOT NULL,
  `payment_balance` varchar(45) NOT NULL,
  `payment_amount` varchar(45) NOT NULL,
  PRIMARY KEY  (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_payment`
--

/*!40000 ALTER TABLE `event_payment` DISABLE KEYS */;
INSERT INTO `event_payment` (`p_id`,`event_paymentID`,`customer_NIC`,`payment_method`,`credit_Debit`,`payment_description`,`payment_total`,`payment_balance`,`payment_amount`) VALUES 
 (1,'','','Item 1','Debit','','590000.0','560000.0',''),
 (2,'','','Item 1','Debit','','590000.0','560000.0',''),
 (3,'4','1341341234','Money','Debit','sdfasfdadf','560000.0','540000.0',''),
 (4,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (5,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (6,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (7,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (8,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (9,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (10,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (11,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (12,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (13,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (14,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (15,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (16,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (17,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (18,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (19,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (20,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (21,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (22,'9','345234','Money','Debit','sddfasdf','194450.0','194450.0','0'),
 (23,'10','112233','Money','Credit','asdfasd','153460.0','20000','133460.0'),
 (24,'12','123','Bank','Debit','sadf','103460.0','83460.0','20000'),
 (25,'12','123','Bank','Debit','sadf','103460.0','83460.0','20000'),
 (26,'13','333','Bank','Credit','sdfsf','484450.0','464450.0','20000'),
 (27,'14','111','Bank','Credit','asdfadf','459450.0','439450.0','20000'),
 (28,'15','11111','Bank','Debit','','97670.0','47670.0','50000');
/*!40000 ALTER TABLE `event_payment` ENABLE KEYS */;


--
-- Definition of table `eventbill`
--

DROP TABLE IF EXISTS `eventbill`;
CREATE TABLE `eventbill` (
  `b_id` int(10) unsigned NOT NULL auto_increment,
  `room_bill` varchar(45) default NULL,
  `decoration_bill` varchar(45) default NULL,
  `food_bill` varchar(45) default NULL,
  `Total` varchar(45) default NULL,
  `Advance` varchar(45) default NULL,
  `Due` varchar(45) default NULL,
  `event_id` varchar(45) NOT NULL,
  `CustomerName` varchar(45) NOT NULL,
  `CustomerNid` varchar(45) NOT NULL,
  `status` varchar(45) NOT NULL,
  `event_date` varchar(45) NOT NULL,
  `room_no` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eventbill`
--

/*!40000 ALTER TABLE `eventbill` DISABLE KEYS */;
INSERT INTO `eventbill` (`b_id`,`room_bill`,`decoration_bill`,`food_bill`,`Total`,`Advance`,`Due`,`event_id`,`CustomerName`,`CustomerNid`,`status`,`event_date`,`room_no`) VALUES 
 (1,'100000','100000.0','4450.00',NULL,NULL,NULL,'7','','','Pending','0000-00-00',0),
 (2,'90000','60000.0','3460.00','153460.0','20000','133460.0','10','null','112233','Paid','0000-00-00',0),
 (3,'50000','44000.0','3670.00','97670.0','50000','47670.0','15','null','11111','Pending','Sep 24, 2018',101);
/*!40000 ALTER TABLE `eventbill` ENABLE KEYS */;


--
-- Definition of table `foods`
--

DROP TABLE IF EXISTS `foods`;
CREATE TABLE `foods` (
  `item_no` int(20) NOT NULL,
  `item_name` varchar(45) NOT NULL,
  `item_price` double NOT NULL,
  `status` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `foods`
--

/*!40000 ALTER TABLE `foods` DISABLE KEYS */;
INSERT INTO `foods` (`item_no`,`item_name`,`item_price`,`status`) VALUES 
 (1,'rice',20,''),
 (2,'fish',120,'Available'),
 (5,'meat',150,'Available'),
 (5,'akd',50,'Available'),
 (5,'Breakfast',100,'Available');
/*!40000 ALTER TABLE `foods` ENABLE KEYS */;


--
-- Definition of table `hallroom`
--

DROP TABLE IF EXISTS `hallroom`;
CREATE TABLE `hallroom` (
  `hd` int(10) unsigned NOT NULL auto_increment,
  `h_id` int(10) unsigned NOT NULL,
  `h_name` varchar(45) NOT NULL,
  `h_status` varchar(45) NOT NULL,
  `h_price` double default NULL,
  PRIMARY KEY  USING BTREE (`hd`,`h_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hallroom`
--

/*!40000 ALTER TABLE `hallroom` DISABLE KEYS */;
INSERT INTO `hallroom` (`hd`,`h_id`,`h_name`,`h_status`,`h_price`) VALUES 
 (2,101,'South','Unavailable',80000),
 (3,102,'North','Unavailable',90000),
 (4,103,'East','Unavailable',100000),
 (5,101,'adsfaf','Unavailable',50000);
/*!40000 ALTER TABLE `hallroom` ENABLE KEYS */;


--
-- Definition of table `hr_employee`
--

DROP TABLE IF EXISTS `hr_employee`;
CREATE TABLE `hr_employee` (
  `employee_id` int(10) unsigned NOT NULL auto_increment,
  `employee_fname` varchar(45) NOT NULL,
  `employee_lname` varchar(45) NOT NULL,
  `employee_nic` varchar(45) NOT NULL,
  `employee_telephone` varchar(45) NOT NULL,
  `employee_address` varchar(45) NOT NULL,
  `employee_sex` varchar(45) NOT NULL,
  `employee_DOB` varchar(45) NOT NULL,
  `employee_designation` varchar(45) NOT NULL,
  `employee_type` varchar(45) NOT NULL,
  `employee_hourly_rate` varchar(45) NOT NULL,
  `employee_basic_salary` varchar(45) NOT NULL,
  `employee_department` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`employee_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_employee`
--

/*!40000 ALTER TABLE `hr_employee` DISABLE KEYS */;
INSERT INTO `hr_employee` (`employee_id`,`employee_fname`,`employee_lname`,`employee_nic`,`employee_telephone`,`employee_address`,`employee_sex`,`employee_DOB`,`employee_designation`,`employee_type`,`employee_hourly_rate`,`employee_basic_salary`,`employee_department`) VALUES 
 (1,'','','asdf','asdf','asdf','Male','','asdf','Part Time Employee','500','','Select the Department'),
 (2,'asdf','asdf','asdf','asdf','asdf','Male','','asdf','Part Time Employee','500','','Select the Department');
/*!40000 ALTER TABLE `hr_employee` ENABLE KEYS */;


--
-- Definition of table `hr_leaves`
--

DROP TABLE IF EXISTS `hr_leaves`;
CREATE TABLE `hr_leaves` (
  `l_id` int(10) unsigned NOT NULL auto_increment,
  `leaves_from_date` varchar(45) NOT NULL,
  `leaves_end_date` varchar(45) NOT NULL,
  `leaves_resson` varchar(45) NOT NULL,
  `leaves_status` varchar(45) NOT NULL,
  `leaves_employee_id` varchar(45) NOT NULL,
  PRIMARY KEY  (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_leaves`
--

/*!40000 ALTER TABLE `hr_leaves` DISABLE KEYS */;
/*!40000 ALTER TABLE `hr_leaves` ENABLE KEYS */;


--
-- Definition of table `hr_salary`
--

DROP TABLE IF EXISTS `hr_salary`;
CREATE TABLE `hr_salary` (
  `s_id` int(10) unsigned NOT NULL auto_increment,
  `salary_other_pay` varchar(45) NOT NULL,
  `salary_deduction` varchar(45) NOT NULL,
  `salary_emp_id` varchar(45) NOT NULL,
  `salary_total` varchar(45) NOT NULL,
  `salary_status` varchar(45) NOT NULL,
  PRIMARY KEY  (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_salary`
--

/*!40000 ALTER TABLE `hr_salary` DISABLE KEYS */;
INSERT INTO `hr_salary` (`s_id`,`salary_other_pay`,`salary_deduction`,`salary_emp_id`,`salary_total`,`salary_status`) VALUES 
 (1,'2000','1000','1','6000.0','Calculate');
/*!40000 ALTER TABLE `hr_salary` ENABLE KEYS */;


--
-- Definition of table `hr_wage`
--

DROP TABLE IF EXISTS `hr_wage`;
CREATE TABLE `hr_wage` (
  `w_id` int(10) unsigned NOT NULL auto_increment,
  `wage_hours_worked` varchar(45) NOT NULL,
  `wage_deduction` varchar(45) NOT NULL,
  `wage_total` varchar(45) NOT NULL,
  `wage_other_pay` varchar(45) NOT NULL,
  `wage_status` varchar(45) NOT NULL,
  `wage_emp_id` varchar(45) NOT NULL,
  PRIMARY KEY  (`w_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hr_wage`
--

/*!40000 ALTER TABLE `hr_wage` DISABLE KEYS */;
/*!40000 ALTER TABLE `hr_wage` ENABLE KEYS */;


--
-- Definition of table `login_tbl`
--

DROP TABLE IF EXISTS `login_tbl`;
CREATE TABLE `login_tbl` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login_tbl`
--

/*!40000 ALTER TABLE `login_tbl` DISABLE KEYS */;
INSERT INTO `login_tbl` (`id`,`name`,`password`) VALUES 
 (1,'rasel','1991');
/*!40000 ALTER TABLE `login_tbl` ENABLE KEYS */;


--
-- Definition of table `order_food`
--

DROP TABLE IF EXISTS `order_food`;
CREATE TABLE `order_food` (
  `room_no` int(10) unsigned NOT NULL,
  `food_name` varchar(45) NOT NULL,
  `food_price` double NOT NULL,
  `food_quantity` int(10) unsigned NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_food`
--

/*!40000 ALTER TABLE `order_food` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_food` ENABLE KEYS */;


--
-- Definition of table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `Room_No` varchar(45) NOT NULL,
  `Room_Type` varchar(45) NOT NULL,
  `Name` varchar(45) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `City` varchar(45) NOT NULL,
  `Sex` varchar(45) NOT NULL,
  `Age` varchar(45) character set latin1 collate latin1_bin NOT NULL,
  `Mobile` varchar(45) NOT NULL,
  `Arrival` varchar(45) NOT NULL,
  `Departure` varchar(45) NOT NULL,
  `Charges` varchar(45) NOT NULL,
  `Advance` varchar(45) NOT NULL,
  `Days` varchar(45) NOT NULL,
  `Total` varchar(45) NOT NULL,
  `Due` varchar(45) NOT NULL,
  `Food_bill` varchar(45) NOT NULL default '0',
  `Food_date` varchar(45) NOT NULL default '0',
  `nid` int(10) unsigned NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`Room_No`,`Room_Type`,`Name`,`Address`,`City`,`Sex`,`Age`,`Mobile`,`Arrival`,`Departure`,`Charges`,`Advance`,`Days`,`Total`,`Due`,`Food_bill`,`Food_date`,`nid`) VALUES 
 ('1001','Single','sdgfa','asdf','Dhaka','Male ',0x3435,'23452345','Aug 1, 2018','Aug 6, 2018','2500','5000','5','12500.0','7500.0','750.0','30 - 7 - 2018',0),
 ('105','Single','sakibul','Savar','Dhaka','Male ',0x3334,'22352345','Aug 30, 2018','Aug 24, 2018','2500','0','2','5000.0','5000.0','750.0','6 - 8 - 2018',19274933),
 ('103','Single','sajd','stsdf','Dhaka','Male ',0x3435,'43445','Sep 4, 2018','Sep 12, 2018','2500','25000','44','110000.0','85000.0','500.0','6 - 8 - 2018',2344546),
 ('105','Single','tfr','iyuft','Khulna','Male ',0x38,'88723','Sep 5, 2018','Sep 20, 2018','2500','4000','34','85000.0','81000.0','750.0','6 - 8 - 2018',121);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;


--
-- Definition of table `room`
--

DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `room_no` varchar(45) NOT NULL,
  `book` varchar(45) NOT NULL,
  `room_type` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room`
--

/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` (`id`,`room_no`,`book`,`room_type`) VALUES 
 (9,'103','Unbooked','Single'),
 (10,'105','Booked','Single'),
 (11,'500','Unbooked','Double'),
 (12,'295','Unbooked','Single'),
 (13,'1001','Unbooked','Single'),
 (14,'1002','Unbooked','Double');
/*!40000 ALTER TABLE `room` ENABLE KEYS */;


--
-- Definition of table `system_user`
--

DROP TABLE IF EXISTS `system_user`;
CREATE TABLE `system_user` (
  `system_user_id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `department` varchar(45) NOT NULL,
  `accessLevel` varchar(45) NOT NULL,
  `userAvailibility` varchar(45) NOT NULL,
  PRIMARY KEY  (`system_user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `system_user`
--

/*!40000 ALTER TABLE `system_user` DISABLE KEYS */;
INSERT INTO `system_user` (`system_user_id`,`username`,`password`,`department`,`accessLevel`,`userAvailibility`) VALUES 
 (1,'sakibul','1991','System','Admin','available'),
 (2,'rasel','1991','Stock','Admin','available'),
 (3,'sakibulrasel','1991','Restaurant','Admin','available');
/*!40000 ALTER TABLE `system_user` ENABLE KEYS */;


--
-- Definition of function `get_price`
--

DROP FUNCTION IF EXISTS `get_price`;

DELIMITER $$

/*!50003 SET @TEMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER' */ $$
CREATE DEFINER=`root`@`localhost` FUNCTION `get_price`(getiname varchar(45)) RETURNS int(11)
BEGIN
return(select item_price from foods where item_name = getiname);
END $$
/*!50003 SET SESSION SQL_MODE=@TEMP_SQL_MODE */  $$

DELIMITER ;



/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
