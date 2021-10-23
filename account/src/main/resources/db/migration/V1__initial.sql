create table accounts
(
    id              uuid         not null,
    balance         float8, /* null if type = user */
    number          varchar(255) not null,
    type            varchar(255),
    organization_id uuid, /* null if type = user */
    user_id         uuid, /* null if type = organization */
    primary key (id)
);
create table cards
(
    id         uuid         not null,
    account_id uuid         not null,
    balance    float8       not null,
    number     varchar(255) not null,
    primary key (id)
);
create table transactions
(
    id              uuid   not null,
    amount          float8 not null,
    from_card       uuid   not null,
    to_card         uuid, /* null if type = organization */
    to_organization uuid, /* null if type = user */
    type            varchar(255),
    primary key (id)
);