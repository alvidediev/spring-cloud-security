
CREATE TABLE IF NOT EXISTS `proselyte.file`
(
    id        INT         NOT NULL AUTO_INCREMENT,
    file_name VARCHAR(20) NOT NULL,
    file_path VARCHAR(50) NOT NULL,
    status    VARCHAR(25) NOT NULL DEFAULT 'ACTIVE',
    PRIMARY KEY (id)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;