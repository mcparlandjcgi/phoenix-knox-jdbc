package org.apache.knox.phoenix;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class JdbctestApplication {

  public static void main(String[] args) {
    ApplicationContext ctx = SpringApplication.run(JdbctestApplication.class, args);
    PhoenixJdbcClient jdbcClient = ctx.getBean(PhoenixJdbcClient.class);
    List<WebStat> queryResults = jdbcClient.executeTestQuery();
    System.out.format("HOST | DOMAIN | FEATURE |    DATE    | USAGE.CORE | USAGE.DB | STATS.ACTIVE_VISITOR ");
    for (WebStat ws : queryResults) {
      System.out.println(ws.toString());
    }
  }
}
