package array;



import java.util.Iterator;

/**
 * @author channing
 * 自定义链表
 */
public class MyLinkList implements Iterable {
    private Node first;
    private Node current;
    private int size;

    public MyLinkList() {
    }

    //判断链表是否为空
    public boolean isNull(){
        return  first==null;
    }

    //添加尾数据
    public int addLast(int last){
        Node node = new Node();
        node.setData(last);
        if (isNull()) {
            first = node;
            current = node;
        }else {
            current.setNextNode(node);
          current = node;
        }
        size++;
        return last;
    }

    //添加头数据
    public int addFirst(int head){
        Node node = new Node();
        node.setData(head);
        if (isNull()){
            first = node;
            current = node;
        }
        node.setNextNode(first);
        first = node;
        size ++;
        return head;
    }

    //插入数据
    public int add(int index,int data){
       if (index >= size){
           throw new RuntimeException("该链表长度未达到预期值,当前长度为:"+size);
       }

       if (index == 0){
           addFirst(data);
       }

       if (index == size-1){
           addLast(data);
       }

       int i = 0;
       Node fNode = first;
       Node lNode = first ;
        Node node = new Node();
        node.setData(data);
        while (index-2>=i){
           fNode =  fNode.getNextNode();
           i++;
       }
        int j=0;
        while (index-1>=j){
            lNode =  lNode.getNextNode();
            j++;
        }
        fNode.setNextNode(node);
        node.setNextNode(lNode);

        size++;
        return data;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            Node node = first;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public Object next() {
                int data = node.getData();
                node = node.getNextNode();
                return data;
            }
        };
    }


class Node{
    private int data;
    private Node nextNode;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

}}