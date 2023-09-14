--------------------------------------------------------
--  File created - Wednesday-September-13-2023   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table DATABASE
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."DATABASE" 
   (	"First Name" VARCHAR2(100 BYTE), 
	"Last Name" VARCHAR2(100 BYTE), 
	"ID" VARCHAR2(100 BYTE), 
	"Time" TIMESTAMP (6), 
	"Access Level" VARCHAR2(100 BYTE), 
	"Status" VARCHAR2(100 BYTE), 
	"USERNAME" VARCHAR2(100 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.DATABASE
SET DEFINE OFF;
Insert into SYSTEM.DATABASE ("First Name","Last Name",ID,"Time","Access Level","Status",USERNAME) values ('John','Smith','958548877',to_timestamp('13-SEP-23 03.26.45.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Student','Active','JS99');
Insert into SYSTEM.DATABASE ("First Name","Last Name",ID,"Time","Access Level","Status",USERNAME) values ('Jackson','Bull','756345692',to_timestamp('13-SEP-23 03.26.47.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Employee','Active','JB87');
Insert into SYSTEM.DATABASE ("First Name","Last Name",ID,"Time","Access Level","Status",USERNAME) values ('Abraham','Lincoln','653469834',to_timestamp('13-SEP-23 03.26.48.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Management','Active','AL19');
Insert into SYSTEM.DATABASE ("First Name","Last Name",ID,"Time","Access Level","Status",USERNAME) values ('John','Smith','958548877',to_timestamp('13-SEP-23 04.20.46.000000000 AM','DD-MON-RR HH.MI.SSXFF AM'),'Employee','Active','JS99');
