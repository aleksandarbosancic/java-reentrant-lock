/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.abosancic.java.reentrant.lock;

/**
 *
 * @author AleksandarBosancic
 */

/**
 * Java program to show, how to use ReentrantLock in Java. Reentrant lock is an
 * alternative way of locking apart from implicit locking provided by
 * synchronized keyword in Java.
 *
 * @author Javin Paul
 */
public class NoReentrantLockHowto {

    private int count = 0;

    public int getCount() {
        System.out.println(Thread.currentThread().getName() + " gets Count: " + count);
        return count++;
    }

    public static void main(String args[]) {
        
        final int loop = 6;
        final NoReentrantLockHowto counter = new NoReentrantLockHowto();

        Thread t1 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() < loop) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        Thread t2 = new Thread() {

            @Override
            public void run() {
                while (counter.getCount() < loop) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        };

        t1.start();
        t2.start();

    }
}
