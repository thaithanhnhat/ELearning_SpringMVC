<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${user.role=='admin'}">
    <nav style="background-color: #6842E3;" class="navbar navbar-expand-lg bg-body-tertiary">
</c:if>
<c:if test="${user.role!='admin'}">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
</c:if>
  <div class="container-fluid">
     <a class="navbar-brand" href="home">
         <c:if test="${user.role!='admin'}">
            <img src="./assets/img/logo.png" alt="" height="55px" width="150px"/>
         </c:if>
             <c:if test="${user.role=='admin'}"> 
                 <i style="color: white" class="bi bi-code-slash fs-1"></i>
         </c:if>
            
            
            
     </a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
   
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <c:if test="${user.role!='admin'}">
        <ul class="navbar-nav">       
            <li style=" background-color:#f8f7f6;margin-left: 150px; border-radius: 20px; "  class="nav-item dropdown">
            <a  class="nav-link dropdown-toggle" style="color: black;" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
             Category
          </a>              
          <ul class="dropdown-menu">    
              <c:forEach items="${listCategory}" var="Category">
                <li><a class="dropdown-item" href="./home?id_category=${Category.id}">${Category.name}</a></li>
              </c:forEach> 
          </ul>
        </li>
        </c:if>
        
      </ul>
        <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
        <c:if test="${user.role=='1'}">
          <form class="d-flex" role="search">
              <input type="text" style="  border-radius: 20px; margin-left: 200px; height: 50px; width: 400px" class="form-control me-2" name="search" type="search" placeholder="Search" aria-label="Search">
              <button style="border-radius:20px; " class="btn btn-outline-success" type="submit"><i class="bi bi-search fs-4"></i></button>
          </form>
          </c:if>
        </div>
        </nav>
    </div>  
     
      <c:if test="${user==null}">
          <a style="color: #282626; margin-right:  30px;" class="text-decoration-non" href="login">
                <i  class="bi-person-circle h2 fs-2"></i>
          </a>
       </c:if>  
     
     <c:if test="${user!=null}">
        <div class="dropdown">
             <c:if test="${user.role!='admin'}">
                <a href="login" class="d-flex align-items-center justify-content-center p-3 link-dark text-decoration-none dropdown-toggle" id="dropdownUser3" data-bs-toggle="dropdown" aria-expanded="false">
                    <i class="bi-person-circle h2 fs-2"><h6>${user.name}</h6></i>
                </a>
              </c:if>
               <c:if test="${user.role=='admin'}">
                <a href="login" class="d-flex align-items-center justify-content-center p-3 link-dark text-decoration-none dropdown-toggle" id="dropdownUser3" data-bs-toggle="dropdown" aria-expanded="false">
                    <i style="color: white;" class="bi-person-circle h2 fs-2"><h6>${user.name}</h6></i>
                </a>
              </c:if>
            
                <ul class="dropdown-menu text-small shadow" aria-labelledby="dropdownUser3">
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><a class="dropdown-item" href="./views/logout.jsp">Log out</a></li>
                </ul>
        </div>
    </c:if>  
     <c:if test="${user.role!='admin'}">
       <a style="color: #282626" href="login">
           <i class="bi bi-bell fs-2"></i>
       </a>
     </c:if>
  </div>
</nav>