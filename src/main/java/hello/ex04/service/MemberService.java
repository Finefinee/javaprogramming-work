package hello.ex04.service;

import hello.ex04.entity.Member;
import hello.ex04.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findById(Long id) {
        Optional<Member> optionalMember = memberRepository.findById(id);
        return optionalMember.orElse(null);
    }
}
