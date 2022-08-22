public class Auto {
    private BrandsAuto brand;
    private int yearOfProduction;
    private long price;
    private String color;
    private double volumeOfMotor;

    public Auto(BrandsAuto brand, int yearOfProduction, long price, String color, double volumeOfMotor) {
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.color = color;
        this.volumeOfMotor = volumeOfMotor;
    }

    public BrandsAuto getBrand() {
        return brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public long getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public double getVolumeOfMotor() {
        return volumeOfMotor;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "brand='" + brand + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", volumeOfMotor=" + volumeOfMotor +
                '}';
    }
}
