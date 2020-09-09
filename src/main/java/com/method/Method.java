package com.method;

import com.util.ListNode;
import com.util.Search;
import com.util.Sort;
import com.util.TreeNode;
import com.util.StdIn;
//import com.util.StdOut;
//import edu.princeton.cs.algs4.StdIn;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

//import com.util.Sort;

public class Method {
    //1.判断数组中是否包含给定数字（从右上角起步）
    public static boolean find(int array[][],int target){
        int i=0;
        int j=array[0].length-1;
        while(i<array.length&&j>=0){
            if(target>array[i][j]){
                i++;
            }else if(target<array[i][j]){
                j--;
            }else if(target==array[i][j]){
                return true;
            }
        }
        return false;
    }
    //上面方法的另一种思路（从左下角起）
    public static boolean Find(int array[][],int target){
        int i=array.length-1;				//array.length 表示数组的列数
        int j=0;
        while(j<array[0].length&&i>=0){
            if(target>array[i][j]){			//[2,0]
                j++;
            }else if(target<array[i][j]){
                i--;
            }else if(target==array[i][j]){
                System.out.println("找到啦：array["+i+"]["+j+"]");
                return true;
            }
        }
        return false;
    }

    //2.反向波兰表达式 计算
    public static int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<String>();
        int a,b;
        for(int i=0;i<tokens.length;i++){
            String temp=tokens[i];
            if(temp.equals("+")){
                a=Integer.parseInt(stack.pop());
                b=Integer.parseInt(stack.pop());
                stack.push(Integer.toString(a+b));
            }else if(temp.equals("-")){
                a=Integer.parseInt(stack.pop());
                b=Integer.parseInt(stack.pop());
                stack.push(Integer.toString(b-a));
            }else if(temp.equals("*")){
                a=Integer.parseInt(stack.pop());
                b=Integer.parseInt(stack.pop());
                stack.push(Integer.toString(b*a));
            }else if(temp.equals("/")){
                a=Integer.parseInt(stack.pop());
                b=Integer.parseInt(stack.pop());
                if(a!=0)
                    stack.push(Integer.toString(b/a));
            }else{
                stack.push(temp);
            }
        }
        return Integer.parseInt(stack.peek());
    }
    //上面方法的另一种思路
    public static int EvalRPN(String[] tokens) {

        // 栈，用于遍历初始字符串数组
        Deque<Integer> stack = new ArrayDeque<Integer>();

        int a, b;// 临时存放栈中弹出两个元素

        /**
         * 遍历初始字符串数组，
         * 若当前字符为 运算符 ，则从栈中弹出两个元素，并用该运算符对它们进行运算，然后再将运算结果压入栈
         *  若读到的是数字，则直接将其压入栈，不作其他操作
         */
        for (int i = 0; i < tokens.length; i++) {
            String temp = tokens[i];
            switch (temp) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push((b + a));
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    if (a == 0) {
                        return -1;
                    }
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(temp));
            }
        }

        int result = stack.peek();

        return result;
    }

    //3.二分法
    public static boolean binarySearch(int array[],int key){
        int low=0;
        int high=array.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if(array[mid]<key){
                low=mid+1;
            }else if(array[mid]>key){
                high=mid-1;
            }else if(array[mid]==key){
                System.out.println("找到啦，array["+mid+"]");
                return true;
            }
        }
        System.out.println("很遗憾，没找到！");
        return false;
    }


    //4.树的最小深度（方法实现）
    public static int run(TreeNode root) {
        if(root==null){
            return 0;
        }
        int i=run(root.getLeft());
        int j=run(root.getRight());
        return (i==0||j==0)?i+j+1:Math.min(i,j)+1;
    }

    //5.顺序查找（基于无序链表）
    public static class SearchNode<Key,Value> {
        private Node first;
        //内部类，定义节点
        private class Node{
            Key key;
            Value val;
            Node next;
            public Node(Key key,Value val,Node next){
                this.key=key;
                this.val=val;
                this.next=next;
            }
        }
        //查找
        public Value get(Key key){
            for(Node i=first;i!=null;i=i.next){
                if(key.equals(i.key))
                    return i.val;
            }
            return null;
        }
        //插入
        public void put(Key key,Value val){
            for(Node i=first;i!=null;i=i.next){
                if(key.equals(i.key)){
                    i.val=val;
                    return;
                }
            }
            first.next=new Node(key, val, first);
        }
    }


    //6.选择排序
    public static void selectionSort(Comparable[] a){		//对象数组
        int N=a.length;
        for(int i=0;i<N;i++){
            int min=i;
            for(int j=i+1;j<N;j++){
                if(Sort.less(a[j],a[min])){
                    min=j;
                }
            }
            Sort.exch(a,i,min);
        }
    }

    //7.插入排序
    public static void insertionSort(Comparable[]a){
        int N=a.length;
        for(int i=1;i<N;i++){
            for(int j=i;j>0 && Sort.less(a[j], a[j-1]);j--){
                Sort.exch(a, j, j-1);
            }
        }
    }

    //8.希尔排序
    public static void shellSort(Comparable[]a){
        int N=a.length;
        int h=4;
//		while(h<N/3) h=3*h+1;
        while(h>=1){
            for(int i=1;i<N;i++){
                for(int j=i;j>=h&&Sort.less(a[j], a[j-h]);j=j-h){
                    Sort.exch(a, j, j-h);
                }
            }
            h=h/3;
        }
    }

    //9.归并
    public static void mergeSort(Comparable[]a,int lo,int hi){
        if(hi<=lo)	return;			//在递归中，return一次，返回上层调用
        int mid=lo+(hi-lo)/2;
        mergeSort(a, lo, mid);
        mergeSort(a, mid+1, hi);
        Sort.merge(a, lo, mid, hi);
    }

    //10.快速排序
    public static void quickSort(Comparable[]a,int lo,int hi){
        if(lo>=hi) return;
        int j=Sort.partition(a,lo,hi);
        quickSort(a, lo, j-1);
        quickSort(a, j+1, hi);
    }

    //11.堆排序
    public static void heapSort(Comparable[]a){
        int N=a.length-1;
        //堆有序
        for(int i=N/2;i>=1;i--){
            Sort.sink(a, i,N);
        }
        //堆排序
        while(N>1){
            Sort.exch(a, 1, N--);
            Sort.sink(a, 1,N);
        }
        //找出重复元素
        int count=0;
        for(int i=2;i<=a.length-1;i++)
            if (a[i].compareTo(a[i-1])==0) {
                count++;
                System.out.println("a["+i+"]="+a[i]);
            }
        System.out.println(count);
    }

    //12.文本单词频率查找
    public static void frequencyCounter() throws IOException{
        System.out.println("请输入最小阈值：");
        //Scanner sc=new Scanner(System.in);
        //Integer minlen=sc.nextInt();
        int minlen=StdIn.readInt();
        Search<String, Integer> st =new Search<String,Integer>();
        while(!StdIn.isEmpty()){
            //统计频率
            String word=StdIn.readString();
            if(word.length()<minlen)	continue;
            if(!st.contains(word))	st.put(word, 1);
            else	st.put(word, st.get(word)+1);
        }

//		FileReader fis=new FileReader("F:/TwoCity.txt");
//		StringBuilder sb=new StringBuilder();
//		while(fis.read()>0){
			//统计频率
//			char word=(char)fis.read();
//			sb.append(word);
//			if(word.length()<minlen)	continue;
//			if(!st.contains(word))	st.put(word, 1);
//			else	st.put(word, st.get(word)+1);
//		}
//		fis.close();

        //找出频率最高的单词
        String max="";
        st.put(max, 0);
        for(String word:st.keys())
            if (st.get(word)>st.get(max))
                max=word;
        System.out.println(max+"  "+st.get(max));
        for(String key:st.keys())
            System.out.println("Key:"+key+"\t Value:"+st.get(key));
    }

    //13.字符串反转
    public static void reverse(String str){
        int len=str.length();
        Stack<Character> stack=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<len;i++){
            stack.push(str.charAt(i));
        }
        for(int i=0;i<len;i++){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    //14.寻找给定字符串中的不重复最长字串的长度
    public static int lengthOfLongestSubstring(String s) {
        int index = 0;
        int max = 0;
        int len = s.length();
        if( len == 0)
            return 0;
        if (len ==1)
            return 1;
        String str="";
        System.out.println(s);
        //遍历，类似于插入排序
        int i,j;
        for (i =1; i< len; i++)
        {
            for(j=i-1; j>=index; j--)
            {
                if(s.charAt(i)== s.charAt(j))
                {
                    index = j+1;
                    break;
                }
                else
                {
                    if(max < i-j+1){
                        max = i - j +1;
                        str=s.substring(j, i+1);		//打印最长子字符串
//						System.out.println(str);
                    }
//					str=s.substring(j, i+1);
//					System.out.println(str);
//					char ch=s.charAt(j);
//					System.out.println(ch);

                }
            }
//			char ch=s.charAt(j+1);
//			System.out.println(ch);
        }
        System.out.println(str);
        return max;
    }

    //15.判断字符串中是否存在(指定的)重复字符
    public static boolean isRepete(String s) {
        int index1,index2;
        char[] chars = s.toCharArray();
        System.out.println(Arrays.toString(chars));
        for(char c:chars) {
            index1 = s.indexOf(c);
            index2 = s.lastIndexOf(c);
            if(index1 != index2){
                System.out.println(c);			//打印重复字符
                System.out.println(index1);
                System.out.println(index2);
                return true;
            }
        }
        return false;

//		int a=s.indexOf('b');
//		int b=s.lastIndexOf('b');
//		System.out.println(a);
//		System.out.println(b);
//		if(a==b) return false;
//		return true;
    }

    //16.打印字符串每个字符出现的次数
    public static void charFrequency(String str){
        char[]chars=str.toCharArray();
        Map<Character, Integer> tm=new TreeMap<>();
        for(char ch:chars){
            if(!tm.containsKey(ch))	tm.put(ch, 1);
            else	tm.put(ch,tm.get(ch)+1);
        }
        System.out.println(str);
        System.out.println(tm);
    }

    //17.寻找数组的两数之和(力扣#1)：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标
    public static int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int sum=nums[i]+nums[j];
                if(sum==target){
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("没找到");
    }

    //18.判断字符串是否是同一个字符拼接而成
    public static boolean isUniqueOfString(String str){
        Set<Character> set=new HashSet<>();			//利用了hashSet不重复的机制
//		for(int i=0;i<str.length();i++){
//			char c=str.charAt(i);
//			set.add(c);
//		}
        char[] ch=str.toCharArray();
        for(char c:ch){
            set.add(c);
        }
        if(set.size()==1){
            return true;
        }else
            return false;
    }
    //19.求最长子字符个数（不重复的）同#14，只是加了判断“aaaaa”的情况
    public static int lengthOfLongestSub(String s) {
        char[] ch=s.toCharArray();
        if (isUniqueOfString(s)) {
            return 1;
        }
        int flag=0;
        int max=0;
        String str="";
        for(int i=1;i<s.length();i++){
            for(int j=i-1;j>=flag;j--){
                if(ch[j]==ch[i]){
                    flag=j+1;
                    break;
                }
                if(max<i-j+1){
                    max=i-j+1;
                    str=s.substring(j, i+1);
                }

            }
        }
        System.out.println(str);
        return max;
    }

    //20.求中位数（两个已经排序的数组）
    public static double findMedian(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int len=m+n;
        Integer[] arr=new Integer[len];
        //合并两个数组（未排序）
        for(int i=0;i<len;i++){
            if(i<m){
                arr[i]=nums1[i];
            }else
                arr[i]=nums2[i-m];
        }
        System.out.println(Arrays.toString(arr));
//      quickSort(arr, 0, len-1);			//快速排序
        Sort.merge(arr, 0, m-1, len-1);		//归并排序
        System.out.println(Arrays.toString(arr));
//        if((len)%2!=0){						//若为奇数
//        	return arr[(len)/2];
//        }else{								//若为偶数
//        	return (arr[(len)/2-1]+arr[(len)/2])/2.0;
//        }
        return (len)%2==1 ? arr[(len)/2] : (arr[(len)/2-1]+arr[(len)/2])/2.0;
    }

    /**
     *
     * 马拉车算法:
     * 	1)插入'#'
     * 	2)调用'中心扩散算法'
     * 	3)擦除'#'
     */
    //21.求最长回文（子字符串）：回文串是左右对称的
    public static String longestPalindrome(String s) {
        if(s.length()==1) return s;
        if(s.length()==2&&s.charAt(0)!=s.charAt(1))	return s.charAt(0)+"";
        //插入'#'
        int N=s.length();	//长度
        int n=N-1;			//插入的个数，也是循环次数
        char[] chars=s.toCharArray();
        List<Character> list=new ArrayList<>();
        //字符数组添加到集合中
        for(char c:chars){
            list.add(c);
        }
        //集合中插入'#'
        for(int i=1;i<=2*n-1;i+=2){
            list.add(i,'#');
        }
        //转为字符串
        StringBuilder sb= new StringBuilder();
        for(char c:list)
            sb.append(c);
        String s2=sb.toString();
        System.out.println(s2);
        //调用中心扩散算法
        int max=0;
        int N2=N+n;
        String maxStr="";

        for(int i=1;i<N2-1;i++){
            String str=aroundCent(i, s2);
            String s3=erace(str);
            if(s3.length()>max){
                max=s3.length();
                maxStr=s3;
            }
        }
        return maxStr;
    }

    //擦除字符串中的'#'
    public static String erace(String s){
        StringBuilder sb2= new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){}
            else	sb2.append(s.charAt(i));
        }
        return sb2.toString();
    }

    //中心扩散法（精髓）
    public static String aroundCent(int center,String s){
        int L=center-1;
        int R=center+1;
        while(L>=0 && R<s.length() && s.charAt(L)==s.charAt(R)){
            L--;
            R++;
        }
        ++L;
        --R;
        return s.substring(L, R+1);
    }

    //22.整数反转
    public static int reverse(int x) {
        int fin=0;
//        	System.out.println(Integer.MAX_VALUE);
        while(x!=0){
            int temp=x%10;
            if(fin>Integer.MAX_VALUE/10 || (fin==Integer.MAX_VALUE/10 && temp>7)) return 0;
            if(fin<Integer.MIN_VALUE/10 || (fin==Integer.MIN_VALUE/10 && temp<-8)) return 0;
            fin=10*fin+temp;
            x/=10;
        }
        return fin;
    }

    //23.判断回文数字
    public static boolean isPalindrome(int x) {
        if(x>0){
            List list=new ArrayList();
            while(x!=0){
                int temp=x%10;
                list.add(temp);
                x/=10;
            }
            int n=list.size();
            for(int i=0;i<n/2;i++){
                if(list.get(i)!=list.get(n-1-i))	return false;
            }
            return true;
        }else if(x==0){
            return true;
        }else
            return false;
    }
    //上面另一种思路
    public static boolean isPalindrome2(int x) {
        if(x>0){
            int fin=0;
            int ori=x;
            while(x!=0){
                int temp=x%10;
                fin=fin*10+temp;
                x/=10;
            }
            if(fin==ori) return true;
            return false;
        }else if(x==0){
            return true;
        }else
            return false;
    }

    //24.罗马数字转阿拉伯
    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int sum = 0;;
        for(int i = 0; i < s.length()-1;){
            String c1 = s.charAt(i) + "";
            String c2 = s.charAt(i+1) + "";
            int t1 = map.get(c1);
            int t2 = map.get(c2);
            if(t1 < t2) {
                sum = sum + t2 - t1;
                i += 2;
                if(i == s.length()) return sum;
            }else{
                sum = sum + t1;
                i += 1;
            }
        }
        return sum += map.get(s.charAt(s.length()-1) + "");
    }

    //25.最长公共前缀（字符串数组 ）
    public static String longestCommonPrefix(String[] strs) {
        if(strs==null)	return null;
        int N=strs.length;

        //将数组中最长的字符串作为标志，存入集合中，与其他字符串逐一比较
        int maxlen=0;
        int maxflag=0;
        for(int i=0;i<N;i++){
            if(strs[i].length()>maxlen){
                maxlen=strs[i].length();
                maxflag=i;
            }
        }
        List<Character> list=new ArrayList<>();
        for(int i=0;i<maxlen;i++){
            list.add(strs[maxflag].charAt(i));
        }

        int num=0;			//第num个元素
        int min=maxlen;		//子字符串截取尾指针
        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            int n=str.length();
            if(n==0)    return "";
            for(int j=0;j<n;j++){
                if(str.charAt(j)==list.get(j)){
                    if(j==n-1 && n<min){
                        min=n;
                        num=i;
                    }
                }else{
                    if(j>0 && j<min){
                        min=j;
                        num=i;
                        break;
                    }else if(j==0)	return "";
                }
            }

        }
