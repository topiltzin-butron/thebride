CREATE TABLE IF NOT EXISTS characters (
    id uuid,
    name text,
    creation_time timestamp,
    code_name text,
    actor_name text,
    weapon_of_choice text,
    group text,
    PRIMARY KEY ((id, name), creation_time)
) WITH CLUSTERING ORDER BY (creation_time DESC);

CREATE INDEX ON characters (id);
CREATE INDEX ON characters (name);

CREATE TABLE users (
    username text PRIMARY KEY,
    password text
);

CREATE TABLE followers (
    username text,
    follower text,
    since timestamp,
    PRIMARY KEY (username, follower)
);

CREATE TABLE following (
    username text,
    friend text,
    since timestamp,
    PRIMARY KEY (username, friend)
);

CREATE TABLE posts (
    post_id uuid PRIMARY KEY,
    username text,
    body text
);

CREATE TABLE user_timeline (
    username text,
    time timeuuid,
    post_id uuid,
    PRIMARY KEY (username, time)
) WITH CLUSTERING ORDER BY (time DESC);

CREATE TABLE timeline (
    username text,
    time timeuuid,
    post_id uuid,
    PRIMARY KEY (username, time)
) WITH CLUSTERING ORDER BY (time DESC);
