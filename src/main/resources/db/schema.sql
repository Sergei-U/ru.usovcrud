CREATE TABLE BANK
(
    ID SERIAL PRIMARY KEY NOT NULL
);

CREATE TABLE CLIENT
(
    ID               SERIAL PRIMARY KEY NOT NULL,
    FIRST_NAME       VARCHAR(220)       NOT NULL,
    LAST_NAME        VARCHAR(220)       NOT NULL,
    THIRD_NAME       VARCHAR(220)       NOT NULL,
    TELEPHONE_NUMBER INTEGER            NOT NULL,
    EMAIL            VARCHAR(220)       NOT NULL,
    SERIAL_PASSPORT  INTEGER            NOT NULL,
    NUMBER_PASSPORT  INTEGER            NOT NULL
);

CREATE TABLE CREDIT
(
    ID                SERIAL PRIMARY KEY NOT NULL,
    CREDIT_NAME       VARCHAR(220)       NOT NULL,
    CREDIT_LIMIT      INTEGER            NOT NULL,
    CREDIT_VALIDITY   INTEGER            NOT NULL,
    CREDIT_RATE       INTEGER            NOT NULL,
    CREDIT_START_DATE DATE               NOT NULL
);
create table credit_offer
(
    id               uuid primary key not null,
    client_id        uuid references client (id),
    credit_id        uuid references credit (id),
    amount           bigint           not null,
    payment_schedule varchar(2048)
)
