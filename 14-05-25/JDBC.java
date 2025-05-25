import java.sql.*;
import java.util.*;

class JDBC
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String url="jdbc:mysql://localhost:3306/test";
        String username="root";
        String password="Tanuku@1";
        
        //String query="select * from emp";
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(url,username,password);
            System.out.println("Connection establishd sucessfully !");
            
            CallableStatement st =conn.prepareCall("{call getdepartments()}");
            ResultSet rs= st.executeQuery();
            
            while(rs.next())
            {
                String name=rs.getString("dname");
                System.out.println(name);
            }
            
            st.close();
            conn.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}