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
public class shareFile extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        //String name, roll, email, pass, confirmPass, institution, phone, guardianPhone, location, photo;
        //long p, g;
        response.setContentType("text/html");
        String savePath = "";
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String code = request.getParameter("code");
        String sec = request.getParameter("sec");
        String fileName = "";
        
        //PHOTO
        
       if(request.getPart("filePath").toString().length()!=0){
            InputStream inputStream = null;
            Part filePart = request.getPart("filePath");

            fileName = extractFileName(filePart);
            savePath = "C:\\Users\\GR Pranto\\Documents\\NetBeansProjects\\Aider\\src\\main\\webapp\\uploadedImage" + File.separator + fileName;
            File fileSaveDir = new File(savePath);
            filePart.write(savePath + File.separator);
        }
        
        String title = "";
        Connection conn = null;
   
            try{
                //out.println("hello");
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

                PreparedStatement ps = conn.prepareStatement("insert into file values(?,?,?,?,?)"); 
                ps.setString(1, email);
                ps.setString(2, code);
                ps.setString(3, sec);
                ps.setString(4, savePath);
                ps.setString(5, fileName);
                
                ps.executeUpdate();
                request.getRequestDispatcher("success.jsp").forward(request, response);

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
