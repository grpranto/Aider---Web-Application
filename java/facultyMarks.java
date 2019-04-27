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
public class facultyMarks extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");       
        PrintWriter out = response.getWriter();
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            HttpSession session = request.getSession();
            String email = session.getAttribute("facultyEmail").toString();
            String code = request.getParameter("code");
            String sec = request.getParameter("sec");
            String key = request.getParameter("key");
            String name = "";
            PreparedStatement ps = conn.prepareStatement("select * from marks where facultyEmail=? and courseCode=? and sec=? and enrolKey=?");
            ps.setString(1, email);
            ps.setString(2, code);
            ps.setString(3, sec);
            ps.setString(4, key);
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
                        "            <li><a href=\"courses_fac\" >Courses</a></li>\n" +
                        "            <li><a href=\"attendanceHome\">Take Attendance</a></li>\n" +
                         "            <li><a href=\"addCourse.jsp\">Add Course</a></li>\n" +
                          "            <li><a href=\"#\" class=\"active\">Marks</a></li>\n" +
                         
                        "            <li style=\"float: right;\"><a href=\"index.html\" style=\"background-color: #b72424;color:#FFFFFF\">Log Out</a></li>\n" +
                        "            \n" +
                        "       </ul>");
            
            out.println("<div style=\"background-color:#E7EDEE;margin-bottom:20px\">");
            out.println("<div style=\"margin-left:500px;\">");
            while (rs.next()) {
                //String codee = rs.getString("courseCode");
                String totalClass = rs.getString("total");
                String marks = rs.getString("totalMark");
                String stEmail = rs.getString("studentMail");

                
                try{
                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                    PreparedStatement ps1 = conn.prepareStatement("select name from student1 where email=? ");
                    ps1.setString(1, stEmail);
                    
                    ResultSet rs1 = ps1.executeQuery();
                    
                    while(rs1.next()){
                        name = rs1.getString("name");
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                finally{
                    
                }
                
                
                out.println("<div class=\"card\">\n" +
                "  <div class=\"container\" style=\"color:black;background-color:#FFFFFF\">\n" +
                "    <p><b>" +name + "</b></p> \n" +
                "    <p>Total class attended: " +totalClass + "</p> \n" +
                "    <p>Marks: " +marks + "</p> \n" +
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
