create table if not exists Produce (
    id varchar(6) not null,
    name varchar(40) not null,
    type varchar(10) not null,
    price decimal(8,2) not null,
    primary key (id)
    );

create table if not exists Harvest_Order (
    id identity,
    customer_name varchar(50) not null,
    customer_street varchar(50) not null,
    customer_city varchar(50) not null,
    customer_state varchar(2) not null,
    customer_zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );

create table if not exists Box (
    id identity,
    name varchar(50) not null,
    harvest_order bigint not null,
    harvest_order_key bigint not null,
    created_at timestamp not null,
    vegetable_id varchar(6) not null,
    fruit_id varchar(6) not null,
    grain_id varchar(6) not null,
    dairy_id varchar(6) not null,
    protein_id varchar(6) not null
    );

alter table Box add foreign key (harvest_order) references Harvest_Order(id);
alter table Box add foreign key (vegetable_id) references Produce(id);
alter table Box add foreign key (fruit_id) references Produce(id);
alter table Box add foreign key (grain_id) references Produce(id);
alter table Box add foreign key (dairy_id) references Produce(id);
alter table Box add foreign key (protein_id) references Produce(id);