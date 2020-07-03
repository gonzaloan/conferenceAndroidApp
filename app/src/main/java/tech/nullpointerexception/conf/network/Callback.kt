package tech.nullpointerexception.conf.network

interface Callback<T> {
    fun onSuccess(result: T?)

    fun onFailed(exception: Exception)
}