<%-- 
    Document   : index
    Created on : Apr 23, 2021, 9:38:36 PM
    Author     : hd
    Hoadnt: Your code here. Do not delete this comment
--%>



<%@page import="java.sql.Date"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
    </head>
    <body>
        <form action="MainController">
            Search: <input type="text" name="search" value="${param.search}" /> 
            <input type="submit" value="Search" name="action" />
        </form>

        <form action="MainController">

            <select name="searchValueByStatus">
                <c:if test="${not empty param.searchValueByStatus}">
                    <c:if test="${param.searchValueByStatus eq 'true'}">
                        <option value="true">Available</option>
                        <option value="false">Unavailable</option>    
                    </c:if>
                    <c:if test="${param.searchValueByStatus eq 'false'}">
                        <option value="false">Unavailable</option>    
                        <option value="true">Available</option>
                    </c:if>
                </c:if>
                <c:if test="${empty param.searchValueByStatus}">
                    <option value="true">Available</option>
                    <option value="false">Unavailable</option>    
                </c:if>

            </select>
            <input type="submit" value="SearchByStatus" name="action" />
        </form>
        <c:set var="listProduct" value="${requestScope.listProduct}"/>
        <c:if test="${not empty listProduct}">
            <table border="10">
                <thead>
                    <tr>
                        <th>No.</th>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Price</th>
                        <th>CPU</th>
                        <th>Status</th>
                        <th>Create Date</th>
                        <th>Update Date</th>
                        <th>Remove</th>
                        <th>Update</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${listProduct}" varStatus="counter">

                        <tr  style="text-align: center;">
                    <form action="MainController">
                        <td>
                            ${counter.count}.
                        </td>
                        <td>${dto.productID}</td>
                        <input type="hidden" name="productID" value="${dto.productID}" />
                        <td>
                            <input type="text" name="name" value="${dto.name}" />
                        </td>
                        <td>
                            <input type="text" name="description" value="${dto.description}" />
                        </td>
                        <td>
                            <input type="text" name="price" value="${dto.price}" min="1" />
                        </td>
                        <td>
                            <input type="number" name="cpu" value="${dto.cpu}"  min="1"/>
                        </td>
                        <td>
                            <c:if test="${dto.status eq true}">
                                <select name="status">
                                    <option value="${dto.status}">Active</option>
                                    <option value="false">Inactive</option>
                                </select>
                            </c:if>
                            <c:if test="${dto.status eq false}">
                                <select name="status">
                                    <option value="${dto.status}">Inactive</option>
                                    <option value="true">Active</option>
                                </select>
                            </c:if>
                        </td>
                      
                        <td> ${dto.createDate}</td>             


                        <td>
                            <input type="date" name="updateDate" value="${dto.updateDate}"/>
                        </td>
                        <c:if test="${dto.status eq true}">
                            <td>
                                <input type="submit" value="Remove" name="action" onclick="return confirm('Are you sure?')"/>    
                            </td>    
                        </c:if>
                        <c:if test="${dto.status eq false}">
                            <td>
                                <input type="submit" value="Remove" name="action" disabled />
                            </td>  
                        </c:if>        
                        <td>
                            <input type="submit" value="Update" name="action" />
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</c:if>

<a href="MainController?action=Add">Click Here to add More Products</a>
</body>
</html>
