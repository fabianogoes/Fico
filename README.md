# Fico
### Financial control System   
![Fico][4]

title: Fico - Financial control System
author: 
   - Author Fabiano Góes
institute: 
   - Guarulhos, SP, Brasil
date: "Saturday, July 01, 2016"

### Setup Development  

1. Create Table Security    
```sql
create table users (username varchar(50) not null primary key, password varchar(255) not null,    enabled boolean not null) engine = InnoDb;create table authorities (    username varchar(50) not null,    authority varchar(50) not null,    foreign key (username) references users (username),    unique index authorities_idx_1 (username, authority)) engine = InnoDb;
```   

2. Populate Data Basic   
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


Libraries / Tools
---------
* [Java][21]
* [SpringBoot][15]
* [Spring IoC][16]
* [Spring Data][17]
* [Spring Security][18]
* [JPA][19]
* [Hibernate][20]
* [HTML][22]
* [Thymeleaf][14]
* [MySQL][13]
* [Apache Tomcat][12]
* [Apache Maven][11]
* [Twitter Bootstrap][9]
* [Font-Awesome][10]
* [JQuery][7]
* [JQueryUI][8]
* [AngularJS][6]
* [SweetAlert][5]

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
[5]: http://t4t5.github.io/sweetalert/
[6]: https://angularjs.org/
[7]: http://jquery.com/
[8]: https://jqueryui.com/
[9]: http://getbootstrap.com/
[10]: http://fontawesome.io/
[11]: http://maven.apache.org/
[12]: http://tomcat.apache.org/
[13]: https://www.mysql.com/
[14]: http://www.thymeleaf.org/
[15]: http://projects.spring.io/spring-boot/
[16]: http://docs.spring.io/spring/docs/current/spring-framework-reference/html/beans.html
[17]: http://projects.spring.io/spring-data/
[18]: http://projects.spring.io/spring-security/
[19]: https://pt.wikipedia.org/wiki/Java_Persistence_API
[20]: http://hibernate.org/
[21]: http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html
[22]: https://pt.wikipedia.org/wiki/HTML