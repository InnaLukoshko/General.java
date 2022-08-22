import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class General {
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static List<Auto> auto = new ArrayList<>();

    public static void main(String[] args) {
        auto.add(new Auto(BrandsAuto.GEELY,2020,19000,"White",1.4));
        auto.add(new Auto(BrandsAuto.AUDI,2021,50000,"Red",2));
        auto.add(new Auto(BrandsAuto.BMW,2019,40000,"Green",1.8));
        showMenu();

    }
    public static void showMenu() {
        while (true) {
            System.out.println("\nВведите действие, которое хотите реализовать: " +
                    "\n1 Показать все авто." +
                    "\n2 Показать все авто заданного цвета." +
                    "\n3 Показать все авто заданного объёма." +
                    "\n4 Показать все авто дороже заданной цены." +
                    "\n5 Показать все авто, чей год выпуска находится в указанном диапазоне." +
                    "\n6 Выход из программы");
            Integer operation = null;
            try {
                operation = Integer.parseInt(reader.readLine());
            } catch (Exception e1) {
                System.out.println("Номера действия с таким номером не существует!!!");
            }
            try {
                switch (operation) {
                    case 1:
                        printListAutos();
                        break;
                    case 2:
                        printByColor();
                        break;
                    case 3:
                        printByVolume();
                        break;
                    case 4:
                        printByPrice();
                        break;
                    case 5:
                        printByYear();
                        break;
                    case 6:
                        System.exit(1);
                    default:
                        System.out.println("Неверный ввод номера действия!!!");
                }
                break;

            } catch (Exception e) {
                System.out.println("Неверный ввод !!!");
                continue;
            }
        }
    }
    public static void printListAutos() {
        auto.stream().forEach(auto -> System.out.println(auto + "; "));
    }
    public static void printByColor() throws IOException {
        System.out.println("Введите цвет авто, которые хотите вывести на консоль");
        String color = reader.readLine();

        auto.stream()
                .filter(x -> x.getColor().equalsIgnoreCase(color))
                .forEach(n -> System.out.print(n + " "));

        boolean isColor = auto.stream().noneMatch(x -> x.getColor().equalsIgnoreCase(color));
        if (isColor == true) {
            System.out.println("Нет совпадения по " + color + " цвету");
        }

    }
    public static void printByVolume() throws IOException {
        System.out.println("Введите объём двителей авто, которые хотите вывести на консоль");
        double volume = Double.parseDouble(reader.readLine());

        auto.stream()
                .filter(x -> x.getVolumeOfMotor() == volume)
                .forEach(n -> System.out.print(n + " "));

        boolean isColor = auto.stream().noneMatch(x -> x.getVolumeOfMotor() == volume);
        if (isColor == true) {
            System.out.println("Нет совпадения по " + volume + " объёму двигателя");
        }
    }
    public static void printByPrice() throws IOException {
        System.out.println("Введите цену, чтобы вывести на консоль авто, которые дороже заданной цены");
        long price = Long.parseLong(reader.readLine());

        auto.stream()
                .filter(x -> x.getPrice() > price)
                .forEach(n -> System.out.print(n + " "));

        boolean isPrice = auto.stream().noneMatch(x -> x.getPrice() > price);
        if (isPrice == true) {
            System.out.println("В базе отсутствует авто дороже " + price);
        }
    }
    public static void printByYear() throws IOException {
        System.out.println("Введите 1й год диапазона");
        int year1 = Integer.parseInt(reader.readLine());
        System.out.println("Введите 2й год диапазона");
        int year2 = Integer.parseInt(reader.readLine());

        auto.stream()
                .filter(x -> x.getYearOfProduction() > year1 && x.getYearOfProduction() < year2)
                .forEach(n -> System.out.print(n + " "));

        boolean isPrice = auto.stream()
                .noneMatch(x -> x.getYearOfProduction() > year1 && x.getYearOfProduction() < year2);
        if (isPrice == true) {
            System.out.println("В базе отсутствует авто с годом выпуска в указанном диапазоне");
        }
    }
}
