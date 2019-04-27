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
public class facultyLogin extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");

        String title = "";
        Connection conn = null;
        
        HttpSession session = request.getSession();
        
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
    
            PreparedStatement ps = conn.prepareStatement("select count(*) from faculty where email=? and password=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            //out.println("heyyy");
            
            while (rs.next()) {
                if(rs.getInt(1)>0){
                    session.setAttribute("facultyEmail", email);
                    response.sendRedirect("courses_fac");
                }
                else{
                    /*out.println("<script type=\"text/javascript\">");
                    out.println("alert('Incorrect Email or Password\nTry Again!');");
                    out.println("</script>");*/
                    
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
