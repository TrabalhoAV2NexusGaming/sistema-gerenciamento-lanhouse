CREATE DATABASE nexus_gaming_system;

USE nexus_gaming_system;

CREATE TABLE clientes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cpf VARCHAR(14) UNIQUE NOT NULL,
    telefone VARCHAR(20),
    nickname VARCHAR(50),
    pontos INT DEFAULT 0,
    saldo_horas DECIMAL(5,2) DEFAULT 0
);

CREATE TABLE equipamentos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    numero INT NOT NULL,
    tipo VARCHAR(30) NOT NULL,
    valor_hora DECIMAL(6,2) NOT NULL,
    status VARCHAR(20) NOT NULL,

    processador VARCHAR(100),
    memoria_ram INT,
    placa_video VARCHAR(100),

    marca_console VARCHAR(50),
    geracao_console VARCHAR(50)
);

CREATE TABLE funcionarios (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    usuario VARCHAR(50) UNIQUE NOT NULL,
    senha VARCHAR(100) NOT NULL,
    cargo VARCHAR(30) NOT NULL
);

CREATE TABLE promocoes (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    horario_inicio TIME NOT NULL,
    horario_fim TIME NOT NULL,
    valor_fixo DECIMAL(6,2)
);

CREATE TABLE sessoes (
    id INT PRIMARY KEY AUTO_INCREMENT,

    cliente_id INT NOT NULL,
    equipamento_id INT NOT NULL,
    promocao_id INT,

    horario_inicio DATETIME NOT NULL,
    horario_fim DATETIME,

    tempo_contratado INT NOT NULL,

    valor_total DECIMAL(8,2),

    ativa BOOLEAN DEFAULT TRUE,

    FOREIGN KEY (cliente_id)
        REFERENCES clientes(id),

    FOREIGN KEY (equipamento_id)
        REFERENCES equipamentos(id),

    FOREIGN KEY (promocao_id)
        REFERENCES promocoes(id)
);

CREATE TABLE pagamentos (
    id INT PRIMARY KEY AUTO_INCREMENT,

    sessao_id INT UNIQUE NOT NULL,

    valor DECIMAL(8,2) NOT NULL,

    data_pagamento DATE NOT NULL,

    tipo_pagamento VARCHAR(30) NOT NULL,

    FOREIGN KEY (sessao_id)
        REFERENCES sessoes(id)
);
