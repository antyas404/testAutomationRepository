# AGENTS.md

Учебный Maven-проект (Java 21) для UI-автоматизации: Selenium 4.41.0, TestNG 7.12.0,
WebDriverManager 6.3.3. E2E-тесты для живых сайтов rabota.by и kaminbel.by.

## Запуск и сборка
- Все тесты лежат в `src/test/java` (`src/main` пустой).
- Сборка/проверка компиляции: `./mvnw test-compile` (wrapper, Java 21).
- `mvn test` НЕ запускает все тесты: нет `testng.xml`/surefire-конфига, по умолчанию
  Maven подхватывает только классы вида `*Test.java`. Запускай тесты из IDE
  (IntelliJ) — щелчком по классу/методу. Некоторые скрипты в `waits/` имеют `main()`.
- Тесты требуют интернет и установленный Chrome; драйвер скачивает WebDriverManager.
  Это живые сайты — возможны попапы, cookie-баннеры, AJAX. Сайты могут меняться
  → локаторы (`//span[text()='Найти']` и т.п.) периодически ломаются.

## Структура
- `pageobject_models/<site>/page/` — Page Object (поля `By`, fluent-методы, ожидания через `waits.customConditions`).
- `pageobject_models/<site>/test/` — TestNG-тесты. Общий паттерн: `@BeforeMethod` c
  `WebDriverManager.chromedriver().setup()`, `@AfterMethod` с `driver.quit()`.
- `waits/` — кастомные условия (`customConditions`) + учебные скрипты ожиданий.
- `first_test/`, `script/` — ранние учебные версии тех же сценариев.

## Конвенции
- Ожидания выносятся в методы страниц через `waits.customConditions`
  (`jQueryAJAXsCompleted`, `waitForElementLocatedBy`, `waitForElementToBeClickable`) — расширяй здесь.
- Кодировка файлов UTF-8 (русские строки в локаторах).
- Git: ветка `master`; сообщения коммитов на английском, повелительное наклонение
  (`Add ...`, `Remove ...`); согласуй текст каждого коммита с пользователем перед
  commit и коммить логическими порциями.

## Общение с пользователем
- Прочитай `.opencode/skills/test-automation/SKILL.md` — там стиль работы (новый
  в автоматизации; ответы пошаговые, с объяснением, на русском, без жаргона).
