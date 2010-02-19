package net.itneering.glitter.ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class GlitterPostEJB implements GlitterPostEJBRemote {

    @PersistenceContext(unitName = "GlitterPU")
    private EntityManager em;

    public GlitterPost createPost(GlitterPost post) {
        em.persist(post);
        return post;
    }

    public void deletePost(GlitterPost post) {
        em.remove(em.merge(post));
    }

    public GlitterPost updatePost(GlitterPost post) {
        return em.merge(post);
    }

    public List<GlitterPost> findPosts() {
        Query query = em.createNamedQuery("findAllPosts");
        return query.getResultList();
    }

    public GlitterPost findPostById(Long id) {
        return em.find(GlitterPost.class, id);
    }
}
