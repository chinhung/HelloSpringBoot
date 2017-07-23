--liquibase formatted sql

--changeset chinhung:init__emp
INSERT INTO emp (first_name, last_name) VALUES ('John', 'Chen'), ('Mary', 'Lin');

--changeset chinhung:init__sys_user
INSERT INTO sys_user (user_name, password, token) VALUES ('peter', 'peterpw', 'petertoken'), ('lisa', 'lisapw', 'lisatoken');