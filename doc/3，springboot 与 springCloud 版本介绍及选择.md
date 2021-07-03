1，springboot 和 springCloud 官网地址及git库地址

springboot官网地址：https://spring.io/projects/spring-boot#learn

springboot代码仓库git地址：https://github.com/spring-projects/spring-boot/releases

springcloud官网地址：https://spring.io/projects/spring-cloud#learn

springCloud代码仓库git地址：非常懒，git上面已经没有维护了，要看就去官网看



**2，SpringBoot 和 SpringCloud 版本说明**

**SpringBoot 版本以数字开头，如：2.2.5**

![springboot_version](D:\IdeaProjects\microservicecloud2020\doc\img\springboot_version.png)

**SpringCloud 版本以前以大写字母开头，但是后来又用数字开头了，如：Hoxton.SP11、2020.0.3**

![springCloud-bersion](D:\IdeaProjects\microservicecloud2020\doc\img\springCloud-bersion.png)



**4，springboot 和 springcloud 版本如何选择呢？**

4.1 spring boot和springcloud之间的依赖关系如何看？

查看官网可知对应关系：

![springbootAndSpringCloud-version-select](D:\IdeaProjects\microservicecloud2020\doc\img\springbootAndSpringCloud-version-select.png)

**官网提供的一个更详细的版本对照地址：https://start.spring.io/actuator/info 访问会得到一个 json 字符串，格式化后内容，如下：**

![versin-select](D:\IdeaProjects\microservicecloud2020\doc\img\versin-select.png)

**版本选择这就是依据。**

另外，springcloud 官网对应的版本查看详情一般都会介绍，对应推荐的 springboot 版本，如下：

**点击springBoot 版本后面的 [ Reference Doc.](https://docs.spring.io/spring-cloud/docs/current/reference/html/) 即可看到如下内容：**

   -- Release Train Version: **2020.0.3**    表示，springcloud 的版本是 2020.0.3

   -- Supported Boot Version: **2.4.6 **     表示推荐的 springboot 版本是 2.4.6

