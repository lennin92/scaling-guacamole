--liquibase formatted sql
--changeset ldhn:5
CREATE TABLE delivery (
       id VARCHAR(26) NOT NULL PRIMARY KEY,
       client_id VARCHAR(26) NOT NULL,
       product_type_id VARCHAR(26) NOT NULL,
       registered_at TIMESTAMP WITH TIME ZONE,
       estimated_delivery_date TIMESTAMP WITH TIME ZONE,
       delivery_price DECIMAL NOT NULL
);



CREATE TABLE bill_of_landing (
       id VARCHAR(26) NOT NULL PRIMARY KEY,
       delivery_id VARCHAR(26) NOT NULL,
       shipment_port VARCHAR(50) NOT NULL,
       fleet_number VARCHAR(8) NOT NULL,
       bill_of_landing_number VARCHAR(10) NOT NULL
);



CREATE TABLE way_bill (
       id VARCHAR(26) NOT NULL PRIMARY KEY,
       delivery_id VARCHAR(26) NOT NULL,
       warehouse VARCHAR(50) NOT NULL,
       trucks_plate VARCHAR(6) NOT NULL,
       waybill_number VARCHAR(10) NOT NULL
);

ALTER TABLE bill_of_landing
    ADD CONSTRAINT bill_of_landing_delivery_fk
        FOREIGN KEY (delivery_id)
            REFERENCES delivery (id);

ALTER TABLE way_bill
    ADD CONSTRAINT way_bill_delivery_fk
        FOREIGN KEY (delivery_id)
            REFERENCES delivery (id);

ALTER TABLE delivery
    ADD CONSTRAINT delivery_client_fk
        FOREIGN KEY (client_id)
            REFERENCES client (id);

ALTER TABLE delivery
    ADD CONSTRAINT delivery_product_type_fk
        FOREIGN KEY (product_type_id)
            REFERENCES product_type (id);
