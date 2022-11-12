package src;

import src.Car;

import java.util.Scanner;

public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        this.cars = new Car[cars.length];
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]);
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    public void sell(int index) {
        this.cars[index].drive();
        this.cars[index] = null;
    }
    public void searchAndSell(String make, int budget){
        sell(search(make, budget));
    }

    
    public int search(String make, int budget) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                System.out.println("\nWe found one in spot " + i + "\n" + this.cars[i].toString() + "\nAre you interested ?(anwser yes/no)");
                String anwser = scanner.nextLine();
                if(anwser.equals("yes")){
                    return i;
                }else{
                    continue;
                }

            }
        }
        System.out.println("we didn't find any car for you");
        System.out.println("feel free to check our car colletion");
        for (int i = 0; i < cars.length ; i++) {
            System.out.println(cars[i].toString());
        }
        return 404;
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}
