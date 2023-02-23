
package context_simulation;

import java.sql.SQLException;

public class TalkTime {
    boolean similarityOfOneWeek(int d1, int d2, int d3, int d4, int d5, int d6, int d7) throws SQLException
    {
        
        double[][] ratioTalkTime = new double[10][10];
        ratioTalkTime[1][1]=ratioTalkTime[2][2]=ratioTalkTime[3][3]=ratioTalkTime[4][4]=ratioTalkTime[5][5]=ratioTalkTime[6][6]=ratioTalkTime[7][7]=1.0;
        //day 1
        ratioTalkTime[1][2]=ratioTalkTime[2][1]=calculateRatio(d1, d2);
        ratioTalkTime[1][3]=ratioTalkTime[3][1]=calculateRatio(d1, d3);
        ratioTalkTime[1][4]=ratioTalkTime[4][1]=calculateRatio(d1, d4);
        ratioTalkTime[1][5]=ratioTalkTime[5][1]=calculateRatio(d1, d5);
        ratioTalkTime[1][6]=ratioTalkTime[6][1]=calculateRatio(d1, d6);
        ratioTalkTime[1][7]=ratioTalkTime[7][1]=calculateRatio(d1, d7);
        //day 2
        ratioTalkTime[2][3]=ratioTalkTime[3][2]=calculateRatio(d2, d3);
        ratioTalkTime[2][4]=ratioTalkTime[4][2]=calculateRatio(d2, d4);
        ratioTalkTime[2][5]=ratioTalkTime[5][2]=calculateRatio(d2, d5);
        ratioTalkTime[2][6]=ratioTalkTime[6][2]=calculateRatio(d2, d6);
        ratioTalkTime[2][7]=ratioTalkTime[7][2]=calculateRatio(d2, d7);
        //day 3
        ratioTalkTime[3][4]=ratioTalkTime[4][3]=calculateRatio(d3, d4);
        ratioTalkTime[3][5]=ratioTalkTime[5][3]=calculateRatio(d3, d5);
        ratioTalkTime[3][6]=ratioTalkTime[6][3]=calculateRatio(d3, d6);
        ratioTalkTime[3][7]=ratioTalkTime[7][3]=calculateRatio(d3, d7);
        //day 4
        ratioTalkTime[4][5]=ratioTalkTime[5][4]=calculateRatio(d4, d5);
        ratioTalkTime[4][6]=ratioTalkTime[6][4]=calculateRatio(d4, d6);
        ratioTalkTime[4][7]=ratioTalkTime[7][4]=calculateRatio(d4, d7);
        //day 5
        ratioTalkTime[5][6]=ratioTalkTime[6][5]=calculateRatio(d5, d6);
        ratioTalkTime[5][7]=ratioTalkTime[7][5]=calculateRatio(d5, d7);
        //day 6
        ratioTalkTime[6][7]=ratioTalkTime[7][6]=calculateRatio(d6, d7);
        //displayData(ratioTalkTime);
        //DbConnect connect = new DbConnect();
        //connect.insertSimilarityOfTalkTime(ratioTalkTime);
        return loginPermission(ratioTalkTime);
    }
    
    double calculateRatio(int a, int b)
    {
        if(b>a)
            return (double)a/(double)b;
        else
            return (double)b/(double)a;
    }
   
    void displayData(double[][] ratioTalkTime)
    {
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                System.out.print(ratioTalkTime[i][j]+"  ");
            }
            System.out.println();
        }
            
    }
    
    boolean loginPermission(double[][] ratioTalkTime)
    {
        double thresholdValue = 0.050;
        boolean flagValue = true;
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                if(ratioTalkTime[i][j] < thresholdValue)
                {
                    flagValue = false;
                }
            }
        }
        return flagValue;
    }
}
