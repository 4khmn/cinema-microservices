CREATE TABLE directors(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE movies(
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    year INTEGER,
    duration_minutes INTEGER,
    director_id BIGINT REFERENCES directors(id)
);

CREATE TABLE actors(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER
);

CREATE TABLE movies_actors(
    movie_id BIGINT NOT NULL REFERENCES movies(id),
    actor_id BIGINT NOT NULL REFERENCES actors(id),
    PRIMARY KEY (movie_id, actor_id)
);