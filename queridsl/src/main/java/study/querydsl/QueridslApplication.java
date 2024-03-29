package study.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;

@SpringBootApplication
public class QueridslApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueridslApplication.class, args);
	}

//	@Bean
//	JPAQueryFactory jpaQueryFactory(EntityManager em){
//		return new JPAQueryFactory(em);
//	}

}
