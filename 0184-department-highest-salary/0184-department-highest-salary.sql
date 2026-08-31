select d.name as Department,
e.name as Employee,
e.salary as Salary
from Employee e,Department d
where e.departmentId=d.id
AND e.salary=(select max(e2.salary)
from employee e2
where e.departmentId=e2.departmentId);