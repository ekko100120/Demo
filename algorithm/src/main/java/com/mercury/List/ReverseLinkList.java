package com.mercury.List;

import com.sun.scenario.effect.impl.prism.PrImage;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/5/18-11:28
 * @Description:
 * @return:
 */
  //实现单链表逆序
public class ReverseLinkList {

  public static Node<Integer,Integer> reverse(Node<Integer,Integer> head){
    Node<Integer,Integer> reverse = null;
    Node<Integer,Integer> current = head;

    if (head == null || head.getNext()==null){
      return  head;
    }
    while(current!=null){
        Node<Integer,Integer> temp = current;
        current=current.getNext();
        temp.setNext(reverse);
        reverse=temp;
    }
    return reverse;
  }

  public static Node<Integer,Integer> reverse2(Node<Integer,Integer> head){
    if (head ==null||head.getNext()==null){
      return head;
    }
    Node<Integer,Integer> reversedHead = reverse2(head.getNext());
    head.getNext().setNext(head);
    head.setNext(null);
    return  reversedHead;
  }

  private  static  class Node<K,V>{
    private  final  K key;
    private V value;
    private  Node<K,V> next;

    public Node(K key, V value, Node<K, V> next) {
      this.key = key;
      this.value = value;
      this.next = next;
    }

    public K getKey() {
      return key;
    }

    public V getValue() {
      return value;
    }

    public void setValue(V value) {
      this.value = value;
    }

    public Node<K, V> getNext() {
      return next;
    }

    public void setNext(Node<K, V> next) {
      this.next = next;
    }
  }
}