//        return strs[num].substring(0, min);
        System.out.println(num);
        System.out.println(min);
        if(strs.length==0)	return "";
        else{
            String string=strs[num];
//            return string.substring(0, min);
            return string.length()==0?"":string.substring(0, min);
        }
    }

    //26.三数之和为0（数组）
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> arraylist=new ArrayList<>();
        if(nums==null || nums.length<3)	return arraylist;
        Arrays.sort(nums);
        if(nums[0]>0 || nums[nums.length-1]<0) return arraylist;
        int N=nums.length;
        for(int i=0;i<N-2;i++){
            if(i!=0 && nums[i]==nums[i-1])	continue;
            int L=i+1;
            int R=N-1;
            while(L<R && nums[i]<=0){
                int s=nums[i]+nums[L]+nums[R];
                if(s==0){
                    while(nums[R]==nums[R-1] && L<R){
                        R--;
                    }
                    while(nums[L]==nums[L+1] && L<R){
                        L++;
                    }

                    if (arraylist.contains(Arrays.asList(nums[i],nums[L],nums[R]))) {
                        L++;
                        R--;
                        continue;
                    }
                    arraylist.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    L++;
                    R--;
                }else if(s<0){
                    L++;
                }else {
                    R--;
                }
            }
        }
        return arraylist;
    }
    //另标准答案
