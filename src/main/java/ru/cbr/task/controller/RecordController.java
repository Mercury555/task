package ru.cbr.task.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.cbr.task.entity.Record;
import ru.cbr.task.service.RecordService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/records")
@Api(description = "Work with records")
public class RecordController {
    private final RecordService recordService;

    @Autowired
    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @RequestMapping(path = "/searchAllByPzn", params = {"pzn"}, method = RequestMethod.GET)
    public List<Record> searchAllByPZN(@RequestParam String pzn) {
        return recordService.findAllByPzn(pzn);
    }

    @RequestMapping(path = "/searchAllByRkc", params = {"rkc"}, method = RequestMethod.GET)
    public List<Record> searchAllByRkc(@RequestParam String rkc) {
        return recordService.searchAllByRkc(rkc);
    }

    @RequestMapping(path = "/searchAllByRgn", params = {"rgn"}, method = RequestMethod.GET)
    public List<Record> searchAllByRgn(@RequestParam String rgn) {
        return recordService.searchAllByRgn(rgn);
    }

    @RequestMapping(path = "/searchByVkey", params = {"vkey"}, method = RequestMethod.GET)
    public Record searchByVkey(@RequestParam String vkey) {
        return recordService.searchByVkey(vkey);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Record> searchAll() {
        return recordService.findAll();
    }



    //    @RequestMapping(method = RequestMethod.POST)
//    public void save(@PathVariable long recordId, @RequestBody Record record) {
//        recordService.save(record);
//    }
    @RequestMapping(method = RequestMethod.POST)
    public void save(@RequestBody Record record){
        recordService.save(record);
    }

    @RequestMapping(path = "/{vkey}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String vkey){
        recordService.delete(vkey);
    }
}
