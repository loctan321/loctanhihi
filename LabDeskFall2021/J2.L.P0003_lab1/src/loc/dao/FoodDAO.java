/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dao;


import loc.dbultis.MyConnection;
import loc.dto.Food;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class FoodDAO {
    
     public static ArrayList<Food> getsFood() throws SQLException{
        ArrayList<Food> listFood=new ArrayList<>();
        Connection cn = MyConnection.makeConnection();
        if(cn!=null){
            String sql="SELECT foodID, foodName, unit, price, quantity,tblFood.categoryID AS categoryID ,categoryName\n" +
                        "FROM dbo.tblFood INNER JOIN dbo.TblFoodCategory ON TblFoodCategory.categoryID = tblFood.categoryID";
            PreparedStatement pst=cn.prepareStatement(sql);
            ResultSet rs=pst.executeQuery();
            while (rs.next()) {                
                String foodID = rs.getString("foodID");
                String foodName = rs.getString("foodName");
                String unit = rs.getString("unit");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                String categoryID = rs.getString("categoryID");
                String categoryName = rs.getString("categoryName");  
                Food p = new Food(foodID, foodName, unit, price, quantity, categoryID, categoryName);
                listFood.add(p);
            }
            cn.close();
        }
    return listFood;
    }
     
     
      public static int insertFood(String foodID, String foodName, String unit, float price, int quantity, String categoryID) throws SQLException{
        Connection cn = MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="INSERT dbo.tblFood VALUES(?,?,?,?,?,?)";
            PreparedStatement pst=cn.prepareStatement(sql);
            pst.setString(1, foodID);
            pst.setString(2, foodName);
            pst.setString(3, unit);
            pst.setFloat(4, price);
            pst.setInt(5, quantity);
            pst.setString(6, categoryID);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    } 
     
   public static int updateFood(String foodID, String foodName, String unit, float price, int quantity, String categoryID) throws SQLException{
        Connection cn = MyConnection.makeConnection();
        int result=0;
        if(cn!=null){
            String sql="UPDATE dbo.tblFood SET foodName=?, unit=?, price=?, quantity=?, categoryID=? WHERE foodID=?";
            PreparedStatement pst=cn.prepareStatement(sql);            
            pst.setString(1, foodName);
            pst.setString(2, unit);
            pst.setFloat(3, price);
            pst.setInt(4, quantity);
            pst.setString(5, categoryID);
            pst.setString(6, foodID);
            result=pst.executeUpdate();
            cn.close();
        }
        return result;
    }   
     
     
     public static int deleteFood(String foodID) throws SQLException{
         int result = 0;
         Connection cn = MyConnection.makeConnection();
         if ( cn != null ) {
             String sql="delete from dbo.tblFood where foodID=?";
             PreparedStatement pst = cn.prepareStatement(sql);
             pst.setString(1, foodID);
             result = pst.executeUpdate();
             cn.close();
         }
         return result;
    }
     
     
     
     
     
}
