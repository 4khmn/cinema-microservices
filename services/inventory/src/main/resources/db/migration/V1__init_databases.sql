CREATE TABLE halls (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    total_rows INTEGER,
    seats_per_row INTEGER
);

CREATE TABLE screenings (
    id BIGSERIAL PRIMARY KEY,
    movie_id BIGINT NOT NULL,
    hall_id BIGINT NOT NULL REFERENCES halls(id),
    start_time TIMESTAMP NOT NULL,
    price DECIMAL(19, 2) NOT NULL
);

CREATE TABLE seats (
    id BIGSERIAL PRIMARY KEY,
    screening_id BIGINT NOT NULL REFERENCES screenings(id),
    row_number INTEGER NOT NULL,
    seat_number INTEGER NOT NULL,
    is_reserved BOOLEAN DEFAULT FALSE,
    version BIGINT DEFAULT 0
);