CREATE TABLE IF NOT EXISTS flight (
    flight_id SERIAL PRIMARY KEY,
    departure_time TIMESTAMP,
    arrival_time TIMESTAMP,
    flight_number INT,
    price DOUBLE PRECISION,
    created_at TIMESTAMP,
    departure_city_id INT REFERENCES city(city_id),
    arrival_city_id INT REFERENCES city(city_id)
);
