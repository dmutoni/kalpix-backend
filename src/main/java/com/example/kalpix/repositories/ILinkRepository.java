package com.example.kalpix.repositories;

import com.example.kalpix.dtos.LinkDto;
import com.example.kalpix.models.Link;
import com.example.kalpix.models.Website;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILinkRepository extends JpaRepository<Link, Long> {
    List<Link> findAllByWebsite(Website website);
}
