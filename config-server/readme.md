
分别启动 eureka、config-server 和两个 config-client.

使用 `mvn clean package` 打包，并 使用 `java -jar **.jar --server.port=0000`运行

调用 `curl -X POST http://localhost:12000/actuator/bus-refresh/` 刷新配置。

并调用接口检查配置是否更新。