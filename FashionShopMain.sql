CREATE DATABASE FashionShopxxxxxxx
USE  FashionShopxxxxxxx

CREATE TABLE [CATEGORIES](
[CategoryID] INT IDENTITY (1,1) PRIMARY KEY,

[CategoryName] NVARCHAR(50) NOT NULL
)

---------------------------------------------

CREATE TABLE [PRODUCTS](
[ProductID] INT IDENTITY (1,1) PRIMARY KEY,

[ProductName] NVARCHAR(50) NOT NULL, 

[Price] MONEY CHECK (Price >0 ),

[Image] NVARCHAR(500) NOT NULL,

-- 1 for summer, 2 for winter | Shoes dosen't need season
[Season] INT CHECK( [Season] BETWEEN 1 AND 2 ),

[Description] NVARCHAR(500) NOT NULL,

--male | female
[Gender] NVARCHAR(10) NOT NULL,

[CategoryID] INT FOREIGN KEY REFERENCES [CATEGORIES](CategoryID)
)


-------------------------------------------------------------

CREATE TABLE [AGENT] (
-- HANOI DANANG SAIGON
[AgentID] INT PRIMARY KEY,

[AgentName] NVARCHAR(10)
)


CREATE TABLE [SIZE] (
[SizeID] INT PRIMARY KEY IDENTITY(1,1),

[AgentID] INT FOREIGN KEY REFERENCES [AGENT]([AgentID]),

[ProductID] INT FOREIGN KEY REFERENCES [PRODUCTS](ProductID),

[Size] NVARCHAR(20) NOT NULL,

[Quantity] INT CHECK ([QUANTITY] > 0)
)

----------------------------------------------------------------

-- TABLE TO Login
CREATE TABLE [ACCOUNT] (
[UserID] INT IDENTITY (1,1) PRIMARY KEY,

[UserName] NVARCHAR(50) NOT NULL,

[PassWord] NVARCHAR(50) NOT NULL,

[PhoneNumber] INT NOT NULL,

-- 1 for Admin, 2 for HANOI employees, 3 for DANANG employees, 4 for SAIGON emloyees, 5 for Customers, anonym is null for orders
[Role] INT,

[Email] NVARCHAR(50) NOT NULL,

[Avatar] VARCHAR(500)

UNIQUE ([UserName], [EMAIL])
)

-----------------------------------------------------------------
-- TABLE TO Stores Infor of Customer'Orders

CREATE TABLE [ORDERS] (
[OrderID] INT IDENTITY (1,1) PRIMARY KEY,

[Payment] MONEY NOT NULL CHECK ( [Payment] > 0 ),

[Address] NVARCHAR(100) NOT NULL,

[OrderDate] Date,

[ShipDate] Date,

[ReceivedDate] Date,

[Status] NVARCHAR(50) not null,
)


-------------------------------------------------------

CREATE TABLE [CART] (
[CartID] INT PRIMARY KEY IDENTITY(1,1) ,

[UserID] INT FOREIGN KEY REFERENCES [ACCOUNT](UserID),

[SizeID] INT FOREIGN KEY REFERENCES [SIZE](SizeID),

[Quantity] INT CHECK ([Quantity] > 0),

[OrderID] INT FOREIGN KEY REFERENCES [ORDERS]([OrderId])
)



CREATE TABLE REVENUE (
[RevenueId] INT IDENTITY (1,1) PRIMARY KEY,

-- Join để lấy product Id , size và quantity
[CartID] INT FOREIGN KEY REFERENCES [CART](CartID),

[Date] Date
)
----------------------------------------------------------------

CREATE TABLE WISH (
[ProductID] INT FOREIGN KEY REFERENCES [PRODUCTS](ProductID),

[UserID] INT FOREIGN KEY REFERENCES [ACCOUNT](UserID),
)

CREATE TABLE COMMENT(
[ProductID] INT FOREIGN KEY REFERENCES [PRODUCTS](ProductID),

[UserID] INT FOREIGN KEY REFERENCES [ACCOUNT](UserID),

[Content] TEXT
)


