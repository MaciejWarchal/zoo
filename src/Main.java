import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println("Hello DB user!");

        DBConnector user = new DBConnector();
        user.Connect();

        List<Animal> animalList = new ArrayList<>(10);
        List<Employee> employeeList = new ArrayList<>(10);
        animalList = Animal.getAllAnimals(user);
        employeeList = Employee.getAllEmployess(user);

        Map<Animal, Employee> feedOrder = new HashMap<>();
        feedOrder.put(animalList.get(0), employeeList.get(0));
        feedOrder.put(animalList.get(1), employeeList.get(1));
        feedOrder.put(animalList.get(2), employeeList.get(2));

        String termination = "";
        while (!termination.equals("t")) {

            System.out.println("wybież jedną z opcji");
            System.out.println("1. pokaż listę zwierzat w zoo");
            System.out.println("2. dodaj zwierze do listy");
            System.out.println("3. modyfikuj dane zwierzecia");
            System.out.println("4. usuń wszystkie zwierzeta z listy");
            System.out.println("5. pokaż listę pracowników w zoo");
            System.out.println("6. dodaj pracownika do listy");
            System.out.println("7. modyfikuj dane pracownika");
            System.out.println("8. usuń wszystkich pracownikow z listy");
            System.out.println("9. karm zwirzeta");


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
                    break;
                case 5:
                    Employee.getAllEmployess(user);
                    break;
                case 6:
                    Employee employee1 = new Employee(null, null);
                    employee1.addEmployee(user);
                    break;
                case 7:
                    Employee.modifyEmployeeData(user);
                    break;
                case 8:
                    Employee.deleteAllEmployees(user);
                    break;
                case 9:
                    feedAnimal(Animal.getAllAnimals(user),Employee.getAllEmployess(user),feedOrder);

                    break;

                default:
                    System.out.println("Niepoprawny wybor");

            }

            System.out.println("czy zakończyć działanie programu [t/n]");
            termination = getString();

        }


        Map<Country, String> popularReligion = new HashMap<>();

        popularReligion.put(Country.Poland, "Christianity");
        popularReligion.put(Country.Egipt, "muslim");
        popularReligion.put(Country.India, "Buddism");







}
    public static void feedAnimal(List<Animal> animalList, List<Employee> employeeList, Map<Animal, Employee> feedOrder){
        System.out.println("podaj imię zwierzecia do karmienia");
        String name=getString();
        for (int i=0;i< animalList.size();i++){
            if (animalList.get(i).getName().equals(name)){
                Animal animal2=animalList.get(i);
                System.out.println(animal2);

                System.out.println(animal2.getName()+" bedzie karmiony pokarmem "+animal2.getFoodType());
                System.out.println("przez pracownika "+feedOrder.get(animal2));
                System.out.println(feedOrder.containsValue(animal2));

                System.out.println("forLoop");
                for (int k=0;k< feedOrder.size();k++){
                    System.out.println(feedOrder);
                }




            }

        }
    }





    public static int getInt(){
        return new Scanner(System.in).nextInt();
    }
    public static String getString(){
        return new Scanner(System.in).next();
    }





}