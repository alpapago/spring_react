# Q1. Spring Container vs Spring Context vs IOC Container vs Application Context

<br>
<br>

## Spring Container vs Spring Context vs IOC Container

- 스프링은 Object의 생성과 관계 설정, 사용및 제거를 application code대신 독립된 container가 담당한다.
- 이를 컨테이너가 코드 대신 object에 대한 제어권을 가지고 있다고 해서 IoC(Inversion of Control)이라고 부른다.

 - 여기서 컨테이너란 스프링에서 자바 객체를 관리하는 공간을 말한다.
 - 자바 객체를 스프링에서는 빈(Bean)이라고 하는데 스프링 컨테이너에 이 빈의 생성부터 소멸까지를 개발자 대신 과니해주는 공간을 컨테이너라고 한다. 

  한줄요약하면, Spring Container = Spring Context = IOC Container 이고, spring bean의 생명 주기를 관리하는 것이 이들의 역할이다. 즉, class 와 input을 가지고 ready system을 만든다.

## Application Context

- 스프링에서는 IoC를 담당하는 컨테이너를 Bean factory 또는 Application Context라고 한다.
- Dependency Injection(DI)를 위한 bean factory에 엔터프라이즈 어플리케이션을 개발하는데 필요한 여러가지 컨테이너 기능을 추가한 것을 application context라고 부른다.

  한줄 요약하면, application context = IoC와 DI를 위한 bean factory + 어플리케이션 개발을 위한 컨테이너 기능
  
# Q2. Java Bean vs Spring Bean vs POJO

POJO 란 plain old java object의 준말로 거의 모든 java object를 의미한다. 

POJO와는 다르게 Java Bean이 되려면 3가지의 기준을 만족해야한다. 

1) public no-args constructor를 가질것
2) getter/setter를 가질것
3) Serializer 인터페이스를 구현한 형태일 

EJB(Enterprise Java Bean) 이라는 형태를 사용할 때 자주 사용되었지만 요즘엔 쓰지 않는다.

Spring Bean 은 스프링에서 생성, 사용, 소멸 등의 관리를 하는 객체를 의미한다. POJO나 Spring Bean이나 비슷한 말이다. 

# Q3. Spring 프레임워크가 관리하는 Bean을 모두 나열하려면 어떻게 해야할까?

import org.springframework.context.annotation.AnnotationConfigApplicationContext;해서, new AnnotationConfigApplicationContext 객체를 만든다음
context.getBeanDefinitionNames()를 하면, springframework가 관리하는 bean들의 이름을 모두 얻을 수 있다.

# Q4. DI시에 Bean이 여러개라면, 어떤것을 우선순위로 정해야할까?

@Primary annotation을 사용하면 된다. 
