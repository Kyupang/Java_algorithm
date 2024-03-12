-- 코드를 입력하세요
SELECT YEAR(SALES_DATE) as YEAR, MONTH(SALES_DATE) as MONTH, GENDER, count(distinct i.USER_ID) as USERS
from USER_INFO i
inner join ONLINE_SALE s
on i.USER_ID = s.USER_ID
where GENDER is not null
group by YEAR, MONTH, GENDER
order by YEAR asc, MONTH asc, GENDER asc