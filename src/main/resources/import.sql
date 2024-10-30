-- Inserts para a tabela `tbl_cozinha`
INSERT INTO tbl_cozinha (id, nome) VALUES (1, 'Italiana');
INSERT INTO tbl_cozinha (id, nome) VALUES (2, 'Japonesa');
INSERT INTO tbl_cozinha (id, nome) VALUES (3, 'Brasileira');
INSERT INTO tbl_cozinha (id, nome) VALUES (4, 'Mexicana');
INSERT INTO tbl_cozinha (id, nome) VALUES (5, 'Chinesa');

-- Inserts para a tabela `tbl_restaurante`, agora incluindo `taxa_frete`
INSERT INTO tbl_restaurante (id, nome, taxa_frete, ID_COZINHA) VALUES (1, 'Restaurante A', 5.00, 1);
INSERT INTO tbl_restaurante (id, nome, taxa_frete, ID_COZINHA) VALUES (2, 'Restaurante B', 7.50, 2);
INSERT INTO tbl_restaurante (id, nome, taxa_frete, ID_COZINHA) VALUES (3, 'Restaurante C', 6.25, 3);
INSERT INTO tbl_restaurante (id, nome, taxa_frete, ID_COZINHA) VALUES (4, 'Restaurante D', 8.40, 4);
INSERT INTO tbl_restaurante (id, nome, taxa_frete, ID_COZINHA) VALUES (5, 'Restaurante E', 4.80, 5);


INSERT INTO estado (id, nome) VALUES (1, 'Minas Gerais');
INSERT INTO estado (id, nome) VALUES (2, 'São Paulo');
INSERT INTO estado (id, nome) VALUES (3, 'Ceará');

INSERT INTO cidade (id, nome, estado_id) VALUES (1, 'Uberlândia', 1);
INSERT INTO cidade (id, nome, estado_id) VALUES (2, 'Belo Horizonte', 1);
INSERT INTO cidade (id, nome, estado_id) VALUES (3, 'São Paulo', 2);
INSERT INTO cidade (id, nome, estado_id) VALUES (4, 'Campinas', 2);
INSERT INTO cidade (id, nome, estado_id) VALUES (5, 'Fortaleza', 3);

INSERT INTO forma_pagamento (id, descricao) VALUES (1, 'Cartão de crédito');
INSERT INTO forma_pagamento (id, descricao) VALUES (2, 'Cartão de débito');
INSERT INTO forma_pagamento (id, descricao) VALUES (3, 'Dinheiro');

INSERT INTO permissao (id, nome, descricao) VALUES (1, 'CONSULTAR_COZINHAS', 'Permite consultar cozinhas');
INSERT INTO permissao (id, nome, descricao) VALUES (2, 'EDITAR_COZINHAS', 'Permite editar cozinhas');
    