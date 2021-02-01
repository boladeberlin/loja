create table produto(
    id serial primary key,
    nome varchar(50) not null,
    preco decimal(5,2) not null
);

create table carrinhocompras(
    id serial,
    username varchar(50) not null,
    quantidade integer,
    preco decimal(5,2) not null,
    FOREIGN KEY (id) REFERENCES produto(id),
    FOREIGN KEY (username) REFERENCES utilizador(username)
);

create table encomendas(
    id serial,
    username varchar(50) not null,
    quantidade integer,
    preco decimal(5,2) not null,
    data date,
    FOREIGN KEY (id) REFERENCES produto(id),
    FOREIGN KEY (username) REFERENCES utilizador(username)
);


create table utilizador(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    email varchar(50) not null,
    enable bool not null
);

create table autorizacao(
    username varchar(50) not null,
    cargo varchar(50) not null,
    constraint fk_autorizacao_utilizador foreign key(username) references utilizador(username)
);

create unique index ix_autorizacao_utilizador on permissao(username,cargo);
