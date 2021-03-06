SELECT *
FROM PESSOA P
RIGHT JOIN CONTATO C ON P.ID_PESSOA = C.ID_PESSOA;

SELECT *
FROM PESSOA P
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON P.ID_PESSOA = PXPE.ID_PESSOA 
RIGHT JOIN ENDERECO_PESSOA EP ON PXPE.ID_ENDERECO = EP.ID_ENDERECO;

SELECT *
FROM PESSOA P
RIGHT JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON P.ID_PESSOA = PXPE.ID_PESSOA 
RIGHT JOIN ENDERECO_PESSOA EP ON PXPE.ID_ENDERECO = EP.ID_ENDERECO
RIGHT JOIN CONTATO C ON P.ID_PESSOA = C.ID_PESSOA;

SELECT *
FROM PESSOA P
FULL JOIN CONTATO C ON P.ID_PESSOA = C.ID_PESSOA;

SELECT *
FROM PESSOA P
FULL JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON P.ID_PESSOA = PXPE.ID_PESSOA 
FULL JOIN ENDERECO_PESSOA EP ON PXPE.ID_ENDERECO = EP.ID_ENDERECO;

SELECT *
FROM PESSOA P
FULL JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON P.ID_PESSOA = PXPE.ID_PESSOA 
FULL JOIN ENDERECO_PESSOA EP ON PXPE.ID_ENDERECO = EP.ID_ENDERECO
FULL JOIN CONTATO C ON P.ID_PESSOA = C.ID_PESSOA;

SELECT *
FROM PESSOA P
WHERE EXISTS (SELECT *
				FROM PESSOA_X_PESSOA_ENDERECO PXPE
				WHERE P.ID_PESSOA = PXPE.ID_PESSOA
				AND PXPE.ID_ENDERECO IS NOT NULL);

SELECT 
	P.ID_PESSOA,
	P.NOME,
	EP.ID_ENDERECO,
	EP.LOGRADOURO  
FROM PESSOA P
FULL JOIN PESSOA_X_PESSOA_ENDERECO PXPE ON P.ID_PESSOA = PXPE.ID_PESSOA 
FULL JOIN ENDERECO_PESSOA EP ON PXPE.ID_ENDERECO  = EP.ID_ENDERECO