<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
        <link rel="stylesheet" href="./assets/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="./assets/css/owl.carousel.min.css">
        <link rel="stylesheet" href="./assets/css/style.css">
        <script type="text/javascript"  src="./assets/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
        <style>
            body{
                background-color: transparent;
            }
            .nav-item{
                margin-left: 40px;
                
            }
            .navbar{
                border-bottom: 1px solid #d9d4d4 ;
                height: 75px;
            }
            .dropdown{
                margin-right: 10px;
            }
         

            .flex-container {
                display: flex;
            }

            .video-container {
                width: 70%;
            }

  

       

            .list-item a {
                width: 100%;
            }

            .list-item h6 {
                margin: 0;
            }


            #list-container {
                width: 30%; /* Độ rộng của khung chứa danh sách */
                height: 500px; /* Chiều cao cố định của khung chứa danh sách */
                overflow-y: auto; /* Tạo thanh cuộn dọc khi danh sách vượt quá kích thước */
            }
            #playvideo:hover{
                background-color: #b3b3b3;
            }
            #btndelete:hover{
                background-color: #e35858;
            }
            
            
     .numbers-list {
        height: 250px; /* Adjust the height as needed */
        overflow-y: auto;
    }
    /* Center the form */
    .centered-form {
      position: fixed;
      top: 50%;
      left: 50%;
      transform: translate(-50%, -50%);
      z-index: 9999;
      background-color: white;
      padding: 20px;
      border-radius: 10px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }



    h3 {
      margin-bottom: 10px;
    }

    .horizontal-bar {
      display: flex;
      align-items: center;
      background-color: #fff;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); /* Đổ bóng cho thanh ngang */
      overflow-x: auto; /* Hiển thị thanh cuộn khi nội dung vượt quá kích thước */
      padding: 5px;
      margin-bottom: 10px; /* Khoảng cách với phần tử close-icon */
      scrollbar-width: thin; /* Chỉ áp dụng cho Firefox */
    }

    .horizontal-bar::-webkit-scrollbar {
      width: 8px;
      height: 8px;
    }

    .horizontal-bar::-webkit-scrollbar-thumb {
      background-color: rgba(0, 0, 0, 0.2);
      border-radius: 4px;
    }

    .horizontal-bar input {
      padding: 10px;
      margin-right: 10px;
      border: 1px solid #ccc;
      border-radius: 5px;
      flex: 1;
      transition: border-color 0.3s ease-in-out; /* Hiệu ứng khi hover vào input */
    }

    .horizontal-bar input:focus {
      outline: none;
      border-color: dodgerblue; /* Thay đổi màu khi input được focus */
    }

    .horizontal-bar input:last-child {
      margin-right: 0;
    }

   

  

p {
  color: #b3b3b3;
  font-weight: 300; }

h1, h2, h3, h4, h5, h6,
.h1, .h2, .h3, .h4, .h5, .h6 {
  font-family: "Roboto", sans-serif; }

a {
  -webkit-transition: .3s all ease;
  -o-transition: .3s all ease;
  transition: .3s all ease; }
  a:hover {
    text-decoration: none !important; }

.content {
  padding: 7rem 0; }

h2 {
  font-size: 20px; }

@media (max-width: 991.98px) {
  .content .bg {
    height: 500px; } }

