package com.Synergastic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Synergastic.Service.UserService;
import com.Synergastic.model.User;

@Controller
public class homeController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("pageTitle", "Synergistic - Consultancy | IT Services | Digital Transformation | Personal Growth");
        return "index";
    }

    @PostMapping("/submit")
    public ResponseEntity<MessageResponse> saveUser(@ModelAttribute User user) {
        try {
            userService.saveUser(user);
            String message = "Form submitted successfully, " + user.getFname() + "!";
            return ResponseEntity.ok(new MessageResponse(message));
        } catch (Exception e) {
            // Log the error (uncomment the logger if you have one)
            // logger.error("Error saving user", e);
            String errorMessage = "Error occurred while saving user.";
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body(new MessageResponse(errorMessage));
        }
    }

    public static class MessageResponse {
        private String message;

        public MessageResponse(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    
    
    @GetMapping("/team")
    public String teamPage() {
    	return "team";
    }
}
