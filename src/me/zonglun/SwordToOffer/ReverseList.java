 /*
  * Copyright (C), 2015-2018
  * FileName: ReverseList
  * Author:   Administrator
  * Date:     2018/3/8 0008 22:29
  * Description: 反转链表
  */

 package me.zonglun.SwordToOffer;

 /**
  * 〈一句话功能简述〉<br>
  * 〈反转链表〉
  *
  * @author Administrator
  * @create 2018/3/8 0008
  * @subject    1. 输入一个链表，反转链表后，输出链表的所有元素。
  *             2. 时间限制：1秒 空间限制：32768K
  * @Strategies
  * @since 1.0.0
  */
 public class ReverseList {

     private class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

     /**
      * 反转链表用循环来实现
      * @param head
      * @return ListNode
      */
     public ListNode ReverseList(ListNode head) {
         if (head == null) {
             return null;
         }
         ListNode current = head;   //即pre让节点可以反转所指方向，但反转之后如果不用next节点保存next1节点的话，此单链表就此断开了
         ListNode pre = null;           // 用来保存待反序的第一个节点（head 和 next节点）
         ListNode next = null;          // 用来保存已经反序的第一个结点
         while (current != null) {  //做循环，如果当前节点不为空的话，始终执行此循环，此循环的目的就是让当前节点从指向next到指向pre
             next = current.next;      //   首先记录当前节点的下一个节点，（保存起来）

             current.next = pre;       //   让当前节点指向前一个节点，反序操作
                                        //  head指向pre后，就继续依次反转下一个节点
                                         // 让pre，head，next依次向后移动一个节点，继续下一次的指针反转
             pre = current;             //  让前一个节点值，取代当前的节点值。因为要继续向下走
             current = next;            //  让下一个节点，取代当前节点。同样是向下走，为下一次循环做准备
         }
         return pre;             // 如果head为null的时候，pre就为最后一个节点了，但是链表已经反转完毕，pre就是反转后链表的第一个节点
                                //  直接输出pre就是我们想要得到的反转后的链表
     }

 }
