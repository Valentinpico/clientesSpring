

CREATE TABLE `cliente` (
  `cliente_id` bigint(20) NOT NULL,
  `contraseña` varchar(255) NOT NULL,
  `estado` bit(1) NOT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `identificacion` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `cliente` (`cliente_id`, `contraseña`, `estado`, `direccion`, `edad`, `genero`, `identificacion`, `nombre`, `telefono`) VALUES
(37, '1234', b'1', 'Otavalo sn y principal', 21, 'MASCULINO', '1231234234', 'Jose Lema', '098254785'),
(38, '5678', b'1', 'Amazonas y NNUU', 21, 'FEMENINO', '1231234234', 'Marianela Montalvo', '097548965'),
(39, '1245', b'1', '13 junio y Equinoccial', 21, 'MASCULINO', '1231234234', 'Juan Osorio', '098874587');


ALTER TABLE `cliente`
  ADD PRIMARY KEY (`cliente_id`);

ALTER TABLE `cliente`
  MODIFY `cliente_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*///////////////////////  */

CREATE TABLE `cuenta` (
  `numero_cuenta` varchar(255) NOT NULL,
  `cliente_id` bigint(20) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL,
  `saldo_inicial` int(11) DEFAULT NULL,
  `tipo_cuenta` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `cuenta` (`numero_cuenta`, `cliente_id`, `estado`, `saldo_inicial`, `tipo_cuenta`) VALUES
('225487', 38, b'1', 700, 'Corriente'),
('478758', 37, b'1', 1425, 'Ahorros'),
('495878', 39, b'1', 150, 'Ahorros'),
('496825', 38, b'1', 0, 'Ahorros'),
('585545', 37, b'1', 1000, 'Corriente');


CREATE TABLE `movimiento` (
  `movimiento_id` bigint(20) NOT NULL,
  `fecha` datetime(6) DEFAULT NULL,
  `saldo` int(11) DEFAULT NULL,
  `tipo_movimiento` varchar(255) DEFAULT NULL,
  `valor` int(11) DEFAULT NULL,
  `numero_cuenta` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;


INSERT INTO `movimiento` (`movimiento_id`, `fecha`, `saldo`, `tipo_movimiento`, `valor`, `numero_cuenta`) VALUES
(22, '2024-10-27 15:03:39.000000', 1425, 'retiro', 575, '478758'),
(23, '2024-10-27 15:04:32.000000', 700, 'deposito', 600, '225487'),
(24, '2024-10-27 15:04:58.000000', 150, 'deposito', 150, '495878'),
(25, '2024-10-27 15:05:20.000000', 0, 'retiro', 540, '496825');


ALTER TABLE `cuenta`
  ADD PRIMARY KEY (`numero_cuenta`);


ALTER TABLE `movimiento`
  ADD PRIMARY KEY (`movimiento_id`),
  ADD KEY `FKk10u787s9re28fue9gdscb5kt` (`numero_cuenta`);


ALTER TABLE `movimiento`
  MODIFY `movimiento_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;


ALTER TABLE `movimiento`
  ADD CONSTRAINT `FKk10u787s9re28fue9gdscb5kt` FOREIGN KEY (`numero_cuenta`) REFERENCES `cuenta` (`numero_cuenta`);
COMMIT;

