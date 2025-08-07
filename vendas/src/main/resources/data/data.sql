
CREATE SEQUENCE seq_messages START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_views START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_tables START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_columns START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_rows START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_fields START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE seq_buttons START WITH 1 INCREMENT BY 1;


INSERT INTO city (id, name) values (nextval('seq_city'), 'Orlândia');

insert into CLIENT(id, name, cpf, birth_date, register_date, email, cellphone, send_promotions, idcity, address, number_address, district, observation) 
values (nextval('seq_client'), 'Caio', '11111111111', '2002-06-09', '2022-11-10', 'email@gmail.com', '(10) 9 9999-9999', true, (select min(id) from city), 'Avenida J', 'bloco e', 'jardim', 'dev');
insert into CLIENT(id, name, cpf, birth_date, register_date) values (nextval('seq_client'), 'Esther', '22222222222', '2004-03-08', now());

/* DO NOT CHANGE THE NAME OF COLUMNS, SPECIFICALLY ORDER_{SOMETHING} */


--CLIENTS
INSERT INTO views(id, key_View, name, idtable) values
(NEXTVAL('seq_views'), 'view.client', 'Client View Default', null)
;

INSERT INTO rows_view(id, order_row, style_class, condition, idview) values
(NEXTVAL('seq_rows'), 1, null, 'this.clientForm.value.id != null', (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_rows'), 2, null, null, (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_rows'), 3, null, null, (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_rows'), 4, null, null, (SELECT id FROM views WHERE key_View = 'view.client'))
;

INSERT INTO fields_view(id, key_field, prop, order_field, type, style_class, style_find_class, mask, active, readonly, idrow) values
(NEXTVAL('seq_fields'), 'field.client.id', 'id', 1, 'text', 'col-md-1 col-sm-2 col-4', 'col-md-6 col-4', null, true, true, (SELECT id FROM rows_view WHERE order_row = 1 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.registerDate', 'registerDate', 2, 'date', 'col-md-2 col-sm-4 col-6', 'col-md-6 col-12', null, true, true, (SELECT id FROM rows_view WHERE order_row = 1 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.name', 'name', 3, 'text', 'col-md-3 col-sm-6 col-12', 'col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.cpf', 'cpf', 4, 'text', 'col-md-2 col-sm-4 col-6', 'col-md-6 col-12', '000.000.000-00', true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.birthDate', 'birthDate', 5, 'date', 'col-md-2 col-sm-4 col-6', 'col-md-6 col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.email', 'email', 6, 'text', 'col-md-4 col-sm-6 col-8', 'col-md-8 col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.cellphone', 'cellphone', 7, 'text', 'col-md-2 col-sm-4 col-5', 'col-md-6 col-12', '(00) 0 0000-0000', true, false, (SELECT id FROM rows_view WHERE order_row = 3 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.address', 'address', 8, 'text', 'col-md-4 col-sm-6 col-8', 'col-md-8 col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 3 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.numberAddress', 'numberAddress', 9, 'text', 'col-md-2 col-sm-4 col-8', 'col-md-4 col-8', null, true, false, (SELECT id FROM rows_view WHERE order_row = 3 and idview = (SELECT id FROM views WHERE key_View = 'view.client'))),
(NEXTVAL('seq_fields'), 'field.client.observation', 'observation', 10, 'textarea', 'col-md-12 col-sm-12 col-12', 'col-md-12 col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 4 and idview = (SELECT id FROM views WHERE key_View = 'view.client')))
;

INSERT INTO buttons_view(id, key_button, order_button, action, style_class, icon_class, condition, disable, idview) values
(NEXTVAL('seq_buttons'), 'button.save', 1, 'this.submit()', 'btn btn-success', 'fa fa-save mr-2', null, '!this.clientForm.valid || this.clientForm.value.id != null', (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_buttons'), 'button.clear', 2, 'this.clear()', 'btn btn-primary', 'fa fa-eraser mr-2', null, null, (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_buttons'), 'button.alter', 3, 'this.alter()', 'btn btn-warning', 'fa fa-pen mr-2', 'this.clientForm.value.id != null', null, (SELECT id FROM views WHERE key_View = 'view.client')),
(NEXTVAL('seq_buttons'), 'button.delete', 4, 'this.delete()', 'btn btn-danger', 'fa fa-trash mr-2', 'this.clientForm.value.id != null', null, (SELECT id FROM views WHERE key_View = 'view.client'))
;

INSERT INTO VIEW_KEY_LIST_MESSAGES(view_id, key_list_messages) VALUES
((SELECT id FROM views WHERE key_View = 'view.client'), 'view.client.title'),
((SELECT id FROM views WHERE key_View = 'view.client'), 'view.client.register'),
((SELECT id FROM views WHERE key_View = 'view.client'), 'view.client.edit'),
((SELECT id FROM views WHERE key_View = 'view.client'), 'view.client.registered'),
((SELECT id FROM views WHERE key_View = 'view.client'), 'field.client.filter'),
((SELECT id FROM views WHERE key_View = 'view.client'), 'button.find')
;

INSERT INTO tables_view(id, key_table, name, page_sizes) values
(NEXTVAL('seq_tables'), 'table.client', 'Client Table Default', '5, 15')
;

UPDATE views SET idtable = (SELECT min(id) FROM tables_view WHERE key_table = 'table.client') 
WHERE id = (SELECT min(id) FROM views WHERE key_view = 'view.client');

INSERT INTO columns_view(id, key_column, prop, position, active, idtable)
SELECT 
    nextval('seq_columns'), 
    replace(field.key_field, 'field.', 'column.'), 
    field.prop, 
    field.order_field, 
    CASE  
    WHEN field.prop IN ('name', 'cpf', 'birthDate', 'registerDate') THEN true 
    ELSE false 
    END,
    (SELECT min(id) FROM tables_view WHERE key_table = 'table.client')
FROM fields_view field 
WHERE key_field LIKE 'field.client.%';

-- (NEXTVAL('seq_columns'), 'column.client.name', 'name', 1, (SELECT id FROM tables_view WHERE key_table = 'table.client')),
-- (NEXTVAL('seq_columns'), 'column.client.cpf', 'cpf', 2, (SELECT id FROM tables_view WHERE key_table = 'table.client')),
-- (NEXTVAL('seq_columns'), 'column.client.birthDate', 'birthDate', 3, (SELECT id FROM tables_view WHERE key_table = 'table.client')),
-- (NEXTVAL('seq_columns'), 'column.client.registerDate', 'registerDate', 4, (SELECT id FROM tables_view WHERE key_table = 'table.client'))




--USERS
INSERT INTO views(id, key_View, name, idtable) values
(NEXTVAL('seq_views'), 'view.user', 'User View Default', null)
;

INSERT INTO rows_view(id, order_row, style_class, condition, idview) values
(NEXTVAL('seq_rows'), 1, null, 'this.userForm.value.id != null', (SELECT id FROM views WHERE key_View = 'view.user'))
;

INSERT INTO fields_view(id, key_field, prop, order_field, type, style_class, style_find_class, mask, active, readonly, idrow) values
(NEXTVAL('seq_fields'), 'field.user.id', 'id', 1, 'text', 'col-md-1 col-sm-2 col-4', 'col-md-6 col-4', null, true, true, (SELECT id FROM rows_view WHERE order_row = 1 and idview = (SELECT id FROM views WHERE key_View = 'view.user'))),
(NEXTVAL('seq_fields'), 'field.user.login', 'login', 2, 'text', 'col-md-2 col-sm-4 col-6', 'col-md-6 col-12', null, true, true , (SELECT id FROM rows_view WHERE order_row = 1 and idview = (SELECT id FROM views WHERE key_View = 'view.user'))),
(NEXTVAL('seq_fields'), 'field.user.name', 'name', 3, 'text', 'col-md-3 col-sm-6 col-12', 'col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.user'))),
(NEXTVAL('seq_fields'), 'field.user.locale', 'locale', 4, 'text', 'col-md-2 col-sm-4 col-6', 'col-md-6 col-12', null, true, false, (SELECT id FROM rows_view WHERE order_row = 2 and idview = (SELECT id FROM views WHERE key_View = 'view.user')))
;

INSERT INTO buttons_view(id, key_button, order_button, action, style_class, icon_class, condition, disable, idview) values
(NEXTVAL('seq_buttons'), 'button.save', 1, 'this.submit()', 'btn btn-success', 'fa fa-save mr-2', null, '!this.userForm.valid || this.userForm.value.id != null', (SELECT id FROM views WHERE key_View = 'view.user')),
(NEXTVAL('seq_buttons'), 'button.clear', 2, 'this.clear()', 'btn btn-primary', 'fa fa-eraser mr-2', null, null, (SELECT id FROM views WHERE key_View = 'view.user')),
(NEXTVAL('seq_buttons'), 'button.alter', 3, 'this.alter()', 'btn btn-warning', 'fa fa-pen mr-2', 'this.userForm.value.id != null', null, (SELECT id FROM views WHERE key_View = 'view.user')),
(NEXTVAL('seq_buttons'), 'button.delete', 4, 'this.delete()', 'btn btn-danger', 'fa fa-trash mr-2', 'this.userForm.value.id != null', null, (SELECT id FROM views WHERE key_View = 'view.user'))
;

INSERT INTO VIEW_KEY_LIST_MESSAGES(view_id, key_list_messages) VALUES
((SELECT id FROM views WHERE key_View = 'view.user'), 'view.user.title'),
((SELECT id FROM views WHERE key_View = 'view.user'), 'view.user.register'),
((SELECT id FROM views WHERE key_View = 'view.user'), 'view.user.edit'),
((SELECT id FROM views WHERE key_View = 'view.user'), 'view.user.registered'),
((SELECT id FROM views WHERE key_View = 'view.user'), 'field.user.filter'),
((SELECT id FROM views WHERE key_View = 'view.user'), 'button.find')
;

INSERT INTO tables_view(id, key_table, name, page_sizes) values
(NEXTVAL('seq_tables'), 'table.user', 'User Table Default', '5, 15')
;

UPDATE views SET idtable = (SELECT min(id) FROM tables_view WHERE key_table = 'table.user') 
WHERE id = (SELECT min(id) FROM views WHERE key_view = 'view.user');


INSERT INTO columns_view(id, key_column, prop, position, active, idtable)
SELECT 
    nextval('seq_columns'), 
    replace(field.key_field, 'field.', 'column.'), 
    field.prop, 
    field.order_field, 
    CASE  
    WHEN field.prop IN ('name', 'login', 'locale') THEN true 
    ELSE false 
    END,
    (SELECT min(id) FROM tables_view WHERE key_table = 'table.user')
FROM fields_view field 
WHERE key_field LIKE 'field.user.%';


-- INSERT INTO columns_view(id, key_column, prop, position, idtable) values
-- (NEXTVAL('seq_columns'), 'column.user.name', 'name', 1, (SELECT id FROM tables_view WHERE key_table = 'table.user')),
-- (NEXTVAL('seq_columns'), 'column.user.login', 'login', 2, (SELECT id FROM tables_view WHERE key_table = 'table.user')),
-- (NEXTVAL('seq_columns'), 'column.user.locale', 'locale', 3, (SELECT id FROM tables_view WHERE key_table = 'table.user'))
-- ;









INSERT INTO messages (id, locale, key_message, message_content) VALUES
(NEXTVAL('seq_messages'), 'pt', 'field.name.required','O campo nome é obrigatório.'),
(NEXTVAL('seq_messages'), 'es', 'field.name.required','El campo nombre es obligatorio.'),
(NEXTVAL('seq_messages'), 'en', 'field.name.required','The field name is required.'),
(NEXTVAL('seq_messages'), 'pt', 'field.cpf.required','O campo CPF é obrigatório.'),
(NEXTVAL('seq_messages'), 'es', 'field.cpf.required','El campo CPF es obligatorio.'),
(NEXTVAL('seq_messages'), 'en', 'field.cpf.required','The field CPF is required.'),
(NEXTVAL('seq_messages'), 'pt', 'field.cpf.invalid','CPF inválido.'),
(NEXTVAL('seq_messages'), 'es', 'field.cpf.invalid','CPF inválido.'),
(NEXTVAL('seq_messages'), 'en', 'field.cpf.invalid','CPF invalid.'),
(NEXTVAL('seq_messages'), 'pt', 'field.email.invalid','Email inválido.'),
(NEXTVAL('seq_messages'), 'es', 'field.email.invalid','Email inválido.'),
(NEXTVAL('seq_messages'), 'en', 'field.email.invalid','Email invalid.'),
(NEXTVAL('seq_messages'), 'pt', 'button.save','Salvar'),
(NEXTVAL('seq_messages'), 'es', 'button.save','Guardar'),
(NEXTVAL('seq_messages'), 'en', 'button.save','Save'),
(NEXTVAL('seq_messages'), 'pt', 'button.clear','Limpar'),
(NEXTVAL('seq_messages'), 'es', 'button.clear','Limpiar'),
(NEXTVAL('seq_messages'), 'en', 'button.clear','Clear'),
(NEXTVAL('seq_messages'), 'pt', 'button.alter','Alterar'),
(NEXTVAL('seq_messages'), 'es', 'button.alter','Modificar'),
(NEXTVAL('seq_messages'), 'en', 'button.alter','Alter'),
(NEXTVAL('seq_messages'), 'pt', 'button.delete','Excluir'),
(NEXTVAL('seq_messages'), 'es', 'button.delete','Eliminar'),
(NEXTVAL('seq_messages'), 'en', 'button.delete','Delete'),
(NEXTVAL('seq_messages'), 'pt', 'button.find','Buscar'),
(NEXTVAL('seq_messages'), 'es', 'button.find','Buscar'),
(NEXTVAL('seq_messages'), 'en', 'button.find','Find'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.id','ID'),
(NEXTVAL('seq_messages'), 'es', 'field.client.id','ID'),
(NEXTVAL('seq_messages'), 'en', 'field.client.id','ID'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.name','Nome'),
(NEXTVAL('seq_messages'), 'es', 'field.client.name','Nombre'),
(NEXTVAL('seq_messages'), 'en', 'field.client.name','Name'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.name','Nome'),
(NEXTVAL('seq_messages'), 'es', 'column.client.name','Nombre'),
(NEXTVAL('seq_messages'), 'en', 'column.client.name','Name'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.registerDate','Data de registro'),
(NEXTVAL('seq_messages'), 'es', 'field.client.registerDate','Fecha de registro'),
(NEXTVAL('seq_messages'), 'en', 'field.client.registerDate','Register Date'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.registerDate','Data de registro'),
(NEXTVAL('seq_messages'), 'es', 'column.client.registerDate','Fecha de registro'),
(NEXTVAL('seq_messages'), 'en', 'column.client.registerDate','Register Date'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'es', 'field.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'en', 'field.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'es', 'column.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'en', 'column.client.cpf','CPF'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.birthDate','Data de nascimento'),
(NEXTVAL('seq_messages'), 'es', 'field.client.birthDate','Fecha de nacimiento'),
(NEXTVAL('seq_messages'), 'en', 'field.client.birthDate','Birth Date'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.birthDate','Data de nascimento'),
(NEXTVAL('seq_messages'), 'es', 'column.client.birthDate','Fecha de nacimiento'),
(NEXTVAL('seq_messages'), 'en', 'column.client.birthDate','Birth Date'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.email','E-mail'),
(NEXTVAL('seq_messages'), 'es', 'field.client.email','Correo electrónico'),
(NEXTVAL('seq_messages'), 'en', 'field.client.email','Email'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.email','E-mail'),
(NEXTVAL('seq_messages'), 'es', 'column.client.email','Correo electrónico'),
(NEXTVAL('seq_messages'), 'en', 'column.client.email','Email'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.cellphone','Celular'),
(NEXTVAL('seq_messages'), 'es', 'field.client.cellphone','Telemóvel'),
(NEXTVAL('seq_messages'), 'en', 'field.client.cellphone','Cellphone'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.cellphone','Celular'),
(NEXTVAL('seq_messages'), 'es', 'column.client.cellphone','Telemóvel'),
(NEXTVAL('seq_messages'), 'en', 'column.client.cellphone','Cellphone'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.address','Endereço'),
(NEXTVAL('seq_messages'), 'es', 'field.client.address','Dirección'),
(NEXTVAL('seq_messages'), 'en', 'field.client.address','Address'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.address','Endereço'),
(NEXTVAL('seq_messages'), 'es', 'column.client.address','Dirección'),
(NEXTVAL('seq_messages'), 'en', 'column.client.address','Address'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.numberAddress','Número do Endereço'),
(NEXTVAL('seq_messages'), 'es', 'field.client.numberAddress','Número de Dirección'),
(NEXTVAL('seq_messages'), 'en', 'field.client.numberAddress','Address Number'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.numberAddress','Número do Endereço'),
(NEXTVAL('seq_messages'), 'es', 'column.client.numberAddress','Número de Dirección'),
(NEXTVAL('seq_messages'), 'en', 'column.client.numberAddress','Address Number'),
(NEXTVAL('seq_messages'), 'pt', 'field.client.observation','Observação'),
(NEXTVAL('seq_messages'), 'es', 'field.client.observation','Observación'),
(NEXTVAL('seq_messages'), 'en', 'field.client.observation','Observation'),
(NEXTVAL('seq_messages'), 'pt', 'column.client.observation','Observação'),
(NEXTVAL('seq_messages'), 'es', 'column.client.observation','Observación'),
(NEXTVAL('seq_messages'), 'en', 'column.client.observation','Observation'),

(NEXTVAL('seq_messages'), 'pt', 'view.dashboard.title','Dashboard'),
(NEXTVAL('seq_messages'), 'es', 'view.dashboard.title','Tablero'),
(NEXTVAL('seq_messages'), 'en', 'view.dashboard.title','Dashboard'),
(NEXTVAL('seq_messages'), 'pt', 'view.client.title','Clientes'),
(NEXTVAL('seq_messages'), 'es', 'view.client.title','Clientes'),
(NEXTVAL('seq_messages'), 'en', 'view.client.title','Clients'),
(NEXTVAL('seq_messages'), 'pt', 'view.user.title','Usuários'),
(NEXTVAL('seq_messages'), 'es', 'view.user.title','Usuarios'),
(NEXTVAL('seq_messages'), 'en', 'view.user.title','Users')
;



