package ru.cbr.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.cbr.task.entity.Record;
import ru.cbr.task.repository.RecordRepository;

import java.util.List;

@Service
public class RecordService {

    private RecordRepository recordRepository;

    @Autowired
    public RecordService(RecordRepository recordRepository) {
        this.recordRepository = recordRepository;
    }

    public List<Record> searchAllByRkc(String rkc) {
        return recordRepository.findAllByRkc(rkc);
    }

    public List<Record> searchAllByRgn(String rgn) {
        return recordRepository.findAllByRgn(rgn);
    }

    public List<Record> findAllByPzn(String pzn) {
        return recordRepository.findAllByPzn(pzn);
    }

    public List<Record> findAll() {
        return recordRepository.findAll();
    }

    public void save(Record record) {
        recordRepository.save(record);
    }

    public void delete(String vkey) {
        recordRepository.delete(vkey);
    }

}
