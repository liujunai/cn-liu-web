package cn.lele.thread;

/**
 * Created by liu on 16-11-19.
 */

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.BlockingQueue;

/**
 * 多实例消费线程
 */
//线程队列出
@Scope("prototype")
@Component
public class ThreadQueueOut implements Runnable {

    @Resource
    private BlockingQueue<String> blockingQueue;

    public void run() {
        for (;;){
            try {
                String queueMsg = blockingQueue.take();
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        }
    }
}
