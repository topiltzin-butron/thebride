// Deadly Viper Assassination Squad
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Beatrix Kiddo', toTimestamp(now()), 'Black Mamba', 'Uma Thurman', 'Hattori Hanzo sword', 'Deadly Viper Assassination Squad');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Bill', toTimestamp(now()), 'Snake Charmer', 'David Carradine', 'EMF Hartford Pinkerton chambered in .45', 'Deadly Viper Assassination Squad');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'O-Ren Ishii', toTimestamp(now()), 'Cottonmouth', 'Lucy Liu', 'H&K PSG-1 sniper rifle', 'Deadly Viper Assassination Squad');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Vernita Green', toTimestamp(now()), 'Copperhead', 'Vivica A. Fox', 'Walther PPK/S', 'Deadly Viper Assassination Squad');
// Leave these alone so you can add them later through the app
// INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Elle Driver', toTimestamp(now()), 'California Mountain Snake', 'Daryl Hannah', 'Poison', 'Deadly Viper Assassination Squad');
// INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Budd', toTimestamp(now()), 'Sidewinder', 'Michael Madsen', 'Hattori Hanzo sword', 'Deadly Viper Assassination Squad');

// Associates of O-Ren Ishii
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Sofie Fatale', toTimestamp(now()), '', 'Julie Dreyfus', 'Lawyer', 'Associates of O-Ren Ishii');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Gogo Yubari', toTimestamp(now()), '', 'Chiaki Kuriyama', 'Meteor hammer', 'Associates of O-Ren Ishii');
// Leave this one alone so you can add them later through the app
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Johnny Mo', toTimestamp(now()), '', 'Gordon Liu', 'Sword', 'Associates of O-Ren Ishii');

// Others
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Hattori Hanzo', toTimestamp(now()), '', 'Sonny Chiba', 'Swordsmith', 'Other');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Esteban Vallejo', toTimestamp(now()), '', 'Michael Parks', 'Mexican pimp', 'Other');
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Pai Mei', toTimestamp(now()), 'White Eyebrow', 'Gordon Liu', 'Five Point Palm Exploding Heart Technique', 'Other');
// Leave this on alone so you can add them later through the app
INSERT INTO characters (id, name, creation_time, code_name, actor_name, weapon_of_choice, group) VALUES (uuid(), 'Karen Kim', toTimestamp(now()), '', 'Helen Kim', 'Shotgun', 'Other');

INSERT INTO users (username, password) VALUES ('topi', 'mypassword');
INSERT INTO users (username, password) VALUES ('alex', 'mypassword');
INSERT INTO users (username, password) VALUES ('marcus', 'mypassword');
INSERT INTO users (username, password) VALUES ('dad', 'mypassword');
INSERT INTO users (username, password) VALUES ('georgie', 'mypassword');

