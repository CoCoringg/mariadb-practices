-- DepartmentDao:findAll()
select no, name from department order by no desc;
select no, name, department_no from employee;

-- DepartmentDao:update()
update department set name = '솔루션개발' where no = 3;

-- EmployeeDao:delete()
delete from employee;
