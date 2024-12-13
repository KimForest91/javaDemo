package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.example.demo.model.UserPhonesVO;
import java.util.List;

@Mapper
public interface UserPhonesMapper {
    List<UserPhonesVO> getAllUsersPhones();

    void updatePhoneNumber(UserPhonesVO userPhonesVO);
}
