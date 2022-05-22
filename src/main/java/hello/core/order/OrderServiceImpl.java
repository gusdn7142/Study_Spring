package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


//    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    //주문 생성
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);   //회원 조회
        int discountPrice = discountPolicy.discount(member, itemPrice);  //할인 금액 조회


        //주문 객체 생성후 리턴
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }



    //테스트 코드
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }



}