USE [ProductManagement]
GO
/****** Object:  Table [dbo].[tblProducts]    Script Date: 10/23/2021 6:01:22 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblProducts](
	[productID] [char](5) NOT NULL,
	[name] [varchar](50) NULL,
	[description] [varchar](500) NULL,
	[price] [float] NULL,
	[cpu] [float] NULL,
	[status] [bit] NULL,
	[createDate] [date] NULL,
	[updateDate] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[productID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[tblProducts] ([productID], [name], [description], [price], [cpu], [status], [createDate], [updateDate]) VALUES (N'1    ', N'may tinh ', N'cuc ngon va xin', 12, 1, 1, CAST(N'2021-10-23' AS Date), CAST(N'2021-10-31' AS Date))
