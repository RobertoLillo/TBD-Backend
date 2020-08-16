-------------------------------TABLES-------------------------------

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

---------------------------------VALUES---------------------------------


-------------------------------VOLUNTEERS-------------------------------

INSERT INTO volunteers VALUES ('4a995f8c-a3a5-11ea-bb37-0242ac130002', 'Claudia Castillo');

INSERT INTO volunteers VALUES ('4a9961a8-a3a5-11ea-bb37-0242ac130002', 'Jorge Rosales');

INSERT INTO volunteers VALUES ('4a99628e-a3a5-11ea-bb37-0242ac130002', 'Mónica Pascual');

INSERT INTO volunteers VALUES ('4a9964c8-a3a5-11ea-bb37-0242ac130002', 'Román Martínez');

INSERT INTO volunteers VALUES ('4a9965ae-a3a5-11ea-bb37-0242ac130002', 'Guillermo Calvo');

INSERT INTO volunteers VALUES ('4a99666c-a3a5-11ea-bb37-0242ac130002', 'Iris Navarro');

INSERT INTO volunteers VALUES ('4a99672a-a3a5-11ea-bb37-0242ac130002', 'Laura Morales');

INSERT INTO volunteers VALUES ('4a9967e8-a3a5-11ea-bb37-0242ac130002', 'Andrés Núñez');

INSERT INTO volunteers VALUES ('4a99689c-a3a5-11ea-bb37-0242ac130002', 'Ernesto Castro');

INSERT INTO volunteers VALUES ('4a996bb2-a3a5-11ea-bb37-0242ac130002', 'Alan Pastor');

INSERT INTO volunteers VALUES ('4a996cac-a3a5-11ea-bb37-0242ac130002', 'Ximena Gallardo');

INSERT INTO volunteers VALUES ('4a996d6a-a3a5-11ea-bb37-0242ac130002', 'Alonzo Diaz');

INSERT INTO volunteers VALUES ('4a996e28-a3a5-11ea-bb37-0242ac130002', 'Paola Velasco');

INSERT INTO volunteers VALUES ('4a996ee6-a3a5-11ea-bb37-0242ac130002', 'Emanuel Santos');

INSERT INTO volunteers VALUES ('4a996fa4-a3a5-11ea-bb37-0242ac130002', 'Daniela Santana');

INSERT INTO volunteers VALUES ('4a997062-a3a5-11ea-bb37-0242ac130002', 'Amanda Herrera');

INSERT INTO volunteers VALUES ('4a997116-a3a5-11ea-bb37-0242ac130002', 'Pedro Molina');

INSERT INTO volunteers VALUES ('4a997300-a3a5-11ea-bb37-0242ac130002', 'Cecilia Arias');

INSERT INTO volunteers VALUES ('4a9973d2-a3a5-11ea-bb37-0242ac130002', 'Celeste Vera');

INSERT INTO volunteers VALUES ('4a997490-a3a5-11ea-bb37-0242ac130002', 'Javier Parra');

-------------------------------ABILITIES-------------------------------

INSERT INTO abilities VALUES ('72a6f398-a3ac-11ea-bb37-0242ac130002', 'Fuerza y resistencia');

INSERT INTO abilities VALUES ('72a6f5d2-a3ac-11ea-bb37-0242ac130002', 'Manejo de la matemática básica como álgebra y buena ortografía');

INSERT INTO abilities VALUES ('72a6f6c2-a3ac-11ea-bb37-0242ac130002', 'Habilidades de comunicación con abuelos y niños');

INSERT INTO abilities VALUES ('72a6f794-a3ac-11ea-bb37-0242ac130002', 'Empatia y paciencia');

INSERT INTO abilities VALUES ('72a6f852-a3ac-11ea-bb37-0242ac130002', 'Hábil y delicado con los animales');

INSERT INTO abilities VALUES ('72a70234-a3ac-11ea-bb37-0242ac130002', 'Orden y limpieza en su lugar de trabajo');

INSERT INTO abilities VALUES ('72a70374-a3ac-11ea-bb37-0242ac130002', 'No tener fobia a la sangre, heridas, cortes y las jeringas');

