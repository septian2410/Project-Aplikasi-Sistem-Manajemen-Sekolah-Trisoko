-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 19 Jun 2022 pada 05.57
-- Versi server: 10.4.13-MariaDB
-- Versi PHP: 7.4.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_datasekolah`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `pembayaran`
--

CREATE TABLE `pembayaran` (
  `kode` int(11) NOT NULL,
  `harga1` int(11) NOT NULL,
  `harga2` int(11) NOT NULL,
  `harga3` int(11) NOT NULL,
  `hasil` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `pembayaran`
--

INSERT INTO `pembayaran` (`kode`, `harga1`, `harga2`, `harga3`, `hasil`) VALUES
(3, 1, 2, 0, 3),
(11, 100, 50, 0, 150),
(21, 200, 50, 0, 250),
(31, 200, 100, 50, 250);

-- --------------------------------------------------------

--
-- Struktur dari tabel `petugas`
--

CREATE TABLE `petugas` (
  `id_petugas` int(11) NOT NULL,
  `username` varchar(225) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nama_lengkap` varchar(225) NOT NULL,
  `level` enum('Kesiswaan','Inventory','Administrasi') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `petugas`
--

INSERT INTO `petugas` (`id_petugas`, `username`, `password`, `nama_lengkap`, `level`) VALUES
(1, 'pandu', '999', 'Pandu Septiandito', 'Kesiswaan'),
(2, 'DWI', '123', 'Dwi Agung Widiarto', 'Inventory'),
(3, 'NANDA', '567', 'Nanda Kresna Riyadi', 'Administrasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `spp`
--

CREATE TABLE `spp` (
  `id_spp` int(20) NOT NULL,
  `tahun` int(20) NOT NULL,
  `nominal` int(20) NOT NULL,
  `uts` int(20) NOT NULL,
  `uas` int(20) NOT NULL,
  `seragam` int(20) NOT NULL,
  `buku` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `spp`
--

INSERT INTO `spp` (`id_spp`, `tahun`, `nominal`, `uts`, `uas`, `seragam`, `buku`) VALUES
(6, 2020, 150000, 20000, 40000, 180000, 200000),
(7, 2021, 170000, 30000, 50000, 200000, 250000),
(8, 2022, 210000, 40000, 50000, 220000, 280000),
(10, 2023, 230000, 50000, 60000, 220000, 260000),
(11, 2032, 10000, 5000, 2000, 3000, 200);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_bayar_lain`
--

CREATE TABLE `tb_data_bayar_lain` (
  `nama` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `no_pembayaran_lain` varchar(20) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `tahun_dibayar` varchar(20) NOT NULL,
  `id_spp` int(11) NOT NULL,
  `uts` varchar(20) NOT NULL,
  `uas` varchar(20) NOT NULL,
  `seragam` varchar(20) NOT NULL,
  `buku` varchar(20) NOT NULL,
  `nis` varchar(30) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_bayar_lain`
--

INSERT INTO `tb_data_bayar_lain` (`nama`, `kelas`, `no_pembayaran_lain`, `tgl_bayar`, `tahun_dibayar`, `id_spp`, `uts`, `uas`, `seragam`, `buku`, `nis`, `id_petugas`) VALUES
('Fahri Abdur rohmat', 'VIII A', 'TRS0001', '2022-06-15', '2021', 7, '30000', '50000', '200000', '250000', '000732821140', 3),
('Ferry Ardiansyah', 'VII A', 'TRS00010', '2022-06-15', '2022', 8, '40000', '50000', '220000', 'Belum Lunas', '000908324520', 3),
('Nurina Amanda Safa', 'VII A', 'TRS00011', '2022-06-15', '2022', 8, '40000', '50000', '220000', '280000', '000908326740', 3),
('Muhammad Fajri', 'VII A', 'TRS00012', '2022-06-15', '2022', 8, '40000', '50000', 'Belum Lunas', '280000', '000908329540', 3),
('Muhammad Farrel', 'VIII A', 'TRS0002', '2022-06-15', '2021', 7, '30000', '50000', '200000', '250000', '000732821225', 3),
('Fathur Jaya ', 'VIII A', 'TRS0003', '2022-06-15', '2021', 7, '30000', '50000', 'Belum Lunas', 'Belum Lunas', '000732823450', 3),
('Sifa Al Jannah', 'VIII A', 'TRS0004', '2022-06-15', '2021', 7, '30000', '50000', 'Belum Lunas', 'Belum Lunas', '000732827676', 3),
('Kevin Aprilio', 'IX A', 'TRS0005', '2022-06-15', '2020', 6, '20000', '40000', '180000', '200000', '000807420920', 3),
('Rahmat Firdaus', 'IX A', 'TRS0006', '2022-06-15', '2020', 6, '20000', '40000', 'Belum Lunas', 'Belum Lunas', '000807421120', 3),
('Sinta Anjani', 'IX A', 'TRS0007', '2022-06-15', '2020', 6, '20000', '40000', '180000', '200000', '000807425976', 3),
('Keya Qila', 'IX A', 'TRS0008', '2022-06-15', '2020', 6, '20000', '40000', '180000', '200000', '000807428976', 3),
('Syahrul Ahmad', 'VII A', 'TRS0009', '2022-06-15', '2022', 8, '40000', '50000', 'Belum Lunas', 'Belum Lunas', '000908321120', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_bayar_spp`
--

CREATE TABLE `tb_data_bayar_spp` (
  `nama` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `no_pembayaran_spp` varchar(20) NOT NULL,
  `tgl_bayar` date NOT NULL,
  `bulan_dibayar` varchar(20) NOT NULL,
  `tahun_dibayar` varchar(20) NOT NULL,
  `id_spp` int(20) NOT NULL,
  `jumlah_dibayar` int(20) NOT NULL,
  `nis` varchar(30) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_bayar_spp`
--

INSERT INTO `tb_data_bayar_spp` (`nama`, `kelas`, `no_pembayaran_spp`, `tgl_bayar`, `bulan_dibayar`, `tahun_dibayar`, `id_spp`, `jumlah_dibayar`, `nis`, `id_petugas`) VALUES
('Fahri Abdur rohmat', 'VIII A', 'TRS0001', '2022-06-15', 'januari', '2021', 7, 170000, '000732821140', 3),
('Ferry Ardiansyah', 'VII A', 'TRS00010', '2022-06-15', 'januari', '2022', 8, 210000, '000908324520', 3),
('Nurina Amanda Safa', 'VII A', 'TRS00011', '2022-06-15', 'januari', '2022', 8, 210000, '000908326740', 3),
('Muhammad Fajri', 'VII A', 'TRS00012', '2022-06-15', 'januari', '2022', 8, 210000, '000908329540', 3),
('Muhammad Farrel', 'VIII A', 'TRS0002', '2022-06-15', 'januari', '2021', 7, 170000, '000732821225', 3),
('Fathur Jaya ', 'VIII A', 'TRS0003', '2022-06-15', 'januari', '2021', 7, 170000, '000732823450', 3),
('Sifa Al Jannah', 'VIII A', 'TRS0004', '2022-06-15', 'januari', '2021', 7, 170000, '000732827676', 3),
('Kevin Aprilio', 'IX A', 'TRS0005', '2022-06-15', 'januari', '2020', 6, 150000, '000807420920', 3),
('Rahmat Firdaus', 'IX A', 'TRS0006', '2022-06-15', 'januari', '2020', 6, 150000, '000807421120', 3),
('Sinta Anjani', 'IX A', 'TRS0007', '2022-06-15', 'januari', '2020', 6, 150000, '000807425976', 3),
('Keya Qila', 'IX A', 'TRS0008', '2022-06-15', 'januari', '2020', 6, 150000, '000807428976', 3),
('Syahrul Ahmad', 'VII A', 'TRS0009', '2022-06-15', 'januari', '2022', 8, 210000, '000908321120', 3);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_guru`
--

CREATE TABLE `tb_data_guru` (
  `nip` varchar(20) NOT NULL,
  `nm_guru` varchar(20) NOT NULL,
  `mapel` varchar(20) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `ttl` date NOT NULL,
  `asal` varchar(30) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `telpon` varchar(15) NOT NULL,
  `alamat` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `tb_data_guru`
--

INSERT INTO `tb_data_guru` (`nip`, `nm_guru`, `mapel`, `jenis_kelamin`, `ttl`, `asal`, `agama`, `telpon`, `alamat`) VALUES
('197502132011122006	', 'Wina Nadiya, S.pa', 'Bahasa Indonesia', 'Perempuan', '1984-04-12', 'Jambi', 'Islam', '081256987986', 'Jln Baru, No 94B.'),
('198007082008062004	', 'Sekar Rini, M.m', 'Bahasa Indonesia', 'Perempuan', '1981-06-03', 'Jawa Tengah ', 'Budha', '085884722698', 'Jln Masjid, No.30 A'),
('198007082008062220	', 'Fatui Al Faqih', 'Bimbingan konseling', 'Laki-laki', '1982-09-09', 'Banten', 'Islam', '085884722620', 'Jln Raya al jamaludin, No 45 A'),
('198503222011122002	', 'Bertha Dian, M.pd', 'Bahasa Inggris', 'Perempuan', '1983-11-09', 'Bali', 'Khatolik', '081256477835', 'Jln Dewa No 19. D'),
('198705202006061006	', 'Pandu Wicaksondes', 'Penjasorkes', 'Laki-laki', '2000-09-24', 'DKI Jakarta', 'Islam', '084579856631', 'Jln Raya Ciracas, No 94.B'),
('198801102008111001	', 'Abdul Mufti, M.pd', 'Matematika', 'Laki-laki', '1973-02-09', 'Jawa Timur', 'Islam', '085844569874', 'Jln Anyer No 32.A'),
('198802282007122009	', 'Rifanni Nur, S.Ak', 'Ips', 'Perempuan', '1972-01-11', 'Jawa Tengah ', 'Islam', '081255647985', 'Jln Rambutan No 21.G'),
('198906302009101007', 'Antonio Jaka, S.Hum', 'Ips', 'Laki-laki', '1979-02-10', 'DKI Jakarta', 'Hindu', '025879865412', 'Jln Patin No 32.G'),
('199004212009091012', 'Jarwo Sutejo, S.Pdi', 'Pendidikan Agama', 'Laki-laki', '1975-07-18', 'Jawa Barat', 'Islam', '085884733459', 'Jln Jati No 56.B'),
('199007252008092007	', 'Nadia Maharani, S.pd', 'Seni Budaya', 'Perempuan', '1972-11-10', 'DKI Jakarta', 'Kristen', '081365488976', 'Jln Syair No.73 D'),
('199008132011111004', 'Agung Riski, M.kom', 'Seni Budaya', 'Laki-laki', '2022-12-14', 'DKI Jakarta', 'Islam', '081365465879', 'Jln Pintas No. 21 B');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_kelas`
--

CREATE TABLE `tb_data_kelas` (
  `kd_kelas` int(20) NOT NULL,
  `wali_kelas` varchar(20) NOT NULL,
  `jumlah` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_kelas`
--

INSERT INTO `tb_data_kelas` (`kd_kelas`, `wali_kelas`, `jumlah`, `kelas`) VALUES
(7, 'Prambudi M.Pd', '29', 'VII A'),
(8, 'Samuel M.Pd', '32', 'VIII A'),
(9, 'Fajri M.Pd', '30', 'IX A'),
(12, 'Wina Nadiya, S.pa', '29', 'VII C'),
(13, 'Sekar Rini, M.m', '29', 'VII B'),
(14, 'Pandu Wicaksondes', '30', 'VIII B'),
(15, 'Abdul Mufti, M.pd', '30', 'VIII C'),
(16, 'Nadia Maharani, S.pd', '30', 'IX B'),
(17, 'Agung Riski, M.kom', '30', 'IX C'),
(18, 'Jarwo Sutejo, S.Pdi', '32', 'VII D');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_siswa`
--

CREATE TABLE `tb_data_siswa` (
  `nisn` varchar(50) NOT NULL,
  `nis` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `kelas` varchar(10) NOT NULL,
  `ttl` date NOT NULL,
  `asal` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `telp` varchar(15) NOT NULL,
  `alamat` varchar(20) NOT NULL,
  `id_spp` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_siswa`
--

INSERT INTO `tb_data_siswa` (`nisn`, `nis`, `nama`, `kelas`, `ttl`, `asal`, `jenis_kelamin`, `agama`, `telp`, `alamat`, `id_spp`) VALUES
('0007328211', '000732821140', 'Fahri Abdur rohmat', 'VIII A', '2000-09-13', 'DKI Jakarta', 'Laki-laki', 'Islam', '0892-7732-6677', 'Jln bumi No 3.C', 7),
('0007328212', '000732821225', 'Muhammad Farrel', 'VIII A', '2000-09-30', 'DKI Jakarta', 'Laki-laki', 'Islam', '0892-7732-1122', 'Jln Pakitan No 28.D', 7),
('0007328234', '000732823450', 'Fathur Jaya ', 'VIII A', '2000-10-08', 'Jawa Barat', 'Laki-laki', 'Islam', '0892-7760-5343', 'Jln Bandeng No 4.E', 7),
('0007328276', '000732827676', 'Sifa Al Jannah', 'VIII A', '2000-08-17', 'Yogyakarta ', 'Perempuan', 'Islam', '0892-7732-0832', 'Jln Mawar No 4.E', 7),
('0008074209', '000807420920', 'Kevin Aprilio', 'IX A', '1999-08-11', 'DKI Jakarta', 'Laki-laki', 'Khatolik', '0892-7732-2390', 'Jln Pisang No 42.A', 6),
('0008074211', '000807421120', 'Rahmat Firdaus', 'IX A', '1999-12-16', 'Jawa Timur', 'Laki-laki', 'Islam', '0892-7732-6756', 'Jln Jati No 42.B', 6),
('0008074259', '000807425976', 'Sinta Anjani', 'IX A', '1999-02-18', 'Bali', 'Perempuan', 'Hindu', '0892-7732-5267', 'Jln Raya Baru No 8.B', 6),
('0008074289', '000807428976', 'Keya Qila', 'IX A', '1999-06-14', 'DKI Jakarta', 'Perempuan', 'Kristen', '0892-7732-1212', 'Jln Ranco No 7.B', 6),
('0009083211', '000908321120', 'Syahrul Ahmad', 'VII A', '2001-12-12', 'DKI Jakarta', 'Laki-laki', 'Islam', '0892-7732-0909', 'Jln Kramat No 22.B', 8),
('0009083245', '000908324520', 'Ferry Ardiansyah', 'VII A', '2001-06-13', 'DKI Jakarta', 'Laki-laki', 'Islam', '0892-7732-2222', 'Jln Kramat No 21.B', 8),
('0009083267', '000908326740', 'Nurina Amanda Safa', 'VII A', '2001-02-09', 'Lampung', 'Perempuan', 'Islam', '0892-7732-0982', 'Jln Patin No 10.F', 8),
('0009083295', '000908329540', 'Muhammad Fajri', 'VII A', '2001-08-11', 'Jawa Barat', 'Laki-laki', 'Islam', '0892-7732-9990', 'Jln Apel No 21.B', 8);

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_data_staff`
--

CREATE TABLE `tb_data_staff` (
  `id_staff` varchar(20) NOT NULL,
  `bidang` varchar(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `ttl` date NOT NULL,
  `asal` varchar(30) NOT NULL,
  `jenis_kelamin` varchar(10) NOT NULL,
  `agama` varchar(10) NOT NULL,
  `telp` varchar(20) NOT NULL,
  `alamat` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_data_staff`
--

INSERT INTO `tb_data_staff` (`id_staff`, `bidang`, `nama`, `ttl`, `asal`, `jenis_kelamin`, `agama`, `telp`, `alamat`) VALUES
('15140790	', 'Keamanan', 'Prasetyo Andi', '1976-06-18', 'Jawa Barat', 'Laki-laki', 'Islam', '081245663900	', 'JL.Penggilingan II'),
('15230487	', 'Keamanan', 'Cahyo WinardI', '1975-02-06', 'DKI Jakarta', 'Laki-laki', 'Islam', '085632145598	', 'JL.Kembangan II'),
('16150682	', 'Tata Usaha ', 'Eti Kosendang', '1971-04-16', '', 'Perempuan', 'Islam', '081256987863	', 'JL.Sadar III'),
('17301285	', 'Tata Usaha ', 'Dhea Ageviana', '2000-02-11', '', 'Perempuan', 'Kristen', '081256478896	', 'JL.Arundina IV'),
('19151289', 'Keamanan', 'Tarno Sucipto', '1979-09-14', '', 'Laki-laki', 'Islam', '085846521103	', 'JL.Puri Cikole'),
('20060395	', 'Kebersihan', 'Ayu Eka', '1999-11-04', '', 'Perempuan', 'Kristen', '085632158966	', 'JL.Radar Auri'),
('20070390	', 'Kebersihan', 'Nabila Zizi', '1983-07-15', '', 'Perempuan', 'Islam', '081236547896	', 'JL.Indah Puri II'),
('20170980	', 'Teknisi Komputer', 'Toto Handoko', '1989-05-12', '', 'Laki-laki', 'Islam', '081245639985	', 'JL.Merpati Terbang'),
('20210498	', 'Kebersihan', 'Ardhito Pramono', '2000-08-11', '', 'Laki-laki', 'Khatolik', '085879866452	', 'JL.Industrial'),
('21010490	', 'Kebersihan', 'Endang Tarmizi', '1984-10-10', '', 'Perempuan', 'Islam', '085778466920	', 'JL.Nagrek II');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_in_barang`
--

CREATE TABLE `tb_in_barang` (
  `kode_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `tanggal_masuk` date NOT NULL,
  `model` varchar(20) NOT NULL,
  `keterangan` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_in_barang`
--

INSERT INTO `tb_in_barang` (`kode_barang`, `nama_barang`, `jumlah`, `tanggal_masuk`, `model`, `keterangan`) VALUES
('BR001', 'Kursi Siswa', 450, '2022-04-12', 'Ikea', '100 Kursi Siswa Rusak '),
('BR002', 'Meja Siswa', 450, '2022-04-12', 'Ikea', '30 Kursi Siswa Rusak'),
('BR003', 'Papan Tulis', 20, '2022-04-12', 'Ikea', '-'),
('BR004', 'Spidol Permanent', 100, '2022-04-12', 'Snowman', '50 Spidol Permanent Habis'),
('BR005', 'LCD Proyektor', 15, '2022-04-12', 'LD', '2 LCD Proyektor Rusak'),
('BR006', 'Kipas Angin', 20, '2022-04-12', 'Panasonic', '5 Kipas Angin Butuh Perbaikan'),
('BR007', 'Air Conditioner', 20, '2022-04-12', 'Panasonic', '2 Air Conditioner Butuh Perbaikan'),
('BR008', 'Gawang bola', 2, '2022-06-15', 'Mebel', '-'),
('BR009', 'Bola Basket', 5, '2022-06-15', 'Nike', '2 Bola Rusak'),
('BR010', 'Bola Voli', 6, '2022-06-15', 'Nike', '2 Bola Rusak'),
('BR011', 'Lemari Kayu', 20, '2022-06-15', 'Mebel', '5 Lemari Rusak'),
('BR012', 'Rak Sepatu', 3, '2022-06-15', 'Plastik', '-'),
('BR013', 'Sapu Kelas', 30, '2022-06-15', 'Ikea', '4 Sapu Rusak'),
('BR014', 'Papan Pengumuman', 2, '2022-06-15', 'Mebel', '-'),
('BR015', 'Pel Kelas', 15, '2022-06-15', 'Plastik', '5 Pel Rusak');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_jadwal`
--

CREATE TABLE `tb_jadwal` (
  `kd_jadwal` varchar(30) NOT NULL,
  `kd_kelas` varchar(20) NOT NULL,
  `kelas` varchar(20) NOT NULL,
  `nip` varchar(20) NOT NULL,
  `nm_guru` varchar(20) NOT NULL,
  `mapel` varchar(20) NOT NULL,
  `hari` varchar(20) NOT NULL,
  `jam` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_jadwal`
--

INSERT INTO `tb_jadwal` (`kd_jadwal`, `kd_kelas`, `kelas`, `nip`, `nm_guru`, `mapel`, `hari`, `jam`) VALUES
('KJ001', '7', 'VII A', '197502132011122006	', 'Wina Nadiya, S.pa', 'Bahasa Indonesia', 'Senin', '07.00-09.00'),
('KJ002', '7', 'VII A', '198503222011122002	', 'Bertha Dian, M.pd', 'Bahasa Inggris', 'Senin', '09.15-11.00'),
('KJ003', '7', 'VII A', '199007252008092007	', 'Nadia Maharani, S.pd', 'Seni Budaya', 'Senin', '11.15-12.30'),
('KJ004', '7', 'VII A', '198705202006061006	', 'Pandu Wicaksondes', 'Penjasorkes', 'Selasa', '07.00-09.00'),
('KJ005', '7', 'VII A', '198906302009101007', 'Antonio Jaka, S.Hum', 'Ips', 'Selasa', '09.15-11.00'),
('KJ006', '7', 'VII A', '199004212009091012', 'Jarwo Sutejo, S.Pdi', 'Pendidikan Agama', 'Selasa', '11.15-12.30'),
('KJ007', '8', 'VIII A', '198802282007122009	', 'Rifanni Nur, S.Ak', 'Ips', 'Senin', '07.00-09.00'),
('KJ008', '8', 'VIII A', '197502132011122006	', 'Wina Nadiya, S.pa', 'Bahasa Indonesia', 'Senin', '09.15-11.00'),
('KJ009', '8', 'VIII A', '198007082008062220	', 'Fatui Al Faqih', 'Bimbingan konseling', 'Senin', '11.15-12.30'),
('KJ010', '9', 'IX A', '199004212009091012', 'Jarwo Sutejo, S.Pdi', 'Pendidikan Agama', 'Senin', '07.00-09.00'),
('KJ011', '9', 'IX A', '198801102008111001	', 'Abdul Mufti, M.pd', 'Matematika', 'Senin', '09.15-11.00'),
('KJ012', '9', 'IX A', '198503222011122002	', 'Bertha Dian, M.pd', 'Bahasa Inggris', 'Senin', '11.15-12.30');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_login`
--

CREATE TABLE `tb_login` (
  `id_petugas` int(11) NOT NULL,
  `username` varchar(225) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nama_lengkap` varchar(225) NOT NULL,
  `level` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_login`
--

INSERT INTO `tb_login` (`id_petugas`, `username`, `password`, `nama_lengkap`, `level`) VALUES
(1, 'pandu', '	\r\n999', 'Pandu Septiandito', 'Kesiswaan'),
(2, 'DWI', '123', 'Dwi Agung Widiarto', 'Inventory'),
(3, 'NANDA', '567', 'Nanda Kresna Riyadi', 'Administras');

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_out_barang`
--

CREATE TABLE `tb_out_barang` (
  `id_barang_rusak` varchar(20) NOT NULL,
  `kode_barang` varchar(20) NOT NULL,
  `nama_barang` varchar(20) NOT NULL,
  `jumlah` int(20) NOT NULL,
  `keadaan` varchar(20) NOT NULL,
  `model` varchar(20) NOT NULL,
  `tanggal_perbaikan` date NOT NULL,
  `status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `tb_out_barang`
--

INSERT INTO `tb_out_barang` (`id_barang_rusak`, `kode_barang`, `nama_barang`, `jumlah`, `keadaan`, `model`, `tanggal_perbaikan`, `status`) VALUES
('PM001', 'BR001', 'Kursi Siswa', 100, 'Rusak', 'Ikea', '2022-06-15', 'Sedang Memohon'),
('PM002', 'BR002', 'Meja Siswa', 30, 'Rusak', 'Ikea', '2022-06-15', 'Sedang Memohon'),
('PM003', 'BR004', 'Spidol Permanent', 50, 'Habis', 'Snowman', '2022-06-15', 'Sedang Memohon'),
('PM004', 'BR005', 'LCD Proyektor', 2, 'Rusak', 'LD', '2022-06-15', 'Sedang Memohon'),
('PM005', 'BR006', 'Kipas Angin', 5, 'Rusak', 'Panasonic', '2022-06-15', 'Sedang Memohon'),
('PM006', 'BR007', 'Air Conditioner', 2, 'Rusak', 'Panasonic', '2022-06-18', 'Sedang Memohon'),
('PM007', 'BR009', 'Bola Basket', 2, 'Rusak', 'Nike', '2022-06-18', 'Sedang Memohon'),
('PM008', 'BR010', 'Bola Voli', 2, 'Rusak', 'Nike', '2022-06-20', 'Sedang Memohon'),
('PM009', 'BR011', 'Lemari Kayu', 5, 'Rusak', 'Mebel', '2022-06-21', 'Sedang Memohon'),
('PM010', 'BR013', 'Sapu Kelas', 4, 'Rusak', 'Ikea', '2022-06-23', 'Sedang Memohon'),
('PM011', 'BR015', 'Pel Kelas', 5, 'Rusak', 'Plastik', '2022-06-25', 'Sedang Memohon');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE `user` (
  `nama` varchar(225) NOT NULL,
  `nama_lengkap` varchar(200) NOT NULL,
  `password` varchar(225) NOT NULL,
  `keterangan` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`nama`, `nama_lengkap`, `password`, `keterangan`) VALUES
('Pandu', 'Pandu Septiandito', '123pandu', 'admin TU Mahasiswa\r\n'),
('Risma', 'Risma Suciwati', 'Risma123', 'Admin TU Keuangan\r\n');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `petugas`
--
ALTER TABLE `petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indeks untuk tabel `spp`
--
ALTER TABLE `spp`
  ADD PRIMARY KEY (`id_spp`);

--
-- Indeks untuk tabel `tb_data_bayar_lain`
--
ALTER TABLE `tb_data_bayar_lain`
  ADD PRIMARY KEY (`no_pembayaran_lain`),
  ADD KEY `nis` (`nis`),
  ADD KEY `id_spp` (`id_spp`);

--
-- Indeks untuk tabel `tb_data_bayar_spp`
--
ALTER TABLE `tb_data_bayar_spp`
  ADD PRIMARY KEY (`no_pembayaran_spp`),
  ADD KEY `id_spp` (`id_spp`),
  ADD KEY `nis` (`nis`);

--
-- Indeks untuk tabel `tb_data_guru`
--
ALTER TABLE `tb_data_guru`
  ADD PRIMARY KEY (`nip`);

--
-- Indeks untuk tabel `tb_data_kelas`
--
ALTER TABLE `tb_data_kelas`
  ADD PRIMARY KEY (`kd_kelas`);

--
-- Indeks untuk tabel `tb_data_siswa`
--
ALTER TABLE `tb_data_siswa`
  ADD PRIMARY KEY (`nis`),
  ADD KEY `id_spp` (`id_spp`);

--
-- Indeks untuk tabel `tb_data_staff`
--
ALTER TABLE `tb_data_staff`
  ADD PRIMARY KEY (`id_staff`);

--
-- Indeks untuk tabel `tb_in_barang`
--
ALTER TABLE `tb_in_barang`
  ADD PRIMARY KEY (`kode_barang`);

--
-- Indeks untuk tabel `tb_jadwal`
--
ALTER TABLE `tb_jadwal`
  ADD PRIMARY KEY (`kd_jadwal`),
  ADD KEY `kd_kelas` (`kd_kelas`);

--
-- Indeks untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indeks untuk tabel `tb_out_barang`
--
ALTER TABLE `tb_out_barang`
  ADD PRIMARY KEY (`id_barang_rusak`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `pembayaran`
--
ALTER TABLE `pembayaran`
  MODIFY `kode` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT untuk tabel `petugas`
--
ALTER TABLE `petugas`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT untuk tabel `spp`
--
ALTER TABLE `spp`
  MODIFY `id_spp` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT untuk tabel `tb_data_kelas`
--
ALTER TABLE `tb_data_kelas`
  MODIFY `kd_kelas` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT untuk tabel `tb_login`
--
ALTER TABLE `tb_login`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
