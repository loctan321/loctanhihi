USE [QLSVien]
GO
/****** Object:  Table [dbo].[SinhVien]    Script Date: 3/15/2022 12:01:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SinhVien](
	[MaSV] [nvarchar](50) NOT NULL,
	[HoSV] [nvarchar](50) NULL,
	[TenSV] [nvarchar](50) NULL,
	[NgaySinh] [date] NULL,
	[GioiTinh] [nvarchar](10) NULL,
	[MaKhoa] [nvarchar](50) NULL,
 CONSTRAINT [PK_SinhVien] PRIMARY KEY CLUSTERED 
(
	[MaSV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[SinhVien] ([MaSV], [HoSV], [TenSV], [NgaySinh], [GioiTinh], [MaKhoa]) VALUES (N'dsd', N'thay doi ten', N'ds', CAST(N'2022-03-15' AS Date), N'Nam', N'dsds')
INSERT [dbo].[SinhVien] ([MaSV], [HoSV], [TenSV], [NgaySinh], [GioiTinh], [MaKhoa]) VALUES (N'sdds', N'ds', N'ds', CAST(N'2022-03-15' AS Date), N'Nam', N'dsds')
GO
