## 1、nacos 注册中心、
### 1.1 原理：
### 1.2 安装部署
### 1.3 使用
## 2、配置中心
## 2.1 必须使用bootstrap.yml，存放config配置


3. 加载顺序
   bootstrap.yml / bootstrap.yaml：首先加载，用于配置应用的启动环境。
   Nacos 配置中心的配置文件：
   先加载 共享配置文件 (shared-configs)
   然后是 扩展配置文件 (extension-configs)
   最后是 项目应用名配置文件 (${spring.application.name}.yaml / .properties)
   application.yml / application.yaml：在 Nacos 配置加载之后。
4. 优先级
   项目应用名配置文件：具有最高优先级。
   扩展配置文件：次之，覆盖共享配置。
   共享配置文件：优先级低于扩展配置。
   本地 application.yml / application.yaml：优先级低于所有从 Nacos 加载的配置。
   本地 bootstrap.yml / bootstrap.yaml：优先级最低。
   相同的配置，优先级高的会覆盖优先级低的，bootstrap是作为spring cloud的上下文配置加载的，
一般配置nacos和config的注册中心数据，不配置其他数据，配置了其他数据也可能会被覆盖，而nacos和config相关数据则不会被覆盖。
5. springboot配置文件加载顺序：
   优先级：application.properties>application.yml>application.yaml
   如果文件同时存在，相同的配置项会按照高优先级覆盖低优先级的文件，不同的会合并