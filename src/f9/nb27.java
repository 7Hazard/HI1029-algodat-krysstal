package f9;

import java.io.*;
import java.util.*;

public class nb27 {
    public static void main(String[] args) throws IOException {
        var cars = new ArrayList<Car>();
        try (BufferedReader br = new BufferedReader(new FileReader("cars.txt"))) {
            for (String brand; (brand = br.readLine()) != null; ) {
                var year = Integer.parseInt(br.readLine());
                var miles = Integer.parseInt(br.readLine());
                cars.add(new Car(brand, year, miles));
            }
        }

        // a: Java APIs
        System.out.println("\nCollection:");
        Collections.sort(cars);
        for (Car car : cars) {
            System.out.println(car);
        }

        System.out.println("Stream:");
        try (var br = new BufferedWriter(new FileWriter("cars-jsorted.txt"))) {
            cars.stream().sorted().forEach(car -> {
                System.out.println(car);
                try {
                    br.write(car.brand+"\n");
                    br.write(car.year+"\n");
                    br.write(car.miles+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }

        // b: Comparator
        System.out.println("Comparator:");
        try (var br = new BufferedWriter(new FileWriter("cars-csorted.txt"))) {
            cars.sort(new CompareCar());
            for (Car car : cars) {
                br.write(car.brand+"\n");
                br.write(car.year+"\n");
                br.write(car.miles+"\n");
            }
        }
    }

    static class Car implements Comparable<Car> {
        String brand;
        int year;
        int miles;

        public Car(String brand, int year, int miles) {
            this.brand = brand;
            this.year = year;
            this.miles = miles;
        }

        @Override
        public int compareTo(Car o) {
            return brand.compareTo(o.brand);
        }

        @Override
        public String toString() {
            return brand;
        }
    }

    static class CompareCar implements Comparator<Car> {
        @Override
        public int compare(Car r, Car l) {
            return Integer.compare(r.year, l.year);
//            return r.year > l.year ? 1 : (r.year == l.year ? 0 : -1);
        }
    }
}
