package DAY2.program1;

import java.lang.String;

class Bicycle{
    int gear;
    int speed;

    Bicycle(int gear, int speed){
        this.gear = gear;
        this.speed = speed;
    }

    void applyBreak(int decrement){
        speed -= decrement;
    }

    void speedUp(int increment){
        speed += increment;
    }

    public String toString(){
        return ("The Bicycle have " + this.gear + " gear with speed of " + this.speed);
    }
}

class MountainBike extends Bicycle{
    int seatHeight;

    MountainBike(int gear, int speed, int seatHeight) {
        super(gear, speed);
        this.seatHeight = seatHeight;
    }

    void setSeatHeight(int seatHeight){
        this.seatHeight = seatHeight;
    }

    public String toString(){
        return (super.toString() + " at seat height of " + this.seatHeight);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        MountainBike m1 = new MountainBike(3, 200, 2);
        m1.setSeatHeight(1);
        System.out.println(m1.toString());
    }
}