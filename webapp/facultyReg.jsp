
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registration</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

	<style type="text/css">
                body {
                    background-image: url("background.jpg");
                    background-size:cover;
                    background-repeat:no-repeat;
                    background-attachment: fixed;
                    
                 }
		span{
			color: red;
		}
		p{
			margin: 4px;
		}
		div{
			padding: 10px;
		}

		span.horizontal{
			margin-top: 0px;
		}
		form.sign input{
			display: block;
			border-radius: 5px;
			border-width:1px;
			padding:3px;
			text-decoration: none;font-weight: normal;
			width:280px;
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
        .closebtn:hover {
            color: black;
        }
        .closebtn {
            margin-left: 15px;
            color: white;
            font-weight: bold;
            float: right;
            font-size: 22px;
            line-height: 20px;
            cursor: pointer;
            transition: 0.3s;
        }
        .alert {
            padding: 5px;
            margin-bottom: 15px;
            background-color: #f44336;
            color: white;
            
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
<body style="margin-top: 0px ; margin-right: 0px ; margin-left: 0px">
    
        <ul>
            <li><a  href="index.html">Home</a></li>
            <li><a href="facultyLogin.jsp" >Log In</a></li>
            <li><a href="facultyReg.jsp" class="active">Register</a></li>
            <li><a href="forgotFaculty.jsp">Forgot Password?</a></li>
            
        </ul>

	<div style="display: block;text-align: center;">
		<fieldset style="width: 150px; margin: auto; padding-right: 80px;padding-left: 80px; padding-top: 20px;padding-bottom: 20px; border-radius: 6px;border-color: #F69483; border-width: .5px;  background-color:#FFFFFF">
			<img src="faculty2.png" style="text-align: center; height: 100px; width: 100px;margin-bottom: 30px;"><br>
			<form name="form" onsubmit="return validate(document.form.email, document.form.pass, document.form.confirmPass);" action="facultyReg" method="post" style="display: inline-block;margin-left: auto;margin-right: auto;text-align: left;" class="sign" enctype="multipart/form-data">
                            <input type="text" name="name" placeholder="🤵🏻  Name" required><br>
                                <input type="text" name="email" placeholder="✉️ Email" required><br>
                                <div class="alert" style="display: none;" id="emailJav">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                    Invalid email format<br>
                                </div>
				<input type="password" name="pass" placeholder="🔒 Password" required><br>	
                                <div class="alert" style="display: none;" id="passJav">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                    Minimum 5 letters needed<br>
                                </div>
				<input type="password" name="confirmPass" placeholder="🔒 Confirm Password" required><br>
                                <div class="alert" style="display: none;" id="confirmPassJav">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                    Minimum 5 letters needed<br>
                                </div>
                                
                                <div class="alert" style="display: none;" id="matchJav">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                    Passwords don't match<br>
                                </div>
				<input type="text" name="institution" placeholder="🏚 Institution Name" required><br>
                                <input type="text" name="dept" placeholder="🏡 Department" required><br>
                                <input type="text" name="designation" placeholder="🏚 Designation" required><br>
                                <input type="text" name="phone" placeholder="📱 Phone Number" required><br>
                                <input type="text" name="secret" placeholder="🍩 What's your favourite food?" required><br>
                                📸 Upload Your Photo (optional) <input type="file" name="photo" id="pic"><br>
                                <div class="alert" style="display: none;" id="photoJav">
                                    <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                                    Selected file is not an image<br>
                                </div>
				<input type="submit" value="Sign Up" class="bt">
			</form>
		</fieldset>
		
	</div>
    <script>
    function validate(inputText, pass, confirmPass){
        var checkEmail = 1;
        var checkLen = 1;
        var checkMatch = 1;
        var final = 1;
        var checkImage = 1;
        var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        if(!inputText.value.match(mailformat)){
           checkEmail = 0;
        }
        
        var len = pass.value.length;
        var len1 = confirmPass.value.length;
        
        if(len>=5 && len1>=5){
            if(pass.value != confirmPass.value){
                checkMatch = 0;
            }
        }
        else{
            checkLen = 0;
        }
        
        
        if(checkEmail==0 || checkLen==0 || checkMatch==0){
            if(checkEmail==0 && checkLen==0 && checkMatch==0){
                //ei condition e porbe nah
            }
            else if(checkEmail==0 && checkLen==0){
                var mySpan2 = document.getElementById('emailJav');
                mySpan2.style.display = "block";
                var mySpan = document.getElementById('passJav');
                mySpan.style.display = "block";
                
            }
            else if(checkEmail==0 && checkMatch==0){
                var mySpan2 = document.getElementById('emailJav');
                mySpan2.style.display = "block";
                
                var mySpan3 = document.getElementById('matchJav');
                mySpan3.style.display = "block";
                
            }
            else if(checkLen==0 && checkMatch==0){
                //ei condition e porbe na
            }
            else if(checkEmail==0){
                 var mySpan2 = document.getElementById('emailJav');
                 mySpan2.style.display = "block";
            }
            else if(checkLen==0){
               // alert("Password should contain at least 5 letter");
               if(len == 0 && len1==0){
                    var mySpan = document.getElementById('passJav');
                    mySpan.style.display = "block";
                    var mySpan1 = document.getElementById('confirmPassJav');
                    mySpan1.style.display = "block";
                }
                else if(len == 0){
                    var mySpan = document.getElementById('passJav');
                    mySpan.style.display = "block";
                }
                else{
                    var mySpan1 = document.getElementById('confirmPassJav');
                    mySpan1.style.display = "block";
                }
            }
            else if(checkMatch==0){
                var mySpan3 = document.getElementById('matchJav');
                mySpan3.style.display = "block";
            }
            
            final = 0;
        }
        
            if(checkEmail==1 && checkLen==1){
                var mySpan2 = document.getElementById('emailJav');
                mySpan2.style.display = "none";
                var mySpan = document.getElementById('passJav');
                mySpan.style.display = "none";
                
            }
            else if(checkEmail==1 && checkMatch==1){
                var mySpan2 = document.getElementById('emailJav');
                mySpan2.style.display = "none";
                
                var mySpan3 = document.getElementById('matchJav');
                mySpan3.style.display = "none";
                
            }
            else if(checkLen==1 && checkMatch==1){
                var mySpan = document.getElementById('passJav');
                mySpan.style.display = "none";
                var mySpan1 = document.getElementById('confirmPassJav');
                mySpan1.style.display = "none";
                
                var mySpan3 = document.getElementById('matchJav');
                mySpan3.style.display = "none";
                
            }
            else if(checkEmail==1){
                 var mySpan2 = document.getElementById('emailJav');
                 mySpan2.style.display = "none";
            }
            else if(checkLen==1){
               
                    var mySpan = document.getElementById('passJav');
                    mySpan.style.display = "none";
                    var mySpan1 = document.getElementById('confirmPassJav');
                    mySpan1.style.display = "none";
                
            }
            else if(checkMatch==1){
                var mySpan3 = document.getElementById('matchJav');
                mySpan3.style.display = "none";
            }
            
        var fileInput = document.getElementById('pic');
        var filePath = fileInput.value;
        var allowedExtensions = /(\.jpg|\.jpeg|\.png|\.gif)$/i;
        if(fileInput.files.length == 0){
            var mySpan2 = document.getElementById('photoJav');
            mySpan2.style.display = "none";
        }
        else if(!allowedExtensions.exec(filePath)){
            final = 0;
            var mySpan1 = document.getElementById('photoJav');
            mySpan1.style.display = "block";
        }   
        else{
            var mySpan2 = document.getElementById('photoJav');
            mySpan2.style.display = "none";
        }
            
            
        if(final == 1){
            return true;
        }
        else{
            return false;
        }
    }
    </script>
</body>

<footer style="font-size: 13px; margin: 5px;background-color: white">
        <p><i>Author: GR Pranto</i></p>
        <p><a href="mailto:grpranto@gmail.com" style="color:blue;"><i>Contact</i></a></p>
</footer>

</html>