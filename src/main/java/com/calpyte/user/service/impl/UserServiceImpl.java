package com.calpyte.user.service.impl;


import com.calpyte.user.dto.Pagination;
import com.calpyte.user.entity.User;
import com.calpyte.user.repository.UserRepository;
import com.calpyte.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

        @Autowired
        private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);

    }

    @Override
    public Page<User> getAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize(), Sort.by(pagination.getSort()));
        return userRepository.findAll(pageable);
    }

    @Override
    public void delete(String id) {
        Optional<User> userOpt = userRepository.findById(id);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            userRepository.save(user);
        }
    }

}
