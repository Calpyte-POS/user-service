package com.calpyte.user.service;


import com.calpyte.user.entity.Capabilities;

import java.util.List;

public interface CapabilitiesService {
    Capabilities saveCapabilities(Capabilities capabilities);

    List<Capabilities> getAllCapabilities();
}
