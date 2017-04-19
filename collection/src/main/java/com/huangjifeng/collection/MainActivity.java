package com.huangjifeng.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        http://www.cnblogs.com/summers/p/4094260.html
        * 数组和集合类同时容器，有何不同？
        *     数组虽然也可以存储对象，但长度固定，集合长度可以变化，数组中可以存储基本数据类型，集合中只能存储对象
        * 集合类的特点：集合只用于存储对象，集合长度可变，集合可以存储不同类型的对象，集合中存储的是对象的地址，而不是对象的实例
        *    |---Collection                     共性：add、remove、contains、clear、iterator
        *    |---------------List
        *    |---------------------ArrayList
        *    |---------------------LinkedList
        *    |---------------------Vector
        *    |--------------Set
        *    |---------------------HashSet
        *    |---------------------treeSet
        * */

        List list = new ArrayList();   //创建一个容器
        list.add("12r4e");             //集合中存储的都是对象的引用
        list.size();                   //获取集合长度，即个数
        list.remove("12");             //删除元素
        list.removeAll(new ArrayList<Object>());   //传入一个集合，就是删除这个集合的元素
        list.clear();                  //清空集合
        list.contains("234");          //判断是否存在
        list.isEmpty();                //是否为空

        List list001 = new ArrayList();
        list.retainAll(list001);       //取交集，list 中只会保留和list001中相同的元素


        /*
        * 迭代器： 其实就是集合的取出的元素的方式
        * */
        ArrayList iterator_list = new ArrayList();
        Iterator it = iterator_list.iterator();    //获取迭代器，用于取出集合中的元素
        while (it.hasNext()) {                      //判断是否有下一个元素
            it.next();                             //获取下一个元素
        }

        /*
        * Collection
        * |------List : 元素是有序的，元素可以重复，因为该集合体系有索引
        * |-------------ArrayList: 底层的数据结构使用的是数组结构，特点在于查询速度很快，通过角标查询，增删稍慢，元素越多越明显
        * |-------------LinkedList: 底层使用的是链表数据结构，每个元素只知道前后的元素，特点是查处稍慢，增删较快
        * |-------------Vector: 底层是数组数据结构，老版本使用的类，可以不用了
        *
        * |------Set ：元素是无序，元素不可以重复
        * |-------------
        *
        * List:
        *       特有方法，凡是可以操作角标的方法都是该体系特有的方法
        *       增：add(index,element)   addAll(index,Collection)
        *       删：remove(index)
        *       改：set(index,element)
        *       查：get(index)     subList(from,to)     listIterator()
        *
        * LinkedList : 的特有方法
        *       addFirst()
        *       addLast()
        *       getFirst()    获取元素但是不删除元素
        *       getLast()     获取元素但是不删除元素
        *       removeFirst()      获取元素，但是删除元素
        *       removeLast()       获取元素，但是删除元素
        *
        * */
        ArrayList arrayList56 = new ArrayList();
        arrayList56.add("haha01");     //添加元素
        arrayList56.add("haha02");
        arrayList56.add("haha03");
        arrayList56.add("haha04");
        arrayList56.add(2, "haha25");   //在指定的位置添加元素
        arrayList56.remove(1);         //删除指定位置的元素
        arrayList56.set(2, "hahahhahah");//修改指定位置的元素
        arrayList56.get(2);            //通过角标获取元素
        arrayList56.indexOf("haha03"); //通过indexOf获取对象的位置
        arrayList56.subList(1, 4);      //获取子列表，包含头不包含尾
        Iterator iterator1 = arrayList56.iterator();
        while (iterator1.hasNext()) {
            iterator1.next();
        }
        /*使用迭代器获取集合中的元素之后，在通过迭代器访问元素的过程中如果通过集合的增删改查方法
        操作集合，那就会出现并发不安全性，所以需要使用特有的列表迭代器ListIterator
        List集合特有的迭代器，ListIterator是Iterator的子接口，在迭代时，不可以通过集合对象的方法操作
        集合中的元素，因为会发生并发操作异常，所以在迭代时只能用迭代器的方法操作元素，可是Interator
        方法是有限的，只能对元素进行判断，取出，删除的操作
        */
        ListIterator listIterator = arrayList56.listIterator();
        while (listIterator.hasNext()) {
            Object object = listIterator.next();
            if (object.equals("haha02")) {
                listIterator.add("haha009");   //迭代过程中进行增
                listIterator.remove();
                listIterator.set("haha0102");

            }
        }

        //List集合判断元素是否相同，依据的是元素的equals方法，任何对象都可以重写Object的equals（）方
        //法重新制定比较方法，其实，remove(Object obj) 和 contains(Object obj) 内部都是使用的equals()方法进行比较



        /*
        * 泛型：
        * 好处：
        *       1、将运行时期出现问题ClassCastException，转移到了编译时期，方便于程序员解决问题，让
        *       运行时期问题减少，安全
        *       2、避免了强转转换的麻烦
        *
        *
        * */
        List<String> arrayList002 = new ArrayList<String>();
        Iterator<String> iterator002 = arrayList002.iterator();
        while (iterator002.hasNext()) {
            String string002 = iterator002.next();
        }

        //比较器中也使用泛型
        abstract class MyComparator implements Comparator<String>{
            @Override
            public int compare(String o1, String o2) {
                int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));
                if (num == 0){
                    return o1.compareTo(o2);
                }
                return num;
            }
        }

        //泛型类：  这个类是对一类对象可以进行操作的，所以需要使用泛型来扩展使用范围，可以是工具类
        //当类中要操作的引用数据类型不确定的时候，可以定义泛型来扩展
        //泛型类定义的泛型，在整个类中有效，如果被方法使用，那么泛型类的对象明确要操作的具体类型后，
        // 所有的操作的类型就已经固定了
        class Utils<Student>{
            private Student student;

            public void setStudent(Student student) {
                this.student = student;
            }

            public Student getStudent() {
                return student;
            }
        }

        //泛型方法：
        //为了让不同的方法可以操作不同的类型，而且类型还不确定，那么可以将泛型定义在方法上
        //泛型类和泛型方法是可以混用的，特殊之处是：静态方法不可以访问类上定义的泛型。如果
        //静态方法操作的应用数据类型不确定，可以将泛型定义的方法上。
        //静态方法的<T>放到返回值类型的前面
        class Demo{
            public <T> void show(T t){

            }
            public <Q> void print(Q q){

            }
            public static  <H> void haha(H h){

            }
        }

        /*
        * 泛型限定
        * ？   通配符，也可以理解为占位符
        * 泛型的限定
        * ？  extends E : 可以接受E类型或者E的子类型，上线
        * ？  super E : 可以接受E类型或者E的父类型， 下线
        * */



    }
    //泛型定义在接口上，实现泛型接口的实例对象既可以使用泛型<T>，也可以在实现泛型的时候使用下面的
    //下面这两种都是可以接受的
    class InterImpl001<T> implements Inter<T>{

        @Override
        public void show(T t) {

        }
    }
    class InterImpl002 implements Inter<String>{

        @Override
        public void show(String t) {

        }
    }



}
