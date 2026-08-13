This repository contains a collection of UI automation tests for various websites.  
The project is created for educational purposes to practice and improve skills in writing automated tests using **Java**, **Selenium WebDriver**, **TestNG**, and the **Page Object Model (POM)** design pattern.

Each test scenario focuses on real-world challenges such as dynamic content, AJAX loading, unstable UI elements, popups, cookies, and complex user interactions.

---

## Getting Started

### Prerequisites

- **JDK 21**
- **Git**
- **Google Chrome** — the matching chromedriver is downloaded automatically by WebDriverManager
- Internet connection

### 1. Clone the repository

```bash
git clone https://github.com/antyas404/testAutomationRepository.git
cd testAutomationRepository
```

### 2. Verify the project compiles

The Maven Wrapper is included, so no Maven installation is required.

Windows:

```bash
mvnw.cmd test-compile
```

macOS / Linux:

```bash
./mvnw test-compile
```

### 3. Run the tests

The test suite is defined in `src/test/resources/testng.xml` and wired into Maven via the Surefire plugin.

Run all tests:

```bash
mvnw.cmd test        # Windows
./mvnw test          # macOS / Linux
```

To run a specific test class from an IDE (IntelliJ IDEA):

1. Open the project as a Maven project.
2. Wait for dependencies to download.
3. Right-click a test class or method and choose **Run**.

> **Note:** The tests are E2E scenarios against live websites (rabota.by, kaminbel.by).
> Popups, cookie banners, and AJAX content may appear, and selectors can break if the sites change.

---

Project Goals

- Strengthen practical skills in UI test automation  
- Learn to design maintainable and scalable test frameworks  
- Practice Page Object Model and Fluent API patterns  
- Work with dynamic and unstable web interfaces  
- Build a portfolio of automation examples for different websites  
- Experiment with advanced Selenium techniques (JavaScriptExecutor, custom waits, AJAX handling)

---

Technologies & Tools

- **Java 21**
- **Selenium WebDriver**
- **TestNG**
- **Page Object Model (POM)**
- **JavaScriptExecutor**
- **WebDriverWait + custom wait conditions**
- **Maven**

---
