package com.Synergastic.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {
    @Id
    private String id; // Use String for MongoDB IDs
    
    private String fname;
    private String service_name;
    private String budget;
    private String mail;
    private String project_details;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getService_name() {
		return service_name;
	}
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}
	public String getBudget() {
		return budget;
	}
	public void setBudget(String budget) {
		this.budget = budget;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getProject_details() {
		return project_details;
	}
	public void setProject_details(String project_details) {
		this.project_details = project_details;
	}
	public User() {
		
		// TODO Auto-generated constructor stub
	}

    // Getters and Setters
    
}
