/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Util;

/**
 *
 * @author ASUS
 */
public interface SqlQuery {

    interface account {

        public static final String login = "SELECT * FROM [ACCOUNT] WHERE UserName = ? AND PassWord = ?";

        public static final String signUp = "INSERT INTO [ACCOUNT] VALUES(?,?,?,?,?)";

        public static final String getAddressByUserId = "SELECT P.Address FROM [ACCOUNT] A WHERE A.UserId = ?";
    }

    interface category {

//        public static final String getAllCategoryName = "SELECT [CategoryName] FROM [CATEGORIES]";
        public static final String getAllCategory = "SELECT * FROM [CATEGORIES]";

        public static final String getCategoryByCategoryId = "SELECT * FROM [CATEGORIES] WHERE [CategoryId] = ?";
    }

    interface product {

        public static final String getNewProducts = "select top(4) p.ProductID, p. ProductName, p.Price, p.[Image], p.Season, p.[Description], p.Gender, c.CategoryID, c.CategoryName from PRODUCTS p inner join CATEGORIES c \n"
                + "on p.CategoryID= c.CategoryID\n"
                + "Order by ProductID desc";

        public static final String getProductByCategoryId = "SELECT * FROM [PRODUCTS] WHERE [CategoryID] = ?";

        public static final String getProductByProductId = "SELECT * FROM [PRODUCTS] WHERE [ProductId] = ?";

        public static final String getListProductBySeason = "SELECT * FROM [PRODUCTS] WHERE Season = ? AND CategoryId = ?";

        //public static final String getListProductBySeasonAndPrice = " SELECT * FROM [PRODUCTS] WHERE Season = ?  Order By Price  ?  ";
        public static final String getListProductBySeasoonAndGender = "SELECT * FROM [PRODUCTS] WHERE Season = ? AND Gender = ? AND CategoryId = ?";

        public static final String getListProductBySeasoonAndSize = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE P.Season = ? AND S.Size = ?";

        public static final String getLitProductBySeasonAndPriceAndGender = "SELECT * FROM [PRODUCTS] WHERE Season = ? AND Gender = ? ORDER BY Price ?";

        public static final String getListProductBySeasonAndGenderAndSize = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE P.Season = ? AND S.Size = ? AND P.Gender = ? ORDER BY P.Price ";

        public static final String getListProductByPrice = "SELECT * FROM [PRODUCTS] ORDER BY Price (?)";

        public static final String getListProductByGender = "SELECT * FROM [PRODUCTS] WHERE Gender = ? AND CategoryId = ?";

        public static final String getListProductByGenderAndSize = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE P.Gender = ? AND S.Size = ? AND P.CategoryId = ? ";

        public static final String getListProductBySize = " SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE S.Size = ? AND P.CategoryId = ? ";

        public static final String insertProduct = "Insert into [PRODUCTS]([ProductName], "
                + "[Price], "
                + "[Image], "
                + "[Season], "
                + "[Description], ["
                + "Gender], "
                + "[CategoryID]) "
                + "values (?,?,?,?,?,?,?)";

        public static final String insertSize = "Insert into SIZE ([AgentID], "
                + "[ProductID], "
                + "[Quantity], "
                + "[Size]) values "
                + "(?, ?, ?, ?)";

        public static final String upDateProduct = "Update [PRODUCTS] "
                + "set [ProductName]=?, \n"
                + "[Price]=?, \n"
                + "[Image]=?, \n"
                + "[Season]=?, \n"
                + "[Description]=?, \n"
                + "[Gender]=?, \n"
                + "[CategoryID]=?\n"
                + "where [ProductID]= ?";

        public static final String updateSize = "Update [SIZE] set [Quantity]= ?,\n"
                + "[Size]=?\n"
                + "where ProductID =?";

        public static final String deleteProduct = "Delete [SIZE] where ProductID=?\n"
                + "Delete [PRODUCTS] \n"
                + "where ProductID=?";

        public static final String getMaxProductId = "SELECT TOP(1) p.[ProductID],p.[ProductName], p.[Price], p.[Image], p.[Season], p.[Description], p.[Gender], c.[CategoryID], c.CategoryName\n"
                + "from PRODUCTS p inner join CATEGORIES c on p.CategoryID= c.CategoryID \n"
                + "order by ProductID desc";

        public static final String getProductByAgentId = "select p.ProductID, p.ProductName, p.Price, p.[Image], p.Season, p.[Description], p.Gender, c.CategoryID, c.CategoryName, \n"
                + "a.AgentID, a.AgentName, s.Size, s.Quantity from PRODUCTS p \n"
                + "IN [CATEGORIES] c on p.CategoryID= c.CategoryID\n"
                + "INNER JOIN [SIZE] s on p.ProductID= s.ProductID\n"
                + "IN [AGENT] a on s.AgentID= a.AgentID\n"
                + "AgentID=?";

        public static final String getProductAndCategoryName = "select p.[ProductID],[ProductName], "
                + "[Price], [Image], [Season], "
                + "[Description], [Gender], "
                + "c.[CategoryID], c.CategoryName "
                + "from [PRODUCTS] p inner join CATEGORIES c "
                + "on p.CategoryID= c.CategoryID\n"
                + "where p.ProductID=?";
    }

    interface size {

        public static final String getSizeOfProductsByCategoryId = "SELECT DISTINCT P.CategoryID, S.Size FROM [PRODUCTS] P INNER JOIN [SIZE] S ON P.ProductID = S.ProductID WHERE P.CategoryID = ?";

        public static final String getSizeId = " SELECT [SizeId]  FROM [SIZE] WHERE ProductID = ? AND AgentID = ? AND SIZE = ?";

        public static final String minusNumberProductByCartId = "UPDATE [SIZE] SET Quantity = Quantity-(SELECT Quantity FROM [CART] WHERE CartID = ?) WHERE [SizeID] = (SELECT C.SizeID FROM [CART] C INNER JOIN [SIZE] S \n"
                + "ON C.SizeID =S.SizeID\n"
                + "WHERE C.CartID = ?)";

        }
        interface cart {

            public static final String addToCart = "INSERT INTO [CART] ([UserID], [SizeID], [Quantity], [OrderId]) \n"
                    + "VALUES ( ?, ?, ?, ?)";

            public static final String viewCart = "SELECT C.UserID, S.ProductID, P.ProductName, S.Size, P.Price, P.Image ,S.AgentID, C.Quantity, C.CartId\n"
                    + "FROM [CART] C INNER JOIN [SIZE] S ON C.SizeId = S.SizeId\n"
                    + "INNER JOIN [PRODUCTS] P ON S.ProductId = P.ProductId\n"
                    + "WHERE C.UserID = ? AND C.OrderID IS NULL";

            public static final String getCartByCartId = "SELECT C.UserID, S.ProductID, P.ProductName, S.Size, P.Price, P.Image ,S.AgentID, C.Quantity, C.CartId\n"
                    + "FROM [CART] C INNER JOIN [SIZE] S ON C.SizeId = S.SizeId INNER JOIN [PRODUCTS] P ON S.ProductId = P.ProductId\n"
                    + "WHERE  C.CartID = ?";

            public static final String updateOrderIdForCart = "UPDATE [CART] SET OrderID = ? WHERE CartID =?";

        }

        interface order {

            public static String insertOder = "INSERT INTO [ORDERS] (Payment, Address, OrderDate, Status)\n"
                    + "VALUES (?,?,GETDATE(), ?)";

            public static String getMaxOrderId = "SELECT TOP(1) OrderID FROM [ORDERS] ORDER BY OrderID DESC";
        }

}