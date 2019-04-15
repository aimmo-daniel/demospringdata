package naver.sangjin.demospringdata;

import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // JQPL (데이터베이스 테이블이 아닌, 엔티티 객체 모델 기반으로 쿼리 작성)
        // JPA 또는 하이버네이트가 해당 쿼리를 SQL로 변환해서 실행함
        TypedQuery<Post> query = entityManager.createQuery("SELECT p FROM Post AS p", Post.class);
        List<Post> posts = query.getResultList();
        posts.forEach(System.out::println);

        // Native Query
        List posts2 = entityManager.createNativeQuery("SELECT * FROM Post").getResultList();
        List<Post> post3 = entityManager.createNativeQuery("SELECT * FROM Post", Post.class).getResultList();
        posts2.forEach(System.out::println);
        post3.forEach(System.out::println);
    }

}
