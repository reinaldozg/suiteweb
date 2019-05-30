/* INSERIR CORES PARA O LAYOUT DO SISTEMA */
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (0, 'default', '#8bc43f', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (1, 'green', '#8bc43f', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (2, 'red', '#FB494D', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (3, 'orange', '#FE7A0E', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (4, 'seagreen', '#4bcf99', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (5, 'blue', '#52BCD3', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (6, 'purple', '#7867A7', true);
INSERT INTO tbl_layout(id, tema, paleta_hexa, ativa) VALUES (7, 'brown', '#62462B', true);


/*PERMISSÕES*/
INSERT INTO tbl_role(id, role) VALUES (1, 'SUPORTE');
INSERT INTO tbl_role(id, role) VALUES (2, 'GERENTE');
INSERT INTO tbl_role(id, role) VALUES (3, 'GESTOR');
INSERT INTO tbl_role(id, role) VALUES (4, 'USUARIO');

/*USUARIO*/
INSERT INTO tbl_usuario(id, dt_atualizacao, excluido, email, nome, sobre_nome, senha, rest_reset, rest_validade, theme_id) VALUES (0,now(), false, 'suporte@suporte.com', 'Suporte', 'Sistema', '$2a$10$kaUCEfEH9DQ.C8DDdv36CeiRAbUvd79j6tLkGdWDm0jrpDXguCJ9S', null,null,0);
INSERT INTO tbl_usuario(id, dt_atualizacao, excluido, email, nome, sobre_nome, senha, rest_reset, rest_validade, theme_id) VALUES (1,now(), false, 'usuario@suporte.com', 'Usuario', 'Usuario', '$2a$10$kaUCEfEH9DQ.C8DDdv36CeiRAbUvd79j6tLkGdWDm0jrpDXguCJ9S', null,null,2);
INSERT INTO tbl_usuario(id, dt_atualizacao, excluido, email, nome, sobre_nome, senha, rest_reset, rest_validade, theme_id) VALUES (2,now(), false, 'adm@suporte.com', 'ADM', 'ADM', '$2a$10$kaUCEfEH9DQ.C8DDdv36CeiRAbUvd79j6tLkGdWDm0jrpDXguCJ9S', null,null,3);
INSERT INTO tbl_usuario(id, dt_atualizacao, excluido, email, nome, sobre_nome, senha, rest_reset, rest_validade, theme_id) VALUES (3,now(), false, 'user@suporte.com', 'User', 'User', '$2a$10$kaUCEfEH9DQ.C8DDdv36CeiRAbUvd79j6tLkGdWDm0jrpDXguCJ9S', null,null,4);

/*MENU*/
/*  INSERT INTO tbl_menu(id, descricao, icone) VALUES (1, 'Suporte-ADM', 'fa fa-fw fa-dashboard'); */
/*	INSERT INTO tbl_menu(id, descricao, icone) VALUES (2, 'Acesso', 'fa fa-fw fa-dashboard'); */
/*	INSERT INTO tbl_menu(id, descricao, icone) VALUES (3, 'Cliente', 'fa fa-fw fa-area-chart'); */
	
/*ITEM DO MENU*/
/*  INSERT INTO tbl_menu_item( id, descricao, icone, acao) VALUES (1, 'Menu', 'fa fa-fw fa-table', '/suporte/buscar'); */
/*	INSERT INTO tbl_menu_item( id, descricao, icone, acao) VALUES (2, 'Permissões', 'fa fa-fw fa-area-chart', '/usuario'); */
/*	INSERT INTO tbl_menu_item( id, descricao, icone, acao) VALUES (3, 'Grupos', 'fa fa-fw fa-table', '/usuario'); */


/*RELACIONAMENTO ENTRE MENU E ITEM DO MENU*/
/*  INSERT INTO tbl_rel_menu_item(menu_id, item_id) VALUES (1, 1); */
/*	INSERT INTO tbl_rel_menu_item(menu_id, item_id) VALUES (2, 2); */
/*	INSERT INTO tbl_rel_menu_item(menu_id, item_id) VALUES (3, 3); */

/*RELACIONAMENTO MENU E PERMISSÃO*/
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (1, 1); */
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (2, 1); */
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (2, 2); */
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (3, 1); */
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (3, 2); */ 
/*	INSERT INTO tbl_rel_menu_role(menu_id, role_id) VALUES (3, 3); */


/*SUPORTE*/
/*	INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (1, 1); */
/*  INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (2, 1); */
/*	INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (3, 1); */

/*GERENTE*/
/* INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (2, 2); */
/* INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (3, 2); */

/*USUARIO*/
/* INSERT INTO tbl_rel_menu_item_role(menu_item_id, role_id) VALUES (3, 3);*/


/*RELACIONAMENTO USUARIO E PERMISSÃO*/
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (0, 1);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (0, 2);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (0, 3);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (0, 4);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (1, 1);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (1, 2);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (1, 3);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (1, 4);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (2, 1);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (2, 2);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (2, 3);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (2, 4);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (3, 1);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (3, 2);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (4, 3);
INSERT INTO tbl_usuario_role(usuario_id, role_id) VALUES (4, 4);


INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (1, '04-07-2018', false, '12345678973', 'Razão Social 1', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (2, '04-07-2018', false, '22345678963', 'Razão Social 2', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (3, '04-07-2018', false, '32345678953', 'Razão Social 3', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (4, '04-07-2018', false, '12345678943', 'Razão Social 4', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (5, '04-07-2018', false, '22345678933', 'Razão Social 5', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (6, '04-07-2018', false, '32345678123', 'Razão Social 6', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (7, '04-07-2018', false, '42341178913', 'Razão Social 7', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (8, '04-07-2018', false, '52340078913', 'Razão Social 8', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (9, '04-07-2018', false, '62349978913', 'Razão Social 9', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (10, '04-07-2018', false, '42388678913', 'Razão Social 10', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (11, '04-07-2018', false, '52377678913', 'Razão Social 11', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (12, '04-07-2018', false, '62366678913', 'Razão Social 12', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (13, '04-07-2018', false, '42344678913', 'Razão Social 13', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (14, '04-07-2018', false, '52333678913', 'Razão Social 14', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (15, '04-07-2018', false, '62322678913', 'Razão Social 15', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (16, '04-07-2018', false, '42323678913', 'Razão Social 16', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (17, '04-07-2018', false, '52345674313', 'Razão Social 17', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (18, '04-07-2018', false, '62345670913', 'Razão Social 18', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (19, '04-07-2018', false, '42345678913', 'Razão Social 19', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (20, '04-07-2018', false, '52345675613', 'Razão Social 20', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (21, '04-07-2018', false, '62345672413', 'Razão Social 21', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (22, '04-07-2018', false, '42345671213', 'Razão Social 22', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (23, '04-07-2018', false, '52345673313', 'Razão Social 23', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (24, '04-07-2018', false, '62345675513', 'Razão Social 24', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (25, '04-07-2018', false, '42345676613', 'Razão Social 25', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (26, '04-07-2018', false, '52345677713', 'Razão Social 26', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (27, '04-07-2018', false, '62387678913', 'Razão Social 27', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (28, '04-07-2018', false, '42312678913', 'Razão Social 28', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (29, '04-07-2018', false, '52323678913', 'Razão Social 29', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (30, '04-07-2018', false, '62345678913', 'Razão Social 30', false);

INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (31, '04-07-2018', false, '42388678923', 'Razão Social 40', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (32, '15-07-2018', false, '52377678933', 'Razão Social 41', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (33, '07-07-2018', false, '62366678943', 'Razão Social 52', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (34, '08-07-2018', false, '42344678923', 'Razão Social 53', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (35, '09-07-2018', false, '52333678919', 'Razão Social 54', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (36, '10-07-2018', false, '62322678918', 'Razão Social 55', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (37, '04-07-2018', false, '42323678917', 'Razão Social 56', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (38, '04-07-2018', false, '52345674316', 'Razão Social 57', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (39, '04-07-2018', false, '62345670915', 'Razão Social 58', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (40, '20-07-2018', false, '42345678914', 'Razão Social 59', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (41, '04-07-2018', false, '52345675612', 'Razão Social 60', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (42, '04-07-2018', false, '62345672411', 'Razão Social 61', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (42, '25-07-2018', false, '42345670210', 'Razão Social 62', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (43, '04-07-2018', false, '52345679313', 'Razão Social 63', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (44, '04-07-2018', false, '62345678513', 'Razão Social 64', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (45, '13-07-2018', false, '42345676613', 'Razão Social 65', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (46, '04-07-2018', false, '52345667713', 'Razão Social 66', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (47, '04-07-2018', false, '62387658913', 'Razão Social 67', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (48, '04-07-2018', false, '42312648913', 'Razão Social 68', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (49, '04-07-2018', false, '52323638913', 'Razão Social 69', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (50, '04-07-2018', false, '62345628913', 'Razão Social 60', false);

INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (51, '04-07-2018', false, '42389678923', 'Razão Social 70', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (52, '15-07-2018', false, '52379578933', 'Razão Social 71', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (53, '07-07-2018', false, '62369478943', 'Razão Social 72', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (54, '08-07-2018', false, '42349378923', 'Razão Social 73', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (55, '09-07-2018', false, '52339278919', 'Razão Social 74', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (56, '10-07-2018', false, '62328178918', 'Razão Social 75', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (57, '04-07-2018', false, '42327978917', 'Razão Social 76', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (58, '04-07-2018', false, '52343074316', 'Razão Social 77', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (59, '04-07-2018', false, '62346770915', 'Razão Social 78', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (60, '20-07-2018', false, '42346748914', 'Razão Social 79', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (61, '07-08-2018', false, '52346675612', 'Razão Social 80', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (62, '04-09-2018', false, '62340672411', 'Razão Social 81', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (62, '25-06-2018', false, '42349670210', 'Razão Social 82', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (63, '04-05-2018', false, '52348679313', 'Razão Social 83', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (64, '04-04-2018', false, '62347678513', 'Razão Social 84', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (65, '13-03-2018', false, '42346676613', 'Razão Social 85', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (66, '05-02-2018', false, '52345667713', 'Razão Social 86', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (67, '04-01-2018', false, '62384658913', 'Razão Social 87', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (68, '03-07-2018', false, '42313648913', 'Razão Social 88', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (69, '04-03-2018', false, '52322638913', 'Razão Social 89', false);
INSERT INTO tbl_empresa(id, dt_atualizacao, excluido, cnpj_cpf, razao_social, sincronizando)VALUES (70, '04-07-2018', false, '62342628913', 'Razão Social 90', false);


