package com.company;

class District {
    private City districtCenter;
    private int numberOfSettlements;
    private String name;

    District(City districtCenter, int numberOfSettlements){
        this.districtCenter = districtCenter;
        this.numberOfSettlements = numberOfSettlements;
        this.name = districtCenter.getName();
    }
}