.content .contents, .content .bg {
  width: 50%; }
  @media (max-width: 1199.98px) {
    .content .contents, .content .bg {
      width: 100%; } }
  .content .contents .form-group, .content .bg .form-group {
    overflow: hidden;
    margin-bottom: 0;
    padding: 15px 15px;
    border-bottom: none;
    position: relative;
    background: #edf2f5;
    border-bottom: 1px solid #e6edf1; }
    .content .contents .form-group label, .content .bg .form-group label {
      position: absolute;
      top: 50%;
      -webkit-transform: translateY(-50%);
      -ms-transform: translateY(-50%);
      transform: translateY(-50%);
      -webkit-transition: .3s all ease;
      -o-transition: .3s all ease;
      transition: .3s all ease; }
    .content .contents .form-group input, .content .bg .form-group input {
      background: transparent; }
    .content .contents .form-group.first, .content .bg .form-group.first {
      border-top-left-radius: 7px;
      border-top-right-radius: 7px; }
    .content .contents .form-group.last, .content .bg .form-group.last {
      border-bottom-left-radius: 7px;
      border-bottom-right-radius: 7px; }
    .content .contents .form-group label, .content .bg .form-group label {
      font-size: 12px;
      display: block;
      margin-bottom: 0;
      color: #b3b3b3; }
    .content .contents .form-group.focus, .content .bg .form-group.focus {
      background: #fff; }
    .content .contents .form-group.field--not-empty label, .content .bg .form-group.field--not-empty label {
      margin-top: -20px; }
  .content .contents .form-control, .content .bg .form-control {
    border: none;
    padding: 0;
    font-size: 20px;
    border-radius: 0; }
    .content .contents .form-control:active, .content .contents .form-control:focus, .content .bg .form-control:active, .content .bg .form-control:focus {
      outline: none;
      -webkit-box-shadow: none;
      box-shadow: none; }

.content .bg {
  background-size: cover;
  background-position: center; }

.content a {
  color: #888;
  text-decoration: underline; }

.content .btn {
  height: 54px;
  padding-left: 30px;
  padding-right: 30px; }

.content .forgot-pass {
  position: relative;
  top: 2px;
  font-size: 14px; }

.social-login a {
  text-decoration: none;
  position: relative;
  text-align: center;
  color: #fff;
  margin-bottom: 10px;
  width: 50px;
  height: 50px;
  border-radius: 50%;
  display: inline-block; }
  .social-login a span {
    position: absolute;
    top: 50%;
    left: 50%;
    -webkit-transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    transform: translate(-50%, -50%); }
  .social-login a:hover {
    color: #fff; }
  .social-login a.facebook {
    background: #3b5998; }
    .social-login a.facebook:hover {
      background: #344e86; }
  .social-login a.twitter {
    background: #1da1f2; }
    .social-login a.twitter:hover {
      background: #0d95e8; }
  .social-login a.google {
    background: #ea4335; }
    .social-login a.google:hover {
      background: #e82e1e; }

.control {
  display: block;
  position: relative;
  padding-left: 30px;
  margin-bottom: 15px;
  cursor: pointer;
  font-size: 14px; }
  .control .caption {
    position: relative;
    top: .2rem;
    color: #888; }

.control input {
  position: absolute;
  z-index: -1;
  opacity: 0; }

.control__indicator {
  position: absolute;
  top: 2px;
  left: 0;
  height: 20px;
  width: 20px;
  background: #e6e6e6;
  border-radius: 4px; }

.control--radio .control__indicator {
  border-radius: 50%; }

.control:hover input ~ .control__indicator,
.control input:focus ~ .control__indicator {
  background: #ccc; }

.control input:checked ~ .control__indicator {
  background: #6c63ff; }

.control:hover input:not([disabled]):checked ~ .control__indicator,
.control input:checked:focus ~ .control__indicator {
  background: #847dff; }

.control input:disabled ~ .control__indicator {
  background: #e6e6e6;
  opacity: 0.9;
  pointer-events: none; }

.control__indicator:after {
  font-family: 'icomoon';
  content: '\e5ca';
  position: absolute;
  display: none;
  font-size: 16px;
  -webkit-transition: .3s all ease;
  -o-transition: .3s all ease;
  transition: .3s all ease; }

.control input:checked ~ .control__indicator:after {
  display: block;
  color: #fff; }

.control--checkbox .control__indicator:after {
  top: 50%;
  left: 50%;
  margin-top: -1px;
  -webkit-transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  transform: translate(-50%, -50%); }

.control--checkbox input:disabled ~ .control__indicator:after {
  border-color: #7b7b7b; }

.control--checkbox input:disabled:checked ~ .control__indicator {
  background-color: #7e0cf5;
  opacity: .2; }

            
        </style>
    </head>
