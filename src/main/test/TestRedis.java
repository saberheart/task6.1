import com.jnshu.util.RedisUtil;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by 56929 on 2017/5/15.
 */
public class TestRedis {
    private Jedis jedis;
    @Before
    public void setup() {
        //连接redis服务器,
        jedis = new Jedis("localhost",6379);
        //权限认证
        jedis.auth("admin");
    }
    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //----------添加数据-------------
        jedis.set("name","yanheng");//向key-->name中放入了value-->yanheng
        System.out.println(jedis.get("name"));//执行结果:yanheng
        jedis.append("name","is my love");//拼接
        System.out.println(jedis.get("name"));
        jedis.del("name");//删除某个键
        System.out.println(jedis.get("name"));
        //设置多个键值对
        jedis.mset("name","yanheng","age","22","qq","569291841");
        jedis.incr("age");//进行加1操作
        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
    }
    /**
     * redis操作map
     */
    @Test
    public void  testMap(){
        Map<String,String> map = new HashMap<String, String>();
        map.put("name","yanheng");
        map.put("age","22");
        map.put("qq","569291841");
        jedis.hmset("user",map);
        //取出user中的name,执行结果:[minxr]-->注意结果是一个泛型的list
        //第一个参数是存入redis中map对象的key,后面跟的是放入map中的对象的key,后面的key可以跟多个,是可变参数
        List<String> rsmap = jedis.hmget("user","name","age","qq");
        System.out.println(rsmap);
        //删除map中的某个键值
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value
        Iterator<String> iter = jedis.hkeys("user").iterator();
        while (iter.hasNext()){
            String key = iter.next();
            System.out.println(key+":"+jedis.hmget("user",key));
        }

    }
    @Test
    public void testRedisPoll() {
        RedisUtil.getJedis().set("newname","中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
}
