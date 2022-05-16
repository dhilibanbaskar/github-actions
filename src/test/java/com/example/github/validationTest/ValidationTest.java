package com.example.github.validationTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.github.model.Actions;

@SpringBootTest
public class ValidationTest {

	@Test
	void testValidateName() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Actions actions = Actions.builder().name(null).number("9894").address("dark horse street").build();

		Set<ConstraintViolation<Actions>> results = validator.validate(actions);

		results.forEach(result -> {

			System.out.println(result.getMessage());
		});
		assertEquals(2, results.size());
	}

	@Test
	void testValidateNumber() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Actions actions = Actions.builder().name("Drake Scott").number("98943312").address("Dark horse street").build();

		Set<ConstraintViolation<Actions>> results = validator.validate(actions);
		results.forEach(result -> {

			System.out.println(result.getMessage());
		});
		assertEquals(2, results.size());
	}

	@Test
	void testValidateAddress() {

		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();

		Actions actions = Actions.builder().name("Drake Scott").number("98947752").address("Dark horse street 1983").build();

		Set<ConstraintViolation<Actions>> results = validator.validate(actions);
		results.forEach(result -> {

			System.out.println(result.getMessage());
		});
		assertEquals(3, results.size());
	}
}
