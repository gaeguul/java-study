package org.scoula.persistence;

import java.sql.*;
import lombok.extern.log4j.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.fail;

@Log4j2
public class JDBCTests {

  @BeforeAll
  public static void setup() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
    }catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Test
  @DisplayName("JDBC 드라이버 연결이 된다.")
  public void testConnection() {
    String url = "jdbc:mysql://localhost:3306/scoula_db";
    try(Connection con = DriverManager.getConnection(url, "scoula", "1234")) {
      log.info(con);
    } catch(Exception e) {
      fail(e.getMessage());
    }
  }
}
