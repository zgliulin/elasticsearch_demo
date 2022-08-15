package com.dbl.es.service.impl;

import com.alibaba.fastjson.JSON;
import com.dbl.es.bean.User;
import com.dbl.es.service.UserService;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * descrription:
 * <p>
 * Create by DbL on 2022/8/13 10:32
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    BulkProcessor bulkProcessor;

    @Override
    public void initEsUserInfo(Integer size) {
       // Long count = 0L;
        while (size >= 0) {
            if (size > 100) {
                List<User> randomUser = User.getRandomUser(100);
                for (User user : randomUser) {
                    String userStr = JSON.toJSONString(user);
                    //count++;
                    //System.out.println("第" + count + "个："+ userStr);
                    bulkProcessor.add(new IndexRequest("user", "type1").source(userStr, XContentType.JSON));
                }
                size -= 100;
            } else {
                List<User> randomUser = User.getRandomUser(size);
                for (User user : randomUser) {
                    String userStr = JSON.toJSONString(user);
                   // count++;
                    // System.out.println("第" + count + "个："+ userStr);
                    bulkProcessor.add(new IndexRequest("user", "type1").source(userStr, XContentType.JSON));
                }
                size = -1;
            }
        }


    }
}
