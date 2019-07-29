create table transaction(
id INT AUTO_INCREMENT PRIMARY KEY,
type VARCHAR(20),
description VARCHAR(50),
amount DECIMAL(10,2),
date DATE);

select * from transaction;

select SUM(amount) as SUMA_PRZYCHODÓW from transaction where type='IN';
INSERT INTO transaction (type, description, amount, date)
values('OUT','Rachunki za prąd',102.30,'2019-07-01'),
('IN','Perzent od dziadka','200','2019-06-11');

update transaction set type='IN', description='Rachunki za prąd', amount=200, date='2019-07-02' where id=2;

delete from transaction where id=1;

select SUM(amount) as SUMA_WYDATKÓW from transaction where type='OUT';
select SUM(amount) as SUMA_PRZYCHODÓW from transaction where type='IN';