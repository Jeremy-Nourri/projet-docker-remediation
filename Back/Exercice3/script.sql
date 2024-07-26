INSERT INTO Employee (name, identificationNumber, address, phone, email, birthDate, contractStartDate, contractEndDate, occupation, password, admin, salary, observation)
VALUES
('Jean Dupont', 'ID123456', '123 Rue Principale', '0102030405', 'jean.dupont@example.com', '1985-05-15', '2020-01-01', '2025-01-01', 'Développeur', 'motdepasse123', true, 50000.00, 'Aucune observation'),
('Marie Martin', 'ID654321', '456 Rue de la République', '0607080910', 'marie.martin@example.com', '1990-08-25', '2019-02-01', '2024-02-01', 'Designer', 'motdepasse456', false, 55000.00, 'Aucune observation'),
('Pierre Dubois', 'ID789012', '789 Avenue des Champs', '0708091011', 'pierre.dubois@example.com', '1978-12-30', '2018-03-15', '2023-03-15', 'Analyste', 'motdepasse789', true, 60000.00, 'Aucune observation'),
('Sophie Lefevre', 'ID345678', '321 Boulevard Victor Hugo', '0809101112', 'sophie.lefevre@example.com', '1982-11-12', '2021-04-01', '2026-04-01', 'Manager', 'motdepasse012', false, 65000.00, 'Aucune observation');

INSERT INTO Candidate (name, identificationNumber, address, phone, email, birthDate, rating, observation, skills, technicalArea, jobInterviewDate)
VALUES
('Alice Bernard', 'ID901234', '123 Rue de la Paix', '0102030406', 'alice.bernard@example.com', '1995-03-10', 85, 'Fortement recommandée', 'Java, Spring, SQL', 'Développement logiciel', '2024-06-15'),
('Bob Martin', 'ID345678', '456 Rue du Faubourg', '0607080911', 'bob.martin@example.com', '1988-11-20', 75, 'Bonnes compétences en communication', 'HTML, CSS, JavaScript', 'Développement web', '2024-07-10');

INSERT INTO Vacation (id_employee, start, end)
VALUES
(1, '2024-07-01', '2024-07-15'),
(2, '2024-08-01', '2024-08-10'),
(3, '2024-09-01', '2024-09-15'),
(4, '2024-10-01', '2024-10-10');

INSERT INTO Absense (id_employee, date)
VALUES
(1, '2024-07-20'),
(2, '2024-08-15'),
(3, '2024-09-20'),
(4, '2024-10-15');
