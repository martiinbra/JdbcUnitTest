DELIMITER //

-- Listar todos los clientes
CREATE PROCEDURE Client_list_all()
BEGIN
    SELECT * FROM Client;
END//

-- Listar todos los productos
CREATE PROCEDURE Product_list_all()
BEGIN
    SELECT * FROM Product;
END//

-- Crear un cliente
CREATE PROCEDURE Client_create(
    IN name varchar(255),
    IN phone varchar(255)
)
BEGIN
    INSERT INTO Client (name, phone)
    VALUES (name, phone);
END//

-- Crear un producto
CREATE PROCEDURE Product_create(
    IN description varchar(255),
    IN cost decimal(19,2)
)
BEGIN
    INSERT INTO Product (description, cost)
    VALUES (description, cost);
END//

-- Obtener un cliente por id
CREATE PROCEDURE Client_get_by_id(
    IN idClient int
)
BEGIN
    SELECT * FROM Client
    WHERE id = idClient;
END//

-- Obtener un producto por id
CREATE PROCEDURE Product_get_by_id(
    IN idProduct int
)
BEGIN
    SELECT * FROM Product
    WHERE id = idProduct;
END//

-- Crear una nueva Sale con sus respectivos SaleDetail y Product
CREATE PROCEDURE Sale_Details_create(
    IN idClient int,
    IN products_details JSON
)
BEGIN
    DECLARE subtotal DECIMAL(19,2);
    DECLARE total DECIMAL(19,2);
    DECLARE detail_count INT DEFAULT 0;
    DECLARE product_id INT;
    DECLARE quantity INT;
    DECLARE cost DECIMAL(19,2);
    DECLARE description VARCHAR(255);

    -- Insertar la nueva venta
    INSERT INTO Sale (idClient, total)
    VALUES (idClient, 0);
    SET @sale_id = LAST_INSERT_ID();

    -- Recorrer los detalles de los productos y calcular el subtotal y total de la venta
    SELECT JSON_LENGTH(products_details) INTO detail_count;
    WHILE detail_count > 0 DO
            SELECT JSON_EXTRACT(products_details, CONCAT('$[', detail_count - 1, '].product_id')) INTO product_id;
            SELECT JSON_EXTRACT(products_details, CONCAT('$[', detail_count - 1, '].quantity')) INTO quantity;
            SELECT cost, description FROM Product WHERE id = product_id;
            SET subtotal = quantity * cost;
            SET total = total + subtotal;

            -- Insertar el detalle de la venta
            INSERT INTO SaleDetail (idSale, idProduct, quantity, subtotal)
            VALUES (@sale_id, product_id, quantity, subtotal);

            SET detail_count = detail_count - 1;
        END WHILE;

    -- Actualizar el total de la venta
    UPDATE Sale SET total = total WHERE id = @sale_id;

    -- Devolver la información de la venta creada
    SELECT s.id AS sale_id, s.idClient, s.total, sd.id AS saledetail_id, sd.idProduct, sd.quantity, sd.subtotal, p.description, p.cost
    FROM Sale AS s
             INNER JOIN SaleDetail AS sd ON s.id = sd.idSale
             INNER JOIN Product AS p ON sd.idProduct = p.id
    WHERE s.id = @sale_id;
END//

-- Listar todas las Sale con sus respectivos SaleDetail y Product
CREATE PROCEDURE Sales_Details_list_all()
BEGIN
    SELECT s.id AS sale_id, s.idClient, s.total, sd.id AS saledetail_id, sd.idProduct, sd.quantity, sd.subtotal, p.description, p.cost
    FROM Sale AS s
             INNER JOIN SaleDetail AS sd ON s.id = sd.idSale
             INNER JOIN Product AS p ON sd.idProduct = p.id;
END//

DELIMITER ;