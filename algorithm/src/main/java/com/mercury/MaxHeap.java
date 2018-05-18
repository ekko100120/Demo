package com.mercury;

public class MaxHeap {

    private int[] data;

    public int[] getData() {
        return data;
    }

    public int getCount() {
        return count;
    }

    public int getCapacity() {
        return capacity;
    }

    private int count; //堆中元素
    private int capacity;

    public MaxHeap(int capacity) {
        data = new int[capacity+1];
        count=0;
    }

    public MaxHeap(int[] arr,int n) {
        heapify(arr,n);
    }
    //根据数组初始化最大堆，从非叶子节点(count/2)开始逐个shfitdown
    private void heapify(int[] arr,int n){
        data = new int[n+1];
        capacity=n;
        for (int i = 0; i <n ; i++) {
            data[i+1]=arr[i];
            count=n;
        }
        for (int i = count/2; i >=1; i--) {
            shiftDown(data,i);
        }
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return count==0;
    }

    public void insert(int item){

       data[++count]=item;
       shiftup(data,count);

    }
    public int extract(){
        int ex= data[1];
        swap(data,1,count);
        count--;
        shiftDown(data,1);
        return ex;
    }

    //与子节点中比较大的节点交换顺序
    private void shiftDown(int[] data,int k) {
        while (2*k<=count){
            int j=2*k;
            if (j+1<=count&&data[j+1]>data[j]){
                j=j+1;
            }
            if (data[k]>=data[j]){
                break;
            }
            swap(data,k,j);
            k=j;
        }
    }

    private void shiftup(int[] data, int i) {
        while(data[i/2]<data[i]&&i>1){
            swap(data,i/2,i);
            i /=2;
        }
    }

    private void swap(int[] data, int i,int j) {
        int tmp =data[i];
        data[i]=data[j];
        data[j]=tmp;
    }



}
