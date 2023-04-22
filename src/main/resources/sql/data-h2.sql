insert into APP_INFO (MSG)
values ('app start');

INSERT INTO UPLOAD_HISTORY (ID, FILE_URL, FILE_NAME, FILE_S3_URL, FILE_NEW_NAME, VENDOR, BUCKET_NAME, FILE_PATH,
                            FILE_SIZE, MEDIA_TYPE, SUFFIX, CREATED_BY, CREATED_TIME)
SELECT 1,
       'https://s.6bw.fun/0/logo.png',
       'logo.png',
       'https://six-b2-f0.s3.us-west-004.backblazeb2.com/logo.png',
       'logo.png',
       'B2',
       'six-b2-f0',
       'logo.png',
       7,
       'image/png',
       'png',
       'SYS',
       '2023-04-19 00:00:00'
WHERE NOT EXISTS(
        SELECT 1 FROM UPLOAD_HISTORY WHERE ID = 1
    );

