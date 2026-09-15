package hello.ex04.controller;

import hello.ex04.entity.Member;
import hello.ex04.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor
@CrossOrigin
public class MemberController {

    /*
    ProductController - ProductService - ProductRepository - Product(Entity)

    GetMapping(products) - Product 테이블 전체
    GetMapping({id}) - Product id로 조회
     */

    private final MemberService memberService;

    @GetMapping
    public List<Member> findAll() {
        return memberService.findAll();
    }

    @GetMapping("/{id}")
    public Member findById(@PathVariable Long id) {
        System.out.println("id = " + id);
        Member member = memberService.findById(id);
        return member;
    }

}
