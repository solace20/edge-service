# edge-service
spring-cloud-gateway-eureka网关负载均衡调用

# 启动流程
- 1.启动eureka-server
- 2.启动provider
- 3.启动gateway
- 4.访问localhost:8081/cusotmers,路由到localhost:8080/customers
