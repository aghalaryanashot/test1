package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Это говорит Hibernate сделать таблицу из этого класса

public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String frst;
    private String last;

    public Message() {
    }

    public Message(String frst, String last) {
        this.frst = frst;
        this.last = last;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrst() {
        return frst;
    }

    public void setFrst(String frst) {
        this.frst = frst;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }
}
