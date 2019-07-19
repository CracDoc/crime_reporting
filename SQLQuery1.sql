create database DB_crime_management

go 

use DB_crime_management

go 

/* Reporter Information table for registration */
create table tbl_contact_reporter(
contact_id int primary key identity(1,1),
primary_no varchar(10) NOT NULL,
secondary_no varchar(10),
land_line varchar(15)
);


go 

/* Contains the complete address of the reporter */
create table tbl_address_reporter(
addr_id int primary key identity(1,1),
flat_no varchar(6) ,
street varchar(20) NOT NULL,
landmark varchar(50) ,
city varchar(30) NOT NULL,
pincode int NOT NULL

);

go

/* Contains the information of the crime reporter */
create table tbl_reporter(
rp_id int primary key identity(1,1),
repo_name varchar(50) NOT NULL,
repo_aadhar_no varchar(12) NOT NULL, 
date_of_birth DATE NOT NULL,
addr_id int NOT NULL,
contact_id int NOT NULL,
FOREIGN KEY(addr_id) REFERENCES tbl_address_reporter(addr_id),
FOREIGN KEY (contact_id) REFERENCES tbl_contact_reporter(contact_id)
);

go 

/* Complaint Table Common for reporter and Police-Station */
create table tbl_complaint(
complaint_id int primary key identity(1,1),
com_type varchar(50) NOT NULL,
com_status varchar(10) NOT NULL,
com_desc varchar(500),
location varchar(50) NOT NULL,
);

go

/* Only  Super-Admin can access following table */
/* Contains the police station address information */
create table tbl_address_police_station(
ps_addr_id int primary key identity(1,1),
flat_no varchar(6) ,
street varchar(20) NOT NULL,
landmark varchar(50) ,
city varchar(30) NOT NULL,
pincode int NOT NULL
);

go 

/* Only  Super-Admin can access following table */
/* Contains the police station information */
create table tbl_police_station(
ps_id int primary key identity(1,1),
police_station_name varchar(50) NOT NULL,
ps_addr_id int not null,
FOREIGN KEY(ps_addr_id) REFERENCES tbl_address_police_station(ps_addr_id)
);

go 

/* Contains which complaint is assigned to which police station */
create table tbl_ps_complaint_map(
map_id int primary key identity(1,1),
complaint_id int NOT NULL,
ps_id int NOT NULL,
FOREIGN KEY (complaint_id ) REFERENCES tbl_complaint(complaint_id), 
FOREIGN KEY (ps_id) REFERENCES tbl_police_station(ps_id) 
);

go 

/* Only  Super-Admin can access following table */
/* Contains the admin login information */
create table tbl_admin(
admin_id int primary key identity(1,1),
username varchar(20) NOT NULL,
password varchar(20) NOT NULL,
ps_id int,
FOREIGN KEY (ps_id) REFERENCES tbl_police_station(ps_id)
);

go