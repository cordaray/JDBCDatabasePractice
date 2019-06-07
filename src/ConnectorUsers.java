
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DacordMachine
 */
public class ConnectorUsers extends Connector {

    Scanner sc = new Scanner(System.in);
    PreparedStatement pstmt = null;

    public ConnectorUsers() {

        super("jdbc:mysql://localhost/Patrones", "root", "1234", null, null, null);

    }

    @Override
    public void select() {
        super.select();
        connect();
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery("Select * from Usuario");
            ArrayList<User> Users = new ArrayList();

            while (rs.next()) {

                Users.add(new User(rs.getInt("id"), rs.getString("nombre")));

            }

            for (User u : Users) {
                System.out.println(u.toString());
            }

        } catch (Exception ex) {

            System.out.print("Connection Error: ");
            ex.printStackTrace();

        }
    }

    @Override
    public void delete() {

        super.delete();
        connect();
        try {

            System.out.println("What is the id?");
            int id = sc.nextInt();
            PreparedStatement pstmt = conn.prepareStatement("DELETE from usuario where id = ?");
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (Exception ex) {

        }

    }

    @Override
    public void update() {
        super.update();
        boolean done = false;

        do {

            try {

                System.out.println("What is the ID of the User you want to update?");
                int id = sc.nextInt();
                System.out.println("What is the new name");
                String name = sc.next();
                System.out.println("What is the last name");
                String lname = sc.next();
                connect();
                pstmt = conn.prepareStatement("UPDATE usuario set nombre = ? where id = ?");
                pstmt.setString(1, name + " " + lname);
                pstmt.setInt(2, id);
                pstmt.executeUpdate();
                System.out.println("Update succesfull");
                done = true;

            } catch (Exception ex) {

                System.out.println("Error updating info");

            }

        } while (done == false);

    }

    @Override
    public void create() {
        super.create();
        int index = 0;
        connect();
        try {
            rs = stmt.executeQuery("Select * from usuario");

            while (rs.next()) {

                index = index + 1;

            }
            System.out.println("What is first name?");
            String name = sc.next();
            System.out.println("What is the last name?");
            String lname = sc.next();
            pstmt = conn.prepareStatement("INSERT INTO usuario (id,nombre) values (?, ?)");
            pstmt.setInt(1, index + 1);
            pstmt.setString(2, name + " " + lname);
            pstmt.executeUpdate();
            System.out.println("User added");
        } catch (Exception ex) {

            System.out.println("Connection Error:");
            ex.printStackTrace();

        }

    }

    @Override
    public void disconnect() {
        super.disconnect();
    }

    @Override
    public void connect() {
        super.connect();

        try {

            conn = DriverManager.getConnection(DB_URL, USER, PWD);

            System.out.println("Connection Succeded");

        } catch (Exception ex) {

            System.out.println("Connection ERROR: ");
            ex.printStackTrace();

        }

    }

}
