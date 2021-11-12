USE GroSys
GO

-- report SanPham
-- Nhằm load sản phẩm hiển thị lên bảng giao dịch
CREATE PROC sp_LoadSanPham 
AS 
BEGIN 
	SELECT sp.MaSP, sp.TenSP, sp.MaLSP, lsp.TenLSP, sp.GiaBan,
			sp.HanSuDung, sp.DonViTinh, sp.SoLuong, sp.Anh, nsx.MaNSX,nsx.TenNSX
	FROM SanPham sp JOIN ChiTietHopDong ct ON sp.MaSP = ct.MaSP
					JOIN NhaSanXuat nsx ON ct.MaNSX = nsx.MaNSX
					JOIN LoaiSanPham lsp ON sp.MaLSP = lsp.MaLSP
					
END

GO
-- ADD SanPham
-- Thêm sản phẩm mới: Phải thêm sản phẩm vào hợp đồng rồi mới thêm vào sản phẩm

CREATE PROC sp_Them_SanPham @MaNPP NVARCHAR(50), @MaNSX NVARCHAR(50), @MaSP NVARCHAR(50), @TenSP NVARCHAR(50), @GiaNhap FLOAT,
							@MaLSP NVARCHAR(50), @GiaBan FLOAT, @HanSuDung DATE, @DonViTInh NVARCHAR(20), @SoLuong INT, @Anh NVARCHAR(50)
AS
BEGIN 
	BEGIN TRY
		BEGIN TRAN 
			INSERT INTO ChiTietHopDong VALUES (@MaNPP, @MaSP, @MaNSX, @TenSP, CONVERT(DATE, GETDATE()), @GiaNhap)

			INSERT INTO SanPham VALUES (@MaSP, @TenSP, @MaLSP, @GiaBan, @HanSuDung, @DonViTInh, @SoLuong, @Anh)
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		RAISERROR (N'không được cập nhật được',16,1)
		ROLLBACK TRAN
	END CATCH
END
GO
EXEC sp_Them_SanPham  'NPP01', 'NSS01', 'SP11', N'VIM nước rửa bồn cầu', 9, 'LSP07', 100, '2021-11-20' ,N'Chai', 50, NULL

-- Giao dich
-- Cập nhật lại số lượng sản phẩm sau kho giao dịch
GO
CREATE PROC sp_GiaoDich @MaSP NVARCHAR(50), @SoLuong INT
AS
BEGIN 
	DECLARE @SoLuongHienTai INT
	SELECT @SoLuongHienTai = SoLuong FROM SanPham WHERE MaSP = @MaSP
	UPDATE SanPham SET SoLuong = @SoLuongHienTai - @SoLuong WHERE MaSP = @MaSP
	
END
GO
EXEC sp_GiaoDich 'SP01', 1

-- Trung
-- Xóa Sản phẩm + xóa Chitiethopdong
CREATE PROC sp_Xoa_SanPham  @MaSP NVARCHAR(50)
							
AS
BEGIN 
	BEGIN TRY
		BEGIN TRAN 
			DELETE FROM SanPham 
			Where MaSP=@MaSP
			DELETE FROM ChiTietHopDong 
			Where MaSP=@MaSP
		COMMIT TRAN
	END TRY
	BEGIN CATCH
		RAISERROR (N'không thể xóa được',16,1)
		ROLLBACK TRAN
	END CATCH
END
GO
EXEC sp_Xoa_SanPham 'SP11'
-- Chọn theo mã 
-- cập nhật lại select BY sql gồm : sp.MaSP, sp.TenSP, sp.MaLSP, lsp.TenLSP, sp.GiaBan, sp.HanSuDung, sp.DonViTinh, sp.SoLuong, sp.Anh, nsx.MaNSX,nsx.TenNSX
CREATE PROC sp_LoadSanPhamTheoID @MaSP NVARCHAR(50)
AS 
BEGIN 
	SELECT sp.MaSP, sp.TenSP, sp.MaLSP, lsp.TenLSP, sp.GiaBan,
			sp.HanSuDung, sp.DonViTinh, sp.SoLuong, sp.Anh, nsx.MaNSX,nsx.TenNSX
	FROM SanPham sp JOIN ChiTietHopDong ct ON sp.MaSP = ct.MaSP
					JOIN NhaSanXuat nsx ON ct.MaNSX = nsx.MaNSX
					JOIN LoaiSanPham lsp ON sp.MaLSP = lsp.MaLSP
					Where sp.MaSP=@MaSP
					
END

GO

EXEC sp_LoadSanPhamTheoID 'SP09'
-- Nguyên
-- thêm chitietHoadon, Phieugiamgia, hoivien
