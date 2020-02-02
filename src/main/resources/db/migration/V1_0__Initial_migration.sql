CREATE TABLE account (id serial NOT NULL, account_number varchar(255), created_at TIMESTAMP, account_holder_id int8, PRIMARY KEY (id));


CREATE TABLE person (id serial NOT NULL, date_of_birth date, first_name varchar(255), last_name varchar(255), PRIMARY KEY (id));


CREATE TABLE STATEMENT (id serial NOT NULL,
                                ammount float8,
                                date_time TIMESTAMP,
                                          TYPE varchar(255),
                                               account_id int8, PRIMARY KEY (id));


ALTER TABLE account ADD CONSTRAINT account_person_fk
FOREIGN KEY (account_holder_id) REFERENCES person;


ALTER TABLE STATEMENT ADD CONSTRAINT STATEMENT_account_fk
FOREIGN KEY (account_id) REFERENCES account;