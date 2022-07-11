package com.example.kalpix.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "link_name", nullable = false)
    private String linkName;

    @ManyToOne
    @JoinColumn(name="website_id", nullable=false)
    private Website website;

    @Column(name = "total_elapsed_time")
    private long totalElapsedTime;

    @Column(name = "total_downloaded_kilobytes")
    private long totalDownloadedKilobytes;

    public Link() {
    }
}
