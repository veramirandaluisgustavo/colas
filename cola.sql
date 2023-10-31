create database cola;
use cola;

CREATE TABLE `especialidad` (
  `nombre` varchar(40) NOT NULL,
  `imagen` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `especialidad`
--

INSERT INTO `especialidad` (`nombre`, `imagen`) VALUES
('cardiologia', 'cardiologia.jpg'),
('dermatologia', 'dermatologia.jpg'),
('obstetricia', 'obstetricia.jpg'),
('neurologia', 'neurologia.jpg'),
('pediatria', 'pediatria.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medico`
--

CREATE TABLE `medico` (
  `nombre` varchar(40) NOT NULL,
  `especialidad` varchar(40) NOT NULL,
  `imagen` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `medico`
--

INSERT INTO `medico` (`nombre`, `especialidad`, `imagen`) VALUES
('Jose Condori', 'cardiologia', 'jose.jpg'),
('Marta Ruiz', 'pediatria', 'marta.jpg');
COMMIT;