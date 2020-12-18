package com.niuguanqun.springbootdemomongodbmulti.config;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.niuguanqun.springbootdemomongodbmulti.MultipleMongoProperties;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import javax.annotation.Resource;

@Configuration
public class MultipleMongoConfig {

    @Resource
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = "db1MongoTemplate")
    public MongoTemplate db1MongoTemplate() throws Exception {
        return new MongoTemplate(db1Factory(this.mongoProperties.getDb1()));
    }

    @Bean
    @Qualifier("db2MongoTemplate")
    public MongoTemplate db2MongoTemplate() throws Exception {
        return new MongoTemplate(db2Factory(this.mongoProperties.getDb2()));
    }

    @Bean
    @Primary
    public MongoDbFactory db1Factory(MongoProperties mongo) throws Exception {
        MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getDb1().getUri()));
        return new SimpleMongoDbFactory(client, mongoProperties.getDb1().getDatabase());
    }

    @Bean
    public MongoDbFactory db2Factory(MongoProperties mongo) throws Exception {
        MongoClient client = new MongoClient(new MongoClientURI(mongoProperties.getDb2().getUri()));
        return new SimpleMongoDbFactory(client, mongoProperties.getDb2().getDatabase());
    }
}