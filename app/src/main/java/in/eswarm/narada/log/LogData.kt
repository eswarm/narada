package `in`.eswarm.narada.log

data class LogData(val msg: String, val logType: LogType = LogType.INFO)

enum class LogType {
    INFO,
    WARNING,
    ERROR
}