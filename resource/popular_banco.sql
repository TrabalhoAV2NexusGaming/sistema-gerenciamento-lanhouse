USE nexus_gaming_system;

INSERT INTO clientes
(nome, cpf, telefone, nickname, pontos, saldo_horas)
VALUES
('Eduardo Vieira', '111.111.111-11', '(47)99999-1111', 'EduFPS', 150, 2.5),

('Lucas Mendes', '222.222.222-22', '(47)99999-2222', 'MendesX', 80, 1.0),

('Ana Clara', '333.333.333-33', '(47)99999-3333', 'AnaPlayer', 230, 4.0);

INSERT INTO equipamentos
(nome, numero, tipo, valor_hora, status,
processador, memoria_ram, placa_video,
marca_console, geracao_console)
VALUES

('PC Gamer RTX', 1, 'COMPUTADOR', 12.00, 'LIVRE',
'Ryzen 7', 32, 'RTX 4070',
NULL, NULL),

('PC Intermediario', 2, 'COMPUTADOR', 8.00, 'OCUPADO',
'Core i5', 16, 'RTX 3060',
NULL, NULL),

('PlayStation 5', 3, 'PLAYSTATION', 15.00, 'LIVRE',
NULL, NULL, NULL,
'Sony', 'PS5'),

('Xbox Series X', 4, 'XBOX', 14.00, 'MANUTENCAO',
NULL, NULL, NULL,
'Microsoft', 'Series X');

INSERT INTO funcionarios
(nome, usuario, senha, cargo)
VALUES

('Carlos Silva', 'carlos', '123456', 'ADMIN'),

('Fernanda Lima', 'fernanda', '654321', 'ATENDENTE');

INSERT INTO promocoes
(nome, horario_inicio, horario_fim, valor_fixo)
VALUES

('Corujao', '22:00:00', '06:00:00', 35.00),

('Happy Hour Gamer', '18:00:00', '20:00:00', 20.00);

INSERT INTO sessoes
(cliente_id, equipamento_id, promocao_id,
horario_inicio, horario_fim,
tempo_contratado, valor_total, ativa)
VALUES

(1, 1, NULL,
'2026-05-31 14:00:00',
'2026-05-31 16:00:00',
120, 24.00, FALSE),

(2, 3, 1,
'2026-05-31 22:00:00',
NULL,
480, 35.00, TRUE);

INSERT INTO pagamentos
(sessao_id, valor, data_pagamento, tipo_pagamento)
VALUES

(1, 24.00, '2026-05-31', 'PIX'),

(2, 35.00, '2026-05-31', 'CARTAO');
