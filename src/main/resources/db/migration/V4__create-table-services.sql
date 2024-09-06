CREATE TABLE services (
    id INT AUTO_INCREMENT PRIMARY KEY,
    service_name VARCHAR(100) UNIQUE NOT NULL,
    description TEXT
);
