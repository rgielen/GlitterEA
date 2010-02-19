package net.itneering.glitter.ejb;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 *
 * @author rene
 */
@Entity
@NamedQuery(name = "findAllPosts",
query = "SELECT p FROM GlitterPost p ORDER BY p.id DESC")
public class GlitterPost implements Serializable {

    private static final long serialVersionUID = 1L;

    public GlitterPost() {
    }

    public GlitterPost(String username, String content) {
        this.username = username;
        this.content = content;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String username;
    @Column(length = 2000)
    private String content;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GlitterPost)) {
            return false;
        }
        GlitterPost other = (GlitterPost) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("<")
                .append(username).append("> ")
                .append(content);
        return sb.toString();
    }
}
