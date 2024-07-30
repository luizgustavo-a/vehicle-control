CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE operations (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    branch_id BIGINT NOT NULL,
    vehicle_id BIGINT NOT NULL,
    event VARCHAR(50) NOT NULL,
    timestamp TIMESTAMP WITH TIME ZONE NOT NULL,

    CONSTRAINT fk_branch FOREIGN KEY (branch_id) REFERENCES branches(id),
    CONSTRAINT fk_vehicle FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);