/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoadnt.product;

import java.sql.Date;


/**
 *
 * @author hd
 */
public class ProductDTO {
    private String productID;
    private String name;
    private String description;
    private float price;
    private float cpu;
    private boolean status;
    private Date createDate;
    private Date updateDate;

  

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, String description, float price, float cpu, boolean status, Date createDate, Date updateDate) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cpu = cpu;
        this.status = status;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    public ProductDTO(String productID, String name, String description, float price, float cpu, boolean status) {
        this.productID = productID;
        this.name = name;
        this.description = description;
        this.price = price;
        this.cpu = cpu;
        this.status = status;
    }

   

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCpu() {
        return cpu;
    }

    public void setCpu(float cpu) {
        this.cpu = cpu;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

  
    
    
}
