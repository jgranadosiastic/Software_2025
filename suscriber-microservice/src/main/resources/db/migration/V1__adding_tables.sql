create table subscriber (
    id UUID primary key,
    email varchar(50) not null,
    name varchar(50) not null
);

create table subscription (
    subscriber_id UUID not null references subscriber(id),
    author_id UUID not null,
    subscription_date date not null,
    with_notifications boolean not null,
    primary key(subscriber_id, author_id)

);
