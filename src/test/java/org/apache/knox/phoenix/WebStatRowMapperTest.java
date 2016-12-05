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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

/**
 * A .
 *
 * @author mcparlandj
 *
 */
public class WebStatRowMapperTest {

  /*
   * HOST CHAR(2) NOT NULL, DOMAIN VARCHAR NOT NULL, FEATURE VARCHAR NOT NULL, DATE DATE NOT NULL,
   * USAGE.CORE BIGINT, USAGE.DB BIGINT, STATS.ACTIVE_VISITOR INTEGER
   * 
   */

  /**
   * Test method for
   * {@link org.apache.knox.phoenix.WebStatRowMapper#mapRow(java.sql.ResultSet, int)}.
   */
  @Test
  public void testMapRow() throws SQLException {
    final String host = "host";
    final String domain = "domain";
    final String feature = "feature";
    final java.sql.Date sqlDate = new java.sql.Date(10L);
    final long usageCore = 10L;
    final long usageDb = 99L;
    final int statsActiveVisitor = 14;

    final ResultSet rs = mock(ResultSet.class);
    when(rs.getString("HOST")).thenReturn(host);
    when(rs.getString("DOMAIN")).thenReturn(domain);
    when(rs.getString("FEATURE")).thenReturn(feature);
    when(rs.getDate("DATE")).thenReturn(sqlDate);
    when(rs.getLong("USAGE.CORE")).thenReturn(usageCore);
    when(rs.getLong("USAGE.DB")).thenReturn(usageDb);
    when(rs.getInt("STATS.ACTIVE_VISITOR")).thenReturn(statsActiveVisitor);

    final WebStatRowMapper mapper = new WebStatRowMapper();
    final WebStat returnedWs = mapper.mapRow(rs, 0);

    assertEquals(host, returnedWs.getHost());
    assertEquals(domain, returnedWs.getDomain());
    assertEquals(feature, returnedWs.getFeature());
    assertEquals(sqlDate.getTime(), returnedWs.getDate().getTime());
    assertEquals(usageCore, returnedWs.getUsageCore());
    assertEquals(usageDb, returnedWs.getUsageDb());
    assertEquals(statsActiveVisitor, returnedWs.getStatsActiveVisitor());
  }

}
