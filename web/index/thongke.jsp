<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Outwear</title>
    <style>
     <%@ include file="/css/thongke.css"%>
    </style>
    <link rel="stylesheet" href="/WebApplication3/icon/themify-icons-font/themify-icons/themify-icons.css">
    <script src="test.js"></script>
</head>
<body>
    <div class="header">
        <a href="/WebApplication3/Trangchu"> <img  src="/WebApplication3/anh/logo.png" class="logo" alt="SLY CLOTHING"> </a>
        <nav class="nav-bar">
            <div class="button-nav">
                <button class="btn ">   <a class="b1" href="/WebApplication3/Cuahang">SHOP ALL</a>  </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Top">TOP </a>         </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Outwear">OUTWEAR </a>      </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Bottom">BOTTOM</a>       </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Accessories">ACCESSORY</a>    </button>
                 <c:if test="${sessionScope.taikhoan.isAdmin == 1}">      
                     <button class="btn">    <a class="b1" href="/WebApplication3/Manager">MANAGE PRODUCT</a>         </button>
                     <button class="btn">    <a class="b1" href="/WebApplication3/Thongke">THỐNG KÊ</a>         </button>
                 </c:if>
                <c:if test="${sessionScope.taikhoan != null}">   
                <c:if test="${sessionScope.taikhoan.isAdmin == 0}">  
                <button class="btn">    <a class="b1" href="/WebApplication3/Cart"><i class="ti-shopping-cart"></i></a>      </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Orderhis">LỊCH SỬ</a>      </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/LoadeditAcc">THÔNG TIN</a>      </button>
                </c:if>
                <button class="btn">    <a class="b1" href="#">${sessionScope.taikhoan.user}</a>      </button>
                <button class="btn">    <a class="b1" href="/WebApplication3/Logout">ĐĂNG XUẤT</a>      </button>             
                </c:if>
            </div>
        </nav>
        <form action="Search" method="post" class="form1">
            <div class="timkiem">
                <button type="submit" class="btn"><i class="search-icon ti-search"></i></button> 
            </div>
            <div class="timkiem1">
                <input name="txt" type="text" id="search">
            </div>
        </form>
        <c:if test="${sessionScope.taikhoan == null}">         
            <div class="log">
                <div class="dk-dn1" >   <a href="/WebApplication3/index/dk.jsp">ĐĂNG KÝ</a>   </div>
                <div class="dk-dn2" >   <a href="/WebApplication3/Login">ĐĂNG NHẬP</a> </div>
            </div>
        </c:if>
    </div>
    
    <div class="giua">
       <center>
            <div class="tieude">
                <h2><b>Chọn loại thống kê</b></h2>                				
            </div>  
            <a class="btn2" id="tk1" href="/WebApplication3/Thongke1" style="margin-left: 0px;">THỐNG KÊ KHÁCH HÀNG TIÊU NHIỀU TIỀN NHẤT</a>
            <a class="btn2" id="tk2" href="/WebApplication3/Thongke2">THỐNG KÊ KHÁCH HÀNG MUA NHIỀU ĐƠN HÀNG NHẤT</a>
            <a class="btn2" id="tk3" href="/WebApplication3/Thongke3">THỐNG KÊ SẢN PHẨM ĐƯỢC MUA NHIỀU NHẤT</a>
        </center>
    </div>

    <script>window.onload=function(){search.focus()}</script>
</body>
</html>