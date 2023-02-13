

-- for the Products table.

CREATE TABLE `commerce`.`products` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL DEFAULT 'Null',
  `description` VARCHAR(1000) NULL DEFAULT 'Null',
  `img` VARCHAR(45) NULL DEFAULT 'Null',
  `price` DECIMAL(10,2) NULL DEFAULT 0.00,
  `stock` INT NULL,
  `sales` INT NULL,
  `category` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));



-- orders table.
CREATE TABLE `commerce`.`orders` (
  `ID` BIGINT(10) NOT NULL,
  `status` VARCHAR(100) NULL DEFAULT 'PENDING',
  `userID` BIGINT(10) NULL,
  `productID` BIGINT(10) NULL,
  `orderID` BIGINT(10) NULL,
  `time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`ID`));
