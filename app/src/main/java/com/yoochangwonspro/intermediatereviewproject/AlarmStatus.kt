package com.yoochangwonspro.intermediatereviewproject

enum class AlarmStatus(val type: String, val id: Int) {
    NORMAL("기본 알림", 0),
    EXPANDABLE("확장형 알림", 1),
    CUSTOM("커스텀 알림", 2)
}