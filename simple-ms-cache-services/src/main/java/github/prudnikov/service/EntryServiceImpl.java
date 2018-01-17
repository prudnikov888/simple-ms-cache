package github.prudnikov.service;

import github.prudnikov.database.EntryDao;
import github.prudnikov.pojo.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class EntryServiceImpl implements EntryService {

    @Autowired
    private EntryDao entryDao;

    public void saveOrUpdate(Entry entry) {
        entryDao.saveOrUpdate(entry);
    }

    public Entry findByKey(String key) {
        return entryDao.findByKey(key);
    }

    public void delete(String key) {
        entryDao.delete(key);
    }
}
