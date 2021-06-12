CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE movie (
    id UUID NOT NULL PRIMARY KEY DEFAULT uuid_generate_v4(),
    title VARCHAR NOT NULL CHECK (char_length(title) BETWEEN 1 AND 50),
    format VARCHAR NOT NULL CHECK (format IN ('VHS', 'DVD', 'Streaming')),
    length INTERVAL NOT NULL CHECK (length BETWEEN '0 minutes' AND '500 minutes'),
    release_year INTEGER NOT NULL CHECK (release_year BETWEEN 1800 AND 2100),
    rating INTEGER NOT NULL CHECK (rating BETWEEN 1 AND 5)
);
