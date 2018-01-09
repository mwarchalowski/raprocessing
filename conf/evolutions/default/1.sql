# noinspection SqlNoDataSourceInspectionForFile

# RaAuthorizations schema

# --- !Ups

CREATE TABLE ra_authorizations (
  `id` varchar(254) NOT NULL,
  `status` text NOT NULL,
  `email` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# -- !Downs

DROP TABLE ra_authorizations