INSERT INTO abilities VALUES ('72a70446-a3ac-11ea-bb37-0242ac130002', 'Capacidad de trabajar bajo presión');

INSERT INTO abilities VALUES ('72a70504-a3ac-11ea-bb37-0242ac130002', 'Capacidad de organizar y liderar una gran cantidad de personas');

INSERT INTO abilities VALUES ('72a705c2-a3ac-11ea-bb37-0242ac130002', 'Conocimientos de Reanimación cardiopulmonar (RCP)');

INSERT INTO abilities VALUES ('72a70680-a3ac-11ea-bb37-0242ac130002', 'Buena orientación');

INSERT INTO abilities VALUES ('72a7073e-a3ac-11ea-bb37-0242ac130002', 'Experiencia de rescates en bosques');

INSERT INTO abilities VALUES ('72a707f2-a3ac-11ea-bb37-0242ac130002', 'Posibilidad de movilización por sus propios medios (Traslado)');

INSERT INTO abilities VALUES ('72a70a9a-a3ac-11ea-bb37-0242ac130002', 'Disposición para aprender');

INSERT INTO abilities VALUES ('72a70b6c-a3ac-11ea-bb37-0242ac130002', 'Comunicación oral eficiente al trabajar en equipo');

-------------------------------VOLUNTEERS_ABILITIES-------------------------------

