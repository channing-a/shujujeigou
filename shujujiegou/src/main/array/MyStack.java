package array;


import com.sun.org.apache.regexp.internal.RE;

import java.util.Iterator;

/**
 * @author channing
 * pop   出栈
 * push 入栈
 */
public class MyStack {
   private  int[]  stack;
   private  int    max;
   public   int     top;

    public MyStack(int max) {
        this.stack = new int[max];
        this.top = 0;
    }

    //判空
    public boolean isEmpty(){
        return top == 0;
    }

    //判满
    public boolean isOverflow(){
        return top == stack.length;
    }

    //出栈
    public int pop(){
        if (isEmpty()){
            System.out.println("无数据");
        }
        top--;
        stack[top] = 0;
        return stack[top];
    }

    //入栈
    public int push(int num){
        if (isOverflow()){
            System.out.println("栈满");
        }
        stack[top] = num;
        top++;
        return num;
    }

  public  void show(){
      for (int i = top-1; i >= 0; i--) {
          System.out.println(stack[i]);
      }
  }

}
