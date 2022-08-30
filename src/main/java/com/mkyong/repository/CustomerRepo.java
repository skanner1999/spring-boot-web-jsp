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

    @Modifying
    @Query(value = "INSERT INTO eCommerceDB.customers (phone_number,first_name,last_name, password) VALUES (:phone_number, :first_name, :last_name, :password);", nativeQuery = true)
    @Transactional
    void sighUp(@Param("phone_number")String phone_number,
                @Param("first_name")String first_name,
                @Param("last_name")String last_name,
                @Param("password")String password);

    
}
