package com.example.demo.service; 

import com.example.demo.model.User;
import com.example.demo.model.UserPhonesVO;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.UserPhonesMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service; 

import java.util.List; 

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {    
    private final UserMapper userMapper;    
    private final UserPhonesMapper userPhonesMapper;
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class); 
    
    // @Autowired    
    // public UserServiceImpl(UserMapper userMapper, UserPhonesMapper userPhonesMapper) {        
    //     this.userMapper = userMapper;    
    //     this.userPhonesMapper = userPhonesMapper;
    // }     
    
    @Override    
    public List<User> getAllUsers() {        
        List<User> users = userMapper.getAllUsers();       
        return users;    
    }
    
    @Override    
    public User getUserById(Long id) {        
        User user = userMapper.getUserById(id);        
        logger.info("Retrieved user: {}", user); // 로그 출력        
        return user;    
    }

    @Override
    public List<UserPhonesVO> getAllUsersPhones() {
        List<UserPhonesVO> usersPhones = userPhonesMapper.getAllUsersPhones();
        return usersPhones;
    }
}
