package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach // 테스트 실행 전에 무조건 실행
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given
        Member memberA = new Member(1L, "MemberA", Grade.VIP);

        // when
        memberService.join(memberA);
        Member findMemberA = memberService.findMember(1L);

        // then
        Assertions.assertThat(memberA).isEqualTo(findMemberA);
    }
}
