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
public class facprofile extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");       
        PrintWriter out = response.getWriter();
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            HttpSession session = request.getSession();
            
            String email = request.getParameter("email").toString();
            PreparedStatement ps = conn.prepareStatement("select name,email,institution,dept,designation,phone,fileName from faculty where email=?");
            ps.setString(1, email);
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
            "  width: 30%;\n" +
            "}\n" +
            "\n" +
            ".card:hover {\n" +
            "  box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2);\n" +
            "}\n" +
            "\n" +
            
            ".container {\n" +
            "  padding: 2px 16px;\n" +
            "}\n" +
            "</style>");
            out.println("</head>");
           
            out.println("<body style=\"background-color:#E7EDEE;\">");
            
            out.println("<div style=\"margin-left:500px;\">");

            while (rs.next()) {
                String mail = rs.getString("email");
                String name = rs.getString("name");
                String institution = rs.getString("institution");
                String dept = rs.getString("dept");
                String designation = rs.getString("designation");
                String phone = rs.getString("phone");
                String path = rs.getString("fileName");
                //String key = rs.getString("enrolKey");
                /*out.println("<span>" + mail + "</span>" + "<br>");
                out.println("<span>" + name + "</span>" + "<br>");
                out.println("<span>" + code + "</span>" + "<br>");
                out.println("<span>" + sec + "</span>" + "<br>");
                out.println("<span>" + key + "</span>" + "<br>");*/
                
                out.println("<div class=\"card\" style=\"background-color:white\">\n" +
                "<img src=uploadedImage\\"+path+" alt=\"faculty.png\" style=\"width:100px;height:100px;margin-left:60px;\">" +
                "  <div class=\"container\" style=\"color:black;background-color:#E7EDEE\">\n" +
                "    <p><b>Instructor: </b>" + name + "</p> \n" +
                "    <p><b>Designation: </b>" +designation + "</p> \n" +
                "    <p><b> Department: </b>" +dept + "</p> \n" +
                "    <p><b>Institution: </b>" +institution + "</p> \n" +
                "    <p><b>Email: </b>" +mail + "</p> \n" +
                "    <p><b>Phone: </b>" +phone + "</p> \n" +
                //"    <p><b>Enrol Key: </b>" +key + "</p> \n" +
                "  </div>\n" +
                "</div>");
                out.println("<br>");
            }
            out.println("</div>");
            out.println(" <footer style=\"font-size: 13px; margin: 0px;background-color:#E7EDEE\">\n" +
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
