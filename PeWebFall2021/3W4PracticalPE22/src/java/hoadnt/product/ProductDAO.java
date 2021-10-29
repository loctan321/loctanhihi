/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.product;

import hoadnt.utils.DBUtils;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author hd
 */
public class ProductDAO implements Serializable{
        public ArrayList<ProductDTO> getAllProduct() throws NamingException, SQLException {
        ArrayList<ProductDTO> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT productID, name, description, price, cpu, status, createDate, updateDate "
                        + " FROM tblProducts ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    float cpu = rs.getFloat("cpu");
                    boolean status = rs.getBoolean("status");
                    Date createDate = rs.getDate("createDate");
                    Date updateDate = rs.getDate("updateDate");
                    list.add(new ProductDTO(productID, name, description, price, cpu, status, createDate, updateDate));
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public List<ProductDTO> searchProductByName(String search) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT productID, name, description, price, cpu, status, createDate, updateDate FROM tblProducts WHERE name LIKE ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                Float cpu = rs.getFloat("cpu");
                boolean status = rs.getBoolean("status");
                Date createDate = rs.getDate("createDate");
                Date updateDate = rs.getDate("updateDate");
                list.add(new ProductDTO(productID, name, description, price, cpu, status, createDate, updateDate));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
    
    public List<ProductDTO> searchProductByStatus(Boolean statusSearch) throws SQLException {
        List<ProductDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT productID, name, description, price, cpu, status, createDate, updateDate"
                    + " FROM tblProducts"
                    + " WHERE status = ?";
            stm = conn.prepareStatement(sql);
            stm.setBoolean(1, statusSearch);
            rs = stm.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String name = rs.getString("name");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                Float cpu = rs.getFloat("cpu");
                boolean status = rs.getBoolean("status");
                Date createDate = rs.getDate("createDate");
                Date updateDate = rs.getDate("updateDate");
                list.add(new ProductDTO(productID, name, description, price, cpu, status, createDate, updateDate));
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

        return list;
    }
    
    public boolean removeProductByID(String productID) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts SET status = ? "
                        + "WHERE productID = ? ";
                ps = con.prepareStatement(sql);
                ps.setBoolean(1, false);
                ps.setString(2, productID);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean updateProduct(ProductDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "UPDATE tblProducts "
                        + " SET name= ?, description= ?, price= ?, cpu= ?, status= ?, updateDate= ? "
                        + " WHERE productID= ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getName());
                ps.setString(2, dto.getDescription());
                ps.setFloat(3, dto.getPrice());
                ps.setFloat(4, dto.getCpu());
                ps.setBoolean(5, dto.isStatus());
                ps.setDate(6, dto.getUpdateDate()); 
                ps.setString(7, dto.getProductID());
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean insertProduct(ProductDTO dto) throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "INSERT Into tblProducts(productID, name, description, price, cpu, status, createDate ) "
                        + "VALUES(?, ?, ?, ?, ?, ?, ? )";
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getProductID());
                ps.setString(2, dto.getName());
                ps.setString(3, dto.getDescription());
                ps.setFloat(4, dto.getPrice());
                ps.setFloat(5, dto.getCpu());
                ps.setBoolean(6, dto.isStatus());
                ps.setDate(7, dto.getCreateDate());
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {

            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
}
