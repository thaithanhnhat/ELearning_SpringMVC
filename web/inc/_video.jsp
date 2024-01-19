<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div>
    <nav style="height:60px;background-color:#6842E3; " class="navbar navbar-dark">
      <div class="container-fluid">
          <a href="course" style="color: white" type="button" >
              <i class="bi bi-box-arrow-left fs-2"></i>                
          </a>
             <p style="color: #ffffff" class="fw-bolder fs-3">Share3s</p>

      </div>
    </nav>
<div class="flex-container">
    <div class="video-container">
        <div id="video">
            <iframe width=95%" height="500px" src="https://www.youtube.com/embed/${video_start.url_video}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>                      
            <div class="card">
            <div class="card-header">
              <p style="color: black;" class="h3">${video_start.title}</p>
            </div>
            <div class="card-body">
              <h5 class="card-title"><i class="bi bi-people"></i>${video_start.view_quantily} view</h5>
              <p style="color: #0f5132;" class="card-text">${video_start.describe}</p>
            </div>
          </div>
        </div>
        
    </div>
    <div class="list-container">
        <div id="list" class="scrollspy-example">
            <c:forEach items="${listVideo}" var="video">
                <div style="height: 70px; border-bottom:1px solid #e0dfdf" class="list-item">
                    <a href="./video?id_video=${video.id}" style="text-decoration: none;color: #000; height: 100%" id="playvideo" type="button">
                        <i style="color: #ff0000" class="bi bi-youtube"></i> <h6>${video.title}</h6>
                    </a>
                </div>
                   
            </c:forEach>           
        </div>
    </div>
</div>


 


    

