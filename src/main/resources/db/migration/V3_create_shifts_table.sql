CREATE TABLE shifts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    shift_date VARCHAR(255) not null,
    shift_day VARCHAR(255) not null,
    start_time VARCHAR(255) not null,
    end_time VARCHAR(255) not null,
    staff VARCHAR(255) not null,
    shift_position VARCHAR(255) not null
 );

