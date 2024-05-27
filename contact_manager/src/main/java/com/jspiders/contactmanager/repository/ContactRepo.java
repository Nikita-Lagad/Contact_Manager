package com.jspiders.contactmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jspiders.contactmanager.pojo.Contact;

@Repository
public interface ContactRepo extends JpaRepository<Contact, Integer>{

	Contact findContactByName(String name);

}
