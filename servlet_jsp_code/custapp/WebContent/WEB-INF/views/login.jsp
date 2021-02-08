<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer application</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

${param.error}<br>
${param.message }<br>
<br>
<div class="row">
            <div class="col-sm-4">
                <form  method="POST" action="loginController" > 
                    
                    <div alight="center">
                        <label class="form-label">Enter user name </label>
                        <input type="text" class="form-control"  name="username" id="username" required >
                     </div>
                         
                    <div alight="center">
                        <label class="form-label">Enter password</label>
                        <input type="text" class="form-control"  name="password" id="password" 					required >
                     </div>

	              <div alight="center">
                         <input type="submit" id="submit" value="submit" name="submit" class="btn btn-info">
                         <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">
                     </div>  
       
                </form>
            </div>
</div>
</body>
</html>