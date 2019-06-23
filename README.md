# WebService

作为Android开发者学习了解后端的入门项目

## 软件

* IntelliJ IDEA 2018.2.5 (破解版,ε=ε=ε=┏(゜ロ゜;)┛)
* mysql-8.0.16-winx64
* Navicat Premium (数据库可视化软件)



### IEDA 破解方式(适用于2018.2.5版本)

1.安装idea

可以去官网下载，我也上传到网盘了，毕竟其他版本下面的jar包破解可能不起作用。

https://pan.baidu.com/s/1TJ0BQjRp5mS3tMW2eS68kQ  提取码：4h89

2.下载一个JetbrainsCrack-3.1-release-enc.jar放到bin目录下

https://pan.baidu.com/s/1Qll3AK3hW72f8LKncDyVsQ  提取码：gn8y 

3.idea64.exe.vmoptions和idea.exe.vmoptions两个文件分别新增一行代码

-javaagent:../bin/JetbrainsCrack-3.1-release-enc.jar

4.打开idea，激活方式选择active code，复制以下代码

```json
ThisCrackLicenseId-{
"licenseId":"ThisCrackLicenseId",
"licenseeName":"xxx",
"assigneeName":"xxx",
"assigneeEmail":"xxx",
"licenseRestriction":"For This Crack, Only Test! Please support genuine!!!",
"checkConcurrentUse":false,
"products":[
{"code":"II","paidUpTo":"2099-12-31"},
{"code":"DM","paidUpTo":"2099-12-31"},
{"code":"AC","paidUpTo":"2099-12-31"},
{"code":"RS0","paidUpTo":"2099-12-31"},
{"code":"WS","paidUpTo":"2099-12-31"},
{"code":"DPN","paidUpTo":"2099-12-31"},
{"code":"RC","paidUpTo":"2099-12-31"},
{"code":"PS","paidUpTo":"2099-12-31"},
{"code":"DC","paidUpTo":"2099-12-31"},
{"code":"RM","paidUpTo":"2099-12-31"},
{"code":"CL","paidUpTo":"2099-12-31"},
{"code":"PC","paidUpTo":"2099-12-31"}
],
"hash":"2911276/0",
"gracePeriodDays":7,
"autoProlongated":false}
```



### MySql数据库软件安装

1.<a href="<http://dev.mysql.com/downloads/mysql/>">MySql下载</a>

2.解压完成后，在该文件夹下创建my.ini配置文件，编辑：

```ini
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
 
[mysqld]
# 设置3306端口
port = 3306
# 设置mysql的安装目录
basedir=你的安装目录
# 设置 mysql数据库的数据的存放目录，MySQL 8+ 不需要以下配置，系统自己生成即可，否则有可能报错
# datadir=你的安装目录
# 允许最大连接数
max_connections=20
# 服务端使用的字符集默认为8比特编码的latin1字符集
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
```

3.操作MySQL数据库

打开cmd命令行，cd到mysql的bin目录下

* 初始化数据库

```mysql
mysqld --initialize --console
```

得到初始化密码，用户名root

* 安装命令

```mysql
mysqld install
```

* 启动服务

```mysql
net start mysql
```

* 登陆数据库

```mysql
#-h是指定MySQL主机名，登陆本机的可以忽略
mysql -h 主机名 -u 用户名 -p
#所以登陆本机的数据库是这个
mysql -u root -p
#回车输入密码，输入初始化密码
Enter password:
```

* 登陆之后，接着修改密码

```mysql
#修改密码为123456
ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
```

* 创建数据库

```
# 创建数据库
create DATABASE app_service_db;
# 展示所有数据库
show databases;
```

* 关闭服务

```mysql
net stop mysql
```



### 下载mysql可视化软件navicat

http://pan.baidu.com/s/1o87hFN8 提取码：qxkg

操作比较简单，连接选择MySQL，填入连接名(这个自己定)和密码



> 工欲善其事必先利其器，先把上面三个软件安装完成

