package com.easy.base.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class RedisUtil {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean setExpire(String key, long timeout) {
        try {
            if (timeout > 0) {
                redisTemplate.expire(key, timeout, TimeUnit.SECONDS);
                return true;
            }
            return false;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public long getExpire(String key){
        return redisTemplate.getExpire(key,TimeUnit.SECONDS);
    }

    public Object get(String key) {
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean set(String key, Object value, long timeout) {
        try {
            redisTemplate.opsForValue().set(key, value, timeout);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    public void del(String ... key){
        if(key != null && key.length > 0) {
            if(key.length==1) {
                redisTemplate.delete(key[0]);
            } else {
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    public boolean hashPut(String key, String hashKey, Object value) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean hashPut(String key, String hashKey, Object value, long timeout) {
        try {
            redisTemplate.opsForHash().put(key, hashKey, value);
            setExpire(key, timeout);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean hashPutAll(String key, Map<String, Object> map) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public boolean hashPutAll(String key, Map<String, Object> map, long timeout) {
        try {
            redisTemplate.opsForHash().putAll(key, map);
            setExpire(key, timeout);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public Object hashGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    public Map<Object, Object> hashGet(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    public void hashDetele(String key, Object... hashKeys) {
        redisTemplate.opsForHash().delete(key, hashKeys);
    }

    public boolean hashHasKey(String key, String hashKey) {
        return redisTemplate.opsForHash().hasKey(key, hashKey);
    }

    public long setAdd(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().add(key, values);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public long setAdd(String key, long timeout, Object... values) {
        try {
            long count = redisTemplate.opsForSet().add(key, values);
            setExpire(key, timeout);
            return count;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public Set<Object> setMembers(String key) {
        try {
            return redisTemplate.opsForSet().members(key);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    public long setRemove(String key, Object... values) {
        try {
            return redisTemplate.opsForSet().remove(key, values);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public boolean setIsMember(String key, Object o) {
        try {
            return redisTemplate.opsForSet().isMember(key, o);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public long setSize(String key) {
        try {
            return redisTemplate.opsForSet().size(key);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public boolean listSet(String key, long index, Object value) {
        try {
            redisTemplate.opsForList().set(key, index, value);
            return true;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return false;
        }
    }

    public long listRightPush(String key, Object value) {
        try {
            return redisTemplate.opsForList().rightPush(key, value);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public long listRightPush(String key, Object value, long timeout) {
        try {
            long count = listRightPush(key, value);
            setExpire(key, timeout);
            return count;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public long listRightPushAll(String key, List<Object> values) {
        try {
            return redisTemplate.opsForList().rightPushAll(key, values);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public long listRightPushAll(String key, List<Object> values, long timeout) {
        try {
            long count = listRightPushAll(key, values);
            setExpire(key, timeout);
            return count;
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }

    public List<Object> listRange(String key, long start, long end) {
        try {
            return redisTemplate.opsForList().range(key, start, end);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    public Object listIndex(String key, long index) {
        try {
            return redisTemplate.opsForList().index(key, index);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return null;
        }
    }

    

    public long listRemove(String key, long count, Object value) {
        try {
            return redisTemplate.opsForList().remove(key, count, value);
        } catch (Exception e) {
            logger.info(e.getMessage());
            return 0;
        }
    }
}