# Family Budget Application

Aile üyelerinin harcamalarını kontrol eden `Aile Bütce Uygulaması`.

## Nasıl Calıstırılır
Bu uygulamayi calistirmanin iki yolu vardir;
1.  [Maven](https://maven.apache.org/index.html).
2.  [Docker](https://www.docker.com/).

### 1.Maven
Uygulamayı Maven ile çalıştırabilirsiniz. Maven, Maven Wrapper aracılığıyla paketlenmiştir. Uygulamayı çalıştırmak
istiyorsanız Maven ile ayrıca MySQL veritabanını ayrıca kurmanız gerekir.

##### 1.1 Bagımlılıklar

- JDK 17
- MySQL Veritabani

##### 1.2 Uygulama Nasil Calistirilir

- Depoyu klonlayin
- JDK 17'ye sahip oldugunuzdan emin olun.
- MySQL veritabanini kurun.
- Proje dizinine gidin ve `./mvnw springboot:run` komutunu çalıştırın.

### 2. Docker
Dockerfile ve Docker Compose dosyaları vardır.

##### 2.1 Bagımlılıklar
- [Docker](https://www.docker.com/products/docker-desktop/)

##### 2.2 Uygulama Nasil Calistirilir
- Proje dizinine gidin ve çalıştırın `./mvnw clean package && docker-compose build && docker-compose up`

Aşağıdaki gibi logları görmeniz gerekir:
```
Starting family-budget-app_mysqldb_1 ...
Starting family-budget-app_mysqldb_1 ... done
Recreating family-budget-app_web_app_1 ...
Recreating family-budget-app_web_app_1 ... done
Attaching to family-budget-app_mysqldb_1, family-budget-app_web_app_1
mysqldb_1  | 2023-02-07 22:01:20+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.32-1.el8 started.
mysqldb_1  | 2023-02-07 22:01:20+00:00 [Note] [Entrypoint]: Switching to dedicated user 'mysql'
mysqldb_1  | 2023-02-07 22:01:20+00:00 [Note] [Entrypoint]: Entrypoint script for MySQL Server 8.0.32-1.el8 started.
mysqldb_1  | '/var/lib/mysql/mysql.sock' -> '/var/run/mysqld/mysqld.sock'
mysqldb_1  | 2023-02-07T22:01:21.060136Z 0 [Warning] [MY-011068] [Server] The syntax '--skip-host-cache' is deprecated and will be removed in a future release. Please use SET GLOBAL host_cache_size=0 instead.
mysqldb_1  | 2023-02-07T22:01:21.062097Z 0 [System] [MY-010116] [Server] /usr/sbin/mysqld (mysqld 8.0.32) starting as process 1
mysqldb_1  | 2023-02-07T22:01:21.090618Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
mysqldb_1  | 2023-02-07T22:01:22.810647Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
mysqldb_1  | 2023-02-07T22:01:23.251075Z 0 [Warning] [MY-010068] [Server] CA certificate ca.pem is self signed.
mysqldb_1  | 2023-02-07T22:01:23.251156Z 0 [System] [MY-013602] [Server] Channel mysql_main configured to support TLS. Encrypted connections are now supported for this channel.
mysqldb_1  | 2023-02-07T22:01:23.259694Z 0 [Warning] [MY-011810] [Server] Insecure configuration for --pid-file: Location '/var/run/mysqld' in the path is accessible to all OS users. Consider choosing a different directory.
mysqldb_1  | 2023-02-07T22:01:23.296328Z 0 [System] [MY-011323] [Server] X Plugin ready for connections. Bind-address: '::' port: 33060, socket: /var/run/mysqld/mysqlx.sock
mysqldb_1  | 2023-02-07T22:01:23.296902Z 0 [System] [MY-010931] [Server] /usr/sbin/mysqld: ready for connections. Version: '8.0.32'  socket: '/var/run/mysqld/mysqld.sock'  port: 3306  MySQL Community Server - GPL.
web_app_1  |
web_app_1  |   .   ____          _            __ _ _
web_app_1  |  /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
web_app_1  | ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
web_app_1  |  \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
web_app_1  |   '  |____| .__|_| |_|_| |_\__, | / / / /
web_app_1  |  =========|_|==============|___/=/_/_/_/
web_app_1  |  :: Spring Boot ::                (v3.0.1)
web_app_1  |
web_app_1  | 2023-02-07T22:01:25.292Z  INFO 1 --- [           main] t.s.f.FamilyBudgetAppApplication         : Starting FamilyBudgetAppApplication v0.0.1-SNAPSHOT using Java 17.0.2 with PID 1 (/family-budget-app.jar started by root in /)
web_app_1  | 2023-02-07T22:01:25.297Z  INFO 1 --- [           main] t.s.f.FamilyBudgetAppApplication         : No active profile set, falling back to 1 default profile: "default"
web_app_1  | 2023-02-07T22:01:26.285Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Bootstrapping Spring Data JPA repositories in DEFAULT mode.
web_app_1  | 2023-02-07T22:01:26.388Z  INFO 1 --- [           main] .s.d.r.c.RepositoryConfigurationDelegate : Finished Spring Data repository scanning in 79 ms. Found 2 JPA repository interfaces.
web_app_1  | 2023-02-07T22:01:27.046Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8081 (http)
web_app_1  | 2023-02-07T22:01:27.059Z  INFO 1 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
web_app_1  | 2023-02-07T22:01:27.059Z  INFO 1 --- [           main] o.apache.catalina.core.StandardEngine    : Starting Servlet engine: [Apache Tomcat/10.1.4]
web_app_1  | 2023-02-07T22:01:27.143Z  INFO 1 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
web_app_1  | 2023-02-07T22:01:27.146Z  INFO 1 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1764 ms
web_app_1  | Loading class `com.mysql.jdbc.Driver'. This is deprecated. The new driver class is `com.mysql.cj.jdbc.Driver'. The driver is automatically registered via the SPI and manual loading of the driver class is generally unnecessary.
web_app_1  | 2023-02-07T22:01:27.346Z  INFO 1 --- [           main] o.hibernate.jpa.internal.util.LogHelper  : HHH000204: Processing PersistenceUnitInfo [name: default]
web_app_1  | 2023-02-07T22:01:27.402Z  INFO 1 --- [           main] org.hibernate.Version                    : HHH000412: Hibernate ORM core version 6.1.6.Final
web_app_1  | 2023-02-07T22:01:27.680Z  WARN 1 --- [           main] org.hibernate.orm.deprecation            : HHH90000021: Encountered deprecated setting [javax.persistence.sharedCache.mode], use [jakarta.persistence.sharedCache.mode] instead
web_app_1  | 2023-02-07T22:01:27.883Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Starting...
web_app_1  | 2023-02-07T22:01:27.890Z  WARN 1 --- [           main] c.zaxxer.hikari.util.DriverDataSource    : Registered driver with driverClassName=com.mysql.jdbc.Driver was not found, trying direct instantiation.
web_app_1  | 2023-02-07T22:01:29.745Z  INFO 1 --- [           main] com.zaxxer.hikari.pool.HikariPool        : HikariPool-1 - Added connection com.mysql.cj.jdbc.ConnectionImpl@7daa61f3
web_app_1  | 2023-02-07T22:01:29.748Z  INFO 1 --- [           main] com.zaxxer.hikari.HikariDataSource       : HikariPool-1 - Start completed.
web_app_1  | 2023-02-07T22:01:29.799Z  INFO 1 --- [           main] SQL dialect                              : HHH000400: Using dialect: org.hibernate.dialect.MySQLDialect
web_app_1  | 2023-02-07T22:01:32.863Z  INFO 1 --- [           main] o.h.e.t.j.p.i.JtaPlatformInitiator       : HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
web_app_1  | 2023-02-07T22:01:32.871Z  INFO 1 --- [           main] j.LocalContainerEntityManagerFactoryBean : Initialized JPA EntityManagerFactory for persistence unit 'default'
web_app_1  | 2023-02-07T22:01:33.843Z  WARN 1 --- [           main] JpaBaseConfiguration$JpaWebConfiguration : spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
web_app_1  | 2023-02-07T22:01:35.092Z  INFO 1 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
web_app_1  | 2023-02-07T22:01:35.112Z  INFO 1 --- [           main] t.s.f.FamilyBudgetAppApplication         : Started FamilyBudgetAppApplication in 10.559 seconds (process running for 11.525)
```

## API Hakkında

### Kullanıcı Ekleme

```
POST /api/users HTTP/1.1
Host : localhost:8081
Content-Type: application/json

{
"name" : "Mehmet"
"lastName" : "Cetin"
"username" : "CetinMehmet"
}
```

### Kullanıcı Cekme

```
GET/api/users/1 HTTP/1.1
Host: localhost:8081
```

Ve cevap su sekilde olacaktır;

```
{
    "id": 1,
    "firstName": "Mehmet",
    "lastName": "Cetin"
    "username" : "CetinMehmet"
}
```

### Kullanıcı Silme

```
DELETE /api/users/1 HTTP/1.1
Host: localhost:8081
```

### Harcama Ekleme

```
POST /api/spendings HTTP/1.1 
Host : localhost:8081
Content-Type: application/json

    {
        "date": "2023-Ocak-10",
        "price": 100,
        "type": "GROCERY",
        "userId":1,
        "details":[
            {
                "productName": "CAY",
                "price": 100,
                "description": ""
            }
        ]
    }
```

### Bir Kullaniciya Ait Harcamalari Cekme

```
GET /api/users/1/spendings HTTP/1.1
Host: localhost:8081
```

Ve cevap su sekilde olacaktır;

```
{   
        "id": 1,
        "date": "2023-Ocak-10",
        "price": 100.0,
        "type": "GROCERY",
        "user": {
            "id": 1,
            "firstName": "Mehmet",
            "lastName": "Cetin",
            "username": "CetinMehmet"
        },
        "details":[
            {
                "id": 1,
                "productName": "CAY",
                "price": 100.0,
                "description": ""
            }
        ]       
}
```

### Belirli Bir Tarih Araligindaki Harcamaları Listeleme

```
GET /api/spendings?startdate=2023-Ocak-1&endDate=2023-Ocak-31 HTTP/1.1
Host: localhost:8081
```

Ve cevap su sekilde olacaktır;

```
{   
        "id": 1,
        "date": "2023-Ocak-10",
        "price": 100.0,
        "type": "GROCERY",
        "user": {
            "id": 1,
            "firstName": "Mehmet",
            "lastName": "Cetin",
            "username": "CetinMehmet"
        },
        "details":[
            {
                "id": 1,
                "productName": "CAY",
                "price": 100.0,
                "description": ""
            }
        ]       
}
```

### En Yüksek Tutarda Harcama Yapan Kullanıcıyı Cekme

```
GET /api/users/most-spending HTTP/1.1
Host: localhost:8081
```

Ve cevap su sekilde olacaktır;

```
{
"id": 1,
"firstName": "Mehmet",
"lastName": "Cetin",
"username": "CetinMehmet"
}
```