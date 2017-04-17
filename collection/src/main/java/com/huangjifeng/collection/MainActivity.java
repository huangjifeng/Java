package com.huangjifeng.collection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        arrayList56.subList(1,4);      //获取子列表，包含头不包含尾
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
        while (listIterator.hasNext()){
            Object object = listIterator.next();
            if (object.equals("haha02")){
                listIterator.add("haha009");   //迭代过程中进行增
                listIterator.remove();
                listIterator.set("haha0102");

            }
        }

    }
}
