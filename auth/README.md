# Gym Team app backend - Auth Service

Микросервис, отвечающий за регистрацию и авторизацию новых сущностей в системе.

## Обособленный запуск

Чтобы запустить BFF Service локально вне docker-compose сети, необходимо совершить следующие шаги:

#### 1) Необходимые сервисы

Запустить docker-compose.dev.yml со следующими сервисами:

- consul

#### 2) Зависимые сервисы

Хотя Auth Service не требует для старта зависящие от него проектные микросервисы, для отправки запросов к ним необходим их запуск в docker-compose.dev.yml.
При необходимости одновременной разработки в Auth Service и проектных микросервисах, следует запустить эти сервисы локально.
Дополнительная конфигурация для этого не требуется.

#### 3) Конфигурация

Задать следующие переменные окружения при старте Spring-приложения:

- SPRING_APPLICATION_PORT - порт, на котором запустится приложение


- SPRING_CONSUL_HOST - адрес consul-сервиса извне сети
- SPRING_CONSUL_PORT - порт consul-сервиса извне сети
