# Family Budget Application

Aile üyelerinin harcamalarını kontrol eden `Aile Bütce Uygulaması`.

##### Bagımlılıklar

- JDK 17
- MySQL Veritabani

##### Uygulama Nasil Calistirilir

- Depoyu klonlayin
- JDK 17'ye sahip oldugunuzdan emin olun.
- MySQL veritabanini kurun.
- Proje dizinine gidin ve `./mvnw springboot:run` komutunu çalıştırın.

## API Hakkında

### Kullanıcı Ekleme

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