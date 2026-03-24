CREATE TABLE bookings(
    id BIGSERIAL PRIMARY KEY,
    screening_id BIGINT NOT NULL,
    seat_id BIGINT NOT NULL,
    user_email VARCHAR(255) NOT NULL,
    status VARCHAR(12) NOT NULL DEFAULT 'PENDING',
    version BIGINT NOT NULL DEFAULT 0
);


