package com.calpyte.user.dao;

import com.calpyte.user.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface UserDAO {

    void save(User user);

    Optional<User> findById(String id);

    Page findPagination(Pageable pageable);
}
