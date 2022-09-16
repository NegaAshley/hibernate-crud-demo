# Getting Started

### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.3/maven-plugin/reference/html/#build-image)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [JDBC API](https://docs.spring.io/spring-boot/docs/2.7.3/reference/htmlsingle/#data.sql)

### Guides

The following guides illustrate how to use some features concretely:

* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Accessing data with MySQL](https://spring.io/guides/gs/accessing-data-mysql/)
* [Accessing Relational Data using JDBC with Spring](https://spring.io/guides/gs/relational-data-access/)
* [Managing Transactions](https://spring.io/guides/gs/managing-transactions/)

For mySQL table creation

CREATE DATABASE IF NOT EXISTS `hb_employee_tracker`
USE `hb_employee_tracker`;

-- Table structure for table `employee`

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee`(
`id` int(11) NOT NULL AUTO_INCREMENT,
`first_name` varchar(45) DEFAULT NULL,
`last_name` varchar(45) DEFAULT NULL,
`company` varchar(45) DEFAULT NULL,
PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;