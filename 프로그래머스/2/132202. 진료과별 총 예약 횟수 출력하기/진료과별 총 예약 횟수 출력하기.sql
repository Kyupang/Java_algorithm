select MCDP_CD as "진료과코드", count (*) as "5월예약건수"
from APPOINTMENT
where APNT_YMD BETWEEN '2022-05-01' AND '2022-05-31'
group by MCDP_CD
order by count(distinct(PT_NO)) asc, MCDP_CD asc