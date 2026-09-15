package hello.ex04;

import hello.ex04.computer.Computer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ex04Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Ex04Application.class, args);
        System.out.println(context.getBeanDefinitionCount());

        Computer computer1 = context.getBean(Computer.class);
        Computer computer2 = context.getBean(Computer.class);
        Computer computer3 = context.getBean(Computer.class);

        System.out.println(computer1 == computer2);
        System.out.println(computer1 == computer3);

//        String[] beanNames = context.getBeanDefinitionNames();
//        for (String beanName : beanNames) {
//            System.out.println(beanName);
//        }

        // 수행평가
        // String[]을 Stream으로 변환 후 forEach문으로 출력
        // predicate function supplier consumer
        // new vs Spring Container : new는 관리 주체가 개발자, Spring Container는 Spring Framework
    }

}
