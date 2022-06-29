CREATE TABLE VEMSER_JEAN.ESTUDANTE (
	id_estudante NUMBER NOT NULL,
	nome varchar2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL UNIQUE,
	ativo CHAR(1)
);

CREATE SEQUENCE seq_estudante
START WITH 1
INCREMENT BY 1;

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Jean Victor da Silva',to_date('30-01-1996', 'dd-mm-yyyy'), 10001, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Hans Castorp',to_date('30-01-1900', 'dd-mm-yyyy'), 10002, 'N');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Aureliano Buendia',to_date('30-01-1800', 'dd-mm-yyyy'), 10003, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Raskolnikov',to_date('30-01-1850', 'dd-mm-yyyy'), 10004, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Josef K',to_date('30-01-1996', 'dd-mm-yyyy'), 10005, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Gregor Samsa',to_date('30-01-1930', 'dd-mm-yyyy'), 10006, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Ivan Karamazov',to_date('30-01-1833', 'dd-mm-yyyy'), 10007, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Clawdia Chauchat ',to_date('30-01-1920', 'dd-mm-yyyy'), 10008, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Lodovico Settembrini',to_date('30-01-1892', 'dd-mm-yyyy'), 10009, 'S');

INSERT INTO VEMSER_JEAN.ESTUDANTE  (id_estudante, NOME, DATA_NASCIMENTO, NR_MATRICULA, ATIVO) 
VALUES(seq_estudante.nextval, 'Humbert Humbert',to_date('30-01-1955', 'dd-mm-yyyy'), 10010, 'S');


SELECT * FROM  VEMSER_JEAN.ESTUDANTE;


