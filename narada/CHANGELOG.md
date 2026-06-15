# Changelog - Narada (MQTT Broker)

All notable changes to the Narada MQTT Broker app will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.1] - 2026-06-11

### Added
- MQTT Broker functionality powered by Moquette
- Start/Stop broker controls with real-time status display
- Configurable MQTT port (default: 1883)
- WebSocket support with configurable port and path
- Client authentication with username/password
- Connected clients counter
- Real-time broker logs display with clear functionality
- Server connection details sharing
- Material Design 3 user interface
- Android notification support for background operation
- Battery optimization management for uninterrupted service
- WakeLock support to keep broker running
- Cross-platform support (Android & Desktop)
- Local data persistence with SQLDelight
- Dark mode support

### Features
- **MQTT Broker**: Run a full MQTT broker on your Android device or desktop
- **WebSocket Support**: Enable MQTT over WebSocket for web clients
- **Authentication**: Secure your broker with username/password authentication
- **Connection Management**: Monitor connected clients in real-time
- **Configurable Settings**:
  - MQTT port configuration
  - WebSocket enable/disable
  - WebSocket port and path settings
  - Authentication enable/disable
  - Username and password management
  - Battery optimization settings
  - WakeLock settings
- **Server Logs**: View real-time broker logs
- **Background Service**: Keep broker running in the background
- **Material Design 3**: Modern, clean interface with dynamic theming

### Technical Details
- Built with Kotlin Multiplatform
- Uses Moquette 0.18.0 for MQTT broker functionality
- Jetpack Compose UI
- SQLDelight for local storage
- DataStore for preferences
- Supports Android API 26+ (Android 8.0+)
- Supports Desktop (Windows, macOS, Linux)

---

## [1.0] - Initial Release (Historical)

### Added
- Initial release of Narada MQTT Broker
- Basic MQTT broker functionality
- Simple UI controls

