
package context_simulation;

public class Context_Simulation {

        
    public static void main(String[] args) {
                  
        try
        {
                     
            {      
                long start = System.currentTimeMillis();
            
                boolean loginApproval = true; 
            
                //talk time
                TalkTime tt = new TalkTime();
                int d_1=11, d_2=32, d_3=60, d_4=15, d_5=4, d_6=100, d_7=30;
                if(tt.similarityOfOneWeek(d_1, d_2, d_3, d_4, d_5, d_6, d_7)==false)
                    loginApproval = false;
                //no of installed apps
                NumberOfInstalledApps n = new NumberOfInstalledApps();
                int D1=35, D2=35, D3=37, D4=35, D5=35, D6=40, D7=35;        
                if(n.similarityOfOneWeek(D1, D2, D3, D4, D5, D6, D7)==false)
                    loginApproval = false;
                //time spend on each app
                TimeSpendOnEachApp ts = new TimeSpendOnEachApp();
                    //{gallery,messanger,fb,chrome,youtube,MX Player,Settings,Snapchat}
                double[] d1 = {0.75,18,02,03,04,05,06.9,07.5};
                double[] d2 = {10,20,30,40,50,60,70,80}; 
                double[] d3 = {100,200,300,400,500,60,700,9800};
                double[] d4 = {305,036,34065,4084,075,97,03,06};
                double[] d5 = {043,056,0647,560,057,05674,0564,057};
                double[] d6 = {430,35360,740,740,750,560,850,50};
                double[] d7 = {60,30,3509,3590,03,40,509,950};
                if(ts.similarityOfOneWeek(d1,d2,d3,d4,d5,d6,d7) == false)
                    loginApproval = false;
                
                if(loginApproval == true)
                    System.out.println("Login Successful.");
                else
                    System.err.println("Login Failed!");
                
                long end = System.currentTimeMillis();
                 System.out.println("Time taken: "+ (end-start) + " miliseconds."); 
            }            
                      
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
}
