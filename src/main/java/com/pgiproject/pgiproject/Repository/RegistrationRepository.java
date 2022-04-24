package com.pgiproject.pgiproject.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.pgiproject.pgiproject.model.User;




@Repository
public interface RegistrationRepository extends JpaRepository<User,Integer> 
{
    public User findByemailid(String emailid);
    public User findByEmailidAndPwd(String emailid,String pwd);
}   




