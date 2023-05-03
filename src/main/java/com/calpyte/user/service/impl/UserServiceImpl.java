package com.calpyte.user.service.impl;


import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dto.Pagination;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.User;
import com.calpyte.user.repository.UserRepository;
import com.calpyte.user.service.UserService;
import com.calpyte.user.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private List<SearchCriteria> params = new ArrayList<>();

    private MongoTemplate mongoTemplate;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(String id){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            return Mapper.map(userOptional.get(), User.class);
        }
        return null;
    }

//    public User findById(String id) { return findById(id);}

    @Override
    public Page<User> getAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
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
    @Override
    public TableResponseDTO getUsers(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification userSpecification = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<User> userPage = userSpecification.getAll(searchCriteria,paging,User.class);
        if (userPage.hasContent()) {
            List<User> userList = userPage.getContent();
            response = new TableResponseDTO(0, (int) userPage.getTotalElements(), (int) userPage.getTotalElements(),
                    userList);
        } else {
            response = new TableResponseDTO(0, (int) userPage.getTotalElements(), (int) userPage.getTotalElements(),
                    new ArrayList<>());
        }
        return response;
    }
}