INSERT INTO volunteers_abilities VALUES ('aeb2aa9a-a441-11ea-bb37-0242ac130002', '4a995f8c-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2acb6-a441-11ea-bb37-0242ac130002', '4a995f8c-a3a5-11ea-bb37-0242ac130002', '72a6f5d2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2ae50-a441-11ea-bb37-0242ac130002', '4a995f8c-a3a5-11ea-bb37-0242ac130002', '72a70b6c-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2af68-a441-11ea-bb37-0242ac130002', '4a995f8c-a3a5-11ea-bb37-0242ac130002', '72a70504-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b0a8-a441-11ea-bb37-0242ac130002', '4a9961a8-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b17a-a441-11ea-bb37-0242ac130002', '4a9961a8-a3a5-11ea-bb37-0242ac130002', '72a70234-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b27e-a441-11ea-bb37-0242ac130002', '4a9961a8-a3a5-11ea-bb37-0242ac130002', '72a70a9a-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b3e6-a441-11ea-bb37-0242ac130002', '4a99628e-a3a5-11ea-bb37-0242ac130002', '72a6f794-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b4ae-a441-11ea-bb37-0242ac130002', '4a99628e-a3a5-11ea-bb37-0242ac130002', '72a705c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b5d0-a441-11ea-bb37-0242ac130002', '4a99628e-a3a5-11ea-bb37-0242ac130002', '72a70374-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b6b6-a441-11ea-bb37-0242ac130002', '4a9964c8-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b7d8-a441-11ea-bb37-0242ac130002', '4a9964c8-a3a5-11ea-bb37-0242ac130002', '72a70374-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b8d2-a441-11ea-bb37-0242ac130002', '4a9964c8-a3a5-11ea-bb37-0242ac130002', '72a6f852-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2b9e0-a441-11ea-bb37-0242ac130002', '4a9965ae-a3a5-11ea-bb37-0242ac130002', '72a70680-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2bc56-a441-11ea-bb37-0242ac130002', '4a9965ae-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2bd14-a441-11ea-bb37-0242ac130002', '4a9965ae-a3a5-11ea-bb37-0242ac130002', '72a705c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2be72-a441-11ea-bb37-0242ac130002', '4a99666c-a3a5-11ea-bb37-0242ac130002', '72a6f794-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2bf30-a441-11ea-bb37-0242ac130002', '4a99666c-a3a5-11ea-bb37-0242ac130002', '72a6f6c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c034-a441-11ea-bb37-0242ac130002', '4a99666c-a3a5-11ea-bb37-0242ac130002', '72a6f5d2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c11a-a441-11ea-bb37-0242ac130002', '4a99672a-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c23c-a441-11ea-bb37-0242ac130002', '4a99672a-a3a5-11ea-bb37-0242ac130002', '72a70a9a-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c3a4-a441-11ea-bb37-0242ac130002', '4a99672a-a3a5-11ea-bb37-0242ac130002', '72a70b6c-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c50c-a441-11ea-bb37-0242ac130002', '4a9967e8-a3a5-11ea-bb37-0242ac130002', '72a705c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c624-a441-11ea-bb37-0242ac130002', '4a9967e8-a3a5-11ea-bb37-0242ac130002', '72a7073e-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c728-a441-11ea-bb37-0242ac130002', '4a9967e8-a3a5-11ea-bb37-0242ac130002', '72a70504-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c7e6-a441-11ea-bb37-0242ac130002', '4a99689c-a3a5-11ea-bb37-0242ac130002', '72a70680-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2c944-a441-11ea-bb37-0242ac130002', '4a99689c-a3a5-11ea-bb37-0242ac130002', '72a705c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2ca3e-a441-11ea-bb37-0242ac130002', '4a99689c-a3a5-11ea-bb37-0242ac130002', '72a7073e-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2cb38-a441-11ea-bb37-0242ac130002', '4a996bb2-a3a5-11ea-bb37-0242ac130002', '72a6f794-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2cc64-a441-11ea-bb37-0242ac130002', '4a996bb2-a3a5-11ea-bb37-0242ac130002', '72a6f6c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2cdc2-a441-11ea-bb37-0242ac130002', '4a996bb2-a3a5-11ea-bb37-0242ac130002', '72a6f852-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2ceee-a441-11ea-bb37-0242ac130002', '4a996cac-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d006-a441-11ea-bb37-0242ac130002', '4a996cac-a3a5-11ea-bb37-0242ac130002', '72a7073e-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d132-a441-11ea-bb37-0242ac130002', '4a996cac-a3a5-11ea-bb37-0242ac130002', '72a705c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d1fa-a441-11ea-bb37-0242ac130002', '4a996d6a-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d308-a441-11ea-bb37-0242ac130002', '4a996d6a-a3a5-11ea-bb37-0242ac130002', '72a70b6c-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d416-a441-11ea-bb37-0242ac130002', '4a996d6a-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d524-a441-11ea-bb37-0242ac130002', '4a996e28-a3a5-11ea-bb37-0242ac130002', '72a6f852-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d63c-a441-11ea-bb37-0242ac130002', '4a996e28-a3a5-11ea-bb37-0242ac130002', '72a70374-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d754-a441-11ea-bb37-0242ac130002', '4a996e28-a3a5-11ea-bb37-0242ac130002', '72a6f794-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d86c-a441-11ea-bb37-0242ac130002', '4a996ee6-a3a5-11ea-bb37-0242ac130002', '72a70a9a-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2d97a-a441-11ea-bb37-0242ac130002', '4a996ee6-a3a5-11ea-bb37-0242ac130002', '72a70234-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2da6a-a441-11ea-bb37-0242ac130002', '4a996ee6-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2db82-a441-11ea-bb37-0242ac130002', '4a996fa4-a3a5-11ea-bb37-0242ac130002', '72a7073e-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2dc9a-a441-11ea-bb37-0242ac130002', '4a996fa4-a3a5-11ea-bb37-0242ac130002', '72a707f2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2dd76-a441-11ea-bb37-0242ac130002', '4a996fa4-a3a5-11ea-bb37-0242ac130002', '72a70680-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2de98-a441-11ea-bb37-0242ac130002', '4a997062-a3a5-11ea-bb37-0242ac130002', '72a6f794-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2dfce-a441-11ea-bb37-0242ac130002', '4a997062-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e0c8-a441-11ea-bb37-0242ac130002', '4a997116-a3a5-11ea-bb37-0242ac130002', '72a707f2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e294-a441-11ea-bb37-0242ac130002', '4a997116-a3a5-11ea-bb37-0242ac130002', '72a70b6c-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e3ac-a441-11ea-bb37-0242ac130002', '4a997300-a3a5-11ea-bb37-0242ac130002', '72a70234-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e4a6-a441-11ea-bb37-0242ac130002', '4a997300-a3a5-11ea-bb37-0242ac130002', '72a6f5d2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e604-a441-11ea-bb37-0242ac130002', '4a9973d2-a3a5-11ea-bb37-0242ac130002', '72a70374-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e6cc-a441-11ea-bb37-0242ac130002', '4a9973d2-a3a5-11ea-bb37-0242ac130002', '72a70446-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e79e-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a7073e-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e8d4-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a70374-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2e992-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a6f5d2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2eae6-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a6f398-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2ebf4-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a6f6c2-a3ac-11ea-bb37-0242ac130002');

