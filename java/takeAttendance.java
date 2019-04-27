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
public class takeAttendance extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");       
        PrintWriter out = response.getWriter();
        Connection conn = null;
        
        try{
            int i;
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            HttpSession session = request.getSession();
            String email = session.getAttribute("facultyEmail").toString();
            PreparedStatement ps = conn.prepareStatement("select * from course where email=?");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            //out.println("ayy");
            
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
            "  width: 40%;\n" +
            "}\n" +
            "\n" +
            ".card:hover {\n" +
            "  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);\n" +
            "}\n" +
            "\n" +
            ".container {\n" +
            "  padding: 2px 16px;\n" +
            "}\n" +
                    "#customers {\n" +
"  font-family: \"Trebuchet MS\", Arial, Helvetica, sans-serif;\n" +
"  border-collapse: collapse;\n" +
"  width: 100%;\n" +
"}\n" +
"\n" +
"#customers td, #customers th {\n" +
"  border: 1px solid #ddd;\n" +
"  padding: 8px;\n" +
"}\n" +
"\n" +
"#customers tr:nth-child(even){background-color: #f2f2f2;}\n" +
"\n" +
"#customers tr:hover {background-color: #ddd;}\n" +
"\n" +
"#customers th {\n" +
"  padding-top: 12px;\n" +
"  padding-bottom: 12px;\n" +
"  text-align: left;\n" +
"  background-color: #0E6787;\n" +
"  color: white;\n" +
"}"+
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
                        "            <li><a href=\"attendanceHome\" class=\"active\">Take Attendance</a></li>\n" +
                         "            <li><a href=\"addCourse.jsp\">Add Course</a></li>\n" +
                        "            <li style=\"float: right;\"><a href=\"index.html\" style=\"background-color: #b72424;color:#FFFFFF\">Log Out</a></li>\n" +
                        "            \n" +
                        "       </ul>");
            
            out.println("<div style=\"background-color:#E7EDEE;margin-bottom:20px\">");
            out.println("<div>");
            
                String code = request.getParameter("code");
                String sec = request.getParameter("sec");
                String key = request.getParameter("key");
            
                PreparedStatement ps1 = conn.prepareStatement("select studentEmail from joinedstudent where facEmail=? and courseCode=? and enrolKey=?");
                ps1.setString(1, email);
                ps1.setString(2, code);
                ps1.setString(3, key);
                ResultSet rs1 = ps1.executeQuery();
                out.println("<div style=\"text-align:center;margin-bottom:20px;font-size:23px\"> ");
                out.println(code);
                out.println("<br>Section: " + sec);
                out.println("</div>");
 
                out.println();
                out.println("<form action=\"calculateAttendance\" method=\"POST\" senctype=\"multipart/form-data\" style=\"text-decoration:center; margin-left:auto; margin-right:auto;width:20%\">\n");
                out.println("<table id=\"customers\">");
                out.println("<tr>\n" +
                "    <th>Name</th>\n" +
                "    <th>Select</th>\n" +
                "  </tr>");
                
                i=0;
                while (rs1.next()) {
                    String studentMail = rs1.getString("studentEmail");
                    String studentName="";
                    
                    
                    try{
                        PreparedStatement ps2 = conn.prepareStatement("select name from student1 where email=?");
                        ps2.setString(1, studentMail);
                        ResultSet rs2 = ps2.executeQuery();
                        
                        while(rs2.next()){
                            studentName = rs2.getString("name");
                        }
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    
                    
                    
                    
                    out.println("<tr>"+
                                "    <td><label>"+studentName+"</label></td>" +
                              
                                "    <td><input type=\"checkbox\" name=\"role"+i+"\" value=\"1\" style=\"margin-left:60px\"></td>" +
                                "</tr>"+
                                "<input type=\"text\" name=\"studentMail"+i+"\" value="+studentMail+" style=\"display:none\">" 
                               );
                    i+=1;            
                }
                
                out.println("</table>");
                out.println("<input type=\"text\" name=\"count\" value="+i+" style=\"display:none\">");
               // out.println("<input type=\"text\" name=\"count\" value=\"0\" style=\"display:none\">");
                
                
                out.println("<input type=\"text\" name=\"code\" value="+code+" style=\"display:none\">");
                out.println("<input type=\"text\" name=\"sec\" value="+sec+" style=\"display:none\">");
                out.println("<input type=\"text\" name=\"key\" value="+key+" style=\"display:none\">");
                out.println("<input type=\"submit\" class=\"button\" style=\"margin-top:10px;cursor:pointer\">\n" +
                             "</form>");

            
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
