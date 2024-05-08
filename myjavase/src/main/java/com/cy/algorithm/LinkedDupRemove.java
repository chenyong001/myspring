package com.cy.algorithm;

import java.util.HashSet;
import java.util.Objects;

public class LinkedDupRemove {

    public static class LinkedNode {
        public int data;
        public LinkedNode next;
    }

    private static HashSet<Integer> valueSet = new HashSet<>();
    LinkedNode parent;

    /**
     * 基于 O(n) 时间复杂度实现链表去重(不能改变数据的前后相对顺序)
     * 输入 3->2->3->1->1->4->5->5
     * 输出 3->2->1->4->5
     *
     * @param root
     * @return
     */
    public LinkedNode dupRemove(LinkedNode root) {
        if (Objects.nonNull(root)) {
//            判断当前节点数据是否重复，如果不重复则递归查找下个节点，如果重复则将节点的子节点的引用转移给父节点的子节点，达到去掉该节点
            if (valueSet.contains(root.data)) {
                    parent.next = root.next;
            } else {
                System.out.print(root.data);
                valueSet.add(root.data);
                parent = root;
            }
            dupRemove(root.next);
        }
        return root;
    }

    public static void main(String[] args) {
        LinkedDupRemove linkedDupRemove = new LinkedDupRemove();

//        3->2->3->1->1->4->5->5
        LinkedNode child7 = new LinkedNode();
        child7.data = 5;
        LinkedNode child6 = new LinkedNode();
        child6.data = 5;
        child6.next = child7;
        LinkedNode child5 = new LinkedNode();
        child5.data = 4;
        child5.next = child6;
        LinkedNode child4 = new LinkedNode();
        child4.data = 1;
        child4.next = child5;
        LinkedNode child3 = new LinkedNode();
        child3.data = 1;
        child3.next = child4;
        LinkedNode child2 = new LinkedNode();
        child2.data = 3;
        child2.next = child3;
        LinkedNode child1 = new LinkedNode();
        child1.data = 2;
        child1.next = child2;
        LinkedNode root = new LinkedNode();
        root.data = 3;
        root.next = child1;

        LinkedNode linkedNode = linkedDupRemove.dupRemove(root);

    }


}