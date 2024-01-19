<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("userData")) {
                cookie.setMaxAge(0); 
                cookie.setPath("/KTHP_THAITHANHNHAT"); // Thiết lập lại đường dẫn của cookie (nếu cần thiết)
                response.addCookie(cookie); 
            }
        }
    }

 

    // Xóa thuộc tính trong session
    request.getSession().removeAttribute("user");
    response.sendRedirect(request.getContextPath() + "/home");
%>
