# Algorithms
Algorithm practice

## 整数Integer
### 基础
4种整数类型:
* byte(-128 ~ 127)<br>
* short(-32768 ~ 32767)<br>
* int(-pow(2,31) ~ pow(2,31))&nbsp;&nbsp;min:0x80000000&nbsp;&nbsp;max:0x8fffffff<br>
* long(-pow(2,63) ~ pow(2,63))
<br>

<a href="./src/main/day6/integer/Divide.java">面试题1：整数除法<a/>

### 二进制
<br>&nbsp;&nbsp;&nbsp;&nbsp;二进制是指数字的每位都是0或1
<br>

&nbsp;&nbsp;&nbsp;&nbsp;位运算：
非、与、或、异或、左移、和右移6种
<table style="text-align: center">
    <tr style="border: 2px">
        <td>与（&）</td>
        <td>0 & 0 = 0</td>
        <td>1 & 0 = 0</td>
        <td>0 & 1 = 0</td>
        <td>1 & 1 = 1</td>
    </tr>
    <tr>
        <td>或（|）</td>
        <td>0 | 0 = 0</td>
        <td>1 | 0 = 1</td>
        <td>0 | 1 = 1</td>
        <td>1 | 1 = 1</td>
    </tr>    
    <tr>
        <td>异或（^）</td>
        <td>0 ^ 0 = 0</td>
        <td>0 ^ 1 = 1</td>
        <td>1 ^ 0 = 1</td>
        <td>1 ^ 1 = 0</td>
    </tr>
</table>
<br>
左移运算符：<<
<br>
&nbsp;&nbsp;&nbsp;&nbsp;
m << n,表示把m左移n位。最左边的n位将被丢弃，同时在最右边补上n个0

    //左移
    00001010 << 2 = 00101000
    10001010 << 3 = 01010000

右移运算符：>>
<br>
&nbsp;&nbsp;&nbsp;&nbsp;
m >> n,表示把m右移n位。最左边的n位将被丢弃，但右移时处理最左边位的情况比较复杂。

* 若数字是一个无符号数，则用0补全最左边的n位。
* 若数字是一个有符号数，则用符号位补全最左边的n位。
  * 若为正数，则用0补全最左边的n位；
  * 若为负数，则用1补全最左边的n位。
    
    
    //对8位有符号数进行右移
    00001010 >> 2 = 00000010
    10001010 >> 3 = 11110001

Java中增加了一种无符号右移操作符:“>>>”,无论是正数还是负数进行无符号位移都将在最左边插入"0
    
    //无符号右移操作
    00001010 >> 2 = 00000010
    10001010 >> 3 = 00010001

<br>
<a href="./src/main/day6/binary/BinaryAdd.java">面试题2：二进制加法</a>
<br>
<a href="./src/main/day6/binary/CountBinary.java">面试题3：数字二进制形式中1的个数</a>
<br>
<a href="./src/main/day6/binary/OnlyOneNum.java">面试题4：只出现一次的数字</a>
<br>
<a href="./src/main/day7/binary/MaxProduct.java">面试题5：单词长度的最大乘积</a>

# 

## 数组Array
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数组是一种简单的数据结构，是由相同的元素组成的数据集合,并占据一块<span style="font-size: border,color: red">连续的内存并按照顺序储存</span>数据。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数组创建时需要先指定数组容量的大小，然后根据容量的大小分配内存。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数组的空间利用效率不一定很高，可能会由空闲的区域没有得到充分的利用。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Java 中的<code>ArrayList<code><</code>T<code>></code></code>为动态数组。<br>


<code>ArrayList<code><</code>T<code>></code></code>动态数组机制:

* 先为数组分配较小的内存空间，在需要的时候在数组中添加新的数据
* 当数组的容量不足时，重新分配一块更大的空间(新容量为之前容量的2倍)
* 把之前数组中的数据复制到新的数组中
* 将之前分配的内存释放 
  
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;动态数组这种机制能减少内存的浪费，但每次扩充数组时都有大量的额外操作，对时间性能有负面影响。

<a href="./src/main/utils/simplenode/ArrayLists.java">ArrayList(未实现)</a>

### 双指针
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;使用两个方向相同或相反的指针扫描数组。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;这里的指针并不专指C语言中的指针，是能定位数据容器中某个数据的手段。<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在数组中就是数组的下标。<br>

* 方向相反的双指针:经常用来求排序数组中的两个数字之和，两个指针移动方向相反。

  * 数组为升序数组;
  * P1指向数组的第一个数字，P2指向数组的最后一个数字，然后比较两个指针指向的数字之和及一个目标值;
  * 若两个指针指向的数字之和大于一个目标值，则右指针P2左移;
  * 若两个指针指向的数字之和小于一个目标值，则左指针P1右移;

<a href="./src/main/day7/array/SortArraySum.java">面试题6：排序数组中的两个数字之和</a>
<br>
<a href="./src/main/day7/array/ThreeSumZero.java">面试题7：数组中和为0的3个数字</a>


* 方向相同的双指针:通常用来求正数数组中子数组的和或乘积，两个指针移动方向相同。

  * P1和P2都指向数组的第一个数字，然后比较两个指针指向的数字之和或乘积及一个目标值;
  * 若两个指针指向的数字之和或乘积大于一个目标值，则P1右移删除子数组最左边的数据;
  * 若两个指针指向的数字之和或乘积小于一个目标值，则P2右移在子数组最右边添加新的数据。

<a href="./src/main/day7/array/SumMoreThan.java">面试题8：和大于等于k的最短子数组</a>

### 累加数组数字求子数组之和