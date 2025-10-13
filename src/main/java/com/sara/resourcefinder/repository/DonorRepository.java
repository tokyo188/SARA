package com.sara.resourcefinder.repository;

import com.sara.resourcefinder.model.Donor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonorRepository extends JpaRepository<Donor, Long> {
    List<Donor> findByDonationType(String donationType);
}