INSERT INTO volunteers_abilities VALUES ('aeb2ed16-a441-11ea-bb37-0242ac130002', '4a997490-a3a5-11ea-bb37-0242ac130002', '72a6f852-a3ac-11ea-bb37-0242ac130002');

-------------------------------INSTITUTIONS-------------------------------

INSERT INTO institutions VALUES ('f6ff29aa-a3af-11ea-bb37-0242ac130002', 'Fundación un techo para Chile (TECHO)');

INSERT INTO institutions VALUES ('f6ff2bf8-a3af-11ea-bb37-0242ac130002', 'Agrupación de Estudiantes por la Defensa Animal (AEDA)');

INSERT INTO institutions VALUES ('f6ff2cf2-a3af-11ea-bb37-0242ac130002', 'Fundacion las Rosas');

INSERT INTO institutions VALUES ('f6ff2dc4-a3af-11ea-bb37-0242ac130002', 'Corporación Nacional Forestal (CONAF)');

INSERT INTO institutions VALUES ('f6ff2e8c-a3af-11ea-bb37-0242ac130002', 'Search & Rescue Chile (SARCHILE)');

-------------------------------EMERGENCIES-------------------------------

INSERT INTO emergencies VALUES ('ae844504-d52b-11ea-87d0-0242ac130003', 'f6ff29aa-a3af-11ea-bb37-0242ac130002', 'Construccion de mediaguas por covid', 'Se necesita gente que desee ayudar a construir mediaguas para la gente en situacion de calle en medio de la pandemia', '2020-06-12', '2020-06-15');

INSERT INTO emergencies VALUES ('ae844734-d52b-11ea-87d0-0242ac130003', 'f6ff2bf8-a3af-11ea-bb37-0242ac130002', 'URGENTE ayuda para los perros de la USACH', 'Hubo una pelea entre los perros de la USACH, algunos resultaron muy heridos, se necesita ayuda para separarlos y atender sus heridas', '2020-01-03', '2020-01-10');

INSERT INTO emergencies VALUES ('ae84482e-d52b-11ea-87d0-0242ac130003', 'f6ff2cf2-a3af-11ea-bb37-0242ac130002', 'Se necesita ayuda para cuidar abuelos', 'Debido a una falta de personal se necesita gente para pasar tiempo con abuelos y desarrolar tareas basicas como ayudarlos a comer y hablar con ellos para entretenerlos', '2020-03-14', '2020-03-15');

INSERT INTO emergencies VALUES ('ae844a5e-d52b-11ea-87d0-0242ac130003', 'f6ff2dc4-a3af-11ea-bb37-0242ac130002', 'Incendio en Valparaiso', 'Se necesita gente para ayuda y contencion de afectados por incendio en Valparaiso', '2019-12-20', '2019-12-25');

INSERT INTO emergencies VALUES ('ae844b30-d52b-11ea-87d0-0242ac130003', 'f6ff2e8c-a3af-11ea-bb37-0242ac130002', 'Busqueda intensiva de persona perdida en bosque', 'Se perdio una persona en la Reserva Nacional Laguna Parrillar, Region de Magallanes. Se buscan personas con experiencia en este tipo de acontecimientos que puedan ser de ayuda', '2019-08-31', '2019-09-05');

INSERT INTO emergencies VALUES ('ae844bf8-d52b-11ea-87d0-0242ac130003', 'f6ff2bf8-a3af-11ea-bb37-0242ac130002', 'Se necesita gente que ayude a alimentar perros de la USACH', 'Se necesita gente que pueda acercarse a la USACH y alimentar a los perros a cargo de AEDA', '2020-08-11', '2020-08-25');

----------------------------------TASK----------------------------------

