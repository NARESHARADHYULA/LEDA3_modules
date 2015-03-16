import java.io.*;
import java.util.*;
public class bst {
public static void main(String args[] ) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    Scanner in= new Scanner(System.in);
    String s=in.nextLine();
    //System.out.println(s);
    String[] a=s.split(",");
    doublinkedlist lists = new doublinkedlist(); 
    for(int i=0;i<a.length;i++)
        {
    	//System.out.println("hi");
           if(a[i].charAt(0)=='I')
               lists.insert(Integer.parseInt(a[i].substring(1)));
           else if(a[i].charAt(0)=='S')
               lists.locate(Integer.parseInt(a[i].substring(1)));
               else
               {
               lists.delete1(Integer.parseInt(a[i].substring(1)));
               lists.display();
           }
    }
}
}
class Nodes
{
	int data;
	Nodes next;
	Nodes prev;
   public Nodes()
   {
	   this.data=0;
	   this.next=null;
	   this.prev=null;
   }
   public Nodes(int data,Nodes prev,Nodes next)
   {
	   this.data=data;
	   this.next=next;
	   this.prev=prev;
   }
  
   
}

class doublinkedlist{
	Nodes root,temp;
	int size;
    String s="";
    public doublinkedlist()
    {
        root=null;
        size = 0;
    }
    public void insert(int val)
    {
    	Nodes n=new Nodes();
    	n.data=val;
    	if(root==null)
    	{
    		root=n;
    		size++;
    	}
    	else
    	{
    		temp=root;
    		while(temp!=null)
    		{
	    		if(val<temp.data)
	    		{
	    			if(temp.prev==null)
	    			{
	    				temp.prev=n;
	    				size++;
	    				break;
	    			}
	    			else
	    			temp=temp.prev;
	    		
	    		}
	    		else
	    		{
	    			if(temp.next==null)
	    			{
	    			
	    				temp.next=n;
	    				size++;
	    				break;
	    			}
	    			else
	    			temp=temp.next;
	    		}
    		}
    			
    	}
    	inorder(root);
        System.out.println(s.substring(0,s.length()-1));
        s="";
    }
    public void locate(int val)
    {
        //System.out.println(val);
    	temp=root;
        int c=0;
        boolean flag=false;
        while(temp!=null)
          {
            c++;
            if(temp.data==val)
                {
             flag=true;
                break;
            }
            else if(val<temp.data)
                temp=temp.prev;
             else
                temp=temp.next;
        }
        if(flag)
            System.out.println("true,"+c);
        else
            {
            findNextHighest(root,val);
        }
 	  
 	 }
    public int findNextHighest(Nodes n,int val)
    {
        
        if(val<n.data)
            {
            
            if(val>n.prev.data)
                {
                System.out.println("false,"+n.data);
                return n.data;
            }
            else
                findNextHighest(n.prev,val);
        }
        else
            {
           if(val<n.next.data)
               {
               System.out.println("false,"+n.data);
                return n.data;
           }
            else
                findNextHighest(n.next,val);
        }
           return n.data; 
        
    }
    public Nodes delete1(int val)
        {
        return delete(root,val);
    }
     public Nodes delete(Nodes n,int val)
         {
         Nodes t=null;
            if(val<n.data)
               n.prev=delete(n.prev,val);
            else if(val>n.data)
                n.next=delete(n.next,val);
            else
                {
                if(n.prev!=null && n.next!=null)
                    {
				t=findMax(n.prev);
				n.data=t.data;
				n.prev=delete(n.prev,n.data);
                    }
                else if(n.prev==null)
                      n=n.next;
                else if(n.next==null)
                    n=n.prev;
                    else
                    n=null;
                } 
         return n;
         }
    private Nodes findMax(Nodes n) 
	{
		while(n.next!=null)
		{
			n=n.next;
		}
		return n;  
	}
     public void display()
         {
         postorder(root);
         System.out.println(s.substring(0,s.length()-1));
        s="";
     }
    public void postorder(Nodes n)
    {
        if (n!=null)
        {
            postorder(n.prev);             
            postorder(n.next);
             s=s+n.data+",";
        }
    }
    public void inorder(Nodes n)
    {
        if (n!=null)
        {
            inorder(n.prev);   
            s=s+n.data+",";
            inorder(n.next);
        }
    }
}