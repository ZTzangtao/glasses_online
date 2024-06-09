package com.zt.controller;

import com.mongodb.client.result.UpdateResult;
import com.zt.model.ModelGlassesCommodity;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.GetMapping;
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
public class GlassesMallController {

    @Autowired
    private MongoTemplate mongoTemplate;

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
}
