 /*
  * Copyright (C), 2015-2018
  * FileName: ListNodeMerge
  * Author:   Administrator
  * Date:     2018/3/9 0009 22:15
  * Description: 合并两个排序的列表
  */

 package me.zonglun.SwordToOffer;

 /**
  * 〈一句话功能简述〉<br>
  * 〈合并两个排序的列表〉
  *
  * @author Administrator
  * @create 2018/3/9 0009
  * @subject    输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
  * @example    链表1 :　１－＞３－＞５－＞７　　链表２ :　２－＞４－＞６－＞８
  *             合并之后为：　１－＞２－＞３－＞４－＞５－＞６－＞７－＞８
  * @Strategies
  * @since 1.0.0
  */
 public class ListNodeMerge {

     private class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }
     }

     /**
      * 利用递归来做，每次需要比较两条链表的头节点，小的放入归并之后的头节点，之后使用递归继续剩下的值和剩下的链表上的值
      * @param list1   链表1
      * @param list2   链表2
      * @return ListNode
      */
     public ListNode Merge(ListNode list1, ListNode list2) {
         if (list1 == null) {
             return list2;
         }
         if (list2 == null)
             return list1;
         ListNode MergeHead = null;
         if (list1.val < list2.val) {
             MergeHead = list1;
             MergeHead.next = Merge(list1.next, list2);
         } else {
             MergeHead = list2;
             MergeHead.next = Merge(list1, list2.next);
         }

         return MergeHead;
     }
 }
