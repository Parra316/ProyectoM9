DROP DATABASE IF EXISTS Proyecto;
CREATE DATABASE IF NOT EXISTS Proyecto;
USE Proyecto;

CREATE TABLE IF NOT EXISTS Usuarios (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    correo VARCHAR(100) UNIQUE NOT NULL,
    contrasena VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    registro DATETIME DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE IF NOT EXISTS Roles (
    rol_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL,
    descripcion TEXT DEFAULT NULL
);


CREATE TABLE IF NOT EXISTS UsuarioRoles (
    usuario_id INT,
    rol_id INT,
    PRIMARY KEY (usuario_id, rol_id),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY (rol_id) REFERENCES Roles(rol_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Servicio (
    servicio_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    duracion INT NOT NULL, -- en minutos
    precio DECIMAL(10,2) NOT NULL,
    estatus ENUM('disponible', 'nodisponible') DEFAULT 'disponible'
);


CREATE TABLE IF NOT EXISTS Consultorio (
    consultorio_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion TEXT NOT NULL,
    telefono VARCHAR(20)
);


CREATE TABLE IF NOT EXISTS Horario (
    horario_id INT AUTO_INCREMENT PRIMARY KEY,
    consultorio_id INT,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    FOREIGN KEY (consultorio_id) REFERENCES Consultorio(consultorio_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Disponibilidad (
    disponibilidad_id INT AUTO_INCREMENT PRIMARY KEY,
    consultorio_id INT NOT NULL,
    servicio_id INT NOT NULL,
    horario_id INT NOT NULL,
    masajista_id INT NOT NULL,
    FOREIGN KEY (consultorio_id) REFERENCES Consultorio(consultorio_id) ON DELETE CASCADE,
    FOREIGN KEY (servicio_id) REFERENCES Servicio(servicio_id) ON DELETE CASCADE,
    FOREIGN KEY (horario_id) REFERENCES Horario(horario_id) ON DELETE CASCADE,
    FOREIGN KEY (masajista_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE
);



CREATE TABLE IF NOT EXISTS Cita (
    cita_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    masajista_id INT,
    servicio_id INT,
    horario_id INT,
    fecha_cita DATETIME NOT NULL,
    estatus ENUM('programado', 'cancelado', 'completado') DEFAULT 'programado',
    precio DECIMAL(10,2),
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    FOREIGN KEY (masajista_id) REFERENCES Usuarios(usuario_id) ON DELETE SET NULL,
    FOREIGN KEY (servicio_id) REFERENCES Servicio(servicio_id) ON DELETE CASCADE,
    FOREIGN KEY (horario_id) REFERENCES Horario(horario_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Pago (
    pago_id INT AUTO_INCREMENT PRIMARY KEY,
    cita_id INT,
    monto DECIMAL(10,2) NOT NULL,
    pago_metodo ENUM('efectivo', 'tarjeta_credito', 'tarjeta_debito', 'paypal') NOT NULL,
    pago_estatus ENUM('pendiente', 'completado', 'cancelado') DEFAULT 'pendiente',
    pago_fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (cita_id) REFERENCES Cita(cita_id) ON DELETE CASCADE
);


CREATE TABLE IF NOT EXISTS Resena (
    resena_id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    servicio_id INT,
    calificacion INT NOT NULL CHECK (calificacion BETWEEN 1 AND 5),
    comentario VARCHAR(100),
    fecha_resena DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id),
    FOREIGN KEY (servicio_id) REFERENCES Servicio(servicio_id)
);