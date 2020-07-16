-- hive
-- Table:  Person
-- Column Name 	Type
-- PersonId	int
-- FirstName	varchar
-- LastName	varchar
-- PersonId is the primary key column for this table( Person ).

-- Table: Address
-- Column Name	Type
-- AddressId	int
-- PersonId	int
-- City	varchar
-- State 	varchar
--
-- AdressId is the primary key column for this table ( Address)
--
-- Write a SQL query for a report that provides the following information for each person in the Person table,
-- regardless if there is an address for each of those people:
-- FirstName,  LastName, City,  State
create table person
(
    pid        int,
    first_name string,
    last_name  string
);
create table address
(
    aid   int,
    pid   int,
    city  string,
    state string
);
select p.first_name, p.last_name, a.city, a.state
from person p
         left join address a on p.pid = a.pid;

-- 编写一个SQL查询，获取Employee表中的第二高的薪水(Salary)
-- Id	Salary
-- 1	100
-- 2	200
-- 3	300
-- 例如上述Employee表，SQL查询应该返回200作为第二高的薪水，如果不存在第二高的薪水，那么查询应该返回null
-- SecondHighestSalary
-- 200
create table employee
(
    id     int,
    salary double
);
select t.salary
from (
         select id, salary, rank() over (ORDER BY salary desc) rank
         from employee
     ) t
where t.rank = 2;
