package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        OCP, DIP 위반
//        MemberServiceImpl memberService = new MemberServiceImpl();

//        OCP, DIP 준수
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        스프링 프레임워크 사용
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member memberA = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Member findMemberA = memberService.findMember(1L);

        System.out.println("memberA = " + memberA.getName());
        System.out.println("findMemberA = " + findMemberA.getName());

    }
}
