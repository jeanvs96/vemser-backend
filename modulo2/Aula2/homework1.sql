CREATE TABLE VEMSER_JEAN.PAIS(
    ID_PAIS NUMBER(38) PRIMARY KEY NOT NULL,
    NOME VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE seq_pais
START WITH 1
INCREMENT BY 1 NOCYCLE NOCACHE;

CREATE TABLE VEMSER_JEAN.ESTADO(
    ID_ESTADO NUMBER(38) PRIMARY KEY NOT NULL,
    ID_PAIS NUMBER(38) NOT NULL,
    NOME VARCHAR2(50) NOT NULL,
    CONSTRAINT FK_ID_PAIS FOREIGN KEY (ID_PAIS) REFERENCES PAIS(ID_PAIS)
);

CREATE SEQUENCE seq_estado
START WITH 1
INCREMENT BY 1 NOCYCLE NOCACHE;

CREATE TABLE VEMSER_JEAN.CIDADE (
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_CIDADE PRIMARY KEY (ID_CIDADE, ID_ESTADO),
	CONSTRAINT FK_ID_ESTADO FOREIGN KEY (ID_ESTADO) REFERENCES ESTADO(ID_ESTADO)
);

CREATE SEQUENCE seq_cidade
START WITH 1
INCREMENT BY 1 NOCYCLE NOCACHE;

CREATE TABLE VEMSER_JEAN.BAIRRO (
	ID_BAIRRO NUMBER(38) NOT NULL,
	ID_CIDADE NUMBER(38) NOT NULL,
	ID_ESTADO NUMBER(38) NOT NULL,
	NOME VARCHAR2(50) NOT NULL,
	CONSTRAINT PK_BAIRRO PRIMARY KEY(ID_BAIRRO, ID_CIDADE),
	CONSTRAINT FK_ID_CIDADE FOREIGN KEY (ID_CIDADE, ID_ESTADO) REFERENCES CIDADE(ID_CIDADE, ID_ESTADO)
);

CREATE SEQUENCE seq_bairro
START WITH 1
INCREMENT BY 1 NOCYCLE NOCACHE;

CREATE TABLE VEMSER_JEAN.ENDERECO (
	ID_ENDERECO NUMBER(38) PRIMARY KEY NOT NULL,
	ID_BAIRRO NUMBER(38) NOT NULL,
	ID_CIDADE NUMBER(38) NOT NULL,
	LOGRADOURO VARCHAR2(255) NOT NULL,
	NUMERO NUMBER(38) NOT NULL,
	COMPLEMENTO VARCHAR2(100),
	CEP CHAR(9),
	CONSTRAINT FK_ID_ENDERECO_BAIRRO FOREIGN KEY (ID_BAIRRO, ID_CIDADE) REFERENCES BAIRRO(ID_BAIRRO, ID_CIDADE)
);

CREATE SEQUENCE seq_endereco
START WITH 1
INCREMENT BY 1 NOCYCLE NOCACHE;


INSERT INTO VEMSER_JEAN.PAIS (ID_PAIS, NOME) VALUES (seq_pais.nextval, 'Brasil');
INSERT INTO VEMSER_JEAN.PAIS (ID_PAIS, NOME) VALUES (seq_pais.nextval, 'Estados Unidos');


INSERT INTO VEMSER_JEAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (seq_estado.nextval, 1, 'São Paulo');
INSERT INTO VEMSER_JEAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (seq_estado.nextval, 1, 'Bahia');

INSERT INTO VEMSER_JEAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (seq_estado.nextval, 2, 'New York');
INSERT INTO VEMSER_JEAN.ESTADO (ID_ESTADO, ID_PAIS, NOME) VALUES (seq_estado.nextval, 2, 'Texas');


INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 1, 'São Paulo');
INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 1, 'São Bernardo do Campo');

INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 2, 'Salvador');
INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 2, 'Feira de Santana');

INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 3, 'New York');
INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 3, 'Syracuse');

INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 4, 'Houston');
INSERT INTO VEMSER_JEAN.CIDADE (ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_cidade.nextval, 4, 'Dallas');


INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 1, 1, 'Paraíso');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 1, 1, 'Sacomã');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 2, 1, 'Demarchi');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 2, 1, 'Centro');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 3, 2, 'Acupe');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 3, 2, 'Aeroporto');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 4, 2, 'Centro');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 4, 2, 'Queimadinha');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 5, 3, 'Brooklyin');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 5, 3, 'Manhattan');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 6, 3, 'Lakefront');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 6, 3, 'South Valley');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 7, 4, 'Clear Lake City');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 7, 4, 'Mid Town');

INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 8, 4, 'Deep Ellum ');
INSERT INTO VEMSER_JEAN.BAIRRO (ID_BAIRRO, ID_CIDADE, ID_ESTADO, NOME) VALUES (seq_bairro.nextval, 8, 4, 'Oak Lawn');



INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 1, 1, 'Rua Benedito Lapin', 1254, NULL,'04532-040');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 1, 1, 'Avenida Antônio Carlos Magalhães', 548, NULL,'40260-210');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 2, 1, 'Rua Clara Aurora', 254, NULL,'05736-110');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 2, 1, 'Rua Vale do Matatu', 789, NULL,'41230-335');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 3, 2, 'Rua Anduiá', 98, 'Apartamento 32','02650-060');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 3, 2, 'Caminho 6', 751, NULL,'41490-214');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 4, 2, 'Avenida Adolfo Pinheiro', 254, NULL,'04733-000');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 4, 2, 'Rua Mário Ribeiro', 444, NULL,'41925-155');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 5, 3, 'Rua Paulino Ferreira', 854, NULL,'41760-035');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 5, 3, 'Rua Doutor Augusto Lopes Pontes', 77, 'Apartamento 54','41245-810');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 6, 3, 'Rua Avencas', 254, NULL,'40750-255');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 6, 3, 'Rua Avencas', 885, NULL,'40750-255');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 7, 4, 'Rua Nova Canaã', 77, 'Apartamento 90','40830-540');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 7, 4, 'Rua Nova Canaã', 85, 'Apartamento 77','40830-540');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 8, 4, 'Rua do Bonocô', 377, NULL,'40221-465');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 8, 4, 'Travessa Creuza de Jesus', 555, NULL,'41211-023');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 9, 5, 'BROADWAY', 1239, NULL,'100014333');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 9, 5, 'BROADWAY', 1555, NULL,'100014333');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 10, 5, 'CRESCENT', 1900, NULL,'063907847');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 10, 5, 'CRESCENT', 1874, NULL,'063907847');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 11, 6, 'AVENUE OF THE AMERICAS', 6984, NULL,'100015431');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 11, 6, 'AVENUE OF THE AMERICAS', 6400, NULL,'100015431');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 12, 6, '32ND', 777, NULL,'10013811');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 12, 6, '32ND', 13, NULL,'10013811');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 13, 7, '7TH', 1239, NULL,'11011132');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 13, 7, '7TH', 1240, NULL,'11011132');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 14, 7, '33RD', 1900, NULL,'10013844');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 14, 7, '33RD', 1903, NULL,'1013844');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 15, 8, 'PENINSULA', 6984, NULL,'1005012');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 15, 8, 'PENINSULA', 6999, NULL,'1015012');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 16, 8, '26TH', 777, NULL,'10012006');

INSERT INTO VEMSER_JEAN.ENDERECO (ID_ENDERECO, ID_BAIRRO, ID_CIDADE, LOGRADOURO, NUMERO, COMPLEMENTO, CEP)
VALUES (seq_endereco.nextval, 16, 8, '26TH', 778, NULL,'1012006');


SELECT * FROM VEMSER_JEAN.PAIS
ORDER BY NOME DESC;

SELECT
	LOGRADOURO,
	CEP
FROM VEMSER_JEAN.ENDERECO
WHERE LOWER(LOGRADOURO) LIKE 'a%';

SELECT 
	CEP
FROM VEMSER_JEAN.ENDERECO
WHERE CEP LIKE '%0';

SELECT *
FROM VEMSER_JEAN.ENDERECO
WHERE NUMERO BETWEEN 1 AND 100;

SELECT *
FROM VEMSER_JEAN.ENDERECO
WHERE UPPER(LOGRADOURO) LIKE 'RUA%'
ORDER BY CEP DESC;

SELECT 
	COUNT(ID_ENDERECO)
FROM VEMSER_JEAN.ENDERECO;

SELECT 
	COUNT(ID_ENDERECO),
	ID_CIDADE 
FROM VEMSER_JEAN.ENDERECO
GROUP BY ID_CIDADE;