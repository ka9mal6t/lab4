-- Вставка ролей
INSERT INTO roles (role_name) VALUES
('ADMIN'),
('USER');

-- Вставка міст
INSERT INTO city (display_name, created_at) VALUES
('New York', NOW()),
('Los Angeles', NOW()),
('Chicago', NOW()),
('San Francisco', NOW());

-- Вставка користувачів
-- Увага: role_id тут дорівнює 1 (ADMIN) або 2 (USER)
INSERT INTO users (first_name, last_name, username, password, created_at, role) VALUES
('John', 'Doe', 'johndoe', '$2a$10$wHj99l5/4jBZiE9rV4Zuge6e9t2sPq9mv0YsnAqXZbKM2RQqD0ABG', NOW(), 1), -- password123
('Jane', 'Smith', 'janesmith', '$2a$10$8oGkQrr0E4x7cNQGRjNYM.sj6iMkzFAwlxz7SkZRmJoHcDU4k4Kyq', NOW(), 2), -- password456
('Alice', 'Brown', 'alicebrown', '$2a$10$kRTPaXyxE2pVxklYELoXje4dfU7zv.KAEHGcQxY3ac8PIAIwsvrW2', NOW(), 2), -- password789
('Bob', 'White', 'bobwhite', '$2a$10$KV.KMZu1I9Fl5qTz91iXoOi1j86PNzA3bCllRSE19HNSMnvLrcgzy', NOW(), 2); -- password000

-- Вставка рейсів
INSERT INTO flight (departure_time, arrival_time, flight_number, price, created_at, departure_city_id, arrival_city_id) VALUES
(NOW(), NOW() + INTERVAL '2 hours', 1001, 200.00, NOW(), 1, 2),
(NOW() + INTERVAL '1 day', NOW() + INTERVAL '1 day 3 hours', 1002, 300.50, NOW(), 2, 3),
(NOW() + INTERVAL '2 days', NOW() + INTERVAL '2 days 4 hours', 1003, 150.75, NOW(), 3, 4),
(NOW() + INTERVAL '3 days', NOW() + INTERVAL '3 days 5 hours', 1004, 400.00, NOW(), 4, 1);

-- Вставка квитків
INSERT INTO ticket (flight_id, user_id, pnr, created_at) VALUES
(1, 1, 'PNR12345', NOW()),
(2, 2, 'PNR67890', NOW()),
(3, 3, 'PNR54321', NOW()),
(4, 4, 'PNR09876', NOW());
