CREATE TABLE CUSTOMER (
  id SERIAL PRIMARY KEY,
  ADDRESS_LINE_ONE VARCHAR(100) NOT  NULL,
  ADDRESS_LINE_TWO VARCHAR(50) NOT  NULL,
  CITY VARCHAR(50) DEFAULT NULL,
  EMAIL VARCHAR(50) DEFAULT NULL,
  FIRST_NAME VARCHAR(50) DEFAULT NULL,
  LAST_NAME VARCHAR(50) DEFAULT NULL,
  PHONE_NUMBER VARCHAR(50) DEFAULT NULL,
  STATE VARCHAR(50) DEFAULT NULL,
  ZIP_CODE VARCHAR(50) DEFAULT NULL,
);

INSERT INTO CUSTOMER(ADDRESS_LINE_ONE, ADDRESS_LINE_TWO, CITY, EMAIL, FIRST_NAME, LAST_NAME, PHONE_NUMBER, STATE, ZIP_CODE)
VALUES('Address 1', 'Address 2', 'W-WA 1', 'E@MAIL 1', 'JAN 1', 'NOWAK 1', '666999001', 'PL 1', '15-001'),
('Address 1', 'Address 2', 'W-WA 2', 'E@MAIL 2', 'JAN 2', 'NOWAK 2', '666999002', 'PL 2', '15-002'),
('Address 1', 'Address 2', 'W-WA 3', 'E@MAIL 3', 'JAN 3', 'NOWAK 3', '666999003', 'PL 3', '15-003'),
('Address 1', 'Address 2', 'W-WA 4', 'E@MAIL 4', 'JAN 4', 'NOWAK 4', '666999004', 'PL 4', '15-004');

CREATE TABLE PRODUCT (
  ID SERIAL PRIMARY KEY ,
  description varchar(100) NOT NULL,
  price decimal(20,2),
  image_Url varchar(100) NOT NULL
);

INSERT INTO PRODUCT(ID, description, price, image_Url)
VALUES(NULL, 'Great product 1', 20.0, 'http://img.com/prodId=1');

INSERT INTO PRODUCT(ID, description, price, image_Url)
VALUES(NULL, 'Great product 2', 20.0, 'http://img.com/prodId=1');

INSERT INTO PRODUCT(ID, description, price, image_Url)
VALUES(NULL, 'Great product 3', 20.0, 'http://img.com/prodId=1');

INSERT INTO PRODUCT(ID, description, price, image_Url)
VALUES(NULL, 'Great product 4', 20.0, 'http://img.com/prodId=1');