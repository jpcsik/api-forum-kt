create table topic(
    id bigint not null auto_increment,
    title varchar(50) not null,
    message varchar(400) not null,
    created_at datetime not null,
    course_id bigint not null,
    author_id bigint not null,
    status varchar(50) not null,
    primary key(id),
    foreign key(course_id) references course(id),
    foreign key(author_id) references author(id)
);