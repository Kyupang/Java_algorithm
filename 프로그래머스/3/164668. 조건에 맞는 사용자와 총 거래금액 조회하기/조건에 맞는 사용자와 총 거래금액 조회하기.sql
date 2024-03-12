-- 코드를 입력하세요
SELECT U.USER_ID, U.NICKNAME, sum(B.price) as TOTAL_SALES
from USED_GOODS_BOARD as B
inner join USED_GOODS_USER as U
on U.USER_ID = B.WRITER_ID
where B.STATUS = "DONE" # 완료된
group by B.WRITER_ID
having TOTAL_SALES >= 700000 # 완료 게시글 금액이 70만원 이상인 
order by TOTAL_SALES asc