drop table if exists userInfo;
drop table if exists roles;

create table userInfo(
emailId varchar(100) primary key,
password varchar(125) not null
);

create table roles(
roleId int(12) primary key,
rolename varchar(20),
emailId varchar(100) references userInfo(emailId)
);

insert into userInfo values ("payal@rjtcompuquest.com", "$2a$12$gBIM0dVDZFR5yPnXy/Ed4u.svrcidxrKgtzTeCCq7zUMXTHZQP6li");

insert into userInfo values ("admin@rjtcompuquest.com", "$2a$12$YTPRYdfhRhIyCJ3IoN0Yu.gll56kz5U1u9Fi81IpVEMcheLlgHWsy");

insert into roles values (1, "user", "payal@rjtcompuquest.com");

insert into roles values (2, "admin", "admin@rjtcompuquest.com");

insert into roles values (3, "user", "admin@rjtcompuquest.com");