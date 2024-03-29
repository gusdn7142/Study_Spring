package hello.springtx.order;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//Order 엔티티 생성
@Entity
@Table(name = "orders")  //order는 DB 예약어이기 떄문에 사용 불가
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String username; //정상, 예외, 잔고부족
    private String payStatus; //대기, 완료

}