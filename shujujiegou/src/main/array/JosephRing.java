package array;

import java.util.Iterator;

/**
 * @author channing
 */
public class JosephRing implements Iterable{
    private int size;
    private Node headNode;
    private Node thisNode ;
    private Node endNode;
   //是否为空
   public boolean isNull(){
       return thisNode == null? true :false;
   }

   //加入环节点个数
    public int addRing(int sum){
       size = sum;
       if (isNull()){
           thisNode = new Node();
           headNode = thisNode;
           thisNode.setId(1);
       }
       int i = 2;
       while (sum>=i){
           endNode = new Node();
           endNode.setId(i);
           thisNode.setNextNode(endNode);
           thisNode = endNode;
           if (sum == i){
               endNode.setNextNode(headNode);
           }
           i++;
       }
       return 1;
    }

    public Object decrease(int a){

       while (size>=1) {
           Node fNode = headNode;
           Node lNode = headNode;
           for (int i = 0; i < a - 2; i++) {
               fNode = fNode.getNextNode();
           }
           for (int j = 0; j < a; j++) {
               lNode = lNode.getNextNode();
           }
           fNode.setNextNode(lNode);
           headNode = lNode;
           size--;
       }
        return a;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node node = headNode;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public Object next() {
                int id = node.getId();
                node = node.getNextNode();
                return id;
            }
        };
    }
}

class Node{
    private int id;
    private Node nextNode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
