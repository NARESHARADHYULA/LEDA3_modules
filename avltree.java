import java.io.*;
import java.util.*;
public class avltree {
public static void main(String args[] ) throws Exception {
     Scanner in= new Scanner(System.in);
    String p="",c="";
    String[] s=in.nextLine().split(",");
        int r=Integer.parseInt(in.nextLine());
     String t=in.nextLine();
    doublinkedlist1 lists = new doublinkedlist1();
    for(int i=0;i<s.length;i++)
        {
            lists.insert(Integer.parseInt(s[i]));
        }
    while(lists.root.data!=r)
        {
          c=lists.locate(r);
        if(c=="r")
            lists.rotateRight();
        else
            lists.rotateLeft();
        }
      
    System.out.println(lists.count);
    if(t=="1")
        {
        p=lists.preorder();
        System.out.println(p.substring(0,p.length()-1));
         }
         else if(t=="2")
            {
        p=lists.inorder();
        System.out.println(p.substring(0,p.length()-1));
          }
        else
        {
        p=lists.postorder();
        System.out.println(p.substring(0,p.length()-1));
          }
    
}
}
class Node1
{
	int data;
    int height;
	Node1 next;
	Node1 prev;
	Node1 parent;
   public Node1()
   {
	   this.data=0;
       this.height=0;
	   this.next=null;
	   this.prev=null;
	   this.parent=null;
   }
   public Node1(int data,Node1 prev,Node1 next)
   {
	   this.data=data;
       this.height=0;
	   this.next=next;
	   this.prev=prev;
	   this.parent=null;
   } 
}

class doublinkedlist1{
	Node1 root,temp,temp2;
	int size;
    int count=0;
    String s="",c="";
    public doublinkedlist1()
    {
        root=null;
        size = 0;
    }
    public void insert(int val)
    {
    	Node1 n=new Node1();
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
	    				temp.prev.parent=temp;
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
	    				temp.next.parent=temp;
	    				size++;
	    				break;
	    			}
	    			else
	    			temp=temp.next;
	    		}
    		}
    			
    	}
    	
    }
    public void rotateLeft()
        {
    	
    	if(temp2.data==root.data)
    	{
    		root=rotateLeft(temp2);
    	}
    	else
    	{
    		Node1 n1=rotateLeft(temp2);
        	Node1 n2=temp2.parent;
        if(n1.data<=n2.data)
        	n2.prev=n1;
        else
        	n2.next=n1;
    	}
        
        count++;
    }
    public void rotateRight()
        {
    	if(temp2.data==root.data)
    	{
    		root=rotateRight(temp2);
    	}
    	else
    	{
    		Node1 n1=rotateRight(temp2);
        	Node1 n2=temp2.parent;
        if(n1.data<=n2.data)
        	n2.prev=n1;
        else
        	n2.next=n1;
    	}
         count++;
    }
    public Node1 rotateRight(Node1 k1)
     { 
        Node1 k2=new Node1();
          k2 = k1.prev;
         k1.prev = k2.next;
         k2.next = k1;
         k1.height = max( height( k1.prev ), height( k1.next ) ) + 1;
         k2.height = max( height( k2.prev ), k1.height ) + 1;
        
         return k2; 
        
     }
     
     public Node1 rotateLeft(Node1 k1)
     {
         Node1 k2=new Node1();
          k2 = k1.next;
         k1.next = k2.prev;
         k2.prev = k1;
         k1.height = max( height( k1.prev ), height( k1.next ) ) + 1;
         k2.height = max( height( k2.next ), k1.height ) + 1;
         return k2;
     }
    public int height(Node1 t )
     {
         return t == null ? -1 : t.height;
     }
     public int max(int lhs, int rhs)
     {
         return lhs > rhs ? lhs : rhs;
     }
     public String locate(int val)
    {
       // System.out.println(val);
         temp2=new Node1();
    	temp=root;
         c="";
        while(temp!=null)
          {
            if(temp.data==val)
                {
            
                break;
            }
            else if(val<temp.data)
                {
                temp2=temp;
                temp=temp.prev;
                c="r";
            }
             else
                 {
                 temp2=temp;
                temp=temp.next;
                  c="l";
             }
        }
         //System.out.println("locate"+c+temp2.data+temp.data);
 	  return c;
 	 }
     public String postorder()
         { 
         s="";
            postorder(root);
         return s;
          }
  public void postorder(Node1 n)
    {
      
        if (n!=null)
        {
            postorder(n.prev);             
            postorder(n.next);
             s=s+n.data+",";
        }
     
    }
    public String inorder()
         { 
        s="";
            inorder(root);
         return s;
          }
    public void inorder(Node1 n)
    {
        if (n!=null)
        {
            inorder(n.prev);   
            s=s+n.data+",";
            inorder(n.next);
        }
        
    }
    public String preorder()
         { 
        s="";
            preorder(root);
         return s;
          }
    public void preorder(Node1 n)
    {
       
        if (n!=null)
        {
             s=s+n.data+",";
            preorder(n.prev);   
            preorder(n.next);
        }
        
    }
}

