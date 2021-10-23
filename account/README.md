# Gym Team app backend - Account Service

Микросервис, предоставляющий доступ к сущности Account, Card, Transaction и методам работы с ней.

## Обособленный запуск

Чтобы запустить Account Service локально вне docker-compose сети, необходимо совершить следующие шаги:

#### 1) Необходимые сервисы

Запустить docker-compose.dev.yml со следующими сервисами:

- consul
- database

#### 2) База данных

Создать в volume database-сервиса БД этого сервиса.
**НЕ ИСПОЛЬЗОВАТЬ ОДНУ И ТУ ЖЕ БД ДЛЯ ЗАПУСКА ЛОКАЛЬНОГО ПРИЛОЖЕНИЯ И ПРИЛОЖЕНИЯ В КОНТЕЙНЕРЕ**

#### 3) Конфигурация

Задать следующие переменные окружения при старте Spring-приложения:

- SPRING_APPLICATION_PORT - порт, на котором запустится приложение


- SPRING_CONSUL_HOST - адрес consul-сервиса извне сети
- SPRING_CONSUL_PORT - порт consul-сервиса извне сети


- SPRING_JPA_HIBERNATE_DDL_AUTO - режим работы Hibernate с БД
- SPRING_DATASOURCE_URL - jdbc-ссылка на БД сервиса извне сети
- SPRING_DATASOURCE_USERNAME - имя пользователя database-сервиса
- SPRING_DATASOURCE_PASSWORD - пароль пользователя database-сервиса
