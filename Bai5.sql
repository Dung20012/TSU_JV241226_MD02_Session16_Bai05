
CREATE DATABASE movie_db;
USE movie_db;

CREATE TABLE movies(
	movie_id INT auto_increment primary key,
    title varchar(255) NOT NULL,
    director varchar(255) NOT NULL,
    release_year INT NOT NULL
);

-- Stored Procedure
-- Thêm phim
DELIMITER //
CREATE PROCEDURE add_movie(IN p_title VARCHAR(255), IN p_director VARCHAR(255), IN p_year INT)
BEGIN
    INSERT INTO movies(title, director, release_year)
    VALUES (p_title, p_director, p_year);
END //
DELIMITER ;

-- Liệt kê phim
DELIMITER //
CREATE PROCEDURE list_movies()
BEGIN
    SELECT * FROM movies;
END //
DELIMITER ;

-- Cập nhật phim
DELIMITER //
CREATE PROCEDURE update_movie(IN p_id INT, IN p_title VARCHAR(255), IN p_director VARCHAR(255), IN p_year INT)
BEGIN
    UPDATE movies
    SET title = p_title,
        director = p_director,
        release_year = p_year
    WHERE movie_id = p_id;
END //
DELIMITER ;

-- Xóa phim
DELIMITER //
CREATE PROCEDURE delete_movie(IN p_id INT)
BEGIN
    DELETE FROM movies WHERE movie_id = p_id;
END //
DELIMITER ;
