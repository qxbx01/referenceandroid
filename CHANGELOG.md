# Changelog

### General Updates
- **Codebase Refactoring**:
    - Reorganized project structure for better maintainability.
    - Introduced separate packages for pages and tests in line with Page Object Model principles.
    
### Accessibility Enhancements
- **Added `contentDescription` to key UI components**:
    - **Toolbar** (`R.id.toolbar`) for clear identification by screen readers.
    - **Floating Action Button (FAB)** with a clear description of its action (e.g., "Compose Message").
- **Accessibility Tests**:
    - Created new tests to validate that all visible elements have meaningful `contentDescription` attributes.
    - Ensured accessibility standards are met across screens and dynamic content (e.g., Snackbar, FAB).

### Testing Improvements
- **Accessibility Tests**:
    - Validated all UI elements with `contentDescription` using Espresso assertions.
    - Ensured accessibility standards are met across screens.
- **UI Tests**:
    - Enhanced with the Page Object Pattern for modular and maintainable test cases.
    - Added test scenarios for device orientation changes (e.g., `rotateDeviceToLandscape()`).
- **Unit Tests**:
    - Added validation for resources:
        - **Strings** (`strings.xml`): Verified required keys exist.
        - **Colors** (`colors.xml`) and **Dimensions** (`dimens.xml`): Checked naming conventions and proper references.
    - Tested business logic in `MainActivity` for expected functionality.

### Build and Configuration
- **Updated `build.gradle`**:
    - Migrated from `kotlin-android-extensions` to `ViewBinding` for safer and modern UI handling.
    - Bumped `compileSdkVersion` and `targetSdkVersion` to 34 for compatibility with the latest Android releases.
    - Aligned `minSdkVersion` to current best practices (21+).
    - Enabled Java 17 compatibility by setting `sourceCompatibility` and `targetCompatibility`.
- **Dependency Upgrades**:
    - Updated libraries for better functionality and compatibility:
        - Material Components: `1.9.0`.
        - AppCompat: `1.6.1`.
        - Espresso: Ensured compatibility with Android API 34.

### Bug Fixes
- Resolved deprecation warnings by removing `kotlin-android-extensions`.

