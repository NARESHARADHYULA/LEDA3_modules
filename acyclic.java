import java.util.*;
public class acyclic {

    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) 
    {
      int vertexs=Integer.parseInt(sc.nextLine());
        int[][] inpt=new int[vertexs][vertexs];
        int c2=0,c1=0;
        for(int i=0;i<vertexs;i++)
        {
            for(int j=0;j<vertexs;j++)
            {
                inpt[i][j]=0;c2++;
            }
        }
        int st=Integer.parseInt(sc.nextLine()),sty=Integer.parseInt(sc.nextLine()),c=0;
        String s="";
        if(sty==1)
        {
        c2=0;
            while(sc.hasNextLine() && c<vertexs)
            {
                String arti=sc.nextLine();c2++;
                String arti2[]=arti.split(",");
                for(int i=0;i<vertexs;i++)
                {
                    inpt[c][i]=Integer.parseInt(arti2[i]);c1++;
                }
                c++;
            }
        }
        else
        {
            ArrayList<String> arti=new ArrayList<String>();
            while(sc.hasNextLine() && c<vertexs)
            {
                arti.add(sc.nextLine());c1++;
                c++;
            }
            for(int i=0;i<arti.size();i++)
            {
                String arti2[]=arti.get(i).split("->");
                int y=Integer.parseInt(arti2[0]);c2++;
                for(int j=1;j<arti2.length;j++)
                {
                    int x=Integer.parseInt(arti2[j]);c2++;
                    inpt[y-1][x-1]=1;
                }
                c1++;
            }
        }
        Mod16(inpt,st,c1,c2);
        for(int a=0;a<vertexs;a++)
        {
            for(int b=0;b<vertexs;b++)
            {
                //System.out.print(inpt[a][b]+" ");c2++;
            }
            //System.out.println();
        }
        
    }      
           public static void Mod16(int inpt[][], int st,int c,int c1) throws NullPointerException
            {
                 Stack<Integer> ruf= new Stack<Integer>();
                int number_nodes = inpt[st].length - 1;
                int pos = 1;
                int j,flag=0,flag1=0;
                int visited[] = new int[number_nodes + 1];
                int stuf = st;
                int i = st;
                visited[st] = 1;
                ruf.push(st);
                while (!ruf.isEmpty())
                {
                    
                    stuf = ruf.peek();
                    while (i <= number_nodes)
                    {
                        if (inpt[stuf][i] != 0 && visited[i] == 1)
                        {
                            if (ruf.contains(i))
                            {
                                System.out.println("Graph has cycles");
                                flag=1;
                                break;
                            }
                            else
                                flag1=1;
                        }
                        if (inpt[stuf][i] != 0 && visited[i] == 0)
                        {
                            ruf.push(i);
                            visited[i] = 1;
                            stuf = i;
                            i = 1;
                            continue;
                        }
                        i++;
                    }
                    if(flag==1)
                    {
                        break;
                    }
                    j = ruf.pop();
                    i = ++j;
                    if(flag1==1)
                    {
                    System.out.println("Graph has no cycles");
                    }
                    flag=0;flag1=0;
                } }  }