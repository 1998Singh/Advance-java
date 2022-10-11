package com.evoke.unittest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJunitApplicationTests {

	Calculater calculater = new Calculater();

	
	void contextLoads() {
	}

	@Test
	void testSum() {

		// expected
		int exceptedResult = 17;

		// actual
		int actualResult = calculater.doSum(12, 3, 2);

		assertThat(actualResult).isEqualTo(exceptedResult);

	}
     
	@Test
	void testProduct() {

		// expected
		int exceptedResult = 24;

		// actual
		int actualResult = calculater.doProduct(12, 2);

		assertThat(actualResult).isEqualTo(exceptedResult);

	}

}
