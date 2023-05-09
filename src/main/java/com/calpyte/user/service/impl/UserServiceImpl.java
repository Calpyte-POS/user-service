package com.calpyte.user.service.impl;


import com.calpyte.user.Specification.BaseSpecification;
import com.calpyte.user.dto.Pagination;
import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.User;
import com.calpyte.user.entity.Warehouse;
import com.calpyte.user.repository.UserRepository;
import com.calpyte.user.service.UserService;
import com.calpyte.user.util.Mapper;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    private List<SearchCriteria> params = new ArrayList<>();

    private final MongoTemplate mongoTemplate;

    public UserServiceImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }



    @Override
    public User saveUser(User user) {
        SimpleMailMessage message  = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("User");
        StringBuilder sb = new StringBuilder();
        sb.append("name" + user.getUserName());
        sb.append("firstName" + user.getFirstName());
        message.setText(sb.toString());
        javaMailSender.send(message);
        return userRepository.save(user);
    }

    @Override
    public Page<User> getAll(Pagination pagination) {
        Pageable pageable = PageRequest.of(pagination.getPage(), pagination.getSize());
        return userRepository.findAll(pageable);
    }


    @Override
    public TableResponseDTO getUsers(PaginationDTO pagination) {
        TableResponseDTO response;
        BaseSpecification userSpecificaion = new BaseSpecification(mongoTemplate);
        Pageable paging = PageRequest.of(pagination.getPageNo() - 1, pagination.getPageSize());
        List<SearchCriteria> searchCriteria = pagination.getFilter();
        Page<User> userPage = userSpecificaion.getAll(searchCriteria,paging,User.class);
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
