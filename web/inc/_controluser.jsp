<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:forEach items="${listUser}" var="User">
    <div style="
      background-color: #fff;
      border: 1px solid #ccc;
      border-radius: 8px;
      box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.2); /* Đổ bóng */" class="container">      
        <h3>ID:${User.id}</h3>
         <form action="" method="POST">
            <div class="horizontal-bar">
                <input type="text" name="email" placeholder="email"   value="${User.email}">
                <input type="text" name="phone" placeholder="phone" value="${User.phone}">
                <input type="text" name="password" placeholder="password" value="${User.password}">
                <input type="text" name="name" placeholder="name" value="${User.name}">
                <input type="text" name="status" placeholder="status" value="${User.status}">
                <input type="text" name="role" placeholder="member" value="${User.role}">
            </div>
              <input type="hidden" name="id_update" placeholder="id" value="${User.id}">           
              <button type="submit" class="btn btn-primary"><i class="bi bi-floppy"></i></button>              
            </form>
              
            <form action="" method="GET">
                <input type="hidden" name="id_delete" value="${User.id}">
                 <button type="submit" class="btn btn-danger"><i class="bi bi-trash3"></i></button>
            </form>

    </div>
</c:forEach>

