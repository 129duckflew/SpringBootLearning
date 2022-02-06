package cn.duckflew;

public class TestThread
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
//            new Thread(new ConsumeWorkQueueThread()).start();
        }
        new Thread(new RouteTopicThread("*.rabbit.*")).start();
        new Thread(new RouteTopicThread("lazy.#")).start();
    }
}
