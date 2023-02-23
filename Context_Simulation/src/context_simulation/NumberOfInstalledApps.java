
package context_simulation;

import java.sql.SQLException;

public class NumberOfInstalledApps {
    boolean similarityOfOneWeek(int d1, int d2, int d3, int d4, int d5, int d6, int d7) throws SQLException
    {
        double[][] ratioInstalledApps = new double[10][10];
        ratioInstalledApps[1][1]=ratioInstalledApps[2][2]=ratioInstalledApps[3][3]=ratioInstalledApps[4][4]=ratioInstalledApps[5][5]=ratioInstalledApps[6][6]=ratioInstalledApps[7][7]=1.0;
        //day 1
        ratioInstalledApps[1][2]=ratioInstalledApps[2][1]=calculateRatio(d1, d2);
        ratioInstalledApps[1][3]=ratioInstalledApps[3][1]=calculateRatio(d1, d3);
        ratioInstalledApps[1][4]=ratioInstalledApps[4][1]=calculateRatio(d1, d4);
        ratioInstalledApps[1][5]=ratioInstalledApps[5][1]=calculateRatio(d1, d5);
        ratioInstalledApps[1][6]=ratioInstalledApps[6][1]=calculateRatio(d1, d6);
        ratioInstalledApps[1][7]=ratioInstalledApps[7][1]=calculateRatio(d1, d7);
        //day 2
        ratioInstalledApps[2][3]=ratioInstalledApps[3][2]=calculateRatio(d2, d3);
        ratioInstalledApps[2][4]=ratioInstalledApps[4][2]=calculateRatio(d2, d4);
        ratioInstalledApps[2][5]=ratioInstalledApps[5][2]=calculateRatio(d2, d5);
        ratioInstalledApps[2][6]=ratioInstalledApps[6][2]=calculateRatio(d2, d6);
        ratioInstalledApps[2][7]=ratioInstalledApps[7][2]=calculateRatio(d2, d7);
        //day 3
        ratioInstalledApps[3][4]=ratioInstalledApps[4][3]=calculateRatio(d3, d4);
        ratioInstalledApps[3][5]=ratioInstalledApps[5][3]=calculateRatio(d3, d5);
        ratioInstalledApps[3][6]=ratioInstalledApps[6][3]=calculateRatio(d3, d6);
        ratioInstalledApps[3][7]=ratioInstalledApps[7][3]=calculateRatio(d3, d7);
        //day 4
        ratioInstalledApps[4][5]=ratioInstalledApps[5][4]=calculateRatio(d4, d5);
        ratioInstalledApps[4][6]=ratioInstalledApps[6][4]=calculateRatio(d4, d6);
        ratioInstalledApps[4][7]=ratioInstalledApps[7][4]=calculateRatio(d4, d7);
        //day 5
        ratioInstalledApps[5][6]=ratioInstalledApps[6][5]=calculateRatio(d5, d6);
        ratioInstalledApps[5][7]=ratioInstalledApps[7][5]=calculateRatio(d5, d7);
        //day 6
        ratioInstalledApps[6][7]=ratioInstalledApps[7][6]=calculateRatio(d6, d7);
        //displayData(ratioInstalledApps);
        //DbConnect conn = new DbConnect();
        //conn.insertSimilarityOfNumberOfInstalledApps(ratioInstalledApps);
        
        return loginPermission(ratioInstalledApps);
    }
    
    double calculateRatio(int a, int b)
    {
        if(b>a)
            return (double)a/(double)b;
        else
            return (double)b/(double)a;
    }
    
    void displayData(double[][] ratioInstalledApps)
    {
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                System.out.print(ratioInstalledApps[i][j]+"  ");
            }
            System.out.println();
        }
            
    }
    
    boolean loginPermission(double[][] ratioInstalledApps)
    {
        double thresholdValue = 0.050;
        boolean flagValue = true;
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                if(ratioInstalledApps[i][j] < thresholdValue)
                {
                    flagValue = false;
                }
            }
        }
        return flagValue;
    }
}
