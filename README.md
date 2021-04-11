#demo 通用mapper+gateway+securit+seata+dubbo RPC

#开启二级缓存

springboot配置
mybatis.configuration.cache-enabled=true
只用接口时，只需要加一个缓存的注解


@CacheNamespace
public interface AdminUserTMapper extends MySqlBaseMapper<AdminUserT> 
 
 
 实体类需要实现序列化接口 
 public class AdminUserT implements Serializable 


由于 MyBatis 目前处理 XML 和 接口中的引用时存在 BUG，所以只有这里提供的一种方式进行配置。也就是在 XML 中配置 <cache/>，在接口中使用 @CacheNamespaceRef(AdminUserTMapper.class) 引用注解。



在 XML 中定义缓存：

<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.demo.user.mapper.AdminUserTMapper">
    <cache/>
    <select id="selectById" resultType="com.demo.user.entity.AdminUserT">
        select * from admin_user_t where id = #{id}
    </select>
</mapper>



在接口中配置注解引用：

@CacheNamespaceRef(AdminUserTMapper.class)
//或者 @CacheNamespaceRef(name = "com.demo.user.mapper.AdminUserTMapper")
public interface AdminUserTMapper extends MySqlBaseMapper<AdminUserT>  {
 
    /**
     * 定义在 XML 中的方法
     *
     * @param id
     * @return
     */
    AdminUserT selectById(String id);
}


@CacheNamespaceRef 指定的是缓存的 namespace，就是 XML 中 <mapper> 中的 namespace 属性。

#幂等性
 
 <dependency>
             <groupId>com.google.guava</groupId>
             <artifactId>guava</artifactId>
             <version>24.0-jre</version>
   </dependency>
   
    //NoRepeatSubmit自定义注解类
   
   import java.lang.annotation.ElementType;
   import java.lang.annotation.Retention;
   import java.lang.annotation.RetentionPolicy;
   import java.lang.annotation.Target;
   
   /**
    * @title: NoRepeatSubmit
    * @Description:  
    */
   @Target(ElementType.METHOD)  // 作用到方法上
   @Retention(RetentionPolicy.RUNTIME) // 运行时有效
   public @interface NoRepeatSubmit {
   
   }
 
 
//新建NoRepeatSubmitAop.java
 
 import javax.servlet.http.HttpServletRequest;
 import org.apache.commons.logging.Log;
 import org.apache.commons.logging.LogFactory;
 import org.aspectj.lang.ProceedingJoinPoint;
 import org.aspectj.lang.annotation.Around;
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Pointcut;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;
 import org.springframework.web.context.request.RequestContextHolder;
 import org.springframework.web.context.request.ServletRequestAttributes;
 
 import com.google.common.cache.Cache;
 
 @Aspect
 @Component
 public class NoRepeatSubmitAop {
 
     
		@Autowired
		private Cache<String, Integer> cache;

		@Pointcut("@annotation(noRepeatSubmit)")
		public void pointCut(NoRepeatSubmit noRepeatSubmit) {
		}

		@Around("pointCut(noRepeatSubmit)")
		public Object arround(ProceedingJoinPoint pjp, NoRepeatSubmit noRepeatSubmit) {
				try {
						ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
						String sessionId = RequestContextHolder.getRequestAttributes().getSessionId();
						HttpServletRequest request = attributes.getRequest();
						String key = sessionId + "-" + request.getServletPath();
						if (cache.getIfPresent(key) == null) {// 如果缓存中有这个url视为重复提交
								Object o = pjp.proceed();
								cache.put(key, 0);
								return o;
						} else {
								log.error("重复请求，请稍后在试试。");
								return null;
						}
				} catch (Throwable e) {
						e.printStackTrace();
						log.error("验证重复提交时出现未知异常!");
						return Response.serverError_500("验证重复提交时出现未知异常");
				}
		}
 
 
//新建缓存类UrlCache.java
 
 
 import java.util.concurrent.TimeUnit;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;
 import com.google.common.cache.Cache;
 import com.google.common.cache.CacheBuilder;
 
 
 
 @Configuration
 public class UrlCache {
     @Bean
     public Cache<String, Integer> getCache() {
         return CacheBuilder.newBuilder().expireAfterWrite(2L, TimeUnit.SECONDS).build();// 缓存有效期为2秒
     }
 }
 
 
 
//controller  @NoRepeatSubmit()







