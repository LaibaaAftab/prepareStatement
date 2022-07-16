import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

public class ConnectionTest {
    Connection con;
    String query;
    public void testingData()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/assignment","root","root");
             query = "INSERT INTO reservations(id,check_in_date,check_out_date,status) values(?,?,?,?)";
            //st = con.prepareStatement(query);
            PreparedStatement st=con.prepareStatement(query);
            st.setString(1, UUID.randomUUID().toString());
            st.setString(2,"2022-10-11");
            st.setString(3,"2022-10-21");
            st.setString(4,"Hold");
            int i = st.executeUpdate();
            if(i==1)
            {
                System.out.println("INSERTED SUCCESSFULLY");
            }
        }
        catch (ClassNotFoundException c)
        {

        }
        catch(SQLException e)
        {

        }
    }
}
