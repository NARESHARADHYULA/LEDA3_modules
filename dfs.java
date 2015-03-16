
import java.util.*;
public class dfs 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Stack<Integer> st=new Stack<Integer>();
		ArrayList<String> al=new ArrayList<String>();
		ArrayList<Integer> res=new ArrayList<Integer>();
		int n=Integer.parseInt(in.nextLine());
		int[][] a=new int[n+1][n+1];
		int c=Integer.parseInt(in.nextLine());
		int k=0;
		while(k<n)
		{
			al.add(in.nextLine());
			k++;
		}
		if(c==0)
			convert(al,a);
		else if(c==1)
		{
			for(int i = 1; i <= n; i++)
			{
				String[] s=al.get(i-1).split(" ");
				for (int j = 1; j <= n; j++) 
				{
					a[i][j]=Integer.parseInt(s[j-1]);
				}
			}
		}
		int x=1,y=1;
		st.push(x);
		res.add(x);
		while(x<=n+1 && !st.isEmpty())
		{
			x=st.peek();
			y=1;
			while(x<n+1 && y<n+1)
			{
				if(a[x][y]==1 && !res.contains(y))
				{
					st.push(y);
					res.add(y);
					x=y;
					y=1;
				}
				y++;
			}
			st.pop();
		}
		for (int i = 0; i < res.size(); i++) 
		{
			System.out.print(res.get(i));
		}
	}

	public static void convert(ArrayList<String> al, int[][] a) 
	{
		int i,j,k=0;
		while(k<al.size())
		{
			int index=0;
			String[] s=al.get(k).split("->");
			i=Integer.parseInt(s[index]);
			for (index = 1; index < s.length; index++) 
			{
				j=Integer.parseInt(s[index]);
				a[i][j]=1;
			}
			k++;
		}
	}
}
