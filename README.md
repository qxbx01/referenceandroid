# Test Project

## Project Overview
This is a test project for demonstrating Android application testing and development practices. The application has been updated to modern Android development standards with enhanced accessibility, maintainability, and test coverage.

## Key Features
- **Accessibility Enhancements**:
    - Added `contentDescription` for key UI elements to improve screen reader support.
- **Modern Dependencies**:
    - Updated dependencies and target/compile SDK versions for compatibility with the latest Android features.
- **View Binding**:
    - Integrated ViewBinding for safer and cleaner access to UI components.
- **Improved Test Coverage**:
    - Added Accessibility, Unit, and UI tests following best practices (e.g., Page Object Model and AAA pattern).

## Setup Instructions
1. Ensure Android Studio is installed with:
    - **Java 17**
    - **Gradle 8.10+**
2. Open the project in Android Studio.
3. Sync Gradle to download the required dependencies.
4. Run the tests using the built-in Android Studio test runner.

---

For detailed updates and changes, refer to the [CHANGELOG.md](./CHANGELOG.md).

---
## Code Quality

To ensure code quality, static analysis tools like SonarQube can be integrated into the CI/CD pipeline. SonarQube helps identify issues such as code smells, potential bugs, and security vulnerabilities.
Although SonarQube was not set up for this test project due to time constraints, it is highly recommended for real-world scenarios to maintain code standards and ensure long-term maintainability.

### Suggested Setup for SonarQube:
1. Install and configure SonarQube on your local machine or server.
2. Integrate SonarQube with the Gradle build system:
   ```bash
   ./gradlew sonarqube

---
## Development Process

For simplicity and to save time during the test assignment, all changes were made in the `main` branch. However, in real-world scenarios, I would use feature branches to isolate changes. 
This approach:
- Ensures a clean commit history.
- Facilitates code reviews by isolating specific features or fixes.
- Improves collaboration within a team.

Example of a typical branching strategy:
- `main`: Production-ready code.
- `develop`: Staging branch for integrating all features.
- `feature/*`: Isolated branches for individual tasks or features.
- `hotfix/*`: Branches for urgent fixes to the production code.
---

## Future Improvements

- **Additional Test Coverage:**
  - Include edge cases for more robust Unit and UI tests.
- **CI/CD Integration:**
  - Set up GitHub Actions or Jenkins for automated builds and tests.
- **SonarQube Setup:**
  - Integrate static code analysis to monitor code quality.
- **Dynamic Themes:**
  - Add support for light/dark themes based on system preferences.

