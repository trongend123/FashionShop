/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Context.*;
import Model.*;
import Util.SqlQuery;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ProductDao extends MyDao implements SqlQuery {

    //  to get new product
    public List<Product> getNewProdcuts() {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getNewProducts);
            rs = ps.executeQuery();
            Product product = null;
            int count = 0;
            // get 4 latest products
            while (rs.next() && count < 4) {
                product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getProductByCategoryId(int categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getProductByCategoryId);
            ps.setInt(1, categoryId);
            rs = ps.executeQuery();
//             product = null;
            //get all product by categoryId
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Product getProductByProductId(int productId) {
        Product product = new Product();
        try {
            ps = con.prepareStatement(SqlQuery.product.getProductByProductId);
            ps.setInt(1, productId);
            rs = ps.executeQuery();
            // get product by id
            if (rs.next()) {
                return product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    // get List Product by Season
    public List<Product> getListProductBySeason(String season, int categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductBySeason);
            ps.setString(1, season);
            ps.setInt(2, categoryId);
            rs = ps.executeQuery();

            //get all product by season
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Season And Price
    public List<Product> getListProductBySeasonAndPrice(String season, String priceOd, int categoryId) {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM [PRODUCTS] WHERE Season=" + season + " AND CategoryId = " + categoryId + " ORDER BY Price " + priceOd;
        try {
            //   ps = con.prepareStatement(SqlQuery.product.getListProductBySeasonAndPrice);
            ps = con.prepareStatement(sql);
//            ps.setString(1, season);
//            ps.setString(2, priceOd);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Season And Gender
    public List<Product> getListProductBySeasonAndGender(String season, String gender, int catergoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductBySeasoonAndGender);
            ps.setString(1, season);
            ps.setString(2, gender);
            ps.setInt(3, catergoryId);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Season And Gender
    public List<Product> getListProductBySeasonAndSize(String season, String size, int catergoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductBySeasoonAndSize);
            ps.setString(1, season);
            ps.setString(2, size);
            ps.setInt(3, catergoryId);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Season And Gender
    public List<Product> getListProductBySeasonAndPriceAndGender(String season, String gender, String price, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sqlx = "SELECT * FROM [PRODUCTS] WHERE Season = " + season + " AND Gender = '" + gender + "' AND CategoryId = " + categoryId + " Order By Price " + price;
        try {
            //   ps = con.prepareStatement(SqlQuery.product.getLitProductBySeasonAndPriceAndGender);
            ps = con.prepareStatement(sqlx);
            // ps.setString(1, season); 
            // ps.setString(2, gender);
            // ps.setString(3, price);
            rs = ps.executeQuery();

            //get all product by season And Price And gender
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Season And Gender And Size
    public List<Product> getListProductBySeasonAndAndGenderAndSize(String season, String gender, String size, int categoryId) {
        List<Product> list = new ArrayList<>();
        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductBySeasonAndGenderAndSize);
            //  ps = con.prepareStatement(sqlx);
            ps.setString(1, season);
            ps.setString(2, size);
            ps.setString(3, gender);
            rs = ps.executeQuery();

            //get all product by season And Price And gender
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Price ( DESC OR ASC  )
    public List<Product> getListProductByPrice(String price, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM [PRODUCTS] WHERE CategoryID = " + categoryId + " ORDER BY Price " + price;
        try {
            ps = con.prepareStatement(sql);
//            ps = con.prepareStatement(SqlQuery.product.getListProductByPrice);
//            ps.setString(1, price);
            rs = ps.executeQuery();

            //get all product by Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Price And Gender ( DESC OR ASC )
    public List<Product> getListProductByPriceAndGender(String gender, String price, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT * FROM [PRODUCTS]  WHERE Gender = '" + gender + "' AND CategoryId = " + categoryId + "  ORDER BY Price " + price;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //get all product by Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Price And size ( DESC OR ASC )
    public List<Product> getListProductByPriceAndSize(String size, String price, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE S.Size = '" + size + "' AND P.CategoryId = " + categoryId + " ORDER BY P.Price " + price;

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            //get all product by Price and size
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListProductByPriceAndGenderAndSize(String price, String gender, String size, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE P.Gender ='" + gender + "' AND S.Size = '" + size + "' AND P.CategoryId = " + categoryId + " ORDER BY P.Price " + price;

        try {
            ps = con.prepareStatement(sql);
            //   ps = con.prepareStatement(SqlQuery.product.getListProductByGenderAndSize);
//            ps.setString(1, gender);
//            ps.setString(2, size);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List  Gender
    public List<Product> getListProductByGender(String gender, int categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductByGender);
            ps.setString(1, gender);
            ps.setInt(2, categoryId);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Gender and size 
    public List<Product> getListProductByGenderAndSize(String gender, String size, int categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductByGenderAndSize);
            ps.setString(1, gender);
            ps.setString(2, size);
            ps.setInt(3, categoryId);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //get List by Gender and size 
    public List<Product> getListProductBySize(String size, int categoryId) {
        List<Product> list = new ArrayList<>();

        try {
            ps = con.prepareStatement(SqlQuery.product.getListProductBySize);
            ps.setString(1, size);
            ps.setInt(2, categoryId);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // get List product by All filter
    public List<Product> getListProductByALlFilter(String season, String price, String gender, String size, int categoryId) {
        List<Product> list = new ArrayList<>();

        String sql = "SELECT DISTINCT P.ProductID, P.ProductName, P.Price, P.Image, P.Season, P.Description, P.Gender, P.CategoryID, S.Size\n"
                + "FROM [PRODUCTS] P INNER JOIN [SIZE] S \n"
                + "ON P.ProductID = S.ProductID \n"
                + "WHERE P.Season = '" + season + "' AND P.Gender ='" + gender + "' AND S.Size = '" + size + "' AND P.CategoryId = " + categoryId + " ORDER BY P.Price " + price;

        try {
            ps = con.prepareStatement(sql);
            //   ps = con.prepareStatement(SqlQuery.product.getListProductByGenderAndSize);
//            ps.setString(1, gender);
//            ps.setString(2, size);
            rs = ps.executeQuery();

            //get all product by season And Price
            while (rs.next()) {
                Product product = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Product> getListByFilter(String season, String price, String gender, String size, int categoryId) {
        List<Product> listProduct = new ArrayList<>();

        String empty = "empty";

        //   chỉ lọc theo seson
        if (season.equals(empty) == false && price.equals(empty) == true && gender.equals(empty) == true && size.equals(empty) == true) {
            listProduct = getListProductBySeason(season, categoryId);
            return listProduct;
        } else if // lọc theo season và price
                (season.equals(empty) == false && price.equals(empty) == false && gender.equals(empty) == true && size.equals(empty) == true) {
            listProduct = getListProductBySeasonAndPrice(season, price, categoryId);
            return listProduct;
        } else if // lọc theo season and size 
                (season.equals(empty) == false && price.equals(empty) == true && gender.endsWith(empty) == true && size.equals(empty) == false) {
            listProduct = getListProductBySeasonAndSize(season, gender, categoryId);
            return listProduct;
            // lọc theo season và gender
        } else if (season.equals(empty) == false && price.equals(empty) == true && gender.equals(empty) == false && size.equals(empty) == true) {
            listProduct = getListProductBySeasonAndGender(season, gender, categoryId);
            return listProduct;
        } else if // lọc theo season và price và gender
                (season.equals(empty) == false && price.equals(empty) == false && gender.equals(empty) == false && size.equals(empty) == true) {
            listProduct = getListProductBySeasonAndPriceAndGender(season, gender, price, categoryId);
            return listProduct;

        } else if // loc theo season và gender và size 
                (season.equals(empty) == false && price.equals(empty) == true && gender.equals(empty) == false && size.equals(empty) == false) {
            listProduct = getListProductBySeasonAndAndGenderAndSize(season, gender, size, categoryId);
            return listProduct;
        } else if// chỉ lọc theo price
                (season.equals(empty) == true && price.equals(empty) == false && gender.equals(empty) == true && size.equals(empty) == true) {
            listProduct = getListProductByPrice(price, categoryId);
            return listProduct;
        } else if // lọc theo price và gender
                (season.equals(empty) == true && price.equals(empty) == false && gender.equals(empty) == false && size.equals(empty) == true) {
            listProduct = getListProductByPriceAndGender(gender, price, categoryId);
            return listProduct;
        } else if // lọc theo price và size
                (season.equals(empty) == true && price.equals(empty) == false && gender.equals(empty) == true && size.equals(empty) == false) {
            listProduct = getListProductByPriceAndSize(size, price, categoryId);
            return listProduct;
        } else if// lọc theo price và gender và size
                (season.equals(empty) == true && price.equals(empty) == false && gender.equals(empty) == false && size.equals(empty) == false) {
            listProduct = getListProductByPriceAndGenderAndSize(price, gender, size, categoryId);
            return listProduct;
        } else if// chỉ lọc theo gender 
                (season.equals(empty) == true && price.equals(empty) == true && gender.equals(empty) == false && size.equals(empty) == true) {
            listProduct = getListProductByGender(gender, categoryId);
            return listProduct;
        } else if// lọc theo gender và size
                (season.equals(empty) == true && price.equals(empty) == true && gender.equals(empty) == false && size.equals(empty) == false) {
            listProduct = getListProductByGenderAndSize(gender, size, categoryId);
            return listProduct;
        } else if// chỉ lọc theo size
                (season.equals(empty) == true && price.equals(empty) == true && gender.equals(empty) == true && size.equals(empty) == false) {
            listProduct = getListProductBySize(size, categoryId);
            return listProduct;
        } else if// lọc theo tất cả các filter
                (season.equals(empty) == false && price.equals(empty) == false && gender.equals(empty) == false && size.equals(empty) == false) {
            listProduct = getListProductByALlFilter(season, price, gender, size, categoryId);
            return listProduct;
        } else if //  trở về mặc định
                (season.equals(empty) == true && price.equals(empty) == true && gender.equals(empty) == true && size.equals(empty) == true) {
            listProduct = getProductByCategoryId(categoryId);
            return listProduct;
        }
        return listProduct;

    }

    public Product getMaxIdProduct() {
        try {
            String sql = "SELECT TOP(1) p.[ProductID],p.[ProductName], p.[Price], p.[Image], p.[Season], p.[Description], p.[Gender], c.[CategoryID], c.CategoryName\n"
                    + "from PRODUCTS p inner join CATEGORIES c on p.CategoryID= c.CategoryID \n"
                    + "order by ProductID desc";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("ProductID"));
                p.setProductnName(rs.getString("ProductName"));
                p.setPrice(rs.getInt("price"));
                p.setImg(rs.getString("image"));

                p.setSeason(rs.getInt("season"));
                p.setDescripTion(rs.getString("description"));
                p.setGender(rs.getString("gender"));
                Category c = new Category();
                p.setCategoryObject(c);

                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                return p;
            }
        } catch (SQLException e) {

        }
        return null;
    }

    public Product get(int id) {
        try {
            String sql = "select p.[ProductID],[ProductName], "
                    + "[Price], [Image], [Season], "
                    + "[Description], [Gender], "
                    + "c.[CategoryID], c.CategoryName "
                    + "from [PRODUCTS] p inner join CATEGORIES c "
                    + "on p.CategoryID= c.CategoryID\n"
                    + "where p.ProductID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Product p = new Product();
                p.setProductId(rs.getInt("ProductID"));
                p.setProductnName(rs.getString("ProductName"));
                p.setPrice(rs.getInt("price"));
                p.setImg(rs.getString("image"));

                p.setSeason(rs.getInt("season"));
                p.setDescripTion(rs.getString("description"));
                p.setGender(rs.getString("gender"));
                Category c = new Category();
                p.setCategoryObject(c);

                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                return p;

            }
        } catch (SQLException e) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ArrayList<Product> getProductByAid(int id) {
        ArrayList<Product> products = new ArrayList<>();
        try {
            String sql = "select p.ProductID, p.ProductName, p.Price, p.[Image], p.Season, p.[Description], p.Gender, c.CategoryID, c.CategoryName, \n"
                    + "a.AgentID, a.AgentName, s.Size, s.Quantity from PRODUCTS p \n"
                    + "						INNER JOIN [CATEGORIES] c on p.CategoryID= c.CategoryID\n"
                    + "						INNER JOIN [SIZE] s on p.ProductID= s.ProductID\n"
                    + "						INNER JOIN [AGENT] a on s.AgentID= a.AgentID\n"
                    + "						where a.AgentID=?";
            PreparedStatement stm_list = connection.prepareStatement(sql);
            stm_list.setInt(1, id);
            ResultSet rs = stm_list.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                Category c = new Category();
                Agent a = new Agent();
                Size s = new Size();
                s.setSize(rs.getString("Size"));
                s.setQuantity(rs.getInt("quantity"));
                a.setAgentId(rs.getInt("AgentID"));
                a.setAgentName(rs.getString("AgentName"));
                p.setCategoryObject(c);
                p.setSizeObject(s);
                p.setProductId(rs.getInt("ProductID"));
                p.setProductnName(rs.getString("ProductName"));
                p.setImg(rs.getString("image"));
                p.setPrice(rs.getInt("price"));
                p.setSeason(rs.getInt("season"));
                p.setDescripTion(rs.getString("description"));
                p.setGender(rs.getString("gender"));
                c.setCategoryId(rs.getInt("CategoryID"));
                c.setCategoryName(rs.getString("CategoryName"));
                products.add(p);
            }
        } catch (SQLException e) {

        }
        return products;
    }

    public void insertSize(Size model, int id, int idMax) {
        try {
            String sql_into_Size = "Insert into SIZE ([AgentID], "
                    + "[ProductID], "
                    + "[Quantity], "
                    + "[Size]) values "
                    + "(?, ?, ?, ?)";
            PreparedStatement stm_insert_Size = connection.prepareStatement(sql_into_Size);
            stm_insert_Size.setInt(1, id);
            stm_insert_Size.setInt(2, idMax + 1);
            stm_insert_Size.setString(3, model.getSize());
            stm_insert_Size.setInt(4, model.getQuantity());
            stm_insert_Size.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void insert(Product model, int id, int idMax) {
        try {
            String sql = "Insert into [PRODUCTS]([ProductName], "
                    + "[Price], "
                    + "[Image], "
                    + "[Season], "
                    + "[Description], ["
                    + "Gender], "
                    + "[CategoryID]) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, model.getProductnName());
            stm.setInt(2, model.getPrice());
            stm.setString(3, model.getImg());
            stm.setInt(4, model.getSeason());
            stm.setString(5, model.getDescripTion());
            stm.setString(6, model.getGender());
            stm.setInt(7, model.getCategoryObject().getCategoryId());
            stm.executeUpdate();

            String sql_into_Size = "Insert into SIZE ([AgentID], "
                    + "[ProductID], "
                    + "[Quantity], "
                    + "[Size]) values "
                    + "(?, ?, ?, ?)";
            PreparedStatement stm_insert_Size = connection.prepareStatement(sql_into_Size);
            stm_insert_Size.setInt(1, id);
            stm_insert_Size.setInt(2, idMax + 1);

            stm_insert_Size.setInt(3, model.getSizeObject().getQuantity());
            stm_insert_Size.setString(4, model.getSizeObject().getSize());
            stm_insert_Size.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public void update(Product model) {
        try {
            String sql_update_product = "Update [PRODUCTS] "
                    + "set [ProductName]=?, \n"
                    + "						[Price]=?, \n"
                    + "						[Image]=?, \n"
                    + "						[Season]=?, \n"
                    + "						[Description]=?, \n"
                    + "						[Gender]=?, \n"
                    + "						[CategoryID]=?\n"
                    + "						where [ProductID]= ?";
            PreparedStatement stm_update_product = connection.prepareStatement(sql_update_product);
            stm_update_product.setString(1, model.getProductnName());
            stm_update_product.setInt(2, model.getPrice());
            stm_update_product.setString(3, model.getImg());
            stm_update_product.setInt(4, model.getSeason());
            stm_update_product.setString(5, model.getDescripTion());
            stm_update_product.setString(6, model.getGender());
            stm_update_product.setInt(7, model.getCategoryObject().getCategoryId());
            stm_update_product.setInt(8, model.getProductId());
            stm_update_product.executeUpdate();

            String sql_update_size = "Update [SIZE] set [Quantity]= ?,\n"
                    + "			 [Size]=?\n"
                    + "			where ProductID =?";
            PreparedStatement stm_update_size = connection.prepareStatement(sql_update_size);
            stm_update_size.setInt(1, model.getSizeObject().getQuantity());
            stm_update_size.setString(2, model.getSizeObject().getSize());
            stm_update_size.setInt(3, model.getProductId());
            stm_update_size.executeUpdate();

        } catch (SQLException e) {

        }
    }

    public void delete(Product model) {
        try {
            String delete_sql = "Delete [SIZE] where ProductID=?\n"
                    + "Delete [PRODUCTS] \n"
                    + "where ProductID=?";
            PreparedStatement stm_delete = connection.prepareStatement(delete_sql);
            stm_delete.setInt(1, model.getProductId());
            stm_delete.setInt(2, model.getProductId());
            stm_delete.executeUpdate();
        } catch (SQLException e) {

        }
    }

    public ArrayList<Agent> getAllAgent() {
        ArrayList<Agent> list = new ArrayList<>();
        String sql = "SELECT TOP (1000) [AgentID],[AgentName] FROM [AGENT]";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Agent(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println("getSizebyProductId Error:" + e.getMessage());
        }
        return list;
    }

//    public ArrayList<Size> getAgentProduct(int pId) {
//        ArrayList<Size> list = new ArrayList<>();
//        String sql = "select SIZE.*, AGENT.AgentName from SIZE,AGENT WHERE      SIZE.AgentID= AGENT.AgentID AND SIZE.ProductID =" + pId;
//
//        try {
//            ps = con.prepareStatement(sql);
//            rs = ps.executeQuery(sql);
//            while (rs.next()) {
//                Size size = new Size();
//                size.setAgentId(rs.getInt(1));
//                size.setProductId(rs.getInt(2));
//                size.setSize(rs.getString(3));
//                size.setQuantity(rs.getInt(4));
//                Agent agent = new Agent();
//                agent.setAgentName(rs.getString(5));
//                size.setAgent(agent);
//                list.add(size);
//            }
//        } catch (Exception e) {
//            System.out.println("getlist Error:" + e.getMessage());
//        }
//        return list;
//    }
    public ArrayList<Size> getAgentSizebyProductId(int agentId, int ProductId, String size) {
        ArrayList<Size> list = new ArrayList<>();
        String sql = "SELECT ProductID,Size,AgentID,Quantity  from Size WHERE AgentID = ? AND ProductID = ? And Size = ?";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, agentId);
            ps.setInt(2, ProductId);
            ps.setString(3, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Size(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4)));
            }
        } catch (Exception e) {
            System.out.println("getAgentSizebyProductId Error:" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Size> getSizebyProductId(int ProductId, String agentId) {
        ArrayList<Size> list = new ArrayList<>();
        String sql = "  select * from SIZE where ProductID = ? and [AgentID] = ? ";
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, ProductId);
            ps.setString(2, agentId);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Size(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
            System.out.println("getSizebyProductId Error:" + e.getMessage());
        }
        return list;
    }

    public ArrayList<Product> getProducts() {
        ArrayList<Product> list = new ArrayList<>();
        String sql = "select * from [PRODUCTS]";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getString(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            System.out.println("getlist Error:" + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        ProductDao a = new ProductDao();
        // List<Product> list = a.getNewProdcuts();
     //   List<Product> list = a.getProductByAid(1);
        //      List<Product> list = a.getProductByCategoryId(1);
        // List<Product> list = a.getListProductBySeason("1", 1);
        // List<Product> list = a.getListProductBySeasonAndPrice("1", "desc", 1);
        // List<Product> list = a.getListProductBySeasonAndGender("1", "male", 1);
        // List<Product> list = a.getListProductBySeasonAndPriceAndGender("1", "male", "desc", 1);
        // List<Product> list = a.getListProductByPrice("DESC",1 );
        //List<Product> list = a.getListProductByPriceAndGender("male", "DESC",1);
        //List<Product> list = a.getListProductByPriceAndSize("m", "DESC",1 );
        // List<Product> list = a.getListProductByPriceAndGenderAndSize("desc", "male", "s",1);
        //List<Product> list = a.getListProductByGenderAndSize("male", "s",1 );
        //  List<Product> list = a.getListProductByGender("male", 1);
        //List<Product> list = a.getListProductBySize("s",1);
        //List<Product> list = a.getListProductByALlFilter("1", "desc", "male", "s", 1);
//        for (Product pro : list) {
//            System.out.println(pro.toStringWithSize());
//        }

       List<Size> list = a.getSizebyProductId(1, "1");
       
        for (Size pro : list) {
            System.out.println(pro);
        }
        //     List<Product> list = a.getListByFilter("empty", "empty", "empty", "empty", 1);
        //       List<Product> list = a.getProductByCategoryId(1);
//        List<Product> list = a.getListProductBySeasonAndAndGenderAndSize("1", "male", "s", 1);
//        for (Product pro : list) {
//            System.out.println(pro.toStringWithSize());
//        }
    }

}
