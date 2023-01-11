DROP TABLE IF EXISTS Employee;

create table employee (
	id INT AUTO_INCREMENT  PRIMARY KEY,
	name VARCHAR(50),
	department VARCHAR(50),
	email VARCHAR(50),
	gender VARCHAR(50),
	address VARCHAR(50)
);

create table Product (
	id INT,
	description VARCHAR(50),
	version INT,
	price DECIMAL(6,2),
	product_Id VARCHAR(50),
	image_Url VARCHAR(50)
);