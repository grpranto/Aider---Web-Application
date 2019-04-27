import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class studentReg extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        String savePath = "";
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String confirmPass = request.getParameter("confirmPass");
        String roll = request.getParameter("roll");
        String institution = request.getParameter("institution");
        String phone = request.getParameter("phone");
        String guardianPhone = request.getParameter("guardianPhone");
        String location = request.getParameter("location");
        String secret = request.getParameter("secret");
        //PHOTO
        
       if(request.getPart("photo").toString().length()==0){
            InputStream inputStream = null;
            Part filePart = request.getPart("photo");

            String fileName = extractFileName(filePart);
            savePath = "C:\\Users\\GR Pranto\\Documents\\NetBeansProjects\\Aider\\src\\main\\webapp\\uploadedImage" + File.separator + fileName;
            File fileSaveDir = new File(savePath);
            filePart.write(savePath + File.separator);
        }
        
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
        
        if(pass.equals(confirmPass)){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

                PreparedStatement ps = conn.prepareStatement("insert into student1 values(?,?,?,?,?,?,?,?,?,?)"); 
                ps.setString(1, name);
                ps.setString(2, email);
                ps.setString(3, pass);
                ps.setString(4, roll);
                ps.setString(5, institution);
                ps.setString(6, phone);
                ps.setString(7, guardianPhone);
                ps.setString(8, location);
                ps.setString(9, secret);
                ps.setString(10, savePath);
                
                ps.executeUpdate();
                request.getRequestDispatcher("success1.jsp").forward(request, response);

                /*PreparedStatement ps = conn.prepareStatement("insert into student1 values(?)"); 
                ps.setString(1, name);
                ps.executeUpdate();
                out.println("Inserted");*/
               // session.setAttribute(id, name);

            }
            catch(Exception e){
                e.printStackTrace();
            }
            finally{
                out.println(title);
            }
        }
       else{
            out.println("<script type=\"text/javascript\">");
            out.println("alert('passwords do not match');");
            out.println("</script>");
            //response.sendRedirect("index.jsp");    
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
