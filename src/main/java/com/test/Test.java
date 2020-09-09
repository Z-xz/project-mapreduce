package com.test;

import java.io.*;
import java.lang.reflect.Array;
import java.security.KeyStore.TrustedCertificateEntry;
import java.util.*;

import javax.net.ssl.SSLException;
import javax.sound.midi.MidiChannel;
import javax.swing.tree.TreeNode;

import com.method.Method;
import com.util.LinkedTable;
import com.util.ListNode;
//import com.util.ConstructTree;
import com.util.Sort;
//import edu.princeton.cs.algs4.StdIn;
//import edu.princeton.cs.algs4.StdRandom;

public class Test {
    public static void main(String[] args ) throws IOException{
        //1.
//        int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
//        System.out.println(Method.Find(arr, 11));
        //2.
//		String[] str={"4","1","4","/","+"};
//		System.out.println(Method.EvalRPN(str));
        //3.
//		int arr[]={1,2,4,6,8,9};
//		Method.binarySearch(arr, 2);
        //测试util包下的 构造树方法
//		Integer[]arr={5,4,8,11,null,13,4,7,2,null,null,null,1};
//		com.util.TreeNode root=ConstructTree.constructTree(arr);
//		System.out.println(root);
//		int depth=Method.run(root);
        //5.
//		new Method.SearchNode<>().put("a", 1);
        //6.
//		int[]arr=new int[]{4,3,2,1};
//		Comparable[]arr2=new Comparable[4];
//		//Comparable[]arr2=new Comparable[]{4,2,3,5,8};
//		for(int i=0;i<arr.length;i++){
//			arr2[i]=arr[i];
//		}
//		Method.selectionSort(arr2);
//		System.out.println(Arrays.toString(arr2));
        //7.
//		Comparable[]arr3=new Comparable[]{"b","c","d","a"};
//		StdRandom.shuffle(arr3);								//将数组打乱
//		System.out.println(Arrays.toString(arr3));
//		Method.insertionSort(arr3);
//		System.out.println(Arrays.toString(arr3));
//		//8.
//		Comparable[]arr3=new Comparable[]{21,2,5,6,9,8,7,4,5,88,66,54,1};								//将数组打乱
//		System.out.println(Arrays.toString(arr3));
//		Method.shellSort(arr3);
//		System.out.println(Arrays.toString(arr3));
        //9.
//		Comparable[]arr3={"E","E","G","M","R","A","C","E","R","T"};
//		Method.mergeSort(arr3, 0, 8);
//		System.out.println(Arrays.toString(arr3));
        //10.
//		Comparable[]arr3={5,6,4,2,1,8,9,};
//		Method.quickSort(arr3, 0, 6);
//		System.out.println(Arrays.toString(arr3));
        //上浮
//		Comparable[]a={null,5,6,4,2,1,8,9};
//		for(int i=7;i>=1;i--){
//			Sort.swim(a, i);
//		}
//		System.out.println(Arrays.toString(a));
        //下沉
//		Comparable[]a={null,5,6,4,2,1,8,9};
//		for(int i=(a.length-1)/2;i>=1;i--){
//			Sort.sink(a, i);
//		}
//		System.out.println(Arrays.toString(a));
        //11.
//		Comparable[]a={null,9,8,7,6,5,4,1,1,1};
//		Method.heapSort(a);
//		System.out.println(Arrays.toString(a));
        //12.
//		Method.frequencyCounter();
        //13.
//		Method.reverse("abc");
        //14.
//		int a=Method.lengthOfLongestSubstring("abccefd");
//		System.out.println(a);
        //15.
//		boolean a=Method.isRepete("acbcd");
//		System.out.println(a);
        //16.
//		Method.charFrequency("bcaabb");
        //17.
//		int[]arr={4,5,8,9,22};
//		int[]a=Method.twoSum(arr,9);
//		System.out.println(Arrays.toString(a));
        //18.
//		boolean a=Method.isUniqueOfString("sas");
//		System.out.println(a);
        //19.
//		int a=Method.lengthOfLongestSub("dvdf");
//		System.out.println(a);
        //20.
//		int[]a1={1,3};
//		int[]a2={2,4,5};
//		double a=Method.findMedian(a1, a2);
//		System.out.println(a);
        //21.
//		String a=Method.longestPalindrome("cdssddc");
//		System.out.println(a);
        //22.
//		System.out.println(Method.reverse(123));
        //23.
//		boolean a=Method.isPalindrome2(1211212);
//		System.out.println(a);
        //24.
//		System.out.println(Method.romanToInt("VIII"));
        //25.
//		String[] arr={"strs","strs","strs","strst"};
//		System.out.println(Method.longestCommonPrefix(arr));
        //26.
//		List<List<Integer>> list=Method.threeSum(new int[]{-4,-1,1,2});
//		System.out.println(list);
        //27.
//		System.out.println(Method.isValid("(())"));
        //28.
//		System.out.println(Method.threeSumClosest(new int[]{-4,-1,1,2},1));
        //29.
//		ListNode l1 = new ListNode(1);
//		ListNode l2 = new ListNode(2);
//		ListNode l3 = new ListNode(4);
//		l1.next=l2;
//		l2.next=l3;
//		ListNode m1 = new ListNode(1);
//		ListNode m2 = new ListNode(3);
//		ListNode m3 = new ListNode(4);
//		m1.next=m2;
//		m2.next=m3;
//		System.out.println(l2.val);
//		System.out.println(Method.mergeTwoLists(l1,m1).val);
        //30.
//		String[] arr=new String[]{"1","2","3"};
//		List<String> al=new ArrayList<>();
//		System.out.println(Method.permutate(al, arr, 0, 2));
//		System.out.println(Method.generateParenthesis(4));
        //31.
//		System.out.println(Method.removeDuplicates(new int[]{1,1,2,3,3,4}));
        //32.
//		System.out.println(Method.removeElement(new int[]{1,1,2,3,3,4},3) );
        //33.
//		System.out.println(Method.isSubstr("zhangsan", "sn"));
        //34.
			/*
			 * 	输入: haystack = "hello", needle = "ll"
				输出: 2
			 */
//		System.out.println(Method.strStr("hello","ll"));
        //35.
			/*
			 * 	输入: [1,3,5,6], 5
				输出: 2
			 */
//		System.out.println(Method.searchInsert(new int[]{1,3,5,7},6));
        //36.
			/*
			 * 	1:"1",
				2:"11",
				3:"21",
				4:"1211",
				5:"111221",
				6:"312211",
				7:"13112221",
			 */
//		System.out.println(Method.countSay("312211"));
        //37.
//		System.out.println(Method.countAndSay(7));
        //38.
//		System.out.println(Method.permute(new int[]{1,2,3}));
        //39.
//		System.out.println(Method.permuteUnique(new int[]{1,1,2}));
        //40.
//		System.out.println(Method.lengthOfLastWord("ssd"));
        //41.
//		System.out.println(Arrays.toString(Method.plusOne(new int[]{1,2,3,4})));
        //42.
//		System.out.println(Method.addBinary("11", "0"));
        //43.
//		System.out.println(Method.mySqrt(16));

        /*
         * 迭代map集合
         */
//		Map<String, Integer>map=new HashMap<>();
//		Map<String, Integer>map2=new TreeMap<>();
//		map.put("ba", 1);
//		map.put("ab", 5);
//		map.put("cb", 2);
//		map.put("da", 3);
//		map.put("ef", 2);
////		map2.putAll(map);
//		Iterator it=map.entrySet().iterator();		//迭代键值对k-v
////		Iterator it=map.keySet().iterator();		//迭代键k
////		Iterator it=map.values().iterator();		//迭代值v
//		while(it.hasNext()){
//			Map.Entry<String, Integer>kv=(Map.Entry)it.next();
//			System.out.println(kv);
//		}
//		System.out.println(map);
//		System.out.println(map2);

        //44.
//		System.out.println(Method.climbStairs(6));
        //45.
//		ListNode ln1=new ListNode(1);
//		ListNode ln2=new ListNode(2);
//		ListNode ln3=new ListNode(4);
//		ListNode ln4=new ListNode(4);
////		ListNode ln5=new ListNode(5);
//		ln1.next=ln2;
//		ln2.next=ln3;
//		ln3.next=ln4;
////		ln4.next=ln5;
//		System.out.println(Method.deleteDuplicates(ln1).next.next.next);
        //46.
//		Method.treeMapDemo();
//
        //47.
//		int n=Method.lengthOfLastWord2("youareright");
//		System.out.println(n);

        //48.
//		System.out.println(Method.longestValidParentheses(")()()"));

        //49.
//		int[] nums={5,7,7,8,8,10,10};
//		int target=10;
//		int[] resultArray = Method.searchRange(nums, target);
//        if (resultArray != null && resultArray.length == 2) {
//            System.out.print(resultArray[0] + " " + resultArray[1]);
//        } else {
//            System.out.print("结果错误！");
//        }
//		System.out.println(resultArray[0]);

        //50.
//		int[] arr={5,8,9,6,7,2,4};
//		Method.res(arr);

        //51.
//		Method.reso();

        //52.
//		Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        String[]arr=new String[n];
//        for(int i=0;i<n;i++){
//            Scanner s = new Scanner(System.in);
//            arr[i] = s.next();
//        }
//        String str=Method.longestCommonPrefix(arr);
//        System.out.println(str);

        //52
//		Scanner scan = new Scanner(System.in);
//		System.out.println("请输入:");
//		Integer numA=scan.nextInt();
//        Integer numB=scan.nextInt();
//        Method.outPrint(numA, numB);

        //输入测试
//        Scanner in = new Scanner(System.in);
//        while (!in.hasNext("0")) {
//            System.out.println(in.next());
//        }

        //IO文件测试
//        FileReader fis=new FileReader("D:/zane/app/idea/TwoCity.txt");
//		StringBuilder sb=new StringBuilder();
//		while(fis.read()>0){
        //统计频率
//			Character word=(char)fis.read();
//			System.out.println(word);
//			sb.append(word);
//			System.out.println(sb);
//		}
//		fis.close();

		//单词统计
		//创建一个HashMap对象
//		TreeMap<String,Integer> map = new TreeMap<>();
//		// 新建BufferedReader对象
//		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:/zane/app/idea/Robert Louis Stevenson.txt")));
//		//定义一个数组，将读取到的元素先放到数组中
//		String line = "";
//		while((line = br.readLine())!=null){
//			String[] wordline = line.split(" ");
//			for(String word:wordline){
//				if(word.contains(".") || word.contains(",") || word.contains(":") || word.contains(";") ||word.contains(")"))		//去掉标点符号
//					word=word.substring(0,word.length()-1);
//				if(map.containsKey(word)){ // 判断是否存在该单词
//					Integer value = map.get(word); //存在则将value+1，不存在则直接新增即可
//					map.put(word, value+1);
//				}else{
//					map.put(word, 1);
//				}
//			}
//		}
//		// 关闭流
//		br.close();
//		*
//		 * 循环遍历map
//
//		// 取出set集合
//		Set<String> keyset = map.keySet();
//		// 根据key取出value
//		for(String key:keyset){
//			int value = map.get(key);
//			System.out.println(key+":"+value);
//		}
//		System.out.println("----------------------------");



		//正则表达式去除标点符号
//		String regex="().*,;'\"";
//		String Str = new String(",(a)bca.");
//
//		System.out.print("匹配成功返回值 :" );
//		System.out.println(Str.replaceAll("[,.()]", ""));
//		System.out.print("匹配失败返回值 :" );
//		System.out.println(Str.replaceAll("(.*)taobao(.*)", "runoob" ));


		//网络统计单词
		TreeMap<String, Integer> tm=new TreeMap<String, Integer>();
		//用正则表达式来过滤字符串中的所有标点符号
		String regex = "[【】、.。,\"!--;:?\'\\]]";
		try {
			//读取要处理的文件
			//"D:/zane/app/idea/TwoCity.txt"
			BufferedReader br=new BufferedReader(new FileReader(args[0]));
			String value;
			while((value=br.readLine())!=null){
				value=value.replaceAll(regex, "");			//去掉所有的字符
				//使用StringTokenizer来分词
				StringTokenizer tokenizer = new StringTokenizer(value);
				while(tokenizer.hasMoreTokens()){
					String word=tokenizer.nextToken();
					if(!tm.containsKey(word)){
						tm.put(word, 1);
					}else{
						int k=tm.get(word)+1;
						tm.put(word, k);
					}
				}
			}
			//遍历HashMap,输出结果
			Iterator iterator=tm.keySet().iterator();
			while(iterator.hasNext()){
				String word=(String) iterator.next();
				System.out.println(tm.get(word)+":\t"+word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
