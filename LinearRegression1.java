//This program will display the LinerRegression values for data set

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
class LinearRegression1{
public static void main(String args[])throws IOException,Exception{
int MAXN = 1000;
        int n1 = 0;
        double[] xi1 = new double[MAXN];
	    double[] xi2 = new double[MAXN];
        double[] yi = new double[MAXN];
DataInputStream ob=new DataInputStream(System.in);
double sumxi1=0.0,sumxi2=0.0,sumxi3=0.0,sumyi=0.0,xi1sq=0.0,xi2sq=0.0,xi3sq=0.0,xi12=0.0,xi13=0.0,xi23=0.0,xi1y=0.0,xi2y=0.0,xi3y=0.0;

FileInputStream fstream = new FileInputStream("D:/Project/java/Book2.txt");

DataInputStream in = new DataInputStream(fstream);
BufferedReader br = new BufferedReader(new InputStreamReader(in));
String strLine = null;
int z=0;
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

int n=12;
double [][] equationMatrix=new double[3][4];
equationMatrix[0][0]=n;equationMatrix[0][1]=sumxi1;equationMatrix[0][2]=sumxi2;equationMatrix[0][3]=sumyi;
equationMatrix[1][0]=sumxi1;equationMatrix[1][1]=xi1sq;equationMatrix[1][2]=xi12;equationMatrix[1][3]=xi1y;
equationMatrix[2][0]=sumxi2;equationMatrix[2][1]=xi12;equationMatrix[2][2]=xi2sq;equationMatrix[2][3]=xi2y;
for(int k1=0;k1<3;k1++)
{
for(int k2=0;k2<4;k2++)
{
System.out.print("\t"+equationMatrix[k1][k2]);
}
System.out.println();
}
int nVar=3;
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
System.out.println("y="+ans[1]+"*x1+"+ans[2]+"*x2"+"+"+ans[0]);
}}
