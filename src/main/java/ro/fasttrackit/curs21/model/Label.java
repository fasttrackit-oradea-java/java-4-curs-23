package ro.fasttrackit.curs21.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Label {
    @Id
    @GeneratedValue
    private int id;

    @Column(unique = true, nullable = false)
    private String label;

    public Label() {
    }

    public Label(String label) {
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
