package com.calpyte.user.service;

import com.calpyte.user.dto.Pagination;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.User;
import org.springframework.data.domain.Page;

public interface UserService {

        User saveUser(User user) ;

        Page<User> getAll(Pagination pagination);

        public TableResponseDTO getUsers(PaginationDTO pagination);

}
