package DAY1.program4;

import java.lang.String;

class Pen{
    String color;
    String type;

    Pen(String color, String type){
        this.color = color;
        this.type = type;
    }

    void write(){
        System.out.println("Writing With " + this.color + " color " + this.type + " pen!!");
    }
}

public class Oops {
    public static void main(String[] args) {
        Pen pen1 = new Pen("Blue","Gel");
        pen1.write();

    }
}
