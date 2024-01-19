<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container-fluid"">
    <div  class="row">
        <div   class="col-sm-auto sticky-top">
            <div class="d-flex flex-sm-column flex-row flex-nowrap align-items-center sticky-top">
                <c:if test="${user.role!='admin'}">
                    <a href="home" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
                        <i class="bi bi-house fs-1"></i>
                    </a>
                </c:if>
                <c:if test="${user.role=='admin'}">
                    <a href="AdminUser" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
                        <i class="bi bi-person-check-fill fs-1"></i>
                    </a>
                </c:if>
                <ul class="nav nav-pills nav-flush flex-sm-column flex-row flex-nowrap mb-auto mx-auto text-center align-items-center">
                    <c:if test="${user.role!='admin'}">
                   <form action="course"  method="POST">
                        <button style="background-color: transparent;border: 0px;" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
                            <i title="My course" class="bi bi-play-circle fs-1"></i>
                          </form> 
                        </a>
                   </c:if>
                   
                    <c:if test="${user.role=='admin'}">
                        <form action="AdminCourse"  method="POST">
                        <button style="background-color: transparent;border: 0px;" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
                            <i class="bi bi-gear-fill fs-1"></i>
                          </form> 
                        </a>
                   </c:if>
                   
                   
                   
                   
                   
                    <c:if test="${user.role!='admin'}">
                    <form action="cart"  method="POST">                     
                        <button style="background-color: transparent;border: 0px;" type="submit" class="d-block p-3 link-dark text-decoration-none" title="" data-bs-toggle="tooltip" data-bs-placement="right" data-bs-original-title="Icon-only">
                             <i class="bi bi-cart fs-1"></i>
                        </button>
                    </form>
                   </c:if>
                   
                </ul>
                
            </div>
        </div>
        <div class="col-sm p-3 min-vh-100">
                
      