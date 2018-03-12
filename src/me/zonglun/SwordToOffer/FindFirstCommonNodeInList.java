 /*
  * Copyright (C), 2015-2018
  * FileName: FindFirstCommonNodeInList
  * Author:   Administrator
  * Date:     2018/3/11 0011 14:06
  * Description: 输入两个链表，找出它们的第一个公共结点。
  */

 package me.zonglun.SwordToOffer;


 import java.util.Stack;

 /**
  * 〈一句话功能简述〉<br>
  * 〈输入两个链表，找出它们的第一个公共结点。〉
  *
  * @author Administrator
  * @subject    输入两个链表，找出它们的第一个公共结点。
  * @Strategies     由于是单向链表，所以在两条链表之中，必定有一个节点是其公共节点,类似这种
  *              我们使用从尾到头的遍历，把节点放入到两个栈中，比较栈顶的元素，直到最后一个栈顶元素相同的极为所需要的元素
  * @example      1->2->3->4
  *                         ->8->9->10
  *                 5->6->7
  * @create 2018/3/11 0011
  * @since 1.0.0
  */
 public class FindFirstCommonNodeInList {

     private class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

     /**
      * 用两个辅助栈来实现 ，时间复杂度o（m + n）
      * @param pHead1   链表1头节点
      * @param pHead2   链表2头节点
      * @return ListNode
      */
     public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null)
            return null;
         Stack<ListNode> stack1 = new Stack<>();
         Stack<ListNode> stack2 = new Stack<>();
         // 把链表的元素扔进栈中
         while (pHead1 != null) {
             stack1.push(pHead1);
             pHead1 = pHead1.next;
         }
         while (pHead2 != null) {
             stack2.push(pHead2);
             pHead2 = pHead2.next;
         }

         ListNode commonNode = null;

         while (!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek().val == stack2.peek().val) {
             stack2.pop();
             commonNode = stack1.pop();
         }
         return commonNode;
     }

 }
