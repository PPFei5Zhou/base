package com.easy.base.service.impl.user;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.easy.base.domain.dto.user.RoleInfoDTO;
import com.easy.base.repository.mapper.RoleInfoMapper;
import com.easy.base.service.impl.BaseService;
import com.easy.base.service.user.IRoleInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleInfoService extends BaseService<RoleInfoDTO, RoleInfoMapper> implements IRoleInfoService {
    @Override
    public String roleHierarchyChain() {
        try {
            StringBuilder hierarchy = new StringBuilder();
            List<RoleInfoDTO> list = mapper.selectEntities(RoleInfoDTO.validInstance(), 1, Integer.MAX_VALUE)
                    .stream()
                    .sorted(Comparator.comparing(RoleInfoDTO::getRoleSort))
                    .collect(Collectors.toList());
            for (int i = 0; i < list.size() - 1; i++) {
                RoleInfoDTO item = list.get(i);
                RoleInfoDTO item1 = list.get(i + 1);
                hierarchy.append(item.getRoleCode())
                        .append(">")
                        .append(item1.getRoleCode())
                        .append(System.lineSeparator());
            }
            return hierarchy.toString();
        } catch (Exception e) {
            log.error("There are not role hierarchy chain, please insert data to role_info table first.");
            return "";
        }
    }
}