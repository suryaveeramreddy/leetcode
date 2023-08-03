//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		int[][] m=new int[N][N];
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        m[i][j]=(int)1e9;
		    }
		}
		for(int i=0;i<edges.length;i++)
		{
		    m[edges[i][0]][edges[i][1]]=edges[i][2];
		}
		for(int i=0;i<N;i++)
		{
		    for(int j=0;j<N;j++)
		    {
		        for(int k=0;k<N;k++)
		        {
		            m[j][k]=Math.min(m[j][k],(m[j][i]+m[i][k]));
		        }
		    }
		}
		int[] a=new int[N];
		a[0]=0;
		for(int i=1;i<N;i++)
		{
		    if(m[0][i]==(int)1e9)
		    {
		        a[i]=-1;
		    }
		    else
		    {
		        a[i]=m[0][i];
		    }
		}
		return a;
	}
}