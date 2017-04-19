package com.interview.prep.practise.Threads;
   
public class DeadLockExample{
     static class Clazz {
         public synchronized void a(Clazz clazz) {
              System.out.print("a");
               clazz.b();
            }
            public synchronized void b() {
               System.out.print("b");
           }
      }
    public static void main(String[] args) {
          final Clazz c1 = new Clazz();
            final Clazz c2 = new Clazz();
            Thread t1 = new Thread(new Runnable() {
                public void run() { c1.a(c2); }
         });
          Thread t2 = new Thread(new Runnable() {
              public void run() { c2.a(c1); }
         });
      t1.start();
      t2.start();
    }
    }

