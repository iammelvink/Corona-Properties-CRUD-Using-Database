SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema cpdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cpdb` ;

-- -----------------------------------------------------
-- Schema cpdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cpdb` DEFAULT CHARACTER SET utf8mb4 ;
USE `cpdb` ;

-- -----------------------------------------------------
-- Table `cpdb`.`activity_audit`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cpdb`.`activity_audit` ;

CREATE TABLE IF NOT EXISTS `cpdb`.`activity_audit` (
  `action_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT UNSIGNED NULL DEFAULT NULL,
  `fName` VARCHAR(60) NULL DEFAULT NULL,
  `lName` VARCHAR(60) NULL DEFAULT NULL,
  `email` VARCHAR(60) NULL DEFAULT NULL,
  `action_type` VARCHAR(10) NOT NULL,
  `action_timestamp` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`action_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `cpdb`.`deleted_data`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cpdb`.`deleted_data` ;

CREATE TABLE IF NOT EXISTS `cpdb`.`deleted_data` (
  `deleted_data_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `propertyPrimaryKey` BIGINT UNSIGNED NULL DEFAULT NULL,
  `propertyType` VARCHAR(8) NOT NULL,
  `addressNum` VARCHAR(7) NOT NULL,
  `addressStreet` VARCHAR(50) NOT NULL,
  `addressCity` VARCHAR(60) NOT NULL,
  `addressCode` VARCHAR(7) NOT NULL,
  `value` DOUBLE UNSIGNED NOT NULL,
  `constructionStatus` VARCHAR(11) NOT NULL,
  `useOfProperty` VARCHAR(15) NOT NULL,
  `room` TINYINT(3) UNSIGNED NOT NULL,
  `garage` TINYINT(3) UNSIGNED NOT NULL,
  `bath` TINYINT(3) UNSIGNED NOT NULL,
  `floorArea` DOUBLE UNSIGNED NOT NULL,
  `landArea` DOUBLE UNSIGNED NOT NULL,
  `rates` DOUBLE UNSIGNED NOT NULL,
  `description` TEXT NOT NULL,
  `telephone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `deleted_timestamp` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP(),
  PRIMARY KEY (`deleted_data_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `cpdb`.`property`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cpdb`.`property` ;

CREATE TABLE IF NOT EXISTS `cpdb`.`property` (
  `propertyPrimaryKey` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `propertyType` VARCHAR(8) NOT NULL,
  `addressNum` VARCHAR(5) NOT NULL,
  `addressStreet` VARCHAR(50) NOT NULL,
  `addressCity` VARCHAR(60) NOT NULL,
  `addressCode` VARCHAR(7) NOT NULL,
  `value` DOUBLE UNSIGNED NOT NULL,
  `constructionStatus` VARCHAR(11) NOT NULL,
  `useOfProperty` VARCHAR(15) NOT NULL,
  `room` TINYINT(3) UNSIGNED NOT NULL,
  `garage` TINYINT(3) UNSIGNED NOT NULL,
  `bath` TINYINT(3) UNSIGNED NOT NULL,
  `floorArea` DOUBLE UNSIGNED NOT NULL,
  `landArea` DOUBLE UNSIGNED NOT NULL,
  `rates` DOUBLE UNSIGNED NOT NULL,
  `description` TEXT NOT NULL,
  `telephone` VARCHAR(10) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  PRIMARY KEY (`propertyPrimaryKey`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `cpdb`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cpdb`.`user` ;

CREATE TABLE IF NOT EXISTS `cpdb`.`user` (
  `user_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `fName` VARCHAR(60) NOT NULL,
  `lName` VARCHAR(60) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `password` VARCHAR(200) NOT NULL,
  `action` TINYINT(1) UNSIGNED NOT NULL DEFAULT 0,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
USE `cpdb`;

DELIMITER $$

USE `cpdb`$$
DROP TRIGGER IF EXISTS `cpdb`.`before_data_delete` $$
USE `cpdb`$$
CREATE
TRIGGER `cpdb`.`before_data_delete`
BEFORE DELETE ON `cpdb`.`property`
FOR EACH ROW
BEGIN
    INSERT INTO deleted_data
    VALUES(null, OLD.propertyPrimaryKey,OLD.propertyType,OLD.addressNum, OLD.addressStreet, OLD.addressCity, OLD.addressCode, OLD.value, OLD.constructionStatus, OLD.useOfProperty, OLD.room, OLD.garage, OLD.bath, OLD.floorArea, OLD.landArea, OLD.rates, OLD.description, OLD.telephone, OLD.email, NOW());
END$$


USE `cpdb`$$
DROP TRIGGER IF EXISTS `cpdb`.`user_after_crud` $$
USE `cpdb`$$
CREATE
TRIGGER `cpdb`.`user_after_crud`
AFTER UPDATE ON `cpdb`.`user`
FOR EACH ROW
BEGIN
      IF (NEW.action = '1') THEN
      	INSERT INTO activity_audit VALUES(null, NEW.user_id, NEW.fName, NEW.lName, NEW.email, 'SIGN IN' ,NOW());
      END IF;
      IF (NEW.action = '2') THEN
      	INSERT INTO activity_audit VALUES(null, NEW.user_id, NEW.fName, NEW.lName, NEW.email, 'SIGN OUT' ,NOW());
      END IF;
      IF (NEW.action = '3') THEN
      	INSERT INTO activity_audit VALUES(null, NEW.user_id, NEW.fName, NEW.lName, NEW.email, 'NEW' ,NOW());
      END IF;
      IF (NEW.action = '4') THEN
      	INSERT INTO activity_audit VALUES(null, NEW.user_id, NEW.fName, NEW.lName, NEW.email, 'UPDATE' ,NOW());
      END IF;
      IF (NEW.action = '5') THEN
      	INSERT INTO activity_audit VALUES(null, NEW.user_id, NEW.fName, NEW.lName, NEW.email, 'DELETE' ,NOW());
      END IF;      
    END$$


DELIMITER ;
