create table users
(
    id         serial       not null primary key,
    first_name text         not null,
    user_name  varchar(256) not null
);
