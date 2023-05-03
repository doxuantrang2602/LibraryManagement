-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.27-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------
-- Dumping database structure for qltv
CREATE DATABASE IF NOT EXISTS `qltv` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `qltv`;

-- Dumping structure for table qltv.dangnhap
CREATE TABLE IF NOT EXISTS `dangnhap` (
  `Username` varchar(250) NOT NULL,
  `Password` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`Username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qltv.dangnhap: ~11 rows (approximately)
INSERT INTO `dangnhap` (`Username`, `Password`) VALUES
	('dat123', '11111'),
	('dat5', '11111'),
	('hoan123', '11111'),
	('hoang', '123456'),
	('hoang00', '11111'),
	('Hoang1234567', '1111111'),
	('hoannn', '11111'),
	('hoannnn', '11111'),
	('trangxuan', '123456'),
	('viet', '12345'),
	('xuantrangdo', '12345');

-- Dumping structure for table qltv.phieumuon
CREATE TABLE IF NOT EXISTS `phieumuon` (
  `maPhieu` varchar(50) NOT NULL,
  `maSV` int(11) DEFAULT NULL,
  `ngayMuon` date DEFAULT NULL,
  `maSach` int(11) DEFAULT NULL,
  `soLuong` int(11) DEFAULT NULL,
  PRIMARY KEY (`maPhieu`) USING BTREE,
  KEY `FK_phieumuon_sinhvien` (`maSV`) USING BTREE,
  KEY `FK_phieumuon_sach` (`maSach`) USING BTREE,
  CONSTRAINT `FK_phieumuon_sach` FOREIGN KEY (`maSach`) REFERENCES `sach` (`maSach`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_phieumuon_sinhvien` FOREIGN KEY (`maSV`) REFERENCES `sinhvien` (`maSV`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qltv.phieumuon: ~7 rows (approximately)
INSERT INTO `phieumuon` (`maPhieu`, `maSV`, `ngayMuon`, `maSach`, `soLuong`) VALUES
	('MP01', 1001, '2023-04-06', 101, 2),
	('MP02', 1001, '2023-04-06', 102, 1),
	('MP03', 1001, '2023-04-06', 103, 2);

-- Dumping structure for table qltv.sach
CREATE TABLE IF NOT EXISTS `sach` (
  `maSach` int(255) NOT NULL AUTO_INCREMENT,
  `tenSach` varchar(50) NOT NULL DEFAULT '',
  `tacGia` varchar(50) NOT NULL DEFAULT '',
  `theLoai` varchar(50) NOT NULL DEFAULT '',
  `namXB` int(11) NOT NULL DEFAULT 0,
  `soLuongCon` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`maSach`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10002 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qltv.sach: ~12 rows (approximately)
INSERT INTO `sach` (`maSach`, `tenSach`, `tacGia`, `theLoai`, `namXB`, `soLuongCon`) VALUES
	(101, 'Giải tích 1', 'Mai Tiến Mạnh', 'Toán Học', 2021, 6),
	(102, 'Giải tích 2', 'Dũng lại lập trình', 'Toán Cao Cấp', 2022, 2),
	(103, 'Phân tích TKTT', 'Nguyễn Duy Cương', 'Java ', 2023, 2),
	(105, 'Kĩ Thuật Lập Trình', 'Tạ Quốc Việt', 'C++', 2022, 4),
	(106, 'Nguồn Cội', 'Dan Brown', 'Tiểu thuyết', 2004, 9),
	(107, 'Xác suất thống kê', 'Trung Dũng', 'XSTK', 2006, 9),
	(108, 'Kiến trúc máy tính', 'Bùi Ngọc Dzung', 'Assembly', 2018, 16),
	(109, 'Lịch sử Đảng', 'Lê Thị Hòa', 'Chính trị ', 2023, 12),
	(111, 'Toán Rời Rạc', 'Lương Thái Lê', 'Toán Cao Cấp', 2015, 7),
	(113, 'Xác suất thống kê', 'Trung Dũng', 'XSTK', 2006, 9);

-- Dumping structure for table qltv.sinhvien
CREATE TABLE IF NOT EXISTS `sinhvien` (
  `maSV` int(11) NOT NULL,
  `hoVaTen` varchar(50) NOT NULL DEFAULT '',
  `queQuan` varchar(50) NOT NULL DEFAULT '',
  `ngaySinh` date NOT NULL,
  `lopKhoa` varchar(50) NOT NULL DEFAULT '',
  `email` varchar(50) NOT NULL DEFAULT '',
  `sDT` varchar(50) NOT NULL DEFAULT '',
  PRIMARY KEY (`maSV`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qltv.sinhvien: ~13 rows (approximately)
INSERT INTO `sinhvien` (`maSV`, `hoVaTen`, `queQuan`, `ngaySinh`, `lopKhoa`, `email`, `sDT`) VALUES
	(1001, 'Tạ Quốc Việt', 'Thái Nguyên', '2023-04-15', 'CNTT5-K62', 'viet@gmail.com', '0111111111'),
	(1002, 'Nguyễn Trung Dũng', 'Bắc Ninh', '2003-04-19', 'CNTT5-K62', 'dung@gmail.com', '0222222222'),
	(1003, 'Nguyễn Việt Hoàng', 'Phú Thọ', '2003-04-05', 'CNTT5-K62', 'hoang@gmail.com', '0333333333'),
	(1004, 'Mai Tiến Mạnh', 'Nam Định', '2002-04-12', 'CNTT5-K62', 'manh@gmail.com', '0444444444'),
	(1005, 'Nguyễn Duy Cương', 'Hà Nam', '2002-04-18', 'CNTT5-K62', 'cuong@gmail.com', '0555555555'),
	(1006, 'Bùi Đức Duy', 'Hưng Yên', '2001-04-20', 'CNTT6-K62', 'duy@gmail.com', '0666666666'),
	(1007, 'Nguyễn Thành Đạt', 'Hà Nội', '2001-04-07', 'Full Stack', 'dat@gmail.com', '0777777777'),
	(1008, 'Phạm Khánh', 'Thái Bình', '2006-04-15', 'Full Stack', 'khanh@gmail.com', '0888888888'),
	(1009, 'Đăng Tú', 'Hà Nội', '2006-04-15', 'PTIT', 'khanh@gmail.com', '0999999999'),
	(1010, 'Đỗ Xuân Kiên', 'Hưng Yên', '2005-04-21', 'AI Python', 'kien@gmail.com', '0111111110'),
	(1012, 'Đỗ Xuân Kiên', 'Hưng Yên', '2005-04-21', 'AI Python', 'kien@gmail.com', '0111111110');

-- Dumping structure for table qltv.thongtin
CREATE TABLE IF NOT EXISTS `thongtin` (
  `Ten` varchar(100) NOT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `SDT` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`Ten`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table qltv.thongtin: ~0 rows (approximately)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
