package com.example.kalpix.services.Impl;

import com.example.kalpix.models.Website;
import com.example.kalpix.repositories.IWebsiteRepository;
import com.example.kalpix.services.IWebsiteService;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;

@Service
public class WebsiteServiceImpl implements IWebsiteService {
    public final IWebsiteRepository websiteRepository;

    public WebsiteServiceImpl(IWebsiteRepository websiteRepository) {
        this.websiteRepository = websiteRepository;
    }

    @Override
    public Website saveWebsite(String domain, long startTime, long endTime, long totalELapsedTime, long totalDownloadedKiloBytes ) throws IOException {
        Website website = new Website();
        website.setWebsiteName(domain);
        website.setDownloadStartDateTime(startTime);
        website.setDownloadEndTime(endTime);
        website.setTotalElapsed(totalELapsedTime);
        website.setTotalDownloadedKiloBytes(totalDownloadedKiloBytes);

        return websiteRepository.save(website);
    }

    @Override
    public List<Website> getAllWebsites() {
        return websiteRepository.findAll();
    }

    @Override
    public Website findByWebsiteName(String websiteName) {
        return findByWebsiteName(websiteName);
    }
}
