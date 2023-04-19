package cn.sixmillions.sixdb;

import cn.sixmillions.sixdb.entity.UploadHistory;
import cn.sixmillions.sixdb.mapper.UploadHistotyMapper;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
@Slf4j
public class SixDbApplicationTests {

    @Resource
    private UploadHistotyMapper uploadHistotyMapper;

    @Test
    public void dbConnectTest() {
        UploadHistory uploadHistory = UploadHistory.builder()
                .fileUrl("xxxx")
                .createdBy("sys")
                .createdTime(LocalDateTime.now())
                .build();
        log.info(JSON.toJSONString(uploadHistory));
        int insert = uploadHistotyMapper.insert(uploadHistory);
        log.info("插入结果：{}", insert);
    }

}
