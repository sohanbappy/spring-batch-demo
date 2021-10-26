package com.bappy.batch.helper;

import com.bappy.batch.entity.User;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
public class BatchProcessor implements ItemProcessor<User, User> {

    @Override
    public User process(User user) {
        //process can be done upon user (if any)
        user.setCreatedAt(new Date());
        return user;
    }

}
