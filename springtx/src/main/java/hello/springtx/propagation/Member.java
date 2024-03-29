package hello.springtx.propagation;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    public Member() {   //JPA는 기본 스펙으로 기본생성자 필요
    }

    public Member(String username) {
        this.username = username;
    }

}