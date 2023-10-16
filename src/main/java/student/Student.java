package student;
import javax.persistence.*;
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name="group_head")
    private boolean group_head;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isGroup_head() {
        return group_head;
    }

    public void setGroup_head(boolean group_head) {
        this.group_head = group_head;
    }

    public student.Student getGroup() {
        return group;
    }

    public void setGroup(student.Student group) {
        this.group = group;
    }
}