//											while(L<R && nums[i]<=0){
//										        int s=nums[i]+nums[L]+nums[R];
//										    	if(s==0){
//										            arraylist.add(Arrays.asList(nums[i],nums[L],nums[R]));
//										    		L++;
//										    		R--;
//										    		while(nums[R]==nums[R+1] && L<R){
//										    			R--;
//										    		}
//										    		while(nums[L]==nums[L-1] && L<R){
//										    			L++;
//										    		}
//										    	}else if(s<0){
//										    		L++;
//										    	}else {
//													R--;
//												}
//										    }

    //27.有效的括号（--------------------绝对原创----------------）
    public static boolean isValid(String s) {
        if(s.charAt(0)==')' || s.charAt(0)==']' || s.charAt(0)=='}')    return false;
        int len=s.length();
        char[] chars=s.toCharArray();
        HashMap<Character,Character> hashMap = new HashMap<>();
        hashMap.put('(', ')');
        hashMap.put('[', ']');
        hashMap.put('{', '}');
        Stack<Character> st = new Stack<>();
        for(char c:chars){
            if(c=='(' || c=='[' || c=='{'){
                st.push(hashMap.get(c));
            }else{
                Character top=st.size()==0 ? '#':st.peek();		//只有这样leetcode才能运行通过
                if(c==top){
                    st.pop();
                }
                else	return false;
            }
        }
//        if(st.isEmpty())	return true;
//        else	return false;
        return st.isEmpty();
    }

    //28.最接近的三数之和（参照#26）
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len=nums.length;
        int close=nums[0]+nums[1]+nums[2];		//最接近的三数之和，设置一个初始值
        for(int i=0;i<len-2;i++){				//三个变量求和，利用i遍历+双指针
            if(i!=0&&nums[i]==nums[i-1])	i++;	//提高性能
            int L=i+1;
            int R=len-1;
            while(L<R){
                int sum=nums[i]+nums[L]+nums[R];	//-3,-1
                if(Math.abs(sum-target)<Math.abs(close-target)){
                    close=sum;
                }
                if (sum<target) {
                    L++;
                }else if(sum>target){
                    R--;
                }else {
                    return sum;
                }
            }
        }
        return close;
    }

    //29.合并两个链表（有序的）
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 类似归并排序中的合并过程
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else {
                cur.next = l2;
                cur = cur.next;
                l2 = l2.next;
            }
        }
        // 任一为空，直接连接另一条链表
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return dummyHead.next;
    }
    //另外递归 	(有问题)
