package com.dhr.basic.thread.communication.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @Description :注释
 * Created by duanhr30063 on 2018/3/9.
 */

public class Test {
    private static Timer timer = new Timer();

    static public class MyTask extends TimerTask {
        public void run() {
            System.out.println("11111111 运行了！时间为： " + new Date());
            try {
                Thread.sleep(10000);//任务执行时长
            } catch (Exception e) {

            }
        }
    }

    static public class MyTask_2 extends TimerTask {
        public void run() {
            System.out.println("222222222 运行了！时间为： " + new Date());
            this.cancel();
            System.out.println("取消任务后的处理...");
        }
    }

    public static void main(String args[]) throws Exception {
        MyTask myTask = new MyTask();
        MyTask_2 myTask_2 = new MyTask_2();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = "2018-03-09 15:35:00";
        String dateStr_2 = "2018-03-09 15:35:05";
        Date date = sdf.parse(dateStr);
        Date date_2 = sdf.parse(dateStr_2);
        timer.schedule(myTask, date);
        timer.schedule(myTask_2, date_2);
        timer.schedule(myTask,7000);
        timer.schedule(myTask,7000,1000);

    }
}
