import java.util.*;
import java.io.*;
public class djistrauss {
    static Hashtable<String,Integer> h=new Hashtable<String,Integer>();
    
public static void main(String args[] ) throws Exception {
    Scanner in=new Scanner(System.in);
   /* while(in.hasNext())
         {
             String s1=in.nextLine();
        System.out.println(s1);
         }*/
    int n1=Integer.parseInt(in.nextLine());
    String s1=in.nextLine();
    String s2=in.nextLine();
    int a[][]=new int[n1][n1];
    int k=0;
  
    String[] s3=s2.substring(1,s2.length()-1).split(",");
    for(int i=0;i<s3.length;i++)
        h.put(s3[i],i);
    
    while(k<n1){
        String s4[]=in.nextLine().split(",");
        for(int i=0;i<s4.length;i++)
            a[k][i]=Integer.parseInt(s4[i]);
            k++;
           
    }
    djikstros(a,s1);
}
    public static void djikstros(int a[][],String s)
    {   
        int n=h.get(s);
        int d[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        	d[i]=99999;
        String pt[]=new String[a.length];
         ArrayList<String> q=new ArrayList<String>();
         ArrayList<Integer> q1=new ArrayList<Integer>();
        pt[n]=s;
        d[n]=0;
        q.add(s+d[n]+"");
        q1.add(d[n]);
       
        add(q,q1,d,a,pt);
        System.out.println(s+":"+d[h.get(s)]);
        print(pt,d,a,s);
       
    }
    public static void add( ArrayList<String> q, ArrayList<Integer> q1,int[] d,int a[][], String pt[])
        {
         String u="";
        while(!q.isEmpty()){
        	 ArrayList<String> node=new ArrayList<String>();
            Collections.sort(q1);
          
            int temp=q1.get(0);
            q1.remove(0);
            int t=0;
            while(t<q.size())
                {
            	
                 if(Integer.parseInt(q.get(t).substring(1))==temp)
                     {
                     u=q.get(t).charAt(0)+"";
                     
                     q.remove(t);
                    }  
                t++;
               }
            int index=h.get(u);
            for(int i=0;i<a.length;i++){
            	if(a[index][i]!=0){
            		node.add(getValue(i));
            	}
            }
          
        for(int i=0;i<node.size();i++){
        	if(d[index]+a[index][h.get(node.get(i))]<d[h.get(node.get(i))]){
        		
        		d[h.get(node.get(i))]=d[index]+a[index][h.get(node.get(i))];
        		pt[h.get(node.get(i))]=u;
        		if(q.contains(node.get(i)+a[index][h.get(node.get(i))]+"")){
        			
        			  int indx=q.indexOf(node.get(i)+a[index][h.get(node.get(i))]+"");
        			  q.set(indx ,node.get(i)+d[h.get(node.get(i))]+"");
        			  q1.set(indx,d[h.get(node.get(i))]);
        			}
        			else{
        				q.add(node.get(i)+a[index][h.get(node.get(i))]+"");
        				
        				q1.add(a[index][h.get(node.get(i))]);
        			    }
        		}
        	}
        }
    }
    public static void print(String[] pt,int[] d,int a[][],String s)
        {
         int i=1,j=2;
        while(i<a.length)
        {
        	String p=getValue(i);
        	String g=p;
        	  String res=p;
        	  if(pt[h.get(p)]!=null){
         	while(!pt[h.get(p)].equals(s+"")){
        		res=pt[h.get(p)]+"->"+res;
        		p=pt[h.get(p)];
        		//j++;
        	}
         	System.out.println(pt[h.get(p)]+"->"+res+":"+d[h.get(g)]);
        	  }
        	  else
        	  {
        		System.out.println(s+"->"+p+":"+d[h.get(p)]);
        	  }
        	i++;
        }
        
    }
    public static String getValue(int i)
    {
    	for ( String key : h.keySet() ) 
        {
    		 if(i==h.get(key))
             {
    			 
    			 return key;
    		 }
    			 
    	}
    	return "";
    }
   }