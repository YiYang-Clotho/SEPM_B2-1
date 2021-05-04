CREATE TABLE availabilities(
    id INT PRIMARY KEY AUTO_INCREMENT,
    start_time VARCHAR(255) not null,
    end_time VARCHAR(255) not null,
    staff_name VARCHAR(255),

    foreign key(staff_name) references users(name)

 );
