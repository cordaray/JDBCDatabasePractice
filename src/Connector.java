
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author DacordMachine
 */
public abstract class Connector implements Connectable {

    String DB_URL;
    String USER;
    String PWD;
    Connection conn;
    Statement stmt;
    ResultSet rs;

    public Connector(String DB_URL, String USER, String PWD, Connection conn, Statement stmt, ResultSet rs) {
        this.DB_URL = DB_URL;
        this.USER = USER;
        this.PWD = PWD;
        this.conn = conn;
        this.stmt = stmt;
        this.rs = rs;
    }

    @Override
    public void connect() {

    }

    @Override
    public void disconnect() {

    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void select() {

    }

}
