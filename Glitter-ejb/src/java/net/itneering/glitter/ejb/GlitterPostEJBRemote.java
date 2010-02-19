package net.itneering.glitter.ejb;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface GlitterPostEJBRemote {

    public List<GlitterPost> findPosts();

    public GlitterPost createPost(GlitterPost post);
    
}
