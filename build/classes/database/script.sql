/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  gabri
 * Created: 15 de jun. de 2022
 */

use  gerenciamento_de_estoque;


CREATE TABLE IF NOT EXISTS produto(
    codigo INT NOT NULL AUTO_INCREMENT,
    descricao TEXT,
    quant INT DEFAULT '0',
    valorVenda DOUBLE(5, 2),
    valorCusto DOUBLE(5, 2),
    PRIMARY KEY(codigo)
)DEFAULT CHARSET = utf8;


CREATE TABLE IF NOT EXISTS cliente(
    codigo INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(60) NOT NULL,
    contrato VARCHAR(100),
    PRIMARY KEY (codigo)
)DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS compra(
    nrCompra INT NOT NULL AUTO_INCREMENT,
    fornecedor VARCHAR(30) NOT NULL,
    quantComprada INT DEFAULT 0,
    vlaorCompra DOUBLE(5, 2),
    PRIMARY KEY(nrCompra)
)DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS venda(
    nrNF INT NOT NULL,
    dataVenda DATE NOT NULL,
    formaPagto TEXT NOT NULL,
    PRIMARY KEY(nrNF)
)DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS itemVendido(
    quantidadeVendida INT NOT NULL DEFAULT '0',
    precoVenda DOUBLE(5, 2)
)DEFAULT CHARSET = utf8;