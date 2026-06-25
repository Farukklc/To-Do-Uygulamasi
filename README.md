# To-Do Uygulaması

Bu proje, Spring Boot kullanılarak geliştirilmiş bir To-Do (Yapılacaklar Listesi) RESTful API uygulamasıdır. Kullanıcıların görev eklemesine, listelemesine, güncellemesine ve silmesine olanak tanır. Uygulama veritabanı olarak PostgreSQL kullanmaktadır. Kurumsal standartlara uygun olarak DTO, MapStruct ve Validation entegrasyonlarına sahiptir.

## 🚀 Lokal Ortamda Nasıl Çalıştırılır?

Projeyi bilgisayarınızda (IDE veya Terminal üzerinden) çalıştırmak için bilgisayarınızda **Java 17** ve **PostgreSQL** kurulu olmalıdır.

1. PostgreSQL üzerinde `todo_db` adında bir veritabanı oluşturun (Kullanıcı adı: `postgres`, Şifre: `postgres`).
2. Terminali açın ve proje dizininde şu komutu çalıştırın:
   ```bash
   ./mvnw spring-boot:run
   ```
3. Uygulama `http://localhost:8081` adresinde çalışmaya başlayacaktır.

## 🐳 Docker ile Nasıl Ayağa Kaldırılır?

Eğer bilgisayarınızda Java veya PostgreSQL kurmak istemiyorsanız, projeyi tek tuşla Docker üzerinden çalıştırabilirsiniz.

1. Bilgisayarınızda [Docker](https://www.docker.com/) uygulamasının çalıştığından emin olun.
2. Terminali açın ve proje dizinindeyken şu komutu çalıştırın:
   ```bash
   docker-compose up --build -d
   ```
3. Docker, hem PostgreSQL veritabanını hem de Spring Boot uygulamasını ayağa kaldıracak ve birbirine bağlayacaktır.
4. Uygulama yine `http://localhost:8081` adresinde yayında olacaktır.
5. Sistemi durdurmak için: `docker-compose down`

## 🔗 Endpoint Listesi

| Metot  | Endpoint | Açıklama |
| ------------- | ------------- | ------------- |
| GET  | `/api/todos`  | Tüm To-Do kayıtlarını listeler. |
| GET  | `/api/todos/{id}`  | Belirtilen ID'ye sahip To-Do kaydını getirir. |
| POST  | `/api/todos`  | Yeni bir To-Do ekler. |
| PUT  | `/api/todos/{id}`  | Mevcut bir To-Do kaydını günceller. |
| DELETE  | `/api/todos/{id}`  | Belirtilen ID'ye sahip To-Do kaydını siler. |

## 📝 Örnek Request / Response'lar

### 1. Yeni To-Do Ekleme (POST `/api/todos`)

**Request:**
```json
{
  "title": "Docker öğrenilecek"
}
```

**Response (201 Created):**
```json
{
  "id": 1,
  "title": "Docker öğrenilecek",
  "completed": false
}
```

### 2. To-Do Güncelleme (PUT `/api/todos/1`)

**Request:**
```json
{
  "title": "Docker öğrenilecek",
  "completed": true
}
```

**Response (200 OK):**
```json
{
  "id": 1,
  "title": "Docker öğrenilecek",
  "completed": true
}
```

### 3. Olmayan Kaydı İsteme (GET `/api/todos/999`)

**Response (404 Not Found):**
```json
{
  "error": "Todo bulunamadı. ID: 999"
}
```

### 4. Validation Hatası (Hatalı POST)

**Request:**
```json
{
  "title": ""
}
```

**Response (400 Bad Request):**
```json
{
  "title": "Title alanı boş bırakılamaz"
}
```
