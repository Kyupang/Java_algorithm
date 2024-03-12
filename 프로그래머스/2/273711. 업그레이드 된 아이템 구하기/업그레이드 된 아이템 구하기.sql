-- 코드를 작성해주세요
select i.ITEM_ID,i.ITEM_NAME, i.RARITY
from ITEM_INFO i
inner join ITEM_TREE t
on i.ITEM_ID = t.ITEM_ID
where t.PARENT_ITEM_ID in (select ii.ITEM_ID
                    from ITEM_INFO ii
                    where ii.RARITY = "RARE")
order by i.ITEM_ID desc