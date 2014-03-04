package sk.mk.persistence.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 4.3.2014
 * Time: 9:25
 */
public class Project implements Serializable {

    private static final long serialVersionUID = 1871445041745723040L;

    private String id;
    private String name;
    private String abbreviation;
    private String customer;

    public String getId() {
        return id;
    }

    @XmlAttribute
    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    @XmlElement
    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getCustomer() {
        return customer;
    }

    @XmlElement
    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
