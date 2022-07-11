package com.example.kalpix.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "website")
public class Website {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "website_name", nullable = false)
    private String websiteName;
    @Column(name = "download_start_date_time", nullable = false)
    private long downloadStartDateTime;
    @Column(name = "download_end_time", nullable = false)
    private long downloadEndTime;
    @Column(name = "total_elapsed", nullable = false)
    private long totalElapsed;
    @Column(name = "total_downloaded_kilobytes")
    private long totalDownloadedKiloBytes;
    @OneToMany(mappedBy="website")
    private Set<Link> links;
}