INSERT INTO tasks VALUES ('a1c65d8c-d5af-11ea-87d0-0242ac130003', 'ae844504-d52b-11ea-87d0-0242ac130003', 'LLevar materiales', 'Se necesita ayuda para el traslado de los materiales a la zona de construccion', '4', '4', '2020-06-12', '2020-06-13');

INSERT INTO tasks VALUES ('a1c65f9e-d5af-11ea-87d0-0242ac130003', 'ae844504-d52b-11ea-87d0-0242ac130003', 'Tomar medidas y cortar materiales', 'Se busca gente con conocimientos basicos de aritmetica para tomar medidas y cortar los materiales como madera para la construccion de mediaguas', '5', '5', '2020-06-13', '2020-06-15');

INSERT INTO tasks VALUES ('a1c66098-d5af-11ea-87d0-0242ac130003', 'ae844504-d52b-11ea-87d0-0242ac130003', 'Construir mediaguas', 'Se necesita gente para armar la casa con las piezas ya cortadas', '5', '5', '2020-06-13', '2020-06-15');

INSERT INTO tasks VALUES ('a1c6628c-d5af-11ea-87d0-0242ac130003', 'ae844734-d52b-11ea-87d0-0242ac130003', 'Separar perros', 'Se necesita gente que ayude a separar los perros', '8', '6', '2020-01-03', '2020-01-04');

INSERT INTO tasks VALUES ('a1c66368-d5af-11ea-87d0-0242ac130003', 'ae844734-d52b-11ea-87d0-0242ac130003', 'Realizar curaciones a los perros', 'Una vez separados, se necesita revisar las heridas y realizar curaciones', '5', '5', '2020-01-03', '2020-01-10');

INSERT INTO tasks VALUES ('a1c66430-d5af-11ea-87d0-0242ac130003', 'ae84482e-d52b-11ea-87d0-0242ac130003', 'Visitar abuelos', 'Se necesita gente para pasar tiempo con abuelos y desarrolar tareas basicas como ayudarlos a comer y hablar con ellos para entretenerlos', '6', '5', '2020-03-14', '2020-03-15');

INSERT INTO tasks VALUES ('a1c664f8-d5af-11ea-87d0-0242ac130003', 'ae844a5e-d52b-11ea-87d0-0242ac130003', 'Ayudar a evacuar residentes en la zona', 'Se necesita ayuda de gente que pueda controlar a las personas y evacuarlas de la zona del incendio', '5', '5', '2019-12-20', '2019-12-21');

INSERT INTO tasks VALUES ('a1c665b6-d5af-11ea-87d0-0242ac130003', 'ae844a5e-d52b-11ea-87d0-0242ac130003', 'Mojar casas aledañas para evitar la propagacion del incendio', 'Se necesita gente para humedecer las casas de los afectados y evitar que se propague tan rapido el calor en casas aledañas al incendio', '5', '4', '2019-12-20', '2019-12-25');

INSERT INTO tasks VALUES ('a1c66778-d5af-11ea-87d0-0242ac130003', 'ae844b30-d52b-11ea-87d0-0242ac130003', 'Búsqueda de pistas en el bosque', 'Se necesita que llegue gente con experiencia y busque algun objeto e información del afectado', '5', '4', '2019-08-31', '2019-09-01');

INSERT INTO tasks VALUES ('a1c6684a-d5af-11ea-87d0-0242ac130003', 'ae844b30-d52b-11ea-87d0-0242ac130003', 'Iniciar búsqueda en grupos', 'Se necesita gente para formar grupos de 3 personas para iniciar la busqueda del afectado en la madrugada', '9', '9', '2019-08-1', '2019-09-05');

INSERT INTO tasks VALUES ('a1c668fe-d5af-11ea-87d0-0242ac130003', 'ae844bf8-d52b-11ea-87d0-0242ac130003', 'Alimentar perros', 'Se necesita gente que ayude a alimentar los perros de AEDA durante 2 semanas', '5', '4', '2020-08-11', '2020-08-25');

