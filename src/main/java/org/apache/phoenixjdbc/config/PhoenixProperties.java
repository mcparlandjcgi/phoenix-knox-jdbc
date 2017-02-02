/**
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license
 * agreements. See the NOTICE file distributed with this work for additional information regarding
 * copyright ownership. The ASF licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License. You may obtain a
 * copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package org.apache.phoenixjdbc.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * A .
 *
 * @author mcparlandj
 *
 */
public class PhoenixProperties {

  private static final String PROPERTIES_FILE = "/usr/phoenixjdbc/config.properties";

  private static final String JDBC_URL_PROP = "jdbc.url";
  private static final String SQL_STATEMENT_PROP = "sql.statement";
  private static final String DRIVER_NAME_PROP = "driver.name";

  private String jdbcUrl = "jdbc:phoenix:sandbox.hortonworks.com:/hbase-unsecure";

  private String sqlStatement =
      "SELECT DOMAIN, AVG(CORE) Average_CPU_Usage, AVG(DB) Average_DB_Usage  FROM WEB_STAT GROUP BY DOMAIN ORDER BY DOMAIN DESC";

  private String driverName = "org.apache.phoenix.jdbc.PhoenixDriver";

  public PhoenixProperties() {

  }

  /**
   * Get the jdbcUrl.
   * 
   * @return the jdbcUrl.
   */
  public String getJdbcUrl() {
    return jdbcUrl;
  }

  /**
   * Set the jdbcUrl.
   * 
   * @param jdbcUrl the jdbcUrl to set.
   */
  public void setJdbcUrl(String jdbcUrl) {
    this.jdbcUrl = jdbcUrl;
  }

  /**
   * Get the sqlStatement.
   * 
   * @return the sqlStatement.
   */
  public String getSqlStatement() {
    return sqlStatement;
  }

  /**
   * Set the sqlStatement.
   * 
   * @param sqlStatement the sqlStatement to set.
   */
  public void setSqlStatement(String sqlStatement) {
    this.sqlStatement = sqlStatement;
  }

  /**
   * Get the driverName.
   * 
   * @return the driverName.
   */
  public String getDriverName() {
    return driverName;
  }

  /**
   * Set the driverName.
   * 
   * @param driverName the driverName to set.
   */
  public void setDriverName(String driverName) {
    this.driverName = driverName;
  }

  public void readProperties() throws IOException {
    if (Files.exists(Paths.get(PROPERTIES_FILE))) {
      Properties prop = new Properties();
      InputStream input = new FileInputStream(PROPERTIES_FILE);
      prop.load(input);
      jdbcUrl = prop.getProperty(JDBC_URL_PROP);
      sqlStatement = prop.getProperty(SQL_STATEMENT_PROP);
      driverName = prop.getProperty(DRIVER_NAME_PROP);
    }
  }

  public void resetToDefault() {
    jdbcUrl = "jdbc:phoenix:localhost:/hbase-unsecure";
    sqlStatement = "select * from WEB_STAT";
    driverName = "org.apache.phoenix.jdbc.PhoenixDriver";
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return "PhoenixProperties [jdbcUrl=" + jdbcUrl + ", sqlStatement=" + sqlStatement
        + ", driverName=" + driverName + "]";
  }

}
