use DB_crime_management

go 
exec registerReporter @repo_name = "pallavi",
@repo_aadhar_no  = "1234567891" , 
@date_of_birth  = "09/11/1996", 
@flat_no = "12", 
@street = "Spring flowers road", 
@landmark = "near krishna corner", 
@city = "pune", 
@pincode = 411008,
@primary_no = "1234567891" , 
@secondary_no = "1234567897", 
@land_line = "123456789456"

select * from tbl_reporter
select * from tbl_contact_reporter
select * from tbl_address_reporter


exec registerCriminal
@criminal_name = "swati",
@date_of_birth = '1980-07-29',
@crime_commited = "porancha jiv ghene",
@cases_pending = "porancha jiv ghene",
@wanted_level = 10,
@p_file_name = "swati.jpeg",
@p_file_data = null

select * from tbl_criminal


exec registerPoliceStation 
@police_station_name = "pashan",
@flat_no = "5",
@street = "pashan road",
@landmark = "pashan circle",
@city = "pune",
@pincode = "411008",
@username = "pashan",
@password = "pashan"

select * from tbl_police_station
select * from tbl_address_police_station

alter table tbl_complaint alter column ps_id int null 

exec registerComplaint
@com_type = "harasment",
@com_status = "in progress",
@com_desc = "students at acts are physically and mentally harassed",
@com_date = '2019-07-29',
@location = "cdac acts",
@pincode = 411008,
@rp_id = 1,
@ps_id  = null

select * from tbl_complaint

insert into tbl_admin(username,password) values('admin','admin')

select * from tbl_admin

exec assignComplaintToPS
@complaint_id = 2,
@pincode = 411008,
@psid = null

select * from tbl_complaint

exec assignComplaintToCriminal
@complaint_id = 2,
@criminal_id = 1

select * from tbl_complaint_criminal_map

exec registerReporter @repo_name = "ankit",
@repo_aadhar_no  = "1234567890" , 
@date_of_birth  = "09/11/1996", 
@flat_no = "12", 
@street = "Spring flowers road", 
@landmark = "near krishna corner", 
@city = "pune", 
@pincode = 411008,
@primary_no = "1234567893" , 
@secondary_no = "1234567896", 
@land_line = "123456389456"

select * from tbl_reporter

exec changeReporterAddress
@rp_id = 2,
@flat_no = "7",
@street = "andher gali",
@landmark = "near shamshaan ghat",
@city = "Atma shahar",
@pincode = 123456

select * from tbl_address_reporter

exec changeReporterContact
@rp_id = 2,
@primary_no = "1111111111",
@secondary_no = null,
@land_line = null

select * from tbl_contact_reporter

alter table tbl_police_station add unique(police_station_username)

exec changePassword 
@username = "pashan",
@password = "newpass"

select * from tbl_police_station

exec changeComplaintStatus
@complaint_id = 2,
@com_status = "pending"

select * from tbl_complaint

