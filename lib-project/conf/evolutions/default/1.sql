# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table books_model (
  id                            integer auto_increment not null,
  title                         varchar(255),
  author                        varchar(255),
  price                         integer,
  constraint pk_books_model primary key (id)
);


# --- !Downs

drop table if exists books_model;

