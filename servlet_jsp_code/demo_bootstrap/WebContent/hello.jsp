<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>
 <h1>crud application</h1>
        </br>
        <div class="row">
            <div class="col-sm-4">
                <form  method="POST" action="#" > 
                    
                    <div alight="left">
                        <label class="form-label">Student Name</label>
                        <input type="text" class="form-control" placeholder="Student Name" name="sname" id="sname" required >
                     </div>
                         
                    <div alight="left">
                        <label class="form-label">Course</label>
                        <input type="text" class="form-control" placeholder="Course" name="course" id="course" required >
                     </div>
                         
                     <div alight="left">
                        <label class="form-label">Fee</label>
                        <input type="text" class="form-control" placeholder="Fee" name="fee" id="fee" required >
                     </div>
                         </br>
                         
                     <div alight="right">
                         <input type="submit" id="submit" value="submit" name="submit" class="btn btn-info">
                         <input type="reset" id="reset" value="reset" name="reset" class="btn btn-warning">
                     </div>  
                         
                </form>
            </div>
            
             <div class="col-sm-8">
                 <div class="panel-body">
                     <table id="tbl-student" class="table table-responsive table-bordered" cellpadding ="0" width="100%">
                         <thead>
                             <tr>
                                    <th>Student Name</th>
                                    <th>Course</th>
                                    <th>Fee</th>
                                    <th>Edit</th>
                                    <th>Delete</th>
                             </tr>  
                             
           
                             <tr>
                                 <td>raj</td>
                                 <td>MTech</td>
                                 <td>1200</td>
                                 <td><a href="edit">Edit</a></td>
                                 <td><a href="delete">Delete</a></td>
                             </tr> 
                             
                            
                     </table>    
                 </div>

            </div>  
        </div>

</body>
</html>