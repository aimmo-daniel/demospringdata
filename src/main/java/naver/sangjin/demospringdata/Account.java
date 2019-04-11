package naver.sangjin.demospringdata;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity //Account 테이블에 매핑이 된다고 알려주는
public class Account {

    @Id @GeneratedValue //(주키 / 자동으로 생성되는 값을 사용하겠다)
    private Long id;

    //모든 컬럼에는 @Column 에노테이션이 생략되어있으나 추가옵션을 설정하고 싶을때 직접 명시
    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @OneToMany(mappedBy = "owner") //주인한테 관계를 설정해야 DB에 양방향 관계로 반영됨
    private Set<Study> studies = new HashSet<>();

    public Set<Study> getStudies() {
        return studies;
    }

    public void setStudies(Set<Study> studies) {
        this.studies = studies;
    }

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

    public void addStudy(Study study) {
        this.getStudies().add(study);
        study.setOwner(this);
    }

    public void removeStudy(Study study) {
        this.getStudies().remove(study);
        study.setOwner(null);
    }
}
