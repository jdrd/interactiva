-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 27-05-2012 a las 20:02:03
-- Versión del servidor: 5.0.95
-- Versión de PHP: 5.2.9

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `fincas_Proyecto`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistentes`
--

CREATE TABLE IF NOT EXISTS `asistentes` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(20) default NULL,
  `usuario` varchar(20) default NULL,
  `pass` varchar(20) default NULL,
  `conf` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=110 ;

--
-- Volcado de datos para la tabla `asistentes`
--

INSERT INTO `asistentes` (`id`, `nombre`, `usuario`, `pass`, `conf`) VALUES
(109, 'asd', 'asdd', 'dasd', ''),
(108, 'a', 'a', 'a', ''),
(106, 'Mario', 'mar', '123', ''),
(107, 'Jhon Mauro', 'jhonmgb', 'jhonmgb', ''),
(105, 'Juan', 'jota', 'perez', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ponentes`
--

CREATE TABLE IF NOT EXISTS `ponentes` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(20) default NULL,
  `usuario` varchar(20) default NULL,
  `pass` varchar(20) default NULL,
  `conf` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=56 ;

--
-- Volcado de datos para la tabla `ponentes`
--

INSERT INTO `ponentes` (`id`, `nombre`, `usuario`, `pass`, `conf`) VALUES
(54, 'asdasd', 'hola', 'asdasd', 'asdasd'),
(53, 'asdasdasdfsdf', 'ped', 'sdfsdfasdasd', 'asdasdsdfsdf'),
(55, 'Donald Knuth', 'knuth', 'dknuth', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usos`
--

CREATE TABLE IF NOT EXISTS `usos` (
  `id` int(11) NOT NULL auto_increment,
  `horario` datetime default NULL,
  `horafin` datetime default NULL,
  `capacidad` int(20) default NULL,
  `salon` int(20) default NULL,
  `ponente` varchar(20) default NULL,
  `conf` varchar(20) default NULL,
  `cupo` int(11) default NULL,
  `disponible` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=104 ;

--
-- Volcado de datos para la tabla `usos`
--

INSERT INTO `usos` (`id`, `horario`, `horafin`, `capacidad`, `salon`, `ponente`, `conf`, `cupo`, `disponible`) VALUES
(87, '2011-01-01 12:00:00', '2011-01-01 00:00:00', 23, 1001, 'knuth', 'Caninos', 0, 0),
(88, '2000-10-10 10:10:10', '2000-10-10 10:10:10', 33, 1013, 'Fernando', 'El mundo Virtual', 0, 0),
(103, '2000-10-10 10:10:10', '2000-10-10 10:10:10', 1, 1011, 'knuth', 'SO Y Mas', 0, 0),
(100, '2000-10-10 10:10:10', '2000-10-10 10:10:10', 0, 0, 'cxcv', 'cv', 0, 0),
(101, '2000-10-10 10:10:10', '2000-10-10 10:10:10', 0, 0, 'ss', 'xvcxvcx', 0, 0),
(102, '2000-10-10 10:10:10', '2000-10-10 10:10:10', 0, 0, 'ssss', 'sssssss', 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL auto_increment,
  `nombre` varchar(20) default NULL,
  `usuario` varchar(20) default NULL,
  `pass` varchar(20) default NULL,
  `rol` varchar(20) default NULL,
  `img` varchar(2) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=156 ;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `usuario`, `pass`, `rol`, `img`) VALUES
(82, 'administrador', 'admin', 'adminPI', 'ad', NULL),
(155, 'Juan David', 'juan', '123', '', NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
