package gameBase;

import java.util.Random;
import java.util.Scanner;


public class game2048 {

  static int[][] Table4x4={
  {2,0,6,0},
  {0,2,6,0},
  {2,2,0,0},
  {4,0,4,0},
  };
  public static void main(String[] args) {
   /*
   Rotation codes
   0 = left
   1 = up
   2 = right
   3 = down
   */
   ShowTable(Table4x4);
   cwl("0:left \n1:up \n2:right \n3:down");
   Scanner sc=new Scanner(System.in);
   String Uinput="";
   while(Uinput.replace(" ","").equals("e")==false)
   {
     Uinput=sc.next();
     switch(Uinput)
     {
       case "0":
        Move_Manage(Table4x4,0);
       break;
       case "1":
        Move_Manage(Table4x4,1);
       break;
       case "2":
        Move_Manage(Table4x4,2);
       break;
       case "3":
        Move_Manage(Table4x4,3);
       break;
     }
   }
  }
  public static void Move_Manage(int[][] table,int rot)
  {
    for(int i=0;i<table.length;i++)
    {
      switch(rot)
      {
        case 0:
        MoveTable_Left(table);
        break;
        case 1:
        MoveTable_Up(table);
        break;
        case 2:
        MoveTable_Right(table);
        break;
        case 3:
        MoveTable_Down(table);
        break;
      }
    }
    
    
    ShowTable(table);
  }
  public static void MoveTable_Right(int[][] table)
  {
    for(int i=0;i<table.length;i++)
    {
      for(int j=0;j<table[i].length-1;j++)
      {
       if(table[i][j+1]==table[i][j])
       {
        table[i][j+1]*=table[i][j];
        table[i][j]=0;
        }
        if(table[i][j+1]==0)
       {
        table[i][j+1]=table[i][j];
        table[i][j]=0;
        }
      }
    }
  }
  public static void MoveTable_Left(int[][] table)
  {
   // first get full arrays
   for(int i=0;i<table.length;i++)
   {
   // 2. ; get rows , in this loop we dont need to first item
     for(int j=1;j<table[i].length;j++)
     {
     if(table[i][j-1]==table[i][j])
       {
       table[i][j-1]*=table[i][j];
       table[i][j]=0;
       }
       if(table[i][j-1]==0)
       {
         table[i][j-1]=table[i][j];
         table[i][j]=0;
       }
     }
   }
  }
  public static void MoveTable_Down(int[][] table)
  {
    // works with =( normal length - 1) and this is gives ability for access whole table
    for(int i=0;i<table.length-1;i++)
    {
      for(int j=0;j<table[i].length;j++)
      {
      if(table[i+1][j]==table[i][j])
        {
        table[i+1][j]*=table[i][j];
        table[i][j]=0;
        }
        // if cell is empty move number to that cell
       if(table[i+1][j]==0)
       {
         table[i+1][j]=table[i][j];
         table[i][j]=0;
       }
      }
    }
  }
  public static void MoveTable_Up(int[][] table)
  {
    for(int i=1;i<table.length;i++)
    {
      for(int j=0;j<table[i].length;j++)
      {
      if(table[i-1][j]==table[i][j])
        {
        	table[i-1][j]*=table[i][j];
        	table[i][j]=0;
        }
        if(table[i-1][j]==0)
        {
          table[i-1][j]=table[i][j];
          table[i][j]=0;
        }
        
      }
    }
  }
  public static void ShowTable(int[][] table)
  {
    cwl("Table Item Count    :"+table.length);
    cwl("Table [0][0] Length :"+table[0].length);
    for(int i=0;i<table.length;i++)
    {
      for(int j=0;j<table[i].length;j++)
      {
        cw(table[i][j]+" ");
      }
      cwl("");
    }
  }
  public static void cwl(Object obj)
  {
    System.out.println(obj);
  }
  public static void cw(Object obj)
  {
    System.out.print(obj);
  }
}
