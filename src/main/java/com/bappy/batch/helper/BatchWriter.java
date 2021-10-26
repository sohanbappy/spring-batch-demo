package com.bappy.batch.helper;

import com.bappy.batch.entity.User;
import com.bappy.batch.repo.UserRepo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BatchWriter implements ItemWriter<User> {

    @Autowired
    UserRepo userRepo;

    @Override
    public void write(List<? extends User> users) {
        userRepo.saveAll(users);
    }
}
