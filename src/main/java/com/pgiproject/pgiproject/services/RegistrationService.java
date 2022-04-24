package com.pgiproject.pgiproject.services;

import com.pgiproject.pgiproject.Repository.RegistrationRepository;
import com.pgiproject.pgiproject.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    
    @Autowired
    private RegistrationRepository registrationRepository;

    public User saveUser(User user)
    {
     return  registrationRepository.save(user);
        
    }
    public User FetchUserbyEmailid(String emailid)
    {
       return registrationRepository.findByemailid(emailid);
        
    }
    public User FetchUserbyEmailidAndPassword(String emailid,String pwd)
    {
       return registrationRepository.findByEmailidAndPwd(emailid,pwd);
        
    }
}
