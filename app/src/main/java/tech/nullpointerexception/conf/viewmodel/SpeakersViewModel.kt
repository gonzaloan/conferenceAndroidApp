package tech.nullpointerexception.conf.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import tech.nullpointerexception.conf.model.Speaker
import tech.nullpointerexception.conf.network.Callback
import tech.nullpointerexception.conf.network.FirestoreService

class SpeakersViewModel : ViewModel() {
    val firestoreService = FirestoreService()
    var listSpeakers: MutableLiveData<List<Speaker>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()


    fun refresh() {
        getSpeakersFromFirebase()
    }

    fun getSpeakersFromFirebase() {
        firestoreService.getSpeakers(object : Callback<List<Speaker>> {
            override fun onSuccess(result: List<Speaker>?) {
                listSpeakers.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    private fun processFinished() {
        isLoading.value = true
    }

}
