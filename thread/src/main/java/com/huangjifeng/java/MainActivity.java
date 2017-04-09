package com.huangjifeng.java;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.util.Log;

import java.util.Comparator;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    /*
    *
    *
    * 只要有活线程进程就不会结束，真正创建线程是Thread对象或者其子类对象，实现runnable不能创建线程
    *
    * 线程的状态：被创建--start()-->运行--sleep()-->冻结--stop()-->消亡
    * 临时状态，阻塞 ： 具备执行资格但是没有执行权
    *
    *
    *
    * 方法：
    * 1、Thread.currentThread()：静态方法，获取当前线程对象
    * 2、getName()：获取线程名称
    * 3、设置线程名称：setName()或者构造函数
    * 4、Thread.sleep(10)：静态方法，当前线程睡眠，或者调用相关线程的sleep()方法进行睡眠
    *
    * */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyThread myThread = new MyThread("hahahahahaah");      //这样的构造方法可以给线程命名
        myThread.start();
        Log.v("haha", "111111111Thread name ==== " + myThread.getName());
        MyRunnable myRunnable = new MyRunnable();


    }

    /*
    * 多线程的通信问题
    * 线程间通信：其实就是多个线程在操作同一个资源，但是操作的动作不同
    *
    *
    *
    *
    *
    * */








    /*
    * 死锁，示例如下
    * 同步中嵌套同步，而锁却不同（例如同步代码块中有同步函数，同步函数中又有同步代码块）
    *
    *
    *
    * 死锁的例子如下
    * Thread t1 = new Thread(new TestRunnable(true));
        Thread t2 = new Thread(new TestRunnable(false));
        t1.start();
        t2.start();
    * */
    class TestRunnable implements Runnable {
        private final boolean flag;
        Object object01 = new Object();
        Object object02 = new Object();

        public TestRunnable(boolean flag) {
            this.flag = flag;
        }
        @Override
        public void run() {
            if (flag) {
                synchronized (object01) {
                    synchronized (object02) {
                    }
                }
            } else {
                synchronized (object02) {
                    synchronized (object01) {
                    }
                }
            }
        }
    }

    /*
    * 单例设计模式
    *
    * 饿汉式
    * public class Student {
        private static final Student student = new Student();
        private Student() {
        }
        public static Student getInstance() {
            return student;
        }
    }
    *
    * 懒汉式，多线程访问可能会出现student的多次创建没导致安全问题
    * public class Student {
        private static Student student = null;
        private Student() {
        }
        public static Student getInstance() {
            if (student == null) {
                student = new Student();
            }
            return student;
        }
    }
    *
    * 在多线程时使用以下代码可以优化单例模式出现的线程不安全问题
    * public class Student {
        private static Student student = null;

        private Student() {
        }
        public static Student getInstance() {
            if (student == null) {
                synchronized (Student.class) {
                    if (student == null) {
                        student = new Student();
                    }
                }
            }
            return student;
        }
    }
    *
    * 问：懒汉式和饿汉式有什么不同
    * 答：懒汉式的特点在于实例延迟加载，如果多线程访问时会出现线程的安全问题
    * 可以加同步来解决，稍微有些低效，用双重判断能减少低效，加同步的时候使用的
    * 锁是该类所属的字节码对象。
    *
    * */


    /*
    * 多线程的运行出现了安全问题。
    * 问题原因：
    *       当多条语句在操作同一个线程共享数据时，一个线程对多条语句只执行了一部分，还没有执行完
    *       另一个线程就参与进来。导致共享数据的错误
    * 解决方法：
    *       对多条操作共享数据的语句，只能让一个线程执行完，在执行过程中，其他线程不可以参与执行
    *       Java对于多线程的安全问题提供了专业的解决方式，就是同步代码块
    *       synchronized(对象)
    *       {
    *           需要被同步的代码
    *       }
    * 哪些代码需要同步？？？
    *       就看哪些代码在操作共享数据
    * 同步的前提：(如果加了锁还是出现不同步的问题就看这个前提)
    *       1、必须要有两个或者两个以上的线程
    *       2、必须是多个线程使用同一个锁
    * 必须保证同步中只有一个线程在运行
    * 好处：解决了多线程的安全问题
    * 弊端：多个线程都需要判断锁，较为消耗资源，越安全越麻烦，比较低效
    *
    * 如何找到多线程可能会出现的多线程安全问题
    * 1、明确哪些代码是多线程运行代码(一般run里面的代码都是多线程运行代码)
    * 2、明确共享数据（一般实例变量都是共享数据）
    * 3、明确多线程运行代码中哪些语句是操作共享数据的（一般是多条代码对同一个数据进行操作）
    *
    * 同步的两种表现形式：   同步代码块   和   同步函数
    * 同步函数用的是哪一个锁呢？
    *       函数需要被对象调用，那么函数都有一个所属对象引用，就是this
    *       所以同步函数使用的锁就是this
    * 如果同步函数被静态修饰后，使用的锁是什么呢？
    *       通过验证，发现不再是this，因为静态方法中不可以定义this。
    *       静态进内存时，内存中没有本类对象，但是一定有该类对应的字节码文件对象。
    *       类名.class   该对象的类型是class。
    *       synchronized (Bank.class){}      -----静态函数对应的锁是Bank.class，字节码文件
            synchronized (this){}           -----一般函数对应的锁是本实例
    *
    * */

    class Bank {
        private int num;
        Object object = new Object();


        public synchronized void add(int n) {
            synchronized (Bank.class) {
            }
            synchronized (this) {
            }

            try {
                num = num + n;
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Cus implements Runnable {
        private Bank bank = new Bank();

        @Override
        public void run() {
            for (int i = 0; i < 3; i++) {
                bank.add(100);
            }
        }
    }


    /*
    * 线程继承自Thread
    *
    * */
    class MyThread extends Thread {

        public MyThread(String name) {
            super(name);       //父类已经有这样的构造方法，子类只要调用super（）方法即可 这样的构造方法可以给线程命名
        }

        @Override
        public void run() {
            super.run();
            //获取线程的名称，一般通过  标准通用方式：Thread.currentThread().getName()
            Log.v("haha", "Thread name ==== " + Thread.currentThread().getName());
        }
    }

    /*
    * 线程实现Runnable
    * 这个类只能当做参数传给其他线程使用，不能使用start()方法启动该线程
    * MyRunnable的实例不是线程
    *
    *
    * 步骤：
    * 1、定义类实现Runnable接口
    * 2、覆盖Runnable接口中的run方法，将线程要运行的代码放在该Run方法中
    * 3、通过Thread类建立线程对象
    * 4、将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数
    * 5、调用Thread类的start方法开启线程并调用Runnable接口子类的run方法
    *
    *
    * 实现方式和继承方式有什么区别
    * 实现方式的好处：避免了单继承的局限性
    * 在定义线程时，建议使用实现方式
    *
    * */
    class MyRunnable implements Runnable {

        @Override
        public void run() {

        }
    }


}
