package com.example.springbootbase.chapter7_redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisZSetCommands;
import org.springframework.data.redis.connection.SortParameters;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.ranges.Range;
import redis.clients.jedis.Jedis;

import javax.jws.Oneway;
import java.util.*;

/**
 * @author bmr
 * @time 2020-02-25 11:27
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("stringAndHash")
    public Map<String,Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1","value1");
        //注意  这里使用的是默认的jdk的序列化器，所以redis保存时不是整数，不能运算
        redisTemplate.opsForValue().set("int_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        //使用运算
        stringRedisTemplate.opsForValue().increment("int",1);

        //获取底层jedis连接
        Jedis jedis=(Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        //减1操作，这个命令redisTemplate不支持，所以我先获取底层的连接再操作
        jedis.decr("int");
        Map<String,String> hash=new HashMap<>();
        hash.put("field1","value1");
        hash.put("field2","value2");

        //存入一个散列数据类型
        stringRedisTemplate.opsForHash().putAll("hash",hash);
        //新增一个字段
        stringRedisTemplate.opsForHash().put("hash","field3","value3");

        //绑定散列操作的key。这样可以连续对一个散列数据类型进行操作
        BoundHashOperations hashOperations=stringRedisTemplate.boundHashOps("hash");
        //删除两个字段
        hashOperations.delete("field1","field2");
        //新增一个字段
        hashOperations.put("field4","value5");

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/list")
    public Map<String,Object> testList(){
        //插入两个列表，注意它们在链表的顺序
        //链表从左到右为 v10,v8,v6,v4,v2
        stringRedisTemplate.opsForList().leftPushAll("list1","v2","v4","v6","v8","v10");
        //链表从左到右顺序为v1,v2,v3,v4,v5,v6
        stringRedisTemplate.opsForList().rightPushAll("v1","v2","v3","v4","v5","v6");

        //绑定list2链表操作
        BoundListOperations listOps=stringRedisTemplate.boundListOps("list2");

        //从右边弹出一个成员
        Object result1=listOps.rightPop();
        //获取定位元素，Redis从0开始计算，这里值为v2
        Object result2=listOps.index(1);
        //从左边插入链表
        listOps.leftPush("v0");
        //求链表的长度
        Long size=listOps.size();
        //求链表下标区间成员，整个链表下标范围为0到size-1，这里不去最后一个元素
        List elements=listOps.range(0,size-2);
        System.out.println(elements);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/set")
    public Map<String,Object> testSet(){
        //请注意：这里v1重复两次，因为集合不允许重复，所以只是插入5个成员到集合中
        stringRedisTemplate.opsForSet().add("set1","v1","v1","v2","v3","v4","v5");
        stringRedisTemplate.opsForSet().add("set2","v2","v4","v6","v8");

        //绑定set1集合操作
        BoundSetOperations setOps=stringRedisTemplate.boundSetOps("set1");
        //增加两个元素
        setOps.add("v6","v7");
        //删除两个元素
        setOps.remove("v1","v7");

        //返回所有元素
        Set set1=setOps.members();
        //求成员数
        Long size=setOps.size();
        //求交集
        Set inter=setOps.intersect("set2");
        System.out.println(inter);
        //求交集，并且用新集合inter保存
        setOps.intersectAndStore("set2","inter");
        //求差集，并且用新集合diff保存
        setOps.diffAndStore("set2","diff");

        //求并集，并且用新集合union保存
        setOps.unionAndStore("set2","union");

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/zset")
    public Map testZset(){
//        Set<ZSetOperations.TypedTuple<String>> typedTupleSet=new HashSet<>();
//        for(int i=11;i<=20;i++){
//            //分数
//            double score=i*0.1;
//            //创建一个TypedTuple对象，存入值和分数
//            ZSetOperations.TypedTuple<String> typedTuple=new DefaultTypedTuple<>("value"+i,score);
//            typedTupleSet.add(typedTuple);
//        }
//
//        //往有序集合插入元素
//        stringRedisTemplate.opsForZSet().add("zset2",typedTupleSet);


//        Set<ZSetOperations.TypedTuple<String>> typedTupleSet1=new HashSet<>();
//        ZSetOperations.TypedTuple<String> typedTuple1=new DefaultTypedTuple<>("张三",99d);
//        ZSetOperations.TypedTuple<String> typedTuple2=new DefaultTypedTuple<>("李四",100d);
//        ZSetOperations.TypedTuple<String> typedTuple3=new DefaultTypedTuple<>("王五",88d);
//        ZSetOperations.TypedTuple<String> typedTuple4=new DefaultTypedTuple<>("小花",70d);
//        ZSetOperations.TypedTuple<String> typedTuple5=new DefaultTypedTuple<>("小明",52d);
//        ZSetOperations.TypedTuple<String> typedTuple6=new DefaultTypedTuple<>("小玖",59d);
//        typedTupleSet1.add(typedTuple1);
//        typedTupleSet1.add(typedTuple2);
//        typedTupleSet1.add(typedTuple3);
//        typedTupleSet1.add(typedTuple4);
//        typedTupleSet1.add(typedTuple5);
//        typedTupleSet1.add(typedTuple6);
//
//        stringRedisTemplate.opsForZSet().add("zset3",typedTupleSet1);

        BoundZSetOperations<String,String> zsetOps=stringRedisTemplate.boundZSetOps("zset3");
        Set<ZSetOperations.TypedTuple<String>> noUpSet=zsetOps.rangeByScoreWithScores(0,60);
        for(ZSetOperations.TypedTuple<String> typedTuple:noUpSet){
            System.out.println("不及格的学生姓名："+typedTuple.getValue()+",分数："+typedTuple.getScore());
        }

        Set reverseSet=zsetOps.reverseRange(0,zsetOps.size()-1);
        System.out.println("反排序后："+reverseSet);


        //
//        //绑定zset1有序集合操作
//        BoundZSetOperations<String,String> zsetOps=stringRedisTemplate.boundZSetOps("zset1");
//        //增加一个元素
//        zsetOps.add("value10",0.26);
//        Set<String> setRange=zsetOps.range(1,6);
//        //按分数排序获取有序集合
//        Set<String> setScore=zsetOps.rangeByScore(0.2,0.6);
//        System.out.println("按分数排序获取有序集合："+setScore);
//
//        //定义值范围
//        RedisZSetCommands.Range range=new RedisZSetCommands.Range();
//        range.gt("value3");
//        range.lte("value8");
//        //按值排序，请注意这个排序是按字符串排序
//        Set<String> setLex=zsetOps.rangeByLex(range);
//
//        //删除元素
//        zsetOps.remove("value9","value2");
//
//        //求分数
//        double score=zsetOps.score("value8");
//
//        //在下标区间下，按分数排序，同时返回value和score
//        Set<ZSetOperations.TypedTuple<String>> rangeSet=zsetOps.rangeWithScores(1,6);
//        System.out.println("在下标区间下，按分数排序:"+rangeSet);
//
//        //在分数区间下，按分数排序，同时返回value和score
//        Set<ZSetOperations.TypedTuple<String>> scoreSet=zsetOps.rangeByScoreWithScores(1,6);
//        System.out.println("在分数区间下，按分数排序:"+scoreSet);
//
//        //按从大到小排序
//        Set<String> reverseSet=zsetOps.reverseRange(2,8);
//        System.out.println("按从大到小排序:"+reverseSet);

        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }


    @RequestMapping("/multi")
    public Map testMulti(){
        redisTemplate.opsForValue().set("key1","value1");

        List list= (List) redisTemplate.execute(
                new SessionCallback() {
                    @Override
                    public Object execute(RedisOperations operations) throws DataAccessException {
                        //设置要监控key1
                        operations.watch("key1");
                        //开启事务，在exec命令执行前,全部都只是进入队列
                        operations.multi();
                        operations.opsForValue().set("key2","value2");
//                    operations.opsForValue().increment("key1",1);
                        //获取key2的值  此时获取到的是null  因为redis事务时，是将命令先放入队列中
                        Object value2=operations.opsForValue().get("key2");
                        System.out.println("key2的值是:"+value2);

                        operations.opsForValue().set("key3","value3");
                        Object value3=operations.opsForValue().get("key3");
                        System.out.println("key3的值是："+value3);

                        //执行exec命令,将先判别key1是否在监控后被修改过，如果是则不执行事务，否则执行事务
                        return operations.exec();
                    }
                }
//        (RedisOperations operations)->{
//                    //设置要监控key1
//                    operations.watch("key1");
//                    //开启事务，在exec命令执行前,全部都只是进入队列
//                    operations.multi();
//                    operations.opsForValue().set("key2","value2");
////                    operations.opsForValue().increment("key1",1);
//                    //获取key2的值  此时获取到的是null  因为redis事务时，是将命令先放入队列中
//                    Object value2=operations.opsForValue().get("key2");
//                    System.out.println("key2的值是:"+value2);
//
//                    operations.opsForValue().set("key3","value3");
//                    Object value3=operations.opsForValue().get("key3");
//                    System.out.println("key3的值是："+value3);
//
//                    //执行exec命令,将先判别key1是否在监控后被修改过，如果是则不执行事务，否则执行事务
//                    return operations.exec();
//                }
        );

        System.out.println(list);
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/pipeline")
    public Map testPipeline(){
        Long start=System.currentTimeMillis();
//        List list=(List)redisTemplate.executePipelined(
//                new SessionCallback<Object>() {
//                    @Override
//                    public <K, V> Object execute(RedisOperations<K, V> operations) throws DataAccessException {
//                        for(int i=1;i<=100000;i++){
//                            operations.opsForValue().set("pipeline_"+i,"value_"+i);
//                            String value=(String)operations.opsForValue().get("pipeline_"+i);
//                            if(i==100000){
//                                System.out.println("第十万条数据，value值为null，因为命令都在队列中，还没执行："+value);
//                            }
//                        }
//                        return null;
//                    }
//                }
//
//        );
        Long end=System.currentTimeMillis();
        System.out.println("耗时："+(end-start)+"毫秒");
        Map<String,Object> map=new HashMap<>();
        map.put("success",true);
        return map;
    }

    @RequestMapping("/lua")
    public Map testLua(){
        DefaultRedisScript<String> rs=new DefaultRedisScript<>();
        //设置脚本
        rs.setScriptText("return 'Hello Redis'");
        //定义返回类型，注意：如果没有定义这个定义，Spring不会返回结果
        rs.setResultType(String.class);
        RedisSerializer<String> stringRedisSerializer=redisTemplate.getStringSerializer();

        //执行Lua脚本
        String str= (String) redisTemplate.execute(rs,stringRedisSerializer,stringRedisSerializer,null);
        Map map=new HashMap();
        map.put("str",str);
        return map;
    }
}
