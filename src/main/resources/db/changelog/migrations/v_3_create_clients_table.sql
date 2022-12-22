--liquibase formatted sql
--changeset ldhn:3
CREATE TABLE client (
    id VARCHAR(26) NOT NULL PRIMARY KEY,
    clients_idnumber VARCHAR(20) NOT NULL,
    clients_name VARCHAR(50) NOT NULL
);

ALTER TABLE client ADD CONSTRAINT client_identification_unique UNIQUE (clients_idnumber);