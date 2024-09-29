package com.albertvtr.contactwebapi.model.repos;

import com.albertvtr.contactwebapi.model.entities.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findByNumVAT(String numVAT);
}
