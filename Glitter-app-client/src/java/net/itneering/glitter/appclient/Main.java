package net.itneering.glitter.appclient;

import java.util.List;
import javax.ejb.EJB;
import net.itneering.glitter.ejb.GlitterPost;
import net.itneering.glitter.ejb.GlitterPostEJBRemote;

public class Main {

    @EJB
    private static GlitterPostEJBRemote glitterPostEJB;

    public static void main(String[] args) {
        List<GlitterPost> list = glitterPostEJB.findPosts();
        System.out.println(list);
        glitterPostEJB.createPost(new GlitterPost("Testuser", "Test message"));
        list = glitterPostEJB.findPosts();
        System.out.println(list);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GlitterJFrame().setVisible(true);
            }
        });
    }

}
