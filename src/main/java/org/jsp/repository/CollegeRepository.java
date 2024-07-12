package org.jsp.repository;

import java.util.Optional;

import org.jsp.dto.College;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jakarta.persistence.Entity;

public interface CollegeRepository  extends JpaRepository<College, Integer> {
@Query("select c  from College c where c.email=?1 and c.password=?2")
Optional<College> verifyByEmail(String email,String password);

@Query("select c from College c where c.phone=?1 and c.password=?2")
Optional<College> verifyByPhone(long phone,String password);
}
