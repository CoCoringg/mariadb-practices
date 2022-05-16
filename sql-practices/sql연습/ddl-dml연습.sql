drop table member;
create table member(
	no int(11) not null auto_increment,
    email varchar(200) not null,
    password varchar(64) not null,
    name varchar(100) not null,
    department varchar(100),
    
    primary key(no)
);
desc member;

alter table member add juminbunho char(13) not null;
desc member;
alter table member drop juminbunho;
desc member;
alter table member add juminbunho char(13) not null after email;
desc member;
alter table member change department department char(13) not null;
desc member;
alter table member add self_intro text;
desc member;
alter table member drop juminbunho;

-- insert
insert
	into member
values (null, 'rlacodnjs0908@gmail.com', password('1234'), '김채원', '개발팀', null);

insert 
	into member(no,email, name, password, department)
    values(null, 'rlacodnjs2@mail.com', '김채원2',password('12345'),'총무팀');

-- update
update member
	set email='rlacodnjs2', password = password(1234)
where no = 2;

select * from member;

select * from member;

-- transaction
select @@AUTOCOMMIT;
set autocommit=0;

 insert
   into member(no, email, name, password, department)
  value(null, 'kickscar5@gmail.com', '안대혁5', '1234', '개발팀');

commit;

select * from member;