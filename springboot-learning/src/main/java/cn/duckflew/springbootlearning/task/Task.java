package cn.duckflew.springbootlearning.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class Task
{
    private int count = 0;
    @Scheduled(cron = "*/5 * * * * ?")
    private void process1()
    {
        SimpleDateFormat df=new SimpleDateFormat("yyyy-dd HH:mm:ss");
        System.out.println("当前时间"+df.format(new Date()));
        System.out.println("定时任务  count= "+count++);
    }
}