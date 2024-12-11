CREATE TABLE IF NOT EXISTS city (
   city_id SERIAL PRIMARY KEY,
   display_name VARCHAR(255),
   created_at TIMESTAMP
);
