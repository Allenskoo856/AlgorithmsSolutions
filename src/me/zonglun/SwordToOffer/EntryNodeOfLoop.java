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

        // 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
         ListNode p1 = pHead;
         ListNode p2 = pHead;
         while (p2 != null && p1 != null) {
             p1 = p1.next;
             p2 = p2.next.next;
        // 第二步，将相遇的这点时叫做B点，此时将p2指针重新移到链表的头部，p1任然在B点，两者以相同的速度扫描，直到相遇即
             // 到了链表中环的入口
             if (p1 == p2) {
                 p2 = pHead;
                 while (p1 != p2) {
                     p1 = p1.next;
                     p2 = p2.next;
                 }
                 if (p1 == p2)
                     return p1;
             }
         }
         return null;
     }
 }
