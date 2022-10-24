import java.sql.*;


public class DBConnector {

    private final String databaseAddres= "jdbc:postgresql://localhost:5432/zoo";
    private final String user= "maciek";
    private final String password="szymek";
    private Connection connection;

    public boolean Connect(){
        try {
            Class.forName("org.postgresql.Driver");
            connection= DriverManager.getConnection(databaseAddres,user,password);
            System.out.println("Udalo sie polaczyc z baza");
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public void execute(String sql){
        try {
            Statement statement= connection.createStatement();
            statement.execute(sql);
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void show(String sql){
        try {
            Statement statement= connection.createStatement();
            statement.execute(sql);
            System.out.println(statement.toString());
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public ResultSet getResults(String sql){
        ResultSet resultSet = null;
        try {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }





}
