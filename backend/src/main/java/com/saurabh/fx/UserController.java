package com.saurabh.fx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enroll")
public class UserController {
    
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public void enroll(@RequestBody Model model) {
		
		if(model.getAge() < 18 || model.getAge() > 65) {
			throw new IllegalArgumentException("Age must be between 18 and 65 to enroll.");
		}
		
		if(userRepository.existsByEmail(model.getEmail())) {
			 throw new IllegalArgumentException("User with this email is already registered.");
		}	
		
		CompletePayment(model);
		userRepository.save(model);
		
	}
	
	private void CompletePayment(Model model) {
		model.setTotalFee(model.isPaymentDone() ? 500 : 0);
	}
}
