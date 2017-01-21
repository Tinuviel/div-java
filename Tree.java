import java.io.*;
/**
 * 
 * tillägg av Lovisa Colérus
 * Lagt till en get-function
 * 2016
 *
 */
class Node implements Serializable{
	Integer value;
 	Node left, right;
	public Node(Integer o){
		this.value=o;
	}
}

class SearchTree implements Serializable{
	private Node root;
	public SearchTree(){
	    root = null;
	}
	
    public void put(Integer value){
	    root = put(value, root);
	}
    
    /**
     * lagt till en getfunktion för roten
     * @return
     */
    public Node getRoot(){
    	return root;
    }
	
    private Node put(Integer value, Node pointer){
	if (pointer==null)
	    pointer= new Node(value);
	else if (pointer.value > value)
	    pointer.left=put(value,pointer.left);
	else if (pointer.value < value)
	    pointer.right=put(value,pointer.right);
	else{
	    System.out.println("dubbla objekt");
	}
	    return pointer;
}

    public void writeTree(){
	writeTree(root);
    }

    private void writeTree(Node pointer){
        if(pointer==null)
             return;
        else{
        	writeTree(pointer.left);
        	writeTree(pointer.right);
        	System.out.println(pointer.value);

        }
    }
    
    public static void main(String[] args){
    	SearchTree st=new SearchTree();
    	SearchTree st2=new SearchTree();
    	st.put(7);
    	st.put(10);
    	st.put(11);
    	st.put(8);
    	st.put(5);
    	st.put(6);
    	st.put(4);
    	st.writeTree();
    	st2.put(7);
    	st2.put(10);
    	st2.put(11);
    	st2.put(56);
    	st2.put(5);
    	st2.put(6);
    	st2.put(2);
    	st2.put(3);
    	st2.put(4);
    	st2.put(34);
    	st2.writeTree();
    	System.out.println("Antal löv: " + TreeMethods.countLeaves(st.getRoot()));
    	System.out.println("Är de två lika? " + TreeMethods.equal(st.getRoot(), st2.getRoot()));
    	System.out.println("Djupet är: " + TreeMethods.depth(st2.getRoot()));
    	SearchTree stcopy = new SearchTree();
    	stcopy.root = TreeMethods.copyTree(st.getRoot());
    	st.writeTree();
    	stcopy.writeTree();
    	
    }
}

/*
class Test{
    public static void main(String[] args){
	SearchTree st=new SearchTree();
	st.put(7);
	st.put(10);
	st.put(11);
	st.put(8);
	st.put(5);
	st.put(6);
	st.put(4);
	st.writeTree();
	TreeMethods.countLeaves(st);
	/*try
      {
         FileOutputStream fileOut = new FileOutputStream("tree.ser");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(st);
         out.close();
         fileOut.close();
         System.out.printf("tradet finns pa fil nu!");
      }catch(IOException i)
      {
          i.printStackTrace();
      }
    }		
}	


class Test2{
    public static void main(String[] args)throws IOException{
	SearchTree st = null;
	FileInputStream fileIn = new FileInputStream("tree.ser");
	ObjectInputStream in = new ObjectInputStream(fileIn);
	try{
	    st = (SearchTree) in.readObject();
	}catch(ClassNotFoundException c)
	    {
		System.out.println("Searchtree class not found");
		c.printStackTrace();
		return;
	    }
	in.close();
	fileIn.close();
	
	
	System.out.println("Deserialized Tree...");
	st.writeTree();
    }
}*/
