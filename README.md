# Family Budget Application

Aile üyelerinin harcamalarını kontrol eden `Aile Bütce Uygulaması`.

## Nasıl Calıstırılır

- [Maven](https://maven.apache.org/index.html) ile.

### 1.Maven

Bu uygulamayı Maven ile calistirabilirsiniz.Uygulamayı calıstırmak istiyorsaniz ayrica MySQL veritabanını da kurmanız
gerekir.

##### 1.1 Bagımlılıklar

- JDK 17
- MySQL Veritabani

##### 1.2 Uygulamayi Calıstırmak

- Depoyu klonlayin
- JDK 17'ye sahip oldugunuzdan emin olun.
- MySQL veritabanini kurun.
- Proje dizinine gidin ve `./mvnw springboot:run` komutunu çalıştırın.

## API Hakkında

### Kullanıcı Olusturma

```
POST /api/users HTTP/1.1
Host : localhost:8081
Content-Type: application/json

{
"name" : "Mehmet"
"lastName" : "Fırıldak"
"username" : "FırıldakMehmet"
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
    "lastName": "Fırıldak"
    "username" : "FırıldakMehmet"
}
```

### Kullanıcı Silme

```
DELETE /api/users/1 HTTP/1.1
Host: localhost:8081
```

### Harcama Olusturma

```
POST /api/spendings HTTP/1.1 
Host : localhost:8081
Content-Type: application/json

    {
        "date": "2023-Ocak-10",
        "price": 5,
        "type": "GROCERY",
        "userId":1,
        "details":[
            {
                "productName": "BISKUVI",
                "price": 5,
                "description": ""
            }
        ]
    }
```

### Kullanıcıya Gore Harcama Cekme

```
GET /api/users/1/spendings HTTP/1.1
Host: localhost:8081
```

Ve cevap su sekilde olacaktır;

```
{   
        "id": 1,
        "date": "2023-Ocak-10",
        "price": 5.0,
        "type": "GROCERY",
        "user": {
            "id": 1,
            "firstName": "Mehmet",
            "lastName": "Fırıldak",
            "username": "FırıldakMehmet"
        },
        "details":[
            {
                "id": 1,
                "productName": "BISKUVI",
                "price": 5.0,
                "description": ""
            }
        ]       
}

```

### Belirli Bir Tarih Araligindaki Harcamaları Listeleme
```
GET /api/spendings?startdate=2023-Ocak-1&endDate=2023-Ocak-31
Host: localhost:8081
```
Ve cevap su sekilde olacaktır;
  
```
{   
        "id": 1,
        "date": "2023-Ocak-10",
        "price": 5.0,
        "type": "GROCERY",
        "user": {
            "id": 1,
            "firstName": "Mehmet",
            "lastName": "Fırıldak",
            "username": "FırıldakMehmet"
        },
        "details":[
            {
                "id": 1,
                "productName": "BISKUVI",
                "price": 5.0,
                "description": ""
            }
        ]       
}
```