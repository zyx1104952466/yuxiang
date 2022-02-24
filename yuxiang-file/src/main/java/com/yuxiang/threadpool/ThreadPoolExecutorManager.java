package com.yuxiang.threadpool;

import com.yuxiang.entity.DownCenter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: ThreadPoolExecutorManager 
 * @Description: 统线程池管理类
 * @Author： zhangyux
 * @Date 2022年02月24日 下午14:03:34
 */
public class ThreadPoolExecutorManager {

	public static final Logger logger = LoggerFactory.getLogger(ThreadPoolExecutorManager.class);

	/**
	 * 线程池id
	 */
	private static final long THREAD_POOL_ID = System.currentTimeMillis();
	/**
	 * 默认线程池大小
	 */
	private static int POOL_SIZE = 20;
	/**
	 * 处理上传线程池,保证20个回执线程同时运行，其它的线程进入等待队列
	 */
    private static ThreadPoolExecutor downloadPool = new ThreadPoolExecutor(POOL_SIZE,100,1,
            TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(200),  
            new ThreadPoolExecutor.CallerRunsPolicy()); 
    
    
    public static void download(DownCenter downCenter){
    	downloadPool.execute(new HandleThread(downCenter));
    }
    
    public static void close(){
        if((downloadPool != null && !downloadPool.isShutdown())){
        	downloadPool.shutdown();
            logger.info("执行线程池回收成功.");
        }
	}
    
    /**
     * 当前线程活跃线程数
     * @return
     */
    public static int getActiveCount() {
    	return downloadPool.getActiveCount();
    }
    
    /**
     * 获取当线程池空余线程数
     * @return
     */
    public static int getIdleNum() {
    	int idle = POOL_SIZE - getActiveCount();
    	return idle > 0 ? idle : 0;
    }
    
    /**
     * 线程池id
     * @return
     */
    public static long getThreadPoolId() {
    	return THREAD_POOL_ID;
    }
}


