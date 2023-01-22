package it.peppe.userservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import it.peppe.userservice.entity.User;
import it.peppe.userservice.repository.UserRepository;
import it.peppe.userservice.vo.Department;
import it.peppe.userservice.vo.ResponseTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @CircuitBreaker(name="serviceA")
    @Retry(name="serviceA")
    @RateLimiter(name="serviceA")
    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        System.out.println("Retry method");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),Department.class);

        vo.setUser(user);
        vo.setDepartment(department);

        return vo;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
