package tech.nullpointerexception.conf.view.adapter

import tech.nullpointerexception.conf.model.Speaker

interface SpeakerListener {
    fun onSpeakerlicked(speaker: Speaker, position: Int)
}