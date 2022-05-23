
package com.katarilab.java8aircraft;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {    


    @Bean 
    @ConditionalOnMissingBean(RedisConnectionFactory.class)
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory  = new JedisConnectionFactory();        
        jedisConFactory.setHostName("localhost");       
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(200);
		//jedisPoolConfig.setMaxIdle(0);
		//jedisPoolConfig.setMinIdle(0);
        jedisConFactory.setPoolConfig(jedisPoolConfig);
        jedisConFactory.setUsePool(true);        
        jedisConFactory.setPort(6379);
        return jedisConFactory;        
    }
    

    // @Bean 
    // @ConditionalOnMissingBean(RedisConnectionFactory.class)    
    // LettuceConnectionFactory lettuceConnectionFactory(){
    //     LettuceConnectionFactory lettuce = new LettuceConnectionFactory();
    //     lettuce.setHostName("localhost");
    //     lettuce.setShareNativeConnection(true);
    //     lettuce.setPort(6379);
    //     return lettuce;
    // }

    // @Bean
    // public RedisTemplate<String, Object> redisTemplate() {
    //     System.out.println("*****************obtain template*******************");
    //     RedisTemplate<String, Object> template = new RedisTemplate<>();
    //     template.setConnectionFactory(jedisConnectionFactory());
    //     return template;
    // }
}
