# Algorithms
Algorithm practice

##整数Integer

###基础
4种整数类型:
* byte(-128 ~ 127)<br>
* short(-32768 ~ 32767)<br>
* int(-pow(2,31) ~ pow(2,31))&nbsp;&nbsp;min:0x80000000&nbsp;&nbsp;max:<code>Integer.MAX_VALUE</code><br>
* long(-pow(2,63) ~ pow(2,63))
<br>

<a href="./src/main/day6/integer/Divide.java">面试题1：整数除法<a/>

###二进制
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


----------------------------------------------------------------------------------------------------------------------

##数组Array

###双指针

###累加数组数字求子数组之和