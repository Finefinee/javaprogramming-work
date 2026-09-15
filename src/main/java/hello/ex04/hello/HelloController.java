package hello.ex04.hello;

import hello.ex04.computer.Computer;
import hello.ex04.computer.MacBook;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Tag(name = "01")
@RestController
public class HelloController {

    @Autowired
    private Computer computer;

    private final MacBook macBook;

    public HelloController(MacBook macBook) {
        this.macBook = macBook;
    }

    @GetMapping("/macbook")
    public String macBook() {
        System.out.println("macBook = " + macBook);
        return "Hello MacBook";
    }

    @GetMapping("/computer")
    public String computer() {
        computer.turnOn();
        return "computer";
    }

    @GetMapping("/api/product")
    @Operation(summary = "상품 정보를 반환합니다.", description = "상품 정보를 반환합니다.")
    public Map<String, Object> product(@Parameter(description = "상품명 입력", example = "연필") @RequestParam(defaultValue = "연필") String productName) {

        return Map.of("productName", productName, "stock", productName.length() * 10);
    }

    @GetMapping("/api/hello")
    @Operation(summary = "이름을 보내시면 인사힙니다.", description = "이름을 보내시면 인사힙니다. 이름을 보내지 않으면 익명으로 인사힙니다.")
    public Map<String, Object> hello(@Parameter(description = "이름 보내시면 되는 파라미터", example = "홍길동") @RequestParam(defaultValue = "익명") String name

    ) {
        System.out.println("hello " + name);
        return Map.of("message", "Hello, World!");
    }

    @PostMapping("/api/data")
    public Map<String, Object> data(@RequestBody Map<String, Object> body) {
        System.out.println("data " + body);
        return Map.of("message", "/api/data");
    }
}
