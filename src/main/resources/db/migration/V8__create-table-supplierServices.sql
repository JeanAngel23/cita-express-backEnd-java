CREATE TABLE supplier_services (
    supplier_id INT,
    service_id INT,
    PRIMARY KEY (supplier_id, service_id),
    FOREIGN KEY (supplier_id) REFERENCES suppliers(id),
    FOREIGN KEY (service_id) REFERENCES services(id)
);
