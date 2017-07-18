drop table  if exists users;
drop table  if exists products;
drop table  if exists orders;

CREATE TABLE products(product_id INT IDENTITY PRIMARY KEY NOT NULL,product_name VARCHAR(100) NOT NULL,price INT NOT NULL);
CREATE UNIQUE INDEX products_product_id_uindex ON products (product_id);
CREATE TABLE users(user_id INT IDENTITY PRIMARY KEY NOT NULL,username VARCHAR(100) NOT NULL);
CREATE UNIQUE INDEX users_user_id_uindex ON users (user_id);
CREATE TABLE orders(order_id INT IDENTITY PRIMARY KEY NOT NULL,user_id INT NOT NULL,product_id INT NOT NULL,status INT DEFAULT 0 NOT NULL,FOREIGN KEY (user_id) REFERENCES users (user_id),FOREIGN KEY (product_id) REFERENCES products (product_id));
CREATE UNIQUE INDEX orders_order_id_uindex ON orders (order_id);
INSERT into users(username) VALUES ('jhon'), ('matew'), ('lisa'), ('eric');
INSERT into products(product_name, price) VALUES ('tea', 10), ('cofee', 15), ('cake', 7);
INSERT INTO orders(user_id, product_id, status) VALUES (1,2,0), (1,3,1), (2,1,1), (2,3,2);
