package com.tigerit.exam;

import java.util.*;
import java.io.*;
import static com.tigerit.exam.IO.*;

/**
 * All of your application logic should be placed inside this class.
 * Remember we will load your application from our custom container.
 * You may add private method inside this class but, make sure your
 * application's execution points start from inside run method.
 */
public class Solution implements Runnable {
    @Override
    public void run() {
        // your application entry point
      int  test,nT,q,co=0; //co for print test
      Integer[][][] table=new Integer[12][105][105]; // All tables
      Integer[][] res=new Integer[10005][205]; // 2D result: 100*100 max reocrds
      String[] tblname=new String[15]; //table names
      String[][] colname=new String[15][105]; // sob tabler columns
      String[] out=new String[205]; // output er columngula thakbe
      String[] needed=new String[105];
      Integer[][] num=new Integer[15][2];
      
      test=readLineAsInteger();
     // printLine(test+"\n");
      while(test!=0) 
      {
          test--;
          co++;
          nT=readLineAsInteger();
         
          for(int i=0;i<nT;i++)
          {
              tblname[i]=readLine();
              String ttt=readLine();
              needed=ttt.split(" ");
              num[i][0]=Integer.parseInt(needed[0]);
              num[i][1]=Integer.parseInt(needed[1]);
              colname[i]=readLine().split("[ ]");
              for(int j=0;j<num[i][1];j++)
              {
                  needed=readLine().split(" ");
                  for(int k=0;k<num[i][0];k++)
                      table[i][j][k]=Integer.parseInt(needed[k]);
              }    
          }
           //Table input neya finish
          
          q=readLineAsInteger();
          String ta,tb;
          int[] tmpa=new int[105]; //for storing column number
          int[] tmpb=new int[105];
          int[] idxa=new int[105]; // for storing position in output array
          int[] idxb=new int[105];
         
          int indxa=0,indxb=0,rcola=0,rcolb=0,totalcol=0,totalrow=0,sza=0,szb=0,totalcolname=0;
          //indxa=table_a indx, rcola=table_a er column jeta condition e ache
          //totalrow,totalcol holo result array er. sza holo kotota column table_a theke result e asbe
          String newtech="";
          newtech="Test: "+co;
          printLine(newtech);
          
          while(q!=0)
          {
              q--;
              String s1,s2,s3,s4;
              s1=readLine();
              s2=readLine();
              s3=readLine();
              s4=readLine();
              //SELECT ER KAJ
              String[] selcol=s1.split("[,. ]");
              //From
              String[] fromtheke=s2.split("[ ]");
              //Join
              String[] jointheke=s3.split("[ ]");
              //On start
              String[] ontheke=s4.split("[. ]");
                          
              if(selcol[1].equals("*")==true)
              {
                  ta=fromtheke[1];
                  tb=jointheke[1];
                //  printLineln(ta+"  "+tb);
                  for(int i=0;i<nT;i++) //jdi table_a dtabase e na thake tai modified
                  {
                      if(ta.equals(tblname[i])==true)
                      {
                          indxa=i;
                          break;
                      }
                  }
                  for(int i=0;i<nT;i++)
                  {
                      if(tb.equals(tblname[i])==true)
                      {
                          indxb=i;
                          break;
                      }
                  }
                  String tt=ontheke[2];
                  for(int i=0;i<num[indxa][0];i++)
                  {
                      if(tt.equals(colname[indxa][i])==true)
                      {
                          rcola=i;
                          break;
                      }
                  }
                  tt=ontheke[5];
                  for(int i=0;i<num[indxb][0];i++)
                  {
                      if(tt.equals(colname[indxb][i])==true)
                      {
                          rcolb=i;
                          break;
                      }
                  }
                  totalcol=0;
                  totalrow=0;
                  totalcolname=0;
                  sza=0;
                  szb=0;
                  
                  for(int i=0;i<num[indxa][0];i++)
                  {
                      out[totalcolname]=colname[indxa][i];
                      
                      tmpa[sza]=i;
                      idxa[sza]=totalcolname;
                      sza++;
                      totalcolname++;
                  }
                 // printLineln(totalcol+"  -= "+sza);
                  for(int i=0;i<num[indxb][0];i++)
                  {
                      out[totalcolname]=colname[indxb][i];
                      tmpb[szb]=i;
                      idxb[szb]=totalcolname;
                      szb++;
                      totalcolname++;
                  }
                  
                  int haha=0;
                  for(int i=0;i<num[indxa][1];i++)
                  {
                      for(int j=0;j<num[indxb][1];j++)
                      {
                         if(table[indxa][i][rcola]==table[indxb][j][rcolb])
                         {
                            haha=0;
                            for(int k=0;k<num[indxa][0];k++)
                            {
                                res[totalrow][haha]=table[indxa][i][k];
                                haha++;
                            }
                            for(int k=0;k<num[indxb][0];k++)
                            {
                                res[totalrow][haha]=table[indxb][j][k];
                                haha++;
                            }
                            totalcol=totalcolname;
                            totalrow++;
                         }
                      }
                  }
              } //1st case
              else
              {
                  ta=fromtheke[1];
                  tb=jointheke[1];
                  String sa=fromtheke[2]; //Short name
                  String sb=jointheke[2];
                 
                  for(int i=0;i<nT;i++)
                  {
                      if(ta.equals(tblname[i])==true)
                      {
                          indxa=i;
                          break;
                      }
                  }
                  for(int i=0;i<nT;i++)
                  {
                      if(tb.equals(tblname[i])==true)
                      {
                          indxb=i;
                          break;
                      }
                  }
                  String tt=ontheke[2];
                  for(int i=0;i<num[indxa][0];i++)
                  {
                      if(tt.equals(colname[indxa][i])==true)
                      {
                          rcola=i;
                          break;
                      }
                  }
                  tt=ontheke[5];
                  for(int i=0;i<num[indxb][0];i++)
                  {
                      if(tt.equals(colname[indxb][i])==true)
                      {
                          rcolb=i;
                          break;
                      }
                  }
                  totalcol=0;
                  totalrow=0;
                  totalcolname=0;
                  sza=0;
                  szb=0;
                  
                  for(int i=0;i<selcol.length;i++)
                  {
                      if(selcol[i].equals(sa)==true)
                      {
                          for(int j=0;j<num[indxa][0];j++)
                          {
                              if(colname[indxa][j].equals(selcol[i+1]))
                              {
                                 out[totalcolname]=colname[indxa][j];
                                 tmpa[sza]=j;
                                 idxa[sza]=totalcolname;
                                 sza++; 
                                 totalcolname++;
                              }
                          }
                          i++;
                      }
                      else if(selcol[i].equals(sb)==true)
                      {
                          for(int j=0;j<num[indxb][0];j++)
                          {
                              if(colname[indxb][j].equals(selcol[i+1]))
                              {
                                 out[totalcolname]=colname[indxb][j];
                                 tmpb[szb]=j;
                                 idxb[szb]=totalcolname;
                                 szb++; 
                                 totalcolname++;
                              }
                          }
                          i++; 
                      }
                  }
                  //printLine(totalrow+"   "+totalcol);
                  for(int i=0;i<num[indxa][1];i++)
                  {
                      for(int j=0;j<num[indxb][1];j++)
                      {
                         if(table[indxa][i][rcola]==table[indxb][j][rcolb])
                         {
                            for(int k=0;k<sza;k++)
                            {
                                res[totalrow][idxa[k]]=table[indxa][i][tmpa[k]];
                                //haha++;
                            }
                            for(int k=0;k<szb;k++)
                            {
                                res[totalrow][idxb[k]]=table[indxb][j][tmpb[k]];
                                //haha++;
                            }
                            totalrow++;
                            totalcol=totalcolname;
                         }
                      }
                  }
              }//end of else
                 //Output er kaj strt
                  int[][] finalout=new int[totalrow][totalcol];
                  for(int i=0;i<totalrow;i++)
                      for(int j=0;j<totalcol;j++)
                          finalout[i][j]=res[i][j];
                  
                   //Customize Sorting
                    Arrays.sort(finalout, new Comparator<int[]>(){
                     @Override
                     public int compare(int[] ff, int[] ss)
                     {
                         for(int i=0;i<ff.length;i++)
                         {
                             if(ff[i]==ss[i]) continue;
                             else
                             {
                                 return Integer.compare(ff[i],ss[i]); //Class dite hbe
                             }
                         }
                        return 1; 
                     }
                  }); //Customize sorting finish
               
                  newtech="";
                  for(int i=0;i<totalcolname;i++)
                  {
                      if(i>0) newtech+=" ";
                      newtech+=out[i];
                  }
                  printLine(newtech);
                  newtech="";
                  for(int i=0;i<totalrow;i++)
                  {
                      newtech="";
                      for(int j=0;j<totalcol;j++)
                        {
                            if(j>0) newtech+=" ";
                            newtech+=finalout[i][j];
                        }
                      printLine(newtech);
                  }
              printLine("");
              readLine(); //last ignored blank line
          } //end of query  
      } //End of test
      
    }
}
