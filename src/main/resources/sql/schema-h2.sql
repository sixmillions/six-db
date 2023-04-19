DROP TABLE IF EXISTS upload_history;

CREATE TABLE upload_history
(
    id           BIGINT(20) AUTO_INCREMENT PRIMARY KEY COMMENT '文件ID',
    file_url     VARCHAR(100) NULL     DEFAULT NULL COMMENT '文件url',
    file_name    VARCHAR(100) NULL     DEFAULT NULL COMMENT '文件名',
    file_s3_url  VARCHAR(100) NULL     DEFAULT NULL COMMENT 's3类型url',
    file_path    VARCHAR(100) NULL     DEFAULT NULL COMMENT '路径',
    created_by   VARCHAR(20)  NOT NULL DEFAULT 'sys' COMMENT '上传人',
    created_time VARCHAR(50)  NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间'
);