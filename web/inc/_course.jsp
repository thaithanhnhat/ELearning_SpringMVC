<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h4>Your Course</h4>
<section style="background-color: #f6f5f5;border-radius: 20px; margin-top: 20px;"> 
    <div style="margin-left: 40px;" class="container py-5">
       
      <div style="margin-left: 50px;"  class="row">
          <c:forEach items="${listOrdered}" var="Ordered">
          <c:forEach items="${listCourse}" var="Course">
              <c:if test="${Ordered.id_course == Course.id }">
            <!--course -->
            <div style="margin-top: 15px;"  class="col-md-12 col-lg-4 mb-4 mb-lg-0">
            <div class="card" style="border-radius: 15px;">
              <div class="bg-image hover-overlay ripple ripple-surface ripple-surface-light"
                data-mdb-ripple-color="light">
                  <img src="./assets/img/${Course.img}"
                  style="border-top-left-radius: 15px; border-top-right-radius: 15px;" class="img-fluid"
                  alt="Laptop" />
                <a href="#!">
                  <div class="mask"></div>
                </a>
              </div>
              <div class="card-body pb-0">
                <div class="d-flex justify-content-between">
                  <div>
                    <h5>${Course.name}</h5>
                
                  </div>
                  <div>
                    <div class="d-flex flex-row justify-content-end mt-1 mb-4 text-danger">
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                      <i class="fas fa-star"></i>
                    </div>
                    <p class="small text-muted">${Course.rated}<i style="color: #fff200" class="bi bi-star-fill"></i></p>
                  </div>
                </div>
              </div>
              <hr class="my-0" />
              <div class="card-body pb-0">
                <div class="d-flex justify-content-between">
                    <h6 style="color: #66ff33">actived</h6>
                  
                </div>         
              </div>
              <hr class="my-0" />
              <div class="card-body">
                <div class="d-grid gap-2">
                    <a href="./video?id_course=${Course.id}" class="btn btn-success" type="button"><i class="bi bi-play-fill fs-3"></i></a>

</div>
              </div>
            </div>
            </div>
            <!--course -->
            </c:if>
        </c:forEach> 

  </c:forEach> 
      </div>
  
 
  
    </div>
</section>