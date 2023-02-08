package com.company.goodigruha;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class GoodIgruhaApplicationTests {

	@Test
	void contextLoads() {
		assertThat(3).isEqualTo(3);
	}

}