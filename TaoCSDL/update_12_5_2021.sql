USE GroSys

-- Thống kê doanh thu Theo từng Tháng
GO
CREATE PROC sp_doanhThuTheoThang 
AS BEGIN 
	SELECT SUM(SoTien) AS SoTien, MONTH(NgayLHD) AS Thang
	FROM HoaDon 
	WHERE YEAR(NgayLHD) = YEAR(GETDATE())
	GROUP BY MONTH(NgayLHD) 
END
EXEC sp_doanhThuTheoThang
-- THống kê số vốn bỏ ra theo từng tháng
GO
CREATE PROC sp_vonBoRaTheoThang
AS BEGIN
	SELECT SUM(GiaNhap) AS GiaNhap, MONTH(NgayNhap) AS Thang
	FROM ChiTietHopDong
	WHERE YEAR(NgayNhap) = YEAR(GETDATE())
	GROUP BY MONTH(NgayNhap) 
END
EXEC sp_vonBoRaTheoThang
-- Thống kê 3 sản phẩm có doanh thu cao nhất

GO 
CREATE PROC sp_topDoanhThu
AS 
BEGIN
	SELECT TOP 3 SUM(SanPham.GiaBan *HoaDonChiTiet.SoLuong) AS DoanhThu, SanPham.MaSP
	FROM SanPham JOIN HoaDonChiTiet ON SanPham.MaSP = HoaDonChiTiet.MaSanPham
	GROUP BY SanPham.MaSP
	ORDER BY DoanhThu DESC
END

EXEC sp_topDoanhThu

-- Thống kê doanh thu theo từng sản phẩm

GO 
CREATE PROC sp_doanhThuTheoTungSP
AS 
BEGIN
	SELECT SUM(SanPham.GiaBan *HoaDonChiTiet.SoLuong) AS DoanhThu, SanPham.MaSP
	FROM SanPham JOIN HoaDonChiTiet ON SanPham.MaSP = HoaDonChiTiet.MaSanPham
	GROUP BY SanPham.MaSP
END
EXEC sp_doanhThuTheoTungSP
-- Lấy Tổng Doanh Thu
SELECT SUM(Sotien) AS TongDoanhThu
FROM HoaDon



-- Lấy Tổng Số vốn
SELECT SUM(GiaNhap) AS GiaNhap FROM ChiTietHopDong

-- Lấy tổng số sản phẩm được mua 
SELECT SUM(SoLuong) AS SanPham FROM HoaDonChiTiet 

-- Lất Tổng số Lượt mua
SELECT COUNT(*) AS TongSoLuotMua FROM HoaDon

-- Thống kê doanh thu theo tháng nhập vào\
GO
CREATE PROC sp_doanhThuTheoThangNV @thang INT 
AS 
BEGIN 
	SELECT SUM(SoTien) AS DoanhThu
	FROM HoaDon
	WHERE MONTH(NgayLHD) = @thang AND YEAR(NgayLHD) = YEAR(GETDATE())
END 

EXEC sp_doanhThuTheoThangNV 11

-- Thống Kê số lượt mua theo tháng
GO
CREATE PROC sp_SoLuotMuaTheoThang @thang INT
AS
BEGIN 
	SELECT COUNT(MaHD) AS SoLuotMua
	FROM HoaDon
	WHERE MONTH(NgayLHD) = @thang AND YEAR(NgayLHD) = YEAR(GetDATE())
	GROUP BY MONTH(NgayLHD) 
END 
EXEC sp_SoLuotMuaTheoThang 1

-- Thống kê Chi tiêu theo tháng

GO
CREATE PROC sp_ChiTieuTheoThang @Thang INT
AS
BEGIN 
	SELECT SUM(GiaNhap) AS GiaNhap
	FROM ChiTietHopDong
	WHERE YEAR(NgayNhap) = YEAR(GETDATE()) AND MONTH(NgayNhap) = @Thang
	GROUP BY MONTH(NgayNhap)
END

INSERT INTO LoaiSanPham 
VALUES ('LSP08', N'Đồ Công Nghệ', '')
-- Thống kê doanh thu theo từng loại sản phẩm
GO
CREATE PROC sp_thongKeDoanhThuTheoLSP @MaLSP NVARCHAR(50)
AS
BEGIN 
	SELECT SUM(sp.GiaBan*hdct.SoLuong) AS ThongKe, lsp.MaLSP
	FROM LoaiSanPham lsp JOIN SanPham sp ON lsp.MaLSP = sp.MaLSP
						 JOIN HoaDonChiTiet hdct ON sp.MaSP = hdct.MaSanPham 
	WHERE lsp.MaLSP = @MalSP
	GROUP BY lsp.MaLSP
END

EXEC sp_thongKeDoanhThuTheoLSP 'LSP08'

SELECT SanPham.MaSP, SUM(HoaDonChiTiet.SoLuong*SanPham.GiaBan) AS DoanhThu, SUM(HoaDonChiTiet.SoLuong) AS DoanhSo
FROM SanPham JOIN HoaDonChiTiet ON SanPham.MaSP = HoaDonChiTiet.MaSanPham
GROUP By SanPham.MaSP
SELECT (HoaDonChiTiet.SoLuong*SanPham.GiaBan) AS DoanhSo, SUM(HoaDonChiTiet.SoLuong) AS DoanhThu
FROM SanPham JOIN HoaDonChiTiet ON SanPham.MaSP = HoaDonChiTiet.MaSanPham

EXEC sp_topDoanhThu










