--liquibase formatted sql
--changeset ldhn:8
ALTER TABLE delivery ADD product_quantity DECIMAL NULL;

UPDATE delivery set product_quantity=0 where 1=1;
