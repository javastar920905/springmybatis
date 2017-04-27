# 说说整合这个单体应用的原因
* 现在公司里面都用分布式开发了,单体应用用到的比较少
所以我这个项目也只是服务于个人,譬如 我一直想着为我爸的小工厂写个订单管理系统,自家项目,用分布式就太累了
* 其二,自己写dome的时候,不能总是从头开始吧,checkout这个骨架也方便得多
* 其三,选择自己掌握的比较好的几个点做个总结,加深印象
* 其四,也在做两手准备,底下还有一个分布式的项目正在写,终究还是打工,要服务于企业的,当前应用是那个项目提取的简化版
* 其五,这是经过本人测试的项目,其他人要是想用现成的,可以按照下面步骤学会使用

# 这是spring mvc +mybatis的手脚架,目的于开箱即用
项目地址: https://github.com/javastar920905/springmybatis ,有兴趣的可以点击右上角的 的fork和star

# 使用要求:
java 8及以上
gradle
idea
git
tomcat 8
对上面工具不熟悉或忘记的,这里有本人开发环境搭建的总结
http://note.youdao.com/noteshare?id=3a89ea0236870588129e890a15e19fee&sub=A12129E8C3E14938969D4FF9963659E5

# 使用步骤:
1 克隆仓库到本地 git clone https://github.com/javastar920905/springmybatis.git
2 导入项目到 idea
3 gradle 刷新依赖,并且打包成war包 gradle clean assemble
4 发布到Tomcat(或者直接运行AppConfig.java中的 main方法)
访问 localhost:8080/index/

# 项目说明:
* 集成了spring boot + mybatis
配置数据源 resources/mybatis.properties (你需要一个m可用的myysql数据库 数据库的话这里提供一个docker版本的mysql 2017-06-20到期不再提供)
* 持久层添加 mybatis Generator 插件,用于生成常用的增删改查(实体类&&Mapper接口&&Mapper.xml)
Generator 配置文件位于 resources/generatorConfig.xml (修改生成文件的位置,以及数据表, 需要下载mysql驱动)
配置好配置文件以后 运行 com.ouzhx.repository.MybatisGeneratorRun.java 的main方法即可
* 持久层集成了flyway,用于数据库版本同步
首先在 resources/db.migration 按照对应的文件格式写新的sql V1__Init_db.sql(注意V1__这里必须有两条下划线)
运行 com.ouzhx.repository.FlyWaryRun.java 下的main方法即可往数据库自动生成表和数据

* spring boot 集成 spring mvc + freemark
静态页面 位于 resources/static,可以在WebMvcConfig.java中配置
ftl 页面位于 resources/templates

* 计划集成但是还没有集成的功能
web (Apache shiro /swagger ui /spring websocket+ 消息发布与订阅 (MQ/Redis)  ...)
repository (junit+dbutil做单元测试 /redis /elasticsearch+ ik分词器 ...)

# 相关项目进度
* 同时请关注下面项目进度,支持当前项目的分布式开发,使用motan做rpc框架,有多个分支
motan 注解配置实现方式 https://github.com/javastar920905/ssm-repository/tree/motan_annotation_config 
motan xml配置方式实现 https://github.com/javastar920905/ssm-repository/tree/motan_xml_config
master主分支,为稳定版本 https://github.com/javastar920905/ssm-repository 

* 其他小项目 https://github.com/javastar920905/spider-webmagic.git (这是一个用webmagic做的爬虫示例程序!)



