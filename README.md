# Gym Team app backend

Этот проект сделан по [Microservice Architecture Pattern](http://martinfowler.com/microservices/), использует Spring Boot, Spring Cloud и Docker.
Для запуска необходим Docker Compose, поддерживающий docker-compose.yml версии не ниже 3.7.

## Локальный запуск

Для корректного старта всех микросервисов требуется настройка.

#### 1) Конфигурация
В целях безопасности, все данные, представляющие ценность вынесены в файл конфигурации. Необходимые для старта переменные указаны в .env.example.

Для запуска всей системы необходимо указать следующее переменные

- BFF_SERVICE_IMAGE_NAME - имя docker-image для bff-сервиса
- BFF_SERVICE_IMAGE_TAG - тег docker-image для bff-сервиса


- USER_SERVICE_IMAGE_NAME - имя docker-image для user-сервиса
- USER_SERVICE_IMAGE_TAG - тег docker-image для user-сервиса
- USER_SERVICE_DATASOURCE_URL - jdbc-ссылка на БД user-service с учётом адресации внутри docker network


- DATASOURCE_USERNAME - имя пользователя database-сервиса
- DATASOURCE_PASSWORD - пароль пользователя database-сервиса
- DATASOURCE_VOLUME - docker volume для database-сервиса

#### 2) Базы данных
Для старта user-service, в volume database-сервиса должны быть созданы БД этих сервисов.