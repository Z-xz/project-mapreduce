package com.util;

import java.util.Iterator;
import java.util.TreeMap;

//import org.omg.CORBA.portable.ValueBase;

public class Search<Key extends Comparable<Key>,Value> implements Iterable<Key>{
    TreeMap<Key, Value> treeMap=new TreeMap<>();

    public void put(Key key, Value val) {
        if (key == null) throw new IllegalArgumentException("calls put() with null key");
        if (val == null) treeMap.remove(key);
        else             treeMap.put(key, val);
    }

    public boolean contains(Key word) {
        return get(word)!=null;
    }
//	public boolean contains(Key key) {
//        if (key == null) throw new IllegalArgumentException("calls contains() with null key");
//        return st.containsKey(key);
//    }

    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("calls get() with null key");
        return treeMap.get(key);
    }

//	public Iterable<Key> keys() {
//		// TODO Auto-generated method stub
//		return null;
//	}

    @Override
    public Iterator<Key> iterator() {
        // TODO Auto-generated method stub
        return null;
    }

    public Iterable<Key> keys() {
        return treeMap.keySet();
    }
}
