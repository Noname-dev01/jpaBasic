package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Member {

    @Id //PK 매핑
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") //컬럼명 지정
    private String username;


    @Enumerated(EnumType.STRING) //Enum 타입을 쓰려면 이 애노테이션을 쓰면 된다.
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP) //DATE=날짜,TIME=시간,TIMESTAMP=날짜,시간 둘다 포함된것
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob //varchar를 넘어서는 큰 컨테츠를 넣고싶으면 @Lob
    private String description;
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
    public RoleType getRoleType() {
        return roleType;
    }
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Member() {

    }
}
