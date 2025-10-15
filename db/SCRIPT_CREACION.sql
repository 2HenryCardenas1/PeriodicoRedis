--Ejecutar con usuario SYS
create user PERIODICO identified by A;
grant connect, resource to PERIODICO;
ALTER USER PERIODICO QUOTA UNLIMITED ON USERS;

-- Periodista
CREATE TABLE Periodista (
    id_periodista NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100),
    direccion VARCHAR2(150),
    telefono VARCHAR2(20),
    num_notic NUMBER
);

-- Noticia
CREATE TABLE Noticia (
    id_noticia NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fecha_hora DATE,
    titular VARCHAR2(200),
    texto CLOB,
    id_noticia_relacionada NUMBER,
    CONSTRAINT FK_NOTICIA_RELACIONADA FOREIGN KEY (id_noticia_relacionada)
        REFERENCES Noticia (id_noticia)
);

-- 3Quien_cubre (Periodista cubre Noticia)
CREATE TABLE Quien_cubre (
    id_periodista NUMBER,
    id_noticia NUMBER,
    CONSTRAINT PK_QUIEN_CUBRE PRIMARY KEY (id_periodista, id_noticia),
    CONSTRAINT FK_QC_PERIODISTA FOREIGN KEY (id_periodista)
        REFERENCES Periodista (id_periodista),
    CONSTRAINT FK_QC_NOTICIA FOREIGN KEY (id_noticia)
        REFERENCES Noticia (id_noticia)
);

-- Implicado
CREATE TABLE Implicado (
    id_implicado NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100),
    fecha_nacimiento DATE
);

-- Implicado_noticia (relaci�n N:M entre Implicado y Noticia)
CREATE TABLE Entrevista (
    id_entrevista NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY, --llave artificial
    id_periodista NUMBER NOT NULL,
    id_implicado NUMBER NOT NULL,
    id_noticia NUMBER NOT NULL,
    CONSTRAINT FK_ENTREVISTA_PERIODISTA FOREIGN KEY (id_periodista)
        REFERENCES Periodista (id_periodista),
    CONSTRAINT FK_ENTREVISTA_IMPLICADO FOREIGN KEY (id_implicado)
        REFERENCES Implicado (id_implicado),
    CONSTRAINT FK_ENTREVISTA_NOTICIA FOREIGN KEY (id_noticia)
        REFERENCES Noticia (id_noticia)
);

-- 6Agencia
CREATE TABLE Agencia (
    id_agencia NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nombre VARCHAR2(100),
    anio_creacion NUMBER(4)
);

-- 7Ag_noticia (relaci�n Agencia - Noticia)
CREATE TABLE Ag_noticia (
    id_agencia NUMBER,
    id_noticia NUMBER,
    hora_noticia DATE,
    CONSTRAINT PK_AG_NOTICIA PRIMARY KEY (id_agencia, id_noticia),
    CONSTRAINT FK_AG_AGENCIA FOREIGN KEY (id_agencia)
        REFERENCES Agencia (id_agencia),
    CONSTRAINT FK_AG_NOTICIA FOREIGN KEY (id_noticia)
        REFERENCES Noticia (id_noticia)
);



-- ==============================================
-- INSERTS DE PRUEBA
-- ==============================================

-- Periodistas
INSERT INTO Periodista (nombre, direccion, telefono, num_notic)
VALUES ('Juan P�rez', 'Calle 123', '3104567890', 5);

INSERT INTO Periodista (nombre, direccion, telefono, num_notic)
VALUES ('Laura G�mez', 'Carrera 45', '3209876543', 8);

-- Noticias
INSERT INTO Noticia (fecha_hora, titular, texto)
VALUES (SYSDATE, 'Accidente en autopista norte', 'Un fuerte accidente se registr� hoy en la autopista norte...');

INSERT INTO Noticia (fecha_hora, titular, texto, id_noticia_relacionada)
VALUES (SYSDATE, 'Reacciones tras el accidente', 'Autoridades y testigos hablan sobre el accidente...', 1);

-- Relaci�n Quien_cubre
INSERT INTO Quien_cubre (id_periodista, id_noticia) VALUES (1, 1);
INSERT INTO Quien_cubre (id_periodista, id_noticia) VALUES (2, 2);

-- Implicados
INSERT INTO Implicado (nombre, fecha_nacimiento)
VALUES ('Carlos Ruiz', TO_DATE('1985-03-12', 'YYYY-MM-DD'));

INSERT INTO Implicado (nombre, fecha_nacimiento)
VALUES ('Mar�a Torres', TO_DATE('1990-07-22', 'YYYY-MM-DD'));

-- Relaci�n Implicado_noticia
INSERT INTO Implicado_noticia (id_noticia, id_implicado, rol)
VALUES (1, 1, 'Testigo');

INSERT INTO Implicado_noticia (id_noticia, id_implicado, rol)
VALUES (2, 2, 'Implicado');

-- Agencias
INSERT INTO Agencia (nombre, anio_creacion) VALUES ('Agencia EFE', 1980);
INSERT INTO Agencia (nombre, anio_creacion) VALUES ('Reuters', 1851);

-- Relaci�n Agencia - Noticia
INSERT INTO Ag_noticia (id_agencia, id_noticia, hora_noticia)
VALUES (1, 1, SYSDATE);

INSERT INTO Ag_noticia (id_agencia, id_noticia, hora_noticia)
VALUES (2, 2, SYSDATE);

-- Entrevistas
INSERT INTO Entrevista (id_periodista, id_implicado, id_noticia)
VALUES (1, 1, 1);

INSERT INTO Entrevista (id_periodista, id_implicado, id_noticia)
VALUES (2, 2, 2);

COMMIT;
