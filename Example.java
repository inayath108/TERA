import java.io.*;
public class Example {
	public static void main(String args[])throws Exception{
		int n;
		System.out.println("Enter number of varaibles");
		DataInputStream ob=new DataInputStream(System.in);
	    n=Integer.parseInt(ob.readLine());
	    System.out.println("Enter number of observations");
			   int n2=Integer.parseInt(ob.readLine());
	       	double[] xi1 = new double[1000];
		    double[] xi2 = new double[1000];
	        double[] yi = new double[1000];
	        double[] xi3 = new double[1000];
	        double[] xi4 = new double[1000]; 
	     
	    int n1 = 0;
	    double sumxi1=0.0,sumxi2=0.0,sumxi3=0.0,sumxi4=0.0,sumyi=0.0,xi1sq=0.0,xi2sq=0.0,xi3sq=0.0,xi4sq=0.0,xi12=0.0,xi13=0.0,xi14=0.0,xi23=0.0,xi24=0.0,xi34=0.0,xi1y=0.0,xi2y=0.0,xi3y=0.0,xi4y=0.0;
	    FileInputStream fstream = new FileInputStream("D:/Project/java/Book2.txt");

	    DataInputStream in = new DataInputStream(fstream);
	    BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    String strLine = null;
	    int z=0;
	       if(n==3){
	    	   while ((strLine = br.readLine()) != null)   {
	       
		 	String m[]=strLine.split("\t");
		 	
	        
	            yi[n1] = Double.parseDouble(m[z]);
	            xi1[n1] =Double.parseDouble(m[++z]);
		    xi2[n1] = Double.parseDouble(m[++z]);            
	            sumxi1  += xi1[n1];
		    sumxi2  += xi2[n1];
	            sumyi   += yi[n1];
	            xi1sq += xi1[n1] * xi1[n1];
		    xi2sq += xi2[n1] * xi2[n1];
	            xi12  += xi1[n1] * xi2[n1];
	            xi1y  += xi1[n1] * yi[n1];
	            xi2y  += xi2[n1] * yi[n1];
	            n1++;
	        z=0;
		 	}
	       }
	       if(n==4){
	    	   while ((strLine = br.readLine()) != null)   {
	       
		 	String m[]=strLine.split("\t");
		 	
	        
	            yi[n1] = Double.parseDouble(m[z]);
	            xi1[n1] =Double.parseDouble(m[++z]);
		    xi2[n1] = Double.parseDouble(m[++z]);            
	        xi3[n1]=Double.parseDouble(m[++z]);    
		    sumxi1  += xi1[n1];
		    sumxi2  += xi2[n1];
		    sumxi3 +=xi3[n1];
	            sumyi   += yi[n1];
	            xi1sq += xi1[n1] * xi1[n1];
		    xi2sq += xi2[n1] * xi2[n1];
		    xi3sq+=xi3[n1]*xi3[n1];
	            xi12  += xi1[n1] * xi2[n1];
	            xi1y  += xi1[n1] * yi[n1];
	            xi2y  += xi2[n1] * yi[n1];
	            xi3y  += xi3[n1] * yi[n1];
	            xi13  += xi1[n1] * xi3[n1];
	            xi23  += xi2[n1] * xi3[n1];
	            n1++;
	        z=0;
		 	}
	       }
	       if(n==5){
	    	   while ((strLine = br.readLine()) != null)   {
	       
		 	String m[]=strLine.split("\t");
		 	
	        
	            yi[n1] = Double.parseDouble(m[z]);
	            xi1[n1] =Double.parseDouble(m[++z]);
		    xi2[n1] = Double.parseDouble(m[++z]);            
	        xi3[n1]=Double.parseDouble(m[++z]);    
	        xi4[n1]=Double.parseDouble(m[++z]); 
	        sumxi1  += xi1[n1];
		    sumxi2  += xi2[n1];
		    sumxi3 +=xi3[n1];
	        sumxi4 +=xi4[n1];
	        sumyi   += yi[n1];
	            xi1sq += xi1[n1] * xi1[n1];
		    xi2sq += xi2[n1] * xi2[n1];
		    xi3sq+=xi3[n1]*xi3[n1];
	        xi4sq+=xi4[n1] * xi4[n1];
	        xi12  += xi1[n1] * xi2[n1];
	            xi1y  += xi1[n1] * yi[n1];
	            xi2y  += xi2[n1] * yi[n1];
	            xi3y  += xi3[n1] * yi[n1];
	            xi4y += xi4[n1] * yi[n1];
	            xi13  += xi1[n1] * xi3[n1];
	            xi14  += xi1[n1] * xi4[n1];
	            xi23  += xi2[n1] * xi3[n1];
	            xi24  += xi2[n1] * xi4[n1];
	            xi34 += xi3[n1] *xi4[n1];
	            n1++;
	        z=0;
		 	}
	       }
	       double [][] eq=new double[3][4];
	       double [][] equationMatrix1=new double[4][5];
	       double [][] equationMatrix2=new double[5][6];
	       if(n==3){
	    	   eq[0][0]=n2;eq[0][1]=sumxi1;eq[0][2]=sumxi2;eq[0][3]=sumyi;
	    	   eq[1][0]=sumxi1;eq[1][1]=xi1sq;eq[1][2]=xi12;eq[1][3]=xi1y;
	    	   eq[2][0]=sumxi2;eq[2][1]=xi12;eq[2][2]=xi2sq;eq[2][3]=xi2y;
	       }
	       if(n==4){
	    	   equationMatrix1[0][0]=n2;equationMatrix1[0][1]=sumxi1;equationMatrix1[0][2]=sumxi2;equationMatrix1[0][3]=sumxi3;equationMatrix1[0][4]=sumyi;
	    	   equationMatrix1[1][0]=sumxi1;equationMatrix1[1][1]=xi1sq;equationMatrix1[1][2]=xi12;equationMatrix1[1][3]=xi13;equationMatrix1[1][4]=xi1y;
	    	   equationMatrix1[2][0]=sumxi2;equationMatrix1[2][1]=xi12;equationMatrix1[2][2]=xi2sq;equationMatrix1[2][3]=xi23;equationMatrix1[2][4]=xi2y;
	    	   equationMatrix1[3][0]=sumxi3;equationMatrix1[3][1]=xi13;equationMatrix1[3][2]=xi23;equationMatrix1[3][3]=xi3sq;equationMatrix1[3][4]=xi3y;
		       
	       }
	       if(n==5){
	    	   equationMatrix2[0][0]=n2;equationMatrix2[0][1]=sumxi1;equationMatrix2[0][2]=sumxi2;equationMatrix2[0][3]=sumxi3;equationMatrix2[0][4]=sumxi4;equationMatrix2[0][5]=sumyi;
	    	   equationMatrix2[1][0]=sumxi1;equationMatrix2[1][1]=xi1sq;equationMatrix2[1][2]=xi12;equationMatrix2[1][3]=xi13;equationMatrix2[1][4]=xi14;equationMatrix2[1][5]=xi1y;
	    	   equationMatrix2[2][0]=sumxi2;equationMatrix2[2][1]=xi12;equationMatrix2[2][2]=xi2sq;equationMatrix2[2][3]=xi23;equationMatrix2[2][4]=xi24;equationMatrix2[2][5]=xi2y;
	    	   equationMatrix2[3][0]=sumxi3;equationMatrix2[3][1]=xi13;equationMatrix2[3][2]=xi23;equationMatrix2[3][3]=xi3sq;equationMatrix2[3][4]=xi34;equationMatrix2[3][5]=xi3y;
	    	   equationMatrix2[4][0]=sumxi4;equationMatrix2[4][1]=xi14;equationMatrix2[4][2]=xi24;equationMatrix2[4][3]=xi34;equationMatrix2[4][4]=xi4sq;equationMatrix2[4][5]=xi4y;       
	       }
	       if(n==3){
	    	   for(int k1=0;k1<3;k1++)
	       {
	       for(int k2=0;k2<4;k2++)
	       {
	       System.out.print("\t"+eq[k1][k2]);
	       }
	       System.out.println();
	       }
}
	       if(n==4){
	    	   for(int k1=0;k1<4;k1++)
	       {
	       for(int k2=0;k2<5;k2++)
	       {
	       System.out.print("\t"+equationMatrix1[k1][k2]);
	       }
	       System.out.println();
	       }
}
	       if(n==5){
	    	   for(int k1=0;k1<5;k1++)
	       {
	       for(int k2=0;k2<6;k2++)
	       {
	       System.out.print("\t"+equationMatrix2[k1][k2]);
	       }
	       System.out.println();
	       }
}
	       
	       double equationMatrix[][]=new double[10][10];
	       if(n==3)
	    	   equationMatrix=eq;
	       
	       if(n==4)
	    	   equationMatrix=equationMatrix1;
              if(n==5)
            	 equationMatrix=equationMatrix2; 
              int nVar=n;
              for (int i=0; i<nVar;i++)
              {
                  //If the element is zero, make it non zero by row operation
                  if(equationMatrix[i][i]==0)
                  {
                      int j;
                      for (j = i+1; j < nVar; j++)
                      {
                          if (equationMatrix[j][i] != 0)
                          {
                              for (int k = i; k < nVar + 1; k++)
                                  equationMatrix[i][k] += equationMatrix[j][k];
                              break;
                          }
                      }
                      //If all value for this variable is zero, there should a duplicated equation
                      if (j == nVar)
                          throw new Exception("Same equation repeated. Can't solve it");
                  }

                  //make the diagonal element as 1
                  for (int k = nVar; k >= i; k--)
                      equationMatrix[i][k] /= equationMatrix[i][ i];

                  //use row operation to make upper matrix
                  for (int j = i+1; j < nVar; j++)
                  {
                      for (int k = nVar; k >= i; k--)
                          equationMatrix[j][k] -= equationMatrix[i][k]*equationMatrix[j][i];
                  }
              }

              //It is to make diagonal matrix
              for (int i = nVar-1; i > 0; i--)
              {
                  for(int j=i-1; j>=0; j--)
                  {
                      equationMatrix[j][nVar] -= equationMatrix[j][i] * equationMatrix[i][nVar];
                      equationMatrix[j][i]=0.0;
                  }
              }

              double []ans = new double[nVar];
              for(int j=0; j < nVar; j++)
               {
                 ans[j]=equationMatrix[j][nVar];
              System.out.println(ans[j]);
              }

	       }
}