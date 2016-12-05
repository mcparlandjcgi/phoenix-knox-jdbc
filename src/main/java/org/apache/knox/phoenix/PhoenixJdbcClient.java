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
package org.apache.knox.phoenix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

/**
 * A JDBC Client for Phoenix.
 *
 * @author mcparlandj
 *
 */
@Component
public class PhoenixJdbcClient {

  /**
   * The jdbcTemplate.
   */
  @Autowired
  private JdbcTemplate jdbcTemplate = null;

  /**
   * The testQuery.
   */
  @Value("${phoenixJdbcClient.testQuery}")
  private String testQuery = null;

  /**
   * The testRowMapper.
   */
  @Autowired
  private RowMapper<WebStat> testRowMapper = null;

  /**
   * Create a PhoenixJdbcClient.
   * 
   */
  public PhoenixJdbcClient() {

  }

  /**
   * Get the jdbcTemplate.
   * 
   * @return the jdbcTemplate.
   */
  public JdbcTemplate getJdbcTemplate() {
    return jdbcTemplate;
  }


  /**
   * Set the jdbcTemplate.
   * 
   * @param jdbcTemplate the jdbcTemplate to set.
   */
  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }

  /**
   * Get the testQuery.
   * 
   * @return the testQuery.
   */
  public String getTestQuery() {
    return testQuery;
  }

  /**
   * Set the testQuery.
   * 
   * @param testQuery the testQuery to set.
   */
  public void setTestQuery(String testQuery) {
    this.testQuery = testQuery;
  }

  /**
   * Get the testRowMapper.
   * 
   * @return the testRowMapper.
   */
  public RowMapper<WebStat> getTestRowMapper() {
    return testRowMapper;
  }

  /**
   * Set the testRowMapper.
   * 
   * @param testRowMapper the testRowMapper to set.
   */
  public void setTestRowMapper(RowMapper<WebStat> testRowMapper) {
    this.testRowMapper = testRowMapper;
  }

  /**
   * Execute the test query.
   * 
   * @return the result of executing the test query.
   */
  public List<WebStat> executeTestQuery() {
    return jdbcTemplate.query(testQuery, testRowMapper);
  }


}
