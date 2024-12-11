-- Вставка данных в таблицу city
INSERT INTO city (display_name, created_at) VALUES
('New York', NOW()),
('Los Angeles', NOW()),
('Chicago', NOW()),
('San Francisco', NOW());

-- Вставка данных в таблицу user_profile
INSERT INTO users (first_name, last_name, username, password, created_at) VALUES
('John', 'Doe', 'johndoe', 'password123', NOW()),
('Jane', 'Smith', 'janesmith', 'password456', NOW()),
('Alice', 'Brown', 'alicebrown', 'password789', NOW()),
('Bob', 'White', 'bobwhite', 'password000', NOW());

-- Вставка данных в таблицу flight
INSERT INTO flight (departure_time, arrival_time, flight_number, price, created_at, departure_city_id, arrival_city_id) VALUES
(NOW(), NOW() + INTERVAL '2 hours', 1001, 200.00, NOW(), 1, 2),
(NOW() + INTERVAL '1 day', NOW() + INTERVAL '1 day 3 hours', 1002, 300.50, NOW(), 2, 3),
(NOW() + INTERVAL '2 days', NOW() + INTERVAL '2 days 4 hours', 1003, 150.75, NOW(), 3, 4),
(NOW() + INTERVAL '3 days', NOW() + INTERVAL '3 days 5 hours', 1004, 400.00, NOW(), 4, 1);

-- Вставка данных в таблицу ticket
INSERT INTO ticket (flight_id, user_id, pnr, created_at) VALUES
(1, 1, 'PNR12345', NOW()),
(2, 2, 'PNR67890', NOW()),
(3, 3, 'PNR54321', NOW()),
(4, 4, 'PNR09876', NOW());