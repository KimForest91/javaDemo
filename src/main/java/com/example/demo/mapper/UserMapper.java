package com.example.demo.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.User; 

@Mapper
public interface UserMapper {    
    // 모든 사용자 조회    
    List<User> getAllUsers();     
    
    // ID로 사용자 조회    
    User getUserById(Long id);     
    
    // 사용자 삽입    
    void insertUser(User user);     
    
    // 사용자 업데이트    
    void updateUser(User user);     
    
    // 사용자 삭제    
    void deleteUser(Long id);
}