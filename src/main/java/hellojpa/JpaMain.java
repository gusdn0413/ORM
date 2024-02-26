package hellojpa;

import hellojpa.item.Movie;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        //code

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("hello1");

            Member member2 = new Member();
            member2.setName("hello2");

            em.persist(member1);
            em.persist(member2);
            em.flush();
            em.clear();

            //
            Member m1 = em.getReference(Member.class, member1.getId());
            Member m2 = em.getReference(Member.class, member2.getId());
            System.out.println("===============================");
            System.out.println("===============================");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
