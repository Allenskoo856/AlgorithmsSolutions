# Java 算法设计与实现

> **本仓库使用 Java 实现常见的算法和解决常见的算法面试题目**



## [排序算法](https://github.com/Allenskoo856/AlgorithmsSolutions/tree/master/src/me/zonglun/Sort)

| 排序算法      | 平均时间复杂度    | 空间复杂度    | 排序方式      | 稳定性  | 代码实现                                     | 说明     |
| --------- | ---------- | -------- | --------- | ---- | ---------------------------------------- | ------ |
| 冒泡排序      | `O(N^2)`   | O(1)     | In-place  | 稳定   | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/BubbleSort.java) | ——     |
| 选择排序      | `O(N^2)`   | O(1)     | In-place  | 不稳定  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/SelectionSort.java) | ------ |
| 插入排序      | `O(N^2)`   | O(1)     | In-place  | 稳定   | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/InsertionSort.java) |        |
| 希尔排序      | `O(nLogN)` | O(1)     | In-Place  | 不稳定  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/ShellSort.java) |        |
| 归并排序      | `O(nLogN)` | O(N)     | out-Place | 稳定   | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MergeSort.java) |        |
| 自顶向上的归并排序 | `O(nLogN)` | O(N)     | out-Place | 稳定   | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MergeSortBU.java) | 自顶先上   |
| 快速排序      | `O(nLogN)` | O(logN)  | In-Place  | 不稳定  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSort.java) |        |
| 快速排序2版    | `o(nLogN)` | O(logN)  | In-Place  | 不稳定  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSort2Ways.java) | 二路快排   |
| 三路快速排序    | `o(nLogN)` | O(logN)  | In-Place  | 不稳定  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSortThreeWays.java) | 上路快排   |
| 最大索引堆     | Null       | NUll     | NUll      | NUll | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MaxHeap.java) | 最大索引   |
| 堆排序       | `o(nLogN)` | O（1）     | In-Place  | 不稳定  | [Java]()                                 |        |
| 堆排序2      | `o(nLogN)` | O（1）     | In-Place  | 不稳定  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/HeapSort2.java) |        |
| 堆排序3      | `o(nLogN)` | O（1）     | In-Place  | 不稳定  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/HeapSort3.java) |        |
| 基数排序      | O(n * K)   | O(N + K) | Out—place | 稳定   | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/RadixSort.java) |        |



## [二叉树](https://github.com/Allenskoo856/AlgorithmsSolutions/tree/master/src/me/zonglun/BinaryTree)

| 二叉树          | 平均时间复杂度 | 空间复杂度 | 代码实现                                     |
| ------------ | ------- | ----- | ---------------------------------------- |
| 顺序查找表        | Null    | Null  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/SST.java) |
| 基于Hash的散列表   | Null    | NUll  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/SeparateChainingHashST.java) |
| 链式查找链表       | Null    | Null  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/SequentialSearchST.java) |
| 二分搜索树        | Null    | NUll  | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/BST.java) |
| 平衡二叉树---红黑树  | NUll    | Null  | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/BlackRedBST.java) |
| 二分查找算法  (递归) |         |       | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/BinarySearch2.java) |
| 二分查找算法(非递归)  |         |       | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/BinaryTree/BinarySearch.java) |



##  [图](https://github.com/Allenskoo856/AlgorithmsSolutions/tree/master/src/me/zonglun/Graph)

| 图                   | 平均时间复杂度 | 空间复杂度 | 代码实现                                     |
| ------------------- | ------- | ----- | ---------------------------------------- |
| DenseGraph          |         |       | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Graph/DenseGraph.java) |
| DenseWeightedGraph  |         |       | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Graph/DenseWeightedGraph.java) |
| SparseGraph         |         |       | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Graph/SparseGraph.java) |
| SparseWeightedGraph |         |       | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Graph/SparseWeightedGraph.java) |



## [剑指offer](https://github.com/Allenskoo856/AlgorithmsSolutions/tree/master/src/me/zonglun/SwordToOffer)

