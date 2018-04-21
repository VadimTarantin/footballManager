drop table TASKS IF EXISTS;

CREATE TABLE TASKS
(
    ID INT,
    SESSION_ID INT,
    ROUND_ID INT,
    COMPETITION_ID INT,
    TYPE VARCHAR(255),
    PARSER_ID INT,
    EVENT_ID INT
);

INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (1, 14218, 42070, 70, 'competition_wide_table', 1, 1);
INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (1, 14218, 42070, 70, 'competition_form_table', 2, 1);
INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (1, 14218, 42070, 70, 'competition_overunder_table', 3, 1);

INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (2, 14029, 41547, 8, 'competition_wide_table', 1, 2);
INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (2, 14029, 41547, 8, 'competition_form_table', 2, 2);
INSERT INTO TASKS (ID, SESSION_ID, ROUND_ID, COMPETITION_ID, TYPE, PARSER_ID, EVENT_ID)
VALUES (2, 14029, 41547, 8, 'competition_overunder_table', 3, 2);