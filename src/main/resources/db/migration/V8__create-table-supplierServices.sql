CREATE TABLE SupplierServices (
    supplier_id INT,
    service_id INT,
    PRIMARY KEY (supplier_id, service_id),
    FOREIGN KEY (supplier_id) REFERENCES Suppliers(id),
    FOREIGN KEY (service_id) REFERENCES Services(id)
);
