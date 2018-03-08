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

| 题目           | 英文                          | 牛客网在线编程                                  | 答案解答                                     |
| ------------ | --------------------------- | ---------------------------------------- | ---------------------------------------- |
| 【二维数组中的查找】   | FindInPartiallySortedMatrix | [FindInPartiallySortedMatrix](https://www.nowcoder.com/practice/abc3fe2ce8e146608e868a70efebf62e?tpId=13&tqId=11154&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking) | [Java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/FindInPartiallySortedMatrix.java) |
| 【替换空格】       | ReplaceBlank                | [ReplaceBlank](https://www.nowcoder.com/practice/4060ac7e3e404ad1a894ef3e17650423?tpId=13&tqId=11155&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/ReplaceBlank.java) |
| 【从头到尾打印链表】   | PrintListFromTailToHead     | [PrintListFromTailToHead](https://www.nowcoder.com/practice/d0267f7f55b3412ba93bd35cfa8e8035?tpId=13&tqId=11156&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/PrintListFromTailToHead.java) |
| 【用两个栈实现队列】   | TwoStackQueue               | [TwoStackQueue](https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=13&tqId=11158&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/TwoStackQueue.java) |
| 【旋转数组的最小的数字】 | MinNumberInRotateArray      | [MinNumberInRotateArray](https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/MinNumberInRotateArray.java) |
| 【斐波那契数列】     | Fibonacci                   | [Fibonacci](https://www.nowcoder.com/practice/c6c7742f5ba7442aada113136ddea0c3?tpId=13&tqId=11160&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/Fibonacci.java) |
| 【跳台阶】        | JumpSteps                   | [JumpSteps](https://www.nowcoder.com/practice/8c82a5b80378478f9484d87d1c5f12a4?tpId=13&tqId=11161&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/JumpSteps.java) |
| 【变态跳台阶】      | JumpStepsII                 | [JumpStepsII](https://www.nowcoder.com/practice/22243d016f6b47f2a6928b4313c85387?tpId=13&tqId=11162&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/JumpStepsII.java) |
| 【矩形覆盖】       | RectCover                   | [RectCover](https://www.nowcoder.com/practice/72a5a919508a4251859fb2cfb987a0e6?tpId=13&tqId=11163&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/RectCover.java) |
| 【二进制中1的个数】   | NumberOf1                   | [NumberOf1](https://www.nowcoder.com/practice/8ee967e43c2c4ec193b040ea7fbb10b8?tpId=13&tqId=11164&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/NumberOf1.java) |
| 【数值的整数次方】    | Power                       | [Power](https://www.nowcoder.com/practice/1a834e5e3e1a4b7ba251417554e07c00?tpId=13&tqId=11165&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/Power.java) |
| 【链表中倒数第K个节点】 | FindKthToTail               | [FindKthToTail](https://www.nowcoder.com/practice/529d3ae5a407492994ad2a246518148a?tpId=13&tqId=11167&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/FindKthToTail.java) |
| 【包含min函数的栈】  | GetMinStack                 | [GetMinStack](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/GetMinStack.java) |
| 【栈的压入弹出顺序】   | IsPopOrder                  | [IsPopOrder](https://www.nowcoder.com/practice/d77d11405cc7470d82554cb392585106?tpId=13&tqId=11174&tPage=2&rp=1&ru=%2Fta%2Fcoding-interviews&qru=%2Fta%2Fcoding-interviews%2Fquestion-ranking) | [java](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/SwordToOffer/IsPopOrder.java) |
|              |                             |                                          |                                          |





## References

- 算法第四版  ：https://book.douban.com/subject/19952400/
- 剑指offer  ：https://book.douban.com/subject/6966465/
- Algorithms, 4th edition textbook code and libraries：https://github.com/kevin-wayne/algs4
- 《算法（第4版）》习题解答 ：https://github.com/jimmysuncpt/Algorithms &&  https://github.com/aistrate/AlgorithmsSedgewick
- 慕课网上的课程《算法与数据结构》： https://github.com/liuyubobobo/Play-with-Algorithms
- Algorithm Visualizer ：https://github.com/parkjs814/AlgorithmVisualizer
- 一些好的计算机科学门户网站：https://www.geeksforgeeks.org/data-structures/
- 排序算法的 GitBook 在线书籍 《十大经典排序算法》：https://github.com/hustcc/JS-Sorting-Algorithm

