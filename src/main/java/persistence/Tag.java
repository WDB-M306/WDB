package persistence;

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
    private string name
    private string entries

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public string getName() {
        return name;
    }
    public void setName(string name) {
        this.name = name;
    }
    public string getEntries() {
        return entries;
    }
    public void setEntries(string entries) {
        this.entries = entries;
    }
}
