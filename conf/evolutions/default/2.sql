# noinspection SqlNoDataSourceInspectionForFile

# Claims schema

# --- !Ups

CREATE TABLE claims (
  `id` varchar(254) NOT NULL,
  `ra_authorization_id` VARCHAR(254),
  `first_name` text NOT NULL,
  `last_name` text NOT NULL,
  `phone` VARCHAR(50) NOT NULL,
  `email` text NOT NULL,
  `order` VARCHAR(254),
  `sku` text,
  `tracking_number` text,
  `date_received` DATE,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# -- !Downs

DROP TABLE claims
