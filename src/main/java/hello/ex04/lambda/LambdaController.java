package hello.ex04.lambda;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@RestController
public class LambdaController {

    @GetMapping("/lambda")
    public String lambda() {
        double random = Math.random();
        return String.valueOf(random);
    }

    // calculate 인터페이스 만들어서 람다 정의 후 return으로 두 수 합과 차를 구해보자
    @GetMapping("/calculate")
    public Map<String, Integer> calculate(@RequestParam int a, @RequestParam int b) {

        Calculate plusCalculate = (x, y) -> x + y;
        int hap = plusCalculate.operate(a, b);

        Calculate subCalculate = (x, y) -> x - y;
        int cha = subCalculate.operate(a, b);

        return Map.of("a", a, "b", b, "합", hap, "차", cha);
    }

    @GetMapping("/make-stream")
    public String makeStream() {
        String[] strings = new String[]{"aa", "bb", "cc", "eee", "dd", "kkk", "oo"};
        Stream<String> stream = Stream.of(strings);
        long count = stream.filter(s -> s.length() == 2)
                .count();

        return "make-stream count = " + count;
    }

    @GetMapping("/stream-map")
    public String streamMap() {
        String[] arr = {"aa", "bb", "cc", "eee", "dd", "kkk", "oo"};
        Stream<String> stream = Stream.of(arr);
        List<Integer> list = stream.map((str) -> str.length())
                .toList();

        return "streamMap count = " + list;
    }

    // from, to를 받아서 intStream.range(from, to를 사용해
    // 짝수 필터 후 개수 리턴, Map.of("count", 개수)
    @GetMapping("/even-count")
    public Map<String, ?> evenCount(@RequestParam int from, @RequestParam int to) {

        Stream<Integer> stream = IntStream.range(from, to + 1)
                .filter(i -> i % 2 == 0).boxed();
        List<Integer> list = stream.toList();
        long count = list.stream().count();
        return Map.of("count", count, "filter", list);
    }
}

@FunctionalInterface
interface Calculate {
    int operate(int a, int b);
}
