-- Datos Para Client
INSERT INTO Client (name, phone)
VALUES
    ('martin', '938462745'),
    ('carola', '982645244'),
    ('claudia', '927484637'),
    ('stefania', '982546472');


-- Datos Para Product
INSERT INTO Product (description, cost)
VALUES
    ('producto Camisa de buena calidad', 100.00),
    ('producto Pantalón de calida media', 120.00),
    ('producto Mochila de alta calidad' , 250.00),
    ('producto Mesa de muy alta calidad', 750.00),
    ('producto Polo de baja calidad', 50.00),
    ('producto Short de baja calidad', 40.00),
    ('producto Saco calidad estandar', 90.00),
    ('producto Media calidad buena', 25.00);

-- Datos Para Sale
INSERT INTO Sale (idClient, total)
VALUES
    (1, 300.00),
    (4, 470.00),
    (3, 1500.00),
    (2, 460.00);

-- Datos Para SaleDetail
INSERT INTO SaleDetail (idSale, idProduct, quantity, subtotal)
VALUES
    (1,8,4, 100.00),
    (1,1,2, 200.00),
    (2,2,1, 120.00),
    (2,5,2, 100.00),
    (2,3,1, 250.00),
    (3,4,2, 1500.00),
    (4,6,7, 280.00),
    (4,7,2, 180.00);