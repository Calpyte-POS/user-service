package com.calpyte.user.dao.Impl;

import com.calpyte.user.dao.UserDAO;
import com.calpyte.user.entity.User;
import com.calpyte.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user){
        userRepository.save(user);
    }

    @Override
    public Page<User> findPagination(Pageable pageable) { return userRepository.findAll(pageable);}
}
