package test.java.lang;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Stack;
import java.util.concurrent.TimeUnit;

public class BreadTest {

  private final Stack<Bread> mPlate = new Stack<Bread>();

  @Before
  public void setUp() throws Exception {

  }

  @After
  public void tearDown() throws Exception {
    mPlate.clear();
  }


  /**
   * 一位厨师给一位客人做面包吃的故事
   * 客人到店点面包，叫厨师开始做面包
   * 厨师开始做面包，客人在餐桌边玩手机等待
   * 厨师做好了面包，把面包放到餐盘里，提醒客人可以吃面包了，自己去看书
   * 客人从餐盘取面包，开始吃面包
   * 吃完后觉得面包太好吃了，于是再点了一个面包，叫厨师继续做面包
   * ...
   * 一直循环
   */
  @Test
  public void testEatBread_OneGuestOneCook() {

    Thread guest = new Thread(new Guest(), "Guest");
    Thread cook = new Thread(new Cook(), "Cook");

    guest.start();
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    cook.start();

    try {
      guest.join();
      cook.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }


  class Cook implements Runnable {

    @Override
    public void run() {
      synchronized (mPlate) {

        while (true) {
          System.out.println("Cook:好的，我马上开始做面包，请稍等");
          System.out.println("Cook:到厨房开始做面包...");

          try {
            TimeUnit.MILLISECONDS.sleep(600);
            //产品已经生产出来
            mPlate.push(new Bread());
            mPlate.notify();//通知消费者
            System.out.println("Cook:你好，面包已经做好啦！请慢用！");
//            TimeUnit.MILLISECONDS.sleep(1000);

            //          System.out.println("Cook:请慢用！");
            mPlate.wait();

          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }

      }
    }
  }

  class Guest implements Runnable {

    @Override
    public void run() {
      synchronized (mPlate) {
        System.out.println("Guest:你好！请给我来一个面包");
        while (true) {

          while (mPlate.empty()) {
            try {
              System.out.println("Guest:面包还没有做好，那我先玩一会手机吧（wait...）");
              mPlate.wait();
              System.out.println("Guest:好像厨师叫我可以吃面包了(notified from waiting)");
            } catch (InterruptedException e) {
              e.printStackTrace();
            }

          }

//          System.out.println("Guest:面包做好了吗？" + !mPlate.empty());
          System.out.println("Guest:盘子里现在有" + mPlate.size() + "个面包");
          System.out.println("Guest:好吧，开吃！！！！");
          mPlate.pop();
          try {
            TimeUnit.MILLISECONDS.sleep(200);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
//          System.out.println("Guest:面包吃完，真好吃啊！");
          System.out.println("Guest:盘子里现在有" + mPlate.size() + "个面包");
          System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
          System.out.println("Guest:你好！请给我来一个面包");
          System.out.println("Guest:面包还没有做好，那我先玩一会手机吧（wait...）");
          mPlate.notify();
          try {
            mPlate.wait();
          } catch (InterruptedException e) {
            e.printStackTrace();
          }

        }

      }
    }
  }

  private class Bread {
  }


}