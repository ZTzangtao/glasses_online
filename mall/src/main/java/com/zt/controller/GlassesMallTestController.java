package com.zt.controller;

import com.mongodb.client.result.UpdateResult;
import com.zt.base.Response;
import com.zt.model.ModelGlassesCommodity;
import com.zt.service.GlassesMallService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.redisson.api.RBucket;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

/**
 * @Author Tommy
 * @Date 2024/6/9 15:28
 * @Version 1.0
 */
@RestController
@Slf4j
public class GlassesMallTestController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private GlassesMallService glassesMallService;

    @Autowired
    private RedissonClient redissonClient;

    @PostMapping("testBeetlSql")
    public Response testBeetlSql () {
        return glassesMallService.testBeetlSql();
    }
    @PostMapping("testRedisson")
    public Response testRedisson () {
        RBucket<String> bucket = redissonClient.getBucket("zt");
        bucket.set("kyrie suck");
        System.out.println(bucket.get());
        System.out.println( bucket.delete());
        return Response.success(bucket.delete());
    }

    @GetMapping("mongoTest")
    public void mongoTest() throws InterruptedException {
        ModelGlassesCommodity gucciGlasses = ModelGlassesCommodity.builder()
                .name("gucci")
                .price(Money.of(CurrencyUnit.of("CNY"), 1899.00))
                .createTime(new Date())
                .updateTime(new Date()).build();
        ModelGlassesCommodity saved = mongoTemplate.save(gucciGlasses);
        log.info("gucciGlasses {}", saved);

        List<ModelGlassesCommodity> list = mongoTemplate.find(
                Query.query(Criteria.where("name").is("gucci")), ModelGlassesCommodity.class);
        log.info("Find {} gucci", list.size());
        list.forEach(c -> log.info("gucci {}", c));

        Thread.sleep(1000); // 为了看更新时间
        UpdateResult result = mongoTemplate.updateFirst(query(where("name").is("gucci")),
                new Update().set("price", Money.ofMajor(CurrencyUnit.of("CNY"), 300))
                        .currentDate("updateTime"),
                ModelGlassesCommodity.class);
        log.info("Update Result: {}", result.getModifiedCount());
        ModelGlassesCommodity updateOne = mongoTemplate.findById(saved.getId(), ModelGlassesCommodity.class);
        log.info("Update Result: {}", updateOne);

        mongoTemplate.remove(updateOne);

    }

    @GetMapping("redisTemplateTest")
    public void jedisTest() {
        redisTemplate.boundValueOps("zz").set("brandGlasses");
        String name = redisTemplate.boundValueOps("zz").get().toString();
        log.info(name);
        redisTemplate.delete("zz");
//        log.info(jedisPoolConfig.toString());
//        ModelGlassesCommodity gucciGlasses = ModelGlassesCommodity.builder()
//                .name("gucci")
//                .price(Money.of(CurrencyUnit.of("CNY"), 1899.00))
//                .createTime(new Date())
//                .updateTime(new Date()).build();
//        try (Jedis jedis = jedisPool.getResource()) {
//            jedis.hset("gucciGlasses", gucciGlasses.getName(), Long.toString(gucciGlasses.getPrice().getAmountMinorLong()));
//            Map<String, String> map = jedis.hgetAll("gucciGlasses");
//            log.info("map: {}", map);
//
//            String price = jedis.hget("gucciGlasses", "gucci");
//            log.info("gucci price - {}", Money.ofMinor(CurrencyUnit.of("CNY"), Long.parseLong(price)));
//        }
    }
}
