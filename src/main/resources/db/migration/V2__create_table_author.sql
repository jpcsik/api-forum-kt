create table author(
    id bigint not null auto_increment,
    name varchar(50) not null,
    email varchar(50) not null,
    primary key(id)
);

INSERT INTO AUTHOR(ID, NAME, EMAIL) VALUES (1, 'Michael Scott', 'michael@email.com');
