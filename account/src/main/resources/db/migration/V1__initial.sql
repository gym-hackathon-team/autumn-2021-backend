CREATE TABLE ACCOUNTS
(
    ID              UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    NUMBER          VARCHAR(20) NOT NULL,
    TYPE            VARCHAR(255), /* TODO ENUM USER/ORGANIZATION this */
    USER_ID         UUID, /* TODO Nullable check */ /* null if type = organization */
    ORGANIZATION_ID UUID, /* TODO Nullable check */ /* null if type = user */
    BALANCE         FLOAT /* TODO Nullable check */ /* null if type = user */
);

CREATE TABLE CARDS
(
    ID         UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    NUMBER     VARCHAR(16) NOT NULL,
    BALANCE    FLOAT       NOT NULL,
    ACCOUNT_ID UUID        NOT NULL
);

CREATE TABLE PAYMENTS
(
    ID         UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    AMOUNT     FLOAT NOT NULL,
    FROM_CARD  UUID  NOT NULL,
    TYPE       VARCHAR(255), /* TODO ENUM USER/ORGANIZATION This */
    TO_CARD    UUID, /* TODO Nullable check */ /* null if type = organization */
    TO_ACCOUNT UUID /* TODO Nullable check */ /* null if type = user */
);