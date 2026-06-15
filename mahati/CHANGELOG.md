# Changelog - Mahati

All notable changes to the Mahati MQTT Client app will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.1] - 2026-05-31

### Added
- Full MQTT client functionality with HiveMQ client library
- Connection management with multiple broker support
- Save and manage multiple MQTT broker connections
- Topic subscription with pattern support
- Message publishing with retain flag support
- Real-time message viewing in chat-style interface
- Connection logs and activity monitoring
- QR code scanner for easy broker configuration import
- Settings screen for app preferences
- Material Design 3 modern UI with dynamic theming
- Responsive layout supporting both phone and tablet/desktop modes
- Connection validation and error handling
- Password visibility toggle for secure credential entry
- Persistent local storage using SQLDelight database
- Cross-platform support (Android and Desktop)

### Features
- **Multiple Connections**: Create and manage connections to different MQTT brokers
- **Secure Authentication**: Support for username/password authentication
- **Topic Management**: Subscribe to multiple topics per connection
- **Message History**: View incoming and outgoing messages in real-time
- **Offline Storage**: All connection details stored locally using SQLite
- **Modern UI**: Clean Material Design 3 interface with adaptive layouts

### Technical
- Built with Kotlin Multiplatform
- Jetpack Compose UI
- HiveMQ MQTT Client library
- SQLDelight for database management
- Minimum Android SDK: 26 (Android 8.0)
- Target Android SDK: 36

## [1.0] - Initial Development
- Initial development and testing
- Core MQTT functionality implementation
- Basic UI structure

---

## Version Naming Convention
- **Major.Minor** format (e.g., 1.1, 2.0)
- **Major**: Significant feature additions or breaking changes
- **Minor**: New features, improvements, and bug fixes

