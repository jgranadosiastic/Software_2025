create table author (
    id uuid primary key,
    email varchar(50),
    name varchar(50) not null,
    profession varchar(50) not null,
    about varchar(50)
);

create table article (
    id uuid primary key,
    title varchar(50) not null,
    description varchar(50),
    author_email varchar(50) not null references author(id),
    text varchar(3000) not null,
    publication_date date not null,
    active boolean not null,
    visible boolean not null
);

