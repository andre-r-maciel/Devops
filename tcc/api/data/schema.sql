DROP TABLE IF EXISTS usuario CASCADE;
DROP TABLE IF EXISTS permissao CASCADE;
DROP TABLE IF EXISTS solicitacao CASCADE;
DROP TABLE IF EXISTS amizade CASCADE;
DROP TABLE IF EXISTS post CASCADE;
DROP TABLE IF EXISTS comentario CASCADE;
DROP TABLE IF EXISTS curtida CASCADE;

CREATE TABLE usuario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	nome VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	apelido VARCHAR(50) NULL,
	data_nascimento DATE NOT NULL,
	senha VARCHAR(128) NOT NULL,
	foto_perfil VARCHAR(512) NULL,
	assombracao BOOLEAN NULL,
	ativo BOOLEAN NULL
);
ALTER TABLE usuario ADD CONSTRAINT pk_usuario PRIMARY KEY (id);
ALTER TABLE usuario ADD CONSTRAINT uk_usuario_email UNIQUE (email);

CREATE TABLE solicitacao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	amigo_id BIGINT NOT NULL,
	estado VARCHAR(10) NOT NULL
);
ALTER TABLE solicitacao ADD CONSTRAINT pk_solicitacao PRIMARY KEY (id);
ALTER TABLE solicitacao ADD CONSTRAINT uk_solicitacao UNIQUE (amigo_id, usuario_id);
ALTER TABLE solicitacao ADD CONSTRAINT fk_solicitacao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE solicitacao ADD CONSTRAINT ck_solicitacao CHECK (estado IN ('AGUARDANDO', 'SOLICITADO'));

CREATE TABLE amizade (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	amigo_id BIGINT NOT NULL
);
ALTER TABLE amizade ADD CONSTRAINT pk_amizade PRIMARY KEY (id);
ALTER TABLE amizade ADD CONSTRAINT uk_amizade UNIQUE (amigo_id, usuario_id);
ALTER TABLE amizade ADD CONSTRAINT fk_amizade_amigo FOREIGN KEY (amigo_id) REFERENCES usuario;
ALTER TABLE amizade ADD CONSTRAINT fk_amizade_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;

CREATE TABLE permissao (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	funcao VARCHAR(20) NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE permissao ADD CONSTRAINT pk_permissao PRIMARY KEY (id);
ALTER TABLE permissao ADD CONSTRAINT uk_permissao UNIQUE (funcao, usuario_id);
ALTER TABLE permissao ADD CONSTRAINT fk_permissao_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;


CREATE TABLE post (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	usuario_id BIGINT NOT NULL,
	mensagem VARCHAR(500) NOT NULL,
	visualizacao VARCHAR(7) NOT NULL,
	data_postagem TIMESTAMP NOT NULL
);
ALTER TABLE post ADD CONSTRAINT pk_post PRIMARY KEY (id);
ALTER TABLE post ADD CONSTRAINT fk_post FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE post ADD CONSTRAINT ck_post CHECK (visualizacao IN ('PRIVADO', 'PUBLICO'));

CREATE TABLE comentario (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	post_id BIGINT NOT NULL,
	usuario_id BIGINT NOT NULL,
	resposta VARCHAR(500) NOT NULL,
	data_comentario TIMESTAMP NOT NULL
);
ALTER TABLE comentario ADD CONSTRAINT pk_comentario PRIMARY KEY (id);
ALTER TABLE comentario ADD CONSTRAINT fk_comentario_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE comentario ADD CONSTRAINT fk_comentario_post FOREIGN KEY (post_id) REFERENCES post;

CREATE TABLE curtida (
	id BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
	post_id BIGINT NOT NULL,
	usuario_id BIGINT NOT NULL
);
ALTER TABLE curtida ADD CONSTRAINT pk_curtida PRIMARY KEY (id);
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_usuario FOREIGN KEY (usuario_id) REFERENCES usuario;
ALTER TABLE curtida ADD CONSTRAINT fk_curtida_post FOREIGN KEY (post_id) REFERENCES post;