-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2024 at 04:22 PM
-- Server version: 11.3.0-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ktp_republikhb`
--

-- --------------------------------------------------------

--
-- Table structure for table `data_ktp`
--

CREATE TABLE `data_ktp` (
  `nik` varchar(16) NOT NULL,
  `nama` varchar(255) DEFAULT NULL,
  `tanggalLahir` date DEFAULT NULL,
  `tempatLahir` varchar(50) DEFAULT NULL,
  `jenisKelamin` varchar(6) DEFAULT NULL,
  `golDarah` varchar(2) DEFAULT NULL,
  `alamat` varchar(255) DEFAULT NULL,
  `rtRw` varchar(7) DEFAULT NULL,
  `kelDesa` varchar(50) DEFAULT NULL,
  `kecamatan` varchar(50) DEFAULT NULL,
  `agama` varchar(15) DEFAULT NULL,
  `statusKawin` varchar(20) DEFAULT NULL,
  `pekerjaan` varchar(120) DEFAULT NULL,
  `kewarganegaraan` varchar(50) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `ttd` varchar(255) DEFAULT NULL,
  `berlakuHingga` varchar(12) DEFAULT NULL,
  `kotaPembuatanKtp` varchar(50) DEFAULT NULL,
  `tanggalPembuatanKtp` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `data_ktp`
--

INSERT INTO `data_ktp` (`nik`, `nama`, `tanggalLahir`, `tempatLahir`, `jenisKelamin`, `golDarah`, `alamat`, `rtRw`, `kelDesa`, `kecamatan`, `agama`, `statusKawin`, `pekerjaan`, `kewarganegaraan`, `foto`, `ttd`, `berlakuHingga`, `kotaPembuatanKtp`, `tanggalPembuatanKtp`) VALUES
('001', 'Steven Felim', '2004-03-14', 'Kuala Lumpur', 'PRIA', 'A', 'Gg Maksudi No 10', '006/015', 'Panjunan', 'Astana Anyar', 'BUDDHA', 'BELUM_MENIKAH', 'Pengangguran ', 'WNA Malaysia', 'DSC_4148.jpg', '1ttd.png', 'Seumur Hidup', 'Bandung', '2024-12-03');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `data_ktp`
--
ALTER TABLE `data_ktp`
  ADD PRIMARY KEY (`nik`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
