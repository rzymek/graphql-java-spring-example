INSERT INTO store(
 	id, address, name, owner)
 	VALUES (1, 'Hackensack', 'Test', 1);
INSERT INTO store(
 	id, address, name, owner)
 	VALUES (2, 'Washington', 'Walmart', 1);

INSERT INTO product(
    id, description, name, price, score, store_id)
    VALUES (1, 'test product description', 'test product name', 10.99, 4.5, 1);