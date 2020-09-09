package com.util;

public class LinkedTable<E> {
    private Node first;
    private Node last;
    private Integer N=0;
    class Node{
        E item;
        Node next;
        public Node(E item) {
//			super();
            this.item = item;
        }
    }
    //表头插入
    public void addFirst(E obj) {
        Node node = new Node(obj);
        if(N==0) {
            this.first=node;
            this.last=node;
//			this.first.item=string;
        }else{
//			node.item=string;
            node.next=this.first;
            this.first=node;
        }
        N++;
    }
    //表尾插入
    public void addTail(E obj) {
        Node node=new Node(obj);
        if(N==0){
            this.first=node;
            this.last=node;
        }else{
            this.last.next=node;
            this.last=node;
            this.last.next=null;
        }
        N++;
    }
    //表头删除
    public E removeFirst() {
        if(N==0)	return null;
        E item=first.item;
        first=first.next;
        N--;
        return item;
    }

    //表尾删除						(单向链表不能表尾删除)
    public void removeTail() {
        // TODO Auto-generated method stub
    }

    //链表大小
    public Integer size() {
//		System.out.println(N);
        return N;
    }
    //重写toString方法
    public String toString(){
        if(N==0)	return "[]";
        StringBuilder sb= new StringBuilder();
        //遍历链表
//		sb.append("[");
//		for(Node i=first;i!=null;i=i.next){
//			sb.append(i.item);
//		}
        Node current=first;
        sb.append("[");
        for(int i=0;i<N;i++){
            sb.append(current.item);
            if(i!=N-1)
                sb.append(",");
            else
                sb.append("]");
            current=current.next;
        }
        return sb.toString();
    }

}
