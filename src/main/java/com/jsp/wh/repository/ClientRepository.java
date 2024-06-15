package com.jsp.wh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.wh.entity.Client;

public  interface ClientRepository extends JpaRepository<Client, Integer> {

}
