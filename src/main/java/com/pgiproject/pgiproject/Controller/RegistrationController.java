package com.pgiproject.pgiproject.Controller;

import com.pgiproject.pgiproject.model.User;
import com.pgiproject.pgiproject.services.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService registrationservice;

    @PostMapping("/registeruser")
    public User registerUser(@RequestBody User user) throws Exception

    {
        String tempEmailid = user.getEmailid();
        if (tempEmailid != null && !"".equals(tempEmailid)) {
            User userobj = registrationservice.FetchUserbyEmailid(tempEmailid);
            if (userobj != null) {
              //  throw new Exception("user with" + tempEmailid + "already exists");
              throw new Exception("user with" + tempEmailid + "already exists");
            }
        }
        User userObj = null;
        userObj = registrationservice.saveUser(user);
        return userObj;

    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception
    {
        String tempEmailid=user.getEmailid();
        String tempePwd=user.getPwd();
        User userObj = null;
        if(tempEmailid!=null && tempePwd !=null)
        {
            userObj=   registrationservice.FetchUserbyEmailidAndPassword(tempEmailid, tempePwd);
        }
        if(userObj==null)
        {
            throw new Exception("Bad credentials");
        }
        return userObj;

    }
}
