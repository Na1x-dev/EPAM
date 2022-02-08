package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TravelVouchers {
    ArrayList<TravelVoucher> travelVouchers = new ArrayList<>();


    TravelVouchers(TravelVoucher travelVoucher) {
        travelVouchers.add(travelVoucher);
    }

    public void addVoucher(TravelVoucher travelVoucher) {
        travelVouchers.add(travelVoucher);
    }

    public void print() {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            tv.printVoucher();
            {
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void printByType(String type) {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            if (type.equals(tv.getType())) {
                tv.printVoucher();
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void printByDuration(int duration) {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            if (duration == tv.getDuration()) {
                tv.printVoucher();
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void printByTransport(String transport) {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            if (transport.equals(tv.getTransport())) {
                tv.printVoucher();
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void printByFood(int food) {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            if (food == tv.getFood()) {
                tv.printVoucher();
                System.out.println("-------------------------------------------------");
            }
        }
    }

    public void printByPrice(int price) {
        System.out.println("-------------------------------------------------");
        for (TravelVoucher tv : travelVouchers) {
            if (price >= tv.getPrice())
                tv.printVoucher();
            System.out.println("-------------------------------------------------");
        }
    }

    //-------------------------------------------------------------------------------------------------//

    class TypeComparator implements Comparator<TravelVoucher> {
        public int compare(TravelVoucher tv1, TravelVoucher tv2) {
            return tv1.getType().compareTo(tv2.getType());
        }
    }

    public void sortByType() {
        TypeComparator typeComparator = new TypeComparator();
        Collections.sort(travelVouchers, typeComparator);
    }


    class DurationComparator implements Comparator<TravelVoucher> {
        public int compare(TravelVoucher tv1, TravelVoucher tv2) {
            if (tv1.getDuration() > tv2.getDuration())
                return 1;
            else if (tv1.getDuration() < tv2.getDuration())
                return -1;
            else
                return 0;
        }
    }

    public void sortByDuration() {
        DurationComparator durationComparator = new DurationComparator();
        Collections.sort(travelVouchers, durationComparator);
    }


    class TransportComparator implements Comparator<TravelVoucher> {
        public int compare(TravelVoucher tv1, TravelVoucher tv2) {
            System.out.println(tv1.getTransport().compareTo(tv2.getTransport()));
            return tv1.getTransport().compareTo(tv2.getTransport());
        }
    }

    public void sortByTransport() {
        TransportComparator transportComparator = new TransportComparator();
        Collections.sort(travelVouchers, transportComparator);
    }


    class FoodComparator implements Comparator<TravelVoucher> {
        public int compare(TravelVoucher tv1, TravelVoucher tv2) {
            if (tv1.getFood() > tv2.getFood())
                return 1;
            else if (tv1.getFood() < tv2.getFood())
                return -1;
            else
                return 0;
        }
    }

    public void sortByFood() {
        FoodComparator foodComparator = new FoodComparator();
        Collections.sort(travelVouchers, foodComparator);
    }


    class PriceComparator implements Comparator<TravelVoucher> {
        public int compare(TravelVoucher tv1, TravelVoucher tv2) {
            if (tv1.getPrice() > tv2.getPrice())
                return 1;
            else if (tv1.getPrice() < tv2.getPrice())
                return -1;
            else
                return 0;
        }
    }

    public void sortByPrice() {
        PriceComparator priceComparator = new PriceComparator();
        Collections.sort(travelVouchers, priceComparator);
    }
}
