### [EN](#EN) | [RU](#RU)

# <a name="RU"></a>Требования к запуску проекта
Проект состоит из 2 микросервисов, которые должны быть запущены параллельно с помощью их собственных
App классов в src.main.hava.org.example для корректной работы проекта.
## Notification-service:
 - Необходим Docker для запуска Kafka. Работоспособность программы была проверена с использованием Docker Desktop
 - Для запуска Kafka(3.6.1) проделать следующие шаги:
 - - Открыть командую строку в папке notification-service
 - - Выполнить следующую команду: ```docker-compose up -d```
 - Заполнить application.properties:
 - - Ввести адрес используемой почты```spring.mail.username=```
 - - Ввести пароль к приложению (не обычный пароль почты, см. App passwords в Gmail)```spring.mail.password=```
 - - Поменять хост почты, если не используется Gmail почта```spring.mail.host=smtp.gmail.com```
## User-service:
- Создать базу данных. Работоспособность программы была проверена при созданной БД в pgAdmin4
- Необходимо заполнить файл application.properties в src.main.resources для доступа к БД:
    - **Адрес БД** ```spring.datasource.url```: \
      Пример: ```spring.datasource.url = jdbc:postgresql://localhost:5432/Users```
    - **Имя пользователя БД** ```spring.datasource.username```
    - **Пароль данного пользователя** ```spring.datasource.password```
# Требования к проекту
Реализовать микросервис(notification-service) для отправки сообщения на почту при удалении или добавлении пользователя.
Требования

 - Использовать необходимые модули spring и kafka.
 - При удалении или создании юзера приложение, реализованное до этого(user-service), должно отправлять сообщение в kafka, в котором содержится информация об операции(удаление или создание) и email юзера.
 - Новый микросервис(notification-service) должен получить сообщение из kafka и отправить сообщение на почту юзера в зависимости от операции: удаление - Здравствуйте! Ваш аккаунт был удалён. Создание - Здравствуйте! Ваш аккаунт на сайте ваш сайт был успешно создан.
 - Также отдельно добавить API, которая будет отправлять сообщение на почту(почти тот же функционал, что и через кафку).
 - Написать интеграционные тесты для проверки отправки сообщения на почту.

# <a name="EN"></a>Requirements for project to run
The project consists of 2 microservices that should be run in parallel using their own
App classes in src.main.java.org.example for the correct operation of the project.
## Notification-service:
- Docker is required to run Kafka. The program was tested using Docker Desktop
- To launch Kafka(3.6.1), follow these steps:
- - Open the command prompt in the notification-service folder
- - Run the following command: ```docker-compose up -d```
- Fill in application.properties:
- - Enter the address of the email you are using```spring.mail.username=```
- - Enter the password for the application (not the usual mail password, see App passwords in Gmail)```spring.mail.password=```
- - Change the mail host if Gmail is not your used mail```spring.mail.host=smtp.gmail.com ```
## User-service:
- Create DB. The program was tested using DB created in pgAdmin4
- Fill in missing parts in hibernate.properties located in src.main.resources to access your DB:
    - Location of your created DB ```spring.datasource.url:```\
      Example: ```spring.datasource.url: = jdbc:postgresql://localhost:5432/Users```
    - DB User's name ```spring.datasource.username```
    - DB User's password ```spring.datasource.password ```