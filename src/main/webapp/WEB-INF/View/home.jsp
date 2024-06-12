<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ page import="com.spring.model.Product" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" rel="stylesheet">
    <style>
        body {
            font-family: Arial, sans-serif;
            color: #343a40;
            padding: 20px;
            background-color: #f8f9fa;
        }
        .table-container {
            max-width: 1000px;
            margin: auto;
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .table-responsive {
            overflow-x: auto;
        }
        .table {
            width: 100%;
            background-color: #ffffff;
            color: #343a40;
        }
        .table th, .table td {
            border: none;
            vertical-align: middle;
            text-align: center;
            padding: 12px;
        }
        .table th {
            background-color: #007bff;
            color: white;
            font-size: 1.2rem;
        }
        .table td {
            background-color: #fff3e0;
        }
        .table .btn {
            padding: .25rem .5rem;
            font-size: 0.9rem;
            border-radius: 5px;
            transition: all 0.3s ease;
        }
        .btn-update {
            background-color: #17a2b8;
            color: white;
            border: none;
        }
        .btn-update:hover {
            background-color: #138496;
        }
        .btn-delete {
            background-color: #dc3545;
            color: white;
            border: none;
        }
        .btn-delete:hover {
            background-color: #bd2130;
        }
        .btn-add {
            background-color: #ffc107;
            color: white;
            border: none;
            animation: pulse 1s infinite;
        }
        .btn-add:hover {
            background-color: #e0a800;
        }
        @keyframes pulse {
            0% {
                transform: scale(1);
            }
            50% {
                transform: scale(1.05);
            }
            100% {
                transform: scale(1);
            }
        }
        .tr_row {
            margin-bottom: 10px;
            background-color: #fff8e1;
            border-radius: 10px;
            padding: 10px 0;
        }
    </style>
</head>
<body>
    <div class="table-container">
        <h2 style="text-align: center; color: #343a40; padding: 10px 0; border-radius: 10px 10px 0 0; margin-bottom: 20px;">
            Product List
        </h2>
        <div class="table-responsive">
            <table class="table table-striped table-bordered">
                <thead>
                    <tr>
                        <th style="width: 10%;">Product ID</th>
                        <th style="width: 20%;">Product Name</th>
                        <th style="width: 40%;">Product Description</th>
                        <th style="width: 15%;">Product Price</th>
                        <th style="width: 15%;">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="product" items="${ProductList}">
                        <tr class="tr_row">
                            <td>PRODUCT${product.id}</td> 
                            <td>${product.productName}</td>
                            <td>${product.productDescription}</td>
                            <td>${product.productPrice}</td>
                             <td style="text-align: center;">
                                <a href="home/update/${product.id}" class="btn btn-update">
                                    <i class="fas fa-pen"></i> Update
                                </a>
                                <a href="home/delete/${product.id}" class="btn btn-delete">
                                    <i class="fas fa-trash-alt"></i>
                                </a>
                            </td> 
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Add Product Button -->
    <div style="text-align: center; margin-top: 20px;">
        <a href="addProduct"><button class="btn btn-add">
            <i class="fas fa-plus"></i> Add Product
        </button></a>
    </div>

    <!-- Bootstrap JS and FontAwesome JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
