package com.example.kalpix.services;

import com.example.kalpix.models.Website;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public interface IWebsiteService {
    Website saveWebsite(String domain, long startTime, long endTime, long totalELapsedTime, long totalDownloadedKiloBytes) throws IOException;
    List<Website> getAllWebsites();

    Website findByWebsiteName(String websiteName);
}
