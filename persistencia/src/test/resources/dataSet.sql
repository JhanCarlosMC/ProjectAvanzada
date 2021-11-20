insert into ciudad values (1, "Armenia");
insert into ciudad values (2, "Pereira");
insert into ciudad values (3, "Manizales");

insert into usuario values ("1", "juan@gmail.com", "Juan", "1234", '1');
insert into usuario values ("2", "jhan@gmail.com", "Jhan", "4321", '2');
insert into usuario values ("3", "sebas@gmail.com", "Sebastian", "0000", '1');
insert into usuario values ("4", "Honores@gmail.com", "Michael", "1111", '3');

insert into usuario_num_telefonos values ("2", "3113608329", "1");
insert into usuario_num_telefonos values ("3", "3203749382", "2");
insert into usuario_num_telefonos values ("1", "3103763821", "3");
insert into usuario_num_telefonos values ("4", "3003783622", "4");

insert into categoria values ("1", "Electodomestico");
insert into categoria values ("2", "Cosmetico");
insert into categoria values ("3", "Hogar");

insert into compra values ("1", "2021-10-18", '0', "1");
insert into compra values ("2", "2021-10-18", '1', "1");
insert into compra values ("3", "2021-10-18", '2', "1");

insert into producto values ("1", "Sirve para guardar agua", '10', "2021-10-20", "Botella de agua", '100', '2','1', '1');
insert into producto values ("2", "Lo ultimo en waracha", '20', "2021-10-20", "Play 8", '99999', '10','2', '2');
insert into producto values ("3", "Celuco", '30', "2021-10-20", "Iphone 15", '15032', '5','3', '3');

insert into producto_categorias values ("2","1");
insert into producto_categorias values ("3","1");

insert into producto_imagenes values ("1","BotellaAgua.jpg","1");
insert into producto_imagenes values ("3","Iphone15.jpg","2");

insert into Detalle_Compra values("1", '20000', '12', '1', '1');
insert into Detalle_Compra values("2", '40000', '11', '2', '2');
insert into Detalle_Compra values("3", '30000', '20', '3', '3');

insert into comentario values ("1", '5', "2021-10-18", "Precio?", "En la publicacion esta", '1', '1');
insert into comentario values ("2", '3', "2021-10-18", "Exelente producto", "Si sirve??", '2', '2');
insert into comentario values ("3", '1', "2021-10-18", "No me llego", "Compre amazon prime", '3', '3');

insert into subasta values ("1", "2021-10-18", '1');
insert into subasta values ("2", "2021-10-18", '2');
insert into subasta values ("3", "2021-10-18", '3');

insert into detalle_subasta values ("1", "2021-10-18",'30000', '1', '1');
insert into detalle_subasta values ("2", "2021-10-18",'40000', '2', '2');
insert into detalle_subasta values ("3", "2021-10-18",'50000', '3', '3');

insert into administrador values ('123','juan@mail.com','juan jacinto','12345');
insert into administrador values ('124','jhan@mail.com','jhan','contrasenia');
insert into administrador values ('125','josesito@mail.com','juan jose','password');

insert into chat values ("1", "1", "1");
insert into chat values ("2", "2", "2");
insert into chat values ("3", "3", "3");

insert into Mensaje values("1", "Jhan", "2021-12-01", "hola", "1");
insert into Mensaje values("2", "micha", "2021-12-01", "hola","2");
insert into Mensaje values("3", "pedro", "2021-12-01", "hola", "3");