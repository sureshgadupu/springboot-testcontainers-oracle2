
ALTER SEQUENCE hibernate_sequence RESTART start WITH 10;

DELETE FROM employee;
DELETE FROM department;

INSERT INTO DEPARTMENT(id,name) VALUES(100,'HR');
INSERT INTO DEPARTMENT(id,name) VALUES(101,'PDE');
INSERT INTO DEPARTMENT(id,name) VALUES(102,'Marketing');

INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(1,'Alex','Bonilla','M',TO_DATE('1990-12-07','YYYY-MM-DD'),TO_DATE('2011-04-01','YYYY-MM-DD'),100);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(2,'Duke','Stacey','M',TO_DATE('1989-07-11','YYYY-MM-DD'),TO_DATE('2012-08-21','YYYY-MM-DD'),100);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(3,'Hayley','Drake','M',TO_DATE('1992-10-01','YYYY-MM-DD'),TO_DATE('2007-07-06','YYYY-MM-DD'),101);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(4,'Nancie','Beasley','M',TO_DATE('1978-02-21','YYYY-MM-DD'),TO_DATE('2003-03-03','YYYY-MM-DD'),101);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(5,'Wyatt','Holder','M',TO_DATE('1994-12-01','YYYY-MM-DD'),TO_DATE('2016-02-15','YYYY-MM-DD'),101);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(6,'Tobey','Drake','M',TO_DATE('1992-10-01','YYYY-MM-DD'),TO_DATE('2014-06-11','YYYY-MM-DD'),102);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(7,'Marvin','Hope','F',TO_DATE('1978-02-21','YYYY-MM-DD'),TO_DATE('2003-09-10','YYYY-MM-DD'),102);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(8,'Ibrar','Garcia','F',TO_DATE('1994-12-01','YYYY-MM-DD'),TO_DATE('2004-12-21','YYYY-MM-DD'),102);
INSERT INTO employee(id,first_name,last_name,gender,birth_date,hire_date,department_id) VALUES(9,'Ibrar1','Garcia1','F','01-DEC-1994',TO_DATE('2004-12-21','YYYY-MM-DD'),102);

