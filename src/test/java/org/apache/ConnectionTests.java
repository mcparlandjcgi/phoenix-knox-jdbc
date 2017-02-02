package org.apache;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.phoenixjdbc.config.PhoenixProperties;
import org.apache.phoenixjdbc.database.ConnectionFactoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by jovanicb on 02/02/17.
 */
public class ConnectionTests {

  @Before
  public void before() {
    // Install the all-trusting host verifier
    HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
      // Create all-trusting host name verifier
      public boolean verify(String hostname, SSLSession session) {
        return true;
      }
    });
  }

  @Test
  public void testConnection() throws SQLException, ClassNotFoundException {

    ConnectionFactoryImpl conn = new ConnectionFactoryImpl();
    PhoenixProperties props = new PhoenixProperties();

    // props.setJdbcUrl(
    // "jdbc:avatica:remote:url=https://hdp24sandbox-v2.ukwest.cloudapp.azure.com:8443/gateway/sandbox/avatica/;authentication=BASIC;avatica_username=guest;avatica_password=guest-password");
    props.setJdbcUrl(
        "jdbc:avatica:remote:url=https://hdp24sandbox-v2.ukwest.cloudapp.azure.com:8443/gateway/sandbox/avatica/");

    System.out.println(props);
    conn.getConnection(props);
  }

  @Test
  public void testURLReturns404() throws IOException {

    URL url =
        new URL("https://hdp24sandbox-v2.ukwest.cloudapp.azure.com:8443/gateway/sandbox/avatica/");

    HttpURLConnection connection = (HttpURLConnection) url.openConnection();

    byte[] message = ("guest:guest-password").getBytes("UTF-8");
    String encoded = javax.xml.bind.DatatypeConverter.printBase64Binary(message);
    connection.setRequestProperty("Authorization", "Basic " + encoded);

    final int responseCode = connection.getResponseCode();

    Assert.assertEquals(404, responseCode);
  }
}
