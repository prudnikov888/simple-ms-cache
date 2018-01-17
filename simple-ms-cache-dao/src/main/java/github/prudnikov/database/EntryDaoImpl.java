package github.prudnikov.database;

import github.prudnikov.pojo.Entry;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDaoImpl implements EntryDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession(){
        return sessionFactory.getCurrentSession();
    }

    public void saveOrUpdate(Entry entry) {
        getCurrentSession().saveOrUpdate(entry);
    }

    public Entry findByKey(String key) {
        Entry entry = getCurrentSession().get(Entry.class, key);
        if (entry == null) {
            throw new ObjectNotFoundException(key, "");
        }
        return entry;
    }

    public void delete(String key) {
        Entry entry = findByKey(key);
        getCurrentSession().delete(entry);
    }
}
