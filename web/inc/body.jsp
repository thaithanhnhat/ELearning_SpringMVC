<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section style="background-color: #f6f5f5;border-radius: 20px; margin-top: 20px;"> 
    <div style="margin-left: 50px;" class="container py-5">
        <c:if test="${id_category==null}">
            <c:forEach items="${listCategory}" var="Category">
      <h1>${Category.name}</h1>
      <div style="margin-left: 50px;"  class="row">
          <c:forEach items="${listCourse}" var="Course">
              <c:if test="${Course.id_category == Category.id }">
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
                    <p class="small text-muted">${Category.name}</p>
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
                    <c:if test="${Course.price==0}"> 
                        <h6>Free</h6>
                    </c:if>
                    <c:if test="${Course.price>0}">                 
                        <h6>$${Course.price}</h6>
                    </c:if>
                  
                </div>         
              </div>
              <hr class="my-0" />
              <div class="card-body">
                <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
                  <p href="#!" class="text-dark fw-bold"></p>
                  <a href="./addCart?id_course=${Course.id}" type="button" class="btn btn-primary">Add To Cart</a>
                </div>
              </div>
            </div>
            </div>
            <!--course -->
            </c:if>
        </c:forEach> 


      </div>
    </c:forEach> 
        </c:if> 
      <c:if test="${id_category!=null}">
          <c:forEach items="${listCategory}" var="Category">
              <c:if test="${id_category==Category.id}">
              <h1>${Category.name}</h1>
            </c:if>
      <div style="margin-left: 100px;"  class="row">
          <c:forEach items="${listCourse}" var="Course">
              
              <c:if test="${Course.id_category == Category.id &&Category.id==id_category}">
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
                    <p class="small text-muted">${Category.name}</p>
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
                    <c:if test="${Course.price==0}"> 
                        <h6>Free</h6>
                    </c:if>
                    <c:if test="${Course.price>0}">                 
                        <h6>$${Course.price}</h6>
                    </c:if>
                  
                </div>         
              </div>
              <hr class="my-0" />
              <div class="card-body">
                <div class="d-flex justify-content-between align-items-center pb-2 mb-1">
                  <p href="#!" class="text-dark fw-bold"></p>
                   <a href="./addCart?id_course=${Course.id}" type="button" class="btn btn-primary">Add To Cart</a>
                </div>
              </div>
            </div>
            </div>
            <!--course -->
            </c:if>
        </c:forEach> 


      </div>
    </c:forEach> 
        </c:if> 
  </div>
</section>


