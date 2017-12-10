package ru.cbr.task.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.cbr.task.entity.Record;

import java.util.List;

@Repository
public interface RecordRepository extends JpaRepository<Record, String> {
    List<Record> findAllByRgn(String rgn);
    List<Record> findAllByPzn(String pzn);
    List<Record> findAllByRkc(String rkc);
    List<Record> findAll();

}
