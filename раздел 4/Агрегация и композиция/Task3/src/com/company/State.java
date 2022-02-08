package com.company;

import java.util.ArrayList;
import java.util.Collections;

class State {
    private City capital;
    private ArrayList<Region> regions = new ArrayList<>();
    private String name;
    private int area;

    State(City capital, Region[] regions, String name, int area) {
        this.capital = capital;
        Collections.addAll(this.regions, regions);
        this.name = name;
        this.area = area;
    }

    public void printCapital() {
        System.out.println("Столица государства: " + capital.getName());
        capital.printCity();
    }

    public void printNumOfRegions() {
        System.out.println("Количество областей: " + regions.size());
    }

    public void printArea() {
        System.out.println("Площадь государства: " + area + " тысяч километров крадратных");
    }

    public void printRegionalCenters() {
        for (Region region : regions) {
            region.printRegionalCenter();
        }
    }
}
