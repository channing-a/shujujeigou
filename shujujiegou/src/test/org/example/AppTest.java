package org.example;

import static org.junit.Assert.assertTrue;

import array.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        int[][]  a={{3,5,5},{2,2,6},{1,3,7},{2,4,3}};
        XiSuArray xiSuArray = new XiSuArray(a);
        xiSuArray.toXiSuArray();

//        xiSuArray.toArray(a);
    }

    @Test
    public void  queue(){
        MyQueue myQueue = new MyQueue(5);
        System.out.println(myQueue.add(151));
        System.out.println(myQueue.add(153));
        System.out.println(myQueue.add(125));
        System.out.println(myQueue.add(5));
        System.out.println(myQueue.add(1));
        System.out.println(myQueue.toString());
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
        System.out.println(myQueue.get());
        System.out.println(myQueue.toString());
    }

    @Test
    public void  linktest(){
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.addLast(4);
        myLinkList.addLast(5);
        myLinkList.addLast(6);
        myLinkList.addLast(7);
        myLinkList.addFirst(3);
        myLinkList.addFirst(2);
        myLinkList.addFirst(1);
        myLinkList.add(2, 10);
        myLinkList.add(5, 20);
        Iterator iterator = myLinkList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void  josephRing() throws InterruptedException {
        JosephRing josephRing = new JosephRing();
        josephRing.addRing(10);
        josephRing.decrease(3);
        Iterator iterator = josephRing.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void  testStack(){
        MyStack myStack = new MyStack(10);
        for (int i = 0; i < 10; i++) {
          myStack.push(i + 10);
        }
        myStack.pop();
        myStack.show();

    }
}
