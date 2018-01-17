package github.prudnikov.database;

import github.prudnikov.pojo.Entry;

public interface EntryDao {

    void saveOrUpdate(Entry entry);

    Entry findByKey(String key);

    void delete(String key);
}
