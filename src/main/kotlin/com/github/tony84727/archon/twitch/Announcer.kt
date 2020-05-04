package com.github.tony84727.archon.twitch

interface Announcer {
    fun speak(who: String, what: String)
}