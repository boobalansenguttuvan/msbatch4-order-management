delete from items;
delete from orders;

insert into orders(id, name) values(1,'Order1');
insert into orders(id, name) values(2,'Order2');
insert into orders(id, name) values(3,'Order3');

insert into items(id, name, quantity, price, order_id) values(1,'item1', 10, 120, 1);
insert into items(id, name, quantity, price, order_id) values(2,'item2', 80, 50, 1);
insert into items(id, name, quantity, price, order_id) values(3,'item3', 100, 11, 1);
insert into items(id, name, quantity, price, order_id) values(4,'item4', 300, 25, 2);
insert into items(id, name, quantity, price, order_id) values(5,'item5', 20, 33, 2);
insert into items(id, name, quantity, price, order_id) values(6,'item6', 2, 20, 3);
insert into items(id, name, quantity, price, order_id) values(7,'item7', 1, 12, 3);