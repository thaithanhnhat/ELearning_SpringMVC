<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<section style="background-color: #f6f5f5;border-radius: 20px; margin-top: 20px;"> 
    <form action="SaveCourse" method="POST" enctype="multipart/form-data">
     <div class="collapse" id="navbarToggleExternalContent" data-bs-theme="dark">
     <div class="bg-light p-5">
        <div class="input-group mb-3">       
            <input name="name" type="text" class="form-control" placeholder="Name course"  aria-describedby="button-addon1">
         </div>   
         <div class="input-group mb-3">       
             <label>Choose image</label>
         </div> 
         <div class="input-group mb-3">       
             <input name="img" type="file" class="form-control" placeholder="Name course"  aria-describedby="button-addon1">
         </div>
          <div class="input-group mb-3">
              <select name="id_category" class="form-select" id="inputGroupSelect01">
              <option selected>Category</option>
              <option value="1">Front end</option>
              <option value="2">Back End</option>
              <option value="3">Review</option>
           </select>             
          </div>
          <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="addon-wrapping">$</span>
                    <input name="price" value="${Course.price}" type="text" class="form-control" placeholder="courseprice" aria-label="coursename" aria-describedby="addon-wrapping">
                  </div>
        <div class="input-group mb-3">
         
            <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Add</button>
        </div>
      </div>

    </div>
      <nav style="background-color: transparent" class="navbar ">
      <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarToggleExternalContent" aria-controls="navbarToggleExternalContent" aria-expanded="false" aria-label="Toggle navigation">
         <i class="bi bi-plus-circle"> Add course</i>
        </button>
      </div>
   </form>
      
</nav>
    <div style="margin-left: 50px;" class="container py-5">
          <c:forEach items="${listCourse}" var="Course">      
            <!--course -->
            <div   class="container">
         <div style="margin-top: 30px;" class="row">
    <div class="col-md-6">
      <!-- Course information -->
      <div class="card">
        <!-- Course content -->
        <img src="./assets/img/${Course.img}" class="img-fluid" alt="Course Image">
        
        <!-- ... other course details -->
        
            <div class="input-group flex-nowrap">
                <h5 style="color:black ">${Course.name}</h5>
              </div>
               <div class="input-group flex-nowrap">
                    <h5 style="color:black">${Course.price}</h5>
          
              </div>                  
         <div class="course-price">   
   
                
             <a href="./EditCourse?id_course=${Course.id}"  class="btn btn-danger" type="submit">Delete</a>  
     
                   
        </div>
        <!-- ... other course elements -->
        
      </div>
    </div>
        <div  class="col-md-6">
      <!-- Scrollable list of numbers -->
      <div style="height: 400px;" class="numbers-list">
        <div class="list-group">
          <!-- Numbers from 1 to 50 (example range) -->
          <!-- Adjust the range or content as needed -->
           <button onclick="showForm('', '','',0,${Course.id})" type="button" class="list-group-item list-group-item-action"><i style="color: #33ff33" class="bi bi-plus-circle-fill">Add video</i></button>
          <c:forEach items="${listVideo}" var="video">
              <c:if test="${Course.id == video.id_course}">             
              <button style="height: 100px;" onclick="showForm('${video.title}', '${video.describe}', '${video.url_video}','${video.id}','${video.id_course}')" type="button" class="list-group-item list-group-item-action">${video.title}
                  <form action="deletevideo" method="POST">
                      <input type="hidden" name="delete_idvideo" value="${video.id}">
                      <button id="btndelete" style="background: white; border: 1px solid #ff3333; border-top:0px none;" ><i style="color: #ff3333;" class="bi bi-trash3-fill"></i></button>
                  </form>
              </button>
          </c:if>
          </c:forEach>
                
        </div>
      </div>
    </div>
  </div>
</div>

<!-- Form container (initially hidden) -->
<div class="centered-form" id="formContainer" style="display: none;">
          <form action="saveanddelete" method="POST"  class="row g-3">
          <div class="col-md-4">
              <input name="title" placeholder="title video" title="title video" type="text" class="form-control" id="validationDefault01"  required>
          </div>
          <div class="col-md-4">
            <div class="input-group">  
                <input name="url_video" placeholder="url-video" type="text" title="url video" class="form-control" id="validationDefaultUsername" aria-describedby="inputGroupPrepend2" required">
                <input type="hidden" name="id_video" id="id_video">
                
                <input placeholder="id_course" type="hidden" name="id_course" id="id_course" class="form-control" aria-describedby="inputGroupPrepend2">

                   
            </div>
          </div>
          <div class="col-md-12">
            <input name="describe" placeholder="describe video" type="text" class="form-control" id="validationDefault03" required>
          </div>
       
          <div class="col-12">
              <button  class="btn btn-primary" type="submit">Save</button>
          </div>
</form>  
            <button onclick="hidentForm()" type="button" class="btn btn-warning">Cancel</button>
</div>
  </c:forEach> 
<script>
  function showForm(title, description, videoUrl,id_video,id_course) {
    var formContainer = document.getElementById('formContainer');
    formContainer.style.display = 'block'; 
    document.getElementById('id_video').value = id_video;
    document.getElementById('id_course').value = id_course;
    document.getElementById('validationDefault01').value = title;
    document.getElementById('validationDefault03').value = description;
    document.getElementById('validationDefaultUsername').value = videoUrl;
  }

  function hidentForm() {
    var formContainer = document.getElementById('formContainer');
    formContainer.style.display = 'none'; // Ẩn form container
  }
</script>


            <!--course -->
      


      </div>

  </div>
</section>


