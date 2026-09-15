package hello.ex04.computer;

import org.springframework.stereotype.Component;

@Component
public class MacBook {

    public void turnOn() {
        System.out.println("MacBook이 켜졌습니다.");
    }
}
