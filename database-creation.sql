create database cinema_room;
\c cinema_room
--one room can project many cinema but not on the same time--
--one room have many seat
create table room(
    id_room serial primary key,
    room_name varchar(50),
    capacity int
);
--one cinema can be projected to many room
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
--one customer can book many seat 
create table customer(
    id_customer serial primary key,
    customer_first_name varchar(100),
    customer_last_name varchar(100),
    email varchar(80)
);
--One seat can be booked by multiple customers, but for different showtimes.
create table seat(
    id_seat serial primary key,
    seat_number int,
    "type" varchar(7) check ("type"='VIP' or "type"='normal'),
    id_room int references room(id_room)

);
create table reservation(
    id_reservation serial primary key,
    reservation_date date,
    id_seat int references seat(id_seat),
    id_customer int references customer(id_customer)
);
