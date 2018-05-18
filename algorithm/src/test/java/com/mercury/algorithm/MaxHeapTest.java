package com.mercury.algorithm;

import com.mercury.MaxHeap;
import org.junit.Test;

public class MaxHeapTest {

    @Test
    public void test(){
        int[] temp = new int[]{0,82,91,0,34,29,16,1,7,24,33,17,39,56,40,77,60,91};
        MaxHeap maxHeap = new MaxHeap(16);
        MaxHeap maxHeap1 =new MaxHeap(temp,15);
        System.out.println();
        for (int i = 0; i < maxHeap1.getData().length; i++) {
            System.out.print( maxHeap1.getData()[i]+",");
        }
        System.out.println();
        for (int i = 0; i < 15; i++) {
            int item = (int) (Math.random()*100);
            maxHeap.insert(item);
        }
        for (int i = 0; i <maxHeap.getData().length ; i++) {
            System.out.print("["+i+":"+maxHeap.getData()[i]+"] ");
        }
        System.out.println();
        for (int i = 0; i < maxHeap.getData().length; i++) {
            System.out.print( maxHeap.getData()[i]+",");
        }
        System.out.println(maxHeap.extract());
        for (int i = 0; i <maxHeap.getData().length ; i++) {
            System.out.print("["+i+":"+maxHeap.getData()[i]+"] ");
        }
    }
}
