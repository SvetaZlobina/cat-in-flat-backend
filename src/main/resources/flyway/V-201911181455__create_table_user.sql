CREATE TABLE hops.client (
    id BIGSERIAL PRIMARY KEY,
    name TEXT,
    login TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    email TEXT,
    phone TEXT
)