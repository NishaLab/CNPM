SELECT c.name, c.cccd, c.phone, c.address, ifnull(x.days,0) as days, ifnull(x.income,0) as income
from
(SELECT a.id, a.tblClient_id,
		(SELECT DATEDIFF(LEAST(b.returnDate, "2020-05-30"), GREATEST(b.receivedDate,"2020-05-10")) FROM cnpm7.tblBookedCar b
			WHERE b.returnDate > "2020-05-10" AND b.receivedDate < "2020-05-30" AND b.tblContract_id = a.id  ) as days,
		(SELECT (datediff(least(b.returnDate,"2020-05-30"),greatest(b.receivedDate,"2020-05-10"))/DATEDIFF(b.returnDate,b.receivedDate)*b.totalprice) + b.penAmount FROM cnpm7.tblBookedCar b
			WHERE b.tblContract_id = a.id AND b.returnDate > "2020-05-10" AND b.receivedDate < "2020-05-30" ) as income
from cnpm7.tblContract a 
ORDER BY income DESC) as x, cnpm7.tblClient c
where X.tblClient_id = c.id