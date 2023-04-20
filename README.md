# 数据存储

web控制台：http://localhost:3282/h2

# replit

从github导入

> https://github.com/sixmillions/six-db.git

```
# .replit文件
compile = "mvn clean compile"
run = "mvn spring-boot:run"
```

# 说明

## 连接参数

> https://blog.csdn.net/kanpiaoxue/article/details/84925846
> https://blog.csdn.net/sinat_36695865/article/details/108573354
> https://www.coder.work/article/1413295

设置了连接参数，就不要乱修改了，防止破坏数据库；  
如果修改了连接参数，可以将事先导出的数据导入新数据库

1. `DATABASE_TO_LOWER=TRUE` 将所有创建的数据库对象名（表名、列名等）转换为小写

2. `AUTO_SERVER=TRUE` 混合模式启动，应用程序访问的同时，网页和其他应用程序都可以访问，但是需要用相同的连接参数
   
   https://h2database.com/html/features.html#auto_mixed_mode
   例如：当前程序用 `jdbc:h2:./db/sixdb;AUTO_SERVER=TRUE` 连接，其他可以使用 `jdbc:h2:D:\workspaces\six-db\db\sixdb;AUTO_SERVER=TRUE` 连接，只要找到对应的路径即可
   
3. `MODE=MYSQL` 使用MySQL语法解析特定的数据类型、语法和函数。也就尽可能兼容MySQL，但归根到底不一样

## 命令

```sql
--查看表/schema
show tables;
show schemas;

--查看user表列结构
show columns from ts_user;

--修改密码/用户名
ALTER USER sa SET PASSWORD 'new_password';
ALTER USER six RENAME TO sixdba;
```

### 修改默认用户名

> [Commands (h2database.com)](http://h2database.com/html/commands.html#alter_user_admin)

数据开始时候创建了一个用户名，默认是sa，按理说是不能修改的，但是有个折中方法  

先创建一个admin用户，然后再删除sa用户

```sql
CREATE USER sixdba PASSWORD '123';
ALTER USER sixdba ADMIN TRUE;
DROP USER sa;
```

**注意：**操作有风险，注意先备份

## H2DRIVERS

可以使用h2控制台连接其他类型数据库，但是需要增加数据库驱动

https://localhost:8082/help.jsp

> 可以通过添加系统环境变量H2DRIVERS 或者 CLASSPATH 来增加数据库驱动注册。
> 例如（Windows）：要增加数据库驱动C:/Programs/hsqldb/lib/hsqldb.jar，
> 可以增加系统环境变量H2DRIVERS并设置到C:/Programs/hsqldb/lib/hsqldb.jar。

这种方式只能添加一个，可以修改启动脚本，将驱动加入进去

这里我修改了 `bin/h2.bat` （h2.bat启动会有一个cmd窗口，h2w.bat启动没有cmd窗口，也就是后台启动）

1. 提前下载（从maven仓库copy）驱动jar包，在`bin`同级目录下建了一个 `drivers` 文件夹（也可以不建立）
2. 写上驱动具体路径

```bat
@java -cp "h2-2.1.214.jar;%H2DRIVERS%;%CLASSPATH%;E:\OpenSources\h2-2022-06-13\h2\drivers\mysql-connector-java-8.0.29.jar;E:\OpenSources\h2-2022-06-13\h2\drivers\postgresql-42.5.4.jar" org.h2.tools.Console %*
@if errorlevel 1 pause
```

## Q1

第一次建好数据库之后，就不要修改连接参数，不然会连不上

例如：  
第一启动没有加参数 `DATABASE_TO_LOWER=TRUE`，也就是默认建立表，schema等都是大写  
这时候你如果加上该参数，就会连接不上，提示找不到 `PUBLIC` schema  
因为开始建立的public是大写的，现在改成小写就找不到了  
用 `show tables` 就能看到属于哪个schema  
通用可以使用下面验证，在加了参数的数据库执行

```text
create schema "PUBLIC"
show schemas;
```

发现大写和小写的都存在，这一点和pg差不多

建议不加，用最少的配置

## Q2

如果你在第一次启动 H2 数据库时忘记设置密码，后面可以通过以下步骤来设置密码：

1. 连接到 H2 数据库，使用 sa 用户或其他有管理员权限的用户进行操作
2. 设置密码： `ALTER USER sa SET PASSWORD 'new_password';`
3. 重新连接

## 其他

1. `driver-class-name: org.h2.Driver` 可省略
2. `url: jdbc:h2:./db/sixdb` 相对路径，相对于当前工作目录（也就是db文件夹src文件夹平级）
