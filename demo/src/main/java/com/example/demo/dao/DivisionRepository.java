package com.example.demo.dao;

import com.example.demo.entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "divisions", path = "divisions")
public interface DivisionRepository extends JpaRepository<Division, Long> {
    // Allows looking up divisions by Country ID (e.g., /api/divisions/search/findByCountry_Id?id=1)
    java.util.List<Division> findByCountry_Id(Long id);
}