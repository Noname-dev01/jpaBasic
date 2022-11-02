package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            /** 값 타입과 불변 객체 */
            Address address = new Address("city", "street", "100");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(address);
            em.persist(member1);



            /** 임베디드 타입 */
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city","street","100"));
//            member.setWorkPeriod(new Period());
//
//            em.persist(member);
            /** 영속성 전이(CASECADE)와 고아 객체 */
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);

            /** 즉시 로딩과 지연 로딩 */
//            Team team = new Team();
//            team.setName("team");
//            em.persist(team);
//
//            Member member = new Member();
//            member.setUsername("member");
//            member.setTeam(team);
//            em.persist(member);
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member);
//            System.out.println("m.getTeam().getClass() = " + m.getTeam().getClass());
            /** 프록시 */
//            Member member = new Member();
//            member.setUsername("member1");
//            em.persist(member);
//
//            em.flush();
//            em.clear();
//
//            Member refMember = em.getReference(Member.class, member.getId());
//            System.out.println("refMember.getClass() = " + refMember.getClass()); //proxy
//            Hibernate.initialize(refMember); //강제 초기화

            /** Mapped Superclass - 매핑 정보 상속 */
//            Member member = new Member();
//            member.setCreateBy("kim");
//            member.setCreatedDate(LocalDateTime.now());
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();
            //조회 검색 불가(em.find(BaseEntity) 불가)
            /**
             * 상속관계 매핑
             */
//            Movie movie = new Movie();
//            movie.setDirector("aaaa");
//            movie.setActor("bbbb");
//            movie.setName("트랜스포머");
//            movie.setPrice(10000);
//
//            em.persist(movie);
//
//            em.flush();
//            em.clear();
//
//            Movie findmovie = em.find(Movie.class, movie.getId());
//            System.out.println("findmovie = " + findmovie);

            /** ??? */
//            Member member = new Member();
//            member.setUsername("member1");
//
//            em.persist(member);
//
//            Team team = new Team();
//            team.setName("teamA");
//            team.getMembers().add(member);
//
//            em.persist(team);
            //비영속 상태
//            Member member = new Member();
//            member.setId(100L);
//            member.setUsername("HelloJPA");
//            //persist하면서 영속 상태되고 DB에 저장되는 상태는 아니다.
//            em.persist(member);


            /** 회원 등록 */
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
            /** 회원 조회 */
//            Member findMember = em.find(Member.class, 1L);
            /** 회원 삭제 */
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
            /** 회원 수정 */
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");

            tx.commit();//커밋하는 시점에 영속성 컨텍스트에 있는 애가 쿼리로 DB로 날라간다.
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
