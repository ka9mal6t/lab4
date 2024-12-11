CREATE TABLE IF NOT EXISTS ticket (
    ticket_id SERIAL PRIMARY KEY,
    flight_id INT REFERENCES flight(flight_id),
    user_id INT REFERENCES users(user_id),
    pnr VARCHAR(255),
    created_at TIMESTAMP
);
