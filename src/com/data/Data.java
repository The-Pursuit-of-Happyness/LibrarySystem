package com.data;

public class Data {
	/*
	 	create table Reader(
	 		readerNumber char(10) UNIQUE NOT NULL,
	 		readerName char(30) NOT NULL,
	 		readerPassword char(10) NOT NULL,
	 		readerSex char(2) CHECK (readerSex IN('男','女')),
	 		readerAge SMALLINT CHECK (readerAge >= 15 AND readerAge <= 30),
	 		readerPhone char(11) NOT NULL,
	 		readerEmail char(20),
	 		readerTie char(20) NOT NULL,
	 		readerType char(10),
	 		readerGrade char(5),
	 		readerLimits char(10) NOT NULL,
	 		PRIMARY KEY (readerNumber)
	 	);
	 	
	 	
	 	Insert into Reader Values 
	 	('2013083225','姚鸿','84878323','男','21',
	 	'15640928579','2293952179@qq.com','计算机科学与工程学院网络工程',
	 	'工作室成员','2013级','管理员');
	 	
	 	
	 	update reader set readerTie='计算机学院网络工程' where readerNumber='2013083225';
	 	update reader set readerLimits='管理员' where readerNumber='2013083225';
	 */
	
	/*
	 	create table Book(
	 		bookNumber char(10) UNIQUE NOT NULL,
	 		bookName char(20) NOT NULL,
	 		bookType char(10),
	 		bookAuthor char(20) NOT NULL,
	 		bookPrice SMALLINT CHECK (bookPrice >= 1),
	 		bookCount SMALLINT CHECK (bookCount >= 0),
	 		bookState char(2) CHECK (bookState IN ('可借','不可借')),
	 		bookPress char(20),
	 		bookDate DATETIME,
	 		bookDiscuss char(100)
	 	);
	 	
	 	
	 	insert into book values ('TP312JA527','java项目案例分析','编程','明日科技','39.80','2','可借','清华大学出版社','2012-1-1','这本书讲的很不错，印刷也可以。');
	 	insert into book values ('TP312JA528','数据库系统概论','编程','王珊  萨师煊','39.80','2','可借','高等教育出版社','2014-9-1','这本书讲的很不错，印刷也可以。');
	 	insert into book values ('TP312JA529','java经典编程300例','编程','明日科技','39.80','2','可借','清华大学出版社','2012-1-1','这本书讲的很不错，印刷也可以。');
	 	insert into book values ('TP312JA530','java项目案例分析','编程','明日科技','39.80','2','可借','清华大学出版社','2012-1-1','这本书讲的很不错，印刷也可以。');
	 	insert into book values ('TP312JA531','java项目案例分析','编程','明日科技','39.80','2','可借','清华大学出版社','2012-1-1','这本书讲的很不错，印刷也可以。');
	 	insert into book values ('TP312JA550','现代礼仪常识','文化修养','背负','39.80','1','可借','清华大学出版社','2011-5-5','学号礼仪是很有必要的');
	 	
	 */
}
