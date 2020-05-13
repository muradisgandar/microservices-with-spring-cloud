CREATE KEYSPACE springcloud
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

use springcloud;

CREATE TABLE accounts(
                    id varchar PRIMARY KEY,
                    name varchar,
                    uname varchar,
                    surname varchar,
                    birth_date timestamp,
                    pwd varchar,
                    email varchar,
                    created_at,
                    is_active boolean
);

select * from accounts