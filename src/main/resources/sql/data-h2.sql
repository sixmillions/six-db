DELETE
FROM upload_history;

INSERT INTO upload_history (id, file_url, file_name, file_s3_url, file_path, created_by, created_time)
VALUES (1, 'https://b2.6bw.fun/0/logo.png', 'logo.png', 'xxxx', 'logo.png', 'sys', '2023-04-19 00:00:00');