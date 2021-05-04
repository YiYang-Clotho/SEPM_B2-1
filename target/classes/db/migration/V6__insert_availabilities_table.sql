INSERT INTO availabilities(start_time, end_time, staff_name) VALUES ('Mon April 12 11:30:00 AEST 2021', 'Wed April 14 13:00:00 AEST 2021', (SELECT name from users where id = 1));
INSERT INTO availabilities(start_time, end_time, staff_name) VALUES ('Mon April 12 11:30:00 AEST 2021', 'Wed April 14 13:00:00 AEST 2021', (SELECT name from users where id = 2));
INSERT INTO availabilities(start_time, end_time, staff_name) VALUES ('Mon April 12 11:30:00 AEST 2021', 'Wed April 14 13:00:00 AEST 2021', (SELECT name from users where id = 3));
INSERT INTO availabilities(start_time, end_time, staff_name) VALUES ('Mon April 12 11:30:00 AEST 2021', 'Wed April 14 13:00:00 AEST 2021', (SELECT name from users where id = 4));