INSERT INTO followers (username, follower, since) VALUES ('topi', 'alex', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('alex', 'topi', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('alex', 'marcus', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('alex', 'dad', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('alex', 'georgie', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('marcus', 'topi', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('marcus', 'georgie', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('dad', 'topi', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('dad', 'alex', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('georgie', 'topi', toTimestamp(now()));
INSERT INTO followers (username, follower, since) VALUES ('georgie', 'alex', toTimestamp(now()));

INSERT INTO following (username, friend, since) VALUES ('topi', 'alex', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('alex', 'dad', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('marcus', 'topi', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('marcus', 'alex', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('marcus', 'georgie', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('dad', 'topi', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('dad', 'alex', toTimestamp(now()));
INSERT INTO following (username, friend, since) VALUES ('georgie', 'alex', toTimestamp(now()));

INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 001');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'alex', 'Post number 002');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'marcus', 'Post number 003');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 004');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 005');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 006');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 007');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 008');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 009');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'marcus', 'Post number 010');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'alex', 'Post number 011');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 012');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 013');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 014');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 015');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'dad', 'Post number 016');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'alex', 'Post number 017');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'topi', 'Post number 018');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'marcus', 'Post number 019');
INSERT INTO posts (post_id, username, body) VALUES (uuid(), 'marcus', 'Post number 020');

INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 50de4f11-85c7-40cd-96ff-e064bab425c9);
INSERT INTO user_timeline (username, time, post_id) VALUES ('alex', now(), eac718d8-ca5e-46ff-a1e3-4d62ef1289f4);
INSERT INTO user_timeline (username, time, post_id) VALUES ('marcus', now(), 964c504c-1a92-4664-9cc0-eb73f2fc4f34);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), 490a7dc0-0f43-4f1c-a34b-2338c37e3bb7);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 3d8d176e-e5ec-4e6b-9255-c1dc38e85d99);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 7182e561-6608-4eaa-ac80-d032552709e0);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), e4e2a6c7-1014-422c-86c9-09492964a296);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 2e53e89a-0c17-4ae3-9ddf-d55ef0ffb5df);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), cb590c41-473b-4e0f-a295-8bc312cb7f73);
INSERT INTO user_timeline (username, time, post_id) VALUES ('marcus', now(), 7d1e8c60-49f1-430e-9fd1-dcded053713b);
INSERT INTO user_timeline (username, time, post_id) VALUES ('alex', now(), c1ee9085-931f-45e8-b012-bdb89d550780);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 917bd19c-7c3a-4ca2-af8e-c36157edcdae);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), 9fef5bd7-00d9-4e92-ab73-c68c77207d06);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), e92bc1ae-6e5d-41be-ab96-9cc1c515aafe);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), 328b3e78-ee08-48ae-926b-ed1faeca4499);
INSERT INTO user_timeline (username, time, post_id) VALUES ('dad', now(), 25f8f50b-3443-4797-85d9-f84ddbba9228);
INSERT INTO user_timeline (username, time, post_id) VALUES ('alex', now(), fa811d77-38c1-4832-98f2-981e2f10aaa9);
INSERT INTO user_timeline (username, time, post_id) VALUES ('topi', now(), 011cef7b-cacd-4994-836c-b043df3cd950);
INSERT INTO user_timeline (username, time, post_id) VALUES ('marcus', now(), d1e974ab-abb8-461b-b4f1-3ed36f581e5c);
INSERT INTO user_timeline (username, time, post_id) VALUES ('marcus', now(), 83892fe3-5344-4167-aa28-d5e68fbf0127);

INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 50de4f11-85c7-40cd-96ff-e064bab425c9);
INSERT INTO timeline (username, time, post_id) VALUES ('alex', now(), eac718d8-ca5e-46ff-a1e3-4d62ef1289f4);
INSERT INTO timeline (username, time, post_id) VALUES ('marcus', now(), 964c504c-1a92-4664-9cc0-eb73f2fc4f34);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), 490a7dc0-0f43-4f1c-a34b-2338c37e3bb7);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 3d8d176e-e5ec-4e6b-9255-c1dc38e85d99);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 7182e561-6608-4eaa-ac80-d032552709e0);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), e4e2a6c7-1014-422c-86c9-09492964a296);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 2e53e89a-0c17-4ae3-9ddf-d55ef0ffb5df);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), cb590c41-473b-4e0f-a295-8bc312cb7f73);
INSERT INTO timeline (username, time, post_id) VALUES ('marcus', now(), 7d1e8c60-49f1-430e-9fd1-dcded053713b);
INSERT INTO timeline (username, time, post_id) VALUES ('alex', now(), c1ee9085-931f-45e8-b012-bdb89d550780);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 917bd19c-7c3a-4ca2-af8e-c36157edcdae);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), 9fef5bd7-00d9-4e92-ab73-c68c77207d06);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), e92bc1ae-6e5d-41be-ab96-9cc1c515aafe);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), 328b3e78-ee08-48ae-926b-ed1faeca4499);
INSERT INTO timeline (username, time, post_id) VALUES ('dad', now(), 25f8f50b-3443-4797-85d9-f84ddbba9228);
INSERT INTO timeline (username, time, post_id) VALUES ('alex', now(), fa811d77-38c1-4832-98f2-981e2f10aaa9);
INSERT INTO timeline (username, time, post_id) VALUES ('topi', now(), 011cef7b-cacd-4994-836c-b043df3cd950);
INSERT INTO timeline (username, time, post_id) VALUES ('marcus', now(), d1e974ab-abb8-461b-b4f1-3ed36f581e5c);
INSERT INTO timeline (username, time, post_id) VALUES ('marcus', now(), 83892fe3-5344-4167-aa28-d5e68fbf0127);

