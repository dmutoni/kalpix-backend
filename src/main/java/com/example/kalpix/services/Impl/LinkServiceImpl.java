package com.example.kalpix.services.Impl;

import com.example.kalpix.models.Link;
import com.example.kalpix.models.Website;
import com.example.kalpix.repositories.ILinkRepository;
import com.example.kalpix.services.ILinkService;
import com.example.kalpix.services.IWebsiteService;

import java.io.*;
import java.net.URL;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {
    public final ILinkRepository linkRepository;

    public final IWebsiteService websiteService;

    public LinkServiceImpl(ILinkRepository linkRepository, IWebsiteService websiteService) {
        this.linkRepository = linkRepository;
        this.websiteService = websiteService;
    }

    @Override
    public List<Link> saveLink(String webpage) throws IOException {
        long startTime = System.currentTimeMillis();
        URL url = new URL(webpage);
        String host = url.getHost();
        String domain =  host.startsWith("www.") ? host.substring(4) : host;
        File homePagePath = new File(url.getPath());
        String fileName = homePagePath.getName();

        BufferedReader readr =
                new BufferedReader(new InputStreamReader(url.openStream()));
        File folderName = new File(domain);
        if (!folderName.exists()){
            folderName.mkdirs();
        }
        BufferedWriter writer;
        if (fileName.isEmpty()) {
            writer = new BufferedWriter(new FileWriter(folderName + "//index.html"));
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

        }else {
            writer = new BufferedWriter(new FileWriter(fileName));
            String line;
            while ((line = readr.readLine()) != null) {
                writer.write(line);
            }

        }
        readr.close();
        writer.close();
        long endTime = System.currentTimeMillis();
        long totalDownloadedKiloBytes = homePagePath.length() / 1024;
        long totalElapsedTime = endTime - startTime;

        Website website = websiteService.saveWebsite(domain, startTime, endTime, totalElapsedTime, totalDownloadedKiloBytes);

        Document doc = Jsoup.connect(webpage).get();

        Elements links = doc.select("a[href]");

        for (Element link : links) {
            Link newLink = new Link();
            newLink.setWebsite(website);
            newLink.setLinkName(link.attr("abs:href"));
            newLink.setTotalDownloadedKilobytes(website.getTotalDownloadedKiloBytes());
            newLink.setTotalElapsedTime(website.getTotalElapsed());
            linkRepository.save(newLink);
        }
        return linkRepository.findAllByWebsite(website);
    }

    @Override
    public List<Link> getAllLinks() {
        return linkRepository.findAll();
    }
}
