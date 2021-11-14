USE GroSys
GO 
ALTER PROC sp_LoadSanPham 
AS 
BEGIN 
	SELECT sp.MaSP, sp.TenSP, sp.MaLSP, lsp.TenLSP, ct.GiaNhap, sp.GiaBan, 
			sp.HanSuDung, sp.DonViTinh, sp.SoLuong, sp.Anh, nsx.MaNSX,nsx.TenNSX, ct.MaNPP
	FROM SanPham sp JOIN ChiTietHopDong ct ON sp.MaSP = ct.MaSP
					JOIN NhaSanXuat nsx ON ct.MaNSX = nsx.MaNSX
					JOIN LoaiSanPham lsp ON sp.MaLSP = lsp.MaLSP
					
END

GO
ALTER PROC sp_LoadSanPhamTheoID @MaSP NVARCHAR(50)
AS 
BEGIN 
	SELECT sp.MaSP, sp.TenSP, sp.MaLSP, lsp.TenLSP AS 'TenLSP', ct.GiaNhap, sp.GiaBan,
			sp.HanSuDung, sp.DonViTinh, sp.SoLuong, sp.Anh, nsx.MaNSX,nsx.TenNSX, ct.MaNPP
	FROM SanPham sp JOIN ChiTietHopDong ct ON sp.MaSP = ct.MaSP
					JOIN NhaSanXuat nsx ON ct.MaNSX = nsx.MaNSX
					JOIN LoaiSanPham lsp ON sp.MaLSP = lsp.MaLSP
					Where sp.MaSP=@MaSP
					
END
-- Thêm Nhà Phân phối khi load sản phẩm
EXEC sp_LoadSanPham

EXEC sp_LoadSanPhamTheoID 'SP02'