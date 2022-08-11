package sg.edu.rp.c346.id20026955.democarpark;

import java.io.Serializable;

public class Carpark implements Serializable {
    private String carpark_num;
    private String total_lot;
    private String type;
    private String left;

    public Carpark(String carpark_num, String total_lot, String type, String left) {
        this.carpark_num = carpark_num;
        this.total_lot = total_lot;
        this.type = type;
        this.left = left;
    }

    public String getCarpark_num() {
        return carpark_num;
    }

    public void setCarpark_num(String carpark_num) {
        this.carpark_num = carpark_num;
    }

    public String getTotal_lot() {
        return total_lot;
    }

    public void setTotal_lot(String total_lot) {
        this.total_lot = total_lot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    @Override
    public String toString() {
        return "Carpark\n" +
                "Carpark Number: " + carpark_num + "\n"+
                "Total Lots: " + total_lot + "\n"+
                "Lot Type: " + type + '\'' + "\n"+
                "Lots Left: " + left + "\n";
    }
}
