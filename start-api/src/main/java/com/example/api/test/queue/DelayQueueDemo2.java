package com.example.api.test.queue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @program: start-DelayQueueDemo2
 * @description: 具有过期时间的缓存
 * @author: Mr.lfl
 * @create: 2019-03-26 09:21
 **/
public class DelayQueueDemo2 {
    /**
     * 这相当于用delayQueue实现redis的过期删除key
     */

}
class cache{
    ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    DelayQueue<RedisKey> queue = new DelayQueue<>();

    public void put(String k,String v,long time){
        //这里map返回前妻
        String v1 = map.put(k,v);
        RedisKey redisKey = new RedisKey(k,v,time);
        if(v1 != null){
            queue.remove(redisKey);
        }
        queue.offer(redisKey);
    }

    public cache() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        RedisKey key = queue.take();
                        if(key != null){
                            map.remove(key.getName());
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}

class RedisKey implements Delayed{
    String name;
    String value;
    long time;

    public RedisKey(String name, String value, long time) {
        this.name = name;
        this.value = value;
        this.time = TimeUnit.NANOSECONDS.convert(time, TimeUnit.SECONDS) + System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        RedisKey key = (RedisKey) o;
        if(this.time > key.getTime()){
            return 1;
        }else if(this.time < key.getTime()){
            return -1;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
