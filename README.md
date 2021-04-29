Запуск приложения:

1. Создаем БД (jdbc:postgresql://127.0.0.1:5432/test_db)
2. Делаем restore из backup файла resources\sql\test_db-202104291217.sql
3. Из терминала IDEA выполняем команды mvn clean install spring-boot:run
4. По умолчанию сервис запускается на 8081 порту
5. По uri localhost:8081/swagger-ui.html доступна Open-Api документация
