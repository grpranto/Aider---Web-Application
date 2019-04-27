<%-- 
    Document   : facultyHome
    Created on : Feb 28, 2019, 6:41:19 PM
    Author     : GR Pranto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <style>
            html, body {
                height: 100%;
                margin:0;
            }
            .first {
                float:left;
                width:50%;
                height:100%;
                background-color: #0a4282;
                text-decoration: none;
            }
            .second{
                float:right;
                width:50%;
                height:100%;
                background-color: #ce6350;
                text-decoration: none;
            }
            .frm1{
                padding:300px;
                text-align: center;
                font-size: 70px;
                color:white;
            }
            .frm1:hover{
                font-size: 85px;
                background-color:#062a54;
                transition: all .6s ease;
                -webkit-transition: all .8s ease;
            }
            .frm2{
                padding:300px;
                text-align: center;
                font-size: 70px;
                color:white;
            }
            .frm2:hover{
                font-size: 85px;
                background-color:#a8240d;
                transition: all .6s ease;
                -webkit-transition: all .8s ease;
            }
            
            body {
                    background-image: url("studentHome.jpg");
                    background-size:cover;
                    background-repeat:no-repeat;
                    background-attachment: fixed;
                    
            }
            h1{
                  text-align: center;
                  color:#D4D3D9;
                  font-family: cursive;
                  font-size: 28px;
                  margin-bottom: 120px
             }
            .button {
                font: 23px cursive;
                text-decoration: none;
                background-color: #075b75;
                color: #FFFFFF;
                padding: 8px 12px 8px 12px;
                border-top: 1px solid ;
                border-right: 1px solid ;
                border-bottom: 1px solid ;
                border-left: 1px solid ;
                cursor:pointer;
                
              }
              .button:hover{
                background-color: #F7630C;
                color: #FFFFFF;
                transition: 0.5s ease-in;
              }
           
        </style>
    </head>
    
    <body style="margin-top: 30px">
        <a href="index.html" style="margin-left:1200px;margin-bottom: 25px;font-size:15px;" class="button">Log Out</a>
        <form action="courses_fac" method="post" enctype="multipart/form-data" style="margin-bottom:20px;margin-top: 200px">
            <input type="submit" value="Courses" class="button" style="margin-left: 550px;width: 200px">
        </form>
        <a href="addCourse.jsp" class="button" style="margin-top: 200px;margin-left:550px;width: 200px">Add Course</a>
        <form action="attendanceHome" method="post" senctype="multipart/form-data">
            <input type="submit" value="Take attendance" class="button" style="margin-left: 550px;margin-top: 25px">
        </form>
      
        
        
    </body>
</html>
