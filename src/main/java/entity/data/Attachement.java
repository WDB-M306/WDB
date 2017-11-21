package entity.data;

import javax.persistence.*;
import java.util.Date;

@Entity
@NamedQueries({
        @NamedQuery(name = "User.findAttatchementById", query = "SELECT a FROM Attachement AS a WHERE a.id = ?1"),
        @NamedQuery(name= "User.findAttachementByDate", query = "SELECT a FROM Attachement AS a WHERE a.date = ?1")
})
public class Attachement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String fileName;
    private long size;
    private Date date;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    public long getSize() {
        return size;
    }
    public void setSize(long size) {
        this.size = size;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}