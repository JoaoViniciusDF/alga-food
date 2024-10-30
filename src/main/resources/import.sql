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