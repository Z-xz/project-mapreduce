package com.util;

//import org.omg.CORBA.Current;

public class DeLinkedTable {
    private Node first;
    private Node last;
    private Integer N=0;
    class Node{
        Object item;
        Node next;
        Node pre;
        public Node(Object item) {
//			super();
            this.item = item;
        }
    }
    //表头插入
    public void addFirst(Object string) {
        Node node = new Node(string);
        if(N==0) {
            this.first=node;
            this.last=node;
        }else{
            node.next=this.first;
            this.first.pre=node;
            this.first=node;
        }
        N++;
    }
    //表尾插入
    public void addTail(Object string) {
        Node node=new Node(string);
        if(N==0){
            this.first=node;
            this.last=node;
        }else{
            this.last.next=node;
            node.pre=this.last;
            this.last=node;
            this.last.next=null;
        }
        N++;
    }
    //表头删除
    public boolean removeFirst() {
        if(N==0)	return false;
        first=first.next;
        first.pre=null;
        N--;
        return true;
    }

    //表尾删除						(单向链表不能表尾删除)
    public boolean removeTail() {
        if(N==0)	return false;
        last=last.pre;
        last.next=null;
        N--;
        return true;
    }

    //删除指定节点
    public boolean remove(Object string) {
        //先查找节点
        Node currrent=this.first;
        for(int i=0;i<N;i++){
            if(!string.equals(currrent.item)){
                if(currrent.next==null){
                    System.out.println("没找到指定节点");
                    return false;
                }
                currrent=currrent.next;
            }else{
                System.out.println("找到节点："+currrent.item);
                break;
            }
        }
        //再删除节点
        if(currrent==first){
            this.removeFirst();
        }else if(currrent==last){
            this.removeTail();
        }else {
            currrent.pre.next=currrent.next;
            currrent.next.pre=currrent.pre;
            N--;
        }
        return true;
    }

    //链表大小
    public Integer size() {
        System.out.println(N);
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
