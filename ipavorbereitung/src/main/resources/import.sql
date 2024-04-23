INSERT INTO city(id, name, postal_code) VALUES('1','Männedorf','8708');
INSERT INTO city(id, name, postal_code) VALUES('2','Niederlenz','5702');
INSERT INTO city(id, name, postal_code) VALUES('3','Uetikon Am See','8707');
INSERT INTO city(id, name, postal_code) VALUES('4','Lenzburg','5600');
INSERT INTO city(id, name, postal_code) VALUES('5','Meilen','8706');


INSERT INTO contact_data(id, mail, phone_number) VALUES ('1', 'max@gmail.com', '0784548751');
INSERT INTO contact_data(id, mail, phone_number) VALUES ('2', 'mustermann@gmail.com', '0784548754');
INSERT INTO contact_data(id, mail, phone_number) VALUES ('3', 'jane@gmail.com', '0784548753');
INSERT INTO contact_data(id, mail, phone_number) VALUES ('4', 'john@gmail.com', '0784548756');
INSERT INTO contact_data(id, mail, phone_number) VALUES ('5', 'doe@gmail.com', '0784548758');

INSERT INTO address_data(id, street_name, street_number, city_id) VALUES ('1','Musterstrasse','1','1');
INSERT INTO address_data(id, street_name, street_number, city_id) VALUES ('2','Landstrasse','1','2');
INSERT INTO address_data(id, street_name, street_number, city_id) VALUES ('3','Hauptstrasse','1','3');
INSERT INTO address_data(id, street_name, street_number, city_id) VALUES ('4','Seestrasse','','4');
INSERT INTO address_data(id, street_name, street_number, city_id) VALUES ('5','Musterstrasse','','5');

INSERT INTO basic_data(id, salutation, first_name, last_name, date_of_birth, contact_data_id, address_data_id) VALUES ('1','Herr','Max','Meier','15.03.2024','1','1');
INSERT INTO basic_data(id, salutation, first_name, last_name, date_of_birth, contact_data_id, address_data_id) VALUES ('2','Herr','Martin','Mustermann','20.11.1945','2','2');
INSERT INTO basic_data(id, salutation, first_name, last_name, date_of_birth, contact_data_id, address_data_id) VALUES ('3','Frau','Jane','Doe','31.08.1987','3','3');
INSERT INTO basic_data(id, salutation, first_name, last_name, date_of_birth, contact_data_id, address_data_id) VALUES ('4','Frau','Johana','Joe','14.02.2007','4','4');
INSERT INTO basic_data(id, salutation, first_name, last_name, date_of_birth, contact_data_id, address_data_id) VALUES ('5','','Doe','David','01.01.2000','5','5');