package com.bicovski.user.service;

import com.bicovski.user.VO.Department;
import com.bicovski.user.VO.ResponseTemplateVO;
import com.bicovski.user.entity.User;
import com.bicovski.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

  //@Autowired gets error with Eureka DiscoveryClient on restTemplate
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("userservice: saveUser method");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("userservice: getUserWithDepartment method");
        restTemplate = new RestTemplate(); //TODO: discovery cloud error tmp fix
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        Department department = restTemplate.
                getForObject("http://localhost:9001/department/" + user.getDepartmentId(), Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
    }
}
