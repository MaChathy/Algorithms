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
<br>
    
    
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

使用双指针的前提：数据为正数数组<br><br>
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
<br>
<a href="./src/main/day8/array/MultipleSmaller.java">面试题9：乘积小于target的子数组</a>

### 累加数组数字求子数组之和

若数组中的数据有负数和零，双指针的思路可能并不使用。<br>
因为数组中有负数时向子数组添加数据，不一定能增加子数组之和;向子数组删除数据，不一定能减少子数组之和。<br>
假设下标为n的数组之和为S(n)，下标为i到j的子数组之和为S(j)-S(i-1)。<br>

<a href="./src/main/day8/array/SumChildArray.java">面试题10：和为target的子数组</a>
<br>
<a href="./src/main/day8/array/BinaryCharArray.java">面试题11：0和1个数相同的子数组</a>
<br>
<a href="./src/main/day9/array/ChildSumEqual.java">面试题12：左右两边子数组的和相等</a>
<br>
<a href="./src/main/day9/matrix/MatrixChildSum.java">面试题13：二维矩阵的数字之和</a>

# 

## 字符串

### 基础
&nbsp;&nbsp;&nbsp;&nbsp;字符串由任意长度的字符组成。

&nbsp;&nbsp;&nbsp;&nbsp;Java中用定义的类型<code>String</code>来表示字符串。

<table style="padding-left: 10px">
  <tr style="background: antiquewhite">
    <td colspan="2" style="text-align: center"><code style="text-align: center">String</code>类中主要方法及功能</td>
  </tr>
  <tr>
    <td>函数</td>
    <td>函数功能</td>
  </tr>
  <tr>
    <td><code>charAt</code></td>
    <td>返回指定下标的字符串</td>
  </tr>
  <tr>
    <td><code>compareTo</code></td>
    <td>按照字典顺序比较两个字符串</td>
  </tr>
  <tr>
    <td><code>equals</code></td>
    <td>判断两个字符串的长度和内容是否相同</td>
  </tr>
  <tr>
    <td><code>indexOf</code></td>
    <td>返回字符串中某个字符或子字符串首次出现的下标位置</td>
  </tr>
  <tr>
    <td><code>lastIndexOf</code></td>
    <td>返回字符串中某个字符或子字符串最后出现的下标位置</td>
  </tr>
  <tr>
    <td><code>length</code></td>
    <td>返回字符串的长度</td>
  </tr>
  <tr>
    <td><code>split</code></td>
    <td>将字符串按照指定的分隔符进行分隔</td>
  </tr>
  <tr>
    <td><code>substring</code></td>
    <td>根据下表截取字符串</td>
  </tr>
  <tr>
    <td><code>toLowerCase/toUpperCase</code></td>
    <td>将字符串中所有的大写(或小写)字母转换成小写(或大写)字母</td>
  </tr>
</table>

&nbsp;&nbsp;&nbsp;&nbsp;Java中的<code>String</code>类型所表达的字符串是无法改变的，只能对字符串进行读操作。
若对字符串进行写操作，那么修改的内容在返回值的字符串中，原来的字符串保持不变。

    public static void test(){
        String str1 = "offer";
        //str2的内容是"OFFER"
        String str2 = str1.toUpperCase();
        //此时str1的内容仍然是"offer"
        System.out.println(str1); 
        System.out.println(str1);
    }

&nbsp;&nbsp;&nbsp;&nbsp;由于每次对<code>String</code>实例进行修改将创建一个新的<code>String</code>实例，不必要的内存开销过大，
所以可以创建一个<code>StringBuilder</code>实例。


### 双指针

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;参考在数组中，用两个指针来定位一个子数组;
将字符串看成一个由字符组成的数组，也可以用两个指针来定位一个子字符串。
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;可以在移动这两个指针的同时统计两个指针之间的字符串中字符出现的次数，这样可以解决很多常见的题目。
例如在一个字符串中定位另一个字符串的变位词等。
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;由于这类题都与统计字母出现的次数相关，经常使用哈希表来储存每个元素出现的次数，
因此解决这类题目通常需要同时使用双指针和哈希表。

<a href="./src/main/day9/string/StringInclusion.java">面试题14：字符串中的变位词</a>
<br>
<a href="./src/main/day9/string/AllAnagrams.java">面试题15：字符串中所有的变位词</a>
<br>
<a href="./src/main/day9/string/MaxSubString.java">面试题16：不包含重复字符的最大子字符串</a>

# 

## 链表

### 链表基础

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在链表中每个节点包含指向下一个节点的指针，
这些指针把节点连接成链状数据结构。
<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;在创建连链表时无须事先知道链表的长度。


### 哨兵节点

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;哨兵节点是为了简化处理链表边界条件而引入的附加链表节点。
哨兵节点通常位于表的头部，它的值没有任何意义。在一个有哨兵节点的链表中，从第二个节点开始才真正保存有用的的值。
