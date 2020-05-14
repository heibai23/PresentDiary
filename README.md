## 青葱记录之后端

### 青葱记录

+ 目的
  1. 巩固和提升技术
  2. 纪念手机APP《青葱日记》。（目前已经停止维护了）

+ 项目包含前端和后端
  1. 后端：PresentDiary
  2. 前端：diary

### 技术实现笔记

**SpringBoot**
1. 前后端交互：SpringBoot + Vue + Axios
    + Controller：
      + Api命名与业务相关：timeline
      
2. 日志配置：Logback

3. 开发接口swagger-ui
    1. 引入swagger依赖
    ```xml
    <!-- Swagger2 -->
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger2</artifactId>
                <version>2.6.1</version>
            </dependency>
            <dependency>
                <groupId>io.springfox</groupId>
                <artifactId>springfox-swagger-ui</artifactId>
                <version>2.6.1</version>
            </dependency>
    ```
   2. 添加swagger配置类
   ```java
    Swagger2Config.java
   ```
   
   3. 访问swagger页面，若404，则添加静态资源路径的配置
   ```java
    WebMvcConfig.java
   ```
   
   4. [接口类添加响应注解](https://www.ibm.com/developerworks/cn/java/j-using-swagger-in-a-spring-boot-project/index.html)
   ```text
   // Controller类
   @Api(tags = {"点滴操作"})
   @ApiOperation(value = "记点滴",notes = "记录点滴操作方法")
   // 实体类
   @ApiModel("时间轴")
   @ApiModelProperty("保存类型：0--新增、1--更新")
   ```

4. 功能
   1. 文件上传
   ```java
   // 前端Vue使用表单对象参数：FormData（详细看前端项目代码diary）
   
   // 后端
   @PostMapping("/upload")
    public String uploadFile(@RequestParam(name = "file")MultipartFile file){
        System.out.println(JSON.toJSONString(file));
        return "success";
    }
   
   ```
   
   2. 文件下载
   ```java
   // 前提：数据库存储的是二进制数据
   // 前端：请求参数的返回类型为 responseType: 'blob'
   
   // 后端：1.获取response对象、2.获取字节输出流、3.输出流写数据，前端接收并模拟下载
     @PostMapping("/download")
     public void downloadFile(@RequestBody TimeLineVO timeLineVO){
                 ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                 HttpServletRequest request = servletRequestAttributes.getRequest();
                 HttpServletResponse response = servletRequestAttributes.getResponse();
                 try {
                     // 下载服务
                     fileUploaderService.downloadFileInfo(request,response);
                 } catch (UnsupportedEncodingException e) {
                     e.printStackTrace();
                 }  
       }   
   
   3. 工具类
       1. 集合工具类
           + 集合对象拷贝
   
   ```