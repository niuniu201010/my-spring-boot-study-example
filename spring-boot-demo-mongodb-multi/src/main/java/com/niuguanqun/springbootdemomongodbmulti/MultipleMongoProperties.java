package com.niuguanqun.springbootdemomongodbmulti;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb")
public class MultipleMongoProperties {

    private MongoProperties db1 = new MongoProperties();
    private MongoProperties db2= new MongoProperties();


    public MongoProperties getDb1() {
        return db1;
    }

    public void setDb1(MongoProperties db1) {
        this.db1 = db1;
    }

    public MongoProperties getDb2() {
        return db2;
    }

    public void setDb2(MongoProperties db2) {
        this.db2 = db2;
    }
}