CREATE KEYSPACE IF NOT EXISTS library WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'}  AND durable_writes = true;

USE library;

CREATE TABLE if NOT EXISTS books_by_id (
    id uuid ,
    title text ,
    authors set<text > ,
    year int ,
    PRIMARY KEY ((id), title))
    with comment = 'Books'
    AND CLUSTERING order by (title desc);

insert into books_by_id (id, title , authors , year )
    values (uuid(), 'SAPIENS', {'Homo', 'SAPIENS'}, 2017);