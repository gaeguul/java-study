package org.scoula.config;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;
import javax.sql.*;
import lombok.extern.log4j.*;
import org.apache.ibatis.session.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.test.context.*;
import org.springframework.test.context.junit.jupiter.*;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {RootConfig.class})
class RootConfigTest {

  @Autowired
  private DataSource dataSource;

  @Autowired // Bean으로 등록된 객체에만 Autowired가 가능하다
  private SqlSessionFactory sqlSessionFactory;

  @Test
  @DisplayName("DataSource 연결이 된다")
  void dataSource() throws SQLException {
    try (Connection con = dataSource.getConnection()) {
      log.info("DataSource 준비 완료");
      log.info(con);
    }
  }

  @Test
  public void testSqlSessionFactory() {
    try (SqlSession session = sqlSessionFactory.openSession(); Connection con = session.getConnection();) {
      log.info(session);
      log.info(con);
    } catch (Exception e) {
      e.printStackTrace();
      fail(e.getMessage());
    }
  }
}