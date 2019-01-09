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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

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
 (7,750,0,105,0),
 (8,750,0,105,0),
 (9,900,0,105,0),
 (10,900,0,105,0),
 (11,500,0,1001,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
 (7,'Birthday Party','5','DJ','Aug 24, 2018','01 :01 PM','700','East','100000');
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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
 (8,6,'sakibul','123456789','Savar','01738363303','102');
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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_decoration`
--

/*!40000 ALTER TABLE `event_decoration` DISABLE KEYS */;
INSERT INTO `event_decoration` (`d_id`,`decor_event_id`,`decor_customer_NIC`,`theme_color`,`decor_description`,`table_decoration`,`wall_decoration`,`flower_decoration`,`disco_light`,`entrance_arch`,`decor_special_requirements`,`decor_special_req_price`,`decor_price`,`decor_total`) VALUES 
 (1,'101','19912617239002736','Green','wegsfasf','null','null','null','null','null','sdfasffasdfsfsf','30000','90000','80000.0'),
 (2,'6','123456789','Red','fasdfasdf','Table Decorations','null','null','null','null','asfasdf','20000','60000','80000.0'),
 (3,'7','24242','Red','gfasrff','Table Decorations','Wall Decorations','null','null','null','','30000','70000','100000.0'),
 (4,'7','24242','Red','gfasrff','Table Decorations','Wall Decorations','null','null','null','','30000','70000','100000.0');
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

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
 (6,'7','3252352','600','Package A','4450.00','0','550004','2');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_order`
--

/*!40000 ALTER TABLE `event_order` DISABLE KEYS */;
INSERT INTO `event_order` (`eo_id`,`order_event_id`,`order_customer_NIC`,`event_order_no_of_plates`,`order_status`,`order_menu_id`) VALUES 
 (1,'5454','19912617239002736','500','0','550005'),
 (2,'','','600','Customized','N/A'),
 (3,'34','1991364','700','Customized','N/A'),
 (4,'3','19912617239002736','500','Customized','N/A'),
 (5,'7','3252352','600','0','550004');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `event_payment`
--

/*!40000 ALTER TABLE `event_payment` DISABLE KEYS */;
INSERT INTO `event_payment` (`p_id`,`event_paymentID`,`customer_NIC`,`payment_method`,`credit_Debit`,`payment_description`,`payment_total`,`payment_balance`,`payment_amount`) VALUES 
 (1,'','','Item 1','Debit','','590000.0','560000.0',''),
 (2,'','','Item 1','Debit','','590000.0','560000.0',''),
 (3,'4','1341341234','Money','Debit','sdfasfdadf','560000.0','540000.0','');
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
  PRIMARY KEY  (`b_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `eventbill`
--

/*!40000 ALTER TABLE `eventbill` DISABLE KEYS */;
INSERT INTO `eventbill` (`b_id`,`room_bill`,`decoration_bill`,`food_bill`,`Total`,`Advance`,`Due`,`event_id`,`CustomerName`,`CustomerNid`,`status`) VALUES 
 (1,'100000','100000.0','4450.00',NULL,NULL,NULL,'7','','','');
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
 (5,101,'adsfaf','Available',50000);
/*!40000 ALTER TABLE `hallroom` ENABLE KEYS */;


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
  `Food_date` varchar(45) NOT NULL default '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`Room_No`,`Room_Type`,`Name`,`Address`,`City`,`Sex`,`Age`,`Mobile`,`Arrival`,`Departure`,`Charges`,`Advance`,`Days`,`Total`,`Due`,`Food_bill`,`Food_date`) VALUES 
 ('1001','Single','sdgfa','asdf','Dhaka','Male ',0x3435,'23452345','Aug 1, 2018','Aug 6, 2018','2500','5000','5','12500.0','7500.0','500.0','Aug 28, 2018');
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
 (6,'100','Booked','Single'),
 (9,'103','Unbooked','Single'),
 (10,'105','Unbooked','Double'),
 (11,'500','Unbooked','Double'),
 (12,'295','Unbooked','Single'),
 (13,'1001','Booked','Single'),
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
