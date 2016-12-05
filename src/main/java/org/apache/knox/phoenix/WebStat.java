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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A row from the web stat table.
 *
 * @author mcparlandj
 *
 */
public class WebStat {
  /*
   * HOST CHAR(2) NOT NULL, DOMAIN VARCHAR NOT NULL, FEATURE VARCHAR NOT NULL, DATE DATE NOT NULL,
   * USAGE.CORE BIGINT, USAGE.DB BIGINT, STATS.ACTIVE_VISITOR INTEGER
   * 
   */

  private DateFormat DATE_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

  private String host = null;

  private String domain = null;

  private String feature = null;

  private Date date = null;

  private long usageCore = 0L;

  private long usageDb = 0L;

  private int statsActiveVisitor = 0;

  public WebStat() {

  }

  /**
   * Get the host.
   * 
   * @return the host.
   */
  public String getHost() {
    return host;
  }

  /**
   * Set the host.
   * 
   * @param host the host to set.
   */
  public void setHost(String host) {
    this.host = host;
  }

  /**
   * Get the domain.
   * 
   * @return the domain.
   */
  public String getDomain() {
    return domain;
  }

  /**
   * Set the domain.
   * 
   * @param domain the domain to set.
   */
  public void setDomain(String domain) {
    this.domain = domain;
  }

  /**
   * Get the feature.
   * 
   * @return the feature.
   */
  public String getFeature() {
    return feature;
  }

  /**
   * Set the feature.
   * 
   * @param feature the feature to set.
   */
  public void setFeature(String feature) {
    this.feature = feature;
  }

  /**
   * Get the date.
   * 
   * @return the date.
   */
  public Date getDate() {
    return date;
  }

  /**
   * Set the date.
   * 
   * @param date the date to set.
   */
  public void setDate(Date date) {
    this.date = date;
  }

  /**
   * Get the usageCore.
   * 
   * @return the usageCore.
   */
  public long getUsageCore() {
    return usageCore;
  }

  /**
   * Set the usageCore.
   * 
   * @param usageCore the usageCore to set.
   */
  public void setUsageCore(long usageCore) {
    this.usageCore = usageCore;
  }

  /**
   * Get the usageDb.
   * 
   * @return the usageDb.
   */
  public long getUsageDb() {
    return usageDb;
  }

  /**
   * Set the usageDb.
   * 
   * @param usageDb the usageDb to set.
   */
  public void setUsageDb(long usageDb) {
    this.usageDb = usageDb;
  }

  /**
   * Get the statsActiveVisitor.
   * 
   * @return the statsActiveVisitor.
   */
  public int getStatsActiveVisitor() {
    return statsActiveVisitor;
  }

  /**
   * Set the statsActiveVisitor.
   * 
   * @param statsActiveVisitor the statsActiveVisitor to set.
   */
  public void setStatsActiveVisitor(int statsActiveVisitor) {
    this.statsActiveVisitor = statsActiveVisitor;
  }

  public String toTableOutput() {
    return host + " | " + domain + " | " + feature + " | " + DATE_FORMATTER.format(date) + " | "
        + usageCore + " | " + usageDb + " | " + statsActiveVisitor;
  }

}
