package github.prudnikov.pojo;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Entry implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "_key")
    private String key;

    @Column(name = "value")
    private String value;

    public Entry(){
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Entry entry = (Entry) o;

        return key.equals(entry.key);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(key);
    }
}
