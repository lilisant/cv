INSERT INTO Category (name) VALUES ('Women');
INSERT INTO Category (name) VALUES ('Kids');
INSERT INTO Category (name) VALUES ('Clothes');

INSERT INTO Product (name, price) VALUES ('Jacket', 500);
INSERT INTO Product (name, price) VALUES ('Short', 300);

INSERT INTO Product_Category (products_id, categories_Id) VALUES (1, 1);
INSERT INTO Product_Category (products_id, categories_Id) VALUES (1, 2);
INSERT INTO Product_Category (products_id, categories_Id) VALUES (2, 1);

INSERT INTO User (firstname, surname, street_adress, town, email, password) VALUES ('Liliana', 'Sant', 'ad', 'sthl', 'liliana@hotmail.com','pass222' );
INSERT INTO User (firstname, surname, street_adress, town, email, password) VALUES ('Tati.', 'Sant', 'ad', 'sthl', 'tati@hotmail.com','pass222' );
INSERT INTO User (firstname, surname, street_adress, town, email, password) VALUES ('Petri', 'Sant', 'ad', 'sthl', 'petri@hotmail.com','pass222' );





