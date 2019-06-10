package naver.sangjin.demospringdata;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository<T, Id extends Serializable> extends Repository{

    <E extends T> E save(E entity);

    List<T> findAll();

    long count();

}