CREATE TABLE [EULA] (
	[ID]			INT IDENTITY (1, 1),
	[EULA]			NTEXT NOT NULL,
	PRIMARY KEY		([ID]),
)



----------------------------------------------------------------- INSERT --------------------------------------------


-------------------



INSERT INTO [CATEGORIES] VALUES ( N'ÁO KHOÁC')
INSERT INTO [CATEGORIES] VALUES ( N'ÁO PHÔNG')
INSERT INTO [CATEGORIES] VALUES ( N'ÁO HOODIE')
INSERT INTO [CATEGORIES] VALUES ( N'QUẦN JEAN')
INSERT INTO [CATEGORIES] VALUES ( N'QUẦN NỈ')
INSERT INTO [CATEGORIES] VALUES ( N'GIÀY')

SELECT * FROM [CATEGORIES]

INSERT INTO [PRODUCTS] VALUES ( 
N'ÁO KHOÁC GIÓ UN OVS',
300, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.05.3.02.002.222.23-10700011-bst-1_6.jpg',
1,
'Áo khoác nam đep',
'male',
1
)

INSERT INTO [PRODUCTS] VALUES ( 
'ÁO KHOÁC NỈ NAM',
250, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.05.2.02.002.220.01-10200011-bst-1.jpg',
2,
'Áo khoác nỉ cho nam đep',
'male',
3
)	

INSERT INTO [PRODUCTS] VALUES ( 
'ÁO PHÔNG NỮ CÁ TINH',
200, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.02.3.18.003.122.23-10600017-bst-1.jpg',
1,
'Áo phông nữ siêu xinh',
'female',
2
)	


INSERT INTO [PRODUCTS] VALUES ( 
N'QUẦN JEAN NAM ĐẸP SANG',
250, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.21.2.02.001.122.23-60600015-bst-1.jpg',
1,
'Quần jean nam nhìn khá bụi bặm',
'male',
4
)	


INSERT INTO [PRODUCTS] VALUES ( 
N'QUẦN NỈ NỮ ĐANG IU',
300, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.11.3.02.007.222.23-11200011-bst-1.jpg',
1,
'Quần nỉ cho các bạn nữ xinh gái',
'female',
5
)	



INSERT INTO [PRODUCTS] VALUES ( 
N'GIÀY NỮ CỰC XINH',
400, 
'https://static.nike.com/a/images/c_limit,w_592,f_auto/t_product_v1/ddf629be-8bfd-457a-868c-1e579a637f7f/pegasus-turbo-next-nature-road-running-shoes-f3Q3zZ.png',
NULL,
'Giày nữ siêu cá tính',
'female',
6
)

INSERT INTO [PRODUCTS] VALUES ( 
N'ÁO KHOÁC KHAKI SPEEDUP',
700, 
'https://cdn2.boo.vn/media/catalog/product/cache/a3c240e3377445b2b4921e41d3348417/1/_/1.2.08.2.18.001.222.23-11500104-bst-1.jpg',
1,
'ÁO KHOÁC NAM ĐUA XE',
'male',
1
)


INSERT INTO [PRODUCTS] VALUES ( 
N'ÁO KHOÁC PARKA UN ĐÍNH PATCH',
700, 
'https://cdn2.boo.vn/media/catalog/product/1/_/1.2.08.3.06.012.222.23-10200011-bst-1.jpg',
2,
'ÁO KHOÁC PHAO ĐEN XÌ',
'male',
1
)

INSERT INTO [PRODUCTS] VALUES ( 
N'ÁO KHOÁC GIÓ UN VARSITY',
700, 
'https://cdn2.boo.vn/media/catalog/product/1/_/1.2.08.3.02.015.222.23-10200011-n-5.jpg',
1,
'ÁO KHOÁC CON THỎ',
'male',
1
)

INSERT INTO [PRODUCTS] VALUES ( 
N'ÁO KHOÁC PARKA LÔNG VŨ ',
700, 
'https://cdn2.boo.vn/media/catalog/product/1/_/1.0.08.2.02.001.221.23-10300011-bst-1.jpg',
2,
'ÁO KHOÁC PHAO MÀU NÂU TO BỰ',
'male',
1
)



