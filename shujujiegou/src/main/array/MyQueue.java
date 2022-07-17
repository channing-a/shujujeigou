package array;

import java.util.Arrays;

public class MyQueue {
    private int rear;
    private int tail ;
    private int[] body;

    public MyQueue(int size) {
        this.body = new int[size];
        System.out.println(Arrays.toString(body));
    }

    /**
     * 判断队列是否为空
     */
    public boolean isNull() {
        return rear != tail ?false:true;
    }
   /**
    * 判断是否已满*/
    public boolean isOverflow(){
        return tail < body.length? false : true;
    }

    /**
     * 插入数据
     */
    public int  add(int num) {
        if (isOverflow()) {
            return -1;
        }
        body[rear] = num;
        rear++;
     return num;
    }

    /**
     * 取出数据
     */
    public int get(){
        if (isNull()){
            return -1;
        }
        int num = body[0];
        for (int i = 0; i < body.length-1; i++) {
            body[i] = body[i+1];
        }

        rear--;
        body[rear] = 0;
       return num;
    }

    @Override
    public String toString() {
        return "MyQueue{" +
                "rear=" + rear +
                ", tail=" + tail +
                ", body=" + Arrays.toString(body) +
                '}';
    }
}
