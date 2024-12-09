package com.example.demo.model; 

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString; 

@Getter
@Setter
@ToString
@NoArgsConstructor // 기본 생성자
@AllArgsConstructor // 모든 필드를 포함하는 생성자

public class User {    
    private Long id;    
    private String name;    
    private String email;
} 

/* lombok 사용으로 인해 주석처리
public class User {    
    private Long id;    
    private String name;    
    private String email;       
    
    public User(Long id, String name, String email) {        
        this.id = id;        
        this.name = name;        
        this.email = email;    
    }     
        
    // Getter 메서드    
    public Long getId() {        
        return id;    
    }     
    
    public String getName() {        
        return name;    
    }     
        
    public String getEmail() {        
        return email;    
    }     
        
    // Setter 메서드    
    public void setId(Long id) {        
        this.id = id;    
    }     
        
    public void setName(String name) {        
        this.name = name;    
    }     
        
    public void setEmail(String email) {
        this.email = email;
    }     
        
    @Override    
    public String toString() {        
        return "User{id=" + id + ", name='" + name + '\'' + ", email='" + email + '\'' + '}';    
    }
}
*/