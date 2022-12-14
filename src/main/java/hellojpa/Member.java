package hellojpa;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.Lock;

@Entity
public class Member{

    @Id //PK 매핑
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME") //컬럼명 지정
    private String username;
    @Embedded
    private Address homeAddress;
    @ElementCollection
    @CollectionTable(name = "FAVORITE_FOOD", joinColumns =
        @JoinColumn(name = "MEMBER_ID"))
    @Column(name = "FOOD_NAME")
    private Set<String> favoriteFoods = new HashSet<>();
    @ElementCollection
    @CollectionTable(name = "ADDRESS", joinColumns =
    @JoinColumn(name = "MEMBER_ID"))
    private List<Address> addressHistory = new ArrayList<>();

    //Period
//    private LocalDateTime startDate;
//    private LocalDateTime endDate;
//    @Embedded
//    private Period workPeriod;

    //Address
//    private String city;
//    private String street;
//    private String zipcode;
//    @Embedded
//    private Address homeAddress;
//
//    @Embedded
//    @AttributeOverrides({@AttributeOverride(name = "city",column = @Column(name = "WORK_CITY")),
//            @AttributeOverride(name = "street",column = @Column(name = "WORK_STREET")),
//            @AttributeOverride(name = "zipcode",column = @Column(name = "WORK_ZIPCODE"))
//    })
//    private Address workAddress;

//    @Enumerated(EnumType.STRING) //Enum 타입을 쓰려면 이 애노테이션을 쓰면 된다.
//    private RoleType roleType;

    /**
     * fetch = FetchType.Lazy --> 지연 로딩
     * fetch = FetchType.EAGER --> 즉시 로딩 (실무에서는 가급적 사용하지 않고 지연로딩을 사용해야한다.)
     */
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;

//@ManyToMany는 실무에서 사용불가
//    @ManyToMany
//    @JoinTable(name = "MEMBER_PRODUCT")
//    private List<Product> products = new ArrayList<>();

//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
//    @Temporal(TemporalType.TIMESTAMP) //DATE=날짜,TIME=시간,TIMESTAMP=날짜,시간 둘다 포함된것
//    private Date createDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;

//    @Lob //varchar를 넘어서는 큰 컨테츠를 넣고싶으면 @Lob
//    private String description;


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


    public Address getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {
        this.homeAddress = homeAddress;
    }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<Address> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<Address> addressHistory) {
        this.addressHistory = addressHistory;
    }
}
