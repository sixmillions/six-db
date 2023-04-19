# 数据存储

# 说明

web控制台：http://localhost:3282/h2

1. `driver-class-name: org.h2.Driver` 可省略
2. `url: jdbc:h2:./db/sixdb` 相对路径，相对于当前工作目录（也就是db文件夹src文件夹平级）
3. `DATABASE_TO_LOWER=TRUE` 将所有创建的数据库对象名（表名、列名等）转换为小写
4. `AUTO_SERVER=TRUE` 混合模式启动，应用程序访问的同时，还以用网页访问（也是项目中配置了访问路径），但是用别的应用程序访问还是不可以的
5. `MODE=MYSQL` 使用MySQL语法解析特定的数据类型、语法和函数。也就尽可能兼容MySQL，但归根到底不一样
6. 第五条补充：https://github.com/h2database/h2database/issues/3446