/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loc.dto;

/**
 *
 * @author ADMIN
 */
public class Food {
    private String foodID;
    private String foodName;
    private String unit;
    private float price;
    private int quantity;
    private String categoryID;
    private String categoryName;

    public Food(String foodID, String foodName, String unit, float price, int quantity, String categoryID, String categoryName) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.unit = unit;
        this.price = price;
        this.quantity = quantity;
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    
}
