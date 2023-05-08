package com.calpyte.user.dao;


import com.calpyte.user.entity.Capabilities;
import com.calpyte.user.entity.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CapabilitiesDAO {
    Optional<Capabilities> findByName(String name);

    Capabilities save(Capabilities capabilities);

    List<Capabilities> getAllCapabilities();


    Optional<Capabilities> findById(String id);
}
