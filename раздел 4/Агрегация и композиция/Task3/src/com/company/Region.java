package com.company;

import java.util.ArrayList;
import java.util.Collections;

class Region {
     private City regionalCenter;
     private ArrayList<District> districts = new ArrayList<>();
     private String name;

     Region(City regionalCenter, District[] districts) {
         this.regionalCenter = regionalCenter;
         Collections.addAll(this.districts, districts);
         this.name = regionalCenter.getName();
     }

     public void printRegionalCenter(){
         System.out.println("Областной центр: " + regionalCenter.getName());
         regionalCenter.printCity();
     }
 }