INSERT INTO [PRODUCTS] VALUES ( 
N'QUẦN DÀI NỮ FLARE THÊU',
400, 
'https://cdn2.boo.vn/media/catalog/product/1/_/1.2.11.1.02.003.222.23-10200011-bst-1.jpg',
1,
'QUẦN NỈ NỮ ĐANG IU MÀU NÂU VÔ CÙNG BỤI BẶM',
'female',
5
)	


SELECT * FROM [PRODUCTS]

SELECT * FROM AGENT
INSERT INTO [AGENT] VALUES(
1, 'HANOI'
)

INSERT INTO  [AGENT] VALUES (
2, 'DANANG'
)

INSERT INTO  [AGENT] VALUES (
3, 'SAIGON'
)

SELECT * FROM PRODUCTS



          ---  AGENT, PRODUCT, SIZE, QUANTITY
INSERT INTO [SIZE] VALUES(1,1, 'S', 20)
INSERT INTO [SIZE] VALUES(1,1, 'M', 20)
INSERT INTO [SIZE] VALUES(1,1, 'L', 20)


INSERT INTO [SIZE] VALUES(2,1, 'S', 15)
INSERT INTO [SIZE] VALUES(2,3, 'S', 26)
INSERT INTO [SIZE] VALUES(2,5, 'S', 10)


INSERT INTO [SIZE] VALUES(3,4, 'M', 21)
INSERT INTO [SIZE] VALUES(3,2, 'L', 10)
INSERT INTO [SIZE] VALUES(3,6, '42', 20)

INSERT INTO [SIZE] VALUES(1,7, 'M', 40)
INSERT INTO [SIZE] VALUES(1,7, 'S', 40)
INSERT INTO [SIZE] VALUES(1,7, 'L', 40)

INSERT INTO [SIZE] VALUES(2,7, 'M', 40)
INSERT INTO [SIZE] VALUES(2,7, 'S', 40)
INSERT INTO [SIZE] VALUES(2,7, 'L', 40)

INSERT INTO [SIZE] VALUES(1,8, 'M', 40)
INSERT INTO [SIZE] VALUES(1,8, 'S', 40)
INSERT INTO [SIZE] VALUES(1,8, 'L', 40)

INSERT INTO [SIZE] VALUES(1,9, 'M', 40)
INSERT INTO [SIZE] VALUES(1,9, 'S', 40)
INSERT INTO [SIZE] VALUES(1,9, 'L', 40)

INSERT INTO [SIZE] VALUES(1,10, 'M', 40)
INSERT INTO [SIZE] VALUES(1,10, 'S', 40)
INSERT INTO [SIZE] VALUES(1,10, 'L', 40)

INSERT INTO [SIZE] VALUES(1,11, 'M', 40)
INSERT INTO [SIZE] VALUES(1,11, 'S', 40)
INSERT INTO [SIZE] VALUES(1,11, 'L', 40)

INSERT INTO [SIZE] VALUES(2,11, 'M', 40)
INSERT INTO [SIZE] VALUES(2,11, 'S', 40)
INSERT INTO [SIZE] VALUES(2,11, 'L', 40)

INSERT INTO [SIZE] VALUES(3,11, 'M', 40)
INSERT INTO [SIZE] VALUES(3,11, 'S', 40)
INSERT INTO [SIZE] VALUES(3,11, 'L', 40)



SELECT * FROM [ACCOUNT]


INSERT INTO [ACCOUNT] VALUES(
'ADMIN', 'NguyenThienThang2002', 0123456789, 1, 'nguyenthienthang@gmail.com', NULL
)

INSERT INTO [ACCOUNT] VALUES(
'TRONG', '	', 0123456781, 2, 'nguyenhuutrong@gmail.com', NULL)

INSERT INTO [ACCOUNT] VALUES(
'KHOA', 'nguyendangkhoa2002', 0123456782, 3, 'nguyendangkhoa@gmail.com', NULL
)

INSERT INTO [ACCOUNT] VALUES(
'HUNG', 'hoangphihung2002', 0123456783, 4, 'hoangphihung@gmail.com', NULL
)

