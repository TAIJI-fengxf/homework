## 国际化登录作业
>项目：[homework-login](https://github.com/TAIJI-fengxf/homework/tree/master/homework-login)
## mangoDB圆形范围查询、图书页数范围查询作业
>项目：[homework-mangodb](https://github.com/TAIJI-fengxf/homework/tree/master/homework-mongodb)
## redis实现3次登录失败后限制5分钟作业
>项目：[homework-redis](https://github.com/TAIJI-fengxf/homework/tree/master/homework-redis)
## Redis 在Windows添加服务----->开启服务的口令
    - 添加Redis服务：
redis-server.exe --service-install redis.windows.conf --loglevel verbose
    -开启服务
redis-server --service-start

## MongoDB添加服务
- mongod.exe --logpath E:\mongodb\server\4.0\log\mongodb.log --logappend --dbpath E:\mongodb\server\4.0\data --directoryperdb --serviceName MongoDB –install
- mangodb添加服务口令 在redis文件夹下的cmd窗口 logpath和dbpath根据自己存储位置更改


## 3-22日上午
>案例[demo](https://github.com/TAIJI-fengxf/homework/tree/master/demo)：
- 基于XML的容器配置：
将配置文件的classpath传入ApplicationContext的对象中，在控制台输出Beans的个数，遍历每个bean的名称和全类名利用反射机制从ApplicationContext的对象中得到指定Bean的全类名并输出
## 3-22日下午
>案例[demo-1](https://github.com/TAIJI-fengxf/homework/tree/master/demo-1)：
- 利用注解配置：需要先在pom配置文件插入Commons组件的依赖，
>出现的问题：
- javax.management.InstanceNotFoundException: org.apache.commons.dbcp2:name=da
org.apache.commons.dbcp2:name=dataSource,type=BasicDataSource at com.sun.jmx.interceptor.DefaultMBeanServerInterce...
>已解决-解决办法：
-  .m2目录下的本地库中存在坏包：
     - （1）在工作空间的当前项目路径下打开doc窗口，键入：mvn -Pnexus dependency:resolve
      -  （2）删掉本地库的相关依赖包，打开sts更新项目重新下载依赖包
  
