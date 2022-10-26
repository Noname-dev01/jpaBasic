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
            //비영속 상태
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA");
            //persist하면서 영속 상태되고 DB에 저장되는 상태는 아니다.
            em.persist(member);


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
