-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 20, 2021 at 05:25 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `sewaja`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `kdBrg` varchar(5) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`kdBrg`, `nama`, `harga`) VALUES
('B0001', 'Sepatu Bola', 4000),
('B0002', 'Baju Bola', 4000),
('B0003', 'Celana Bola', 4000),
('B0004', 'Bola', 4000),
('MN001', 'Nasi Goreng', 10000);

-- --------------------------------------------------------

--
-- Table structure for table `lapangan`
--

CREATE TABLE `lapangan` (
  `kdlpg` varchar(5) NOT NULL,
  `namalpg` varchar(30) NOT NULL,
  `hargasiang` int(11) NOT NULL,
  `hargamalam` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lapangan`
--

INSERT INTO `lapangan` (`kdlpg`, `namalpg`, `hargasiang`, `hargamalam`) VALUES
('L0001', 'Lapangan Luar', 130000, 100000),
('L0002', 'Lapangan Dalam', 150000, 130000);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `username` varchar(25) NOT NULL,
  `password` varchar(25) NOT NULL,
  `status` enum('admin','operator') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`username`, `password`, `status`) VALUES
('admin', 'admin', 'admin'),
('farhan', 'farhan', 'admin'),
('operator', 'operator', 'operator');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idMem` varchar(5) NOT NULL,
  `namaMem` varchar(30) NOT NULL,
  `telp` varchar(20) NOT NULL,
  `alm` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`idMem`, `namaMem`, `telp`, `alm`) VALUES
('-', '-', '-', '-'),
('M0001', 'Tita', '08432421', 'Batusangkar'),
('M0002', 'Budi', '08532', 'Padang');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `kodeplg` varchar(5) NOT NULL,
  `namaplg` varchar(30) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `idMem` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`kodeplg`, `namaplg`, `telp`, `idMem`) VALUES
('PL001', 'Ega', '0853212', 'M0001'),
('PL002', 'Yudi', '0843271241', '-'),
('PL003', 'Randi', '084324', 'M0002'),
('PL004', 'Martin', '0831235', 'M0001'),
('PL005', 'Tirto', '083213', '-');

-- --------------------------------------------------------

--
-- Table structure for table `pembayaran`
--

CREATE TABLE `pembayaran` (
  `idtrans` varchar(5) NOT NULL,
  `idnota` varchar(5) NOT NULL,
  `kdpem` varchar(5) NOT NULL,
  `total` int(11) NOT NULL,
  `masukkan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pembayaran`
--

INSERT INTO `pembayaran` (`idtrans`, `idnota`, `kdpem`, `total`, `masukkan`) VALUES
('T0001', 'P0001', 'S0001', 72000, 72000);

-- --------------------------------------------------------

--
-- Table structure for table `pemesanan`
--

CREATE TABLE `pemesanan` (
  `idnota` varchar(5) NOT NULL,
  `kdplg` varchar(5) NOT NULL,
  `tglpesan` date NOT NULL,
  `subtotalmesan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pemesanan`
--

INSERT INTO `pemesanan` (`idnota`, `kdplg`, `tglpesan`, `subtotalmesan`) VALUES
('P0001', 'PL001', '2021-06-01', 22000),
('P0002', 'PL003', '2021-03-01', 12000),
('P0003', 'PL002', '2021-01-01', 16000);

-- --------------------------------------------------------

--
-- Table structure for table `penyewaan`
--

CREATE TABLE `penyewaan` (
  `kdpem` varchar(5) NOT NULL,
  `kdplg` varchar(5) NOT NULL,
  `kdlpg` varchar(5) NOT NULL,
  `tglmain` date NOT NULL,
  `bayarsewa` int(11) NOT NULL,
  `jamakhir` time NOT NULL,
  `jamawal` time NOT NULL,
  `totalsewa` int(11) NOT NULL,
  `uangmuka` int(11) NOT NULL,
  `pemasukan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `penyewaan`
--

INSERT INTO `penyewaan` (`kdpem`, `kdplg`, `kdlpg`, `tglmain`, `bayarsewa`, `jamakhir`, `jamawal`, `totalsewa`, `uangmuka`, `pemasukan`) VALUES
('S0001', 'PL001', 'L0001', '2021-06-01', 50000, '18:00:00', '17:00:00', 150000, 100000, 150000),
('S0002', 'PL002', 'L0002', '2021-02-01', 100000, '16:00:00', '15:00:00', 150000, 50000, 730000),
('S003', 'PL003', 'L0001', '2021-03-01', 30000, '16:00:00', '15:00:00', 130000, 100000, 710000);

-- --------------------------------------------------------

--
-- Table structure for table `pesanan`
--

CREATE TABLE `pesanan` (
  `idNota` varchar(5) NOT NULL,
  `kdBrg` varchar(5) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `totalharga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pesanan`
--

INSERT INTO `pesanan` (`idNota`, `kdBrg`, `jumlah`, `totalharga`) VALUES
('P0001', 'B0001', 3, 12000),
('P0001', 'MN001', 1, 10000),
('P0002', 'B0001', 1, 4000),
('P0002', 'B0003', 1, 4000),
('P0002', 'B0004', 1, 4000),
('P0003', 'B0001', 4, 16000),
('P0004', 'B0001', 2, 8000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`kdBrg`);

--
-- Indexes for table `lapangan`
--
ALTER TABLE `lapangan`
  ADD PRIMARY KEY (`kdlpg`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idMem`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`kodeplg`),
  ADD KEY `pelanggan_ibfk_1` (`idMem`);

--
-- Indexes for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`idtrans`),
  ADD KEY `pembayaran_ibfk_1` (`idnota`),
  ADD KEY `pembayaran_ibfk_2` (`kdpem`);

--
-- Indexes for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD PRIMARY KEY (`idnota`),
  ADD KEY `pemesanan_ibfk_1` (`kdplg`);

--
-- Indexes for table `penyewaan`
--
ALTER TABLE `penyewaan`
  ADD PRIMARY KEY (`kdpem`),
  ADD KEY `penyewaan_ibfk_1` (`kdlpg`),
  ADD KEY `penyewaan_ibfk_2` (`kdplg`);

--
-- Indexes for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD PRIMARY KEY (`idNota`,`kdBrg`),
  ADD KEY `pesanan_ibfk_1` (`kdBrg`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD CONSTRAINT `pelanggan_ibfk_1` FOREIGN KEY (`idMem`) REFERENCES `member` (`idMem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD CONSTRAINT `pembayaran_ibfk_1` FOREIGN KEY (`idnota`) REFERENCES `pemesanan` (`idnota`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pembayaran_ibfk_2` FOREIGN KEY (`kdpem`) REFERENCES `penyewaan` (`kdpem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pemesanan`
--
ALTER TABLE `pemesanan`
  ADD CONSTRAINT `pemesanan_ibfk_1` FOREIGN KEY (`kdplg`) REFERENCES `pelanggan` (`kodeplg`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `pemesanan_ibfk_2` FOREIGN KEY (`idnota`) REFERENCES `pesanan` (`idNota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `penyewaan`
--
ALTER TABLE `penyewaan`
  ADD CONSTRAINT `penyewaan_ibfk_1` FOREIGN KEY (`kdlpg`) REFERENCES `lapangan` (`kdlpg`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `penyewaan_ibfk_2` FOREIGN KEY (`kdplg`) REFERENCES `pelanggan` (`kodeplg`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pesanan`
--
ALTER TABLE `pesanan`
  ADD CONSTRAINT `pesanan_ibfk_1` FOREIGN KEY (`kdBrg`) REFERENCES `barang` (`kdBrg`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
