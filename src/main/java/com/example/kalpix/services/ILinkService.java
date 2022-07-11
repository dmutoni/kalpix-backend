package com.example.kalpix.services;

import com.example.kalpix.dtos.LinkDto;
import com.example.kalpix.models.Link;

import java.io.IOException;
import java.util.List;

public interface ILinkService {
    List<Link> saveLink(String webpage) throws IOException;
    List<Link> getAllLinks();
}
