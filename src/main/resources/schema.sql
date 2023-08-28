CREATE DATABASE IF NOT EXISTS films_notes;

CREATE TABLE IF NOT EXISTS films_notes.`show`(
	id BIGINT AUTO_INCREMENT,
    title VARCHAR(50) 		NOT NULL,
    grade FLOAT 			NOT NULL,
    viewed BOOLEAN 			NOT NULL DEFAULT 0,
    `year` INT 				NOT NULL,
    time_insert TIMESTAMP 	NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS films_notes.genre (
	id BIGINT AUTO_INCREMENT,
    `name` VARCHAR(30) UNIQUE NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS films_notes.show_genre (
	id BIGINT AUTO_INCREMENT,
    show_id BIGINT NOT NULL,
    genre_id BIGINT NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY(show_id) REFERENCES `show`(id),
    FOREIGN KEY(genre_id) REFERENCES genre(id)
)