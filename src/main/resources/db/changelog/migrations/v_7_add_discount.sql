--liquibase formatted sql
--changeset ldhn:7
ALTER TABLE delivery ADD price_with_discount DECIMAL NULL;

UPDATE delivery set price_with_discount=0 where 1=1;
