package org.apache.phoenixjdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.phoenixjdbc.config.PhoenixProperties;
import org.apache.phoenixjdbc.database.ConnectionFactoryImpl;

/**
 * Hello world!
 *
 */
public class App {
  public static void main(String[] args) throws ClassNotFoundException, SQLException {


    PhoenixProperties props = new PhoenixProperties();
    try {
      props.readProperties();
    } catch (Exception ex) {
      System.err.println("Sorry couldn't read properties, will keep defaults");
      props.resetToDefault();
    }
    
    System.out.println(props.toString());

    ConnectionFactoryImpl conFact = new ConnectionFactoryImpl();
    Connection conn = conFact.getConnection(props);

    ResultSet rst = conn.createStatement().executeQuery(props.getSqlStatement());
    while (rst.next()) {
      System.out.println(rst.getString(1) + " " + rst.getString(2));
    }
  }
}
