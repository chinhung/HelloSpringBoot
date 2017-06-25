--liquibase formatted sql

--changeset chinhung:init_emp
INSERT INTO emp (first_name, last_name) VALUES ('John', 'Chen'), ('Mary', 'Lin');