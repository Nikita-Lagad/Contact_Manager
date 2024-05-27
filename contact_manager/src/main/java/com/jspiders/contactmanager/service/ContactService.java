package com.jspiders.contactmanager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.contactmanager.pojo.Contact;
import com.jspiders.contactmanager.repository.ContactRepo;

@Service
public class ContactService {
	
	@Autowired
	private ContactRepo contactRepo;

	public Contact addContact(Contact contact) {
		return contactRepo.save(contact);
	}

	public Contact findContactById(int id) {
		Optional<Contact> optional=contactRepo.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	public List<Contact> findAllContacts() {
		List<Contact> contacts=contactRepo.findAll();
		if (contacts.size()>0) {
			return contacts;
		}else {
		return null;
		}
	}

	public Contact deleteContact(Integer id) {
		if (id!=null) {
			Contact contactToBeDeleted=findContactById(id);
			contactRepo.deleteById(id);
			return contactToBeDeleted;
		}else {
		return null;
		}
	}

	public Contact findContactByName(String name) {	
		return contactRepo.findContactByName(name);
	}

	 

}
