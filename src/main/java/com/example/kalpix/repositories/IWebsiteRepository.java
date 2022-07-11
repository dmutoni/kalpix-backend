package com.example.kalpix.repositories;

import com.example.kalpix.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IWebsiteRepository extends JpaRepository<Website, Long> {
    Website findByWebsiteName(String websiteName);
}
