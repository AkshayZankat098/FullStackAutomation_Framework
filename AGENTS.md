# Repository AI Agent Guidance

## Purpose
This repository is a Java-based Selenium/TestNG automation framework for UI and API testing. AI agents should treat the Gradle test suite as the primary entry point and only modify the application entry point if a clear need is identified.

## Key commands
- `./gradlew build`
- `./gradlew test`
- `./gradlew :app:test`

## Primary test flow
- TestNG suite file: `app/src/test/resources/testng.xml`
- Default test package: `app/src/test/java/TestFiles`
- Browser setup/teardown: `app/src/test/java/BaseTest/BaseTest.java`
- Page objects: `app/src/main/java/PageObjectFile`
- Cucumber runner (optional): `app/src/test/java/Runner/TestRunner.java`
- Cucumber feature files: `app/src/test/resources/Features`

## Project conventions
- Uses Gradle wrapper and `gradle/wrapper/gradle-wrapper.properties` with Gradle 8.8.
- Java toolchain is configured for Java 21 in `app/build.gradle`.
- WebDriverManager is used for browser driver setup.
- Logging uses Log4j2 + SLF4J.
- Primary automation code is organized into page objects and TestNG test classes.

## Notes for agents
- Prefer improvements to TestNG test structure and stability over adding new application CLI behavior.
- Use the Gradle wrapper from the repository root: `./gradlew build`, `./gradlew test`, `./gradlew :app:test`.
- The primary entry points are test artifacts, not the application main class.
- Confirm test behavior against `app/src/test/resources/testng.xml`, `app/src/test/java/TestFiles`, and `app/src/main/java/PageObjectFile`.
- No existing GPU acceleration or terminal acceleration support was found in the repository. Do not introduce GPU-specific or terminal-performance features without explicit user direction and a clear implementation plan.
- If a request mentions terminal or GPU acceleration, ask whether it is about the test execution environment, browser automation performance, or a different subsystem.
- Do not assume the `application.mainClass` entry point is used by test execution.