//			public static int mergeTwoLists(ListNode l1, ListNode l2) {
//			   if(l1==null)	return	l2.val;
//			   if(l2==null)	return	l1.val;
//			   ListNode n1 = l1;
//		       ListNode n2 = l2;
//		       if(n1.val<n2.val){
//		    	   n1.next.val=mergeTwoLists(n1.next, n2);
//		    	   return n1.val;
//		       }else{
//		    	   n2.next.val=mergeTwoLists(n1, n2.next);
//		    	   return n2.val;
//		       }
//		    }

    //30.括号生成（给定对数n）
    public static List<String> generateParenthesis(int n) {
        //从参数n转为全排列算法所需的字符串数组
        String[]str = new String[2*n];
        for(int i=0;i<2*n;i+=2){
            str[i]="(";
            str[i+1]=")";
        }

        List<String> al=new ArrayList<>();
        List<String> al2= new ArrayList<>();
        Set<String> hs= new HashSet<>();
        List<String> al3= new ArrayList<>();
        permutate(al,str,0, str.length-1);		//返回原始全排列al集合(含有不符的、重复的)

        for(String string:al){
            if(isValid(string))					//剔除不符合的	(调用#27，)
                al2.add(string);
        }
        hs.addAll(al2);							//剔除重复	（利用set集合性质）
        al3.addAll(hs);
        return al3
                ;
    }
    //全排列,全排列的范围：begin~end
    public static List<String> permutate(List<String> al,String[]arr,int begin,int end){
        StringBuilder sb= new StringBuilder();
        //设置递归的出口,即当需要全排列的范围只有一个元素，则全排结束，此数组为全排列
        if(begin==end){
            for(int i=0;i<=end;i++){
                sb.append(arr[i]);
            }

            al.add(sb.toString());
            return al;									//递归的出口，并非真正的return
        }else{
            //将begin~end中的每一个数分别放到首位，并实现全排列
            for(int j=begin;j<=end;j++){
                swap(arr,begin,j);  //for循环将begin~end中的每一个数放到begin位置中去
                permutate(al,arr,begin+1,end); //假设begin位置确定，那么对begin+1~end中的数组进行全排列
                swap(arr,begin,j); //换过去后再将数组还原
            }
            return al;
        }
    }
    public static void swap(String[] arr,int i,int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    //31.删除排序数组中的重复项（力扣#26）
    public static int removeDuplicates(int[] nums) {
        Set<Integer> ts= new TreeSet<>();
        for(int i:nums){
            ts.add(i);
        }
        Object[]arr=ts.toArray();
        for(int i=0;i<arr.length;i++){
            nums[i]=(int)arr[i];
        }
        return ts.size();
    }

    //32.删除指定元素（数组），返回长度	（力扣#27）
    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }

    //33.判断是否是子字符串
    public static boolean isSubstr(String haystack, String needle) {
        int i=haystack.indexOf(needle);
        return i==-1?false:true;
    }

    //34.实现strStr()-（返回子字符串的位置）
    public static int strStr(String haystack, String needle) {
        int i=haystack.indexOf(needle);
        return i;
    }

    //35.搜索插入位置-（返回指定目标的索引位置）---------直接二分法
    public static int searchInsert(int[] nums, int target) {
        int lo=0;
        int hi=nums.length-1;
        while(lo<=hi){
            int mid=lo+(hi-lo)/2;
            if(nums[mid]<target){
                lo=mid+1;
            }else if(nums[mid]>target){
                hi=mid-1;
            }else{
                return mid;
            }
        }
        return lo;
    }

    //36.报数（精简版--给出上一个求下一个）
    public static String countSay(String res){
//        String res="11";
        Map<String, Integer>map=new LinkedHashMap<>();
        StringBuilder sb=new StringBuilder();
        map.put(res.charAt(0)+"", 1);
        sb.append(map.get(res.charAt(0)+"")+"");
        sb.append(res.charAt(0));

        for(int i=1;i<res.length();i++){
            if(res.charAt(i)==res.charAt(i-1)){
                map.put(res.charAt(i)+"", map.get(res.charAt(i)+"")+1);
                sb.delete(sb.length()-2, sb.length());
                sb.append(map.get(res.charAt(i)+"")+"");
                sb.append(res.charAt(i));
            }else{
                map.put(res.charAt(i)+"", 1);
                sb.append(map.get(res.charAt(i)+"")+"");
                sb.append(res.charAt(i));
            }
        }
        return sb.toString();
    }

    //37.报数
    public static String countAndSay(int n) {
        if(n==1)   return "1";
        if(n==2)   return "11";
        String res=countAndSay(n-1);
        Map<String, Integer>map=new LinkedHashMap<>();
        StringBuilder sb=new StringBuilder();
        map.put(res.charAt(0)+"", 1);
        sb.append(map.get(res.charAt(0)+"")+"");
        sb.append(res.charAt(0));

        for(int i=1;i<res.length();i++){
            if(res.charAt(i)==res.charAt(i-1)){
                map.put(res.charAt(i)+"", map.get(res.charAt(i)+"")+1);
                sb.delete(sb.length()-2, sb.length());
                sb.append(map.get(res.charAt(i)+"")+"");
                sb.append(res.charAt(i));
            }else{
                map.put(res.charAt(i)+"", 1);
                sb.append(map.get(res.charAt(i)+"")+"");
                sb.append(res.charAt(i));
            }
        }
        return sb.toString();
    }

    //38.全排列（力扣#46）
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>arraylist=new ArrayList<>();
        return recursion(arraylist, nums, 0, nums.length-1);

    }
    //核心
    public static List<List<Integer>> recursion(List<List<Integer>> al,int[]nums,int begin,int end){
        List<Integer>al2=new ArrayList<>();
        if(begin==end){
            for(int i=0;i<=end;i++){
                al2.add(nums[i]);
            }
            al.add(al2);
            return al;
        }else{
            for(int j=begin;j<=end;j++){
                exch(nums,begin,j);
                recursion(al,nums, begin+1, end);
                exch(nums,begin,j);
            }
            return al;
        }
    }
    //交换
    private static void exch(int[] nums, int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    //39.全排列2（去重）
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>>arraylist=new ArrayList<>();
        return recur(arraylist, nums, 0, nums.length-1);
    }
    //核心
    public static List<List<Integer>> recur(List<List<Integer>> al,int[]nums,int begin,int end){
        List<Integer>al2=new ArrayList<>();
        if(begin==end){
            for(int i=0;i<=end;i++){
                al2.add(nums[i]);
            }
            if(!al.contains(al2)){
                al.add(al2);
            }
            return al;
        }else{
            for(int j=begin;j<=end;j++){
                exch(nums,begin,j);
                recursion(al,nums, begin+1, end);
                exch(nums,begin,j);
            }
            return al;
        }
    }

    //40.最后一个单词的长度
    public static int lengthOfLastWord(String s) {
        String str=s.trim();						//trim():去掉字符串首尾的空格
        int a=str.length();
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==' '){
                a=str.length()-i-1;
                return a;
            }
        }
        return a;
    }

    //41.加1
    public static int[] plusOne(int[] digits) {		//存在越界问题
        int n=digits.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=digits[i]*(int)Math.pow(10, n-i-1);
        }
        sum=sum+1;
        String str=sum+"";
        int N=str.length();
        int[]arr=new int[N];
        for(int i=N-1;i>=0;i--){
            int temp=sum%10;
            sum=sum/10;
            arr[i]=temp;
        }
        return arr;
    }

    //42.二进制求和
    public static String addBinary(String a, String b) {
        Integer left=Integer.valueOf(a, 2);				//2进制
        Integer right=Integer.valueOf(b,2);
        return Integer.toBinaryString(left+right);
    }

    //43.x 的平方根（牛顿迭代法）
    public static int mySqrt(int x) {
        double last=0;
        double res=1;
        while(last!=res){
            last=res;
            res=(res+x/res)/2.0;
        }
        return (int)res;
    }

    //44.爬楼梯，一次一两阶均可（---斐波那契数列:a(n)=a(n-1)+a(n-2)---）
    public static int climbStairs(int n){
        if(n==1||n==2){
            return n;
        }
//		int a=climbStairs(n-1)+climbStairs(n-2);	//此迭代比较耗时
//		return a;
        int res=0;
        int i=1;
        int j=2;
        int k=3;
        while(k<=n){
            res=i+j;
            i=j;
            j=res;
            k++;
        }
        return res;
    }

    //45.删除排序链表中的重复元素
    public static ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer>hm=new HashMap();
        ListNode temp=head;
        ListNode dummyHead=new ListNode(0);
        ListNode cur=dummyHead;
        while(temp!=null){
            if(hm.containsKey(temp.val)){
                if(temp.next==null){
                    cur.next=null;
                }
//        		hm.put(temp.next.val, 1);
//        		cur.next=temp.next;
//        		temp=temp.next;
//        		cur=cur.next;
            }else{
                hm.put(temp.val, 1);
                cur.next=temp;
                cur=cur.next;
            }
            temp=temp.next;
        }
        return dummyHead.next;
    }

    //46.
    public static void treeMapDemo(){
        Map<String , Integer>tm=new TreeMap<>();
        tm.put("s", 1);
        tm.put("d", 2);
        tm.put("d", 3);
        System.out.println(tm);
    }

    //47.最后一个单词的长度-----------(待改：若无空格则报错)
    public static int lengthOfLastWord2(String s) {
        String substr=s.trim();
        int len=substr.length();
        int i=len-1;
        char[] ca=s.toCharArray();
        while(ca[i]!=' '){
            i--;
        }
        return len-i-1;
    }

    //48.最长有效括号de字符个数------(调用了之前的 isValid)
    public static int longestValidParentheses(String s) {
        int maxlen=0;
        for(int i=0;i<s.length();i++){
            for(int j=i+2;j<=s.length();j+=2){
                if (isValid(s.substring(i, j))) {
//					if(maxlen<j-i){
//						maxlen=j-i;
//					}
                    maxlen=Math.max(maxlen, j-i);
                }
            }
        }
        return maxlen;
    }

    //49.
    public static int[] searchRange(int[] nums, int target) {
        int n=nums.length;
//        System.out.println(n);//-----------
//        StringBuilder sb=new StringBuilder();
//        for(int i=0;i<n;i++){
//        	sb.append(nums[i]+"");
//        }
//        String str=sb.toString();
//        System.out.println(str.length());//--------------
//        int[] array=new int[2];
//        System.out.println(array.length);
//        array[0]=str.indexOf(target+"");
//        array[1]=str.lastIndexOf(target+"");
//        return array;
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]==target){
                array[i]=i;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(nums[i]==target){
                array[1]=i;
                break;
            }
        }
        return array;
    }

    //50.
    public static void res(int[] arr){
        ArrayList<Integer> al1=new ArrayList<>();
        ArrayList<Integer> al2=new ArrayList<>();
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i:arr){
            if(i%2!=0){
                sb1.append(i);
            }else{
                sb2.append(i);
            }
        }
        String str1=sb1.toString();
        String str2=sb2.toString();
        String string=str1+str2;
        String[] s=string.split("");
        System.out.println(string);
        System.out.println(Arrays.toString(s));

    }

    //51.华为笔试#2
    public static void reso(){
        Scanner sc=new Scanner(System.in);
        System.out.println("输入地区数N：");
        int N=sc.nextInt();
        System.out.println("输入操作数M：");
        int M=sc.nextInt();
        System.out.println("输入N个地区的初始销量(逗号隔开)：");
        String str=sc.next();
        String[] string=str.split(",");
        int[] arr=new int[string.length];
        for(int i=0;i<string.length;i++){
            arr[i]=Integer.parseInt(string[i]);
        }
        System.out.println("输入M次操作（“Q”表示查询，“U”表示更新，逗号隔开）：");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<M;i++){
            String s=sc.next();
            String[] st=s.split("");
            if(st[0].equals("Q")){
                int re=Q(arr,Integer.parseInt(st[1]),Integer.parseInt(st[2]));
                sb.append(re+"");
            }else if(st[0].equals("U")){
                U(arr,Integer.parseInt(st[1]),Integer.parseInt(st[2]));
            }
        }
        String[] result=sb.toString().split("");
        for(String s:result){
            System.out.println(s);
        }
    }
    public static int Q(int[] arr,int m,int n){
        int sum =0;
        for(int i=m-1;i<n;i++){
            sum+=arr[i];
        }
        return sum/(n-m+1);
    }
    public static void U(int[] arr,int m,int n){
        arr[m-1]=arr[m-1]+n;
    }


    //52
    public static void outPrint(int a,int b){
        for(int i=a;i<=b;i++){
            if(i%(3*5)==0){
                System.out.println("foobar");
            }else if(i%3 ==0){
                System.out.println("foo");
            }else if(i%5 ==0){
                System.out.println("bar");
            }else{
                System.out.println(i);
            }
        }
    }
}
