# 排序

### 排序算法说明

**（1）排序的定义：对一序列对象根据某个关键字进行排序；**

输入：n个数：a1,a2,a3,...,an
输出：n个数的排列:a1',a2',a3',...,an'，使得a1'<=a2'<=a3'<=...<=an'。

再讲的形象点就是排排坐，调座位，高的站在后面，矮的站在前面咯。

**（3）对于评述算法优劣术语的说明**

**稳定**：如果a原本在b前面，而a=b，排序之后a仍然在b的前面；
**不稳定**：如果a原本在b的前面，而a=b，排序之后a可能会出现在b的后面；

**内排序**：所有排序操作都在内存中完成；
**外排序**：由于数据太大，因此把数据放在磁盘中，而排序通过磁盘和内存的数据传输才能进行；

**时间复杂度**: 一个算法执行所耗费的时间。
**空间复杂度**: 运行完一个程序所需内存的大小。

关于时间空间复杂度的更多了解请戳[这里](http://blog.csdn.net/booirror/article/details/7707551/)，或是看书程杰大大编写的《大话数据结构》还是很赞的，通俗易懂。

**（4）排序算法图片总结(图片来源于网络):**

排序对比：![mark](https://ojd94jpsx.qnssl.com/blog/20170910/205952484.png)

###  图片名词解释

- n: 数据规模

- k:“桶”的个数

- In-place: 占用常数内存，不占用额外内存

- Out-place: 占用额外内存 

  ​

### 排序的分类

![mark](https://ojd94jpsx.qnssl.com/blog/20170910/210229853.jpg)

### 1.冒泡排序（Bubble Sort）

> 好的，开始总结第一个排序算法，冒泡排序。我想对于它每个学过C语言的都会了解的吧，这可能是很多人接触的第一个排序算法。

#### (1)算法描述

> 冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

#### (2)算法描述和实现

具体算法描述如下：

- <1>.比较相邻的元素。如果第一个比第二个大，就交换它们两个；
- <2>.对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
- <3>.针对所有的元素重复以上的步骤，除了最后一个；
- <4>.重复步骤1~3，直到排序完成。

![mark](https://ojd94jpsx.qnssl.com/blog/20170910/211414701.jpg)

#### [Java 代码实现](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/BubbleSort.java)



#### JS 代码实现

```javascript
function bubbleSort(arr) {
    var len = arr.length;
    for (var i = 0; i < len; i++) {
        for (var j = 0; j < len - 1 - i; j++) {
            if (arr[j] > arr[j+1]) {        //相邻元素两两对比
                var temp = arr[j+1];        //元素交换
                arr[j+1] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}
var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(bubbleSort(arr));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

> **改进冒泡排序： **设置一标志性变量pos,用于记录每趟排序中最后一次进行交换的位置。由于pos位置之后的记录均已交换到位,故在进行下一趟排序时只要扫描到pos位置即可。

改进的算法实现为:

```javascript
function bubbleSort3(arr3) {
    var low = 0;
    var high= arr.length-1; //设置变量的初始值
    var tmp,j;
    console.time('2.改进后冒泡排序耗时');
    while (low < high) {
        for (j= low; j< high; ++j) //正向冒泡,找到最大者
            if (arr[j]> arr[j+1]) {
                tmp = arr[j]; arr[j]=arr[j+1];arr[j+1]=tmp;
            }
        --high;                 //修改high值, 前移一位
        for (j=high; j>low; --j) //反向冒泡,找到最小者
            if (arr[j]<arr[j-1]) {
                tmp = arr[j]; arr[j]=arr[j-1];arr[j-1]=tmp;
            }
        ++low;                  //修改low值,后移一位
    }
    console.timeEnd('2.改进后冒泡排序耗时');
    return arr3;
}
var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(bubbleSort3(arr));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

**冒泡排序的动画表示：**

![mark](https://ojd94jpsx.qnssl.com/blog/20170910/212753864.gif)

#### 时间复杂度分析

- 最佳情况：T(n) = O(n)

> 当输入的数据已经是正序时（都已经是正序了，为毛何必还排序呢....）

- 最差情况：T(n) = O(n^2)

> 当输入的数据是反序时(卧槽，我直接反序不就完了....)

- 平均情况：T(n) = O(n^2)

  ​

----

### 2. 选择排序（Selection Sort）

> 表现最稳定的排序算法之一(这个稳定不是指算法层面上的稳定哈，相信聪明的你能明白我说的意思2333)，因为无论什么数据进去都是O(n²)的时间复杂度.....所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。理论上讲，选择排序可能也是平时排序一般人想到的最多的排序方法了吧。

#### (1)算法简介

> 选择排序(Selection-sort)是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

#### (2)算法描述和实现

- **基本思想：**
  在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
  第二次遍历n-2个数，找到最小的数值与第二个元素交换；
  。。。
  第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。

- 过程：![mark](https://ojd94jpsx.qnssl.com/blog/20170910/213413190.png)

- [**java代码实现：**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/SelectionSort.java)

  动态过程分析：

  ![mark](https://ojd94jpsx.qnssl.com/blog/20170910/213620046.gif)

**js 代码展示**

```javascript
function selectionSort(arr) {
    var len = arr.length;
    var minIndex, temp;
    console.time('选择排序耗时');
    for (var i = 0; i < len - 1; i++) {
        minIndex = i;
        for (var j = i + 1; j < len; j++) {
            if (arr[j] < arr[minIndex]) {     //寻找最小的数
                minIndex = j;                 //将最小数的索引保存
            }
        }
        temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
    console.timeEnd('选择排序耗时');
    return arr;
}
var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(selectionSort(arr));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

#### (3)算法分析

- 最佳情况：T(n) = O(n^2)

- 最差情况：T(n) = O(n^2)

- 平均情况：T(n) = O(n^2)

  ​

---

### 3. 插入排序（Insertion Sort）

> 插入排序的代码实现虽然没有冒泡排序和选择排序那么简单粗暴，但它的原理应该是最容易理解的了，因为只要打过扑克牌的人都应该能够秒懂。当然，如果你说你打扑克牌摸牌的时候从来不按牌的大小整理牌，那估计这辈子你对插入排序的算法都不会产生任何兴趣了.....

#### (1)算法简介

> 插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

#### (2)算法描述和实现

一般来说，插入排序都采用in-place在数组上实现。具体算法描述如下：

- <1>.从第一个元素开始，该元素可以认为已经被排序；
- <2>.取出下一个元素，在已经排序的元素序列中从后向前扫描；
- <3>.如果该元素（已排序）大于新元素，将该元素移到下一位置；
- <4>.重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
- <5>.将新元素插入到该位置后；
- <6>.重复步骤2~5。

#### (3) 算法图解

![mark](https://ojd94jpsx.qnssl.com/blog/20170910/214045510.png)

#### (4) 代码实现

##### [Java代码实现](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/InsertionSort.java)

JS 代码实现

```javascript
function insertionSort(array) {
    if (Object.prototype.toString.call(array).slice(8, -1) === 'Array') {
        console.time('插入排序耗时：');
        for (var i = 1; i < array.length; i++) {
            var key = array[i];
            var j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        console.timeEnd('插入排序耗时：');
        return array;
    } else {
        return 'array is not an Array!';
    }
}
```



![mark](https://ojd94jpsx.qnssl.com/blog/20170910/214559384.gif)

#### （5）算法分析

- 最佳情况：输入数组按升序排列。T(n) = O(n)

- 最坏情况：输入数组按降序排列。T(n) = O(n^2)

- 平均情况：T(n) = O(n^2)

  ​

----

###  4. 希尔排序（Shell Sort）

> 1959年Shell发明；
> 第一个突破O(n^2)的排序算法；是简单插入排序的改进版；它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序

#### (1)算法简介

> 希尔排序的核心在于间隔序列的设定。既可以提前设定好间隔序列，也可以动态的定义间隔序列。动态定义间隔序列的算法是《算法（第4版》的合著者Robert Sedgewick提出的。

#### (2)算法描述和实现

先将整个待排序的记录序列分割成为若干子序列分别进行直接插入排序，具体算法描述：

- <1>. 选择一个增量序列t1，t2，…，tk，其中ti>tj，tk=1；
- <2>.按增量序列个数k，对序列进行k 趟排序；
- <3>.每趟排序，根据对应的增量ti，将待排序列分割成若干长度为m 的子序列，分别对各子表进行直接插入排序。仅增量因子为1 时，整个序列作为一个表来处理，表长度即为整个序列的长度。

#### [Java实现](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/ShellSort.java)

```javascript
function shellSort(arr) {
    var len = arr.length,
        temp,
        gap = 1;
    console.time('希尔排序耗时:');
    while(gap < len/5) {          //动态定义间隔序列
        gap =gap*5+1;
    }
    for (gap; gap > 0; gap = Math.floor(gap/5)) {
        for (var i = gap; i < len; i++) {
            temp = arr[i];
            for (var j = i-gap; j >= 0 && arr[j] > temp; j-=gap) {
                arr[j+gap] = arr[j];
            }
            arr[j+gap] = temp;
        }
    }
    console.timeEnd('希尔排序耗时:');
    return arr;
}
var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(shellSort(arr));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

**希尔排序图示（图片来源网络）：**

![这里写图片描述](http://img.blog.csdn.net/20160916235203417)

![mark](https://ojd94jpsx.qnssl.com/blog/20170913/101659655.gif)

**以23, 10, 4, 1的步长序列进行希尔排序。**

#### (4) 算法分析

- 最佳情况：T(n) = O(n（log n）^2)

- 最坏情况：T(n) = O(n（log n）^2)

- 平均情况：T(n) =O(nlog n)

  ​

-----

### 5. 并归排序算法（Merge Sort）

> 和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。

#### (1)算法简介

> 　归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。

#### (2)算法描述和实现

> 具体算法描述如下：
>
> - <1>.把长度为n的输入序列分成两个长度为n/2的子序列；
> - <2>.对这两个子序列分别采用归并排序；
> - <3>.将两个排序好的子序列合并成一个最终的排序序列。

#### （3）算法的图像描述

![mark](https://ojd94jpsx.qnssl.com/blog/20170911/095340028.gif)

#### (4) 代码实现 

```javascript
function mergeSort(arr) {  //采用自上而下的递归方法
    var len = arr.length;
    if(len < 2) {
        return arr;
    }
    var middle = Math.floor(len / 2),
        left = arr.slice(0, middle),
        right = arr.slice(middle);
    return merge(mergeSort(left), mergeSort(right));
}

function merge(left, right)
{
    var result = [];
    console.time('归并排序耗时');
    while (left.length && right.length) {
        if (left[0] <= right[0]) {
            result.push(left.shift());
        } else {
            result.push(right.shift());
        }
    }

    while (left.length)
        result.push(left.shift());

    while (right.length)
        result.push(right.shift());
    console.timeEnd('归并排序耗时');
    return result;
}
var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(mergeSort(arr));
```

[*Java代码分析*](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MergeSort.java)

[自顶向上的归并排序](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MergeSortBU.java)

#### (5) 算法分析复杂度

- 最佳情况：T(n) = O(n)

- 最差情况：T(n) = O(nlogn)

- 平均情况：T(n) = O(nlogn)

  ​

----

### 6. 快速排序（Quick Sort）

> 快速排序的名字起的是简单粗暴，因为一听到这个名字你就知道它存在的意义，就是快，而且效率高! 它是处理大数据最快的排序算法之一了。

#### (1)算法简介

> 快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

#### (2)算法描述和实现

快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）。具体算法描述如下：

- <1>.从数列中挑出一个元素，称为 "基准"（pivot）；
- <2>.重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
- <3>.递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。

#### （3）算法代码实现

```javascript
/*方法说明：快速排序
@param  array 待排序数组*/
//方法一
function quickSort(array, left, right) {
    console.time('1.快速排序耗时');
    if (Object.prototype.toString.call(array).slice(8, -1) === 'Array' && typeof left === 'number' && typeof right === 'number') {
        if (left < right) {
            var x = array[right], i = left - 1, temp;
            for (var j = left; j <= right; j++) {
                if (array[j] <= x) {
                    i++;
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            quickSort(array, left, i - 1);
            quickSort(array, i + 1, right);
        }
        console.timeEnd('1.快速排序耗时');
        return array;
    } else {
        return 'array is not an Array or left or right is not a number!';
    }
}

//方法二
var quickSort2 = function(arr) {
    console.time('2.快速排序耗时');
　　if (arr.length <= 1) { return arr; }
　　var pivotIndex = Math.floor(arr.length / 2);
　　var pivot = arr.splice(pivotIndex, 1)[0];
　　var left = [];
　　var right = [];
　　for (var i = 0; i < arr.length; i++){
　　　　if (arr[i] < pivot) {
　　　　　　left.push(arr[i]);
　　　　} else {
　　　　　　right.push(arr[i]);
　　　　}
　　}
console.timeEnd('2.快速排序耗时');
　　return quickSort2(left).concat([pivot], quickSort2(right));
};

var arr=[3,44,38,5,47,15,36,26,27,2,46,4,19,50,48];
console.log(quickSort(arr,0,arr.length-1));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
console.log(quickSort2(arr));//[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

| Java实现  |                                          |
| ------- | ---------------------------------------- |
| 快排第一个版本 | [**QuickSort.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSort.java) |
| 快排优化    | [**QuickSortOptimize.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSortOptimize.java) |
| 二路快排    | [**QuickSort2Ways.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSort2Ways.java) |
| 三路快排    | [**QuickSortThreeWays**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/QuickSortThreeWays.java) |

**快速排序动图演示：**

![快速排序](http://img.blog.csdn.net/20160917003004906)

#### (4) 算法分析

- 最佳情况：T(n) = O(nlogn)

- 最差情况：T(n) = O(n2)

- 平均情况：T(n) = O(nlogn)

  ​

----

### 7. 堆排序（Heap Sort）

> 堆排序可以说是一种利用堆的概念来排序的选择排序。

#### (1)算法简介

> 堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

#### (2)算法描述和实现

具体算法描述如下：

- <1>.将初始待排序关键字序列(R1,R2....Rn)构建成大顶堆，此堆为初始的无序区；
- <2>.将堆顶元素R[1]与最后一个元素R[n]交换，此时得到新的无序区(R1,R2,......Rn-1)和新的有序区(Rn),且满足R[1,2...n-1]<=R[n]；
- <3>.由于交换后新的堆顶R[1]可能违反堆的性质，因此需要对当前无序区(R1,R2,......Rn-1)调整为新堆，然后再次将R[1]与无序区最后一个元素交换，得到新的无序区(R1,R2....Rn-2)和新的有序区(Rn-1,Rn)。不断重复此过程直到有序区的元素个数为n-1，则整个排序过程完成。

**Javascript代码实现：**

```javascript
/*方法说明：堆排序
@param  array 待排序数组*/
function heapSort(array) {
    console.time('堆排序耗时');
    if (Object.prototype.toString.call(array).slice(8, -1) === 'Array') {
        //建堆
        var heapSize = array.length, temp;
        for (var i = Math.floor(heapSize / 2) - 1; i >= 0; i--) {
            heapify(array, i, heapSize);
        }

        //堆排序
        for (var j = heapSize - 1; j >= 1; j--) {
            temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            heapify(array, 0, --heapSize);
        }
        console.timeEnd('堆排序耗时');
        return array;
    } else {
        return 'array is not an Array!';
    }
}
/*方法说明：维护堆的性质
@param  arr 数组
@param  x   数组下标
@param  len 堆大小*/
function heapify(arr, x, len) {
    if (Object.prototype.toString.call(arr).slice(8, -1) === 'Array' && typeof x === 'number') {
        var l = 2 * x + 1, r = 2 * x + 2, largest = x, temp;
        if (l < len && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < len && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != x) {
            temp = arr[x];
            arr[x] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, len);
        }
    } else {
        return 'arr is not an Array or x is not a number!';
    }
}
var arr=[91,60,96,13,35,65,46,65,10,30,20,31,77,81,22];
console.log(heapSort(arr));//[10, 13, 20, 22, 30, 31, 35, 46, 60, 65, 65, 77, 81, 91, 96]
```

**堆排序动画演示：**

![mark](https://ojd94jpsx.qnssl.com/blog/20170911/145742511.png)

![mark](https://ojd94jpsx.qnssl.com/blog/20170911/145912341.png)

![mark](https://ojd94jpsx.qnssl.com/blog/20170911/150048612.gif)

#### （3）代码实现

| 堆排序  | 地址                                       |
| ---- | ---------------------------------------- |
| 最大堆  | [**MaxHeap.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/MaxHeap.java) |
| 堆排序1 | [**HeapSort1.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/HeapSort1.java) |
| 堆排序2 | [**HeapSort2.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/HeapSort2.java) |
| 堆排序3 | [**HeapSort3.java**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/HeapSort3.java) |

```javascript
/*方法说明：堆排序
@param  array 待排序数组*/
function heapSort(array) {
    console.time('堆排序耗时');
    if (Object.prototype.toString.call(array).slice(8, -1) === 'Array') {
        //建堆
        var heapSize = array.length, temp;
        for (var i = Math.floor(heapSize / 2) - 1; i >= 0; i--) {
            heapify(array, i, heapSize);
        }

        //堆排序
        for (var j = heapSize - 1; j >= 1; j--) {
            temp = array[0];
            array[0] = array[j];
            array[j] = temp;
            heapify(array, 0, --heapSize);
        }
        console.timeEnd('堆排序耗时');
        return array;
    } else {
        return 'array is not an Array!';
    }
}
/*方法说明：维护堆的性质
@param  arr 数组
@param  x   数组下标
@param  len 堆大小*/
function heapify(arr, x, len) {
    if (Object.prototype.toString.call(arr).slice(8, -1) === 'Array' && typeof x === 'number') {
        var l = 2 * x + 1, r = 2 * x + 2, largest = x, temp;
        if (l < len && arr[l] > arr[largest]) {
            largest = l;
        }
        if (r < len && arr[r] > arr[largest]) {
            largest = r;
        }
        if (largest != x) {
            temp = arr[x];
            arr[x] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest, len);
        }
    } else {
        return 'arr is not an Array or x is not a number!';
    }
}
var arr=[91,60,96,13,35,65,46,65,10,30,20,31,77,81,22];
console.log(heapSort(arr));//[10, 13, 20, 22, 30, 31, 35, 46, 60, 65, 65, 77, 81, 91, 96]
```

#### (4)复杂度分析

- 最佳情况：T(n) = O(nlogn)
- 最差情况：T(n) = O(nlogn)
- 平均情况：T(n) = O(nlogn)


---



### 8. 基数排序（Radix Sort）

> 基数排序也是非比较的排序算法，对每一位进行排序，从最低位开始排序，复杂度为O(kn),为数组长度，k为数组中的数的最大的位数；

#### (1)算法简介

> 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。

#### (2)算法描述和实现

具体算法描述如下：

- <1>.取得数组中的最大数，并取得位数；
- <2>.arr为原始数组，从最低位开始取每个位组成radix数组；
- <3>.对radix进行计数排序（利用计数排序适用于小范围数的特点）；

**Javascript代码实现：**

[**Java实现**](https://github.com/Allenskoo856/AlgorithmsSolutions/blob/master/src/me/zonglun/Sort/RadixSort.java)

```javascript
/**
 * 基数排序适用于：
 *  (1)数据范围较小，建议在小于1000
 *  (2)每个数值都要大于等于0
 * @author xiazdong
 * @param  arr 待排序数组
 * @param  maxDigit 最大位数
 */
//LSD Radix Sort

function radixSort(arr, maxDigit) {
    var mod = 10;
    var dev = 1;
    var counter = [];
    console.time('基数排序耗时');
    for (var i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
        for(var j = 0; j < arr.length; j++) {
            var bucket = parseInt((arr[j] % mod) / dev);
            if(counter[bucket]== null) {
                counter[bucket] = [];
            }
            counter[bucket].push(arr[j]);
        }
        var pos = 0;
        for(var j = 0; j < counter.length; j++) {
            var value = null;
            if(counter[j]!=null) {
                while ((value = counter[j].shift()) != null) {
                      arr[pos++] = value;
                }
          }
        }
    }
    console.timeEnd('基数排序耗时');
    return arr;
}
var arr = [3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48];
console.log(radixSort(arr,2)); //[2, 3, 4, 5, 15, 19, 26, 27, 36, 38, 44, 46, 47, 48, 50]
```

**基数排序LSD动图演示：**

![这里写图片描述](http://img.blog.csdn.net/20160917123313659)

#### (3)算法分析

- 最佳情况：T(n) = O(n * k)
- 最差情况：T(n) = O(n * k)
- 平均情况：T(n) = O(n * k)

基数排序有两种方法：

- MSD 从高位开始进行排序
- LSD 从低位开始进行排序

**基数排序 vs 计数排序 vs 桶排序**

这三种排序算法都利用了桶的概念，但对桶的使用方法上有明显差异：

1. 基数排序：根据键值的每位数字来分配桶
2. 计数排序：每个桶只存储单一键值
3. 桶排序：每个桶存储一定范围的数值


-----

### 总结

**排序分类的主要图解：**



![mark](https://ojd94jpsx.qnssl.com/blog/20170911/151138009.png)

**算法复杂度的基本分析：**

![mark](https://ojd94jpsx.qnssl.com/blog/20170911/151252189.jpg)



----

### 选择排序算法准则

> 每种排序算法都各有优缺点。因此，在实用时需根据不同情况适当选用，甚至可以将多种方法结合起来使用。
>
> 影响排序的因素有很多，平均时间复杂度低的算法并不一定就是最优的。相反，有时平均时间复杂度高的算法可能更适合某些特殊情况。同时，选择算法时还得考虑它的可读性，以利于软件的维护。一般而言，需要考虑的因素有以下四点：

 

1. **待排序的记录数目n的大小；**
2. **记录本身数据量的大小，也就是记录中除关键字外的其他信息量的大小；**
3. **关键字的结构及其分布情况；**
4. **对排序稳定性的要求。**

设待排序元素的个数为n

> 1）当n较大，则应采用时间复杂度为O(nlog2n)的排序方法：快速排序、堆排序或归并排序序。
>
> 快速排序：是目前基于比较的内部排序中被认为是最好的方法，当待排序的关键字是随机分布时，快速排序的平均时间最短；
>
> 堆排序：如果内存空间允许且要求稳定性的，
>
> 归并排序：它有一定数量的数据移动，所以我们可能过与插入排序组合，先获得一定长度的序列，然后再合并，在效率上将有所提高。

----



> 2）当n较大，内存空间允许，且要求稳定性，推荐归并排序

 

> 3）当n较小，可采用直接插入或直接选择排序。
>
> 直接插入排序：当元素分布有序，直接插入排序将大大减少比较次数和移动记录的次数。
>
> 直接选择排序 ：元素分布有序，如果不要求稳定性，选择直接选择排序

 

> 5）一般不使用或不直接使用传统的冒泡排序。

 

> 6）基数排序
>
> 它是一种稳定的排序算法，但有一定的局限性：
>
> 　　1、关键字可分解。
>
> 　　2、记录的关键字位数较少，如果密集更好
>
> 　　3、如果是数字时，最好是无符号的，否则将增加相应的映射复杂度，可先将其正负分开排序。
