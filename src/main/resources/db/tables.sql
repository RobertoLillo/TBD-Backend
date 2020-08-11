DROP TABLE IF EXISTS rankings;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS emergencies;
DROP TABLE IF EXISTS institutions;
DROP TABLE IF EXISTS volunteers_abilities;
DROP TABLE IF EXISTS abilities;
DROP TABLE IF EXISTS volunteers;

CREATE TABLE volunteers
(
    id UUID NOT NULL,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE abilities
(
    id UUID NOT NULL,
    description VARCHAR(250),
    PRIMARY KEY (id)
);

CREATE TABLE volunteers_abilities
(
    id UUID NOT NULL,
    id_volunteer UUID NOT NULL,
    id_ability UUID NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (id_volunteer) REFERENCES volunteers (id),
    FOREIGN KEY (id_ability) REFERENCES abilities (id)
);

CREATE TABLE institutions
(
    id UUID NOT NULL,
    name VARCHAR(100),
    PRIMARY KEY (id)
);

CREATE TABLE emergencies
(
    id UUID NOT NULL,
    id_institution UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(250),
    start_date DATE NOT NULL,
    finish_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_institution) REFERENCES institutions (id)
);

CREATE TABLE tasks
(
    id UUID NOT NULL,
    id_emergency UUID NOT NULL,
    name VARCHAR(100) NOT NULL,
    description VARCHAR(250),
    required_volunteers INTEGER NOT NULL,
    enrolled_volunteers INTEGER,
    start_date DATE NOT NULL,
    finish_date DATE,
    PRIMARY KEY (id),
    FOREIGN KEY (id_emergency) REFERENCES emergencies (id)
);

CREATE TABLE rankings
(
    id UUID NOT NULL,
    id_volunteer UUID NOT NULL,
    id_task UUID NOT NULL,
    score INTEGER,
    flag_invited BOOLEAN NOT NULL,
    flag_participated BOOLEAN,
    PRIMARY KEY (id),
    FOREIGN KEY (id_volunteer) REFERENCES volunteers (id),
    FOREIGN KEY (id_task) REFERENCES tasks (id)
);