 /*
  * Copyright (C), 2015-2018
  * FileName: RandomListNodeClone
  * Author:   Administrator
  * Date:     2018/3/10 0010 16:42
  * Description: 复杂链表的复制
  */

 package me.zonglun.SwordToOffer;

 /**
  * 〈一句话功能简述〉<br>
  * 〈复杂链表的复制〉
  *
  * @author Administrator
  * @create 2018/3/10 0010
  * @Strategies     输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），
  *                      返回结果为复制后复杂链表的head。
  *                注意，输出结果中请不要返回参数中的节点引用
  * @since 1.0.0
  */
 public class RandomListNodeClone {

     private class RandomListNode {
         int label;
         RandomListNode next = null;
         RandomListNode random = null;

         RandomListNode(int label) {
             this.label = label;
         }
     }

     public RandomListNode clone(RandomListNode pHead) {
         if (pHead == null) {
             return null;
         }

         RandomListNode current = pHead;
         // 1.第一步 复制next 如原来是A->B->C 变成A->A'->B->B'->C->C'
         while (current != null) {
             RandomListNode cloneNode = new RandomListNode(current.label);  // 复制值
             cloneNode.next = current.next;
             cloneNode.random = null;
             current.next = cloneNode;  // 此三步完成了A->A'->B 后面需要将current 指向 B
             // 指针后移完成循环
             current = cloneNode.next;
         }

         RandomListNode current2 = pHead;
         // 第二步 复制random 指针  current2 是原来链表的结点 pCur.next是复制pCur的结点
         while (current2 != null) {
             if (current2.random != null) {
                 current2.next.random = current2.random;
             }
             current2 = current2.next.next; // 维护指针后移
         }

         // todo 第三步 把这个长链表拆分成两个链表：把奇数节点链接起来为原始节点，偶数节点链接起来为克隆节点
         RandomListNode current3 = pHead;
         RandomListNode cloneHead = current3.next;
         RandomListNode cloneNode = cloneHead;
         while (cloneNode != null) {
             cloneNode.next = current3.next.next;   // 此步使得 A'->B'->C'
             if (current3.next != null) {
                 current3.next = current3.next.next;
             }
             // 上两步分别完成了两条链表，两个节点的指针指向，后面是使得其循环实现
             current3 = current3.next;
             cloneNode = cloneNode.next;
         }
         return cloneHead;
     }

 }
