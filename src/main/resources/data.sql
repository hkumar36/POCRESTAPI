DROP TABLE IF EXISTS product;
 
CREATE TABLE product( 
   id BIGINT PRIMARY KEY, 
   brand VARCHAR(50) NOT NULL, 
   size VARCHAR(20), 
   price BIGINT 
);

INSERT INTO product (id, brand, size, price) VALUES (1, 'Cello','M', 2000);
INSERT INTO product (id, brand, size, price) VALUES (2, 'Apple','M', 3000);
INSERT INTO product (id, brand, size, price) VALUES (3, 'Cello', 'XL',1200);
INSERT INTO product (id, brand, size, price) VALUES (4, 'MicroSoft','S', 1600);