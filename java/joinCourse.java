import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class joinCourse extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String facEmail = request.getParameter("email");
        String code = request.getParameter("code");
        String key = request.getParameter("enrol");
        HttpSession session = request.getSession();
        String studentEmail = session.getAttribute("studentEmail").toString();
        
        Connection conn = null;
        
            try{
 
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                
                
                PreparedStatement ps2 = conn.prepareStatement("select count(*) from joinedStudent where studentEmail=? and facEmail=? and courseCode=?");
                ps2.setString(1, studentEmail);
                ps2.setString(2, facEmail);
                ps2.setString(3, code);
                ResultSet rs2 = ps2.executeQuery();
            
            while (rs2.next()) {
                if(rs2.getInt(1)>0){
                    response.sendRedirect("alreadyJoined.jsp");    
                }
                else{
                         PreparedStatement ps1 = conn.prepareStatement("select count(*) from course where email=? and courseCode=? and enrolKey=?");
                         ps1.setString(1, facEmail);
                         ps1.setString(2, code);
                         ps1.setString(3, key);
                         ResultSet rs1 = ps1.executeQuery();

                     while (rs1.next()) {
                         if(rs1.getInt(1)>0){
                             PreparedStatement ps = conn.prepareStatement("insert into joinedStudent values(?,?,?,?)"); 
                             ps.setString(1, studentEmail);
                             ps.setString(2, facEmail);
                             ps.setString(3, code);
                             ps.setString(4, key);

                             ps.executeUpdate();
                             response.sendRedirect("success3.jsp");
                         }
                         else{
                             response.sendRedirect("Error.jsp");     
                         }
                     } 
                }
            }
                
                
                
                

                //response.sendRedirect("facultyLogin.jsp");    

            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
            }
      
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    
    private String extractFileName(Part filePart) {
        String contentDisp = filePart.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for(String s : items){
            if(s.trim().startsWith("filename")){
                return s.substring(s.indexOf("=")+2,s.length()-1);
            }
        }
        return "";
    }
}
