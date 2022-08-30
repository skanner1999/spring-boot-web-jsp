package com.mkyong.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mkyong.models.Signup;

@Repository
public interface CustomerRepo extends CrudRepository<Signup, Integer>{

    @Query(value = "SELECT phone_number FROM eCommerceDB.customers WHERE phone_number = :phone_number;", nativeQuery = true)
    String getPhone(@Param("phone_number")String phone_number);

    @Query(value = "SELECT password FROM eCommerceDB.customers WHERE phone_number = :phone_number;", nativeQuery = true)
    String getPassword(@Param("phone_number")String phone_number);

    @Query(value = "SELECT * FROM eCommerceDB.customers WHERE phone_number = :phone_number;", nativeQuery = true)
    String getUser(@Param("phone_number")String phone_number);

    @Modifying
    @Query(value = "INSERT INTO eCommerceDB.customers (phone_number,first_name,last_name, password) VALUES (:phone_number, :first_name, :last_name, :password);", nativeQuery = true)
    
    @Transactional
    void signUp(@Param("phone_number")String phone_number,
                @Param("first_name")String first_name,
                @Param("last_name")String last_name,
                @Param("password")String password);
    
}




