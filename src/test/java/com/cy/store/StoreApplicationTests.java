package com.cy.store;

import com.cy.store.entity.User;
import com.cy.store.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.sql.DataSource;
import java.sql.SQLException;


@SpringBootTest
@RunWith(SpringRunner.class)
class StoreApplicationTests {

	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;



	@Test
	void contextLoads() {
	}

	@Test
	void getConnection() throws SQLException {
		System.out.println(dataSource.getConnection());
	}


}
