
	package org.jsp.dao;


import java.util.Optional;

import org.jsp.dto.College;
import org.jsp.repository.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CollegeDao {
@Autowired
	private CollegeRepository repo;

public College saveCollege( College col)
{
	return repo.save(col);
}
public Optional<College> findById(int id)
{
	return repo.findById(id);
}
public Optional<College>verifyByEmail(String email,String password)
{
	Optional<College> col=repo.verifyByEmail(email, password);
	if(col.isPresent()) {
		col.get();
		return col;
	}
	return null;
}

public Optional<College>verifyByPhone(long phone,String password)
{
	Optional<College> col=repo.verifyByPhone(phone, password);
	if(col.isPresent()) {
		col.get();
		return col;
	}
	return null;
}

public Boolean deleteById(int id)
{
	Optional<College> col=repo.findById(id);
	if(col.isPresent())
	{
		repo.deleteById(id);
		return true;
	}
	return null;
	
		
}

}
