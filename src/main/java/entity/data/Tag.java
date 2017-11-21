package entity.data;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Tag.findTagById", query = "SELECT t FROM Tag AS t WHERE t.id = ?1"),
        @NamedQuery(name= "Tag.findTagByname", query = "SELECT t FROM Tag AS t WHERE t.name = ?1")
})
public class Tag {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;
    private String entries;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEntries() {
        return entries;
    }
    public void setEntries(String entries) {
        this.entries = entries;
    }
}
