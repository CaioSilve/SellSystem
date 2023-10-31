insert into CLIENT(id, name, cpf, birth_date, register_date) values (1, 'Caio', '11111111111', '2002-06-09', '2022-11-10');
insert into CLIENT(id, name, cpf, birth_date, register_date) values (2, 'Esther', '22222222222', '2004-03-08', now());

INSERT INTO languages (id, locale, messagekey,messagecontent) VALUES
(1, 'pt', 'field.name.required','O campo nome é obrigatório.'),
(2, 'pt', 'field.cpf.required','O campo CPF é obrigatório.'),
(3, 'pt', 'field.cpf.invalid','CPF inválido.'),
(4, 'en', 'field.name.required','The field name is required.'),
(5, 'en', 'field.cpf.required','The field CPF is required.'),
(6, 'en', 'field.cpf.invalid','CPF invalid.'),
(7, 'en', 'button.save','Save'),
(8, 'en', 'button.alter','Alter'),
(9, 'en', 'button.delete','Delete'),
(10, 'en', 'button.find','Find'),
(11, 'en', 'field.name','Name'),
(12, 'en', 'field.registerDate','Register Date'),
(13, 'en', 'field.birthDate','Birth Date'),
(14, 'en', 'view.dashboard.title','Dashboard'),
(15, 'en', 'view.dashboard.description','Description'),
(16, 'en', 'view.client.title','Client'),
(17, 'en', 'view.client.description','Register'),
(18, 'en', 'view.client.registered','Clients Registered'),
(19, 'en', 'button.clear','Clear'),
(20, 'en', 'field.filter','Filter')
;