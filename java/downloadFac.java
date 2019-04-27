import java.io.*;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;  
  
public class downloadFac extends HttpServlet {  
  
@Override
public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws IOException, ServletException{
  
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
String filename = request.getParameter("name").toString();   
String filepath = "C:\\Users\\GR Pranto\\Documents\\NetBeansProjects\\Aider\\src\\main\\webapp\\uploadedImage";   
response.setContentType("APPLICATION/OCTET-STREAM");   
response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
  
FileInputStream fileInputStream = new FileInputStream("C:\\Users\\GR Pranto\\Documents\\NetBeansProjects\\Aider\\src\\main\\webapp\\uploadedImage\\" + filename);  
            
int i;   
while ((i=fileInputStream.read()) != -1) {  
out.write(i);   
}   
fileInputStream.close();   
out.close();   
}  
  
}  