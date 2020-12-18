package com.niuguanqun.springbootdemomongodbmulti.config;

import com.niuguanqun.springbootdemomongodbmulti.MultipleMongoProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableConfigurationProperties(MultipleMongoProperties.class)
@EnableMongoRepositories(basePackages = "com.niuguanqun.springbootdemomongodbmulti.repository.db2",
        mongoTemplateRef = "db2MongoTemplate")
public class DB2MongoConfig {

}
