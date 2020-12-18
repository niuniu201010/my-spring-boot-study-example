package com.niuguanqun.springbootdemomongodbmulti.repository.db2;


import com.niuguanqun.springbootdemomongodbmulti.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDB2Repository  extends MongoRepository<User, String> {
}
