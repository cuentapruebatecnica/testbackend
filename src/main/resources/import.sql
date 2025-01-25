alter table product AUTO_INCREMENT = 1;

insert into category (name) values("Electronicos");
insert into category (name) values("Ropa");
insert into category (name) values("Electrodomesticos");
insert into category (name) values("relojes");
insert into category (name) values("herramienta");

insert into product (name, description, price, category_id) values('PC MSI', 'Laptop msi i5', 20000, 1);
insert into product (name, description, price, category_id) values('Camiseta nirvana', 'Camisa de algodon', 400, 2);
insert into product (name, description, price, category_id) values("Licuadora", 'licuadora turbo', 700, 3);
insert into product (name, description, price, category_id) values('CASIO', 'Reloj casio', 3000, 4);
insert into product (name, description, price, category_id) values('Taladro', 'Taladro pesado', 1500, 5);