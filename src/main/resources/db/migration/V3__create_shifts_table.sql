CREATE TABLE shifts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) not null,
    staff_name VARCHAR(255) not null,
    detail VARCHAR(255) not null,
    status VARCHAR(225) not null,
    created_time VARCHAR(255) not null,
    finish_time VARCHAR(255),
    due_time VARCHAR(255) not null
 );