INSERT INTO tasks VALUES ('a1c669bc-d5af-11ea-87d0-0242ac130003', 'ae844bf8-d52b-11ea-87d0-0242ac130003', 'Recoger heces de los perros', 'Se necesita gente que ayude a recoger las heces de los perros de AEDA durante 2 semanas', '4', '4', '2020-08-11', '2020-08-25');

-------------------------------RANKINGS-------------------------------

INSERT INTO rankings VALUES ('ea00894e-db61-11ea-87d0-0242ac130003', '4a996fa4-a3a5-11ea-bb37-0242ac130002', 'a1c65d8c-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea008c32-db61-11ea-87d0-0242ac130003', '4a997062-a3a5-11ea-bb37-0242ac130002', 'a1c65d8c-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea008dfe-db61-11ea-87d0-0242ac130003', '4a997116-a3a5-11ea-bb37-0242ac130002', 'a1c65d8c-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea008fe8-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c65d8c-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea0090ce-db61-11ea-87d0-0242ac130003', '4a995f8c-a3a5-11ea-bb37-0242ac130002', 'a1c65f9e-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea0092c2-db61-11ea-87d0-0242ac130003', '4a9961a8-a3a5-11ea-bb37-0242ac130002', 'a1c65f9e-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea0093a8-db61-11ea-87d0-0242ac130003', '4a99666c-a3a5-11ea-bb37-0242ac130002', 'a1c65f9e-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00947a-db61-11ea-87d0-0242ac130003', '4a997300-a3a5-11ea-bb37-0242ac130002', 'a1c65f9e-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea009650-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c65f9e-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00972c-db61-11ea-87d0-0242ac130003', '4a99672a-a3a5-11ea-bb37-0242ac130002', 'a1c66098-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea0098ee-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c66098-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea0099b6-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c66098-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea009ba0-db61-11ea-87d0-0242ac130003', '4a996ee6-a3a5-11ea-bb37-0242ac130002', 'a1c66098-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea009c72-db61-11ea-87d0-0242ac130003', '4a997062-a3a5-11ea-bb37-0242ac130002', 'a1c66098-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea009ec0-db61-11ea-87d0-0242ac130003', '4a99628e-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a03c-db61-11ea-87d0-0242ac130003', '4a9964c8-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a1ea-db61-11ea-87d0-0242ac130003', '4a9965ae-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a2b2-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a532-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a604-db61-11ea-87d0-0242ac130003', '4a9973d2-a3a5-11ea-bb37-0242ac130002', 'a1c6628c-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a6c2-db61-11ea-87d0-0242ac130003', '4a9961a8-a3a5-11ea-bb37-0242ac130002', 'a1c66368-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a78a-db61-11ea-87d0-0242ac130003', '4a996bb2-a3a5-11ea-bb37-0242ac130002', 'a1c66368-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00a9b0-db61-11ea-87d0-0242ac130003', '4a996e28-a3a5-11ea-bb37-0242ac130002', 'a1c66368-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00aa78-db61-11ea-87d0-0242ac130003', '4a996ee6-a3a5-11ea-bb37-0242ac130002', 'a1c66368-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00ab36-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c66368-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00ad48-db61-11ea-87d0-0242ac130003', '4a99628e-a3a5-11ea-bb37-0242ac130002', 'a1c66430-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00af1e-db61-11ea-87d0-0242ac130003', '4a99666c-a3a5-11ea-bb37-0242ac130002', 'a1c66430-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00b108-db61-11ea-87d0-0242ac130003', '4a996bb2-a3a5-11ea-bb37-0242ac130002', 'a1c66430-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00b2a2-db61-11ea-87d0-0242ac130003', '4a996e28-a3a5-11ea-bb37-0242ac130002', 'a1c66430-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00b3ce-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c66430-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00b9d2-db61-11ea-87d0-0242ac130003', '4a995f8c-a3a5-11ea-bb37-0242ac130002', 'a1c664f8-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00baf4-db61-11ea-87d0-0242ac130003', '4a99672a-a3a5-11ea-bb37-0242ac130002', 'a1c664f8-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00bbbc-db61-11ea-87d0-0242ac130003', '4a9967e8-a3a5-11ea-bb37-0242ac130002', 'a1c664f8-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00bc84-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c664f8-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00bd4c-db61-11ea-87d0-0242ac130003', '4a997116-a3a5-11ea-bb37-0242ac130002', 'a1c664f8-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00be78-db61-11ea-87d0-0242ac130003', '4a9961a8-a3a5-11ea-bb37-0242ac130002', 'a1c665b6-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c008-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c665b6-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c0d0-db61-11ea-87d0-0242ac130003', '4a997062-a3a5-11ea-bb37-0242ac130002', 'a1c665b6-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c31e-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c665b6-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c3e6-db61-11ea-87d0-0242ac130003', '4a9967e8-a3a5-11ea-bb37-0242ac130002', 'a1c66778-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c4ae-db61-11ea-87d0-0242ac130003', '4a99689c-a3a5-11ea-bb37-0242ac130002', 'a1c66778-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c71a-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c66778-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00c94a-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c66778-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00ca3a-db61-11ea-87d0-0242ac130003', '4a99628e-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00cbde-db61-11ea-87d0-0242ac130003', '4a9965ae-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00ccb0-db61-11ea-87d0-0242ac130003', '4a9967e8-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00cf30-db61-11ea-87d0-0242ac130003', '4a99689c-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d002-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d0c0-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d188-db61-11ea-87d0-0242ac130003', '4a996fa4-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d2dc-db61-11ea-87d0-0242ac130003', '4a997116-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d598-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c6684a-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d67e-db61-11ea-87d0-0242ac130003', '4a99672a-a3a5-11ea-bb37-0242ac130002', 'a1c668fe-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d750-db61-11ea-87d0-0242ac130003', '4a996bb2-a3a5-11ea-bb37-0242ac130002', 'a1c668fe-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d80e-db61-11ea-87d0-0242ac130003', '4a996e28-a3a5-11ea-bb37-0242ac130002', 'a1c668fe-d5af-11ea-87d0-0242ac130003', '3', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00d994-db61-11ea-87d0-0242ac130003', '4a997490-a3a5-11ea-bb37-0242ac130002', 'a1c668fe-d5af-11ea-87d0-0242ac130003', '2', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00db88-db61-11ea-87d0-0242ac130003', '4a9961a8-a3a5-11ea-bb37-0242ac130002', 'a1c669bc-d5af-11ea-87d0-0242ac130003', '1', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00dc5a-db61-11ea-87d0-0242ac130003', '4a996cac-a3a5-11ea-bb37-0242ac130002', 'a1c669bc-d5af-11ea-87d0-0242ac130003', '4', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00de30-db61-11ea-87d0-0242ac130003', '4a996d6a-a3a5-11ea-bb37-0242ac130002', 'a1c669bc-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');

