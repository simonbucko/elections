-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema volby
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `volby` ;

-- -----------------------------------------------------
-- Schema volby
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `volby` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `volby` ;

-- -----------------------------------------------------
-- Table `volby`.`parties`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `volby`.`parties` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `volby`.`candidates`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `volby`.`candidates` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `parties_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `parties_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  INDEX `fk_candidates_parties_idx` (`parties_id` ASC) VISIBLE,
  CONSTRAINT `fk_candidates_parties`
    FOREIGN KEY (`parties_id`)
    REFERENCES `volby`.`parties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `volby`.`votes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `volby`.`votes` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `cpr` VARCHAR(45) NOT NULL,
  `candidates_id` INT UNSIGNED NOT NULL,
  `parties_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`, `candidates_id`, `parties_id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  UNIQUE INDEX `cpr_UNIQUE` (`cpr` ASC) VISIBLE,
  INDEX `fk_votes_candidates1_idx` (`candidates_id` ASC) VISIBLE,
  INDEX `fk_votes_parties1_idx` (`parties_id` ASC) VISIBLE,
  CONSTRAINT `fk_votes_candidates1`
    FOREIGN KEY (`candidates_id`)
    REFERENCES `volby`.`candidates` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_votes_parties1`
    FOREIGN KEY (`parties_id`)
    REFERENCES `volby`.`parties` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
