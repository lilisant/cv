# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table user (
  userid                    integer not null,
  firstname                 varchar(255),
  surname                   varchar(255),
  street_adress             varchar(255),
  town                      varchar(255),
  postcode                  varchar(255),
  mobile                    varchar(255),
  email                     varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (userid))
;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists user_seq;

