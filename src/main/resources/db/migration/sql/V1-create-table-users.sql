
CREATE TABLE IF NOT EXISTS `proselyte.user`
(
    id         INT                NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(20)        NOT NULL,
    last_name  VARCHAR(50)        NOT NULL,
    email      VARCHAR(50) UNIQUE NOT NULL,
    password   VARCHAR(255)       NOT NULL,
    role       VARCHAR(50)        NOT NULL DEFAULT 'USER',
    status     VARCHAR(50)        NOT NULL DEFAULT 'ACTIVE',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;












