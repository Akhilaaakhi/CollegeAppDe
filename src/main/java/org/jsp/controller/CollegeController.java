package org.jsp.controller;

import java.util.Optional;

import org.jsp.dto.College;
import org.jsp.dto.ResponseStructure;
import org.jsp.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colleges")
public class CollegeController {
@Autowired
private CollegeService service;
@PostMapping("/")
public ResponseEntity<ResponseStructure<College>> saveCollege(@RequestBody College col)
{
  return service.saveCollege(col);
}
@GetMapping("/{id}")
public ResponseEntity<ResponseStructure<College>> findById(@PathVariable(name="id") int id)
{
	return service.findById(id);
}
@DeleteMapping("/{id}")
public ResponseEntity<ResponseStructure<Boolean>> deleteById(@PathVariable(name="id") int id)
{
	return service.deleteById(id);
}
@GetMapping("/verifybyemail")
public ResponseEntity<ResponseStructure<College>> verifyByEmail(@RequestParam(name="email") String email,@RequestParam(name="password") String password)
{
	return service.verifyByEmail(email, password);
}
@GetMapping("/verifybyphone")
public ResponseEntity<ResponseStructure<College>> verifyByPhone(@RequestParam(name="phone") long phone,@RequestParam(name="password") String password)
{
	return service.verifyByPhone(phone, password);
}
@PutMapping("/")
public ResponseEntity<ResponseStructure<College>> updateCollege(@RequestBody College col)
{
	return service.updateCollege(col);
}
}
