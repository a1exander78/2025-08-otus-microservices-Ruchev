DROP TABLE IF EXISTS users;
CREATE TABLE IF NOT EXISTS users (
    id bigserial,
    username varchar(16),
    first_name varchar(32),
    last_name varchar(32),
    email varchar(32),
    phone varchar(12),
    primary key (id)
);