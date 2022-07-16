import java.util.UUID;
import java.sql.*;
public class main {
    public static void main(String[] args){
        //ConnectionTest obj=new ConnectionTest();
       // obj.testingData();

       Connection con = null;
       PreparedStatement st = null;
       ResultSet rs =  null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/assignment","root","root");
            String query = "INSERT INTO reservations(id,check_in_date,check_out_date,status) values(?,?,?,?)";
            st = con.prepareStatement(query);


            st.setString(1,UUID.randomUUID().toString());
            st.setString(2,"2022-10-11");
            st.setString(3,"2022-10-21");
            st.setString(4,"Hold");
            int i = st.executeUpdate();
            if(i==1)
            {
                System.out.println("INSERTED SUCCESSFULLY");
            }

            st = con.prepareStatement("Select * from reservations");
            //st.setString(1,"checkedin");
            rs = st.executeQuery();
            while(rs.next())
            {
                //String id = rs.getString("id");
                System.out.println(rs.getString("id")+" , "+rs.getString("check_in_date")+" , "+rs.getString("check_out_date")+" , "+rs.getString("status"));

            }

            st = con.prepareStatement("Update reservations set check_in_date = ?, check_out_date = ? where id = ?");
            st.setString(1,"2023-12-12");
            st.setString(2,"2023-12-13");
            st.setString(3,"171902d0-4ac7-4fd6-8ed8-51304f16dbc2");
            i = st.executeUpdate();
            if(i==1)
            {
                System.out.println("UPDATEDD SUCCESSFULLY");
            }

            st = con.prepareStatement("Delete from reservations where status = 'Hold'");
            st.executeUpdate();

        }
        catch (ClassNotFoundException c)
        {

        }
        catch(SQLException e)
        {

        }
    }

}
