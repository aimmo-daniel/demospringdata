package naver.sangjin.demospringdata;

import javax.persistence.*;
import java.util.Date;

@Entity //Account 테이블에 매핑이 된다고 알려주는
public class Account {

    @Id @GeneratedValue //(주키 / 자동으로 생성되는 값을 사용하겠다)
    private Long id;

    //모든 컬럼에는 @Column 에노테이션이 생략되어있으나 추가옵션을 설정하고 싶을때 직접 명시
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created = new Date();

    private String yes;

    @Transient //컬럼으로 매핑 하기 싫고 객체에서만 쓸때 붙여준다
    private String no;

    // getter, setter는 없어도 컬럼으로 매핑이 된다

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
