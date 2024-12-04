package com.example.lsi1;

import com.example.lsi1.data.Car;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class Lsi1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	public void test(){
		Car car = new Car("AA1122", "Ferrari", 1000);
		assertTrue(car.getBrand().equals("Ferrari"));
	}

}
