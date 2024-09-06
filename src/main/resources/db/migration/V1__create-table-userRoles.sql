CREATE TABLE user_roles (
    id INT AUTO_INCREMENT PRIMARY KEY,
    role_name VARCHAR(50) UNIQUE NOT NULL
);

INSERT INTO user_roles (role_name) VALUES ('CLIENT'), ('SUPPLIER');
