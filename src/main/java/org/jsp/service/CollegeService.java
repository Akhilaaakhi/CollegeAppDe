package org.jsp.service;

import java.util.Optional;

import org.jsp.dao.CollegeDao;
import org.jsp.dto.College;
import org.jsp.dto.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CollegeService {
@Autowired
	private CollegeDao dao;

public ResponseEntity<ResponseStructure<College>> saveCollege(College col)
{
	ResponseStructure<College> structure=new ResponseStructure<>();
	structure.setMessage("college is saved");
	structure.setData(dao.saveCollege(col));
	structure.setStatuscode(HttpStatus.CREATED.value());
	return new ResponseEntity<ResponseStructure<College>>(structure,HttpStatus.CREATED);
}
 public ResponseEntity<ResponseStructure<College>>findById(int id)
 {
	 ResponseStructure<College> structure=new ResponseStructure<>();
	 Optional<College> recol=dao.findById(id);
	 if(recol.isPresent())
	 {
   structure.setMessage("Found with id");
   structure.setData(recol.get());
   structure.setStatuscode(HttpStatus.OK.value());
   return new ResponseEntity<ResponseStructure<College>>(structure,HttpStatus.OK); 
 }
	return null;
}
 public ResponseEntity<ResponseStructure<Boolean>>deleteById(int id)
 {
 ResponseStructure<Boolean> structure =new ResponseStructure<>();
 Optional<College> recol=dao.findById(id);
 if(recol.isPresent())
 {
	 structure.setMessage("college is deleted");
	 structure.setData(true);
	 structure.setStatuscode(HttpStatus.NO_CONTENT.value());
	 return new ResponseEntity<ResponseStructure<Boolean>>(structure,HttpStatus.NO_CONTENT);
 }
 return null;
 }
 public ResponseEntity<ResponseStructure<College>> verifyByEmail(String email,String password)
 {
	 ResponseStructure<College> structure=new ResponseStructure<>();
	 Optional<College> recol=dao.verifyByEmail(email, password);
	 if(recol.isPresent())
	 {
		 structure.setMessage("found the college by email");
		 structure.setData(recol.get());
		 structure.setStatuscode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<College>>(structure,HttpStatus.OK);
	 }
	 return null;
 }
 public ResponseEntity<ResponseStructure<College>> verifyByPhone(long phone,String password)
 {
	 ResponseStructure<College> structure=new ResponseStructure<>();
	 Optional<College> recol=dao.verifyByPhone(phone, password);
	 if(recol.isPresent())
	 {
		 structure.setMessage("found the college by phone");
		 structure.setData(recol.get());
		 structure.setStatuscode(HttpStatus.OK.value());
		 return new ResponseEntity<ResponseStructure<College>>(structure,HttpStatus.OK);
	 }
	 return null;
 }
public ResponseEntity<ResponseStructure<College>> updateCollege(College col)
{
	ResponseStructure<College> structure=new ResponseStructure<>();
	Optional<College> recol=dao.findById(col.getCid());
	if(recol.isPresent())
	{
		  College c=recol.get();
		  c.setCid(col.getCid());
		  c.setCname(col.getCname());
		  c.setEmail(col.getEmail());
		  c.setPhone(col.getPhone());
		  c.setPassword(col.getPassword());
      structure.setMessage("college is updated");
      structure.setData(dao.saveCollege(c));
      structure.setStatuscode(HttpStatus.ACCEPTED.value());
   return new ResponseEntity<ResponseStructure<College>>(structure,HttpStatus.ACCEPTED);
}
	return null;
}
}
