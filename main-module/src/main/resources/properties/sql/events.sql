drop table EVENTS IF EXISTS;

CREATE TABLE EVENTS
(
    ID INT,
    NAME VARCHAR(255)
);

INSERT INTO EVENTS (ID, NAME) VALUES (1, 'England championship');
INSERT INTO EVENTS (ID, NAME) VALUES (2, 'England prime league');