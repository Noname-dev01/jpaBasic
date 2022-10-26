package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id //PK 매핑
    private Long id;

    @Column(name = "name") //컬럼명 지정
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING) //Enum 타입을 쓰려면 이 애노테이션을 쓰면 된다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //DATE=날짜,TIME=시간,TIMESTAMP=날짜,시간 둘다 포함된것
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar를 넘어서는 큰 컨테츠를 넣고싶으면 @Lob
    private String description;

    public Member() {

    }
}
