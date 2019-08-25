create sequence hibernate_sequence start 1 increment 1;

create table blog_entry_entity (
  id int4 not null,
  created_on timestamp not null,
  modified_on timestamp not null,
  content text,
  published timestamp,
  subject varchar(265),
  primary key (id)
);

create table hobby_entity (
  id int4 not null,
  created_on timestamp not null,
  modified_on timestamp not null,
  primary key (id)
);

create table news_entry_entity (
  id int4 not null,
  created_on timestamp not null,
  modified_on timestamp not null,
  primary key (id)
);