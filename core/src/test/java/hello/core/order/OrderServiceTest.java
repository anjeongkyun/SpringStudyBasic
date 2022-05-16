package hello.core.order;

import hello.core.discount.order.Order;
import hello.core.discount.order.OrderService;
import hello.core.discount.order.OrderServiceImpl;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.craeteOrder(memberId,"itemA",20000);

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
