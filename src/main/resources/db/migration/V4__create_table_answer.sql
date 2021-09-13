create table answer(
    id bigint not null auto_increment,
    message varchar(400) not null,
    created_at datetime not null,
    author_id bigint not null,
    topic_id bigint not null,
    answered int(1) not null,
    primary key(id),
    foreign key(topic_id) references topic(id),
    foreign key(author_id) references author(id)
);