# Fico
### Financial control System   
![Fico][4]

### Setup Development  

1. Create Table Security    
```sql
create table users (username varchar(50) not null primary key, password varchar(255) not null,    enabled boolean not null) engine = InnoDb;create table authorities (    username varchar(50) not null,    authority varchar(50) not null,    foreign key (username) references users (username),    unique index authorities_idx_1 (username, authority)) engine = InnoDb;
```   

1. Populate Data Basic   
```sql
insert into Category(name) values('Alimentação');
insert into Category(name) values('Lazer');
insert into Category(name) values('Moradia');
insert into Category(name) values('Salário');
insert into Category(name) values('Saúde');
insert into Category(name) values('Transporte');
insert into Category(name) values('Combustível');
insert into Category(name) values('Outros');
```   


Libraries
---------
* Java
* SpringBoot
* Spring IoC
* Spring Data
* Spring Security
* JPA
* Hibernate
* HTML
* Thymeleaf
* MySQL
* Maven
* Twitter Bootstrap
* Font-Awesome
* JQuery
* AngularJS

License
-------
[![MIT][0]][1]   
Licensed under an [MIT-style permissive license][0].   

Open Source
-----------
[![Open Source][2]][3]  

[0]: https://raw.githubusercontent.com/fabianogoes/Fico/master/src/main/resources/static/img/mit-license.png
[1]: https://raw.githubusercontent.com/fabianogoes/Fico/master/LICENSE
[2]: https://raw.githubusercontent.com/fabianogoes/Fico/master/src/main/resources/static/img/opensource-iniciative.png
[3]: https://en.wikipedia.org/wiki/Open_Source_Initiative
[4]: https://raw.githubusercontent.com/fabianogoes/Fico/master/src/main/resources/static/img/print-dashboard.png
