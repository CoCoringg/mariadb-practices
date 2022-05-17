-- 서브쿼리(SUBQUERY) SQL 문제입니다.

-- 문제1.
-- 현재 평균 연봉보다 많은 월급을 받는 직원은 몇 명이나 있습니까?
SELECT 
    AVG(salary)
FROM
    salaries;

SELECT 
    COUNT(*)
FROM
    salaries
WHERE
    salary > (SELECT 
            AVG(salary)
        FROM
            salaries
        WHERE
            to_date = '9999-01-01')
        AND to_date = '9999-01-01';

-- 문제2. 
-- 현재, 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회하세요. 단 조회결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다. 
select a.emp_no as '사번', concat(a.first_name, ' ', a.last_name) as '이름', c.dept_name as '부서', d.salary as '연봉'
	from employees a, dept_emp b, departments c, salaries d
where a.emp_no = b.emp_no 
	and b.dept_no = c.dept_no
    and a.emp_no = d.emp_no
    and b.to_date = '9999-01-01'
    and d.to_date = '9999-01-01'
    and (b.dept_no, d.salary) in (select b.dept_no ,max(a.salary) as max_salary
	from salaries a, dept_emp b
where a.emp_no = b.emp_no
	and a.to_date = '9999-01-01'
    and b.to_date = '9999-01-01'
group by b.dept_no)
order by d.salary desc;  
    

-- 문제3.
-- 현재, 자신의 부서 평균 급여보다 연봉(salary)이 많은 사원의 사번, 이름과 연봉을 조회하세요 
SELECT 
    b.dept_no, AVG(a.salary) AS avg_salary
FROM
    salaries a,
    dept_emp b
WHERE
    a.emp_no = b.emp_no
        AND a.to_date = '9999-01-01'
        AND b.to_date = '9999-01-01'
GROUP BY b.dept_no;

SELECT 
    a.emp_no, a.first_name, b.salary
FROM
    employees a,
    salaries b,
    dept_emp c,
    (SELECT 
        b.emp_no, b.dept_no, AVG(a.salary) AS avg_salary
    FROM
        salaries a, dept_emp b
    WHERE
        a.emp_no = b.emp_no
            AND a.to_date = '9999-01-01'
            AND b.to_date = '9999-01-01'
    GROUP BY b.dept_no) d
WHERE
    a.emp_no = b.emp_no
        AND b.emp_no = c.emp_no
        AND c.dept_no = d.dept_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND b.salary > d.avg_salary;


-- 문제4.
-- 현재, 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력해 보세요.
SELECT 
    a.emp_no,
    CONCAT(a.first_name, ' ', a.last_name) AS name,
    CONCAT(e.first_name, ' ', e.last_name) AS manager_name,
    c.dept_name
FROM
    employees a,
    dept_emp b,
    departments c,
    dept_manager d,
    employees e
WHERE
    a.emp_no = b.emp_no
        AND b.dept_no = c.dept_no
        AND d.dept_no = c.dept_no
        AND d.emp_no = e.emp_no
        AND b.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01';
    

-- 문제5.
-- 현재, 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉 순으로 출력하세요.
-- 평균연봉이 가장 높은
SELECT 
    a.dept_no
FROM
    dept_emp a,
    departments b,
    salaries c
WHERE
    a.dept_no = b.dept_no
        AND a.emp_no = c.emp_no
        AND a.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY a.dept_no
ORDER BY AVG(c.salary) DESC
LIMIT 1;

SELECT 
    a.emp_no,
    CONCAT(a.first_name, ' ', a.last_name) AS name,
    b.title,
    c.salary
FROM
    employees a,
    titles b,
    salaries c,
    dept_emp d
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND a.emp_no = d.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND d.dept_no = (SELECT 
            a.dept_no
        FROM
            dept_emp a,
            departments b,
            salaries c
        WHERE
            a.dept_no = b.dept_no
                AND a.emp_no = c.emp_no
                AND a.to_date = '9999-01-01'
                AND c.to_date = '9999-01-01'
        GROUP BY a.dept_no
        ORDER BY AVG(c.salary) DESC
        LIMIT 1)
ORDER BY c.salary DESC;

-- 문제6.
-- 평균 연봉이 가장 높은 부서는? 
SELECT 
    a.dept_no, b.dept_name
FROM
    dept_emp a,
    departments b,
    salaries c
WHERE
    a.dept_no = b.dept_no
        AND a.emp_no = c.emp_no
        AND a.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY a.dept_no
ORDER BY AVG(c.salary) DESC
LIMIT 1;

-- 문제7.
-- 평균 연봉이 가장 높은 직책?
SELECT 
    c.title, AVG(b.salary)
FROM
    employees a,
    salaries b,
    titles c
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
GROUP BY c.title
ORDER BY AVG(b.salary) DESC
LIMIT 1;

-- 문제8.
-- 현재 자신의 매니저보다 높은 연봉을 받고 있는 직원은?
-- 부서이름, 사원이름, 연봉, 매니저 이름, 메니저 연봉 순으로 출력합니다.
SELECT 
    e.dept_name,
    CONCAT(f.first_name, ' ', f.last_name) AS name,
    g.salary,
    CONCAT(a.first_name, ' ', a.last_name) AS manager_name,
    b.salary AS manager_salary
FROM
    employees a,
    salaries b,
    dept_manager c,
    dept_emp d,
    departments e,
    employees f,
    salaries g
WHERE
    a.emp_no = b.emp_no
        AND a.emp_no = c.emp_no
        AND c.dept_no = d.dept_no
        AND d.dept_no = e.dept_no
        AND d.emp_no = f.emp_no
        AND f.emp_no = g.emp_no
        AND b.to_date = '9999-01-01'
        AND c.to_date = '9999-01-01'
        AND d.to_date = '9999-01-01'
        AND g.to_date = '9999-01-01'
        AND b.salary < g.salary;
    
