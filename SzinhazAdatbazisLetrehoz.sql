create database szinhaz_eloadasok_db;

use szinhaz_eloadasok_db;

create table eloadasok (

   cim varchar(50) NOT NULL PRIMARY KEY,
   rendezo varchar(50) NOT NULL,
   bemutato datetime NOT NULL,
   eloadas_szam int NOT NULL);
    
insert into eloadasok VALUES ('Made in Hungária','Lengyel Ferenc','2022-10-01',30);
insert into eloadasok VALUES ('Moby Dick','Fekete Ádám','2022-10-07',40);
insert into eloadasok VALUES ('Inkognitó','Szőcs Artúr','2022-10-22',35);
insert into eloadasok VALUES ('A tanú','Böhm György','2022-09-30',50);
insert into eloadasok VALUES ('A képzelt beteg','Zakariás Zalán','2022-09-30',100);




