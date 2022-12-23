--liquibase formatted sql
--changeset ldhn:9

CREATE TABLE "user" (
    id VARCHAR(26) NOT NULL PRIMARY KEY,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(120) NOT NULL
);

ALTER TABLE "user" ADD CONSTRAINT user_username_unique UNIQUE (username);

INSERT INTO "user"(id, username, password)
VALUES ('01GMYESA8JEFSTKPGZEZ2TK3VY', 'USER1', '$2a$12$6x/Zv3cKqdfvXmM0VnLWmuYYhaLk8Zou6Y2CFHSvtCAjme5JuDr/u'), --passw0rd1
       ('01GMYESA8JSSH6XZPJNJ508QKQ', 'USER2', '$2a$12$iD47lCSpmTQzUyEhZkjyLuy0aXwTesIYIU1hc7c9iWahLNmQ3xbAm'), --passw_rd2
       ('01GMYESA8JYQBS2BSXBH50Z4KS', 'USER3', '$2a$09$M7QMl6ydnlssCW.s7kZc0uxRWdwzF8Hkitmfmxfr3ckl/.rv7LbOa'); --p4ssw0rd_3
