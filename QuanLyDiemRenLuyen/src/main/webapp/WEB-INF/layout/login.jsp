<%-- 
    Document   : login
    Created on : May 28, 2024, 7:02:00 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<h1 class="text-center text-danger">ĐĂNG NHẬP</h1>


<c:if test= "${param.error != null}">
    <div class= "alert alert-danger">
        Da co loi xay ra
    </div> 
</c:if>

<%--<c:url value="/login" var="action" />--%>
<form method="post" action="${action}">
    <div class="form-group">
        <label>Username</label>
        <input type="text" id="username" name="username" class="form-control" />
    </div>
    <div class="form-group">
        <label>Password</label>
        <input type="password" id="password" name="password" class="form-control" />
    </div>
    <div class="form-group">
        <input type="submit" value="DANG NHAP" class="btn btn-danger"/>
    </div>
</form>

