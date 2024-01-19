<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="content">
    <div class="container">
      <div class="row">
        <div class="col-md-6">
            <img src="./assets/img/undraw_remotely_2j6y.svg" alt="Image" class="img-fluid">
        </div>
        <div class="col-md-6 contents">
          <div class="row justify-content-center">
            <div class="col-md-8">
              <div class="mb-4">

              <h3>Sign In</h3>             
              <p class="mb-4"></p>
            </div>
            <form action="login" method="post">
              <div class="form-group first">
                <input placeholder="Email or Phone number" type="text" name="username" class="form-control" id="username">

              </div>
              <div class="form-group last mb-4">
               
                  <input placeholder="password" type="password" name="password" class="form-control" id="password">
                
              </div>
              
              <div class="d-flex mb-5 align-items-center">
                <label class="control control--checkbox mb-0"><span class="caption">Remember account </span>
                  <input type="checkbox" checked="checked"/>
                  <div class="control__indicator"></div>
                </label>
                  <span class="ml-auto"><a  style="text-decoration: none; color: blue;" href="register" class="forgot-pass"> Register</a></span> 
              </div>

              <input type="submit" value="Log In" class="btn btn-block btn-primary">

              <span class="d-block text-left my-4 text-muted">&mdash; or login with &mdash;</span>
              
              <div class="social-login">
                <a href="#" class="facebook">
                  <span class="bi bi-facebook fs-2"></span> 
                </a>
                <a href="#" class="twitter">
                  <span class="bi bi-twitter fs-2"></span> 
                </a>
                <a href="#" class="google">
                  <span class="bi bi-google fs-2"></span> 
                </a>
              </div>
            </form>
            </div>
          </div>
          
        </div>
        
      </div>
    </div>
  </div>

