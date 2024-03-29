--drop table users;
CREATE TABLE users
  (
    userno NUMBER(3) CONSTRAINT user_userno_pk PRIMARY KEY,
    login  VARCHAR2(50),
    pwd    VARCHAR2(50)
  );

  
CREATE sequence users_seq start with 1 increment BY 1 nocycle;
  CREATE TABLE userinfo
    (
      userno    NUMBER(4) REFERENCES users(userno),
      nom       VARCHAR2(50),
      prenom       VARCHAR2(50),
      couriel   VARCHAR2(50),
      zipcode   VARCHAR2(6),
      telephone VARCHAR2(12),
      photo VARCHAR2(50)
    );
 

 create table userannonces (
   userno NUMBER(4) REFERENCES users(userno),
   id NUMBER(38) REFERENCES annonces(id),
   constraint PK_UA primary key (userno, id)
 );