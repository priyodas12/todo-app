INSERT INTO users (username, password, enabled)
VALUES ("abc","abc123",true);

INSERT INTO users (username, password, enabled)
VALUES ("def","def123",true);

INSERT INTO authorities (username, authority)
VALUES ("abc","ROLE_USER");

INSERT INTO authorities (username, authority)
VALUES ("def","ROLE_ADMIN");

