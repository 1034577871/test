package com.ruoyi.framework.config;

import java.io.Serializable;
import java.time.Duration;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * redis配置
 * 
 * @author ruoyi
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

	@Value("${spring.redis.host}")
	private String hostname;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis0")
	public RedisTemplate<String, Serializable> redis0() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(0);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis1")
	public RedisTemplate<String, Serializable> redis1() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(1);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis2")
	public RedisTemplate<String, Serializable> redis2() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(2);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis3")
	public RedisTemplate<String, Serializable> redis3() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(3);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis4")
	public RedisTemplate<String, Serializable> redis4() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(4);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis5")
	public RedisTemplate<String, Serializable> redis5() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(5);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis6")
	public RedisTemplate<String, Serializable> redis6() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(6);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis7")
	public RedisTemplate<String, Serializable> redis7() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(7);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis8")
	public RedisTemplate<String, Serializable> redis8() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(8);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis9")
	public RedisTemplate<String, Serializable> redis9() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(9);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis10")
	public RedisTemplate<String, Serializable> redis10() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(10);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis11")
	public RedisTemplate<String, Serializable> redis11() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(11);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis12")
	public RedisTemplate<String, Serializable> redis12() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(12);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis13")
	public RedisTemplate<String, Serializable> redis13() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(13);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis14")
	public RedisTemplate<String, Serializable> redis14() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(14);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Bean(name = "redis15")
	public RedisTemplate<String, Serializable> redis15() {
		RedisTemplate<String, Serializable> template = new RedisTemplate<>();
		Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
		ObjectMapper om = new ObjectMapper();
		om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
		om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
		jackson2JsonRedisSerializer.setObjectMapper(om);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new GenericJackson2JsonRedisSerializer());
		/** 事务支持 **/
		template.setEnableTransactionSupport(true);
		LettuceConnectionFactory factory = createLettuceConnectionFactoryNew(15);
		template.setConnectionFactory(factory);
		/** hash的key也采用String的序列化方式 **/
		template.setHashKeySerializer(new StringRedisSerializer());
		/** hash的value序列化方式采用JACKSON **/
		template.setHashValueSerializer(jackson2JsonRedisSerializer);
		template.afterPropertiesSet();
		return template;
	}

	@SuppressWarnings("rawtypes")
	private GenericObjectPoolConfig getRedisConfig() {
		GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
		genericObjectPoolConfig.setMaxIdle(40);
		genericObjectPoolConfig.setMaxTotal(100);
		genericObjectPoolConfig.setMinIdle(0);
		genericObjectPoolConfig.setMaxWaitMillis(3000);
		genericObjectPoolConfig.setMinEvictableIdleTimeMillis(3000);
		genericObjectPoolConfig.setTimeBetweenEvictionRunsMillis(3000);
		genericObjectPoolConfig.setTestOnCreate(true);
		genericObjectPoolConfig.setTestOnBorrow(true);
		genericObjectPoolConfig.setTestOnReturn(true);
		genericObjectPoolConfig.setBlockWhenExhausted(true);
		genericObjectPoolConfig.setTestWhileIdle(true);
		return genericObjectPoolConfig;
	}

	public LettuceConnectionFactory createLettuceConnectionFactoryNew(int database) {
		RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration(hostname, this.port);
		redisConfig.setDatabase(database);
		redisConfig.setPassword(RedisPassword.of(this.password));
		LettucePoolingClientConfiguration clientBuilder = LettucePoolingClientConfiguration.builder()
				.poolConfig(getRedisConfig()).build();
		LettuceConnectionFactory returnFactory = new LettuceConnectionFactory(redisConfig, clientBuilder);
		returnFactory.afterPropertiesSet();
		return returnFactory;
	}

	@Bean
	public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		// 初始化一个RedisCacheWriter
		RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisConnectionFactory);
		// 设置CacheManager的值序列化方式为json序列化
		RedisSerializer<Object> jsonSerializer = new GenericJackson2JsonRedisSerializer();
		RedisSerializationContext.SerializationPair<Object> pair = RedisSerializationContext.SerializationPair
				.fromSerializer(jsonSerializer);
		RedisCacheConfiguration defaultCacheConfig = RedisCacheConfiguration.defaultCacheConfig()
				.serializeValuesWith(pair);
		// 设置默认超过期时间是30秒
		defaultCacheConfig.entryTtl(Duration.ofSeconds(30));
		// 初始化RedisCacheManager
		return new RedisCacheManager(redisCacheWriter, defaultCacheConfig);
	}
}
