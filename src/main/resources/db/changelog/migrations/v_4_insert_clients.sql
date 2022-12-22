--liquibase formatted sql
--changeset ldhn:4
INSERT INTO client(id, clients_idnumber, clients_name)
VALUES ('01GMXC60SFSW382R934AMY73CY', '001010', 'Juan Carlos Bodoque'),
       ('01GMXC60SF58XMSQ56CHRW03B0', '115001', 'Antoine Exuperi'),
       ('01GMXC60SF8XX3P8903DX20PR6', '884401', 'Peter Norbyng'),
       ('01GMXC60SF138JEHEDDK3Z6D4M', '77A444', 'Cliente numero cuatro');