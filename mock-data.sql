-- Insérer des données fictives dans la table 'room'
INSERT INTO room (room_name, capacity)
VALUES
  ('Room A', 50),
  ('Room B', 40),
  ('Room C', 30),
  ('Room D', 60),
  ('Room E', 45),
  ('Room F', 35),
  ('Room G', 55),
  ('Room H', 42),
  ('Room I', 28),
  ('Room J', 70),
  ('Room K', 38),
  ('Room L', 47),
  ('Room M', 52),
  ('Room N', 31),
  ('Room O', 56),
  ('Room P', 41),
  ('Room Q', 49),
  ('Room R', 63),
  ('Room S', 27),
  ('Room T', 59);

-- Insérer des données fictives dans la table 'cinema'
INSERT INTO cinema (title, release_date, duration)
VALUES
  ('spider-man', '2023-08-01', '02:00:00'),
  ('harry potter', '2023-08-15', '01:30:00'),
  ('annabelle', '2023-09-05', '02:15:00'),
  ('barbie', '2023-08-10', '01:45:00'),
  ('iron man', '2023-08-20', '02:30:00'),
  ('doctor strange', '2023-09-01', '01:50:00'),
  ('superman', '2023-09-10', '02:10:00'),
  ('roi Lion', '2023-08-25', '02:20:00'),
  ('conjuring', '2023-09-15', '01:40:00'),
  ('the nun', '2023-09-20', '02:25:00'),
   ('avatar', '2023-08-05', '02:10:00'),
  ('jurassic park', '2023-08-12', '02:20:00'),
  ('inception', '2023-08-18', '02:45:00'),
  ('toy story', '2023-08-08', '01:55:00'),
  ('frozen', '2023-08-28', '01:40:00'),
  ('finding nemo', '2023-09-02', '01:50:00'),
  ('shrek', '2023-09-10', '02:05:00'),
  ('madagascar', '2023-08-23', '01:30:00'),
  ('despicable me', '2023-09-15', '01:42:00'),
  ('zootopia', '2023-09-22', '02:18:00');

-- Insérer des données fictives dans la table 'project'
INSERT INTO project (project_date, hour_project, rate, id_room, id_cinema)
VALUES
  ('2023-08-20', '18:00:00', 1, 1, 4.5),
  ('2023-08-21', '15:30:00', 2, 2, 3.8),
  ('2023-08-22', '20:15:00', 3, 3, 4.2),
  ('2023-08-23', '19:45:00', 4, 4, 4.0),
  ('2023-08-24', '17:30:00', 5, 5, 3.5),
  ('2023-08-25', '21:00:00', 6, 6, 4.7),
  ('2023-08-26', '14:45:00', 7, 7, 4.3),
  ('2023-08-27', '16:30:00', 8, 8, 3.9),
  ('2023-08-28', '22:00:00', 9, 9, 4.1),
  ('2023-08-29', '18:45:00', 10, 10, 3.6),
  ('2023-08-30', '17:15:00', 11, 11, 3.9),
  ('2023-08-31', '19:30:00', 12, 12, 4.6),
  ('2023-09-01', '16:20:00', 13, 13, 4.0),
  ('2023-09-02', '21:45:00', 14, 14, 4.3),
  ('2023-09-03', '14:50:00', 15, 15, 3.7),
  ('2023-09-04', '22:30:00', 16, 16, 4.8),
  ('2023-09-05', '18:25:00', 17, 17, 3.5),
  ('2023-09-06', '20:40:00', 18, 18, 4.2),
  ('2023-09-07', '15:55:00', 19, 19, 3.8),
  ('2023-09-08', '23:00:00', 20, 20, 4.1);
  

-- Insérer des données fictives dans la table 'customer'
INSERT INTO customer (customer_first_name, customer_last_name, email)
VALUES
  ('John', 'Doe', 'john.doe@example.com'),
  ('Jane', 'Smith', 'jane.smith@example.com'),
  ('Michael', 'Johnson', 'michael.johnson@example.com'),
  ('Emily', 'Brown', 'emily.brown@example.com'),
  ('Daniel', 'Wilson', 'daniel.wilson@example.com'),
  ('Sarah', 'Jones', 'sarah.jones@example.com'),
  ('David', 'Martinez', 'david.martinez@example.com'),
  ('Jessica', 'Davis', 'jessica.davis@example.com'),
  ('James', 'Miller', 'james.miller@example.com'),
  ('Olivia', 'Taylor', 'olivia.taylor@example.com'),
   ('William', 'Brown', 'william.brown@example.com'),
  ('Ava', 'Wilson', 'ava.wilson@example.com'),
  ('Liam', 'Johnson', 'liam.johnson@example.com'),
  ('Sophia', 'Jones', 'sophia.jones@example.com'),
  ('Noah', 'Davis', 'noah.davis@example.com'),
  ('Isabella', 'Martinez', 'isabella.martinez@example.com'),
  ('Ethan', 'Miller', 'ethan.miller@example.com'),
  ('Oliver', 'Taylor', 'oliver.taylor@example.com'),
  ('Amelia', 'Smith', 'amelia.smith@example.com'),
  ('Mia', 'Williams', 'mia.williams@example.com');

-- Insérer des données fictives dans la table 'watch'
INSERT INTO watch (id_cinema, id_customer)
VALUES
  (20, 1),
  (3, 2),
  (5, 3),
  (5, 4),
  (20, 5),
  (3, 6),
  (6, 7),
  (5, 8),
  (8, 9),
  (9, 10),
    (6, 11),
  (1, 12),
  (3, 13),
  (5, 14),
  (2, 15),
  (18, 16),
  (20, 17),
  (5, 18),
  (3,19),
  (1, 20);
