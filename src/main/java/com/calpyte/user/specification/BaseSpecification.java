package com.calpyte.user.specification;


import com.calpyte.user.dto.pagination.SearchCriteria;
import com.calpyte.user.util.DateUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import java.util.ArrayList;
import java.util.List;

public class BaseSpecification<T> {

 private T t;
    private final MongoTemplate mongoTemplate;

    public BaseSpecification(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<T> getAll(List<SearchCriteria> searchCriteriaList, Pageable pageable, Class<T> clazz) {
        List<Criteria> criteria = new ArrayList<>();
        Query query = new Query().with(pageable);
        for (SearchCriteria searchCriteria : searchCriteriaList) {
            if(searchCriteria.getOperation().matches(":")){
                if (searchCriteria.getKey() != null && !searchCriteria.getKey().isEmpty() && searchCriteria.getValue() != null && !searchCriteria.getValue().toString().isEmpty()) {
                    String value = String.valueOf(searchCriteria.getValue());
                    criteria.add(Criteria.where(searchCriteria.getKey()).regex(value, "i"));
                }
            }
        }
        if (!criteria.isEmpty()) {
            query.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return  PageableExecutionUtils.getPage(
                mongoTemplate.find(query, clazz),
                pageable,
                () -> mongoTemplate.count(query, clazz)
        );
    }



}
