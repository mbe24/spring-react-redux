# Tech Stack Update - February 2026

## Summary
This document details the comprehensive tech stack update performed on the spring-react-redux project, bringing all dependencies to their latest stable versions as of February 2026.

## Version Updates

### Backend

#### Build Tools
- **Gradle**: `4.10.2` → `8.11.1`
  - Updated Gradle wrapper to latest stable version
  - Improved build performance and compatibility

#### Java
- **Java Version**: `1.8` → `17`
  - Updated sourceCompatibility to Java 17
  - Required for Spring Boot 3.x compatibility

#### Spring Framework
- **Spring Boot**: `2.1.1.RELEASE` → `3.4.2`
  - Major version upgrade with significant improvements
  - Enhanced security, performance, and feature set
  - Native support for Java 17+

#### Dependencies
- **Janino**: `3.0.11` → `3.1.12`
  - Updated Java compiler library

### Frontend

#### Core Libraries
- **React**: `16.6.3` → `18.3.1`
  - Major version upgrade with concurrent rendering features
  - Improved performance and developer experience
  - Updated to use `createRoot` API

- **React-DOM**: `16.6.3` → `18.3.1`
  - Aligned with React version

#### State Management
- **Redux**: `4.0.1` → `5.0.1`
  - Updated to latest stable version
  - Using `legacy_createStore` for backward compatibility

- **React-Redux**: `6.0.0` → `9.1.2`
  - Updated to work with React 18 and Redux 5

- **Redux-Thunk**: `2.3.0` → `3.1.0`
  - Updated import syntax to use named export

#### Build Tools
- **React-Scripts**: `2.1.1` → `5.0.1`
  - Updated Create React App tooling
  - Improved build performance and features

#### Development Tools
- **http-proxy-middleware**: `0.19.1` → `3.0.3`
  - Updated API to use `createProxyMiddleware`

- **Prettier**: `1.15.3` → `3.4.2`
  - Updated code formatter

- **ESLint Plugins**: Updated to latest compatible versions

## Code Changes

### Backend Changes

#### Spring Boot 3 Migration
1. **JUnit 5 Migration**
   - Replaced JUnit 4 annotations with JUnit 5 (`@Test`, `@SpringBootTest`)
   - Removed `@RunWith(SpringRunner.class)` in favor of JUnit 5 extension model
   - Updated assertions to use AssertJ instead of Hamcrest

2. **Deprecated API Updates**
   - Changed `MediaType.APPLICATION_JSON_UTF8_VALUE` to `MediaType.APPLICATION_JSON_VALUE`
   - This API was deprecated in Spring 5 and removed in Spring 6

3. **Gradle Build Configuration**
   - Migrated from buildscript block to plugins DSL
   - Updated dependency management plugin version

4. **Test Enhancements**
   - Added comprehensive test for `/time` endpoint
   - Validates JSON response structure and data format
   - Tests time value ranges (0-23 hours, 0-59 minutes/seconds)

### Frontend Changes

#### React 18 Migration
1. **Rendering API**
   - Updated from `ReactDOM.render()` to `createRoot().render()`
   - Wrapped app in `<React.StrictMode>` for better development warnings

2. **Lifecycle Methods**
   - Replaced deprecated `componentWillMount()` with `componentDidMount()`
   - Maintains same functionality while following React 18 best practices

3. **Redux 5 Compatibility**
   - Updated Redux store creation to use `legacy_createStore`
   - Changed thunk import from default to named export: `import { thunk } from 'redux-thunk'`

4. **Testing Updates**
   - Updated test to use React 18's `createRoot` API
   - Added Redux Provider wrapper to test
   - Updated unmount syntax to use `root.unmount()`

5. **Proxy Configuration**
   - Updated `setupProxy.js` to use `createProxyMiddleware` API
   - Added `changeOrigin: true` option for better proxy behavior

6. **Code Quality**
   - Fixed ESLint issues with anonymous default exports
   - Named all reducer functions for better debugging
   - Fixed Prettier formatting issues (single quotes)
   - Fixed ESLint configuration syntax error

## Testing

### Backend Tests
All backend tests pass successfully:
```bash
./gradlew test
BUILD SUCCESSFUL in 1s
```

Test Coverage:
- ✅ `testGetHello()` - Tests hello endpoint with query parameter
- ✅ `testGetTest()` - Tests error handling endpoint
- ✅ `testGetTime()` - Tests time endpoint JSON response and validation

### Frontend Tests
All frontend tests pass successfully:
```bash
CI=true npm test
Test Suites: 1 passed, 1 total
Tests: 1 passed, 1 total
```

Test Coverage:
- ✅ App renders without crashing with Redux store

### Build Verification
Both backend and frontend build successfully:
```bash
# Backend
./gradlew build
BUILD SUCCESSFUL

# Frontend
npm run build
Compiled successfully.
```

## Backward Compatibility

### Breaking Changes Handled
1. **Java 17 Requirement**: Spring Boot 3 requires Java 17 minimum
2. **Jakarta EE Namespace**: Spring Boot 3 uses jakarta.* instead of javax.*
3. **React 18 Rendering**: New root API required for React 18
4. **Redux 5**: createStore API moved to legacy namespace

### Non-Breaking Changes
- API endpoints remain unchanged
- Application behavior is identical to previous version
- Configuration files remain compatible

## Running the Application

### Backend
```bash
./gradlew bootRun
```
The backend server starts on `http://localhost:8080/app`

### Frontend
```bash
cd app
npm install
npm start
```
The frontend starts on `http://localhost:3000`

### API Endpoints
- `GET /app/api/v1/hello?name=<name>` - Returns greeting
- `GET /app/api/v1/test?name=<name>` - Tests error handling
- `GET /app/api/v1/time` - Returns current time in JSON format

## Migration Benefits

### Performance
- Faster build times with Gradle 8
- Improved runtime performance with Spring Boot 3
- React 18 concurrent features for better UX

### Security
- Latest security patches in all dependencies
- Long-term support for Java 17
- Updated security features in Spring Boot 3

### Developer Experience
- Better error messages and debugging
- Improved IDE support
- Modern tooling and features

### Maintainability
- Easier to upgrade in the future
- Better documentation and community support
- Active maintenance for all dependencies

## Future Recommendations

1. **Consider Redux Toolkit**: Modern Redux best practices recommend Redux Toolkit instead of legacy Redux
2. **Add More Tests**: Expand test coverage for Redux actions and reducers
3. **TypeScript Migration**: Consider migrating to TypeScript for better type safety
4. **Update to React 19**: When React 19 is released and stable
5. **Spring Boot 3.x Updates**: Keep up with Spring Boot 3.x minor versions

## Conclusion

The tech stack has been successfully updated to the latest stable versions as of February 2026. All tests pass, and the application builds and runs correctly with the new versions. The update provides improved performance, security, and maintainability while preserving all existing functionality.
