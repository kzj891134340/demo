package com.example.demo.service.serivceImpl;

import com.example.demo.bean.User;
import com.example.demo.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void save() {
            User user = new User();
            user.setAge(27);
            user.setName("程诚1");
            user.setPasswd("1234561");
            user.setSex("nv1");
            user.setNo("111111");
            user.setMa("1231");
//        Object save = mongoTemplate.save(user);
            Criteria criteria = new Criteria();
            criteria.and("_id").is("5ef59232bd77964aca4304c6");
            Query query = new Query();
            query.addCriteria(criteria);
            mongoTemplate.findAndRemove(query,User.class);
            mongoTemplate.save(user);
//        log.debug("结果 {}"+save);

    }
}
