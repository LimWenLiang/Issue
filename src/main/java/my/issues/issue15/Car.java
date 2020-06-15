package my.issues.issue15;

public class Car {

    private String plateNo;
    private String carModel;
    private int year;

    public Car(String plateNo, String carModel, int year) {
        this.plateNo = plateNo;
        this.carModel = carModel;
        this.year = year;
    }

    @Override
    public String toString() {
        return plateNo + " " + carModel + " " + year;
    }
}
