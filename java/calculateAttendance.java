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
public class calculateAttendance extends HttpServlet {
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Connection conn = null;
        String title = "";
        
        HttpSession session = request.getSession();
        String facultytMail = session.getAttribute("facultyEmail").toString();
        
        int count = Integer.parseInt(request.getParameter("count"));
        String code = request.getParameter("code");
        String sec = request.getParameter("sec");
        String key = request.getParameter("key");
        for(int i=0; i<count;i++){
            String studentMail = "";
            if(request.getParameter("role"+i)!=null){
                if(request.getParameter("role"+i).equals("1")){
                   studentMail = request.getParameter("studentMail"+i);
                   
                  // float mark = (float) 0.25;
                   //int total = 1;
                   
                   
                   
                   try{
                        Class.forName("com.mysql.jdbc.Driver");
                        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");

                        PreparedStatement ps = conn.prepareStatement("select count(*) from marks where studentMail=? and facultyEmail=? and courseCode=? and sec=? and enrolKey=?");
                        ps.setString(1, studentMail);
                        ps.setString(2, facultytMail);
                        ps.setString(3, code);
                        ps.setString(4, sec);
                        ps.setString(5, key);
                        ResultSet rs = ps.executeQuery();
                        

                        while (rs.next()) {
                            if(rs.getInt(1)==0){
                                try{
                                   // Class.forName("com.mysql.jdbc.Driver");
                                    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                                    //out.println("hey");
                                    PreparedStatement ps1 = conn.prepareStatement("insert into marks values(?,?,?,?,?,?,?)"); 
                                    ps1.setString(1, studentMail);
                                    ps1.setString(2, facultytMail);
                                    ps1.setString(3, code);
                                    ps1.setString(4, sec);
                                    ps1.setString(5, key);
                                    ps1.setInt(6, 1);
                                    ps1.setDouble(7, 0.25);
                                    

                                    ps1.executeUpdate();
                                   
                                     request.getRequestDispatcher("calculate.jsp").forward(request, response);
                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    finally{
                                        out.println(title);
                                    }
                            }
                            else{
                                try{
                                   // Class.forName("com.mysql.jdbc.Driver");
                                    //conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
                                    //out.println("heyyy update");
                                    PreparedStatement ps1 = conn.prepareStatement("update marks set total=total+?,totalMark=totalMark+? where studentMail=?"); 
                                    ps1.setInt(1, +1);
                                    ps1.setDouble(2, 0.25);
                                    ps1.setString(3, studentMail);
                                    ps1.executeUpdate();
                                    request.getRequestDispatcher("calculate.jsp").forward(request, response);
                                   

                                    }
                                    catch(Exception e){
                                        e.printStackTrace();
                                    }
                                    finally{
                                        out.println(title);
                                    }     
                            }
                        }



                    }
                catch(Exception e){
                    e.printStackTrace();
                 }
                finally{
                    out.println(title);
                }
                 

                }
            }
            else{
               //out.println("problem man");
            }
                
                
                  

            }
        try {
            conn.close();
       } catch (Exception e) {
             e.printStackTrace();
       }

    }


}
