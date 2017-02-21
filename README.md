# thebride

The Bride (Reference to Kill Bill movie) is a project to implement RESTful Web Services with HATEOAS.
The web service exposes CRUD operations for the characters of the movie. Also through the HAL browser which was taken from [mikekelly](https://github.com/mikekelly/hal-browser). Additionally there is a simplified version of a social media service.

I'm also using this Web service to implement a [React webapp](https://github.com/topiltzin-butron/react-app) and an [Angular 2 webapp](https://github.com/topiltzin-butron/angular-app). 

## Requirements
- Java 8
- Gradle 3
- Spring HATEOAS
- Cassandra 3 locally in a single node
- Datastax

## Steps

### 1. Create the Keyspace
- Start Cassandra and create keyspace
```
cqlsh> CREATE KEYSPACE taleme_ks WITH replication = {'class': 'SimpleStrategy', 'replication_factor' : 1};
cqlsh> USE taleme_ks;
```
To enable the app to connect to Cassandra, please check __/src/main/resources/conf/cassandra/cassandra.properties__

### 2. Run DDL

thebride-ddl.sql

### 3. Run DML

thebride-dml.sql


[My site](http://topi.cafeconleche.xyz)
