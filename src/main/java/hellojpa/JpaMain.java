package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            //상속관계 매핑
            Movie movie = new Movie();
            movie.setDirector("aaaa");
            movie.setActor("bbbb");
            movie.setName("트랜스포머");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Movie findmovie = em.find(Movie.class, movie.getId());
            System.out.println("findmovie = " + findmovie);

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


            //회원 등록
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
            //회원 조회
//            Member findMember = em.find(Member.class, 1L);
            //회원 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
            //회원 수정
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
