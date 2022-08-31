package com.mkyong.repository;

import javax.persistence.Id;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mkyong.models.customer;


@Repository
public interface CustomerRepo extends CrudRepository<customer,String>{

    @Query(value = "SELECT phone_number FROM ecommercedb.customers WHERE phone_number = :phone_number;", nativeQuery = true)
    String getUserPhone(@Param("phone_number")String phone_number);

    @Query(value = "SELECT password FROM ecommercedb.customers WHERE phone_number = :phone_number;", nativeQuery = true)
    String getUserPassword(@Param("phone_number")String phone_number);

    @Query(value = "SELECT * FROM ecommercedb.customers WHERE phone_number = :phone_number;", nativeQuery = true)
     customer getUserDetails(@Param("phone_number")String phone_number);

    @Modifying
    @Query(value = "INSERT INTO ecommercedb.customers (phone_number,first_name,last_name, password) VALUES (:phone_number, :first_name, :last_name, :password);", nativeQuery = true)
    
    @Transactional
    void signUp(@Param("phone_number")String phone_number,
                @Param("first_name")String first_name,
                @Param("last_name")String last_name,
                @Param("password")String password);
    
}




