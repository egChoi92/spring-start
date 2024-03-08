package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        MemberServiceImpl memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "MemberA", Grade.VIP);
        memberService.join(memberA);

        Member findMemberA = memberService.findMember(1L);

        System.out.println("memberA = " + memberA.getName());
        System.out.println("findMemberA = " + findMemberA.getName());

    }
}
