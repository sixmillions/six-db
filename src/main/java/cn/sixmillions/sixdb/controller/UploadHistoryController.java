package cn.sixmillions.sixdb.controller;

import cn.sixmillions.sixdb.entity.UploadHistory;
import cn.sixmillions.sixdb.mapper.UploadHistotyMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/upload-history")
public class UploadHistoryController {

    @Resource
    private UploadHistotyMapper uploadHistotyMapper;

    @GetMapping
    public List<UploadHistory> list() {
        return uploadHistotyMapper.selectList(null);
    }

    @GetMapping("/{id}")
    public UploadHistory getById(@PathVariable Long id) {
        return uploadHistotyMapper.selectById(id);
    }

    @PostMapping
    public int save(@RequestBody UploadHistory uploadHistory) {
        return uploadHistotyMapper.insert(uploadHistory);
    }

    @DeleteMapping("/{id}")
    public int deleteByid(@PathVariable Long id) {
        return uploadHistotyMapper.deleteById(id);
    }
}
