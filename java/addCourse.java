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
public class addCourse extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        //HttpSession session = request.getSession();
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        //String email = (String)session.getAttribute("facultyEmail");
        HttpSession session = request.getSession();
        String email = session.getAttribute("facultyEmail").toString();
        String name = request.getParameter("courseName");
        String code = request.getParameter("courseCode");
        String sec = request.getParameter("sec");
        String key = request.getParameter("key");

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
    
            PreparedStatement ps = conn.prepareStatement("insert into course values(?,?,?,?,?)"); 
                ps.setString(1, email);
                ps.setString(2, name);
                ps.setString(3, code);
                ps.setString(4, sec);
                ps.setString(5, key);
               

                ps.executeUpdate();
                request.getRequestDispatcher("success.jsp").forward(request, response);
                //request.getRequestDispatcher("facultyLogin.jsp").forward(request, response);
            
            
            
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
