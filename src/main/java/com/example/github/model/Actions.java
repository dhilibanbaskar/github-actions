package com.example.github.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@Service
public class Actions {
	
	@NotBlank(message = "name field is empty")
	@Size(min = 3, max = 7, message = "name length must be between 3 to 7")
	private String name;
	
	@NotBlank
	@Size(min = 4, max = 7, message = "number length must be between 4 to 7")	
	private String number;
	
	@NotBlank(message = "address field is empty")
	@Size(min = 10, max = 20, message = "address length must be between 10 to 20")
	private String address;
}
