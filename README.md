# Selenium Automation Testing Framework

## 1. Project Overview

This project is a UI automation testing framework developed using Java, Selenium WebDriver, TestNG, and Maven.

The framework automates login-related test scenarios, including invalid credentials, valid credentials, forgot password, and logout functionality.

The `InvalidCredentialsTest.java` test uses Excel data for data-driven testing, allowing multiple sets of test data to be executed without hardcoding values in the test script.

The project focuses on improving test reusability, maintainability, execution efficiency, and test result verification.

## 2. Tools and Technologies

| Tool / Technology | Purpose |
|---|---|
| Java | Programming language |
| Selenium WebDriver | Automates browser interactions |
| TestNG | Test execution and assertions |
| Maven | Dependency management and build automation |
| Apache POI | Reads test data from Excel files |
| Eclipse IDE | Development environment |
| GitHub Actions | Automates test execution on code pushes |
| TestNG HTML Reports | Displays test execution results |

## 3. Project Structure

The following is the intended project structure. File locations should match the actual project.

```text
SeleniumFrameWorkTest/
│
├── src/
│   └── test/
│       ├── java/
│       │   ├── BasePackage/
│       │   │   └── BaseClass.java
│       │   │
│       │   └── LoginPage/
│       │       ├── InvalidCredentialsTest.java
│       │       ├── validCredentialsTest.java
│       │       ├── ForgotPasswordFlowTest.java
│       │       └── verifyLogoutTest.java
│       │
│       └── resources/
│           ├── testng.xml
│           └── TestData.xlsx
│
├── test-output/
│   ├── index.html
│   └── emailable-report.html
│
├── .github/
│   └── workflows/
│       └── maven-tests.yml
│
├── pom.xml
├── .gitignore
└── README.md
```

*Note: The Excel filename, XML file location, and workflow filename should match the actual project structure.*

## 4. Automated Test Scenarios

### 4.1 Invalid Credentials Test

**File:** `InvalidCredentialsTest.java`

- Tests login using invalid credentials.
- Reads multiple sets of test data from an Excel file.
- Uses Apache POI to read Excel data.
- Verifies the expected error message or login failure.
- Supports data-driven testing.

### 4.2 Valid Credentials Test

**File:** `validCredentialsTest.java`

- Tests login using valid credentials.
- Verifies whether the user can log in successfully.

### 4.3 Forgot Password Test

**File:** `ForgotPasswordFlowTest.java`

- Tests the forgot password flow.
- Verifies the expected response after submitting the required information.

### 4.4 Logout Test

**File:** `verifyLogoutTest.java`

- Tests the logout functionality.
- Verifies whether the user is logged out successfully.

## 5. Why These Tools Were Chosen

- **Java:** Provides a widely used programming language for automation testing.
- **Selenium WebDriver:** Automates browser actions and UI validation.
- **TestNG:** Organizes test cases and supports assertions and execution reports.
- **Maven:** Manages dependencies and provides standard test execution commands.
- **Apache POI:** Reads test data from Excel files.
- **GitHub Actions:** Supports automated test execution after code is pushed to GitHub.
- **TestNG HTML Reports:** Makes test results easy to read and verify in a browser.

## 6. Prerequisites

Before running the project, ensure that the following are available:

- Java JDK
- Maven
- Git
- Eclipse IDE
- Google Chrome
- A GitHub repository for CI execution

Verify Java installation:

```bash
java -version
```

Verify Maven installation:

```bash
mvn -version
```

## 7. How to Run the Tests

Open the project in Eclipse and run the `testng.xml` file located in `src/test/resources` to execute the configured test suite.

## 8. Test Reporting

Test execution results can be reviewed using the TestNG HTML report and emailable report.

### 8.1 TestNG HTML Report

The TestNG HTML report provides a summary of the executed test cases.

To view the report:

1. Open the project directory.
2. Open the `test-output` folder.
3. Locate `index.html`.
4. Double-click the file to open it in your web browser.

The report displays the test execution summary and available test details, including passed, failed, and skipped tests.

### 8.2 TestNG Emailable Report

The emailable report provides a compact view of the test execution results.

To view the report:

1. Open the `test-output` folder.
2. Locate `emailable-report.html`.
3. Double-click the file to open it in your web browser.

This report can be used to review and share the available test execution results.

## 9. GitHub Actions Integration

GitHub Actions can be configured to execute the automation suite whenever code is pushed to the repository.

The workflow should:

1. Check out the source code.
2. Set up the required Java version.
3. Resolve Maven dependencies.
4. Execute the automated tests.
5. Make the test reports available as downloadable workflow artifacts.

The workflow file can be located at:

```text
.github/workflows/maven-tests.yml
```

After pushing code to GitHub, open the repository's **Actions** tab to review the workflow status and execution logs.

The workflow should be configured to upload the TestNG HTML and emailable reports as artifacts so they can be downloaded and reviewed after execution.

## 10. Design Decisions

- **Reusable base class:** Helps reduce duplicate browser setup code.
- **Excel-based test data:** Separates test data from test logic and supports multiple invalid credential combinations.
- **TestNG XML suite:** Organizes test classes and allows them to be executed together.
- **Maven:** Provides dependency management and standard test execution commands.
- **HTML reports:** Allow test results to be reviewed in a browser.
- **GitHub Actions:** Supports continuous integration by running tests after code changes are pushed.

## 11. Future Improvements

- Add more positive and negative test scenarios.
- Improve browser setup and cleanup.
- Extend data-driven testing to other scenarios.
- Capture screenshots when UI tests fail.
- Improve logging and error handling.
- Upload HTML reports as GitHub Actions artifacts.
- Add API automation tests where suitable APIs are available.

## 12. Conclusion

This project demonstrates a Selenium automation testing framework using Java, TestNG, Maven, and Excel-based test data.

It covers login-related UI scenarios, supports data-driven testing, and allows test results to be reviewed through HTML reports.

GitHub Actions can further automate test execution after code changes are pushed. The framework can be extended with additional UI tests, API tests, logging, and reporting capabilities.
