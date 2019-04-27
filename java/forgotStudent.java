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
public class forgotStudent extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String secret = request.getParameter("secret");

        String title = "";
        Connection conn = null;
        
        //SESSION
        /*if(session.isNew()){
            title = "Newbie";
        }
        else{
            title = "Welcome";
        }*/
        //out.println("try er age");
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
    
            PreparedStatement ps = conn.prepareStatement("select count(*) from student1 where email=? and secret=?");
            ps.setString(1, email);
            ps.setString(2, secret);
            ResultSet rs = ps.executeQuery();
            //out.println("heyyy");
            
            while (rs.next()) {
                if(rs.getInt(1)>0){
                    //response.sendRedirect("updateStudentPassword.jsp");
                    request.setAttribute("emailSend", email);
                    request.getRequestDispatcher("updateStudentPassword.jsp").forward(request, response);
                }
                else{
                    response.sendRedirect("Error.jsp");    
                }
            }
            
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            out.println(title);
        }
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    

}
