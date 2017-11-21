package entity.domain;

public class TagEntity {

    private long id;
    private String name;
    private String entries;

    public TagEntity(String name, String entries) {
        this.name = name;
        this.entries = entries;
    }

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
