--create table users1 (
--  username varchar(256),
--  password varchar(256),
--  enabled boolean
--);
create table users(
username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(500) not null,
enabled boolean not null,
phone varchar_ignorecase(500) not null,
email varchar_ignorecase(500) not null
);
create table authorities (
username varchar_ignorecase(50) not null,
authority varchar_ignorecase(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);

create table permissions (
authority varchar_ignorecase(50) not null,
url varchar_ignorecase(500) not null,
constraint fk_permissions_authorities foreign key(authority) references authorities(authority)
);

create unique index ix_auth_authority on permissions (authority,url);