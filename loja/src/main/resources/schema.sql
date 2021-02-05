create table produto(
    id int primary key,
    nome varchar(50) not null,
    preco decimal(5,2) not null,
    cor varchar(50),
    marca varchar(50),
    fuel varchar(50),
    tipo varchar(50)
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
    enable bool not null
);

create table autorizacao(
    username varchar(50) not null,
    cargo varchar(50) not null,
    constraint fk_autorizacao_utilizador foreign key(username) references utilizador(username)
);

create unique index ix_autorizacao_utilizador on permissao(username,cargo);
