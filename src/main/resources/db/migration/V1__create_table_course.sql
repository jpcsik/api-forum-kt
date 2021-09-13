create table course(
    id bigint not null auto_increment,
    name varchar(50) not null,
    category varchar(50) not null,
    primary key(id)
);

INSERT INTO COURSE(ID, NAME, CATEGORY) VALUES (1, 'Kotlin', 'Programing');
