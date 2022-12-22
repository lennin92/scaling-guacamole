--liquibase formatted sql
--changeset ldhn:1
CREATE TABLE product_type (
    id VARCHAR(26) NOT NULL PRIMARY KEY,
    product_type_name VARCHAR(50) NOT NULL
);