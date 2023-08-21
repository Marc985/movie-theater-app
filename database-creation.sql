create database cinema_room;
\c cinema_room
create table room(
    id_room serial primary key,
    room_name varchar(50),
    capacity int
);
create table cinema(
    id_cinema serial primary key,
    title varchar(50),
    release_date date,
    duration time

);
create table project(
    id_project serial primary key,
    project_date date,
    hour_project time,
    rate float,
    id_cinema int references cinema(id_cinema),
    id_room int references room(id_room)
);
create table customer(
    id_customer serial primary key,
    customer_first_name varchar(100),
    customer_last_name varchar(100),
    email varchar(80)
);
create table watch(
    id_watch serial primary key,
    id_cinema int references cinema(id_cinema),
    id_customer int references customer(id_customer)

);