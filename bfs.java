

import java.util.*;

public class bfs 
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		Queue que=new Queue();
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
		que.enqueue(x);
		res.add(x);
		while(x<=n && !que.isEmpty())
		{
			x=que.first();
			y=1;
			while(x<n+1 && y<n+1)
			{
				if(a[x][y]==1 && !res.contains(y))
				{
					que.enqueue(y);
					res.add(y);
				}
				y++;
			}
			que.dequeue();
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

class Queue
{
	int size;
	int arr[];
	int initcap;
	public Queue()
	{
		initcap=10;
		arr=new int[initcap];
		size=0;
	}

	public void enqueue(int element) 
	{
		// TODO Auto-generated method stub
		if(size==arr.length)
		{
			changesize();
		}
		arr[size]=element;
		size++;
	}
	
	private void changesize() 
	{
		// TODO Auto-generated method stub
		int[] obj=new int[2*initcap];
		for(int i=0;i<size;i++)
			obj[i]=arr[i];
		arr=obj;
	}

	public int dequeue() 
	{
		// TODO Auto-generated method stub
		for(int i=1;i<size;i++)
			arr[i-1]=arr[i];
		size--;
		return 0;
	}

	public int first() 
	{
		// TODO Auto-generated method stub
		return arr[0];
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if(size==0)
			return true;
		return false;
	}

	public int size() 
	{
		// TODO Auto-generated method stub
		return size;
	}
	
	public void display()
	{
		for(int i=0;i<size;i++)
			System.out.println(arr[i]);
	}
}
