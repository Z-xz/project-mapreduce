package com.util;

import java.awt.RenderingHints.Key;
import java.security.cert.PolicyQualifierInfo;

import com.method.Method;

//import edu.princeton.cs.algs4.MinPQ;
//import edu.princeton.cs.algs4.Transaction;

public class Sort {
    public static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
    }
    public static void exch(Comparable[] a,int i,int j){
        Comparable t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    //将两个均已经有序的数组合并为一个有序数组
    public static void merge(Comparable[]a,int lo,int mid,int hi){
        int i=lo,j=mid+1;								//指针
        Comparable[]aux=new Comparable[a.length];
        for(int k=lo;k<=hi;k++) aux[k]=a[k];
        for(int k=lo;k<=hi;k++){
            if(i>mid) 						a[k]=aux[j++];
            else if (j>hi) 					a[k]=aux[i++];
            else if (less(aux[j],aux[i])) 	a[k]=aux[j++];
            else 							a[k]=aux[i++];
        }
    }
    //切分函数
    public static int partition(Comparable[] a, int lo, int hi) {
        int i=lo,j=hi+1;
        Comparable v=a[lo];
        while(true){
            while(less(a[++i],v))	 if(i>hi) break;
            while(less(v, a[--j]))	 if(j<lo) break;
            if (i>=j)	break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }
    //上浮
    public static void swim(Comparable[]a,int k){	//怎样构造堆a【实际a就是一个普通数组，只是废弃了第一个元素啊[0],从a[1]开始计数】
        while(k>1&&less(a[k/2], a[k])){
            exch(a, k/2, k);
            k=k/2;
        }
    }
    //下沉
    public static void sink(Comparable[]a,int k,int N){	//【堆a，实际就是一个普通数组，只是废弃了第一个元素啊[0],从a[1]开始计数】
        while(2*k<=N){
            int j=2*k;
            if(j<N&&less(a[j], a[j+1])) j++;
            if(!less(a[k], a[j]))	break;
            exch(a, k, j);
            k=j;
        }
    }
}
