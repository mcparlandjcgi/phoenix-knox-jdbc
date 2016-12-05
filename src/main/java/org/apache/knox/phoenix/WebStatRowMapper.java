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

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * A row mapper for a {@link WebStat}.
 *
 * @author mcparlandj
 *
 */
public class WebStatRowMapper implements RowMapper<WebStat> {

  /*
   * HOST CHAR(2) NOT NULL, DOMAIN VARCHAR NOT NULL, FEATURE VARCHAR NOT NULL, DATE DATE NOT NULL,
   * USAGE.CORE BIGINT, USAGE.DB BIGINT, STATS.ACTIVE_VISITOR INTEGER
   * 
   */

  /*
   * (non-Javadoc)
   * 
   * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
   */
  @Override
  public WebStat mapRow(ResultSet rs, int rowNum) throws SQLException {
    WebStat webStat = new WebStat();
    webStat.setHost(rs.getString("HOST"));
    webStat.setDomain(rs.getString("DOMAIN"));
    webStat.setFeature(rs.getString("FEATURE"));
    webStat.setDate(rs.getDate("DATE"));
    webStat.setUsageCore(rs.getLong("USAGE.CORE"));
    webStat.setUsageDb(rs.getLong("USAGE.DB"));
    webStat.setStatsActiveVisitor(rs.getInt("STATS.ACTIVE_VISITOR"));
    return webStat;
  }

}
