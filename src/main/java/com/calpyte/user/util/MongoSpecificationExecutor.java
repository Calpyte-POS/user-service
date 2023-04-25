package com.calpyte.user.util;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.lang.Nullable;

import java.util.List;

public interface MongoSpecificationExecutor<T> {

    Page<T> findAll(@Nullable Specification<T> spec , Pageable pageable);
}
