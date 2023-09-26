package RedisExamples;

import redis.clients.jedis.Jedis;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FirstExample {
    public String setBasicKeyValue(String key, String value) {
        try (Jedis redisConnection = new Jedis("localhost", 6379)) {
            // Write key value to redis
            redisConnection.set(key, value);
            // Read the value of key and return
            return redisConnection.get(key);
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String setValuesAsList(String key, ArrayList<String> valueList) {
        try (Jedis redisConnection = new Jedis("localhost", 6379)) {
            //Send all value of valueList to redis list
            for (String value : valueList) {
                redisConnection.lpush(key, value);
            }
            return redisConnection.lrange(key, 0, -1).toString();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public Map<String, String> setHashValues(String key, Map<String, String> fieldValuePairs) {

        try (Jedis redisConnection = new Jedis("localhost", 6379)) {
            for (Map.Entry<String, String> entry : fieldValuePairs.entrySet()) {
                redisConnection.hset(key, entry.getKey(), entry.getValue());
            }
            return redisConnection.hgetAll(key);

        } catch (Exception ex) {
            System.err.println("Error caught: " + ex.getMessage());
        }

        return null;
    }

    public String setSortedSetValue(String listName,Integer score, String username){
        try(Jedis redisConnection = new Jedis("localhost",6379)){
            redisConnection.zadd(listName,score,username);
        }
        return null;
    }

    public String getSortedSetValues(String listName){
        try(Jedis redisConnection = new Jedis("localhost",6379)){
            StringBuilder stringBuilder = new StringBuilder();
            Set<String> setString = redisConnection.zrange(listName,0,-1);
            for (String item:setString) {
                stringBuilder.append(item);
            }
            return stringBuilder.toString();
        }
        catch (Exception ex){
            System.err.println("Error Caught: " + ex.getMessage());
        }
        return null;
    }

}