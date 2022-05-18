desc employees;

-- findByFirstNameOrLastName
select emp_no, first_name, last_name, date_format(hire_date, '%Y-%m-%d') 
	from employees
where first_name like '%ken%' 
	or last_name like '%ken%'
order by hire_date
limit 0, 100;

-- findBySalary
select a.emp_no, a.first_name, a.last_name, b.salary
	from employees a, salaries b
where a.emp_no = b.emp_no
	and b.to_date = '9999-01-01'
    and b.salary between 45454 and 66666
order by b.salary desc;