<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TODO Application</title>
<link href="webjars/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet">
<link href="style.css" rel="stylesheet"> 
</head>
<body>

 <div id="login">
        <h3 class="text-center text-white pt-5">Welcome to TODO Application</h3>
        <div class="container">
        
            <div id="login-row" class="row justify-content-center align-items-center">
            
                <div id="login-column" class="col-md-6">
                    <div id="login-box" class="col-md-12">
                        <form id="login-form" class="form" method="post">
                            <h3 class="text-center text-info">Login</h3>
                 			<font color="red">${errorMessage}</font>        
                            <div class="form-group">
                                <label for="username" class="text-info">Username:</label><br>
                                <input type="text" name="username" id="username" class="form-control">                          		
                            </div>
                            <div class="form-group">
                                <label for="password" class="text-info">Password:</label><br>
                                <input type="password" name="password" id="password" class="form-control">
                            </div>
                            <div class="form-group">
                                <!-- <label for="remember-me" class="text-info"><span>Remember me</span> <span><input id="remember-me" name="remember-me" type="checkbox"></span></label><br> -->
                                <input type="submit" name="submit" class="btn btn-info btn-md" value="Submit">
                            </div>
                           <!--  <div id="register-link" class="text-right">
                                <a href="#" class="text-info">Register here</a>
                            </div> -->
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>


<script src="webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.6.0/js/bootstrap.min.js"></script>
</body>
</html>