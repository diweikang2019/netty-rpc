## 说明

### 服务提供者
1. 实现接口
2. 启动netty服务端
3. 收到请求后找到对应的实现，通过反射调用

### 服务消费者
1. 创建代理对象
2. 在代理对象中启动netty客户端，发送请求消息

### 
![流程图](flow_chart.png)