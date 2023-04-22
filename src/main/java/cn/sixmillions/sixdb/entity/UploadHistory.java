package cn.sixmillions.sixdb.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UploadHistory {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String fileUrl;
    private String fileName;
    private String fileS3Url;
    private String fileNewName;
    private String vendor;
    private String bucketName;
    private String filePath;
    private Integer fileSize;
    private String mediaType;
    private String suffix;
    private String createdBy;
    private LocalDateTime createdTime;
}
