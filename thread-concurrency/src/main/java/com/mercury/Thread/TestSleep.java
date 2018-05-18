package com.mercury.Thread;

/**
 * @param :
 * @author: kenny [411316753@qq.com]
 * @Date: 2018/5/18-10:14
 * @Description:
 * @return:
 */

 /**
   * java中的sleep()和wait()的区别
   * @author Hongten
   * @date 2013-12-10
    */

// 对于sleep()方法，我们首先要知道该方法是属于Thread类中的。而wait()方法，则是属于Object类中的。
//
//     sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
//
//     在调用sleep()方法的过程中，线程不会释放对象锁。
//
//     而当调用wait()方法的时候，线程会放弃对象锁，进入等待此对象的等待锁定池，只有针对此对象调用notify()方法后本线程才进入对象锁定池准备
//
//     获取对象锁进入运行状态。
public class TestSleep {
   public static void main(String[] args) {
     new Thread(new Thread1()).start();
     try {
       Thread.sleep(5000);
     } catch (InterruptedException e) {
       e.printStackTrace();
     }
     new Thread(new Thread2()).start();
   }

  private static class Thread1 implements Runnable{

    @Override
    public void run() {
      synchronized (TestSleep.class){
        System.out.println("Enter thread1---->");
        System.out.println("thread1 is waiting--->");
        try {
          TestSleep.class.wait();    //调用wait()方法，线程会放弃对象锁，进入等待此对象的等待锁定池
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.err.println("thread1 is going on---->");
        System.err.println("threa1 is over");
      }
    }
  }

   private static class Thread2 implements Runnable{

     @Override
     public void run() {
       synchronized (TestSleep.class){
         System.out.println("Enter thread2---->");
         System.out.println("thread2 is waiting--->");
         TestSleep.class.notify();

         //只有针对此对象调用notify()方法后本线程才进入对象锁定池准备获取对象锁进入运行状态。
         //==================
         //区别
         //如果我们把代码：TestD.class.notify();给注释掉，即TestD.class调用了wait()方法，但是没有调用notify()
         //方法，则线程永远处于挂起状态。
         //sleep()方法导致了程序暂停执行指定的时间，让出cpu该其他线程，
         //但是他的监控状态依然保持者，当指定的时间到了又会自动恢复运行状态。
         //在调用sleep()方法的过程中，线程不会释放对象锁。
         try {
            Thread.sleep(5000);
         } catch (InterruptedException e) {
           e.printStackTrace();
         }
         System.err.println("thread2 is going on---->");
         System.err.println("threa2 is over");
       }
     }
   }

}
