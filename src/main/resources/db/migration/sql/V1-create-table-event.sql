
CREATE TABLE IF NOT EXISTS `proselyte.event`
(
    id         INT         NOT NULL AUTO_INCREMENT PRIMARY KEY,
    fk_file_id INTEGER     NOT NULL,
    fk_user_id INTEGER     NOT NULL,
    status     VARCHAR(25) NOT NULL DEFAULT 'ACTIVE',
    CONSTRAINT fk_file_id
    FOREIGN KEY (fk_file_id) REFERENCES `proselyte.file` (id),
    CONSTRAINT fk_user_id
    FOREIGN KEY (fk_user_id) REFERENCES `proselyte.user` (id)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8;