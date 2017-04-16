package com.huangjifeng.string;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*
        * 基本数据类型包装类
        * byte      Byte
        * short     Short
        * int       Integer
        * long      Long
        * boolean   Boolean
        * double    Double
        * char      Character
        * 基本数据类型对应的对象包装类的最常用作用：就是用于基本数据类型和字符串数据类型之间做转换
        * 基本数据类型转成字符串：   基本数据类型 + ""
        *
        *
        *
        * */
        int sd = 23;
        Integer.toString(sd);   //通过Integer的方法将基本数据类型转换为字符串
        String age = "12";
        Integer.parseInt(age);  //将字符串强转为整数，比如年龄
        //进制转换，10进制转换为其他进制
        Integer.toBinaryString(sd);
        Integer.toHexString(sd);
        Integer.toOctalString(sd);
        Integer.parseInt("1011010",10);   //将"1011010"转换为10进制
        Integer integer = 123;     //自动装箱
        integer.intValue();        //自动拆箱




        /*
        * StringBuffer  是字符串缓冲区，是一个容器，具有存储，删除，获取，修改
        * 特点：长度可以变化的，可以直接操作多个数据类型，最终会通过toString()方法变成字符串
        * StringBuilder 和 StringBuffer 具有相同的API方法，StringBuilder具有更高的效率，将StringBuilder
        * 的实例用于多线程时不安全的，如果需要这样的同步，则建议使用StringBuffer
        * */
        StringBuffer buffer = new StringBuffer();
        buffer.append('1');   //将指定的数据作为参数添加到已有数据的结尾处
        buffer.toString();    //将StringBuffer变成String
        buffer.append("123", 1, 5);
        buffer.insert(2, "ewf");//往buffer的角标为2的位置插入ewf，可以将数据插入到指定的位置
        buffer.delete(1, buffer.length());  //删除缓冲区中的数据，包含start，不包含end，包含头不包含尾
        buffer.deleteCharAt(2);//删除指定位置的字符
        buffer.charAt(1);   //通过角标获取元素
        buffer.indexOf("1"); //获取字符串“1”的角标
        buffer.lastIndexOf("aj", 2);
        buffer.replace(2, 4, "hasdfskldjf"); //替换2开始，4结束的位置为"hasdfskldjf"
        buffer.reverse();   //字符串反转
        char[] chars = new char[6];
        buffer.getChars(2, 4, chars, 3);//该方法的意思是：将buffer中从第2位到第4位的数字存到chars数组中，并且从第3位开始存储，小心角标越界


        String s4 = "abcdef";
        int awefdfa = s4.length();        //获取长度
        char ergfdf = s4.charAt(3);       //根据位置获取位置上的某个字符
        //s4.indexOf(int ch);      返回的是ch在字符中第一次出现的位置，如果没有找到返回-1
        //s4.indexOf(int ch ,int fromIndex)   从fromIndex指定位置开始，获取ch在字符中出现的位置
        //s4.indexOf(String st);      返回的是st在字符串中第一次出现的位置
        //s4.indexOf(String st ,int fromIndex)   从fromIndex指定位置开始，获取st在字符串中出现的位置
        //s4.lastIndexOf(int ch)    反向索引一个字符出现的位置
        s4.startsWith("a");   //字符串是否是以指定的内容开头
        s4.endsWith("a");     //字符串是否是以指定的内容结尾
        TextUtils.isEmpty(s4);  //判断字符串是否为空
        s4.isEmpty();         //判断是否为空，其实就是判断长度是否为0
        s4.contains("3d");    //判断s4中是否包含“3d”
        s4.equals("addf");   //判断字符串内容是否相同，复写object类中的equals方法
        s4.equalsIgnoreCase("ADBF");  //判断内容是否相同，不区分大小写

        char[] hsdf = new char[]{'a', 'b', 'c'};
        String s5 = new String(hsdf);  //构造方法将整个字符数组转成字符串
        String s6 = new String(hsdf, 1, 4);   //构造方法将部分字符数组转成字符串,1是起始位，4是个数
        String.copyValueOf(hsdf);      //静态方法将字符数组转化为字符串
        s4.toCharArray();     //将字符串变成字符数组
        s4.getBytes();        //将字符串转换为字节数组
        s4.replace("a", "4");   //将字符串中的字符"a"全部替换成"4"
        s4.split("a");      //将字符串用a来切割
        s4.substring(3);    //获取s4字符串的一部分，从3开始
        s4.substring(2, 4);  //获取s4字符串的一部分，从2到4
        s4.toUpperCase();   //切换为大写
        s4.toLowerCase();   //切换为小写
        s4.trim();          //将字符串两端的多个空格去除
        //对两个字符串进行自然顺序的比较，如果参数字符串等于此字符串，则返回值0，如果此字符串按字典顺序
        // 小于字符串参数，则返回一个小于0的值，如果此字符串按字典顺序大于字符串参数，则返回一个大于0的值
        s4.compareTo("2d");



        /*
        * s1 是一个类类型的变量， "abc"是一个对象
        * 字符串最大的特点就是：一旦被初始化就不可以被改变
        *
        * s1 和 s2 有什么区别？
        * s1在内存中有一个对象
        * s2在内存中有两个对象
        *
        * 变量 分为基本数据类型变量和非基本数据类型变量（比如引用数据类型）
        * 在Java中有8种基本数据类型：
        * 浮点型：float(4 byte), double(8 byte)
        * 整型：byte(1 byte), short(2 byte), int(4 byte) , long(8 byte)
        * 字符型: char(2 byte)
        * 布尔型: boolean(JVM规范没有明确规定其所占的空间大小，仅规定其只能够取字面值"true"和"false")
        * 对于这8种基本数据类型的变量，变量直接存储的是“值”，因此在用关系操作符==来进行比较时，比较的就是 “值” 本身。
        * 引用类型的变量存储的并不是 “值”本身，而是于其关联的对象在内存中的地址。
        *
        * 1）对于==，如果作用于基本数据类型的变量，则直接比较其存储的 “值”是否相等；
        * 如果作用于引用类型的变量，则比较的是所指向的对象的地址
        * 2）对于equals方法，注意：equals方法不能作用于基本数据类型的变量
        * 如果没有对equals方法进行重写，则比较的是引用类型的变量所指向的对象的地址；
        * 诸如String、Date等类对equals方法进行了重写的话，比较的是所指向的对象的内容。
        *
        * */
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = "abc";

        System.out.println(s1 == s3);  //返回true，因为s1在内存中的常量池中已经存在的话，s3就不会在内存中独立开辟空间了，引用的是同一个对象

        //“关系操作符生成的是一个boolean结果，它们计算的是操作数的值之间的关系”。
        System.out.println(s1 == s2);  //返回false，因为s1和s2指向不同的对象
        //下面方法返回true，String类复写了Object类中equals()方法，该方法用于判断字符串是否相同
        //  http://www.cnblogs.com/dolphin0520/p/3592500.html
        System.out.println(s1.equals(s2));
    }
}
