import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello DB user!");

        DBConnector user=new DBConnector();
        user.Connect();

        String termination="";
        while (!termination.equals("t")) {

            System.out.println("wybież jedną z opcji");
            System.out.println("1. pokaż listę zwierzat w zoo");
            System.out.println("2. dodaj zwierze do listy");
            System.out.println("3. modyfikuj zwierze");
            System.out.println("4. usuń zwierzeta z listy");

            int opr = getInt();


            switch (opr) {
                case 1:
                    System.out.println(Animal.getAllAnimals(user));
                    //Animal.getAllanimals(user).forEach((n) -> System.out.println(n));
                    break;
                case 2:
                    // troche to na siłę
                    Animal animal = new Animal(null, null, null, null, null);
                    animal.createAnimal();
                    animal.save(user);
                    break;
                case 3:
                    Animal.modify(user);

                    break;
                case 4:
                    Animal.deleteAllAnimals(user);

            }
            System.out.println("czy zakończyć działanie programu [t/n]");
            termination=getString();

        }



        Map<Country,String> popularReligion=new HashMap<>();

        popularReligion.put(Country.Poland,"Christianity");
        popularReligion.put(Country.Egipt,"muslim");
        popularReligion.put(Country.India,"Buddism");

    }



    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }
    public static String getString(){
        return new Scanner(System.in).next();
    }





}