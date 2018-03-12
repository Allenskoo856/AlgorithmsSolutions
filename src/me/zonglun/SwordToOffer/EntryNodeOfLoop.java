 /*
  * Copyright (C), 2015-2018
  * FileName: EntryNodeOfLoop
  * Author:   Administrator
  * Date:     2018/3/11 0011 16:31
  * Description: 链表中环的节点
  */

 package me.zonglun.SwordToOffer;

 import me.zonglun.SwordToOffer.util.ListNode;

 /**
  * 〈一句话功能简述〉<br>
  * 〈链表中环的节点〉
  *
  * @author Administrator
  * @subject  一个链表中包含环，请找出该链表的环的入口结点。
  * @Strategies
  * @create 2018/3/11 0011
  * @since 1.0.0
  */
 public class EntryNodeOfLoop {

     public ListNode EntryNodeOfLoop(ListNode pHead) {
         // 最少要三个节点成环
        if (pHead == null || pHead.next == null || pHead.next.next == null)
            return null;
         return null;
     }
 }
