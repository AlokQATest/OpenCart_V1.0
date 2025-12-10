# E-commerce Automation Testing Project

This project is an **automation testing framework** for an e-commerce
application. It is implemented using **Java**, **Selenium WebDriver**,
and **TestNG**, following a **hybrid-driven framework** with
**data-driven testing** support.

------------------------------------------------------------------------

## Features

-   Selenium WebDriver for UI automation
-   TestNG for test management and reporting
-   Data-driven testing using external test data sources
-   Hybrid-driven framework combining modular and data-driven approaches
-   Parallel and sequential execution support via TestNG XML
    configuration

------------------------------------------------------------------------

## Project Structure

-   **src/test/java** -- Test scripts and framework utilities
-   **test-data/** -- External test data files (Excel/CSV)
-   **testng.xml** -- Sample TestNG configuration files
-   **crossbrowsertesting.xml** -- Runs tests in parallel across
    multiple browsers
-   **master.xml** -- Runs all tests sequentially

------------------------------------------------------------------------

## How to Run the Tests

1.  **Clone the repository**:

    ``` bash
    git clone <repository-url>
    cd <project-folder>
    ```

2.  **Install dependencies**:

    -   Ensure **Java JDK 11+** is installed
    -   Install **Maven** to manage project dependencies
    -   Configure environment variables for Java and Maven

3.  **Run Tests**:

    -   **Parallel execution (across browsers)**:

        ``` bash
        mvn clean test -DsuiteXmlFile=crossbrowsertesting.xml
        ```

    -   **Sequential execution**:

        ``` bash
        mvn clean test -DsuiteXmlFile=master.xml
        ```

4.  **View Reports**:

    -   Reports are generated in the `test-output` folder by default.

------------------------------------------------------------------------

## Notes

-   Update `config.properties` with the correct URL and browser settings
    before running tests.
-   Test data can be modified under the `test-data/` folder.