INSERT INTO [ACCOUNT] VALUES(	
'QUANG', 'quangnguyen2002', 0123456784, 5, 'khoanguyen@gmail.com', NULL
)

DELETE FROM [ACCOUNT] WHERE ROLE = 5

SELECT * FROM [ACCOUNT]



SELECT *FROM CART

INSERT INTO [CART]  VALUES (
 2, 1, 3, 'S', 0, null
)

SELECT  * FROM [CART]

  ------ In process  ->   Delivered   ->   Closed

  --Insert mm-dd-yyyy
INSERT INTO [ORDERS] VALUES (
1, 2, 900, 'Mai Son - Son La', '1-12-2023', '1-13-2023', '1-15-2023',  'In Process'
)



 

UPDATE [CART] SET OrderID = 1 WHERE CartID = 1






SELECT * FROM REVENUE

INSERT INTO [REVENUE] VALUES (
1, 1, 3, 'S', 1, '1-12-2023'
)

-------------


SELECT * FROM [ACCOUNT] WHERE UserName = 'admin' AND PassWord = 'NguyenThienThang2002'

Select * from [PRODUCTS]

SELECT [CategoryName] FROM [CATEGORIES]

INSERT INTO [CATEGORIES] ([CategoryName]) VALUES ( 
 'QUẦN NỈ XỊN HƠN NỮA' 
)

DELETE FROM CATEGORIES WHERE CategoryID = 6

SELECT * FROM PRODUCTS


SELECT TOP(4) * FROM PRODUCTS ORDER BY CategoryID DESC



SELECT P.ProductID, P.ProductName, P.Price, P.Season, P.Description, P.Gender, P.CategoryID, S.Quantity, S.Size, A.AgentID
FROM [PRODUCTS] P INNER JOIN [SIZE] S  on P.ProductID = S.ProductID INNER JOIN [AGENT] A  ON A.AgentID = S.AgentID

SELECT * FROM [PRODUCTS] WHERE Season = 1 AND Gender = 'female' Order By Price DESC
 
 SELECT * FROM [PRODUCTS] WHERE Season = 1 Order By Price desc

SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size
FROM [PRODUCTS] P INNER JOIN [SIZE] S 
ON P.ProductID = S.ProductID 
WHERE P.Gender ='female' ORDER BY P.Price DESC

SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size
FROM [PRODUCTS] P INNER JOIN [SIZE] S 
ON P.ProductID = S.ProductID 
WHERE P.Gender = 'male' AND S.Size = 's'

SELECT * FROM [SIZE]

SELECT * FROM [PRODUCTS] WHERE Season = 1 AND CategoryId = 1

SELECT * FROM [PRODUCTS] WHERE Season = 1 AND Gender = 'male' AND CategoryId = 1

SELECT * FROM [PRODUCTS] WHERE ProductId = 1


	
SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size
FROM [PRODUCTS] P INNER JOIN [SIZE] S 
ON P.ProductID = S.ProductID 
WHERE P.Season = 1 AND S.Size = 'S' AND P.Gender = 'male' ORDER BY P.Price 



SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size
FROM [PRODUCTS] P INNER JOIN [SIZE] S 
ON P.ProductID = S.ProductID 
WHERE P.Season = 1 AND P.Gender ='female' AND S.Size = 'S' ORDER BY P.Price DESC



INSERT INTO [CART] ([CartID] ,[UserID],[ProductId], [Quantity] ,[Size], [AgentId] ,[OrderId]) VALUES (?,?,?,?,?,?,?)

select * from ACCOUNT

select * from PRODUCTS

SELECT * FROM [Cart]

UPDATE [PRODUCTS] SET Season = 2 WHERE ProductID =  8







select p.[ProductID],[ProductName], 
                     [Price], [Image], [Season], 
                     [Description], [Gender], 
                     c.[CategoryID], c.CategoryName 
                     from [PRODUCTS] p inner join CATEGORIES c 
                     on p.CategoryID= c.CategoryID
                    where p.ProductID=1;

					select * from size

					SELECT SizeID ,Quantity  from CART WHERE AgentID = 1 AND ProductID = 1 And Size = 'm'


					select * from SIZE where ProductID = 1 and [AgentID] = 1 