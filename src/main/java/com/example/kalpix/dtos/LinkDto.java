package com.example.kalpix.dtos;

import com.example.kalpix.models.Website;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Getter
@Setter
public class LinkDto {

    private Long id;

    private String webpageName;

    private String linkName;

    private String totalElapsedTime;

    private String totalDownloadedKilobytes;
}
