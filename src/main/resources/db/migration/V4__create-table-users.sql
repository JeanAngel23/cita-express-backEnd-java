CREATE TABLE usuario (

    id bigint not null auto_increment,
    login VARCHAR(155) NOT NULL,
    clave VARCHAR(300) NOT NULL,

    primary key(id)

);