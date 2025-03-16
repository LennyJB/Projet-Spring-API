INSERT INTO users (username, password, enabled) VALUES
('UserRebond', '$2a$10$nNW6eV1DndzdsrZQeB88A.0PSXfpkrd3jBdMkgSG.5CV.KkuorSmq', true),
('UserScraper', '$2a$10$nNW6eV1DndzdsrZQeB88A.0PSXfpkrd3jBdMkgSG.5CV.KkuorSmq',  true),
('UserCrud', '$2a$10$nNW6eV1DndzdsrZQeB88A.0PSXfpkrd3jBdMkgSG.5CV.KkuorSmq', true);


INSERT INTO users_roles (users_id, roles_id) VALUES
(1, 1),
(2, 2),
(3, 3)
;

