DROP DATABASE clubes;
CREATE DATABASE clubes;
USE clubes;

CREATE TABLE jogador(
	id_jogador BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	nome_jogador VARCHAR(50) NOT NULL,
	idade_jogador TINYINT NOT NULL,
	email_jogador VARCHAR(150) NOT NULL UNIQUE ,
	senha_jogador VARCHAR(50) NOT NULL,
	camisa_jogador TINYINT UNSIGNED,
	num_jogador VARCHAR(20) NOT NULL UNIQUE,
	PRIMARY KEY (id_jogador)
);

CREATE TABLE clube(
	id_clube BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	nome_clube VARCHAR(50) NOT NULL,
	qntd_jogador TINYINT UNSIGNED,
	cnpj_clube VARCHAR(21) NOT NULL UNIQUE,
	num_clube VARCHAR(20) NOT NULL UNIQUE,
	tecnico VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_clube)
);

CREATE TABLE ginasio(
	id_ginasio BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	cnpj_ginasio VARCHAR(21) NOT NULL,
	horarios_livres DATETIME NOT NULL,
	num_ginasio VARCHAR(20) NOT NULL,
	PRIMARY KEY (id_ginasio)
);

CREATE TABLE jogos(
	id_jogos BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
	placar VARCHAR(5) NOT NULL,
	horario DATETIME NOT NULL,
	gols VARCHAR(30) NOT NULL,
	id_ginasio BIGINT NOT NULL UNIQUE,
	PRIMARY KEY (id_jogos),
	FOREIGN KEY (id_ginasio) REFERENCES ginasio(id_ginasio)
);

CREATE TABLE endereco (
  id_endereco BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  cep VARCHAR(11) NOT NULL UNIQUE,
  estado VARCHAR(45) NOT NULL,
  cidade VARCHAR(45) NOT NULL,
  bairro VARCHAR(45) NOT NULL,
  rua VARCHAR (50) NOT NULL,
  numero INT NOT NULL,
  id_jogador BIGINT UNIQUE,
  id_ginasio BIGINT UNIQUE,
  id_clube BIGINT UNIQUE,
  PRIMARY KEY (id_endereco),
  FOREIGN KEY (id_jogador) REFERENCES jogador (id_jogador),
  FOREIGN KEY ( id_ginasio) REFERENCES ginasio ( id_ginasio),
  FOREIGN KEY (id_clube) REFERENCES clube (id_clube)
);

CREATE TABLE jogos_endereco(
  id_jogos_endereco BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
  id_endereco BIGINT NOT NULL UNIQUE,
  id_jogos BIGINT NOT NULL UNIQUE,
  PRIMARY KEY (id_jogos_endereco),
  FOREIGN KEY (id_endereco) REFERENCES endereco (id_endereco),
  FOREIGN KEY (id_jogos) REFERENCES jogos (id_jogos)
);

CREATE TABLE clube_jogos(
id_clube_jogos BIGINT NOT NULL UNIQUE AUTO_INCREMENT,
 id_clube BIGINT NOT NULL UNIQUE,
 id_jogos BIGINT NOT NULL UNIQUE,
 FOREIGN KEY (id_clube) REFERENCES clube (id_clube),
 FOREIGN KEY (id_jogos) REFERENCES jogos (id_jogos)
);
