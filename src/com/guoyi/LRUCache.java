package com.guoyi;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /*
    146. LRU 缓存
    请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
    实现 LRUCache 类：
    LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
    int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
    void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
    函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。

    示例：
    输入
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    输出
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    解释
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // 缓存是 {1=1}
    lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
    lRUCache.get(1);    // 返回 1
    lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
    lRUCache.get(2);    // 返回 -1 (未找到)
    lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
    lRUCache.get(1);    // 返回 -1 (未找到)
    lRUCache.get(3);    // 返回 3
    lRUCache.get(4);    // 返回 4
     */
    private int count = 0;
    private int capacity;
    private Map<Integer, DLinkedNode> map;
    private DLinkedNode dummyHeadNode;
    private DLinkedNode tailNode;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap(capacity);
        this.dummyHeadNode = new DLinkedNode(-1, -1);
        this.tailNode = dummyHeadNode;
    }

    private static class DLinkedNode {
        public int key;
        public int val;
        public DLinkedNode prev;
        public DLinkedNode next;

        public DLinkedNode(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int hashCode() {
            return key + val;
        }

        public boolean equals(Object o) {
            DLinkedNode n = (DLinkedNode)o;
            return this.key == n.key && this.val == n.val;
        }

        public String toString() {
            return "val:"+val + " prev:" + (prev == null? null : prev.val) + " next:" + (next == null ? null : next.val);
        }
    }

    public int get(int key) {
        //访问这个元素，如果存在，把这个元素提到队头
        DLinkedNode keyDLinkedNode = map.get(key);
        if(keyDLinkedNode == null) {
            return -1;
        }

        refreshList(keyDLinkedNode);
        return keyDLinkedNode.val;
    }

    public void put(int key, int value) {
        //放入已存在值
        if(map.get(key) != null) {
            DLinkedNode node = map.get(key);
            node.val = value;
            //更新这个key
            refreshList(node);
            return;
        }

        //放入不存在值
        //检查是否到达容量上限
        if(this.count == capacity) {
            //如果到达，node和map都删除队尾的一个元素后，再put
            DLinkedNode lastDLinkedNode = remove(tailNode);
            map.remove(lastDLinkedNode.key);
            this.count--;
        }
        //如果未到达，直接put
        DLinkedNode newDLinkedNode = new DLinkedNode(key, value);
        addFirst(newDLinkedNode);
        map.put(key, newDLinkedNode);
        this.count++;

    }

    private void refreshList(DLinkedNode dLinkedNode) {
        remove(dLinkedNode);
        addFirst(dLinkedNode);
    }

    private void addFirst(DLinkedNode dLinkedNode) {
        DLinkedNode firstDLinkedNode = dummyHeadNode.next;
        dummyHeadNode.next = dLinkedNode;
        dLinkedNode.next = firstDLinkedNode;
        dLinkedNode.prev = dummyHeadNode;

        if(firstDLinkedNode != null) {
            firstDLinkedNode.prev = dLinkedNode;
        }

        if(tailNode == dummyHeadNode) {
            tailNode = dLinkedNode;
        }
    }

    private DLinkedNode remove(DLinkedNode dLinkedNode) {

        DLinkedNode prevDLinkedNode = dLinkedNode.prev;
        DLinkedNode nextDLinkedNode = dLinkedNode.next;
        if(tailNode == dLinkedNode) {
            tailNode = prevDLinkedNode;
        }
        prevDLinkedNode.next = nextDLinkedNode;
        if(nextDLinkedNode != null) {
            nextDLinkedNode.prev = prevDLinkedNode;
        }

        dLinkedNode.next = null;
        dLinkedNode.prev = null;

        return dLinkedNode;
    }

}
