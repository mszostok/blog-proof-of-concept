
CREATE TABLE Users
  (
    id_user  SERIAL,
    first_name VARCHAR (50) NOT NULL ,
    last_name  VARCHAR (50) NOT NULL ,
    e_mail     VARCHAR (50) NOT NULL UNIQUE,
    password   VARCHAR (255) NOT NULL,
    is_active     BOOLEAN NOT NULL
  ) ;
CREATE UNIQUE INDEX Users__IDX ON Users
  (
    id_user ASC
  )
  ;
ALTER TABLE Users ADD CONSTRAINT Users_PK PRIMARY KEY ( id_user ) ;


CREATE TABLE Posts
(
  id_post SERIAL,
  post_date TIMESTAMP NOT NULL,
  post_title VARCHAR(255) NOT NULL,
  post_content TEXT NOT NULL,
  users_id_user INTEGER NOT NULL,
  is_deleted BOOLEAN DEFAULT FALSE
) ;
CREATE UNIQUE INDEX Posts__IDX ON Posts
  (
    id_post ASC
  )
  ;
  CREATE INDEX Posts__IDXv1 ON Posts
    ( users_id_user ASC
    ) ;
ALTER TABLE Posts ADD CONSTRAINT Posts_PK PRIMARY KEY ( id_post ) ;


CREATE TABLE User_roles
(
  id_user_role SERIAL,
  users_id_user INTEGER NOT NULL,
  role VARCHAR(50) NOT NULL
);
CREATE UNIQUE INDEX User_roles__IDX ON User_roles
  (
    id_user_role ASC
  )
  ;
  CREATE INDEX User_roles__IDXv1 ON User_roles
    ( users_id_user ASC
    ) ;
ALTER TABLE User_roles ADD CONSTRAINT User_roles_PK PRIMARY KEY ( id_user_role ) ;


ALTER TABLE Posts ADD CONSTRAINT Posts_Users_FK FOREIGN KEY ( users_id_user ) REFERENCES Users ( id_user ) ;
ALTER TABLE User_roles ADD CONSTRAINT User_roles_Entrances_FK FOREIGN KEY ( users_id_user ) REFERENCES Users ( id_user ) ;