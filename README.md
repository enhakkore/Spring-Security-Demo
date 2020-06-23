# Spring security demo  
* Servlet을 사용하는 Spring boot 환경에서 Spring security를 적용한 데모 웹 애플리케이션  
---

### 사용기술
* OpenJDK 11.0.7
* Spring boot 2.3.1  
* Spring web, security, data-jpa  
* Template - Mustache  
* DB - H2DB  

### 정보  
* mustache 페이지에서 `_csrf`를 사용하기 위해 property 값 변경  
    * src/main/resources/application.properties  
    ```
    spring.mustache.expose-request-attributes=true

    ```

#### 참고  
* https://victorydntmd.tistory.com/328
* https://stackoverflow.com/questions/51623853/is-there-a-mustache-equivalent-to-thymeleafs-secauthorize-tag  
* https://stackoverflow.com/questions/26397168/how-to-use-spring-security-with-mustache  
