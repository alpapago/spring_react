package com.in28minutes.learingspinngframework.helloworld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// record : jdk 16에서 추가된 기능 등호, 해시코드, 두 개의 스트링으로 구성된 메서드를 만들어야 함.
// java bean 

record Person(String name, int age, Address address) {};
record Address(String firstLine, String city) {};

@Configuration
public class HelloWorldConfiguration {
	
	@Bean
	public String name() {
		return "Ranga";
	} 
	
	@Bean
	public int age() {
		return 15;
	}
	
	@Bean
	public Person person() {
		return new Person("Ravi",20, new Address("Main Street","Utrecht"));
	}

	@Bean
	public Person person2MethodCall() {
		return new Person(name(),age(),address());
	}
	
	@Bean
	public Person person3MethodCall(String name, int age, Address address3) {
		return new Person(name, age, address3);
	}
	
	@Bean(name = "address2")
	public Address address() {
		var address = new Address("Baker Street","London");
		return address;
	}

	@Bean(name = "address3")
	public Address address3() {
		var address = new Address("Motinagar","Hyderabad");
		return address;
	}
}
