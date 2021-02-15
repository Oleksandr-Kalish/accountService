CREATE TABLE IF NOT EXISTS account
(
    id             uuid,
    email          varchar(320),
    first_name     varchar(50),
    last_name      varchar(50),
    birth_date     date,
    marital_status varchar(20),
    PRIMARY KEY (id)
);