INSERT INTO posts (post_id, username, body) VALUES (50de4f11-85c7-40cd-96ff-e064bab425c9, 'topi', 'Post number 001');
INSERT INTO posts (post_id, username, body) VALUES (eac718d8-ca5e-46ff-a1e3-4d62ef1289f4, 'alex', 'Post number 002');
INSERT INTO posts (post_id, username, body) VALUES (964c504c-1a92-4664-9cc0-eb73f2fc4f34, 'marcus', 'Post number 003');
INSERT INTO posts (post_id, username, body) VALUES (490a7dc0-0f43-4f1c-a34b-2338c37e3bb7, 'dad', 'Post number 004');
INSERT INTO posts (post_id, username, body) VALUES (3d8d176e-e5ec-4e6b-9255-c1dc38e85d99, 'topi', 'Post number 005');
INSERT INTO posts (post_id, username, body) VALUES (7182e561-6608-4eaa-ac80-d032552709e0, 'topi', 'Post number 006');
INSERT INTO posts (post_id, username, body) VALUES (e4e2a6c7-1014-422c-86c9-09492964a296, 'topi', 'Post number 007');
INSERT INTO posts (post_id, username, body) VALUES (2e53e89a-0c17-4ae3-9ddf-d55ef0ffb5df, 'topi', 'Post number 008');
INSERT INTO posts (post_id, username, body) VALUES (cb590c41-473b-4e0f-a295-8bc312cb7f73, 'dad', 'Post number 009');
INSERT INTO posts (post_id, username, body) VALUES (7d1e8c60-49f1-430e-9fd1-dcded053713b, 'marcus', 'Post number 010');
INSERT INTO posts (post_id, username, body) VALUES (c1ee9085-931f-45e8-b012-bdb89d550780, 'alex', 'Post number 011');
INSERT INTO posts (post_id, username, body) VALUES (917bd19c-7c3a-4ca2-af8e-c36157edcdae, 'topi', 'Post number 012');
INSERT INTO posts (post_id, username, body) VALUES (9fef5bd7-00d9-4e92-ab73-c68c77207d06, 'dad', 'Post number 013');
INSERT INTO posts (post_id, username, body) VALUES (e92bc1ae-6e5d-41be-ab96-9cc1c515aafe, 'dad', 'Post number 014');
INSERT INTO posts (post_id, username, body) VALUES (328b3e78-ee08-48ae-926b-ed1faeca4499, 'dad', 'Post number 015');
INSERT INTO posts (post_id, username, body) VALUES (25f8f50b-3443-4797-85d9-f84ddbba9228, 'dad', 'Post number 016');
INSERT INTO posts (post_id, username, body) VALUES (fa811d77-38c1-4832-98f2-981e2f10aaa9, 'alex', 'Post number 017');
INSERT INTO posts (post_id, username, body) VALUES (011cef7b-cacd-4994-836c-b043df3cd950, 'topi', 'Post number 018');
INSERT INTO posts (post_id, username, body) VALUES (d1e974ab-abb8-461b-b4f1-3ed36f581e5c, 'marcus', 'Post number 019');
INSERT INTO posts (post_id, username, body) VALUES (83892fe3-5344-4167-aa28-d5e68fbf0127, 'marcus', 'Post number 020');
