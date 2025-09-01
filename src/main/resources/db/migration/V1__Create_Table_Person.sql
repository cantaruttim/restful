CREATE TABLE IF NOT EXISTS `person` (
    `id` bigint(20) not null auto_increment,
    `first_name` varchar(100) not null,
    `last_name` varchar(100) not null,
    `gender` varchar(6) not null,
    `address` varchar(100) not null,
    PRIMARY KEY (`id`)
);