INSERT INTO rankings VALUES ('ea00def8-db61-11ea-87d0-0242ac130003', '4a996ee6-a3a5-11ea-bb37-0242ac130002', 'a1c669bc-d5af-11ea-87d0-0242ac130003', '5', 'TRUE', 'TRUE');


----------------------------TRIGGERS--------------------------------
/* Emergencies trigger */
/* Asigna la fecha actual a la nueva emergencia ingresada. */
CREATE OR REPLACE FUNCTION emergency_start_date() RETURNS TRIGGER AS
$BODY$
BEGIN
    NEW.start_date = CURRENT_DATE;
    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER emergency_date_trigger
BEFORE INSERT ON emergencies
FOR EACH ROW
EXECUTE PROCEDURE emergency_start_date();


/* Tasks trigger */
/* Suma 1 a la cantidad de voluntarios participantes en la tarea específica. */
CREATE OR REPLACE FUNCTION add_enrolled_volunteer() RETURNS TRIGGER AS
$BODY$
BEGIN
    IF NEW.flag_participated = true THEN
        UPDATE tasks SET enrolled_volunteers = enrolled_volunteers + 1
        WHERE id = NEW.id_task;
    END IF;
    RETURN NEW;
END;
$BODY$ LANGUAGE plpgsql;

CREATE TRIGGER new_enrolled_volunteer
AFTER INSERT ON rankings
FOR EACH ROW
EXECUTE PROCEDURE add_enrolled_volunteer();