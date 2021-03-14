# ProyectoPSP
Script DB

CREATE DATABASE psp_games;
use psp_games
CREATE TABLE games (
    id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    genre VARCHAR(50) NOT NULL,
    id_pegi INT(3) NOT NULL,
    release_date DATE NOT NULL,
    multiplayer boolean NOT NULL,
    img VARCHAR(300)
);

CREATE TABLE pegi(
    id INT(3) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    pegi VARCHAR(50) NOT NULL
);

ALTER TABLE games
    ADD FOREIGN KEY(id_pegi) REFERENCES pegi(id);

CREATE TABLE usr(
    mail VARCHAR(100) PRIMARY KEY,
    pwd VARCHAR(500)
);

INSERT INTO pegi(pegi) VALUES("PEGI-3"),("PEGI-7"),("PEGI-12"),("PEGI-16"),("PEGI-18");

INSERT INTO games (title,genre,id_pegi,release_date,multiplayer)VALUES
("Octopath Traveler","RPG",3,"2015-07-07",0),
("Kimi ga shine","Adventure",3,"2017-08-28",0),
("Minecraft","Adventure",2,"2011,12,20",1),
("NieR: Automata","RPG",5,"2017-02-23",0),
("Pokémon Go","RPG",1,"2016-07-06",1),
("Overwatch","Shooter",4,"2015-010-27",1);

INSERT into usr(mail,pwd) VALUES("admin@mail.com","abc123."),("usr@mail.com","abc123.");

/*Select with PEGI*/
SELECT g.title,p.pegi FROM games g 
JOIN pegi p
ON p.id = g.id_pegi;
