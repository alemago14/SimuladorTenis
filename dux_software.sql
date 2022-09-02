-- phpMyAdmin SQL Dump
-- version 4.4.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-09-2022 a las 17:53:55
-- Versión del servidor: 5.6.25
-- Versión de PHP: 5.6.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `dux_software`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `id_cliente` bigint(20) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `apellido` varchar(128) NOT NULL,
  `cuit` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `nombre`, `apellido`, `cuit`) VALUES
(1, 'Alejandro ', 'Maugouber', 211111156),
(23, 'Javier', 'Martinez', 78124567893);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `codigo` varchar(128) NOT NULL,
  `nombre` varchar(128) NOT NULL,
  `fecha_creacion` date NOT NULL,
  `id_rubro` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`codigo`, `nombre`, `fecha_creacion`, `id_rubro`) VALUES
('afdqwdwq', 'Talca Naranja', '2022-08-01', 1),
('cintapp', 'Cinta de Papel Adhesiva', '2022-08-31', 3),
('fqfdqwqw', 'Cerveza Andes 900ml', '2022-08-31', 2),
('newnew', 'nuevin', '2022-04-01', 5),
('wqerr', 'Coca-Cola', '2022-08-02', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rubro`
--

CREATE TABLE IF NOT EXISTS `rubro` (
  `id_rubro` bigint(20) NOT NULL,
  `rubro` varchar(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `rubro`
--

INSERT INTO `rubro` (`id_rubro`, `rubro`) VALUES
(1, 'Bebidas no Alcoholicas'),
(2, 'Bebidas Alcoholicas'),
(3, 'Utiles'),
(4, 'Galletas'),
(5, 'nuevo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE IF NOT EXISTS `venta` (
  `id_venta` bigint(20) NOT NULL,
  `codigo_producto` varchar(128) NOT NULL,
  `fecha` date NOT NULL,
  `cantidad` bigint(20) NOT NULL,
  `precio_unitario` double NOT NULL,
  `id_cliente` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`id_venta`, `codigo_producto`, `fecha`, `cantidad`, `precio_unitario`, `id_cliente`) VALUES
(1, 'cintapp', '2022-08-31', 2, 100, 1),
(6, 'fqfdqwqw', '2022-08-02', 5, 120.5, 23),
(8, 'afdqwdwq', '2022-08-30', 2, 1, 1),
(45, 'wqerr', '2022-05-20', 8, 55.55, 1),
(879, 'newnew', '2022-05-17', 2, 840.5, 23);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`codigo`),
  ADD KEY `id_rubro` (`id_rubro`);

--
-- Indices de la tabla `rubro`
--
ALTER TABLE `rubro`
  ADD PRIMARY KEY (`id_rubro`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`id_venta`),
  ADD KEY `codigo_producto` (`codigo_producto`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_rubro`) REFERENCES `rubro` (`id_rubro`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `venta_ibfk_1` FOREIGN KEY (`codigo_producto`) REFERENCES `producto` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `venta_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
