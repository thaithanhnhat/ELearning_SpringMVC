<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="./assets/img/undraw_remotely_2j6y.svg" alt="sing up image"></figure>
                        <a href="login" class="signup-image-link">Login account</a>
                    </div>
                    
                    <div class="signin-form">
                        <h2 class="form-title">Register</h2>
                         <c:if test="${error_user!= null}"> 
                                        <p style="color: red;">${error_user}</p>
                         </c:if>
                        <form method="POST" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="name" id="your_name" placeholder="Your Name"/>
                                <c:if test="${error_name!= null}"> 
                                        <p style="color: red;">${error_name}</p>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="email" id="your_name" placeholder="Email"/>
                                <c:if test="${error_email!= null}"> 
                                        <p style="color: red;">${error_email}</p>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="number" name="phone" id="your_name" placeholder="Phone number"/>
                                <c:if test="${error_phone!= null}"> 
                                        <p style="color: red;">${error_phone}</p>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" id="your_pass" placeholder="Password"/>
                                <c:if test="${error_password!= null}"> 
                                        <p style="color: red;">${error_password}</p>
                                </c:if>
                                
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="repassword" id="your_pass" placeholder="Confirm Password"/>
                                <c:if test="${error_repassword!= null}"> 
                                        <p style="color: red;">${error_repassword}</p>
                                </c:if>
                            </div>
                            
                            
                            
                            
                            
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="register" id="signin" class="form-submit" value="Register"/>
                            </div>
                        </form>
                       
                    </div>
                </div>
            </div>
        </section>