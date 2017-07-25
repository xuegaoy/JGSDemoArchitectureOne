# JGSDemoArchitectureOne
JGS学习语录
通往架构师的路上

2017/7/11记
24讲前内容全部实现
1.git上传和git服务器搭建
2.cache数据库缓存
3.spring mvc和mybits

2017/7/25
项目在war打包后，jetty单元测试总是报下面的错误
--------------------------------------------------------------------------------------------------
HTTP ERROR 500
Problem accessing /customer/customer/toList. Reason: 
    Server Error

Caused by:
org.apache.ibatis.binding.BindingException: Invalid bound statement (not found): com.sishuok.architecture1.customermgr.dao.CustomerDAO.getByConditionPage
	at org.apache.ibatis.binding.MapperMethod$SqlCommand.<init>(MapperMethod.java:184)
	at org.apache.ibatis.binding.MapperMethod.<init>(MapperMethod.java:38)
	at org.apache.ibatis.binding.MapperProxy.cachedMapperMethod(MapperProxy.java:49)
	at org.apache.ibatis.binding.MapperProxy.invoke(MapperProxy.java:42)
	at com.sun.proxy.$Proxy31.getByConditionPage(Unknown Source)
	at com.sishuok.architecture1.common.service.BaseService.getByConditionPage(BaseService.java:37)
	at com.sishuok.architecture1.customermgr.web.CustomerController.toList(CustomerController.java:76)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
-------------------------------------------------------------------------------------------------------
进过一个星期的调查调试发现原来是项目pom文件里吧该common文件打包成jar后，在单元测试时系统应该不会找到该文件的缘故。
对应方法就是将common文件夹下的jar文件删掉
