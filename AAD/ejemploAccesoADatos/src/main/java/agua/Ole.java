package agua;

import java.sql.*;

public class Ole {

    public static void main (String[] args){

        String dir, user, pass;
        dir = "jdbc:mysql://localhost/";
        user = "root";
        pass = "";

        Connection con = null;
        PreparedStatement psmt = null;

        try {
            con = DriverManager.getConnection(dir, user, pass);
            psmt = con.prepareStatement("DROP DATABASE IF EXISTS pikachu;");
            psmt.execute();
            psmt = con.prepareStatement("CREATE DATABASE pikachu");
            psmt.execute();
            psmt = con.prepareStatement("USE pikachu");
            psmt.execute();

            psmt = con.prepareStatement("CREATE TABLE pikapika(" +
                    "id int primary key," +
                    "nombre varchar(30)," +
                    "edad int" +
                    ");");
            psmt.execute();

            psmt = con.prepareStatement("INSERT INTO pikapika VALUES(1, 'olii',12), (2, 'piko', 13);");
            psmt.execute();

            psmt = con.prepareStatement("SELECT * FROM pikapika;");

            ResultSet rs = psmt.executeQuery();

            while(rs.next()){
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                System.out.println(id+nombre+edad);
            }

            psmt = con.prepareStatement("CREATE PROCEDURE pikear(" +
                    "IN iva FLOAT," +
                    "OUT pikeo varchar(20))" +
                    "" +
                    "BEGIN " +
                    "IF iva > 34 THEN " +
                    "SET pikeo = 'bro... wtf...!'; " +
                    "ELSE " +
                    "SET pikeo = 'ogey magey'; " +
                    "END IF;" +
                    "END;");
            psmt.execute();

            Thread.sleep(2000);

            CallableStatement cs = con.prepareCall("call pikachu.pikear(?,?)");
            cs.setFloat(1,35.5f );
            cs.registerOutParameter(2, Types.VARCHAR);

            cs.executeUpdate();

            System.out.println(cs.getString(2));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