|        题目         |             英文              |                 牛客网在线编程                  |                   答案解答                   |
| :---------------: | :-------------------------: | :--------------------------------------: | :--------------------------------------: |
|    【二维数组中的查找】     | FindInPartiallySortedMatrix | [FindInPartiallySortedMatrix](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/FindInPartiallySortedMatrix.java) |
|      【替换空格】       |        ReplaceBlank         | [ReplaceBlank](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ReplaceBlank.java) |
|    【从尾到头打印链表】     |   PrintListFromTailToHead   | [PrintListFromTailToHead](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/PrintListFromTailToHead.java) |
|      【重建二叉树】      |    ReConstructBinaryTree    | [ReConstructBinaryTree](https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ReConstructBinaryTree.java) |
|    【用两个栈实现队列】     |        TwoStackQueue        | [TwoStackQueue](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/TwoStackQueue.java) |
|   【旋转数组的最小的数字】    |   MinNumberInRotateArray    | [MinNumberInRotateArray](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/MinNumberInRotateArray.java) |
|     【斐波那契数列】      |          Fibonacci          | [Fibonacci](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/Fibonacci.java) |
|       【跳台阶】       |          JumpSteps          | [JumpSteps](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/JumpSteps.java) |
|      【变态跳台阶】      |         JumpStepsII         | [JumpStepsII](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/JumpStepsII.java) |
|      【矩形覆盖】       |          RectCover          | [RectCover](https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/RectCover.java) |
|    【二进制中1的个数】     |          NumberOf1          | [NumberOf1](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/NumberOf1.java) |
|     【数值的整数次方】     |            Power            | [Power](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/Power.java) |
| 【调整数组顺序使奇数位于偶数前面】 |        ReOrderArray         | [ReOrderArray](https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ReOrderArray.java) |
|      【链表中倒数第K个节点】       |        FindKthToTail        | [FindKthToTail](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/FindKthToTail.java) |
|            【反转链表】            |         ReverseList         | [ReverseList](https://www.nowcoder.com/practice/75e878df47f24fdc9dc3e400ec6058ca?tpId=13&tqId=11168&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ReverseList.java) |
|       【合并两个排序的链表】       |        ListNodeMerge        | [ListNodeMerge](https://www.nowcoder.com/practice/d8b6b4358f774294a89de2a6ac4d9337?tpId=13&tqId=11169&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ListNodeMerge.java) |
|           【树的子结构】           |         HasSubtree          | [HasSubtree](https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/HasSubtree.java) |
|          【二叉树的镜像】          |      MirrorBinaryTree       | [MirrorBinaryTree](https://www.nowcoder.com/practice/564f4c26aa584921bc75623e48ca3011?tpId=13&tqId=11171&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/MirrorBinaryTree.java) |
|         【顺时针打印矩阵】         |         PrintMatrix         | [PrintMatrix](https://www.nowcoder.com/practice/9b4c81a02cd34f76be2659fa0d54342a?tpId=13&tqId=11172&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) |                                                              |
|        【包含min函数的栈】         |         GetMinStack         | [GetMinStack](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/GetMinStack.java) |
|        【栈的压入弹出顺序】        |         IsPopOrder          | [IsPopOrder](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/IsPopOrder.java) |
|       【从上往下打印二叉树】       |                             |                                                              |                                                              |
|    【二叉搜索树的后序遍历序列】    |                             |                                                              |                                                              |
|    【二叉树中和为某一值的路径】    |                             |                                                              |                                                              |
|         【复杂链表的复制】         |       RandomListNode        | [RandomListNode](https://www.nowcoder.com/practice/f836b2c43afc4b35ad6adc41ec941dba?tpId=13&tqId=11178&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/RandomListNodeClone.java) |
|      【二叉搜索树与双向链表】      |                             |                                                              |                                                              |
|          【字符串的排序】          |        TReeCodeSort         |                         TReeCodeSort                         |                                                              |
|  【数组中出现次数超过一半的数字】  |                             |                                                              |                                                              |
|          【最小的K个数】           |                             |                                                              |                                                              |
|       【连续子数组的最大和】       |                             |                                                              |                                                              |
|       【整数中1出现的次数】        |                             |                                                              |                                                              |
|       【把数组排成最小的数】       |                             |                                                              |                                                              |
|              【丑数】              |                             |                                                              |                                                              |
|   【第一个只出现一次的字符位置】   |                             |                                                              |                                                              |
|          【数组的逆序对】          |                             |                                                              |                                                              |
|   【两个链表中的第一个公共节点】   |  FindFirstCommonNodeInList  | [FindFirstCommonNodeInList](https://www.nowcoder.com/practice/6ab1d9a29e88450685099d45c9e31e46?tpId=13&tqId=11189&tPage=2&rp=2&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/FindFirstCommonNodeInList.java) |
|   【数字在排序数组中出现的次数】   |                             |                                                              |                                                              |
|          【二叉树的深度】          |                             |                                                              |                                                              |
|           【平衡二叉树】           |                             |                                                              |                                                              |
|     【数组中只出现一次的数字】     |                             |                                                              |                                                              |
|      【和为S的连续正数序列】       |                             |                                                              |                                                              |
|        【和为S的两个数字】         |                             |                                                              |                                                              |
|          【左旋转字符串】          |                             |                                                              |                                                              |
|         【翻转单词顺序列】         |                             |                                                              |                                                              |
|           【扑克牌顺子】           |                             |                                                              |                                                              |
|          【孩子们的游戏】          |                             |                                                              |                                                              |
|         【求1+2+3+...+n】          |                             |                                                              |                                                              |
|       【不用加减乘除做加法】       |                             |                                                              |                                                              |
|       【把字符串转换成整数】       |                             |                                                              |                                                              |
|        【数组中重复的数字】        |                             |                                                              |                                                              |
|          【构建乘积数组】          |                             |                                                              |                                                              |
|         【正则表达式匹配】         |                             |                                                              |                                                              |
|        【表示数值的字符串】        |                             |                                                              |                                                              |
|   【字符流中第一个不重复的字符】   |                             |                                                              |                                                              |
|       【链表中环的入口结点】       |       EntryNodeOfLoop       | [EntryNodeOfLoop](https://www.nowcoder.com/practice/253d2c59ec3e4bc68da16833f79a38e4?tpId=13&tqId=11208&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/EntryNodeOfLoop.java) |
|      【删除链表中重复的节点】      |  DeleteDuplicationListNode  | [DeleteDuplicationListNode](https://www.nowcoder.com/practice/fc533c45b73a41b0b44ccba763f866ef?tpId=13&tqId=11209&tPage=3&rp=3&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/DeleteDuplicationListNode.java) |
|       【二叉树的下一个节点】       |                             |                                                              |                                                              |
|          【对称的二叉树】          |                             |                                                              |                                                              |
|     【按之字形顺序打印二叉树】     |                             |                                                              |                                                              |
|       【把二叉树打印成多行】       |                             |                                                              |                                                              |
|          【序列化二叉树】          |                             |                                                              |                                                              |
|     【二叉搜索树的第K个节点】      |                             |                                                              |                                                              |
|        【数据流中的中位数】        |                             |                                                              |                                                              |
|        【滑动窗口的最大值】        |                             |                                                              |                                                              |
|          【矩阵中的路径】          |                             |                                                              |                                                              |





## References

- 算法第四版  ：https://book.douban.com/subject/19952400/
- 剑指offer  ：https://book.douban.com/subject/6966465/
- Algorithms, 4th edition textbook code and libraries：https://github.com/kevin-wayne/algs4
- 《算法（第4版）》习题解答 ：https://github.com/jimmysuncpt/Algorithms &&  https://github.com/aistrate/AlgorithmsSedgewick
- 慕课网上的课程《算法与数据结构》： https://github.com/liuyubobobo/Play-with-Algorithms
- Algorithm Visualizer ：https://github.com/parkjs814/AlgorithmVisualizer
- 一些好的计算机科学门户网站：https://www.geeksforgeeks.org/data-structures/
- 排序算法的 GitBook 在线书籍 《十大经典排序算法》：https://github.com/hustcc/JS-Sorting-Algorithm

