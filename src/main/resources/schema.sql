create table Employee
(
   employeeId integer not null,
   employeeName varchar(255) not null,
   title varchar(255) not null,
   businessUnit varchar(255) not null,
   place varchar(255) not null,
   superVisorId integer not null,
   compentencies varchar(255) not null,
   salary double not null,
   primary key(employeeId)
);
