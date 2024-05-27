package com.jspiders.contactmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.contactmanager.pojo.Contact;
import com.jspiders.contactmanager.response.ResponseStructure;
import com.jspiders.contactmanager.service.ContactService;

@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService;

	@PostMapping("/contacts")
	protected ResponseEntity<ResponseStructure<Contact>> addContact(@RequestBody Contact contact){
		Contact addedContact=contactService.addContact(contact);
		ResponseStructure<Contact> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Contact Added");
		responseStructure.setData(addedContact);
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.OK);	
	}
	
	@GetMapping("/contact{id}")
	protected ResponseEntity<ResponseStructure<Contact>> findContactById(@PathVariable int id){
		Contact contact=contactService.findContactById(id);
		ResponseStructure<Contact> responseStructure=new ResponseStructure<>();
		if (contact!=null) {
			responseStructure.setMessage("Contact Found");
			responseStructure.setData(contact);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.FOUND);	
		}else {
			responseStructure.setMessage("Contact not found");
			responseStructure.setData(contact);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/contacts")
	protected ResponseEntity<ResponseStructure<List<Contact>>> findAllContacts(){
		List<Contact> contacts=contactService.findAllContacts();
		ResponseStructure<List<Contact>> responseStructure=new ResponseStructure<>();
		if (contacts!=null) {
			responseStructure.setMessage("Contacts Found");
			responseStructure.setData(contacts);
			responseStructure.setStatus(HttpStatus.FOUND.value());;
			return new ResponseEntity<ResponseStructure<List<Contact>>>(responseStructure,HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Cars not found");
			responseStructure.setData(contacts);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<List<Contact>>>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping("/contact")
	protected ResponseEntity<ResponseStructure<Contact>> updateContact(@RequestBody Contact contact){
		Contact updatedContact=contactService.addContact(contact);
		ResponseStructure<Contact> responseStructure=new ResponseStructure<>();
		responseStructure.setMessage("Contact Updated");
		responseStructure.setData(updatedContact);
		responseStructure.setStatus(HttpStatus.OK.value());
		return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.OK);
	}
	
	@DeleteMapping("/contact")
	protected ResponseEntity<ResponseStructure<Contact>> deleteContact(@RequestParam(name="id") Integer id){
		Contact deletedContact=contactService.deleteContact(id);
		ResponseStructure<Contact> responseStructure=new ResponseStructure<>();
		if (deletedContact!=null) {
			responseStructure.setMessage("Contact deleted");
			responseStructure.setData(deletedContact);
			responseStructure.setStatus(HttpStatus.OK.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.OK);
		}else {
			responseStructure.setMessage("Contact not deleted");
			responseStructure.setData(deletedContact);
			responseStructure.setStatus(HttpStatus.BAD_REQUEST.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/contact")
	protected ResponseEntity<ResponseStructure<Contact>> findContactByName(@RequestParam(name="name") String name){
		Contact contact=contactService.findContactByName(name);
		ResponseStructure<Contact> responseStructure=new ResponseStructure<>();
		if (contact!=null) {
			responseStructure.setMessage("Contact Found");
			responseStructure.setData(contact);
			responseStructure.setStatus(HttpStatus.FOUND.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.FOUND);
		}else {
			responseStructure.setMessage("Contact not found");
			responseStructure.setData(contact);
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<ResponseStructure<Contact>>(responseStructure,HttpStatus.NOT_FOUND);
		}
	}
}
