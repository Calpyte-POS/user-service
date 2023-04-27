package com.calpyte.user.dao;


import com.calpyte.user.entity.Capabilities;

import java.util.List;
import java.util.Optional;

public interface CapabilitiesDAO {
    Optional<Capabilities> findByName(String name);

    Capabilities save(Capabilities capabilities);

    List<Capabilities> getAllCapabilities();
}
