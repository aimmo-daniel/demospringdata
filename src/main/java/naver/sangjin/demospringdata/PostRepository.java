package naver.sangjin.demospringdata;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Query("SELECT new map (p.id AS id, p.title AS title) FROM Post p")
    List<Map<String, Object>> findAlls();

    Page<Post> findByTitleContains(String title, Pageable pageable);

    long countByTitleContains(String title);

}
