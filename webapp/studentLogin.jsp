<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Student Log In</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<style type="text/css">
		span{
			color: red;
		}
		p{
			margin: 4px;
		}
		div{
			padding: 10px;
		}
		

		span.require{
			color: red;
			font-size: 75%;
		}
		span.horizontal{
			margin-top: 0px;
		}
		form.sign input{
			display: block;
			border-radius: 5px;
			border-width:1px;
			padding:5px;
			text-decoration: none;font-weight: normal;
		}
		
		
		.bt{
        	color:#FFFFFF;
        	font-weight: normal;
        	font-family: Comic Sans MS;
        	padding: 6 6 6 6;
        	border-radius: 5px;
        	border: 1px solid #0e6787;
        	background-color: #0e6787;
        	width:215px;
        	font-weight:bold;
         }

        .bt:hover{
        	color:#ffffff;
        	background-color: #001a66;
        	transition: all .5s ease-out;
        	background-position: left bottom;
        }
        .forgot{
            text-decoration: none;font-weight: normal;font-family: Comic Sans MS;color:#0e6787;
        }
        .forgot:hover{
            color:#001a66;
        	transition: all .5s ease-out;
        	background-position: left bottom;
        }
        .noAccount{
            text-decoration: none;font-weight: normal;font-family: Comic Sans MS;color:#0e6787;
        }
        .noAccount:hover{
            color:#001a66;
        	transition: all .5s ease-out;
        	background-position: left bottom;
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
<body style="margin-top: 0px ; margin-right: 0px ; margin-left: 0px;">
        
        <ul>
            <li><a  href="index.html">Home</a></li>
            <li><a href="studentLogin.jsp" class="active">Log In</a></li>
            <li><a href="studentReg.jsp">Register</a></li>
            <li><a href="forgotStudent.jsp">Forgot Password?</a></li>
            
       </ul>

	<div style="display: block;text-align: center; background-color:#E7EDEE">
		<fieldset style="width: 180px; margin: auto; padding: 20px; border-radius: 6px;border-color: #F69483; border-width: .5px;  background-color:#FFFFFF">
			<img src="student2.png" style="text-align: center; height: 100px; width: 100px;margin-bottom: 30px;"><br>
			<form action="studentLogin" method="post" style="display: inline-block;margin-left: auto;margin-right: auto;text-align: center;" class="sign" enctype="multipart/form-data">
                            <input type="text" name="email" placeholder="✉️ Email" required>
                                <span class="horizontal"></span><br>
					
				<input type="password" name="pass" placeholder="🔒 Password" required>
                                <span class="horizontal"></span><br>
					
				<input type="submit" value="Log In" class="bt"><br>
				<a href="forgotStudent.jsp" class="forgot">Forgot Password?</a><br><br>
				
				<span style="text-decoration: none;font-weight: normal;font-family: Comic Sans MS;color:black">No Account? </span><a href="studentReg.jsp" class="noAccount"><b>SIGN UP</b></a>
			</form>
		</fieldset>
		
	</div>
    
    <footer style="font-size: 13px; margin: 5px">
        <p><i>Author: GR Pranto</i></p>
        <p><a href="mailto:grpranto@gmail.com" style="color:blue"><i>Contact</i></a></p>
    </footer>
</body>
</html>