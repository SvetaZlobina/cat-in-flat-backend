CREATE TABLE hops.home (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT NOT NULL REFERENCES hops.client(id),
    title TEXT NOT NULL
)