-- MySQL Script generated by MySQL Workbench
-- Fri Jun  2 08:18:14 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema ap2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ap2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ap2` DEFAULT CHARACTER SET utf8 ;
USE `ap2` ;

-- -----------------------------------------------------
-- Table `ap2`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`usuario` (
  `cpf` VARCHAR(11) NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `dataNasc` DATE NULL,
  `numeroCartao` INT NULL,
  PRIMARY KEY (`cpf`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`categoria` (
  `id` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`musica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`musica` (
  `id` INT NOT NULL auto_increment,
  `titulo` VARCHAR(45) NOT NULL,
  `letra` VARCHAR(200) NOT NULL,
  `dataLancamento` DATE NULL,
  `duracao` INT NULL,
  `censura` INT NULL,
  `id_categoria` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_musica_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `ap2`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`autor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`autor` (
  `id` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`produtor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`produtor` (
  `id` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`musicaProdutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`musicaProdutor` (
  `musica_id` INT NOT NULL,
  `produtor_id` INT NOT NULL,
  PRIMARY KEY (`musica_id`, `produtor_id`),
  CONSTRAINT `fk_musica_has_produtor_musica`
    FOREIGN KEY (`musica_id`)
    REFERENCES `ap2`.`musica` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_musica_has_produtor_produtor1`
    FOREIGN KEY (`produtor_id`)
    REFERENCES `ap2`.`produtor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`playlist` (
  `id` INT NOT NULL auto_increment,
  `nome` VARCHAR(45) NOT NULL,
  `privado` TINYINT NULL,
  `id_categoria` INT NOT NULL,
  `cpf_usuario` VARCHAR(11) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_playlist_categoria`
    FOREIGN KEY (`id_categoria`)
    REFERENCES `ap2`.`categoria` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_playlist_usuario`
    FOREIGN KEY (`cpf_usuario`)
    REFERENCES `ap2`.`usuario` (`cpf`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `ap2`.`musicaAutor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ap2`.`musicaAutor` (
  `musica_id` INT NOT NULL,
  `autor_id` INT NOT NULL,
  PRIMARY KEY (`musica_id`, `autor_id`),
  CONSTRAINT `fk_musica_has_autor_musica1`
    FOREIGN KEY (`musica_id`)
    REFERENCES `ap2`.`musica` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_musica_has_autor_autor1`
    FOREIGN KEY (`autor_id`)
    REFERENCES `ap2`.`autor` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
