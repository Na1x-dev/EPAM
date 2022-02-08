package com.company;

 class City {
     private String name;
     private int population;

     City(String name, int population) {
         this.name = name;
         this.population = population;
     }

     public String getName() {
         return name;
     }

     public int getPopulation() {
         return population;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setPopulation(int population) {
         this.population = population;
     }

     public void printCity(){
         System.out.println("Население города: " + population);
     }
 }
