package com.calpyte.user.Specification;
import com.calpyte.user.dto.pagination.SearchCriteria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.support.PageableExecutionUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongSupplier;

public class BaseSpecification<T> {


    private T t;
    private final MongoTemplate mongoTemplate;

    public BaseSpecification(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Page<T> getAll(List<SearchCriteria> searchCriteriaList, Pageable pageable, Class<T> clazz) {
        List<Criteria> criteria = new ArrayList<>();
        Query query = new Query().with(pageable);
        Query queryForCount = new Query();
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
            queryForCount.addCriteria(new Criteria().andOperator(criteria.toArray(new Criteria[criteria.size()])));
        }
        return  PageableExecutionUtils.getPage(
                mongoTemplate.find(query, clazz),
                pageable,
                () -> mongoTemplate.count(queryForCount,clazz)
        );
    }

}
