CREATE TABLE Suppliers (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    nit VARCHAR(50) NOT NULL,
    service VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    address VARCHAR(255),
    city_id INT,
    status TINYINT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES Clients(id),
    FOREIGN KEY (city_id) REFERENCES Cities(id)
);
