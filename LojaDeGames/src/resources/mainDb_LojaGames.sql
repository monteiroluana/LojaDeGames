CREATE TABLE cliente (
idCliente INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(255), 
cpf VARCHAR(30), 
rg VARCHAR(30), 
email VARCHAR(255), 
telefone VARCHAR(30), 
estCivil VARCHAR(30), 
dataNasc DATE, 
sexo VARCHAR(30), 
cep VARCHAR(30), 
logradouro VARCHAR(255), 
numero VARCHAR(20), 
complemento VARCHAR(10), 
bairro VARCHAR(255),
cidade VARCHAR(255), 
uf VARCHAR(30), 
enabled BOOLEAN
);


CREATE TABLE plataforma (
idPlataforma INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
descricao VARCHAR (255)
);


CREATE TABLE produto (
idProduto INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
nome VARCHAR(255), 
codBarra VARCHAR(10), 
categoria VARCHAR(30), 
desenv VARCHAR(255), 
preco FLOAT, 
faixaEtaria VARCHAR(30),  
jogadores VARCHAR(30), 
qtdEstoque INT, 
enabled BOOLEAN, 
idPlataforma INT NOT NULL,
FOREIGN KEY(idPlataforma) REFERENCES plataforma(idPlataforma)
);