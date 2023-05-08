package com.calpyte.user.service;


import com.calpyte.user.dto.pagination.PaginationDTO;
import com.calpyte.user.dto.pagination.TableResponseDTO;
import com.calpyte.user.entity.Capabilities;

import java.util.List;

public interface CapabilitiesService {
    Capabilities saveCapabilities(Capabilities capabilities);

    List<Capabilities> getAllCapabilities();

    TableResponseDTO getRoles(PaginationDTO pagination);

    Capabilities findById(String id);

    void delete(String id);
}
