<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
   
<section class="h-100 h-custom" ">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
          <div class="card-body p-0">
            <div class="row g-0">
              <div class="col-lg-8">
                <div class="p-5">
                  <div class="d-flex justify-content-between align-items-center mb-5">
               
                    <h1 class="fw-bold mb-0 text-black">Your Order</h1>          
                    <h6 class="mb-0 text-muted">${listCart.size()} Course</h6>
                  </div>   
                         
                              <hr class="my-4">
                              <c:forEach items="${listCart}" var="Cart">
                                  <c:forEach items="${listCourse}" var="Course">
                                      <c:if test="${Cart.id_course == Course.id}">
                              <div class="row mb-4 d-flex justify-content-between align-items-center">
                              <div class="col-md-2 col-lg-2 col-xl-2">
                                  <img
                                  src="./assets/img/${Course.img}"
                                  class="img-fluid rounded-3" alt="Cotton T-shirt">
                              </div>
                              <div class="col-md-3 col-lg-3 col-xl-3">
                                <h6 class="text-black mb-0">${Course.name}</h6>
    
                              </div>
                              <div class="col-md-3 col-lg-3 col-xl-2 d-flex">                                                     
                              </div>
                              <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                                <h6 class="mb-0">$${Course.price}</h6>
                              </div>

                              <form action="" method="POST" class="col-md-1 col-lg-1 col-xl-1 text-end">
                                 <input type="hidden" name="delete" value="${Course.id}">
                                <button type="submit" class="btn-close text-reset" data-bs-dismiss="offcanvas" aria-label="Close"></button>
                              </form>
                              </div>
                              </c:if>
                              </c:forEach>
                              </c:forEach> 
                      

          
                                
                              <hr class="my-4">   
                  
                  
                  <!-- done order -->
                  
             
                
                </div>
              </div>
              <div class="col-lg-4 bg-grey">
                <div class="p-5">
                  <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                  <hr class="my-4">
                  
                  <div >
                      <img style="height: 80px;width: 120px" src="https://trustweb.vn/wp-content/uploads/2016/11/the-napas-la-gi-cong-thanh-toan-napas-la-gi-2411-7383.png" alt="alt"/>
                      <img style="height: 50px;width: 180px" src="https://rentacarnafplio.gr/wp-content/uploads/2019/04/visa_mastercard.png" alt="alt"/>
                  </div>
                    
                  <h5 class="text-uppercase mb-3">Payments Method</h5>
                   
                   <div class="mb-4 pb-2">
                        <select style="width: 50%;height: 50px;" class="select" id="bankSelect">
                            <option  value="">Choose method</option>
                        </select>
                    </div>
                   

                  <hr class="my-4">
                    
                  
                  
                  
                  
                  
                  
                  <div class="d-flex justify-content-between mb-5">
                    <h5 class="text-uppercase">Total price</h5>
                    <h5 id="sumprice">$${sumCart}</h5>
                  </div>
                  <form method="POST" action="ordered">
                      <input type="hidden" name="carttoordered" value="doneorder">
                      <button type="submit" class="btn btn-dark btn-block btn-lg"
                      data-mdb-ripple-color="dark">Payments</button>
                  </form>
                  
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
   
          
