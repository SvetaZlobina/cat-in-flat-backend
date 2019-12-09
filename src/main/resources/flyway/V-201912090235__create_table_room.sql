CREATE TABLE hops.room (
    id BIGSERIAL PRIMARY KEY,
    home_id BIGINT NOT NULL REFERENCES hops.home(id),
    title TEXT NOT NULL
)