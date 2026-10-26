# Лабораторна робота №1 — повідомлення та DOP

Дисципліна: Розробка програмного забезпечення на платформі Java.
Тема: сучасні можливості Java та Data-Oriented Programming.

## Варіант
Номер залікової книжки N = 4115. V = 4115 mod 3 = 2.
Реалізовано Notification, TextMsg, ImageMsg, AudioMsg і NotificationProcessor
у пакеті `ua.kpi.comsys.dop`. Дані — публічні records, ієрархія — sealed,
логіка — в окремому класі, вичерпний pattern matching switch без default.
Результат кожної гілки формується Text Block і закінчується символом LF.
Валідація не змінює вхідні рядки; відхиляє null, порожні та пробільні значення.

У методичці заголовок V=2 помилково згадує замовлення. Реалізація відповідає
наведеній ієрархії повідомлень. У шаблоні TEXT після `Message:` пропущений
маркер значення, тому тут після нього виводиться поле `text`.

## Вимоги
JDK 21 або новіший та Apache Maven 3.9.x. Preview-функції не потрібні.

## Тести
З кореня проєкту:

```text
mvn clean test
```

33 тестові випадки JUnit 5: усі гілки process, null із точним повідомленням,
точний формат рядків, Unicode, багаторядковий текст, некоректні поля,
мінімальні й максимальні додатні значення. Файли: NotificationProcessorTest
та NotificationValidationTest.

## Запуск демонстрації

```text
mvn compile
java -cp target/classes ua.kpi.comsys.dop.Main
```

Або імпортуйте `pom.xml` в IntelliJ IDEA, оберіть JDK 21+ та запустіть Main.
Батники та інші скрипти запуску не використовуються.

## Результат демонстрації

```text
Notification: TEXT
From: Olena
Message: Hello, Java!

Notification: IMAGE
From: Andrii
URL: https://example.com/photo.png (256 KB)

Notification: AUDIO
From: Iryna
Duration: 45 seconds
```

## Виконана перевірка
Перевірено 23.10.2026 на JDK 25.0.1 із `javac --release 21`.
Тести фактично запускалися через JUnit Platform Console Standalone 1.11.4
(JUnit Jupiter 5.11.4): 33 виконано, 33 успішно, 0 помилок.
Maven у середовищі перевірки не встановлений; команду `mvn clean test`
не запускали. `pom.xml` налаштований на ті самі версії JUnit та Java release.

## Здача
Створіть відкритий GitHub-репозиторій і завантажте в нього вміст цієї папки,
зберігаючи структуру `src/main/java` та `src/test/java`.
У Classroom потрібно прикріпити посилання на репозиторій.
