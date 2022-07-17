package array;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author channing
 */
public class XiSuArray implements Serializable {
  private int[][] array;

  public XiSuArray() {
  }

  public XiSuArray(int[][] array) {
    this.array = array;
  }

  //转化为稀疏数组
  public int[][] toXiSuArray() {
     //找出特殊数的位置和个数
    ArrayList arr = findArrayDifferentNumAndLocation();

    //将获取到的数据转化为稀疏数组
    int[][] xiSuArray = new int[arr.size()/3][3];
    int index = 0;
    for(int i=0;i< arr.size()/3;i++){
      for (int h = 0; h< 3; h++) {
          xiSuArray[i][h] = (int) arr.get(index);
        index++;
      }
    }
    try {
      ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d://a.txt"));
      out.writeObject(xiSuArray);
      out.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    //打印数组
    for (int[] item:xiSuArray ) {
      for (int n:item){
        System.out.print(n+"       ");
      }
      System.out.println("\n");
    }

    return new int[3][];
  }

  private ArrayList
  findArrayDifferentNumAndLocation() {
    ArrayList ar = new ArrayList<Integer>();
    //计数器
    int sum = 0;
    int a = 0;
    for ( int[] arr : array) {
      for (int num:arr) {
        if (0!=num){
          sum++;
        }
      }
      a = arr.length;
    }
    ar.add(this.array.length);
    ar.add(a);
    ar.add(sum);
    for (int w = 0; w< this.array.length; w++){
      for (int l = 0; l < a; l++) {
       if (0!=array[w][l]){
         ar.add(w);
         ar.add(l);
         ar.add(this.array[w][l]);
       }
      }
    }


    return ar;
  }

  //将稀疏数组转为普通数组
  public void toArray(int[][] xiSuArr) {
    int h;
    int l;

    int[][] array = new int[xiSuArr[0][0]][xiSuArr[0][1]];

    for (int i = 1; i < xiSuArr.length; i++) {
            array[xiSuArr[i][0]][xiSuArr[i][1]] = xiSuArr[i][2];
    }
    for (int[] item: array) {
      for (int n:item) {
        System.out.print(n);
        System.out.print("  ");
      }
      System.out.println();
    }

  }


}
