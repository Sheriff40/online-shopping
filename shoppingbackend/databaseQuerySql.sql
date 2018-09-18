FOR CATEGORY

create table category (
id IDENTITY,
name VARCHAR(255),
description VARCHAR(255),
image_url VARCHAR(255),
active BOOLEAN,

constraint pk_category_id PRIMARY KEY(id) 
);

INSERT INTO category (name,description,image_url,active) VALUES ('Telivision','This is telivision','images/img1.png',true);

select * from category;


FOR USER_DETAIL

create table user_detail(
	id IDENTITY,
	first_name VARCHAR(50),
	last_name VARCHAR(50),
	role VARCHAR(50),
	enabled boolean;
	password VARCHAR(50),
	email VARCHAR(100),
	contact_no VARCHAR(50),
	CONSTRAINT pk_user_id PRIMARY KEY(id)
)

INSERT INTO user_detail (first_name,last_name,role,enabled,password,email,contact_no) 
VALUES ('Sheriff','Hussain',ADMIN,true,'admin123','sheriffhussain40@gmail.com','4428864');


create table product(
	id IDENTITY,
	code VARCHAR(50),
	name VARCHAR(50),
	brand VARCHAR(50),
	description VARCHAR(255),
	unit_price DECIMAL(10,2),
	quantity INT,
	is_active BOOLEAN,
	category_id int,
	supplier_id int,
	purchases INT DEFAULT 0,
	views INT DEFAULT 0,
	CONSTRAINT fk_product_category_id FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_product_supplier_id FOREIGN KEY (supplier_id) REFERENCES user_detail(id)
)

INSERT INTO product (name,brand,description,unit_price,quantity,is_active,category_id,supplier_id)
VALUES ('Bravo LED','Bravo','Bravo Full HD TV 1080p',85000,0,true,2,1);
