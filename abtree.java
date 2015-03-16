import java.io.*;
import java.util.*;


public class abtree {
abnode root=null;  int b,a;
public static void main(final String[] args) {


}


public void search(abnode root,final int key){
int e=0,i=0; 
for (i = 0;  i<b; i++) {
if(root.splitters[i].equals("")){
e=0;
break;
}
else {
e=1;
if(Integer.parseInt(root.splitters[i])>key){
break;
}
}
}
// no element is inserted at splitter array
if(e==0){
if(root.pointers[i]==null){
// call insert function
}
else{
root=root.pointers[i];
search(root,key);
}
}
else {
if(root.pointers[i]==null){
// call insert function
}
else {
root=root.pointers[i];
search(root,key);
}
}

if(i==b) {
if(root.pointers[i]==null){
// call insert function
}
else{
root=root.pointers[i+1];
search(root,key);
}
}
}
public abnode insert(abnode temp, int key){
temp.splitters[b]=key+"";int d=0;
abnode right = null,left = null;
Arrays.sort(temp.splitters);
if(!temp.splitters[b].equals("")){
// split is needed 
right=new abnode(b);
left=new abnode(b);
d=(int)Math.ceil(b+1/2);
for (int i = 0; i <b-d; i++) {
left.splitters[i]=temp.splitters[i];
}
int i=b+1-d,j=0;
for (i = 0; i <b; i++) {
right.splitters[j]=temp.splitters[i];
j++;
}

}
if(temp.prev==null){
// having no parent 
root.splitters[0]=temp.splitters[b-d];
root.pointers[0]=left;
root.pointers[1]=right;
return root;

}
/// if having child then what
else{
///temp=prev;
///temp=insrt();
}
// we are losing left child and right child  adress when we recurce
// didnot initialize prev also
return null;
}
}
class abnode{
String[] splitters;
int count;
abnode[] pointers;
abnode prev;

public abnode(int b) {
splitters=new String[b];
pointers=new abnode[b];

}

}