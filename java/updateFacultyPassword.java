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
public class updateFacultyPassword extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String email = session.getAttribute("email").toString();
        String pass = request.getParameter("pass");

        String title = "";
        Connection conn = null;
        
        //SESSION
        /*if(session.isNew()){
            title = "Newbie";
        }
        else{
            title = "Welcome";
        }*/
        //out.println("EMAIL = "+email);
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
    
            PreparedStatement ps = conn.prepareStatement("update faculty set password=? where email=?");
            ps.setString(1, pass);
            ps.setString(2, email);
            //ResultSet rs = ps.executeQuery();
            
            int count = ps.executeUpdate();
            if(count > 0){
              request.getRequestDispatcher("success2.jsp").forward(request, response);
              if (session != null) {
                session.invalidate();
              }
            }
            else{
              request.getRequestDispatcher("error.jsp").forward(request, response);
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
