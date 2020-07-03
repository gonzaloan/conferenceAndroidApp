package tech.nullpointerexception.conf.view.adapter

import tech.nullpointerexception.conf.model.Conference


interface ScheduleListener {

    fun onConferenceClicked(conference: Conference, position: Int)

}