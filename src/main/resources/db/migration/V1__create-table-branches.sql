CREATE TABLE branches (
    id BIGSERIAL PRIMARY KEY,
    street VARCHAR(255) NOT NULL,
    number VARCHAR(20) NOT NULL,
    complement VARCHAR(100),
    city VARCHAR(100) NOT NULL,
    state VARCHAR(100) NOT NULL,
    postal_code VARCHAR(20) NOT NULL,
    contact_number VARCHAR(20) NOT NULL,
    number_of_car_spaces INT NOT NULL,
    number_of_motorcycle_spaces INT NOT NULL
);