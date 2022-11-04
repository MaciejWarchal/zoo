import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Employee {

    Integer id;
    String name;

    public Employee(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public static List<Employee> getAllEmployess(DBConnector dbConnector){
        List<Employee> employeesL=new ArrayList<>(10);
        String sql="select * from employees";
        ResultSet resultSet= dbConnector.getResults(sql);


        try {
            while (resultSet.next()){
                Integer id= resultSet.getInt("id");
                String name=resultSet.getString("name");
                Employee employee=new Employee(id,name);
                employeesL.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i=0;i< employeesL.size(); i++){
            System.out.println(employeesL.get(i));
        }
        return employeesL;
    }

    public void addEmployee(DBConnector dbConnector){
        System.out.println("podaj id pracownika");
        this.id=Main.getInt();
        System.out.println("podaj imie pracownika");
        this.name=Main.getString();

        String sql ="INSERT INTO employees VALUES (";
        sql +=this.id+", ";
        sql +="'"+this.name+"');";
        dbConnector.execute(sql);
        System.out.println("added new employee "+this);
    }
    public static void modifyEmployeeData(DBConnector dbConnector){
        List<Employee> employeesList= new ArrayList<>(10);
        Employee employee=null;
        employeesList=getAllEmployess(dbConnector);
        System.out.println("podaj ID pracownika do zmiany danych");
        int id=Main.getInt();
        for (int i=0;i<employeesList.size();i++){
            int id1=employeesList.get(i).getId();
            if (id1==id){
                employee=employeesList.get(i);
                System.out.println("zmień: [1. id, 2. imie]");
                int op=Main.getInt();
                switch (op){
                    case 1:
                        System.out.println("podaj nowe id");
                        int NId=Main.getInt();
                        String sql="UPDATE employees SET id="+NId+" WHERE id="+id+";";
                        dbConnector.execute(sql);
                        System.out.println("zmiane wprowadzono");
                        break;
                    case  2:
                        System.out.println("podaj nowe imie");
                        String NName=Main.getString();
                        String sql1="UPDATE employees SET name='"+NName+"' WHERE id="+id+";";
                        dbConnector.execute(sql1);
                        System.out.println("zmiane wprowadzono");
                        break;
                }
            }
        }
    }
    public static void deleteAllEmployees(DBConnector dbConnector){
        String sql="DELETE FROM employees";
        dbConnector.execute(sql);
        System.out.println("usunieto wszystkich pracowników z bazy");
    }















    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
