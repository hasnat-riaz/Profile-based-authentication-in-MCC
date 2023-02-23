
package context_simulation;

import java.sql.*;

public class DbConnect {
   private Connection conn;
   private Statement st;
   private ResultSet rs;
   
   public DbConnect()
   {
       try
       {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contextaware","root","");
           st = conn.createStatement();
       }
       catch(Exception ex)
       {
           System.out.println("Error: " + ex);
       }
   }
   
   public void getTimeSpentOnEachAppsData()
   {
       try
       {
           String query = "select * from time_spent_on_each_apps"; 
           rs = st.executeQuery(query);
           System.out.println("Records from database:");
           while(rs.next())
           {
               int day = rs.getInt("day");
               double facebook = rs.getDouble("facebook");
               double messanger = rs.getDouble("messanger");
               double whatsapp = rs.getDouble("whatsapp");
               double instagram = rs.getDouble("instagram");
               double twitter = rs.getDouble("twitter");
               double shareit = rs.getDouble("shareit");
               double skype = rs.getDouble("skype");
               
               System.out.println("Day:"+day+" fb:"+facebook+" msngr:"+messanger+" whatsapp:"+whatsapp+" instagram:"+instagram+" twitter:"+twitter+" shareit:"+shareit+" skype:"+skype);
           }
       }
       catch(Exception e)
       {
           System.out.println(e);
       }
   }
   
   public void insertCosineSimilarityOfTimeSpentOnEachApps(double[][] similarityTimeSpendOnEachApps) throws SQLException
   {
       /*for(int i=1; i<=7; i++)
           for(int j=1; j<=7; j++)
           {
               System.out.println(similarityTimeSpendOnEachApps[i][j]+"  ");
           }*/
       for(int i=1; i<=7; i++)
           {
               String query = "INSERT INTO cosine_similarity_of_time_spent_on_each_apps VALUES ("+i+","+similarityTimeSpendOnEachApps[i][1]+","+similarityTimeSpendOnEachApps[i][2]+","+similarityTimeSpendOnEachApps[i][3]+","+similarityTimeSpendOnEachApps[i][4]+","+similarityTimeSpendOnEachApps[i][5]+","+similarityTimeSpendOnEachApps[i][6]+","+similarityTimeSpendOnEachApps[i][7]+")"; 
               PreparedStatement pst = conn.prepareStatement(query);
               pst.executeUpdate();
           }
   }
   
   public void insertSimilarityOfTalkTime(double[][] similarityTalkTime) throws SQLException
   {
       /*for(int i=1; i<=7; i++)
           for(int j=1; j<=7; j++)
           {
               System.out.println(similarityTalkTime[i][j]+"  ");
           }*/
       for(int i=1; i<=7; i++)
           {
               String query = "INSERT INTO similarity_of_talk_time VALUES ("+i+","+similarityTalkTime[i][1]+","+similarityTalkTime[i][2]+","+similarityTalkTime[i][3]+","+similarityTalkTime[i][4]+","+similarityTalkTime[i][5]+","+similarityTalkTime[i][6]+","+similarityTalkTime[i][7]+")"; 
               PreparedStatement pst = conn.prepareStatement(query);
               pst.executeUpdate();
           }
   }
   
   public void insertSimilarityOfNumberOfInstalledApps(double[][] similarityNoOfInstalledApps) throws SQLException
   {       
       for(int i=1; i<=7; i++)
           {
               String query = "INSERT INTO similarity_of_number_of_installed_apps VALUES ("+i+","+similarityNoOfInstalledApps[i][1]+","+similarityNoOfInstalledApps[i][2]+","+similarityNoOfInstalledApps[i][3]+","+similarityNoOfInstalledApps[i][4]+","+similarityNoOfInstalledApps[i][5]+","+similarityNoOfInstalledApps[i][6]+","+similarityNoOfInstalledApps[i][7]+")"; 
               PreparedStatement pst = conn.prepareStatement(query);
               pst.executeUpdate();
           }
   }

}
