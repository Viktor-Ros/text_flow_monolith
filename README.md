# Text flow monolith - приложение для обмена текстами

![Картинка](resources/pic1.png)

### Навигация
* [Используемые технологии](#title1)
* [Инструкция по запуску](#title2)
* [Инструкция по тестированию](#title3)
* [Логика работы приложения](#title4)
* [Компоненты приложения](#title5)
* [Базовый функционал](#title6)
* [Схема базы данных](#title7)
* [Описание REST запросов](#title8)
* [REST запросы](#title9)


### <a id="title1">Используемые технологии:</a>

* Java 11
* Spring Boot 2.7.0
* Spring JPA 2.7.0
* PostgreSQL 13
* JUnit 5
* Docker
* Spring AOP
* REST API
* Maven PMD
* Монолитная архитектура

### <a id="title2">Инструкция по запуску:</a>
*  В ***application.context*** указать параметры существующей БД или создать новую с параметрами:
   - host = localhost
   - port = 5432
   - user - bestuser
   - password - bestuser
   - name - text_flow_db
*  Запустить приложение из класса ***TextFlowApplication***
*  При первом запуске в БД создаются таблицы и начальные тестовые данные
*  Также запросы для создания таблиц и стартовых данных лежат в ***resources/sql/data.sql***
*  Либо запустить с помощью Docker, для этого используем консольную команду ***docker-compose up*** 


### <a id="title3">Инструкция по тестированию:</a>
*  Тесты настроены на работу с начальными тестовыми данными(класс ***TestData***)
*  Тесты прогоняются при сборке с помощью консольной команды: ***mvn clean install***
*  Если тесты при сборке не нужны, то используем консольную команду: ***mvn clean install -DskipTests=true***


### <a id="title4">Логика работы приложения:</a>

Приложение позволяет пользователям писать тексты, а также подписываться на других авторов, чтобы просматривать их тексты


### <a id="title5">Компоненты приложения:</a>

* Employee - пользователь, может являться автором текстов
* Story - текст автора
* Subscription - подписка на автора


### <a id="title6">Базовый функционал:</a>

Служит для сокращения кода и унификации функционала

 * #### BaseEntity - основа каждой сущности, содержит поля: 
    - id - идентификатор
    - creationDate - дата создания
    - modifyDate - дата изменения
     
 * #### BaseDao - базовый функционал для работы на уровне БД:
    - save() - сохранение сущности
    - deleteById() - удаление сущности по идентификатору
    - getById() - получение сущности по идентификатору 
    - getAllList() - получение списка всех сущностей 

 * #### BaseService - базовый функционал для работы на уровне бизнес-логики:
    - save() - сохранение сущности
    - deleteById() - удаление сущности по идентификатору
    - getById() - получение сущности по идентификатору
    - getAllList() - получение списка всех сущностей

 * #### BaseController - базовый функционал для работы на уровне REST API:
    - POST - "" - создание сущности
    - PUT - "" - изменение сущности
    - DELETE - "/{id}" - удаление сущности по идентификатору
    - GET - "/{id}" - получение сущности по идентификатору
    - GET - "" - получение списка всех сущностей
    

### <a id="title7">Схема базы данных(файл data.sql):</a>

 * #### base - дефолтные поля любой сущности - не таблица!!!
    - id - идентификатор
    - creation_date - дата создания
    - modify_date - дата изменения

 * #### employee - таблица пользователей
    - name - имя пользователя
     
 * #### story - таблица текстов
    - text_value - текст
    - author_id - идентификатор автора - references employee.id

 * #### subscription - таблица подписок
    - writer_id - идентификатор писателя - references employee.id
    - subscriber_id - идентификатор подписчика - references employee.id


### <a id="title8">Описание REST запросов:</a>

 * #### Employee - действия с пользователями
   - POST /employee - сохранение пользователя
   - PUT /employee - изменение пользователя
   - DELETE /employee/{id} - удаление пользователя по id
   - GET /employee/{id} - получение пользователя по id
   - GET /employee - получение списка всех пользователей
   - GET /employee/subscriber_list_by_writer_id/{writer_id} - получения списка подписчиков по id писателя
   - GET /employee/writer_list_by_subscriber_id/{subscriber_id} - получение списка писателей по id подписчика

* #### Story - действия с текстами
    - POST /story - сохранение текста
    - PUT /story - изменение текста
    - DELETE /story/{id} - удаление текста по id
    - GET /story/{id} - получение текста по id
    - GET /story - получение списка всех текстов
    - GET /story/story_list_by_author_id/{author_id} - получения списка текстов по id автора
    - GET /story/story_list_by_subscriber_id/{subscriber_id} - получение списка текстов по id подписчика

* #### Subscription - действия с подписками
    - POST /subscription - сохранение подписки
    - PUT /subscription - изменение подписки
    - DELETE /subscription/{id} - удаление подписки по id
    - GET /subscription/{id} - получение подписки по id
    - GET /subscription - получение списка всех подписок


### <a id="title9">REST запросы для Postman:</a>

* Примеры REST запросов для Postman ***[лежат тут](resources/postman/text_flow_monolith.postman_collection.json)***
