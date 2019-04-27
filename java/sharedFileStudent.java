import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class sharedFileStudent extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");       
        PrintWriter out = response.getWriter();
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            String email = request.getParameter("facEmail");
            String code = request.getParameter("code");
            PreparedStatement ps = conn.prepareStatement("select * from file where facEmail=? and code=?");
            ps.setString(1, email);
            ps.setString(2, code);
            ResultSet rs = ps.executeQuery();
            //out.println("heyyy");
            
            /*Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM course");*/
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Example</title>");
            out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
            out.println("<style>\n" +
            ".card {\n" +
            "  box-shadow: 0 4px 8px 0 rgba(0,0,0,0.2);\n" +
            "  transition: 0.3s;\n" +
            "  width: 50%;\n" +
            "}\n" +
            "\n" +
            ".card:hover {\n" +
            "  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);\n" +
            "}\n" +
            "\n" +
            
            ".container {\n" +
            "  padding: 2px 16px;\n" +
            "}\n" +
                    
             "li a {\n" +
"            display: block;\n" +
"            color: black;\n" +
"            text-align: center;\n" +
"            padding: 14px 16px;\n" +
"            text-decoration: none;\n" +
"            background-color: white;\n" +
"            font-family: cursive;\n" +
"         }\n" +
"\n" +
"         li a:hover:not(.active) {\n" +
"            background-color: #FFFFFF;\n" +
"         }\n" +
"\n" +
"         .active {\n" +
"            background-color: #0e6787;\n" +
"            color: #FFFFFF;\n" +
"            font-family: cursive;\n" +
"         }\n" +
"         \n" +
"         ul {\n" +
"            list-style-type: none;\n" +
"            margin: 0;\n" +
"            padding: 0;\n" +
"            overflow: hidden;\n" +
"            background-color: #FFFFFF;\n" +
"            font-family: cursive;\n" +
"        }\n" +
"\n" +
"        li {\n" +
"          float: left;\n" +
"        }"+
                    "            .button {\n" +
"                font: 12px cursive;\n" +
"                text-decoration: none;\n" +
"                \n" +
"                color: #f7f9f7;\n" +
"                padding: 8px 12px 8px 12px;\n" +
                    "                background-color: #0E6787;\n" +
"                border-top: 1px solid ;\n" +
"                border-right: 1px solid ;\n" +
"                border-bottom: 1px solid ;\n" +
"                border-left: 1px solid ;\n" +
"                \n" +
"              }\n" +
"              .button:hover{\n" +
"                background-color: #F7630C;\n" +
"                color: #FFFFFF;\n" +
"                transition: 0.5s ease-in;\n" +
"              }"+
                    "li a {\n" +
"            display: block;\n" +
"            color: black;\n" +
"            text-align: center;\n" +
"            padding: 14px 16px;\n" +
"            text-decoration: none;\n" +
"            background-color: white;\n" +
"            font-family: cursive;\n" +
"         }\n" +
"\n" +
"         li a:hover:not(.active) {\n" +
"            background-color: #cbd3cb;\n" +
"         }\n" +
"\n" +
"         .active {\n" +
"            background-color: #0e6787;\n" +
"            color: #FFFFFF;\n" +
"            font-family: cursive;\n" +
"         }\n" +
"         \n" +
"         ul {\n" +
"            list-style-type: none;\n" +
"            margin: 0;\n" +
"            padding: 0;\n" +
"            overflow: hidden;\n" +
"            background-color: #FFFFFF;\n" +
"            font-family: cursive;\n" +
"        }\n" +
"\n" +
"        li {\n" +
"          float: left;\n" +
"        }"+
                    
            "</style>");
            out.println("</head>");
            out.println("<body style=\"margin:0px\">");
            out.println("<ul style=\"\">\n" +
                        "            <li><a href=\"courseAll\" >Available Courses</a></li>\n" +
                        "            <li><a href=\"currentCourses\">Enrolled Courses</a></li>\n" +
                        "            <li><a href=\"#\" class=\"active\">Download</a></li>\n" +
                        "            <li style=\"float: right;\"><a href=\"index.html\" style=\"background-color: #b72424;color:#FFFFFF\">Log Out</a></li>\n" +
                        "            \n" +
                        "       </ul>");
            
            out.println("<div style=\"background-color:#E7EDEE;margin-bottom:20px\">");
            out.println("<marquee direction=\"left\" style=\"margin-bottom:20px;color:red\">If faculty did not share anything then this section will be empty</marquee>");
            out.println("<div style=\"margin-left:500px;\">");
            while (rs.next()) {
                String name = rs.getString("fileName");
               
                /*out.println("<span>" + mail + "</span>" + "<br>");
                out.println("<span>" + name + "</span>" + "<br>");
                out.println("<span>" + code + "</span>" + "<br>");
                out.println("<span>" + sec + "</span>" + "<br>");
                out.println("<span>" + key + "</span>" + "<br>");*/
                
                out.println("<div class=\"card\">\n" +
                "  <div class=\"container\" style=\"color:black;background-color:#FFFFFF\">\n" +
                "<form action=\"downloadFac\" method=\"POST\" senctype=\"multipart/form-data\" >\n"+
                "    <p>" + name + "</p> \n" +
                "<input type=\"text\" name=\"name\" value="+name+" style=\"display:none\">"+
                "<input type=\"submit\" value=\"&#8681 Download\" class=\"button\" style=\"cursor:pointer\">\n" +
                "</form>"+
                //"    <p><a href=\"downloadFac?name="+name+"\">" + name + "</a></p> \n" +
                /*"    <p><b>Course Code: </b>" +code + "</p> \n" +
                "    <p><b>Section: </b>" +sec + "</p> \n" +
                "    <p><b>Enrol Key: </b>" +key + "</p> \n" +
                "<form action=\"facultyMarks\" method=\"POST\" senctype=\"multipart/form-data\" >\n"+
                "<input type=\"text\" name=\"code\" value="+code+" style=\"display:none\">"+
                "<input type=\"text\" name=\"sec\" value="+sec+" style=\"display:none\">"+
                "<input type=\"text\" name=\"key\" value="+key+" style=\"display:none\">"+
                "<input type=\"submit\" value=\"Attendance Marks\">\n" +
                "</form>"+
                        
                "<p><b><button><a href=\"shareFile.jsp?email="+email+"&code="+code+"&sec="+sec+"\" style=\"text-decoration:none\">Upload a File</a></button></b></p> \n" +
                     */   
                "  </div>\n" +
                "</div>");
                out.println("<br>");
            }
            out.println("</div>");
            out.println(" <footer style=\"font-size: 13px; margin: 0px;background-color:white\">\n" +
"        <p><i>Author: GR Pranto</i></p>\n" +
"        <p><a href=\"mailto:grpranto@gmail.com\" style=\"color:blue\"><i>Contact</i></a></p>\n" +
"    </footer>");
            out.println("</body>");
            out.println("</html>");
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            //out.println(title);
        }
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    

}
