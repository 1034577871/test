//package com.ruoyi.system.config;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.ruoyi.common.core.domain.entity.SysUser;
//import com.ruoyi.system.service.ISysUserService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Primary;
//import org.springframework.core.annotation.Order;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.util.CollectionUtils;
//
//import java.io.Serializable;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Order(1)
//@Component
//public class UserRedis implements CommandLineRunner {
//
//    @Autowired
//    private ISysUserService iSysUserService;
//
//
//    @Autowired
//    private RedisTemplate<String, Serializable> redis1;
//    @Override
//    public void run(String... args) throws Exception {
//        SysUser user = new SysUser();
//        List<SysUser> userList =iSysUserService.selectUserList(user);
////        if (CollectionUtils.isEmpty(userList)) {
////            throw new Exception("初始化用户信息失败");
////        }
////        redis1.opsForValue().set("userInfoList", (Serializable) JSONArray.toJSON(userList), 10, TimeUnit.DAYS);//, 14, TimeUnit.DAYS
//
//    }
//}
