CREATE TABLE USERS
(
    ID         UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    EMAIL      VARCHAR(30) UNIQUE NOT NULL,
    PASSWORD   VARCHAR(255)       NOT NULL,
    FIRST_NAME VARCHAR(50),
    LAST_NAME  VARCHAR(50)
);