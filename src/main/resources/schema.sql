CREATE DATABASE IF NOT EXISTS films_notes;

CREATE TABLE IF NOT EXISTS films_notes.user(
	id BIGINT AUTO_INCREMENT,
    nickname VARCHAR(25) NOT NULL,
    password VARCHAR(25) NOT NULL,
    access_token VARCHAR(50) NOT NULL,
    time_insert TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS films_notes.`show`(
	id BIGINT AUTO_INCREMENT,
    title VARCHAR(50) 		NOT NULL,
    grade FLOAT 			NOT NULL,
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
);

CREATE TABLE IF NOT EXISTS films_notes.user_show (
	id BIGINT AUTO_INCREMENT,
    user_id BIGINT NOT NULL,
    show_id BIGINT NOT NULL,
    CONSTRAINT user_show_unique UNIQUE (user_id, show_id),
    PRIMARY KEY (id),
    FOREIGN KEY(user_id) REFERENCES user(id),
    FOREIGN KEY(show_id) REFERENCES `show`(id)
);