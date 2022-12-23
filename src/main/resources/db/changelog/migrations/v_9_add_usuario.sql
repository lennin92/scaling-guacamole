--liquibase formatted sql
--changeset ldhn:9
CREATE TABLE "user" (
    user_name VARCHAR(26) NOT NULL PRIMARY KEY,
    password VARCHAR(50) NOT NULL
);

INSERT INTO "user"(user_name, password)
    values ('PRUEBA', 'PRUEBA123');