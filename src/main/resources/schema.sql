--Primero se deben borrar todas las tablas(de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada una de las aplicaciones (tkrun y descuento) se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:

drop table Sugerencias;
create table Sugerencias (idArticulo varchar(32), idRevisor varchar(32));

drop table Usuarios;
create table Usuarios(idUsuario varchar(32) primary key, nombre varchar(32), tipoUsuario varchar(32));

drop table Revisores;
create table Revisores (idRevisor varchar(32) primary key, nombre varchar(32), estado varchar(32), correo varchar(32), especialidad varchar(32));

drop table Articulos;
create table Articulos (idArticulo varchar(32) primary key, titulo varchar(32), primerAutor varchar(32), estado varchar(32), resumen varchar(100), palabrasClave varchar(32), ficheroFuente varchar(32), cartaPresentacion varchar(32), CV varchar(32), firma bool, vecesRevisado int, versionDefinitiva bool, DOI varchar(32),fecha varchar(32), volumen int, pendienteDeCambios boolean);

drop table Autores;
create table Autores (idAutor varchar(32) primary key, nombre varchar(32), dni varchar(32));

drop table AutoresSecundarios;
create table AutoresSecundarios (idArticulo varchar(32), idAutor varchar(32), tipoAutor varchar(32));

drop table Revisiones;
create table Revisiones (idArticulo varchar(32), idRevisor varchar(32), numeroRevision int, fecha varchar(32), comentariosAutor varchar(100), comentariosEditor varchar(100), decision varchar(50), enviarAlEditor bool, estadoDeLaPropuesta varchar(32),
	constraint pk_revisiones primary key (idArticulo, idRevisor, numeroRevision));
