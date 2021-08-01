package com.axl.coronavirustracker.models;

import lombok.Data;
import lombok.ToString;

@ToString
@Data
public class LocationStats {
    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;

}

