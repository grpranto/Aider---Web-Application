<%-- 
    Document   : Error
    Created on : Mar 1, 2019, 11:03:12 AM
    Author     : GR Pranto
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="js/sweet2.js"></script>
    </head>
    <body onload="myFunction()">
    </body>
    <script>
        Swal.fire({
            type: 'success',
            title: 'Successfully Done!!',
            //text: 'Incorrect!!',
            showCloseButton: true,
            confirmButtonText:
            '<a href="facultyLogin.jsp" style="text-decoration:none; color:#FFFFFF">Go to Login Page</a>'
            //footer: '<a href="facultyLogin.jsp"><strong>Try Again</strong></a>'
        });
    </script>
</html>
