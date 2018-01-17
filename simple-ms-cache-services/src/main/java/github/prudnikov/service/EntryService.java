package github.prudnikov.service;

import github.prudnikov.pojo.Entry;

public interface EntryService {

    void saveOrUpdate(Entry entry);

    Entry findByKey(String key);

    void delete(String key);
}
