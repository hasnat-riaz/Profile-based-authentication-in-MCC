
package context_simulation;

import java.sql.SQLException;

public class TimeSpendOnEachApp {
    double calculateCosineSimilarity(double[] x, double[] y)
    {
        double upperSum=0, squareSumOfX=0, squareSumOfY=0;
        
        for(int i=0; i<x.length; i++)
        {
            upperSum += (x[i]*y[i]);
        }

        for(int i=0; i<x.length; i++)
        {
            squareSumOfX += (x[i]*x[i]);
            squareSumOfY += (y[i]*y[i]);
        }
    //cout<<upperSum<<endl<<squareSumOfX<<endl<<squareSumOfY<<endl;cout<<sqrt(squareSumOfX)<<endl;cout<<sqrt(squareSumOfY)<<endl;
        double cosineSimilarity = upperSum /(Math.sqrt(squareSumOfX) * Math.sqrt(squareSumOfY));
        return cosineSimilarity;
        //System.out.println(cosineSimilarity);
    }
    
    boolean similarityOfOneWeek(double[] d1, double[] d2, double[] d3, double[] d4, double[] d5, double[] d6, double[] d7) throws SQLException
    {
        
        double[][] similarityTimeSpendOnEachApps = new double[10][10];
        similarityTimeSpendOnEachApps[1][1]=similarityTimeSpendOnEachApps[2][2]=similarityTimeSpendOnEachApps[3][3]=1.0;
        similarityTimeSpendOnEachApps[4][4]=similarityTimeSpendOnEachApps[5][5]=similarityTimeSpendOnEachApps[6][6]=similarityTimeSpendOnEachApps[7][7]=1.0;
        //Day 1
        similarityTimeSpendOnEachApps[1][2]=similarityTimeSpendOnEachApps[2][1]=calculateCosineSimilarity(d1,d2);
        similarityTimeSpendOnEachApps[1][3]=similarityTimeSpendOnEachApps[3][1]=calculateCosineSimilarity(d1,d3);
        similarityTimeSpendOnEachApps[1][4]=similarityTimeSpendOnEachApps[4][1]=calculateCosineSimilarity(d1,d4);
        similarityTimeSpendOnEachApps[1][5]=similarityTimeSpendOnEachApps[5][1]=calculateCosineSimilarity(d1,d5);
        similarityTimeSpendOnEachApps[1][6]=similarityTimeSpendOnEachApps[6][1]=calculateCosineSimilarity(d1,d6);
        similarityTimeSpendOnEachApps[1][7]=similarityTimeSpendOnEachApps[7][1]=calculateCosineSimilarity(d1,d7);
        //Day 2
        similarityTimeSpendOnEachApps[2][3]=similarityTimeSpendOnEachApps[3][2]=calculateCosineSimilarity(d2,d3);
        similarityTimeSpendOnEachApps[2][4]=similarityTimeSpendOnEachApps[4][2]=calculateCosineSimilarity(d2,d4);
        similarityTimeSpendOnEachApps[2][5]=similarityTimeSpendOnEachApps[5][2]=calculateCosineSimilarity(d2,d5);
        similarityTimeSpendOnEachApps[2][6]=similarityTimeSpendOnEachApps[6][2]=calculateCosineSimilarity(d2,d6);
        similarityTimeSpendOnEachApps[2][7]=similarityTimeSpendOnEachApps[7][2]=calculateCosineSimilarity(d2,d7);
        //Day 3
        similarityTimeSpendOnEachApps[3][4]=similarityTimeSpendOnEachApps[4][3]=calculateCosineSimilarity(d3,d4);
        similarityTimeSpendOnEachApps[3][5]=similarityTimeSpendOnEachApps[5][3]=calculateCosineSimilarity(d3,d4);
        similarityTimeSpendOnEachApps[3][6]=similarityTimeSpendOnEachApps[6][3]=calculateCosineSimilarity(d3,d4);
        similarityTimeSpendOnEachApps[3][7]=similarityTimeSpendOnEachApps[7][3]=calculateCosineSimilarity(d3,d4);
        //Day 4
        similarityTimeSpendOnEachApps[4][5]=similarityTimeSpendOnEachApps[5][4]=calculateCosineSimilarity(d5,d4);
        similarityTimeSpendOnEachApps[4][6]=similarityTimeSpendOnEachApps[6][4]=calculateCosineSimilarity(d5,d4);
        similarityTimeSpendOnEachApps[4][7]=similarityTimeSpendOnEachApps[7][4]=calculateCosineSimilarity(d5,d4);
        //Day 5
        similarityTimeSpendOnEachApps[5][6]=similarityTimeSpendOnEachApps[6][5]=calculateCosineSimilarity(d5,d6);
        similarityTimeSpendOnEachApps[5][7]=similarityTimeSpendOnEachApps[7][5]=calculateCosineSimilarity(d5,d7);
        //Day 6
        similarityTimeSpendOnEachApps[6][7]=similarityTimeSpendOnEachApps[7][6]=calculateCosineSimilarity(d6,d7);
        
        //DbConnect connect = new DbConnect();
        //connect.insertCosineSimilarityOfTimeSpentOnEachApps(similarityTimeSpendOnEachApps);
        //displayData(similarityTimeSpendOnEachApps);
        return loginPermission(similarityTimeSpendOnEachApps);
    }
    
    void displayData(double[][] similarityTimeSpendOnEachApps)
    {
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                System.out.print(similarityTimeSpendOnEachApps[i][j]+"  ");
            }
            System.out.println();
        }
    }
    
    boolean loginPermission(double[][] similarityTimeSpendOnEachApps)
    {
        double thresholdValue = 0.050;
        boolean flagValue = true;
        for(int i=1; i<=7; i++)
        {
            for(int j=1; j<=7; j++)
            {
                if(similarityTimeSpendOnEachApps[i][j] < thresholdValue)
                {
                    flagValue = false;
                }
            }
        }
        return flagValue;
    }
}
