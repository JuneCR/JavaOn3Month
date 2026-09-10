# Apached代码贡献学习笔记及记录

#### 9.7 创建第一个plugin插件

##### Mojo的核心逻辑

Mojo的本质：全称Maven plain Old Java Object

Mojo是一个可执行的构建目标,而插件就是由一个或多个Mojo组成的集合

Mojo需要具备一下核心要素  

​	1.目标名称(goal name):   用户执行时调用的名称

​        2.生命周期阶段(phase)：该Mojo 默认绑定到生命周期的哪个阶段

​        3.参数(parameters):用户可以通过Pom配置参数,用于定制行为

Java层面

​	一个mojo 需要继承 AbstractMojo 抽象类来实现Mojo接口

​	使用@Mojo注解标记,指定goal的名称和默认绑定的生命周期阶段

​        实现execute()方法  ---------这是mojo的核心入口,构建逻辑都在这里执行

实操

1. 创建java项目my-test-plugin  实现了AbstractMojo抽象类GreetingMojo

   重写了excute方法

   @Mojo(name = "sayhi") 告诉maven 插件名称

   @Parameter 开放了一个接口可以使用 pom标签来传值

   ![image-20260907222433278](C:\Users\30554\AppData\Roaming\Typora\typora-user-images\image-20260907222433278.png)

   2.在pom.xml中 <packing>maven-plugin</packing>告诉Maven这不是Jar包而是插件

​       引入了maven-plugin-api依赖 让代码可以使用AbstractMojo

​       <goalPrefix>greet</goalPrefix> maven命令设置

   3.将插件安装到本地  maven clean install -u 清理编译残留

​				       maven-install-plugin 将.jar文件与pom文件按照坐标存放到了本地仓库

   4.在my-test中 执行 mvn greet sayhi  即可

##### Maven的生命周期

​	Maven有三个生命周期

​		1.clean清理生命周期

​			这个条线只负责删除target文件

​		2.default默认生命周期

​			从validate - compile - test - package - install - deploy 

​		3.site站点生命周期

​			生成JavaDoc 和测试覆盖网页

​	例: mvn clean package  先执行clean  在执行default 执行到package就结束

​	生命周期(Lifecycle): clean , default , site

​	阶段(Phase):compile/ test/ package

​	命令行:(Command Line):mvn clean package

​	目标(goal): Mojo最终的执行者



> 项目路径: ../code/my-test ../code/my-first-plugin
>
> 注意: 例mvn clean package 是先执行clean  然后在从default这条线开始仅仅执行到package就结束
>
> ​	当然也可以执行具体的阶段 比如 mvn package 

