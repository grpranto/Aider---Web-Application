<!DOCTYPE html>
<html>
    <head>
        <title>Home</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="w3.css">
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
              
              li a {
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            background-color: white;
            font-family: cursive;
         }

         li a:hover:not(.active) {
            background-color: #cbd3cb;
         }

         .active {
            background-color: #0e6787;
            color: #FFFFFF;
            font-family: cursive;
         }
         
         ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
            overflow: hidden;
            background-color: #FFFFFF;
            font-family: cursive;
        }

        li {
          float: left;
        }
        
        
           
        </style>
        
    </head>
    <body >
        <div style="background-color:#E7EDEE;padding-bottom: 15px">
        <ul>
            <li><a href="courseAll" class="active">Available Courses</a></li>
            <li><a href="currentCourses">Enrolled Courses</a></li>
            <li style="float: right;background-color: red;color:#FFFFFF"><a href="index.html">Log Out</a></li>
            
       </ul>
        
        
     
      
    </body>
    <footer style="font-size: 13px; margin: 5px">
        <p><i>Author: GR Pranto</i></p>
        <p><a href="mailto:grpranto@gmail.com" style="color:blue"><i>Contact</i></a></p>
    </footer>
    
    
    
    
</html>


