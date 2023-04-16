-- Crear la tabla Client
CREATE TABLE IF NOT EXISTS Client (
  id INT(11) NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL,
  phone VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Crear la tabla Sale
CREATE TABLE IF NOT EXISTS Sale (
  id INT(11) NOT NULL AUTO_INCREMENT,
  idClient INT(11) NOT NULL,
  total DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idClient) REFERENCES Client(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB;

-- Crear la tabla Product
CREATE TABLE IF NOT EXISTS Product (
  id INT(11) NOT NULL AUTO_INCREMENT,
  description VARCHAR(255) NOT NULL,
  cost DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB;

-- Crear la tabla SaleDetail
CREATE TABLE IF NOT EXISTS SaleDetail (
  id INT(11) NOT NULL AUTO_INCREMENT,
  idSale INT(11) NOT NULL,
  idProduct INT(11) NOT NULL,
  quantity INT(11) NOT NULL,
  subtotal DECIMAL(19,2) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (idSale) REFERENCES Sale(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  FOREIGN KEY (idProduct) REFERENCES Product(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
) ENGINE=InnoDB;

