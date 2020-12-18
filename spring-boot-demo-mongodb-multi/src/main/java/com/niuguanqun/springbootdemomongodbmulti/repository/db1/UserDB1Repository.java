package com.niuguanqun.springbootdemomongodbmulti.repository.db1;


import com.niuguanqun.springbootdemomongodbmulti.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDB1Repository extends MongoRepository<User, String> {
}
