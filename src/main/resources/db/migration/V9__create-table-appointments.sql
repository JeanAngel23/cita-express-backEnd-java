CREATE TABLE appointments (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_id INT,
    supplier_id INT,
    service_id INT,
    appointment_date DATETIME NOT NULL,
    status ENUM('PENDING', 'CONFIRMED', 'COMPLETED', 'CANCELED') DEFAULT 'PENDING',
    address VARCHAR(255),
    city_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (client_id) REFERENCES clients(id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id),
    FOREIGN KEY (service_id) REFERENCES services(id),
    FOREIGN KEY (city_id) REFERENCES cities(id)
);
