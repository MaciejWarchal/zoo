import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

public class Animal {

    public enum FoodType{
        PLANT, MEAT, ALL;
    }

    Integer id;
    String spieces;
    String name;
    FoodType foodType;
    Country countryOfOrign;


    public Animal(Integer id, String spieces, String name, FoodType foodType, Country countryOfOrign) {
        this.id = id;
        this.spieces = spieces;
        this.name = name;
        this.foodType = foodType;
        this.countryOfOrign = countryOfOrign;
    }

    public Animal() {
    }

    public static List<Animal> getAllAnimals(DBConnector dbConnector){
        List<Animal> animals=new ArrayList<>();
        String sql="select * from animals;";
        ResultSet resultSet= dbConnector.getResults(sql);
        System.out.println(resultSet);
        try {
            while (resultSet.next()){
                Integer id= resultSet.getInt("id");
                String species= resultSet.getString("species");
                String name= resultSet.getString("name");
                String food =resultSet.getString("food_type");
                FoodType foodType2=null;
                switch (food) {
                    case "PLANT":
                        foodType2 = FoodType.PLANT;
                        break;
                    case "MEAT":
                        foodType2 = FoodType.MEAT;
                        break;
                    case "ALL":
                        foodType2 = FoodType.ALL;
                        break;
                }
                Country country1=null;
                String country= resultSet.getString("country");
                switch (country) {
                    case "Poland":
                        country1 = Country.Poland;
                        break;
                    case "Australia":
                        country1 = Country.Australia;
                        break;
                    case "Egipt":
                        country1 = Country.Egipt;
                        break;
                    case "India":
                        country1 = Country.India;
                        break;
                    case "Usa":
                        country1 = Country.Usa;
                        break;
                }







                Animal animal= new Animal(id,species,name,foodType2,country1);
                animals.add(animal);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return animals;
    }

    public void save(DBConnector dbConnector){

        String sql= "insert into animals values (";
        sql += this.id + ",";
        sql += "'" + this.spieces +" ',";
        sql += "'" + this.name + "',";
        sql += "'" + this.foodType +"',";
        sql += "'" + this.countryOfOrign +"');";


        dbConnector.execute(sql);
        System.out.println("Zapisałeś zwierze"+this.name);

    }

    public static void deleteAllAnimals(DBConnector dbConnector){
        dbConnector.execute("delete from animals");
        System.out.println("usunieto wszystkie zwierzeta");
    }


    public static List<Animal> getAllanimals(DBConnector dbConnector){
        List<Animal> animals = new ArrayList<>();
        String sql= "select * from animal;";
        ResultSet resultSet= dbConnector.getResults(sql);
        return (List<Animal>) resultSet;
    }

    public  void createAnimal() {
        System.out.println("podaj id");
        this.id = Main.getInt();

        System.out.println("podaj imie");
        this.name = Main.getString();

        System.out.println("podaj gatunek");
        this.spieces = Main.getString();

        System.out.println("podaj jaki pokarm spożywa [1. plant, 2. meat, 3. all]");
        int food = Main.getInt();
        switch (food) {
            case 1:
                this.foodType = FoodType.PLANT;
                break;
            case 2:
                this.foodType = FoodType.MEAT;
                break;
            case 3:
                this.foodType = FoodType.ALL;
                break;
        }



        System.out.println("podaj kraj pochodzenia");
        System.out.println("1. Polska");
        System.out.println("2. Australia");
        System.out.println("3. Egipt");
        System.out.println("4. Indie");
        System.out.println("5. USA");
        int country = Main.getInt();
        switch (country) {
            case 1:
                this.countryOfOrign = Country.Poland;
                break;
            case 2:
                this.countryOfOrign = Country.Australia;
                break;
            case 3:
                this.countryOfOrign = Country.Egipt;
                break;
            case 4:
                this.countryOfOrign = Country.India;
                break;
            case 5:
                this.countryOfOrign = Country.Usa;
                break;
        }

    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", spieces='" + spieces + '\'' +
                ", name='" + name + '\'' +
                ", foodType=" + foodType +
                ", countryOfOrign=" + countryOfOrign +
                '}';
    }
}
